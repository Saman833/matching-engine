package edu.harbourspace.university.matchingengine;

public class MaxPosition {
    private long maxPosition;
    private long position=0;
    MaxPosition(long maxPosition) {
     this.maxPosition=maxPosition; this.position=0;
    }

    Order checkOrder(Order  order){
            if (((CreateOrder) order).getSide()==Side.SELL && ((CreateOrder) order).getQuantity()+this.position<=this.maxPosition){
                //alreadyListingIdes.checkBuyOrder(order);
                return order;
            }
        if (((CreateOrder) order).getSide()==Side.BUY && Math.abs(this.position-((CreateOrder) order).getQuantity())<=this.maxPosition){
            //this.position-= ((CreateOrder) order).getQuantity();
            //alreadyListingIdes.checkSellOrder(order);
            return order;
        }
            ((CreateOrder) order).setState(State.NOTACCEPTED);
            return order;
    }


}
