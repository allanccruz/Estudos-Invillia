package application;

import db.DB;
import db.DbException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DB.getConnection();
            statement = connection.createStatement();

            //Protegendo os blocos de execução com uma transação (ou executa tudo ou não executa nada)
            connection.setAutoCommit(false);

            int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            //Simulando uma falha no meio da transação
            int x = 1;
            if (x < 2){
                throw new SQLException("Fake error");
            }

            int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            connection.commit(); //Commita as alterações no banco de dados

            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);

        }
        catch (SQLException exception) {
            //Caso aconteça um erro no meio da transação, desfaz as alterações
            try {
                connection.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + exception.getMessage());
            }
            catch (SQLException exception1) {
                throw new DbException("Error trying to rollback! Caused by: " + exception1.getMessage());
            }
        }
        finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
