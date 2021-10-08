
/*
Title: Vending Machine
Date: 1 October 2021
Author: Esha Sawant
Abstract: The code sets the name and location of the Vending machine. It also manages takes user input for items and compares with the quantity available.
It dispenses the item selected and also takes returns. It displays the electronic receipt, the total bill, the items sold and the total earnings of the machine.
 */
package HW4;
import java.util.*;

import static java.lang.System.exit;


public class VendingMachine{
    int name;
    String loc = "UNKNOWN";
    double payment;
    Scanner kb=new Scanner(System.in);
    List<String> arr=new ArrayList<>(5);
    HashMap<String,Integer> Menu=new HashMap<>(10);
    HashMap<Integer,String>menu1=new HashMap<>(10);
    HashMap<String,Integer> price=new HashMap<>(10);

    public VendingMachine(int name){
        setName(name);
        //System.out.println("Serial Number: "+name);
        Menu.put("Water",0);
        Menu.put("Coffee",0);
        Menu.put("Chips",0);
        Menu.put("Chocolate",0);
        //displayMenu();
        menu1.put(1,"Water");
        menu1.put(2,"Coffee");
        menu1.put(3,"Chips");
        menu1.put(4,"Chocolate");

        price.put("Water",0);
        price.put("Coffee",0);
        price.put("Chips",0);
        price.put("Chocolate",0);

    }

    public VendingMachine(int name,String loc){
        setLocation(loc);
        setName(name);
        Menu.put("Water",0);
        Menu.put("Coffee",0);
        Menu.put("Chips",0);
        Menu.put("Chocolate",0);
        //displayMenu();
        menu1.put(1,"Water");
        menu1.put(2,"Coffee");
        menu1.put(3,"Chips");
        menu1.put(4,"Chocolate");

        price.put("Water",0);
        price.put("Coffee",0);
        price.put("Chips",0);
        price.put("Chocolate",0);
    }

    public void setLocation(String loc) {
        this.loc=loc;
    }

    public void setName(int name){
        this.name=name;
    }

    public void reset(int a,int b,int c,int d){
        Menu.put("Water",a);
        Menu.put("Coffee",b);
        Menu.put("Chips",c);
        Menu.put("Chocolate",d);
    }

    public void addItems(int a,int b,int c,int d){
        Menu.compute("Water",(key, val)->(val+a));
        Menu.compute("Coffee",(key, val)->(val+b));
        Menu.compute("Chips",(key, val)->(val+c));
        Menu.compute("Chocolate",(key, val)->(val+d));
    }

    public void displayMenu(){
        //System.out.println(Menu);
        System.out.println("\n===Vending Machine Menu===");
        System.out.println("1. Water........$1.50");
        System.out.println("2. Coffee.......$2.00");
        System.out.println("3. Chips........$1.00");
        System.out.println("4. Chocolate....$2.50");
        System.out.println();
        //for(String i: Menu.keySet()) {
          //      System.out.println("\t"+i+"....."+Menu.get(i));
    //}
    }

    public void buyItem(){
        System.out.println("Select an item number: ");
        int no=kb.nextInt();
        System.out.println("How many do you want to buy? ");
        int item=kb.nextInt();
        System.out.println("You selected "+menu1.get(no)+". Quantity: "+item);
        //int m=Menu.get(menu1.get(no));
        price.replace(menu1.get(no),item);
        arr.add(menu1.get(no));
        Menu.compute(menu1.get(no),(key,val)->(val-item));
    }
    public boolean buyItem(int a,int b){
        String m= menu1.get(a);
        //Menu.compute(m,(key,val)->(Menu.get(m)b);
        //Set<String> it= Menu.keySet();
        if(b<=Menu.get(m)){
            System.out.println("You selected "+menu1.get(a)+". Quantity: "+b);
            //int m=Menu.get(menu1.get(no));
            price.replace(menu1.get(a),b);
            arr.add(menu1.get(a));
            Menu.compute(menu1.get(a),(key,val)->(val-b));
            //buyItem();
            return true;
        }
        else{
            //buyItem();
            arr.remove(m);
            //price.remove(m);
            System.out.println("Selection Failed. We don't have enough "+ m);
            return false;}

    }

    public void returned(int a,int b){
        System.out.println("You selected "+menu1.get(a)+". Quantity: "+b);
        Menu.compute(menu1.get(a),(key,val)->(val+b));
        price.compute(menu1.get(a),(key,val)->(val-b));

        //System.out.println(price.keySet());
        //System.out.println(Menu);
        //System.out.println(menu1);
        //System.out.println(Menu);
    }

    public boolean payment(){
        double pay=0;
        //System.out.println(price);
        for (int i =0; i <arr.size(); i++){
            if(arr.get(i).equals("Water")) {
                pay+=(1.50 * (price.get("Water")));
                //System.out.println("Water: $1.50 X" + price.get("Water") + " = $" +pay);
            }
            else if (arr.get(i).equals("Coffee")) {
                pay+=(2.00 * (price.get("Coffee")));
                //System.out.println("Coffee: $2.00 X" + price.get("Coffee") + " = $" +pay);
            }
            else if (arr.get(i).equals("Chips")) {
                pay+=(1.00 * (price.get("Chips")));
                //System.out.println("Chips: $1.00 X" + price.get("Chips") + " = $" +pay);
            }
            else if (arr.get(i).equals("Chocolate")) {
                pay+=(2.50 * (price.get("Chocolate")));
                //System.out.println("Coffee: $2.50 X" + price.get("Chocolate") + " = $" +pay);
            }
        }
        payment=pay+(pay/10);
        //System.out.println(payment);
        System.out.println("Enter money amount: $");
        double money=kb.nextDouble();
        if(payment>money){
            System.out.println("Insufficient money. $"+String.format("%.2f",money)+" returned");
            return false;
        }
        else {
            System.out.println("Sufficient money. $"+String.format("%.2f",(money-payment))+" returned");
            return true;
        }
    }

    public void displayReceipt() {
        //System.out.println(price.get("Water"));
        double pay=0;
        for (int i = 0; i <arr.size(); i++){
            if(arr.get(i).equals("Water")) {
                pay=(1.50 * (price.get("Water")));
                System.out.println("Water: $1.50 X" + price.get("Water") + " = $" +String.format("%.2f",pay));
            }
            else if (arr.get(i).equals("Coffee")) {
                pay=(2.00 * (price.get("Coffee")));
                System.out.println("Coffee: $2.00 X" + price.get("Coffee") + " = $" +String.format("%.2f",pay));
            }
            else if (arr.get(i).equals("Chips")) {
                pay=(1.00 * (price.get("Chips")));
                System.out.println("Chips: $1.00 X" + price.get("Chips") + " = $" +String.format("%.2f",pay));
            }
            else if (arr.get(i).equals("Chocolate")) {
                pay=(2.50 * (price.get("Chocolate")));
                System.out.println("Chocolate: $2.50 X" + price.get("Chocolate") + " = $"+String.format("%.2f",pay));
            }
        }
        System.out.println("Tax(10.0%): $"+String.format("%.2f",pay/10));
        System.out.println("Total: $"+String.format("%.2f",(pay+(pay/10))));
    }


    public void status() {
        if (price.containsKey(0)) {
            System.out.println("=====Nothing was sold. $0.00 was earned=====");
            exit(1);
        } else {
            System.out.println("Serial Number: " + name);
            System.out.println("Location: " + loc);
            System.out.println("Sold items: ");
            for (String i : price.keySet()) {
                System.out.println("\t" + i + "....." + price.get(i));
            }
            System.out.println();
            System.out.println("Current Contents: ");
            for (String i : Menu.keySet()) {
                System.out.println("\t" + i + "....." + Menu.get(i));
            }
            System.out.println();
            System.out.println("Total earnings: " + String.format("%.2f", payment));
        }
    }
    public String toString() {
        String a= "Serial Number: " + name + "\n" + "Location: " + loc + "\nContents:";
        System.out.println(a);
        for (String i : Menu.keySet()) {
            System.out.println("\t" + i + "....." + Menu.get(i));
        }
        return "\n";
    }

    public boolean equals(VendingMachine o){
        if(this.Menu.equals(o.Menu)){
            return true;
        }
        else
            return false;
    }
}