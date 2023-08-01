package CreatePassword;
/**
 *
 * @author Anav2
 */
public interface PasswordManager {
    boolean testPass();
    String CreateNewPass();
    String tooShort();
    String goodPass();
}
