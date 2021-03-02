package io.wisoft.jdbc.quiz;

public class EmployeeSalary {

    private int avgSal;
    private int minSal;
    private int maxSal;
    private String rcode;

    public EmployeeSalary(String rcode, int avgSal, int minSal, int maxSal) {
        this.rcode = rcode;
        this.avgSal = avgSal;
        this.minSal = minSal;
        this.maxSal = maxSal;
    }

    public int getAvgSal() {
        return avgSal;
    }

    public void setAvgSal(int avgSal) {
        this.avgSal = avgSal;
    }

    public int getMinSal() {
        return minSal;
    }

    public void setMinSal(int minSal) {
        this.minSal = minSal;
    }

    public int getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(int maxSal) {
        this.maxSal = maxSal;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

}
