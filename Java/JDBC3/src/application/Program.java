package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DB.getConnection();

            statement = connection.prepareStatement(
                    "INSERT INTO seller"
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + " VALUES "
                    //As interrogações são placeholders, onde DEPOIS serão colocados os valores
                    + "(?, ?, ?, ?, ?)");

            statement.setString(1, "Carbão Lindão");
            statement.setString(2, "carbão@gmail.com");
            statement.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            statement.setDouble(4, 3000.00);
            statement.setInt(5, 4);

            //Executa o comando SQL descrito acima (alterar dados)
            int rowsAffected = statement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        catch (ParseException exception) {
            exception.printStackTrace();
        }
        finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
