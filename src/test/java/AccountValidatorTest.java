import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountValidatorTest {
    private String validPassword;
    private String validEmail;

    @BeforeEach
    void setUp() {
        validPassword = "Aa123456!";
        validEmail = "seyma.yilmaz@example.com";
    }

    @AfterEach
    void tearDown() {
        validPassword = null;
        validEmail = null;
    }

    @Test
    void validNameAtLowerBoundary() {
        assertTrue(AccountValidator.isValidName("Al"));
    }

    @Test
    void invalidNameTooShort() {
        assertFalse(AccountValidator.isValidName("A"));
    }

    @Test
    void invalidNameBlank() {
        assertFalse(AccountValidator.isValidName("   "));
    }

    @Test
    void validEmailStandardFormat() {
        assertTrue(AccountValidator.isValidEmail("test.user@example.com"));
    }

    @Test
    void invalidEmailMissingAtSign() {
        assertFalse(AccountValidator.isValidEmail("test.example.com"));
    }

    @Test
    void invalidEmailMissingDomainSuffix() {
        assertFalse(AccountValidator.isValidEmail("test@domain"));
    }

    @Test
    void validBirthDateAtAge18Boundary() {
        assertTrue(AccountValidator.isValidBirthDate(LocalDate.now().minusYears(18)));
    }

    @Test
    void invalidBirthDateUnder18() {
        assertFalse(AccountValidator.isValidBirthDate(LocalDate.now().minusYears(17)));
    }

    @Test
    void validBirthDateAtAge120Boundary() {
        assertTrue(AccountValidator.isValidBirthDate(LocalDate.now().minusYears(120)));
    }

    @Test
    void invalidBirthDateOver120() {
        assertFalse(AccountValidator.isValidBirthDate(LocalDate.now().minusYears(121)));
    }

    @Test
    void invalidBirthDateInFuture() {
        assertFalse(AccountValidator.isValidBirthDate(LocalDate.now().plusDays(1)));
    }

    @Test
    void validPasswordAllRulesSatisfied() {
        assertTrue(AccountValidator.isValidPassword(validPassword));
    }

    @Test
    void invalidPasswordTooShort() {
        assertFalse(AccountValidator.isValidPassword("Aa1!a"));
    }

    @Test
    void invalidPasswordWithoutUppercase() {
        assertFalse(AccountValidator.isValidPassword("aa123456!"));
    }

    @Test
    void invalidPasswordWithoutLowercase() {
        assertFalse(AccountValidator.isValidPassword("AA123456!"));
    }

    @Test
    void invalidPasswordWithoutDigit() {
        assertFalse(AccountValidator.isValidPassword("Aaaaaaaa!"));
    }

    @Test
    void invalidPasswordWithoutSpecialCharacter() {
        assertFalse(AccountValidator.isValidPassword("Aa1234567"));
    }

    @Test
    void passwordsMatch() {
        assertTrue(AccountValidator.doPasswordsMatch(validPassword, validPassword));
    }

    @Test
    void passwordsDoNotMatch() {
        assertFalse(AccountValidator.doPasswordsMatch(validPassword, "Aa123456@"));
    }

    @Test
    void fullAccountValid() {
        assertTrue(
                AccountValidator.isValidAccount(
                        "Seyma",
                        "Yilmaz",
                        validEmail,
                        LocalDate.now().minusYears(22),
                        validPassword,
                        validPassword));
    }

    @Test
    void fullAccountInvalidWhenAnyFieldFails() {
        assertFalse(
                AccountValidator.isValidAccount(
                        "S",
                        "Yilmaz",
                        validEmail,
                        LocalDate.now().minusYears(22),
                        validPassword,
                        validPassword));
    }
}
