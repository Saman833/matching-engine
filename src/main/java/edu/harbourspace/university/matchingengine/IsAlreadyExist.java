package edu.harbourspace.university.matchingengine;

import java.util.HashMap;
import java.util.*;

public class IsAlreadyExist {
    private Map<String,Order> idMap=new HashMap<>();
    Order checkIfAlreadyExist(Order order){
        if (idMap.get(order.getId())!=null){
            ((CreateOrder) order).setState(State.NOTACCEPTED);
        }else {
            idMap.put(order.getId(),order);
        }
        return order;
    }

}
