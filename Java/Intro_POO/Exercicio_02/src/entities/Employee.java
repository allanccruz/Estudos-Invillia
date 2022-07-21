package entities;

public class Employee {
    //Atributos da classe
    public String name;
    public double grossSalary;
    public double tax;

    //Métodos da classe
    public double netSalary() {
        return grossSalary - tax;
    }
    public void increaseSalary(double percentage) {
        this.grossSalary += percentage / 100 * grossSalary;
    }
    public String toString() {
        return name + ", $ " + String.format("%.2f", netSalary());
    }
}
