package day7.Frame23HashCode;


public class Address {
    private String city;
    private String street;
    private int house;

    public Address() {
    }

    public Address(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Address){
            Address address=(Address) obj;
            if(city!=null && city.equals(address.getCity())
                    && street!=null && street.equals(address.getStreet())
                    && house>0 && house==address.getHouse()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result=25;
        result=37*result+city.hashCode();
        result=37*result+street.hashCode();
        result=37*result+house;
        return result;
    }
}
