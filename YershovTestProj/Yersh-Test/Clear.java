import java.io.EOFException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Clear {

    Clear() throws SQLException, EOFException {
        Scanner scan = new Scanner(System.in);
        System.out.println("You selected option Clear: Delete database record: ");

        String date;
        System.out.println("Enter date to delete: ");
        date = scan.next();


        DisplayRecord(date);

        String confirm_delete;
        System.out.println("Enter Y to confirm deletion: ");
        confirm_delete = scan.next();

        if ("Y".equals(confirm_delete)) {
            DBUtilities dbUtilities = new DBUtilities();

            String sql_stmt = "DELETE FROM products WHERE date = " + date;

            dbUtilities.ExecuteSQLStatement(sql_stmt);

            System.out.println("The Record has successfully being deleted");
        }

        Main.DisplayMenu();
    }

    private void DisplayRecord(String date) throws SQLException, EOFException {
        try {
            DBUtilities dbUtilities = new DBUtilities();

            String sql_stmt = "SELECT date, price, currency, name FROM products WHERE date = " + date;
            ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt);


            if (resultSet.next()) {

                ResultSetMetaData metaData = resultSet.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                System.out.print("Database Records Listing");

                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8st", metaData.getColumnName(i));
                }
                System.out.println();

                do {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        System.out.printf("%-8st", resultSet.getObject(i));
                    }
                    System.out.println();
                } while (resultSet.next());

                System.out.println();

            } else {
                System.out.println("No database records found");
            }


            dbUtilities.DisconnectFromDB();
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
            Main.DisplayMenu();
        }
    }
}