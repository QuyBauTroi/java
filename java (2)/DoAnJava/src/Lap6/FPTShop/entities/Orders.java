package Lap6.FPTShop.entities;

import java.time.LocalDate;

public class Orders {
    private static int autoId;
    private int id;

    private int productId;
    private LocalDate orderDate;

    private STATUS status;
    private int numberOfProducts;
    private int total;
    private Customer customer;

    public Orders( int productId, LocalDate orderDate, STATUS status, int numberOfProducts, int total, Customer customer) {
        this.id = ++autoId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.status = status;
        this.numberOfProducts = numberOfProducts;
        this.total = total;
        this.customer = customer;
    }


    public Orders(int id, int productId, LocalDate orderDate, STATUS status, int numberOfProducts) {
        this.id = id;
        this.productId = productId;
        this.orderDate = orderDate;
        this.status = status;
        this.numberOfProducts = numberOfProducts;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Orders.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", total=" + total +
                ", customer=" + customer +
                '}';
    }
}
