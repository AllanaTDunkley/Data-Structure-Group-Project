import java.util.ArrayList;
import java.util.List;

public abstract class User {

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String passwordHash;
    protected List<String> passwordHistory; // Stores last 2 password hashes
    protected boolean isFirstLogin; // used to force the user to change password after OTP.

    // Parameter Constructor 
    public User(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = (firstName != null) ? firstName.trim() : "";
        this.lastName = (lastName != null) ? lastName.trim() : "";
        this.email = (email != null && email.contains("@")) ? email.trim() : "";
        this.passwordHistory = new ArrayList<>();
        this.isFirstLogin = true;  //user is forced to change password on first login.
        this.passwordHash = null;           // Password set after OTP
    }

    // Simple Hashing Method
    protected String simpleHash(String password) {
        if (password == null || password.trim().isEmpty()) {
            return "empty";
        }
        int hash = 0;  //calculate the final hash value
        for (char c : password.toCharArray()) {     //converts the password string into an array of individual characters.
            hash = hash * 7 + c; //multiplies the current hash value by 7 and adds the ASCII value of the current character to it.
        }
        return String.valueOf(Math.abs(hash)); 
    }

    // Set Password with History Check
    protected void setPassword(String newPassword) {
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }

        String hashed = simpleHash(newPassword); // new hashed password

        if (passwordHistory.contains(hashed)) { 
            throw new IllegalArgumentException("You cannot reuse your last 2 passwords!");
        }

        if (passwordHash != null) {
            passwordHistory.add(passwordHash);
        }
        if (passwordHistory.size() > 2) {
            passwordHistory.remove(0);
        }

        this.passwordHash = hashed;
        this.isFirstLogin = false;
    }

    // Login Method
    public boolean login(String password) {
        if (passwordHash == null) {
            System.out.println("Account has no password set yet. Please complete registration.");
            return false;
        }

        if (simpleHash(password).equals(passwordHash)) {
            System.out.println("Login successful! Welcome, " + firstName + " " + lastName);
            if (isFirstLogin) {
                System.out.println("First login detected. You must change your password immediately.");
            }
            return true;
        } else {
            System.out.println("Incorrect password!");
            return false;
        }
    }

    // Change Password (requires old password)
    public boolean changePassword(String oldPwd, String newPwd) {
        if (passwordHash == null) {
            System.out.println("Error: No password set yet.");
            return false;
        }
        if (!simpleHash(oldPwd).equals(passwordHash)) {
            System.out.println("Error: Incorrect old password!");
            return false;
        }

        try {
            setPassword(newPwd);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    // Force Change Password (used after OTP)
    public boolean forceChangePassword(String newPwd) {
        try {
            setPassword(newPwd);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    // Update Profile
    public void updateProfile(String first, String last, String email) {
        if (first != null && !first.trim().isEmpty()) {
            this.firstName = first.trim();
        }
        if (last != null && !last.trim().isEmpty()) {
            this.lastName = last.trim();
        }
        if (email != null && email.contains("@")) {
            this.email = email.trim();
        }
        System.out.println("Profile updated successfully!");
    }

    // Forget Password 
    public static void forgetPassword(String firstName, String lastName) {
        System.out.println("A new password has been sent to the registered email for " 
                           + firstName + " " + lastName);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isFirstLogin() {
        return isFirstLogin;
    }

    protected void setFirstLogin(boolean isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }
}
