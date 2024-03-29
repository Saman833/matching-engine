package edu.harbourspace.university.matchingengine;

import java.util.HashMap;
import java.util.Map;

public class FindListingID {
    private Map<String,ListingID> lisingIdMap=new HashMap<>();
    ListingID findListingID(Order order){
        ListingID listingID;
        if (lisingIdMap.get(order.getId())!=null){
            listingID=lisingIdMap.get(order.getId());
        }else {
            listingID=new ListingID();
            listingID.setName(order.getId());
            lisingIdMap.put(listingID.getName(),listingID);
        }
        return listingID;
    }
}
