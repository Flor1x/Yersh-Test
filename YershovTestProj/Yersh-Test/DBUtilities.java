import java.sql.*;

public class DBUtilities  {

             String DATABASE_URL ="jdbc:mysql://localhost:3306/db";
             Connection connection = null;
             Statement statement = null;
             ResultSet resultSet = null;
             public DBUtilities() throws SQLException {

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");

        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }


    public void DisconnectFromDB() {

        try {
            resultSet.close();
            statement.close();
            connection.close();
        } // end try
        catch (Exception ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        } // end catch
    }

    public ResultSet ReadRecords(String sql_stmt) {
        try {

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql_stmt);

            return resultSet;

        }
        catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }

        return resultSet;
    }

    public void ExecuteSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();

            statement.executeUpdate(sql_stmt);
        }
        catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
}
