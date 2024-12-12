
//GroceryItem.java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gopeznicolecrudsystem;

/**
 *
 * @author Administrator
 */
//    07 Handout 1  ABSTRACT CLASSES
abstract class NameSet {
    public abstract void setName(String name);
}

class GroceryItem extends NameSet{
    private int id;
    private String name;
    private double price;

    //    03 Handout 1  parameters, method signature
    //    04 Handout 1  CONSTRUCTORS
    public GroceryItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    //    005 Handout 1 ENCAPSULATION
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}
