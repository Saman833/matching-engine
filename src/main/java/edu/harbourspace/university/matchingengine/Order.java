package edu.harbourspace.university.matchingengine;

public abstract class Order {
    private final String id;
    private final OrderType orderType;

    public OrderType getOrderType() {
        return orderType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListingID() {
        return listingID;
    }

    public void setListingID(String listingID) {
        this.listingID = listingID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }
}
