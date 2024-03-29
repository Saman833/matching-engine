package edu.harbourspace.university.matchingengine;

public abstract class Order {
    private  String id; // final should be here
    private  OrderType orderType;
    private Originator originator;

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }


    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setId(String id) {
         this.id = id;
    }

    public String getId() {
        return id;
    }


}
