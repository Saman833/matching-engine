package edu.harbourspace.university.matchingengine;

public class MaxPosition {
    AlreadyListingIdes alreadyListingIdes=new AlreadyListingIdes();
    private long maxPosition;
    private long position=0;
    MaxPosition(long maxPosition) {
     this.maxPosition=maxPosition; this.position=0;
    }

    boolean buyOrder(Order order){
            if (order.getQuantity()+this.position<=this.maxPosition){
                this.position+= order.getQuantity();
                alreadyListingIdes.checkBuyOrder(order);
                return true;
            }
        return false;
    }
    boolean sellOrder(Order order){
        if (Math.abs(this.position-order.getQuantity())<=this.maxPosition){
            this.position-= order.getQuantity();
            alreadyListingIdes.checkSellOrder(order);
            return true;
        }
        return false;
    }
    AlreadyListingIdes getAlreadyListingIdes(){
        return this.alreadyListingIdes;
    }


}
