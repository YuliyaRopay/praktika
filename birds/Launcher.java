package birds;

import java.util.*;

public class Launcher {
    public static void main(String[] args) {

        DemoData demoData=new DemoData();

        demoData.addCustomer();
        //demoData.printCustomers();
        List<Customer> customerList=demoData.getListCustomers();

        demoData.addBird();
        //demoData.printBirds();
        List<Bird> birdsList=demoData.getListBirds();

        demoData.addTransaction();
        List<Transaction> transactionList=demoData.getTransactionList();


        BirdsStore store =new BirdsStore("My first store");
        store.addListBirds(birdsList);
        store.addListCustomer(customerList);

        System.out.println();
        System.out.println(">>>-----------");
        System.out.println("> List of Birds:");
        store.printAllBirdsList();

        System.out.println();
        System.out.println(">>>-----------");
        System.out.println("> Add new bird - cock:");
        store.addBird(new Bird("cock", BirdsType.DOMESTIC_BIRD, 40, 50));
        store.printAllBirdsList();

        System.out.println();
        System.out.println(">>>-----------");
        System.out.println("> Remove bird - duck:");
        store.removeBird("dUck");
        store.printAllBirdsList();

        System.out.println();
        System.out.println(">>>-----------");
        System.out.println("> Edit bird count - chick=200:");
        System.out.println("> Edit bird price - kiwi=550:");
        store.editBirdCount("Chick", 200);
        store.editBirdPrice("KIWI", 550);
        store.printAllBirdsList();

        System.out.println();
        System.out.println(">>>-----------");
        System.out.println("> Price of Birds DESC:");
        store.printBirdsDescPrice();

        System.out.println();
        System.out.println(">>>-----------");
        System.out.println("> Count of Birds ASC:");
        store.printBirdsAscCount();


        //transaction
        for(Transaction tr:transactionList){
            store.soldBirds(tr.getCalendar(),tr.getCustomer(),tr.getBird().getName(),tr.getCount());
        }

        System.out.println();
        System.out.println(">>>-----------");
        System.out.println("> Transaction list:");
        store.printTransactionByPeriod();

        System.out.println(">>>-----------");
        System.out.println("> List of Birds after transactions:");
        store.printAllBirdsList();


    }

}
