import java.util.Scanner;

public class Main {
    public static final int USERNAME_LENGTH = 15;
    public static final int PASSWORD_LENGTH = 8;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\tWelcome to JnU Login System\nPlease register with your Username and Password to continue.\n");
        System.out.print("Please SET a Username for yourself maximum of 15 character: ");
        String name= input.nextLine();
        String user="";
        if(is_Valid_Username(name))
        {
            System.out.println("Username is valid: " + name);
            user= name;
        } else {
            System.out.println("Not a valid Username: " + name);
            System.exit(1);
        }

        System.out.print("\n\tPlease SET a Password.\nA password must have at least 8 character, at least 1 digit and should contain both Upper case and Lower case: ");
        String pass = input.nextLine();
        String PASS="";
        if (is_Valid_Password(pass)) {
            System.out.println("Password is valid: " + pass);
            PASS= pass;
        } else {
            System.out.println("Not a valid password: " + pass);
            System.exit(1);
        }

        System.out.print("Enter 1 to Login: ");
        int option=input.nextInt();
        if(option==1) {

            int x = 3;
            while (true) {
                if (x == 0) {
                    System.out.println("You have no access to the system! Thank you!");
                    break;
                }
                Scanner take = new Scanner(System.in);
                System.out.print("Please Enter Your Username: ");
                String Username = take.nextLine();
                System.out.print("Please Enter Your Password: ");
                String Password = take.nextLine();
                if (Username.equals(user) && Password.equals(PASS)) {
                    System.out.println("\n\"Welcome to eat assured alliance network!\"");
                    break;
                } else {
                    x--;
                    System.out.println("Wrong Input. Please Try Again. You have " + x + " chance left.");
                }
            }
        }
        else
        {
            System.out.println("Wrong Input!");
        }
    }

    public static boolean is_Valid_Username(String username) {
        return username.length() <= USERNAME_LENGTH;
    }

    public static boolean is_Valid_Password(String password) {

        if (password.length() < PASSWORD_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (is_Numeric(ch)) numCount++;
            else if (is_Letter(ch)) charCount++;
            else return false;
        }
        return (charCount >= 2 && numCount >= 1);
    }

    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }
    public static boolean is_Numeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }
}



