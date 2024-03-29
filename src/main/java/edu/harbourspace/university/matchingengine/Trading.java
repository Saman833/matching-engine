package edu.harbourspace.university.matchingengine;

import java.util.ArrayList;

public class Trading {
    ArrayList<Trade> doTrade(ListingID listingID,Order goal){
        ArrayList<Trade> trades= new ArrayList<>();
        ArrayList<Order> orders=listingID.getOrders();
        for (Order order : orders) {
            if (order.getOriginator() == Originator.DF) {
                if (((CreateOrder) goal).getSide() == Side.BUY && ((CreateOrder) order).getSide() == Side.SELL && ((CreateOrder) order).getPrice()<=((CreateOrder) goal).getPrice()) {
                     if (((CreateOrder) goal).getQuantity()>=((CreateOrder) order).getQuantity()){
                         ((CreateOrder) goal).setQuantity(((CreateOrder) goal).getQuantity()-((CreateOrder) order).getQuantity());
                         trades.add(new Trade(Side.SELL,((CreateOrder) order).getQuantity(),((CreateOrder) goal).getPrice(),((CreateOrder) goal).getListingID()));
                         orders.remove(order);
                     }else {
                         ((CreateOrder) order).setQuantity(((CreateOrder) order).getQuantity()-((CreateOrder) goal).getQuantity());
                         trades.add(new Trade(Side.SELL,((CreateOrder) goal).getQuantity(),((CreateOrder) goal).getPrice(),((CreateOrder) goal).getListingID()));
                         break;
                     }
                } else if (((CreateOrder) goal).getSide() == Side.SELL && ((CreateOrder) order).getSide() == Side.BUY && ((CreateOrder) order).getPrice()>=((CreateOrder) goal).getPrice()){
                    if (((CreateOrder) goal).getQuantity()>=((CreateOrder) order).getQuantity()){
                        ((CreateOrder) goal).setQuantity(((CreateOrder) goal).getQuantity()-((CreateOrder) order).getQuantity());
                        trades.add(new Trade(Side.BUY,((CreateOrder) order).getQuantity(),((CreateOrder) goal).getPrice(),((CreateOrder) goal).getListingID()));
                        orders.remove(order);
                    }else {
                        ((CreateOrder) order).setQuantity(((CreateOrder) order).getQuantity()-((CreateOrder) goal).getQuantity());
                        trades.add(new Trade(Side.BUY,((CreateOrder) goal).getQuantity(),((CreateOrder) goal).getPrice(),((CreateOrder) goal).getListingID()));
                        break;
                    }
                }
            }
        }
        listingID.setOrders(orders);
        return trades;
    }

}
