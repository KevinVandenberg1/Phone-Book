public class PhoneNode {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phoneNumber;

    PhoneNode next;
    PhoneNode prev;

    public PhoneNode() {

    }

    public PhoneNode(String firstName, String lastName, String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public PhoneNode(String firstName, String lastName, String address, String city, String phoneNumber, PhoneNode next) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = next;
    }

    public PhoneNode(String firstName, String lastName, String address, String city, String phoneNumber, PhoneNode next, PhoneNode prev) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = next;
        this.prev = prev;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getAddress() {
        return this.address;
    }
    public String getCity() {
        return this.city;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        String temp = String.format("_____________%n %s%s%n %s%s%n %s%s%n %s%s%n %s%s%n",
        "First Name: ", getFirstName(),
        "Last Name: ", getLastName(),
        "City: ", getCity(),
        "Address: ", getAddress(),
        "Phone Number ", getPhoneNumber());
        return temp;
    }
}
