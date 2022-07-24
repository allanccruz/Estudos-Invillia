package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Employee> listOfEmployees = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Employee #" + (i+1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(listOfEmployees, id) ) {
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            //Adicionar um objeto a lista:
            listOfEmployees.add(new Employee(id, name, salary));
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        //Procurar um objeto da lista por um de seus atributos:
        Employee employee = listOfEmployees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (employee == null) {
            System.out.println("This Id does not exist!");
        } else {
            System.out.print("Enter the increase percentage: ");
            double percentage = sc.nextDouble();
            employee.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee emp : listOfEmployees) {
            System.out.println(emp);
        }

        sc.close();
    }

    //Função auxiliar pra não deixar que existam dois funcionários com o mesmo id:
    public static boolean hasId(List<Employee> listOfEmployees, int id) {
        Employee employee = listOfEmployees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return employee != null;
    }
}
