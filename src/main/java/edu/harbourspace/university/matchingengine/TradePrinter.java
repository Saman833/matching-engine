package edu.harbourspace.university.matchingengine;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.log4j.Logger;

public class TradePrinter {
    private final static Logger LOGGER = Logger.getLogger(TradePrinter.class);
    void printTrades(ArrayList<Trade> trades) {
        for(Trade trade:trades){
            LOGGER.info(trade);
        }
    }
}
