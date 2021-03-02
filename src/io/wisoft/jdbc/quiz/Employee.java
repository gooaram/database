package io.wisoft.jdbc.quiz;

public class Employee {

    private String code;
    private String name;
    private String manager;
    private int salary;

    public Employee() {}

    public Employee(String name, String manager) {
        this.name = name;
        this.manager = manager;
    }

    public Employee(String code, String name, String manager, int salary){
        this.code = code;
        this.name = name;
        this.manager = manager;
        this.salary = salary;
    }

    public Employee (String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "[코드] " + code + "\t" +
                " [이름] " + name + "\t" +
                " [관리자] " + manager + "\t" +
                " [급여] " + salary + "\n" ;
    }


}
