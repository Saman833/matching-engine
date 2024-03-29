package edu.harbourspace.university.matchingengine;

import java.util.HashMap;
import java.util.Map;

public class FindListingID {
    private Map<String,ListingID> lisingIdMap=new HashMap<>();
    ListingID findListingID(Order order){
        ListingID listingID;
        if (lisingIdMap.get(((CreateOrder) order).getListingID())!=null){
            listingID=lisingIdMap.get(((CreateOrder) order).getListingID());
        }else {
            listingID=new ListingID();
            listingID.setName(((CreateOrder) order).getListingID());
            lisingIdMap.put(listingID.getName(),listingID);
        }
        return listingID;
    }
}
