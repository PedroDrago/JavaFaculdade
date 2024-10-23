import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Password {
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    private final String hash;
    private final byte[] salt;

    public static byte[] generateSalt() throws Exception {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public Password(String password, byte[] salt) throws Exception {
        this.salt = salt;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        this.hash = Base64.getEncoder().encodeToString(hash);
    }

    public boolean authenticatePassword(String newPassword) throws Exception {
        Password newPasswordObject = new Password(newPassword, this.salt);
        return newPasswordObject.hash.equals(this.hash);
    }

    public static void main(String[] args) {
        Password passwd1;
        try{
            passwd1 = new Password("asd", generateSalt());
            System.out.println(passwd1.authenticatePassword("asd"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return hash;
    }
}