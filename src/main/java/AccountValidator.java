import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class AccountValidator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern DIGIT_PATTERN = Pattern.compile(".*\\d.*");
    private static final Pattern SPECIAL_PATTERN =
            Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");

    public static boolean isValidName(String value) {
        if (value == null) {
            return false;
        }
        String trimmed = value.trim();
        return !trimmed.isEmpty() && trimmed.length() >= 2 && trimmed.length() <= 50;
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    public static boolean isValidBirthDate(LocalDate birthDate) {
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            return false;
        }
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age >= 19 && age <= 120;
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return password.length() >= 8
                && UPPERCASE_PATTERN.matcher(password).matches()
                && LOWERCASE_PATTERN.matcher(password).matches()
                && DIGIT_PATTERN.matcher(password).matches()
                && SPECIAL_PATTERN.matcher(password).matches();
    }

    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }

    public static boolean isValidAccount(
            String firstName,
            String lastName,
            String email,
            LocalDate birthDate,
            String password,
            String confirmPassword) {
        return isValidName(firstName)
                && isValidName(lastName)
                && isValidEmail(email)
                && isValidBirthDate(birthDate)
                && isValidPassword(password)
                && doPasswordsMatch(password, confirmPassword);
    }
}
