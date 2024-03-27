package edu.harbourspace.university.matchingengine;

import java.util.Collection;

public class TradePrinter {

    void printTrades(Collection<Trade> trades) {
        trades.forEach(System.out::println);
    }
}
