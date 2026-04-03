import java.util.Random;

public class Customer extends User {

    private String otp;

    // Constructor
    public Customer(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    // REGISTER WITH ID
    public static Customer register(String first, String last, String email) {
        if (first == null || first.trim().isEmpty() ||
            last == null || last.trim().isEmpty() ||
            email == null || !email.contains("@")) {
            System.out.println("Invalid registration details!");
            return null;
        }

        int customerId = generateId();
        Customer c = new Customer(customerId, first.trim(), last.trim(), email.trim());
        c.otp = generateOTP();

        System.out.println("Registration successful!");
        System.out.println("Your Customer ID is: " + customerId);
        System.out.println("Your OTP was sent to: " + email);
        System.out.println("OTP: " + c.otp);

        return c;
    }

    // OTP VERIFICATION
    public boolean verifyOTP(String enteredOtp) {
        if (otp != null && otp.equals(enteredOtp)) {
            System.out.println("OTP verified successfully!");
            return true;
        }
        System.out.println("Invalid OTP!");
        return false;
    }

    // FORCE PASSWORD CHANGE AFTER OTP - FIXED VERSION (No Scanner here)
    public void requestPasswordReset() {
        System.out.println("\nYou must set your initial password now.");
        // Note: We will handle the actual password input from Main.java
        // to avoid Scanner conflicts
    }

    // New helper method to set initial password (called from Main)
    public boolean setInitialPassword(String newPassword) {
        return forceChangePassword(newPassword);
    }

    // Change password anytime
    public boolean changeMyPassword(String oldPassword, String newPassword) {
        return changePassword(oldPassword, newPassword);
    }

    // Forget Password
    public static void forgetPassword(String firstName, String lastName) {
        System.out.println("A new password has been sent to the registered email for " 
                           + firstName + " " + lastName);
    }

    // Helper methods
    private static int generateId() {
        return 100000 + new Random().nextInt(900000); // 6-digit ID
    }

    private static String generateOTP() {
        return String.format("%06d", new Random().nextInt(1000000));
    }

    // Getter for ID
    public int getId() {
        return super.getId();
    }
}
