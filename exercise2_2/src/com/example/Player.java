package com.example;

public class Player {

        private String name;

        public Player (String name){
            this.name = name;
        }

        String getName() {

            return name ;
        }

       String getNumber() {

            return "The number is undefined.";
        }


        void showInformation(){

            System.out.println(getName() + " is a genetic player.");
            System.out.println(getNumber());
        }


}
