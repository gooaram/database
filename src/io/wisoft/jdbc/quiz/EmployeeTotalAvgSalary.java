package io.wisoft.jdbc.quiz;

public class EmployeeTotalAvgSalary {

    private int total;
    private double average;

    public EmployeeTotalAvgSalary(int total, double average) {
        this.total = total;
        this.average = average;
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "EmployeeTotalAvgSalary{" +
                "total=" + total +
                ", average=" + average +
                '}';
    }

}
