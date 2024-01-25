// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import supermarktPkg.CashRegister;
import supermarktPkg.Item;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addDiscountedItem("Coffee");

        Stack<Item> cart1 = new Stack<Item>();
        Stack<Item> cart2 = new Stack<Item>();

        cart1.add(new Item("Milk",1));
        cart1.add(new Item("Bread",2.5));

        cart2.add(new Item("Oranges",2));
        cart2.add(new Item("Coffee",4));

        cashRegister.loadItems(cart1);
        cashRegister.placeDivider();
        cashRegister.loadItems(cart2);

        cashRegister.serveClient();
        cashRegister.serveClient();

    }
}