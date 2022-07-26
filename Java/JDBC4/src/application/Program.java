package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DB.getConnection();

            statement = connection.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE"
                    + "(DepartmentId = ?)");

            statement.setDouble(1, 200.00);
            statement.setInt(2, 2);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Done! Rows affected " + rowsAffected);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
