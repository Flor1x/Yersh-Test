import java.io.EOFException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Read {

    public Read() throws SQLException, EOFException {
        System.out.println("You selected option List: Read database record");
        DisplayResults();
    }

    private void DisplayResults() throws SQLException, EOFException {
        try {
            DBUtilities dbUtilities = new DBUtilities();

            String sql_stmt = "SELECT date, price, currency, name FROM products";
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
            System.out.println("The following error has occur: " + ex.getMessage());
        } finally {
            Main.DisplayMenu();
        }
    }
}