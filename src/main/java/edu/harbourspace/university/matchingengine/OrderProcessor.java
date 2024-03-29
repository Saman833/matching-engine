package edu.harbourspace.university.matchingengine;

import java.util.ArrayList;
import java.util.*;

public class OrderProcessor {
    private IsAlreadyExist isAlreadyExist=new IsAlreadyExist();
    private IdForListingID idForListingID=new IdForListingID();
    private FindListingID findListingID=new FindListingID();
    private CheckTradePossible checkTradePossible=new CheckTradePossible();
    private MaxPosition maxPosition;
    private Trading trading=new Trading();

    public void setMaxPosition(MaxPosition maxPosition) {
        this.maxPosition = maxPosition;
    }

    ArrayList<Trade> processOrder(Order order) {
             ListingID listingID;
             ArrayList <Trade> trades=new ArrayList<>();
             order=isAlreadyExist.checkIfAlreadyExist(order);
             if (((CreateOrder) order).getState()==State.ACCEPTED){
                 listingID=findListingID.findListingID(order);
                 listingID.addAnOrder(order);
                 if (order.getOriginator()==Originator.VE){
                     order=maxPosition.checkOrder(order);
                     if (((CreateOrder) order).getState()==State.ACCEPTED){
                         ArrayList<Order> orders=listingID.getOrders();
                         if (checkTradePossible.checkOrders(orders,order)){
                            trades=trading.doTrade(listingID,order);
                         }
                     }
                 }
             }
             return trades;
    }
    void cancelOrder(Order order) {
          idForListingID.giveListingId(order);
          if (order.getListingID().equals("")){

          }else {
              ListingID listingID = findListingID.findListingID(order);
              listingID.removeAnOrder(order);
          }
    }
}
/*
100000
DF id1 BUY 1000 98.0 v
VE id2 SELL 1000 98.0 v
 */
