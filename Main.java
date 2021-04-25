package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //Accessing the input file to get the input
        File fileText = new File("input.txt");

        //Declaring and intializing scanner variable
        Scanner s = new Scanner(fileText);
        String str = s.nextLine();

        //Reading the number of Goodies to be distributed
        str = str.replaceAll("[^\\d.]", "");
        int m = Integer.parseInt(str);
        for(int i=0;i<3;i++){
            s.nextLine();
        }

        //Creating an instance of the class goodies to add all the goodies and prices in the list
        goodies a = new goodies();
        String hold = "";
        String product = "";
        String price  = "";

        while(s.hasNext()){
            hold = s.nextLine();
            product = hold.replaceAll("[^a-zA-Z]", "");
            price = hold.replaceAll("[^\\d.]", "");
            a.addLast(product,Integer.parseInt(price));
        }

        //Sorting the goodies list in ascending order of the price value
        a.sort();

        //Performing distribuiton of goodies to the employees and writing the output to the output file
        a.distribute(m);

    }
}
