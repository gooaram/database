package io.wisoft.jdbc.quiz;

public class Drama {

    private String code;
    private String name;
    private String product;
    private String broadcast;

    public Drama(String name) {
        this.name = name;
    }

    public Drama(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Drama(String code, String name, String product, String broadcast) {
        this.code = code;
        this.name = name;
        this.product = product;
        this.broadcast = broadcast;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public String getBroadcast() {
        return broadcast;
    }

    @Override
    public String toString() {
        return "[코드] " + code + "\t" +
                " [이름] " + name + "\t" +
                " [제작사] " + product + "\t" +
                " [방영사] " + broadcast;
    }

}
