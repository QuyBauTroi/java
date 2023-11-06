package Lap6.FPTShop.Service;

import Lap6.FPTShop.entities.Product;
import Lap6.FPTShop.entities.STATUS;
import Lap6.Utils.Utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ProductService {
    Utils utils = new Utils();
    public void addProduct(Scanner scanner,Map<Integer,Product>productMap){
        System.out.println("Them san pham");
        System.out.println("Nhap so luong san pham ban muon them:");
        int n = utils.inputInt(scanner);
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap ten san pham thu " +(i+1)+":");
            String name = utils.inputString(scanner);
            boolean isValidStatus = false;
            STATUS status = null;
            while (!isValidStatus) {
                System.out.println("Nhap tinh trang san pham: (NEW/OLD)");
                String typeString = scanner.nextLine().toUpperCase();
                try {
                    status = STATUS.valueOf(typeString);
                    isValidStatus = true;
                } catch (Exception e) {
                    System.out.println("Tinh trang nhap vao khong hop le. Vui long nhap lai.");
                }
            }
            System.out.println("Nhap gia tien :");
            double price = utils.inputDouble(scanner);
            System.out.println("Su mieu ta :");
            String description = utils.inputString(scanner);
            System.out.println("Nhap so luong san pham thu" + (i+1) +":");
            int quantity = utils.inputInt(scanner);
            Product product = new Product(name,price,description,quantity,status);
            productMap.put(product.getId(),product);
        }


    }

    public void viewProduct(Map<Integer,Product>productMap){
        System.out.println(productMap);

    }


}
