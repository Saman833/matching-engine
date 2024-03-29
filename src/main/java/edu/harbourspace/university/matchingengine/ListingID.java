package edu.harbourspace.university.matchingengine;

import java.util.ArrayList;
import java.util.*;


public class ListingID {
    private String name;
    private ArrayList<Order> orders = new ArrayList<>();
    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    public void addAnOrder(Order order){
        this.orders.add(order);
    }
    public void removeAnOrder(Order order){
        this.orders.remove(order);
    }
    public void setName(String name) {
        this.name = name;
    }




}
