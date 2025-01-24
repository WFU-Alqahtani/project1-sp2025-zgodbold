import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Item[] store = setUpStore();
        ArrayList<Item> items = new ArrayList<>();
        items = createCart(args, store);
        boolean check = true;
        int cartSize = 0;
        try{
        cartSize = Integer.parseInt(args[0]);}
        catch (NumberFormatException e){
            System.out.println("Invalid Cart Size");
            check = false;
        }
        if (check) {
            printInOrder(items, cartSize);
            emptyCartReverseOrder(items);
        }
    }
    public static Item[] setUpStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Ham", 5.50);
        store[1] = new Item("Turkey", 6.19);
        store[2] = new Item("Chicken", 8.00);
        store[3] = new Item("Swiss", 4.55);
        store[4] = new Item("Cheddar", 2.99);
        return store;
    }

    public static ArrayList<Item> createCart(String[] args, Item[] store) {
        ArrayList<Item> cart = new ArrayList<>();
        for(int i = 1; i < args.length; i++){
            int item = 0;
            try{
            item = Integer.parseInt(args[i]);}
            catch(NumberFormatException e){
                System.out.println("Invalid item: " + args[i]);
                item = 6;
            }
            if(item < store.length && item > -1){
                cart.add(store[item]);
            }
            else if(item == 6){}
            else{
                System.out.println("Invalid item: " + args[i]);
            }
        }
        return cart;
    }

    public static void printInOrder(ArrayList<Item> cart, int cartSize){
        System.out.println("\nReceipt");
        System.out.println("=========================");
        System.out.println("Item                Price");
        double subtotal = 0;
        for(int i = 0; i < cartSize; i++){
            Item item;
            try{
                item = cart.get(i);
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Expected " + cartSize + " items");
                break;
            }
            String itemName = item.getItemName();
            double price = item.getItemPrice();
            System.out.println(itemName + "            " + price);
            subtotal += price;
        }
        System.out.println("=========================");
        System.out.printf("Subtotal: %.2f", subtotal);
        double tax = subtotal * 0.05;
        System.out.printf("\nSales Tax: %.2f", tax);
        double total = subtotal + tax;
        System.out.printf("\nTotal: %.2f", total);
    }

    public static void emptyCartReverseOrder(ArrayList<Item> cart){
        System.out.println("\n\nRemoving all items from the cart in \"Last To First Out\" order...");
        for(int i = cart.size()-1; i >= 0; i--){
            Item item = cart.get(i);
            String itemName = item.getItemName();
            System.out.println("Removing: " + itemName);
        }
        System.out.println("All Items Removed From Cart");
    }
}