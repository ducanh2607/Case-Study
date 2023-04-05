package manager;

import java.util.Scanner;

public interface Manager {
    public void create(Scanner scanner);
    public void display();
    public void upgrade(Scanner scanner);
    public void delete(Scanner scanner);

}
