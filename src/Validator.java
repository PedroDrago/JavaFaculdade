import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private static final String CPF_REGEX = "^(?!.*(\\d)\\1{10})\\d{11}$";
    private static final Pattern cpfPattern = Pattern.compile(CPF_REGEX);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false; // null check
        }
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches(); // returns true if the email matches the regex
    }

    public static boolean isValidCpf(String cpf) {
        if (cpf == null) {
            return false; // null check
        }
        Matcher matcher = cpfPattern.matcher(cpf);
        return matcher.matches(); // returns true if the cpf matches the regex
    }
}
