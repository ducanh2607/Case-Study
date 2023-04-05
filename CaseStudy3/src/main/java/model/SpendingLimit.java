package model;

import java.sql.Date;
import java.time.LocalDate;

public class SpendingLimit {

    private User user;
    private Long id;
    private LocalDate dateCreate;
    private LocalDate dateActive;
    private Double money;
    public SpendingLimit(){
    }

    public SpendingLimit(Long id, LocalDate dateCreate, LocalDate dateActive, Double money) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.dateActive = dateActive;
        this.money = money;
    }

    public SpendingLimit(User user, Long id, LocalDate dateCreate, LocalDate dateActive, Double money) {
        this.user = user;
        this.id = id;
        this.dateCreate = dateCreate;
        this.dateActive = dateActive;
        this.money = money;
    }

    public SpendingLimit(User user, LocalDate dateCreate, LocalDate dateActive, Double money) {
        this.user = user;
        this.dateCreate = dateCreate;
        this.dateActive = dateActive;
        this.money = money;
    }

    public SpendingLimit(User userById) {

    }

    public SpendingLimit(LocalDate dateCreate, LocalDate dateActive, Double money) {
        this.dateCreate = dateCreate;
        this.dateActive = dateActive;
        this.money = money;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDate getDateActive() {
        return dateActive;
    }

    public void setDateActive(LocalDate dateActive) {
        this.dateActive = dateActive;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
