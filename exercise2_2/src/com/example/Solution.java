
package com.example;
import java.util.*;


public class Solution{

    public static void main(String []args){
        Player p1 = new Player("Jack");
        p1.showInformation();

        SoccerPlayer s1 = new SoccerPlayer("Bruce",11);
        s1.showInformation();

        BasketballPlayer b1 = new BasketballPlayer("Kobe", 24,  "shooting guard");
        b1.showInformation();

    }
}
