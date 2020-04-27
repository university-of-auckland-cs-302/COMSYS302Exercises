package com.example;

class BasketballPlayer extends Player{
    private int number;
    private String position;

    BasketballPlayer(String name, int number, String position){

        super(name);
        this.number = number;
        this.position = position;
    }



    @Override
    String getNumber(){
        return "The number is " + number +".";
    }

    String getPosition(){

        return "The position is " + position + ".";
    }


    @Override
    void showInformation() {
        System.out.println();
        System.out.println(getName()+ " is a basketball player.");
        System.out.println(getNumber());
        System.out.println(getPosition());
    }

}
