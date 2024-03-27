package org.example;
import java.util.*;
public class InputParser {
    long maxPos;
    Cansel cansel=new Cansel();
    MaxPosition maxPosition;
    InputParser(long maxPos){
        this.maxPos= maxPos;
        this.maxPosition=new MaxPosition(this.maxPos);
    }

    Order makeBuyOrder(List<String> s){
        Order order=new Order();
        order.setType("Buy");
        order.setId(s.get(1));
        order.setPrice(Double.parseDouble(s.get(4)));
        order.setQuantity(Long.parseLong(s.get(3)));
        order.setListingID(s.get(5));
        return order;
    }
    Order makeSellOrder(List<String> s){
        Order order=new Order();
        order.setType("Sell");
        order.setId(s.get(1));
        order.setPrice(Double.parseDouble(s.get(4)));
        order.setQuantity(Long.parseLong(s.get(3)));
        order.setListingID(s.get(5));
        return order;
    }

    static void invalid(){
        System.out.println("INVALID ORDER");
    }
    public static boolean isNumeric(String strNum) {//Map.entry()
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    boolean parserInput(String order){
        Map<String,ListingID> ids= new HashMap<>();
        if (order.equals("Finish")){
            return true;
        }
        String[] ss=order.split(" ");
        ArrayList<String> s=new ArrayList<>();
        for (int i=0; i<ss.length; i++){
            if(!ss[i].equals(" ")){
                s.add(ss[i]);
            }
        }
        if (s.size()==6 && isNumeric(s.get(3)) && isNumeric(s.get(4)) ){
            if (s.get(0).equals("DF")){
                if (s.get(2).equals("BUY")){
                    maxPosition.buyOrder(makeBuyOrder(s));
                }else if(s.get(2).equals("SELL")){
                    maxPosition.sellOrder(makeSellOrder(s));
                }else {
                    invalid();
                    return false;
                }
            }else if (s.get(0).equals("VE")){
                if (s.get(2).equals("BUY")){
                    maxPosition.getAlreadyListingIdes().tradinForSell(makeSellOrder(s));
                }else if(s.get(2).equals("SELL")){
                   maxPosition.getAlreadyListingIdes().tradinForBuy(makeBuyOrder(s));

                }else {
                    invalid();
                    return false;
                }
            }else {
                invalid();
                return false;
            }
        }else if (s.size()==3 && s.get(2).equals("cansel")) {
            if (s.get(0).equals("DF")) {
                      maxPosition.getAlreadyListingIdes().cansellOrder(s.get(1));
            } else{
                invalid();
            }
        }else {
            invalid();
            return false;
        }
        return false;
    }

}
















