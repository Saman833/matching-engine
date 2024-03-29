package edu.harbourspace.university.matchingengine;
import java.util.*;
public class InputParser {
    long maxPos;
    Cansel cansel=new Cansel();
    MaxPosition maxPosition;
    InputParser(long maxPos){
        this.maxPos= maxPos;
        this.maxPosition=new MaxPosition(this.maxPos);
    }
    Order makeOrder(List<String> s, Side side , Originator originator){
        Order order=new CreateOrder();
        order.setOrderType(OrderType.CREATE);
        ((CreateOrder) order).setSide(side);
        order.setId(s.get(1));
        ((CreateOrder) order).setPrice(Double.parseDouble(s.get(4)));
        ((CreateOrder) order).setQuantity(Long.parseLong(s.get(3)));
        ((CreateOrder) order).setListingID(s.get(5));
        return order;
    }
    Order canselOrder(List<String> s , Originator originator) {
        Order order = new CancelOrder();
        order.setOrderType(OrderType.CANCEL);
        order.setOriginator(originator);
        order.setId(s.get(1));
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
    Order parserInput(String order) throws InvalidOrderException {
        Map<String,ListingID> ids= new HashMap<>();
        if (order.equals("Finish")){
            throw new InvalidOrderException("Message");
        }
        String[] ss=order.split(" ");
        ArrayList<String> s=new ArrayList<>();
        for (int i=0; i<ss.length; i++){
            if(!ss[i].equals(" ")){
                s.add(ss[i]);
            }
        }
        Originator originator = Originator.valueOf(s.get(0));
        Side side = Side.valueOf(s.get(2));
        if (s.size()==6 && isNumeric(s.get(3)) && isNumeric(s.get(4)) ){
            if (originator == Originator.DF){
                if (side== Side.BUY){
                    return makeOrder(s,side,originator);
                }else if(side== Side.SELL){
                    return makeOrder(s,side,originator);
                }else {
                    throw new InvalidOrderException("Message");
                }
            }else if (originator==Originator.VE){
                if (side== Side.BUY){
                    return makeOrder(s,side,originator);
                }else if(side== Side.SELL){
                   return makeOrder(s,side,originator);
                }else {
                    throw new InvalidOrderException("Message");
                }
            }else {
                throw new InvalidOrderException("Message");
            }
        }else if (s.size()==3 && s.get(2).equals("cansel")) {
            if (originator==Originator.DF) {
                return canselOrder(s,originator);
            }else if (originator==Originator.VE){
                return canselOrder(s,originator);
            } else{
                throw new InvalidOrderException("Message");
            }
        }else {
            throw new InvalidOrderException("Message");
        }
    }

}
















