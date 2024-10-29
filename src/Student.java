import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Student {
    private int id;
    private String name;
    private int age;
    private String cpf;
    private String registration;
    private String email;
    private Password password;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Student(int id, String name, String age, String cpf, String email, String password, Status status) throws Exception {
        boolean success = true;
        String errorMessage = "";
        this.id = id;
        this.name = name;
        try{
            this.age = Integer.parseInt(age);
            if (this.age < 18 || this.age > 150){
                success = false;
                errorMessage += " | " + "Invalid age";
            }
        } catch(Exception e){
            success = false;
            errorMessage += " | " + "Invalid age";
        }
        this.cpf = cpf;
        if (!Validator.isValidCpf(cpf)) {
            success = false;
            errorMessage += " | " + "Invalid cpf";
        }
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);
        this.registration = formattedDate + id;
        this.email = email;
        if (!Validator.isValidEmail(email)) {
            success = false;
            errorMessage += " | " + "Invalid email";
        }
        if (!success) {
            throw new Exception(errorMessage);
        }
        this.status = status;
        this.password = new Password(password, Password.generateSalt());
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", password=" + password + age + ", cpf=" + cpf + ", registration=" + registration + ", email=" + email + ", status=" + status + "]";
    }
}
