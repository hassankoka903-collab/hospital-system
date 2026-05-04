import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1.Login as Doctor");
            System.out.println("2.Login as Admin");
            System.out.println("3.Login as Patient");
            System.out.println("4.Exit..");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 4) {
                System.out.println(" Bye ! ");
                break;
            }else if (choice >= 1&&choice <= 3) {
                System.out.println("Please enter your Username: ");
                String username = input.nextLine();
                System.out.println("Please enter your Password: ");
                String password = input.nextLine();

                User user = system.login(username, password);
                if (user == null) {
                    System.out.println("Invalid username or password !");

                } else {
                    System.out.println(" Welcome,You are logged in as " + user.getUsername());
                    system.redirectMenu(user, input);
                }
            }else {
                System.out.println("Invalid choice !");
            }
        }
        input.close();
    }
}