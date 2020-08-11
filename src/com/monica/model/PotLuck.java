package com.monica.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class PotLuck {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty food;
    private SimpleStringProperty confirmed;
    private SimpleStringProperty date;

    public PotLuck(){
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.food = new SimpleStringProperty();
        this.confirmed = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getFood() {
        return food.get();
    }

    public SimpleStringProperty foodProperty() {
        return food;
    }

    public void setFood(String food) {
        this.food.set(food);
    }

    public String getConfirmed() {
        return confirmed.get();
    }

    public SimpleStringProperty confirmedProperty() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed.set(confirmed);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
