package ui;

import java.util.*;

public class PokerGame {

    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        String[] color = {"♦", "♠", "♥", "♣"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int serialNumber = 1;
        for (String n : number) {
            for (String c : color) {
                hm.put(serialNumber, c+n);
                list.add(serialNumber);
                serialNumber++;
            }
        }

        hm.put(serialNumber, "Joker");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber, "Sjoker");
        list.add(serialNumber);
    }


    public PokerGame(){

        Collections.shuffle(list);

        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {

            int serialNumber = list.get(i);
            if (i <= 2){
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0){
                player1.add(serialNumber);
            }else if (i % 3 == 1){
                player2.add(serialNumber);
            }else {
                player3.add(serialNumber);
            }
        }
        System.out.println(player2);
        lookPoker("lord", lord);
        lookPoker("1", player1);
        lookPoker("2", player2);
        lookPoker("3", player3);

        HashMap<ArrayList<String>, String> hm = new HashMap<>();
    }

    public void lookPoker(String name, TreeSet<Integer> ts){
        System.out.print(name + ": ");
        for (Integer serialNumber : ts) {
            String poker = hm.get(serialNumber) ;
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
