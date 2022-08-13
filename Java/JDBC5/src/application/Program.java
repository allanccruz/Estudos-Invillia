package application;

import db.DB;
import db.DbIntegrityException;

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
                    "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?");

            statement.setInt(1, 2);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Done! Rows affected " + rowsAffected);
        }
        catch (SQLException exception) {
            throw new DbIntegrityException(exception.getMessage());
        }
        finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
