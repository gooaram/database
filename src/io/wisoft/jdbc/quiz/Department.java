package io.wisoft.jdbc.quiz;

public class Department {

    private String code;
    private String name;
    private String location;

    public Department() {
    }

    public Department(String code, String name, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "[부서코드] " + code + "\t " +
                " [부서이름] " + name + "\t" +
                " [부서위치] " + location + '\n' ;
    }
}
