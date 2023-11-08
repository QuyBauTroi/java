package Lap6.FPTShop.entities;

public class Customer {
    private static int autoId;
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private double balance;
    private Orders orders;

    public Customer( String name, String phoneNumber, String address, double balance) {
        this.id = ++autoId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = 0.0;
    }

    public Customer( String name, String phoneNumber, String address) {
        this.id = ++autoId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(int id, String name, String phoneNumber, String address, double balance, Orders orders) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = balance;
        this.orders = orders;
    }

    public Customer() {

    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Customer.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                '}';
    }
}
