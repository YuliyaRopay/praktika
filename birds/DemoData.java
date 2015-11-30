package birds;

import java.util.*;

public class DemoData {

    private List<Customer> customerList;
    private List<Bird> birdsList;
    private List<Transaction> transactionList;

    public DemoData() {
        customerList = new ArrayList<Customer>();
        birdsList=new ArrayList<Bird>();
        transactionList=new ArrayList<Transaction>();
    }


    public void addCustomer(){
        customerList.add(new Customer("p1","Petya","Petrov"));
        customerList.add(new Customer("v1","Vanya","Ivanov","050-345-34-55","address2"));
        customerList.add(new Customer("a1","Alex","Petrov","096-123-11-22","address3"));
        customerList.add(new Customer("n1","Nikolay","Sidorov"));
        customerList.add(new Customer("p2","Petya","Sidorov"));
    }

    public void printCustomers(){
        for(Customer customer:customerList){
            System.out.println(customer.toString());
        }
    }

    public List<Customer> getListCustomers(){
        return customerList;
    }


    public void addBird(){
        birdsList.add(new Bird("duck", BirdsType.DOMESTIC_BIRD, 20, 30.20,10));
        birdsList.add(new Bird("chick", BirdsType.DOMESTIC_BIRD, 100, 10, 200));
        birdsList.add(new Bird("dove", BirdsType.WILD_BIRD, 54, 20, 300));
        birdsList.add(new Bird("grouse", BirdsType.WILD_BIRD, 200, 50, 500));
        birdsList.add(new Bird("cockatoo", BirdsType.EXOTIC_BIRD, 10, 300, 10));
        birdsList.add(new Bird("hawk", BirdsType.BIRD_OF_PREY, 2, 500, 5));
        birdsList.add(new Bird("kiwi", BirdsType.EXOTIC_BIRD, 5, 600, 3));
        birdsList.add(new Bird("None", BirdsType.NONE, 0, 0, 0));
    }

    public void printBirds(){
        for(Bird bird:birdsList){
            System.out.println(bird.toString());
        }
    }

    public List<Bird> getListBirds(){
        return birdsList;
    }

    public void addTransaction(){
        Calendar calendar=new GregorianCalendar(2015,Calendar.APRIL,12);

        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.APRIL,12), customerList.get(0), birdsList.get(6), 1, birdsList.get(6).getPrice()*1));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.APRIL,20), customerList.get(1), birdsList.get(1), 5, birdsList.get(1).getPrice()*5));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,01), customerList.get(1), birdsList.get(0), 3, birdsList.get(0).getPrice()*3));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,06), customerList.get(2), birdsList.get(1), 2, birdsList.get(1).getPrice()*2));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,05), customerList.get(0), birdsList.get(2), 2, birdsList.get(2).getPrice()*2));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,03), customerList.get(4), birdsList.get(2), 1, birdsList.get(2).getPrice()*1));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,07), customerList.get(3), birdsList.get(3), 4, birdsList.get(3).getPrice()*4));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,10), customerList.get(3), birdsList.get(5), 5, birdsList.get(5).getPrice()*5));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,11), customerList.get(3), birdsList.get(5), 2, birdsList.get(5).getPrice()*2));
        transactionList.add(new Transaction(new GregorianCalendar(2015,Calendar.AUGUST,01), customerList.get(1), birdsList.get(6), 1, birdsList.get(6).getPrice()*1));

    }

    public List<Transaction> getTransactionList(){
        return transactionList;
    }


}
