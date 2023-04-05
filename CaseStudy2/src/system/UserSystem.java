package system;

import account.User;
import iotextfile.IOTextFiles;
import manager.ProductManager;
import manager.UserManager;
import regex.Check;

import java.util.*;

import product.Alcohol;
import account.Cart;

import static manager.UserManager.indexCheck;


public class UserSystem {
    private final Check check;
    private final UserManager userManager;
    private final Scanner scanner;
    private final ProductSystem productSystem;
    private final ProductManager productManager;
    private Cart cart;
    private final IOTextFiles<Integer, String> ioTextFiles;
    private Map<Integer, String> billPrint;


    public UserSystem() {
        check = new Check();
        userManager = new UserManager();
        productSystem = new ProductSystem();
        scanner = new Scanner(System.in);
        productManager = productSystem.getProductManager();
        cart = new Cart();
        ioTextFiles = new IOTextFiles<>();
        billPrint = ioTextFiles.readFile("E:\\Case-study\\CaseStudy2\\src\\textfile\\bill.txt");
    }


    public void menuUser() {
        String str = "";
        do {
            String format = "│ %-45s │\n";
            System.out.println("┌───────────────────────────────────────────────┐");
            System.out.println("│            --o0o-- Welcome --o0o--            │");
            System.out.println("├───────────────────────────────────────────────┤");
            System.out.printf(format, "▶[1].All product.");
            System.out.printf(format, "▶[2].Search product.");
            System.out.printf(format, "▶[3].Sort product.");
            System.out.printf(format, "▶[4].Display account.");
            System.out.printf(format, "▶[5].Edit account.");
            System.out.printf(format, "▶[6].Buy product.");
            System.out.printf(format, "▶[7].Pay.");
            System.out.printf(format, "▶[8].Bill.");
            System.out.printf(format, "▶[0].Exit.");
            System.out.println("└───────────────────────────────────────────────┘");
            User users = new User();
            for (User u : userManager.getUsers()) {
                if (u.getId() == userManager.getIndexCheck()) {
                    users = u;
                    break;
                }
            }
            String choiceCheck = check.checkChoiceUser(scanner, "your choice");
            int choice = Integer.parseInt(choiceCheck);
            if (choice == 0) {
                indexCheck = -1;
                break;
            }
            switch (choice) {
                case 1:
                    productManager.display();
                    break;
                case 2:
                    productManager.searchByName(scanner);
                    break;
                case 3:
                    productManager.sortByPrice();
                    break;
                case 4:
                    userManager.displayForUser();
                    break;
                case 5:
                    userManager.upgradeForUser(scanner);
                    break;
                case 6:
                    productManager.display();
                    User user = new User();
                    int idChoice = check.checkInt(scanner, "Id");
                    int quantityChoice = check.checkInt(scanner, "Quantity");
                    int count = 0;
                    for (Alcohol al : productManager.getAlcohols()) {
                        if (al.getId() == idChoice) {
                            if (al.getQuantity() < quantityChoice) {
                                System.err.println("The number of products is not enough.");
                                count++;
                                break;
                            } else {
                                cart = new Cart(user);
                                cart.addToCart(al, quantityChoice);
                                count++;
                                System.out.println("✅Add product to cart successfully");
                                break;
                            }
                        }
                    }
                    if (count == 0) {
                        System.err.println("The id you entered is incorrect.");
                    }
                    break;
                case 7:
                    str = cart.checkOut(productSystem.getProductManager());
                    productManager.display();
                    billPrint.put(indexCheck, str);
                    ioTextFiles.writeFile((HashMap<Integer, String>) billPrint, "D:\\Case study\\CaseStudy2\\src\\textfile\\bill.txt");
                    break;
                case 8:
                    billPrint = ioTextFiles.readFile("D:\\Case study\\CaseStudy2\\src\\textfile\\bill.txt");
                    try {
                        if (billPrint.get(indexCheck).isEmpty()) {
                            System.out.println("Currently no bill");
                        } else {
                            System.out.println(billPrint.get(indexCheck));
                        }

                    } catch (Exception e) {
                        System.out.println("Currently no bill");
                    }
                    break;
            }
        }
        while (true);
    }

    public void menuAdmin() {
        do {
            String format = "│ %-45s │\n";
            System.out.println("┌───────────────────────────────────────────────┐");
            System.out.println("│            --o0o--  Admin  --o0o--            │");
            System.out.println("├───────────────────────────────────────────────┤");
            System.out.printf(format, "▶[1].Product System.");
            System.out.printf(format, "▶[2].Edit account.");
            System.out.printf(format, "▶[3].Delete account.");
            System.out.printf(format, "▶[4].Display all account.");
            System.out.printf(format, "▶[5].Display all bill.");
            System.out.printf(format, "▶[0].Exit.");
            System.out.println("└───────────────────────────────────────────────┘");
            String choiceCheck = check.checkChoiceAdmin(scanner, "your choice");
            int choice = Integer.parseInt(choiceCheck);
            if (choice == 0) {
                indexCheck = -1;
                break;
            }
            switch (choice) {
                case 1:
                    productSystem.menu();
                    break;
                case 2:
                    userManager.upgrade(scanner);
                    break;
                case 3:
                    userManager.delete(scanner);
                    break;
                case 4:
                    userManager.display();
                    break;
                case 5:

                    if (billPrint.isEmpty()) {
                        System.out.println("Currently no bill");
                    } else {
                        Set<Integer> key = billPrint.keySet();
                        Object[] arrKey = key.toArray();
                        for (int i = 0; i < arrKey.length; i++) {
                            System.out.println("Id customer: " + arrKey[i] + ", Bill{ " + billPrint.get(arrKey[i]) + "}");
                        }
                    }
            }
        } while (true);
    }

    public void menuGuest() {
        do {
            String format = "│ %-45s │\n";
            System.out.println("┌───────────────────────────────────────────────┐");
            System.out.println("│            --o0o--  Guest  --o0o--            │");
            System.out.println("├───────────────────────────────────────────────┤");
            System.out.printf(format, "▶[1].All product.");
            System.out.printf(format, "▶[2].Search product.");
            System.out.printf(format, "▶[3].Sort product.");
            System.out.printf(format, "▶[4].Sign in.");
            System.out.printf(format, "▶[5].Sign up.");
            System.out.printf(format, "▶[0].Exit.");
            System.out.println("└───────────────────────────────────────────────┘");
            String choiceCheck = check.checkChoiceGuest(scanner, "your choice");
            int choice = Integer.parseInt(choiceCheck);
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    productManager.display();
                    break;
                case 2:
                    productManager.searchByName(scanner);
                    break;
                case 3:
                    productManager.sortByPrice();
                    break;
                case 4:
                    userManager.login(scanner);
                    checkLogin();
                    break;
                case 5:
                    userManager.create(scanner);
                    break;
            }
        } while (true);
    }

    public void checkLogin() {
        if (userManager.getIndexCheck() == 0) {
            menuAdmin();
        } else {
            if (userManager.getIndexCheck() == -1) {
                menuGuest();
            } else {
                menuUser();
            }
        }
    }
}
