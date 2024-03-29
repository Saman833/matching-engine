package edu.harbourspace.university.matchingengine;
import java.util.*;
public class IdForListingID {
    Map <String,String> x= new HashMap<>();

    void giveListingId(Order order){
        String listingId="";
        if(x.get(order.getId())!=null)
            order.setListingID(x.get(order.getId()));
    }
    void add(Order order){
        x.put(order.getId(),order.getListingID());
    }


}
