package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        //Começa com o try porque todas as operações irão acessar um recurso externo (DB) que bode gerar exceções
        try {
            connection = DB.getConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from department");

            //Percorrendo um ResultSet
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + "," + resultSet.getString("Name"));
            }

        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        //Como estamos usando recursos externos, não controlaos pela JVM do Java, devemos fechar eles manualmente para evitar que o programa possa ter algum tipo de vazamento de memória
        finally {
            DB.closeStatement(statement);
            DB.closeStatement(resultSet);
            DB.closeConnection();
        }
    }
}
