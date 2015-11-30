package birds;


import java.util.*;

public class BirdsStore {
    private String name;

    private Map<String,Bird> birdsListByName;
    private List<Bird> birdsList;
    private List<Customer> customerList;
    private List<Transaction> transactionList;

    public BirdsStore(String name) {
        this.name = name;
        birdsList=new ArrayList<Bird>();
        birdsListByName=new HashMap<String, Bird>();
        customerList=new ArrayList<Customer>();
        transactionList=new ArrayList<Transaction>();
    }

    public List<Bird> getBirdsList() {
        return birdsList;
    }

    public List<Bird> getBirdsByTypeList(String typeName) {
        BirdsType type=BirdsType.valueOf(typeName);
        List<Bird> birdsByTypeList=new ArrayList<Bird>();
        for(Bird bird : birdsList){
            if(bird.getType().equals(type)){
                birdsByTypeList.add(bird);
            }
        }

        return birdsByTypeList;
    }

    public String[] getBirdsTypeArray(){
        int length= BirdsType.values().length;
        String resultArray[] =new String[length];
        for(int i =0; i<length; i++){
            resultArray[i]=BirdsType.values()[i].toString();
        }
        return resultArray;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    // add
    public void addListBirds(List<Bird> birdsList){
        for(Bird bird :birdsList){
            addBird(bird);
        }
    }

    public void addBird(Bird bird){
        if(bird!=null){
            birdsList.add(bird);
            birdsListByName.put(bird.getName().toLowerCase(),bird);
        }
    }

    public void addListCustomer(List<Customer> customerList){
        for(Customer customer :customerList){
            addCustomer(customer);
        }
    }

    public void addCustomer(Customer customer){
        if(customer!=null){
            customerList.add(customer);
        }
    }


    // get
    public Bird getBirdByName(String birdName){
        return birdsListByName.get(birdName.toLowerCase());
    }


    // remove
    public void removeBird(Bird bird){
       // Bird birdDelete=bird;
        birdsList.remove(bird);
        birdsListByName.remove(bird.getName().toLowerCase());

    }

    public boolean removeBird(String birdName){
        Bird bird=getBirdByName(birdName);
        if(bird!=null){
            removeBird(bird);
            return true;
        }
        return false;
    }

    // edit
    public boolean editBirdCount(String birdName, int newCount){
        return editBirdByField(birdName, "count", newCount);
    }

    public boolean editBirdPrice(String birdName, double newPrice){
        return editBirdByField(birdName, "price", newPrice);
    }

    private boolean editBirdSold(String birdName, int newSold){
        return editBirdByField(birdName, "sold", newSold);
    }

    private boolean editBirdByField(String birdName, String field, Object newValue){
        Bird bird=getBirdByName(birdName);
        if(bird!=null && newValue!=null){
            if(field.equals("name") && newValue instanceof String){
                String newName =(String) newValue;
                bird.setName(newName);
                return true;
            }
            else if (field.equals("type")  && newValue instanceof BirdsType){
                BirdsType newType =(BirdsType) newValue;
                bird.setType(newType);
                return true;
            }
            else if (field.equals("price")&& newValue instanceof Double){
                Double newPrice =(Double) newValue;
                bird.setPrice(newPrice);
                return true;
            }
            else if (field.equals("count")&& newValue instanceof Integer){
                Integer newCount =(Integer) newValue;
                bird.setCount(newCount);
                return true;
            }
            if (field.equals("sold")&& newValue instanceof Integer){
                Integer newSold =(Integer) newValue;
                bird.setSold(newSold);
                return true;
            }
        }
        return false;
    }

    // sold
    public boolean soldBirds(Calendar calendar,Customer customer,String birdName,int count){
        Bird bird=getBirdByName(birdName);
        if(addTransaction(calendar,customer,bird,count)){
            editBirdSold(bird.getName(),bird.getSold()+count);
            editBirdCount(bird.getName(),bird.getCount()-count);
            System.out.println(transactionList.get(transactionList.size()-1).toString());
            return true;
        }
        return false;
    }

    public boolean soldBirds(Customer customer,String birdName,int count){
        return soldBirds(new GregorianCalendar(),customer,birdName,count);
    }

    private boolean addTransaction(Calendar calendar,Customer customer,Bird bird,int count){
         if(bird!=null && bird.getCount()>=count){
             transactionList.add(new Transaction(calendar, customer, bird, count, bird.getPrice()*count));
            return true;
        }
         return false;
    }


    //print transaction
    public void printAllTransaction(){
        for(Transaction transaction :transactionList){
            System.out.println(transaction.toString());
        }
    }

    public void printTransactionByPeriod(){
        Collections.sort(transactionList, new TransactionByDateComparator());
        for(Transaction transaction :transactionList){
            System.out.println(transaction.toString());
        }
    }


    // print birds
    public void printAllBirdsList(){
        Collections.sort(birdsList,new BirdsByNameComparator());
        for(Bird bird :birdsList){
            System.out.println(bird.toString());
        }
    }

    public void printBirdsDescPrice(){
        Collections.sort(birdsList,new BirdsByDescPriceComparator());
        printBirdsByField(new String[]{"name","price"});
    }

    public void printBirdsAscCount(){
        Collections.sort(birdsList,new BirdsByAscCountComparator());
        printBirdsByField(new String[]{"name","count"});
    }

    private void printBirdsByField(String[] fieldListForPrint){
        for(Bird bird:birdsList){
            String result="[";
            for(String field:fieldListForPrint ){
                if(field.equals("name")){
                    result=result+bird.getName()+", ";
                }
                if (field.equals("type")){
                    result=result+bird.getType()+", ";
                }
                if (field.equals("price")){
                    result=result+" price:"+bird.getPrice()+", ";
                }
                if (field.equals("count")){
                    result=result+" count:"+bird.getCount()+", ";
                }
                if (field.equals("sold")){
                    result=result+" sold:"+bird.getSold()+", ";
                }
            }
            result=result+"]";
            System.out.println(result);
        }

    }



    // Comparators

    class BirdsByAscCountComparator implements Comparator<Bird> {
        @Override
        public int compare(Bird bird1, Bird bird2) {
            int count1=bird1.getCount();
            int count2=bird2.getCount();
            if(count1>count2){
                return 1;
            }
            else if(count1<count2){
                return -1;
            }
            return 0;
        }

    }

    class BirdsByDescPriceComparator implements Comparator<Bird> {
        @Override
        public int compare(Bird bird1, Bird bird2) {
            double price1 = bird1.getPrice();
            double price2 = bird2.getPrice();
            if (price1 < price2) {
                return 1;
            } else if (price1 > price2) {
                return -1;
            }
            return 0;
        }
    }

    class BirdsByNameComparator implements Comparator<Bird> {
        @Override
        public int compare(Bird bird1, Bird bird2) {
            return bird1.getName().compareToIgnoreCase(bird2.getName());
        }
    }

    class TransactionByDateComparator implements Comparator<Transaction> {
        @Override
        public int compare(Transaction tr1, Transaction tr2) {
            Calendar c1 = tr1.getCalendar();
            Calendar c2 = tr2.getCalendar();
            if (c1.compareTo(c2) < 0) {
                return 1;
            } else if (c1.compareTo(c2) > 0) {
                return -1;
            }
            return 0;
        }
    }
}
