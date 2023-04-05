package manager;

import iotextfile.IOTextFile;
import product.Alcohol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


import regex.Check;

public class ProductManager implements Manager {
    private ArrayList<Alcohol> alcohols;
    private final Check check;
    private final IOTextFile<Alcohol> ioTextFile;
    private String path = "E:\\Case-study\\CaseStudy2\\src\\textfile\\product.txt";

    public ProductManager() {
        ioTextFile = new IOTextFile<>();
        alcohols = ioTextFile.readFile(path);
        check = new Check();
    }


    public ArrayList<Alcohol> getAlcohols() {
        return alcohols;
    }

    public void setAlcohols(ArrayList<Alcohol> alcohols) {
        this.alcohols = alcohols;
    }

    @Override
    public void create(Scanner scanner) {
        String name = check.checkString(scanner, "Name");
        String brand = check.checkString(scanner, "Brand");
        double price = check.checkDouble(scanner, "Price");
        int volume = check.checkInt(scanner, "Volume");
        int quantity = check.checkInt(scanner, "Quantity");
        if (!alcohols.isEmpty()) {
            Alcohol.INDEX = alcohols.get(alcohols.size() - 1).getId();
        }
        alcohols.add(new Alcohol(name, brand, price, volume, quantity));
        ioTextFile.writeFile(alcohols, path);
    }

    @Override
    public void display() {
//        alcohols = ioTextFile.readFile("D:\\Case study\\CaseStudy2\\src\\textfile\\product.txt");
        if (alcohols.size() == 0) {
            System.out.println("There are currently no products");
        } else {
            System.out.printf("%-10s%-10s%-15s%-15s%-20s%s", "ID", "Name", "Brand", "Price", "Volume(ml)", "Quantity" + "\n");
            for (Alcohol al : alcohols) {
                System.out.printf("%-10s%-10s%-15s%-15s%-20s%s", al.getId(), al.getName(), al.getBrand(), al.getPrice(), al.getVolume(), al.getQuantity() + "\n");
            }
        }
    }
    public void searchByName(Scanner scanner) {
        int count = 0;
        if (alcohols.size() == 0) {
            System.out.println("There are currently no products");
        } else {
            String name = null;

            boolean flag = false;
            while (!flag) {
                name = check.checkString(scanner, "name of product you want search");
                flag = true;
            }
            for (Alcohol al : alcohols) {
                if (al.getName().equals(name)) {
                    count++;
                    System.out.println(al);
                }
            }
        }
        if (count == 0) {
            System.out.println("You entered wrong name.");
        }

    }


    public void sortByPrice() {
        Collections.sort(alcohols, new Comparator<Alcohol>() {
            @Override
            public int compare(Alcohol o1, Alcohol o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        display();
    }
//
    @Override
    public void delete(Scanner scanner) {
        int count;
        if (alcohols.size() == 0) {
            System.out.println("There are currently no products");
        } else {
            Long id = null;
            count = 0;
            boolean flag = false;
            while (!flag) {

                id = check.checkLong(scanner, "id of product you want delete");
                flag = true;
            }
            for (Alcohol al : alcohols) {
                if (al.getId() == id) {
                    count++;
                    System.out.println("Enter the y to delete or n to cancel.");
                    String confirm = check.checkConfirm(scanner, "Your choice");
                    if (confirm.equals("y")) {
                        alcohols.remove(al);
                        break;
                    }
                }
            }
            ioTextFile.writeFile(alcohols, path);
            if (count == 0) {
                System.out.println("You entered wrong id.");
            }
        }
    }
    @Override
    public void upgrade(Scanner scanner) {
        if (alcohols.size() == 0) {
            System.out.println("There are currently no products");
        } else {
            int count = 0;
            Long id = null;
            boolean flag = false;
            while (!flag) {

                id = check.checkLong(scanner, "id of product you want to edit");
                flag = true;
            }
            for (Alcohol al : alcohols) {
                if (al.getId() == id) {
                    count++;
                    String name = check.checkString(scanner, "Name");
                    String brand = check.checkString(scanner, "Brand");
                    double price = check.checkDouble(scanner, "Price");
                    int volume = check.checkInt(scanner, "Volume");
                    int quantity = check.checkInt(scanner, "Quantity");
                    al.setName(name);
                    al.setBrand(brand);
                    al.setPrice(price);
                    al.setVolume(volume);
                    al.setQuantity(quantity);
                    break;
                }
            }
            ioTextFile.writeFile(alcohols, path);
            if (count == 0) {
                System.out.println("You entered wrong id.");
                display();
            }
        }
    }
}
