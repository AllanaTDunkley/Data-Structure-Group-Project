import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer currentCustomer = null;

        System.out.println("Welcome to BrandEx User Management System\n");
      

        while (true) {
            printMainMenu();

            String input = sc.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1: // Register Customer
                    System.out.println("\n Customer Registration");
                    System.out.print("\n Enter First Name : ");
                    String first = sc.nextLine().trim();
                    System.out.print("\n Enter Last Name  : ");
                    String last = sc.nextLine().trim();
                    System.out.print("\n Enter Email      : ");
                    String email = sc.nextLine().trim();

                    currentCustomer = Customer.register(first, last, email);

                    if (currentCustomer != null) {
                        System.out.print("\nEnter OTP: ");
                        String otp = sc.nextLine().trim();

                        if (currentCustomer.verifyOTP(otp)) {
                            setInitialPassword(currentCustomer, sc);
                        }
                    }
                    break;

                case 2: // Customer Login
                    if (currentCustomer == null) {
                        System.out.println("No customer registered yet. Please register first.\n");
                        break;
                    }
                    
                    System.out.println("\n Customer Login");
                    System.out.print("Enter Email    : ");
                    String loginEmail = sc.nextLine().trim();
                    System.out.print("Enter Password : ");
                    String password = sc.nextLine().trim();

                    if (currentCustomer.login(password)) {
                        customerMenu(currentCustomer, sc);
                    }
                    break;

                case 3: // Admin Login
                    System.out.println("\n--- Admin Login ---");
                    System.out.print("Enter Username : ");
                    String adminUser = sc.nextLine().trim();
                    System.out.print("Enter Password : ");
                    String adminPass = sc.nextLine().trim();

                    if (adminUser.equals("root") && adminPass.equals("admin")) {
                        System.out.println("Admin login successful!\n");
                        adminMenu(sc);
                    } else {
                        System.out.println("Invalid admin credentials!\n");
                    }
                    break;

                case 4: // Forget Password
                    System.out.println("\n--- Forget Password ---");
                    System.out.print("Enter First Name : ");
                    String f = sc.nextLine().trim();
                    System.out.print("Enter Last Name  : ");
                    String l = sc.nextLine().trim();
                    Customer.forgetPassword(f, l);
                    break;

                case 5:
                    System.out.println("Thank you for using BrandEx!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose 1 to 5.\n");
            }
        }
    }

    

    private static void printMainMenu() {
        System.out.println("1. Customer Registration");
        System.out.println("2. Customer Login");
        System.out.println("3. Admin Login");
        System.out.println("4. Forget Password");
        System.out.println("5. Exit");
        System.out.print("Choose option: ");
    }

    // Set initial password after OTP
    private static void setInitialPassword(Customer customer, Scanner sc) {
        System.out.println("\nYou must set your initial password now.");
        while (true) {
            System.out.print("Enter new password: ");
            String newPass = sc.nextLine().trim();

            if (customer.forceChangePassword(newPass)) {
                break;
            }
        }
    }

    // Customer Menu after successful login
    private static void customerMenu(Customer customer, Scanner sc) {
        while (true) {
            System.out.println("\nCustomer Menu ");
            System.out.println("1. Change My Password");
            System.out.println("2. Back to Main Menu");
            System.out.print("Choose: ");

            String choiceStr = sc.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter Old Password : ");
                String oldPass = sc.nextLine().trim();
                System.out.print("Enter New Password : ");
                String newPass = sc.nextLine().trim();

                customer.changeMyPassword(oldPass, newPass);
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    // Admin Menu
    private static void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\n Admin Menu ");
            System.out.println("1. Change Customer Password by ID");
            System.out.println("2. Add Products");
            System.out.println("3. Remove Products");
            System.out.println("4. Update Products");
            System.out.println("5. Process Next Order");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose: ");

            String choiceStr = sc.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter Customer ID   : ");
                String custId = sc.nextLine().trim();
                System.out.print("Enter New Password  : ");
                String newPass = sc.nextLine().trim();

                Admin admin = new Admin();
                admin.changeCustomerPassword(custId, newPass);
            } 
            else if (choice == 2) {
                break;
            } 
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
