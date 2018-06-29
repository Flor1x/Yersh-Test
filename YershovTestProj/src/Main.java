
import java.io.EOFException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, EOFException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        DisplayMenu();

    }

    public static void DisplayMenu() throws SQLException, EOFException {


        Scanner scan = new Scanner(System.in);
        String READ_MENU;
        System.out.println("*****************************************");
        System.out.println("|                 MENU                  |");
        System.out.println("*****************************************");
        System.out.println("| Options:                              |");
        System.out.println("|        Add. Create Database Records   |");
        System.out.println("|        List. Read Database Records    |");
        System.out.println("|        Clear. Delete Database Records |");
        System.out.println("|        EXIT                           |");
        System.out.println("*****************************************");
        System.out.print("Select option: ");
        READ_MENU = scan.next();
        switch (READ_MENU) {
            case "Add":
                Create create = new Create();
                break;
            case "List":
                Read read = new Read();
                break;
            case "Clear":
                Clear clear = new Clear();
                break;
            case "Exit":
            System.exit(0);
            break;
            default:
                System.out.println("Invalid selection");
                break;
        }
    }
}
