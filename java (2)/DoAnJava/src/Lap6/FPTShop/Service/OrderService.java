package Lap6.FPTShop.Service;

import Lap6.FPTShop.entities.Customer;
import Lap6.FPTShop.entities.Orders;
import Lap6.FPTShop.entities.Product;
import Lap6.FPTShop.entities.STATUS;
import Lap6.Utils.Utils;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class OrderService {
    ProductService service = new ProductService();
    Utils utils = new Utils();



    public void order(Map<Integer,Product>productMap, Scanner scanner,Customer customer){
        while (true){

            //Nhap san pham mua
            System.out.println("Nhap id  san pham ban muon mua:");
            Product product = new Product(service.findProductById(productMap,scanner).getName());
            int productId = utils.inputInt(scanner);
            System.out.println("Nhap so luong san pham muon order:");
            int numberOfProducts = utils.inputInt(scanner);
            product.setDescription(String.valueOf(product.getQuantity() - numberOfProducts));
            if (product.getQuantity() ==  0 ){
                System.out.println("San pham da het hang");
            } else if (product.getQuantity()< numberOfProducts) {
                System.out.println("Ban da order qua so luong san pham trong kho , vui long chon lai:");
            }
            LocalDate orderDate = LocalDate.now();
            System.out.println("Ngay mua: "+orderDate);


            ///////////////////////////////Nhap Status /////////////////////////////////////////
            boolean isValidStatus = false;
            STATUS status = null;
            while (!isValidStatus) {
                System.out.println("Nhap tinh trang san pham: (NEW/OLD)");
                String typeString = scanner.nextLine().toUpperCase();
                try {
                    status = STATUS.valueOf(typeString);
                    isValidStatus = true;

                    boolean foundMatchingStatus = false;
                    for (Product product1 : productMap.values()) {
                        if (product1.getStatus() == status) {
                            foundMatchingStatus = true;
                            break;
                        }
                    }
                    if (!foundMatchingStatus) {
                        System.out.println("Không có sản phẩm có tình trạng này. Vui lòng nhập lại.");
                        isValidStatus = false;
                    }


                } catch (Exception e) {
                    System.out.println("Tinh trang nhap vao khong hop le. Vui long nhap lai.");
                }

            }


            //////////////////////////// Thanh toan don hang ///////////////////////////////
            System.out.println("Moi bạn chon phuong thuc thanh toan:");
            System.out.println("1. Thanh toan qua tin dung");
            System.out.println("2. Thanh toan truc tiep");
            int choice = utils.inputInt(scanner);
            switch (choice){
                case 1:
                    creditPayment();
                    break;
                case 2:
                    directPayment();
                    break;
                default:
                    System.out.println("Nhap sai cu phap , vui long nhap lai:");
            }

            System.out.println("Ban co muon tiep tuc mua hang ? (Y/N)");
            if (utils.inputString(scanner).equalsIgnoreCase("n")){
                break;
            }
            Orders orders = new Orders(productId,numberOfProducts,orderDate,status,numberOfProducts);
            customer.setOrders(orders);
        }
    }



    public void creditPayment(){

    }
    public void directPayment(){

    }

}
