package model;

public class Category {
    private Long id;
    private String name;
    private Boolean type;
    public Category() {

    }
    public Category(Long id, String name, Boolean type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Category(String name, Boolean type) {
        this.name = name;
        this.type = type;
    }

    public Category(Boolean type,String name) {
        this.type = type;
        this.name = name;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}