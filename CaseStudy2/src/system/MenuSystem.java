package system;

import manager.UserManager;
import regex.Check;
import java.util.Scanner;

public class MenuSystem {
    private final Check check;
    private final UserSystem userSystem;
    private final UserManager userManager;
    private final Scanner scanner;
    public MenuSystem(){
        scanner = new Scanner(System.in);
        userSystem = new UserSystem();
        userManager = new UserManager();
        check = new Check();
    }
    public void menu() {
        do {
            String format = "│ %-45s │\n";
            System.out.println("┌───────────────────────────────────────────────┐");
            System.out.println("│            --o0o-- Alcohol --o0o--            │");
            System.out.println("├───────────────────────────────────────────────┤");
            System.out.printf(format, "▶[1]. Guest Page.");
            System.out.printf(format, "▶[2]. Sign In.");
            System.out.printf(format, "▶[3]. Sign Up.");
            System.out.printf(format, "▶[0]. Exit.");
            System.out.println("└───────────────────────────────────────────────┘");
            String choiceCheck = check.checkMenu(scanner, "your choice");
            int choice = Integer.parseInt(choiceCheck);
            switch (choice){
                case 1:
                    userSystem.menuGuest();
                    break;
                case 2:
                    userManager.login(scanner);
                    userSystem.checkLogin();
                    break;
                case 3:
                    userManager.create(scanner);
                    break;
                case 0:
                    System.exit(0);
            }

        } while (true);

    }

    public static void main(String[] args) {
        MenuSystem menuSystem = new MenuSystem();
        menuSystem.menu();
    }
}
