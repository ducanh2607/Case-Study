package model;

import java.time.LocalDate;

public class WalletManagement {
    private Long id;
    private LocalDate date;
    private boolean type;
    //    false is income, true is spending
    private Double money;
    private String notes;
    private User user;
    private Category category;



    public WalletManagement(LocalDate date, boolean type, Double money, String notes, Category category) {

        this.date = date;
        this.type = type;
        this.money = money;
        this.notes = notes;
        this.category = category;
    }

    public WalletManagement() {

    }

    public WalletManagement(Long id, LocalDate date, boolean type, Double money, String notes, Category category, User user) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.money = money;
        this.notes = notes;
        this.user = user;
        this.category = category;
    }

    public WalletManagement(LocalDate date, Boolean type, Double money, String notes, Category category, User user) {
        this.date = date;
        this.type = type;
        this.money = money;
        this.notes = notes;
        this.category = category;
        this.user = user;
    }





    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
