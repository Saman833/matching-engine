package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
public class Main {

    public static void main(String[] args){
        Set <String> result= new HashSet<>();
        Scanner inp=new Scanner(System.in);
        long maxPosition= inp.nextLong();
        System.out.println(maxPosition);

        InputParser inputParser=new InputParser(maxPosition);
        InputReader inputReader=new InputReader(inp);
        while (true){
           if (inputParser.parserInput(inputReader.readInput())){
               break;
           }
        }
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