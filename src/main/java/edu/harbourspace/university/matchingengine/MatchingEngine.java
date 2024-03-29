package edu.harbourspace.university.matchingengine;

import java.util.Collection;

public class MatchingEngine {
    private final long maxPosition;
    private final OrderProcessor orderProcessor;
    private final TradePrinter tradePrinter;
    private final InputParser inputParser;
    private final InputReader inputReader;
    private MaxPosition maxPositionn;

    public MatchingEngine(long maxPosition, OrderProcessor orderProcessor, TradePrinter tradePrinter, InputParser inputParser, InputReader inputReader) {
        this.maxPosition = maxPosition;
        this.maxPositionn = new MaxPosition(maxPosition);
        this.orderProcessor = orderProcessor;
        this.tradePrinter = tradePrinter;
        this.inputParser = inputParser;
        this.inputReader = inputReader;
    }

    public void run() {
        orderProcessor.setMaxPosition(maxPositionn);
        while (true) {
            try {
                String strOrder = inputReader.readOrder();
                Order order = inputParser.parserInput(strOrder);
                switch (order.getOrderType()) {
                    case CREATE -> {
                            Collection<Trade> trades = orderProcessor.processOrder(order);
                            tradePrinter.printTrades(trades);
                    }
                    case CANCEL -> orderProcessor.cancelOrder(((CancelOrder) order));
                }
            } catch (InvalidOrderException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
