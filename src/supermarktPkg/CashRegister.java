package supermarktPkg;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CashRegister {

    private Queue<Item> conveyorBelt = new ArrayDeque<Item>();
    private LinkedList<String> discountCatalog = new LinkedList<String>();

    public void addDiscountedItem(String itemName){

        discountCatalog.add(itemName);

    }

    public void placeDivider(){
        Item divider= new Item("",0.0);
        conveyorBelt.add(divider);

    }

    public void loadItems(Stack<Item> cart){

        while (!cart.isEmpty()){

            Item element = cart.pop();

            conveyorBelt.add(element);
        }


    }

    public void serveClient(){

        double total =0.0;
        Item scannedItem=conveyorBelt.poll();
        if(scannedItem!=null){

            String name=scannedItem.getName();
            double price=scannedItem.getPrice();

            while (!scannedItem.isDivider()){

                if(discountCatalog.contains(name)){
                    price=price*0.50;
                    total+=price;
                    System.out.println(name+": € "+price+" (50 % off)");
                }
                else {

                    System.out.println(name+": € "+price);
                    total+=price;

                }

                scannedItem=conveyorBelt.poll();
                name=scannedItem.getName();
                price=scannedItem.getPrice();


            }

            if (total!=0.0){
                System.out.println("Total: €"+total);
                System.out.println();
            }

        }




    }

}

