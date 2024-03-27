package edu.harbourspace.university.matchingengine;

import java.util.Collection;

public class MatchingEngine {
    private final long maxPosition;
    private final OrderProcessor orderProcessor;
    private final TradePrinter tradePrinter;
    private final InputParser inputParser;
    private final InputReader inputReader;

    public MatchingEngine(long maxPosition, OrderProcessor orderProcessor, TradePrinter tradePrinter, InputParser inputParser, InputReader inputReader) {
        this.maxPosition = maxPosition;
        this.orderProcessor = orderProcessor;
        this.tradePrinter = tradePrinter;
        this.inputParser = inputParser;
        this.inputReader = inputReader;
    }

    public void run() {
        while (true) {
            try {
                Order order = inputParser.parserInput(inputReader.readOrder());
                switch (order.getOrderType()) {
                    case CREATE -> {
                        Collection<Trade> trades = orderProcessor.processOrder(order);
                        tradePrinter.printTrades(trades);
                    }
                    case CANCEL -> orderProcessor.cancelOrder((CancelOrder) order);
                }
            } catch (InvalidOrderException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
