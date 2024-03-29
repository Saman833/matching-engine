package edu.harbourspace.university.matchingengine;

public class Trade {
    private final String listingId;
    private final Side side;
    private final double price;
    private final long quantity;
    Trade (Side side, long quantity, double price, String listingId){
        this.side=side;
        this.listingId=listingId;
        this.price=price;
        this.quantity=quantity;
    }
    @Override
    public String toString() {
        return side +" "+quantity+" "+price+" "+listingId+"\n";
    }
    // you need to add ;
}
