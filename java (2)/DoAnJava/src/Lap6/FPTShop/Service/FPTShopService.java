package Lap6.FPTShop.Service;

import Lap6.FPTShop.entities.Customer;
import Lap6.FPTShop.entities.Product;
import Lap6.Utils.Utils;
import Lap6.FPTShop.entities.Staff;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FPTShopService {
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    Utils utils = new Utils();
    Map<Integer, Product>productMap = new HashMap<>();
    public void inputStaffAccount(Scanner scanner, Map<Integer, Staff>staffMap){
        System.out.println("Moi ban xac thuc thong tin cho tai khoan:");
        System.out.println("Nhap ho va ten :");
        String name = utils.inputString(scanner);
        System.out.println("Nhap so dien thoai :");
        String phoneNumber = utils.inputString(scanner);
        System.out.println("Nhap dia chi nha :");
        String address = utils.inputString(scanner);
        System.out.println("Nhap email");
        String email =utils.inputString(scanner);
        Staff staff = new Staff(name,phoneNumber,address,email);
        staffMap.put(staff.getId(),staff);
        System.out.println("Chao mung"+ staff.getName() + ", ban co the thuc hien cong viec sau:");
        int choice;
        do {
            System.out.println("1. Xem thong tin tat ca san pham");
            System.out.println("2. Xem thong tin tat ca don hang");
            System.out.println("3. Chinh sua thong tin don hang");
            System.out.println("4. Xem thong tin Khach hang");
            System.out.println("5. Chinh sua thong tin khach hang");
            choice = utils.inputInt(scanner);
            switch (choice){
                case 1:
                    productService.viewProduct(productMap);
                    break;
                case 2:
            }
        }while (true);
    }

    public void inputCustomerAccount(Scanner scanner, Map<Integer, Customer>customerMap){
        System.out.println("Moi ban xac thuc thong tin cho tai khoan:");
        System.out.println("Nhap ho va ten :");
        String name = utils.inputString(scanner);
        System.out.println("Nhap so dien thoai :");
        String phoneNumber = utils.inputString(scanner);
        System.out.println("Nhap dia chi nha :");
        String address = utils.inputString(scanner);
        Customer customer = new Customer(name,phoneNumber,address);
        System.out.println("Ban co muon nap tien vào tai khoan khong ? (Y/N)");
        String choice = utils.inputString(scanner);
        if (choice.equalsIgnoreCase("y")){
            System.out.println("Moi ban nhap so tien muon nap vao:");
            double amount = utils.inputDouble(scanner);
            customer.addBalance(amount);
            System.out.println("Nap tien thanh cong");
        }
        customerMap.put(customer.getId(),customer);
        System.out.println("Chao mung"+ customer.getName() + ", ban co the thuc hien cong viec sau:");
        int choose;
        do {
            System.out.println("1. Xem thong tin tat ca san pham");
            System.out.println("2. Xem thong tin don hang cua ban than");
            System.out.println("3. Order san pham");
            System.out.println("4. Xem thong tin ca nha");
            System.out.println("5. Chinh sua thong tin ca nhan");
            choose = utils.inputInt(scanner);
            switch (choose){
                case 1:
                    productService.viewProduct(productMap);
                    break;
                case 2:
                case 3:
                    orderService.order(productMap,scanner,customer);
        }
    }while (true);
    }

}