package application;

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        Employee employee;
        employee = new Employee();

        //Entrada, processamento e saída de dados
        System.out.println("Name: ");
        employee.name = sc.nextLine();

        System.out.println("Gross salary: ");
        employee.grossSalary = sc.nextDouble();

        System.out.println("Tax: ");
        employee.tax = sc.nextDouble();
        System.out.println();

        //System.out.printf("Employee: %s, $ %.2f\n", employee.name, employee.netSalary());
        System.out.println("Employee: " + employee);
        System.out.println();

        System.out.println("Which percentage to increase salary?");
        double percentage = sc.nextDouble();
        employee.increaseSalary(percentage);
        System.out.println();

        //System.out.printf("Updated data: %s, $ %.2f\n", employee.name, employee.netSalary());
        System.out.println("Updated data: " + employee);

        sc.close();
    }
}