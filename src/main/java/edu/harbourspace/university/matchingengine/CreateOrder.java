package edu.harbourspace.university.matchingengine;

public class CreateOrder extends Order {
    private double price;
    private long quantity;
    private String type;
    private String listingID;
    private Side side;
    private State state=State.ACCEPTED;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public String getListingID() {
        return listingID;
    }

    public void setListingID(String listingID) {
        this.listingID = listingID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
