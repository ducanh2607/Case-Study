package system;

import manager.ProductManager;
import regex.Check;

import java.util.Scanner;

public class ProductSystem {
    private final Check check;
    private final ProductManager productManager;
    private final Scanner scanner;

    public ProductSystem() {
        check = new Check();
        productManager = new ProductManager();
        scanner = new Scanner(System.in);
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void menu() {
        do {
            String format = "│ %-45s │\n";
            System.out.println("┌───────────────────────────────────────────────┐");
            System.out.println("│            --o0o--  Product  --o0o--          │");
            System.out.println("├───────────────────────────────────────────────┤");
            System.out.printf(format, "▶[1].All product.");
            System.out.printf(format, "▶[2].Search product.");
            System.out.printf(format, "▶[3].Delete product.");
            System.out.printf(format, "▶[4].Upgrade product.");
            System.out.printf(format, "▶[5].Sort.");
            System.out.printf(format, "▶[6].Add product.");
            System.out.printf(format, "▶[7].Funny thing.");
            System.out.printf(format, "▶[8].Funny thing.");
            System.out.printf(format, "▶[0].Exit.");
            System.out.println("└───────────────────────────────────────────────┘");
            String choiceCheck = check.checkChoiceUser(scanner, "your choice");
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
                    productManager.delete(scanner);
                    break;
                case 4:
                    productManager.upgrade(scanner);
                    break;
                case 5:
                    productManager.sortByPrice();
                    break;
                case 6:
                    productManager.create(scanner);
                    break;
                case 7:
                case 8:
                    System.out.println("You are drunk, take a break");
                    break;
            }
        } while (true);
    }
}
