package manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import account.User;
import iotextfile.IOTextFile;
import regex.Check;
import system.UserSystem;

public class UserManager implements Manager, Serializable {
    public static int indexCheck = -1;
    private ArrayList<User> users;
    private final User ADMIN;
    private final String path = "E:\\Case-study\\CaseStudy2\\src\\textfile\\user.txt";
    private final Check check;
    private final IOTextFile<User> ioFiles;
    public UserManager() {
        ADMIN = new User("admin", "admin");
        this.ioFiles = new IOTextFile<>();
        this.ADMIN.setRole("ADMIN");
        users = ioFiles.readFile(path);
        if (users.isEmpty()) {
            users.add(ADMIN);
        }
        check = new Check();
        User.NUMBER = users.get(users.size() - 1).getId();
        ioFiles.writeFile(users, path);
    }

    public int getIndexCheck() {
        return indexCheck;
    }

    @Override
    public void create(Scanner scanner) {
        boolean flag = true;
        String userName = "";
        while (flag) {
            int count = 0;
            String userNameCheck = check.checkString(scanner, "Username");
            for (User u : users) {
                if (u.getUserName().equals(userNameCheck)) {
                    System.err.println("Username already exists.");
                } else {
                    count++;
                    if (count == users.size()) {
                        userName = userNameCheck;
                        flag = false;
                    }
                }
            }
        }
        String password = check.checkString(scanner, "Password");
        User user = new User(userName, password);
        users.add(user);
        ioFiles.writeFile(users, path);
        System.out.println("✅Sign up successfully.");
    }
    @Override
    public void display() {
        users = ioFiles.readFile(path);
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%s", "ID", "Username", "Password", "Name", "Email", "Phone", "Role" + "\n");
        for (User u : users) {
            System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%s", u.getId(), u.getUserName(), u.getPassword(), u.getName(), u.getEmail(), u.getPhone(), u.getRole() + "\n");
        }
    }
    public void displayForUser() {
        users = ioFiles.readFile(path);
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%s", "ID", "Username", "Password", "Name", "Email", "Phone", "Role" + "\n");
        for (int i = 0; i < users.size(); i++) {
            if (i == indexCheck) {
                System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%s", users.get(i).getId(), users.get(i).getUserName(), users.get(i).getPassword(), users.get(i).getName(), users.get(i).getEmail(), users.get(i).getPhone(), users.get(i).getRole() + "\n");
            }
        }
    }
    @Override
    public void upgrade(Scanner scanner) {
        display();
        String userNameCheck = check.checkString(scanner, "username");
        for (User u : users) {
            if (u.getUserName().equals(userNameCheck)) {
                String passwordCheck = check.checkString(scanner, "password");
                u.setPassword(passwordCheck);
            }
        }
        ioFiles.writeFile(users, path);
    }
    public void upgradeForUser(Scanner scanner) {
        displayForUser();
        for (int i = 0; i < users.size(); i++) {
            if (i == indexCheck) {
                String nameCheck = check.checkString(scanner, "name");
                users.get(i).setName(nameCheck);
                String passwordCheck = check.checkString(scanner, "password");
                users.get(i).setPassword(passwordCheck);
                String emailCheck = check.checkEmail(scanner, "Email");
                users.get(i).setEmail(emailCheck);
                String phoneCheck = check.checkPhone(scanner, "Phone");
                users.get(i).setPhone(phoneCheck);
                System.out.println("✅Upgrade successfully");
                break;
            }
        }
        ioFiles.writeFile(users, path);
    }
    @Override
    public void delete(Scanner scanner) {
        display();
        int count = 0;
        String userNameCheck = check.checkString(scanner, "username");
        for (User u : users) {
            if (u.getUserName().equals(userNameCheck)) {
                count++;
                String confirm = check.checkConfirm(scanner, "Your choice");
                if (confirm.equals("y")) {
                    users.remove(u);

                    break;
                } else {
                    break;
                }
            }
        }
        if (count == 0) {
            System.out.println("Username incorrect.");
        }
        ioFiles.writeFile(users, path);
    }
    public ArrayList<User> getUsers() {return users;
    }
    public void login(Scanner scanner) {
//        users = ioFiles.readFile(path);
        for (int i = 0; i < 5; i++) {
            String userNameCheck = check.checkString(scanner, "Username");
            String passwordCheck = check.checkString(scanner, "Password");
            for (int j = 0; j < users.size(); j++) {
                if (users.get(j).getUserName().equals(userNameCheck) && users.get(j).getPassword().equals(passwordCheck)) {
                    indexCheck = j;
                    System.out.println("✅Login successfully.");
                    break;
                }
            }
            if (indexCheck != -1) {
                break;
            }
            System.out.println("Username or password incorrect? You have " + (5 - i - 1) + " chances left to enter");
        }
    }
}
