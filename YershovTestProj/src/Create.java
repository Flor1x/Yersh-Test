
import java.io.EOFException;
import java.sql.SQLException;
import java.util.Scanner;

public class Create {

    Create() throws EOFException, SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("You selected option Add: Create database record: ");
        String date;
        System.out.println("Enter date: ");
        date = scan.next();

        int price;
        System.out.println("Enter price: ");
        price = scan.nextInt();

        String currency;
        System.out.println("Enter currency: ");
        currency = scan.next();

        String name;
        System.out.println("Enter product name: ");
        name = scan.next();

        DBUtilities dbUtilities = new DBUtilities();

        String sql_stmt = "INSERT INTO products (date,price,currency,name) VALUES ('" + date + "','" + price + "','" + currency + ";" + name  + "')";


        Main.DisplayMenu();
    }
}

