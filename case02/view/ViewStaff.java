package view;

import controller.ControllerAccount;
import controller.ControllerStaff;
import model.StaffFullTime;

import java.util.Scanner;

public class ViewStaff {
    static Scanner scanner = new Scanner(System.in);

    public static int menuManagerAdmin() {
        ControllerAccount controllerAccount = new ControllerAccount();
        ControllerStaff controllerStaff = new ControllerStaff();

        while (true) {
            System.out.println("㊊ ㊋ ㊎ ㊏ ㊐ ㊑ ㊒ ㊓ ㊔ ㊕ ㊖ ㊗ ㊘ ㊜ ㊝ ㊊ ㊋ ㊎ ㊏  ㊊ ㊋ ㊎ ㊏ ㊐ ㊑ ㊒ ");
            System.out.println("                                                                         ");
            System.out.println("           WELCOME BOSS !!!                                                        ");
            System.out.println("                                                                                     ");
            System.out.println("        1. Edit Account                                                              ");
            System.out.println("        2. Delete Account                                                            ");
            System.out.println("        3. Display all Account                                                       ");
            System.out.println("        4. Display Staff                                                                  ");
            System.out.println("        5. Add staff                                                                ");
            System.out.println("        6. Search Staff                                                                           ");
            System.out.println("        7. Edit Staff                                                                           ");
            System.out.println("        8. Delete Staff                                                                           ");
            System.out.println("        9. Check staff status by name                                                                      ");
            System.out.println("        10. Chang staff working status   (fire or re-hire  )                                                                           ");
            System.out.println("        11. Calculate staff salary                                     ");
            System.out.println("        12. Calssify staff                                             ");
            System.out.println("        13.Check staff status ( still working or had quit )           ");
            System.out.println("        0. Log Out                                                    ");
            System.err.println(java.time.LocalDateTime.now());
            System.out.println("㊊ ㊋ ㊎ ㊏ ㊐ ㊑ ㊒ ㊓ ㊔ ㊕ ㊖ ㊗ ㊘ ㊜ ㊝ ㊊ ㊋ ㊎ ㊏  ㊊ ㊋ ㊎ ㊏  ㊐ ㊑ ㊒ ");
            System.out.println("input your choice: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 &&
                        choice != 6 && choice != 7 && choice != 8 && choice != 9 && choice != 10
                        && choice != 11 && choice != 12 && choice != 13) {
                    System.err.println("only type from 1 to 13:");
                    return menuManagerAdmin();
                }
            } catch (Exception e) {
                System.err.println("only number is availabe!!!");
                return menuManagerAdmin();
            }
            switch (choice) {
                case 1:
                    System.out.println("which account do you want to edit?: ");
                    int index = controllerAccount.findIndexAccount();
                    if (index > -1) {
                        controllerAccount.edit(index, controllerAccount.updateAccount());
                    } else {
                        System.err.println("try again, this account dose not exit !!!");
                    }
                    break;
                case 2:
                    controllerAccount.deleteAccount();
                    break;
                case 3:
                    controllerAccount.displayAccount();
                    break;
                case 4:
                    controllerStaff.displayStaff();
                    break;
                case 5:
                    System.out.println(" $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                    System.out.println(" $                                                   $");
                    System.out.println(" $      what kind of staff you want add?             $");
                    System.out.println(" $                                                   $");
                    System.out.println(" $          1.  Full Time staff                      $");
                    System.out.println(" $          2.  Part Time staff                      $");
                    System.out.println(" $          3. Return Memu                           $");
                    System.out.println(" $          4. Log out                               $");
                    System.out.println(" $                                                   $");
                    System.out.println(" $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                    System.out.println("INPUT YOUR CHOICE");
                    int choice1 = 0;
                    try {
                        choice1 = Integer.parseInt(scanner.nextLine());
                        if (choice1 != 1 && choice1 != 2 && choice1 != 3 && choice1 != 4) {
                            System.err.println("try again !!!");
                        }
                    } catch (Exception e) {
                        System.err.println("try again!!!");
                    }
                    switch (choice1) {
                        case 1:
                            controllerStaff.add(controllerStaff.addStaff(true));
                            break;
                        case 2:
                            controllerStaff.add(controllerStaff.addStaff(false));
                            break;
                        case 3:
                            menuManagerStaff();
                            break;
                        case 4:
                            ViewAccount.menuSignInAndSignUp();
                            break;
                    }
                    break;
                case 6:
                    controllerStaff.searchStaff();
                    break;
                case 7:
                    System.out.println("which staff you want edit? ");
                    int index1 = controllerStaff.findIndex();
                    if (index1 != -1) {
                        if (controllerStaff.findAll().get(index1) instanceof StaffFullTime) {
                            controllerStaff.edit(index1, controllerStaff.updateStaff(true, index1));
                        } else {
                            controllerStaff.edit(index1, controllerStaff.updateStaff(false, index1));
                        }
                    } else {
                        System.err.println("we do not have these staff !!!");
                    }
                    break;
                case 8:
                    controllerStaff.deleteStaff();
                    break;
                case 9:
                    controllerStaff.checkStatusbyName();
                    break;
                case 10:
                    controllerStaff.updateStatus();
                    break;
                case 11:
                    controllerStaff.payRoll();
                    break;
                case 12:
                    controllerStaff.employeeClassification();
                    break;
                case 13:
                    controllerStaff.checkStatus();
                    break;
                case 0:
                    System.out.println("GoodBye and See");
                    ViewAccount.menuSignInAndSignUp();
                    break;
            }
        }
    }

    public static int menuManagerStaff() {
        ControllerStaff controllerStaff = new ControllerStaff();

        while (true) {
            System.out.println("㊊ ㊋ ㊎ ㊏ ㊐ ㊑ ㊒ ㊓ ㊔ ㊕ ㊖ ㊗ ㊘ ㊜ ㊝ ㊊ ㊋ ㊎ ㊏ ㊐ ㊑ ㊒ ㊓ ㊔ ㊕ ㊖ ㊗ ㊘ ㊜ ㊝ ㊊ ㊋");
            System.out.println("                            STAFF'S INFORMATION                                                        ");
            System.out.println("                           1. Personal Infomation                                              ");
            System.out.println("                           2. Calculate salary                                     ");
            System.out.println("                           0. Log Out                                                    ");
            System.out.println("㊊ ㊋ ㊎ ㊏ ㊐ ㊑ ㊒ ㊓ ㊔ ㊕ ㊖ ㊗ ㊘ ㊜ ㊝ ㊊ ㊋ ㊎ ㊏ ㊐ ㊑ ㊒ ㊓ ㊔ ㊕ ㊖ ㊗ ㊘ ㊜ ㊝ ㊊ ㊋");
            System.out.println("Input your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2 && choice != 0) {
                    System.err.println("only choose0, 1 or 2, guy!!!");
                    return menuManagerStaff();
                }
            } catch (Exception e) {
                System.err.println("No chacracter, please!!!");
                return menuManagerStaff();
            }
            switch (choice) {
                case 1:
                    controllerStaff.searchStaff();
                    break;
                case 2:
                    controllerStaff.payRoll();
                    break;
                case 0:
                    System.out.println("bye");
                    ViewAccount.menuSignInAndSignUp();
                    break;
            }
        }
    }
}