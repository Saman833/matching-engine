package edu.harbourspace.university.matchingengine;
import java.util.*;
public class AlreadyListingIdes {
    private Map<String,ListingID> listingIDMap=new HashMap<>();
    private Map<String,ListingID> idMap=new HashMap<>();
    private Map<String,Order> orderMap=new HashMap<>();
     void checkBuyOrder(Order order){
         orderMap.put(order.getId(),order);
         if (idMap.get(order.getId())==null){
             if (listingIDMap.get(order.getListingID())==null){
                 ListingID listingID=new ListingID();
                 listingID.setBuyOrders(order);
                 idMap.put(order.getId(),listingID);
                 listingIDMap.put(order.getListingID(),listingID);
             }else {
                 listingIDMap.get(order.getListingID()).setBuyOrders(order);
                 idMap.put(order.getId(),listingIDMap.get(order.getListingID()));
             }
         }else {
             idMap.get(order.getId()).cansOrder(order);
             idMap.put(order.getId(),idMap.get(order.getId()));
             listingIDMap.get(order.getListingID()).setBuyOrders(order);
         }
   }
   void checkSellOrder(Order order){
       orderMap.put(order.getId(),order);
       if (idMap.get(order.getId())==null){
           if (listingIDMap.get(order.getListingID())==null){
               ListingID listingID=new ListingID();
               listingID.setSellOrders(order);
               idMap.put(order.getId(),listingID);
               listingIDMap.put(order.getListingID(),listingID);
           }else {
               listingIDMap.get(order.getListingID()).setSellOrders(order);
               idMap.put(order.getId(),listingIDMap.get(order.getListingID()));
           }
       }else {
           idMap.get(order.getId()).cansOrder(order);
           idMap.put(order.getId(),idMap.get(order.getId()));
           listingIDMap.get(order.getListingID()).setSellOrders(order);
       }
    }
    void cansellOrder(String id){
         if (orderMap.get(id)!=null){
             Order order= orderMap.get(id);
             if (idMap.get(order.getId())!=null){
                 idMap.get(order.getId()).cansOrder(order);
             }
         }
    }
    public Map<String, ListingID> getListingIDMap() {
        return listingIDMap;
    }

    public Map<String, ListingID> getIdMap() {
        return idMap;
    }
    void tradinForBuy(Order order){
         if (listingIDMap.get(order.getListingID())!=null){
             System.out.print(listingIDMap.get(order.getListingID()).tradingBuy(order));
         }

    }
    void tradinForSell(Order order){
        if (listingIDMap.get(order.getListingID())!=null){
            System.out.print(listingIDMap.get(order.getListingID()).tradingSell(order));
        }
    }

}
