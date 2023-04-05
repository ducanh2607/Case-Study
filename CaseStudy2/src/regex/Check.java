package regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Check {
    private Pattern pattern;

    public Check() {
    }

    public int checkInt(Scanner scanner, String target) {
        int number;
        pattern = Pattern.compile("[0-9]*");
        while (true) {
            System.out.println("Enter the " + target + ":");
            String inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & inStr != "") {
                number = Integer.parseInt(inStr);
                break;
            } else {
                System.err.println(target + " must be number, please re-enter.");
            }
        }
        return number;
    }

    public String checkString(Scanner scanner, String target) {
        String inStr;
        String str = null;
        pattern = Pattern.compile("[a-zA-z0-9]*");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + "must be word or number, please re-enter.");
            }
        }
        return str;
    }

    public double checkDouble(Scanner scanner, String target) {
        pattern = Pattern.compile("(\\-?\\d*\\.?\\d+)");
        double num;
        while (true) {
            System.out.println("Enter the " + target + ":");
            String inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & inStr != "") {
                num = Double.parseDouble(inStr);
                break;
            } else {
                System.err.println(target + " must be float or number, please re-enter.");
            }
        }
        return num;

    }

    public Long checkLong(Scanner scanner, String target) {
        pattern = Pattern.compile("^-?\\d{1,19}$");
        Long num = null;
        while (true) {
            System.out.println("Enter the " + target + ":");
            String inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & inStr != "") {
                num = Long.parseLong(inStr);
                break;
            } else {
                System.err.println(target + " must be number, please re-enter.");
            }
        }
        return num;
    }

    public String checkConfirm(Scanner scanner, String target) {
        pattern = Pattern.compile("[yn]");
        String inStr;
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & inStr != "") {
                break;
            } else {
                System.err.println(target + " must be y or n, please re-enter.");
            }
        }
        return inStr;
    }
    public String checkEmail(Scanner scanner, String target){
        String inStr;
        String str = null;
        pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + "should have format as a sample after: abc@abc.com or abc123@abc123.com, please re-enter.");
            }
        }
        return str;
    }
    public String checkPhone(Scanner scanner, String target){
        String inStr;
        String str = null;
        pattern = Pattern.compile("^(\\+84|84|0)([0-9])([0-9]{8})$");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + "should have format as a sample after: +84xxxxxxxxx or 84xxxxxxxxx or 0xxxxxxxxx, please re-enter.");
            }
        }
        return str;
    }
    public String checkChoiceUser(Scanner scanner, String target){
        String inStr;
        String str = null;
        pattern = Pattern.compile("[0-8]");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + " must between 0-8, please re-enter.");
            }
        }
        return str;
    }
    public String checkChoiceAdmin(Scanner scanner, String target){
        String inStr;
        String str = null;
        pattern = Pattern.compile("[0-5]");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + " must between 0-5, please re-enter.");
            }
        }
        return str;
    }
    public String checkChoiceGuest(Scanner scanner, String target){
        String inStr;
        String str = null;
        pattern = Pattern.compile("[0-5]");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + " must between 0-5, please re-enter.");
            }
        }
        return str;
    }
    public String checkMenu(Scanner scanner, String target){
        String inStr;
        String str = null;
        pattern = Pattern.compile("[0-3]");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + " must between 0-3, please re-enter.");
            }
        }
        return str;
    }
}
