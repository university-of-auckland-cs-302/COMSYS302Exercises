package com.example;

class SoccerPlayer extends Player{

    private int number;

    SoccerPlayer(String name, int number){

       super(name);
       this.number = number;

   }


    @Override
    String getNumber(){
        return "The number is " + number + ".";
    }

    @Override
    void showInformation() {
        System.out.println();
        System.out.println(getName() + " is a soccer player." );
        System.out.println(getNumber());

    }
}
