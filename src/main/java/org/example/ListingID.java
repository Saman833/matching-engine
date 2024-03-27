package org.example;

import java.util.ArrayList;
import java.util.*;


public class ListingID {
    private String name;
    private ArrayList<Order> buyOrders = new ArrayList<>();
    //private Set <Map.Entry<Double,Order>> set = new TreeSet<>();
    private ArrayList<Order> sellOrders = new ArrayList<>();
    private Map<String,Order> ids=new HashMap<>();
    public String getName() {
        return name;
    }

    public ArrayList<Order> getBuyOrders() {
        return buyOrders;
    }

    public ArrayList<Order> getSellOrders() {
        return sellOrders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuyOrders(Order buyOrder) {
        this.buyOrders.add(buyOrder);
    }

    public void setSellOrders(Order sellOrder) {
        this.sellOrders.add(sellOrder);
    }
    public void cansOrder(Order order){
        this.sellOrders.remove(order);
        this.buyOrders.remove(order);
    }
    String tradingBuy(Order order){
        String s="";
        ArrayList<Order> sell = new ArrayList<>();
        long number=0;
        for (int i=0; i<buyOrders.size(); i++){
            Order tmp=buyOrders.get(i);
            if (order.getPrice()<=tmp.getPrice()){
                 number+=order.getQuantity();
            }
        }
        if (number>=order.getQuantity()){
            for (int i=0; i<buyOrders.size(); i++){
                Order tmp=buyOrders.get(i);
                if (order.getPrice()<=tmp.getPrice()){
                     if (tmp.getQuantity()<= order.getQuantity()){
                         order.setQuantity(order.getQuantity()- tmp.getQuantity());
                         s+="BUY "+""+tmp.getQuantity()+" " +""+order.getPrice()+" "+order.getListingID()+"\n";
                         buyOrders.remove(tmp);
                         i--;
                         continue;
                     }else {
                        tmp.setQuantity(tmp.getQuantity()-order.getQuantity());
                         buyOrders.set(i,tmp);
                         s+="BUY "+ ""+order.getQuantity() +" " +""+order.getPrice()+" "+order.getListingID()+"\n";
                         break;
                     }
                }
            }
        }
        return s;
    }
    String tradingSell(Order order){
        String s="";
        ArrayList<Order> sell = new ArrayList<>();
        long number=0;
        for (int i=0; i<sellOrders.size(); i++){
            Order tmp=sellOrders.get(i);
            if (order.getPrice()>=tmp.getPrice()){
                number+=order.getQuantity();
            }
        }
        if (number>=order.getQuantity()){
            for (int i=0; i<sellOrders.size(); i++){
                Order tmp=sellOrders.get(i);
                if (order.getPrice()>=tmp.getPrice()){
                    if (tmp.getQuantity()<= order.getQuantity()){
                        order.setQuantity(order.getQuantity()- tmp.getQuantity());
                        s+="SELL "+""+tmp.getQuantity() +" " +""+tmp.getPrice()+"\n";
                        sellOrders.remove(tmp);
                        i--;
                        continue;
                    }else {
                        tmp.setQuantity(tmp.getQuantity()-order.getQuantity());
                        sellOrders.set(i,tmp);
                        s+="SELL "+ ""+order.getQuantity()+" " +""+tmp.getPrice()+"\n";
                        break;
                    }
                }
            }
        }
        return s;
    }


}
