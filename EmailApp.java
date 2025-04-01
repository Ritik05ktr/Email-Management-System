import java.util.Scanner;

class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int mailboxCapacity = 500; // Default mailbox capacity in MB
    private String alternateEmail;
    private String companySuffix = "company.com"; // Company domain name

    // Constructor to initialize first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Generate a random password
        this.password = generateRandomPassword(8);

        // Generate email
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + companySuffix;

        System.out.println("Email created: " + this.email);
        System.out.println("Your default password is: " + this.password);
    }

    // Method to generate a random password
    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Method to set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
        System.out.println("Mailbox capacity set to: " + this.mailboxCapacity + "MB");
    }

    // Method to set an alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
        System.out.println("Alternate email set to: " + this.alternateEmail);
    }

    // Method to change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password successfully changed.");
    }

    // Method to display email details
    public void showInfo() {
        System.out.println("\nUser Information:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Company Email: " + email);
        System.out.println("Mailbox Capacity: " + mailboxCapacity + "MB");
        System.out.println("Alternate Email: " + (alternateEmail != null ? alternateEmail : "Not Set"));
    }
}

// Main class
public class EmailApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for first and last name
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        // Create an Email object
        Email email = new Email(firstName, lastName);

        while (true) {
            System.out.println("\nEmail Management System:");
            System.out.println("1. Show Info");
            System.out.println("2. Set Mailbox Capacity");
            System.out.println("3. Set Alternate Email");
            System.out.println("4. Change Password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    email.showInfo();
                    break;
                case 2:
                    System.out.print("Enter new mailbox capacity (MB): ");
                    int capacity = scanner.nextInt();
                    email.setMailboxCapacity(capacity);
                    break;
                case 3:
                    System.out.print("Enter alternate email: ");
                    String altEmail = scanner.nextLine();
                    email.setAlternateEmail(altEmail);
                    break;
                case 4:
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    email.changePassword(newPassword);
                    break;
                case 5:
                    System.out.println("Thank you for using the Email Management System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
