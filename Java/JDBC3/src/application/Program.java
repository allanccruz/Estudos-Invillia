package application;

import db.DB;

import java.sql.*;
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
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            //Atribuindo os valores aos "?"
            statement.setString(1, "Carbão Lindão");
            statement.setString(2, "carbão@gmail.com");
            statement.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            statement.setDouble(4, 3000.00);
            statement.setInt(5, 4);

            //Executa o comando SQL descrito acima (alterar dados)
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            }
            else {
                System.out.println("No Rows affected!");
            }
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
