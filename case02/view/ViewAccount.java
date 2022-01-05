package view;

import controller.ControllerAccount;
import model.Account;

import java.util.Scanner;

public class ViewAccount {
    public static void menuSignInAndSignUp() {
        Scanner scanner = new Scanner(System.in);
        ControllerAccount controllerAccount = new ControllerAccount();

        while (true) {
            System.out.println(" $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$");
            System.out.println(" $$           1. Login                  $$ ");
            System.out.println(" $$           2. SignUp                 $$ ");
            System.out.println(" $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$ $$");
            System.out.println("input your choice: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2) {
                    System.err.println("ONLY 1 OR 2!!!");
                    menuSignInAndSignUp();
                }
            } catch (Exception e) {
                System.err.println("TRY AGAIN!!!");
            }
            switch (choice) {
                case 1:
                    Account account = controllerAccount.signInAdmin();
                    if (controllerAccount.loginAdmin(account)) {
                        ViewStaff.menuManagerAdmin();
                        break;
                    } else if (controllerAccount.signIn(account)) {
                        ViewStaff.menuManagerStaff();
                        break;
                    } else {
                        System.err.println("your account or password incorrect, try again!!!");
                        menuSignInAndSignUp();
                    }
                case 2:
                    controllerAccount.addAccount(controllerAccount.signUpAccount());
                    System.out.println("SIGN UP SUCCESS!!!");
                    break;
            }
        }
    }
}
