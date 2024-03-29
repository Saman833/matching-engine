package edu.harbourspace.university.matchingengine;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        InputReader inputReader = new InputReader(new Scanner(System.in));
        long maxPosition = inputReader.readMaxPosition();
        InputParser inputParser=new InputParser(maxPosition);
        OrderProcessor orderProcessor = new OrderProcessor();
        TradePrinter tradePrinter = new TradePrinter();
        MatchingEngine matchingEngine = new MatchingEngine(maxPosition,
                orderProcessor, tradePrinter, inputParser, inputReader);
        matchingEngine.run();
    }

}
/*
String order= inp.nextLine();
            if (order.equals("Finish")){
                break;
            }
            String[] ss=order.split(" ");
            ArrayList<String> s=new ArrayList<>();
            for (int i=0; i<ss.length; i++){
                if(!ss[i].equals(" ")){
                    s.add(ss[i]);
                }
            }
            if (s.size()==6 && isNumeric(s.get(3)) && isNumeric(s.get(4)) ){
                if (s.get(0).equals("DF")){
                    if (s.get(2).equals("BUY")){

                    }else if(s.get(2).equals("SELL")){

                    }else {
                        invalid();
                    }
                }else if (s.get(0).equals("VE")){
                    if (s.get(2).equals("BUY")){

                    }else if(s.get(2).equals("SELL")){

                    }else {
                        invalid();
                        continue;
                    }
                }else {
                    invalid();
                    continue;
                }
            }else if (s.size()==3 && s.get(2).equals("cansel")){

            }else {
                invalid();
                continue;
            }
 */
/*
DF IDI BUY 400 100.0 v
VE IDOI SELL 300 100.0 v
DF IDI cansel
VE IDO2 SELL 100 100.0 v
 */