package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Goodies class which contains a list of node modules
//Each module consists of the product Name and Price
public class goodies {

    //Accessing the output text file to print the output
    File output = new File("output.txt");

    //To write output to the output.txt file
    FileWriter fw = new FileWriter(output);
    PrintWriter pw = new PrintWriter(fw);

    public goodies() throws IOException {
    }

    private class Node{
        //Node contains the data of product name and product price

        private int value; //product price
        private String product;//product name
        private Node next;//address of the next node of the item in a list

        public Node(String name,int value){
            this.value = value;
            this.product = name;
        }
    }



    private Node first;
    private Node last;

    //fucntion to add items to the list
    public void addLast(String product,int item){
        Node node = new Node(product,item);
        if(first == null){
            first = node;
            last = node;
        }
        else{
            last.next = node;
            last = node;
        }
    }

    //fucntion to sort the Linked List in ascending order
    public void sort(){

       Node current = first;//Node to traverse the list
       Node index = null;// Next Node after the current node to compare
       int temp; //variable to store the temporary price value
       String temps;//variable to stor the temporary product name

       if(first == null){
           return;
       }
       else{
           while (current!=null){
               index = current.next;
               while (index!= null){
                   if(current.value>index.value){
                       temp = current.value;
                       temps = current.product;
                       current.value = index.value;
                       current.product = index.product;
                       index.value = temp;
                       index.product = temps;
                   }
                   index = index.next;
               }
               current = current.next;
           }
       }
    }

    //fucntion to distribute the product among the given number of employees
    public void distribute(int m){
        int minval = Integer.MAX_VALUE; // variable to hold the minimum difference betweeen the highest and lowest difference
        int currentmin = 0;//variable to hold the current minimum value
        Node index1 = null;//variable to hold the node of the lowest product
        Node index2 = null;//variable to hold the node of the highest product
        Node runner1 = first;
        Node runner2 = first;
        int counter =1;
        while(counter<m){
            runner2 = runner2.next;
            counter++;
        }

        //finding the set of products which are between the highest and lowest price products
        while (runner2 != null){
            currentmin = runner2.value - runner1.value;
            if(currentmin<minval){
                minval = currentmin;
                index1 = runner1;
                index2 = runner2;
            }
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        Node current = index1;

        //Writing the output to the output.txt file
        pw.println("The goodies selected for distribution are:");
        pw.println();
        while (current!=index2.next){
            String h = current.product+": "+current.value;
            pw.println(h);
            current = current.next;
        }
        pw.println();
        pw.println("And the difference between the chosen goodie with highest price and the lowest price is "+minval);
        pw.close();
    }

    //funciton to display the list (This function is just to print all the products and their prices in the list
    public void display(){
        Node current = first;
        if (first == null){
            System.out.println("Empty list");
            return;
        }
        while (current!=null){
            System.out.print(current.product+": ");
            System.out.println(current.value);
            current = current.next;
        }

    }
}
