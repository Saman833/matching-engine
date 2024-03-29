package edu.harbourspace.university.matchingengine;

import java.util.ArrayList;

public class CheckTradePossible {
    boolean checkOrders(ArrayList<Order> orders , Order goal) {
        long number = 0;
        for (Order order : orders) {
            if (order.getOriginator() == Originator.DF) {
                if (((CreateOrder) goal).getSide() == Side.BUY && ((CreateOrder) order).getSide() == Side.SELL && ((CreateOrder) order).getPrice()<=((CreateOrder) goal).getPrice()) {
                   number+= ((CreateOrder) order).getQuantity();
                } else if (((CreateOrder) goal).getSide() == Side.SELL && ((CreateOrder) order).getSide() == Side.BUY && ((CreateOrder) order).getPrice()>=((CreateOrder) goal).getPrice()){
                    number+= ((CreateOrder) order).getQuantity();
                }
            }
        }
        if (number>= ((CreateOrder) goal).getQuantity()) return true;
        return false;
    }
}
