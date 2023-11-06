package Lap6;

import Lap6.FPTShop.Service.ProductService;
import Lap6.FPTShop.entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        Map<Integer,Product> productMap = new HashMap<>();
        productService.addProduct(scanner,productMap);

    }
}
