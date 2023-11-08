package Lap6.FPTShop.LogInOutService;

import Lap6.FPTShop.Account.SalesUser;
import Lap6.FPTShop.Account.User;
import Lap6.FPTShop.Service.FPTShopService;
import Lap6.FPTShop.entities.Customer;
import Lap6.Utils.Utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class UserAccountService extends FPTShopService {
    SalesAccountService salesAccountService = new SalesAccountService();
    private User currentUser;
    Utils utils = new Utils();


    public  void inputMenu(Scanner scanner, ArrayList<User> Users){
        int choose;
        do {
            System.out.println("Chon mot tuy chon:");
            System.out.println("1. Dang nhap");
            System.out.println("2. Dang ky");
            System.out.println("Enter your choice:");

            choose = utils.inputInt(scanner);
            switch (choose) {
                case 1:
                    login(scanner, Users);
                    break;
                case 2:
                    register(scanner, Users);
                    break;
                default:
                    System.out.println("Lua chon khong hop len , vui long nhap lai");
                    break;
            }
        }while (true);
    }


    // Log In Start ------------------------------------------------------------------------------------------------
    // Phan dang nhap
    public void login(Scanner scanner, ArrayList<User> Users){
        System.out.println("Dang nhap");
        System.out.println("Nhap usename :");
        String username = utils.inputString(scanner);
        System.out.println("Nhap password :");
        String password = utils.inputString(scanner);

        User User = findUserByUsername(username,Users);
        if (User == null) {
            System.out.println("Kiem tra lai username");
        }else if (!User.getPassword().equals(password)){
            int choice;
            do{
                System.out.println("Nhap sai password");
                System.out.println("Chon 1 tuy chon:");
                System.out.println("1. Dang nhap lai");
                System.out.println("2. Quen mat khau");
                choice= utils.inputInt(scanner);
                switch (choice){
                    case 1:
                        login(scanner, Users);
                        return;
                    case 2:
                        forgotPassword(scanner,Users);
                        return;
                    default:
                        System.out.println("Lua chon khong hop le");
                        break;
                }
            }while (true);
        }else {
            currentUser = User;
            System.out.println("Chao mung " + User.getUsername() + ", ban co the thuc hien cong viec sau:");
            int choice;
            do {
                System.out.println("1. Thay doi username");
                System.out.println("2. Thay doi email");
                System.out.println("3. Thay doi mat khau");
                System.out.println("4. Dang xuat");
                System.out.println("0. Vao trang chu ");
                choice = utils.inputInt(scanner);
                switch (choice){
                    case 1:
                        changeUsername(scanner,Users);
                        break;
                    case 2:
                        changeEmail(scanner,Users);
                        break;
                    case 3:
                        changePassword(scanner);
                        break;
                    case 4:
                        inputMenu(scanner, Users);
                        return;
                    case 0:
                        inputCustomerAccount(scanner, (Map<Integer, Customer>) Users);
                    default:
                        System.out.println("Lua chon khong hop le, vui long chon lai:");
                        break;
                }
            }while (true);
        }
    }



    // phan quen mk
    private  void forgotPassword(Scanner scanner,ArrayList<User> Users){
        System.out.println("Quen mat khau");
        System.out.println("Moi ban nhap email :");
        String email = utils.inputString(scanner);
        if (findUserByEmail(email,Users) == null){
            System.out.println("Email khong ton tai ");
        }else {
            System.out.println("Nhap mat khau moi:");
            String newPassword = utils.inputString(scanner);
            findUserByEmail(email,Users).setPassword(newPassword);
            System.out.println("Doi mat khau thanh cong");
        }
    }

    private void changeUsername(Scanner scanner,ArrayList<User> Users){
        System.out.println("Nhap username moi:");
        String newUsername = utils.inputString(scanner);
        if (findUserByUsername(newUsername,Users) != null){
            System.out.println("Username da ton tai , vui long nhap lai:");
            changeUsername(scanner,Users);
        }else{
            currentUser.setUsername(newUsername);
            System.out.println("Thay doi thanh cong");

        }
    }

    private void changePassword(Scanner scanner){
        System.out.println("Nhap password moi:");
        String newPassword = utils.inputString(scanner);
        if (!salesAccountService.isValidPassword(newPassword)){
            System.out.println("Mat khau khong hop le , vui long nhap lai:");
            changePassword(scanner);
        }else{
            currentUser.setPassword(newPassword);
            System.out.println("Thay doi thanh cong");
        }
    }

    private void changeEmail(Scanner scanner,ArrayList<User> Users){
        System.out.println("Nhap email moi:");
        String newEmail = utils.inputString(scanner);
        if (!salesAccountService.isValidEmail(newEmail)){
            System.out.println("Mat khau khong hop le , vui long nhap lai:");
            changeEmail(scanner,Users);
        }else if (findUserByEmail(newEmail,Users) != null){
            System.out.println("Email da ton tai, vui long nhap lai:");
            changeEmail(scanner,Users);
        }
        else{
            currentUser.setEmail(newEmail);
            System.out.println("Thay doi thanh cong");
        }
    }
// Log In End ------------------------------------------------------------------------------------------------------







// Register Starts --------------------------------------------------------------------------------------------------

    public void register(Scanner scanner, ArrayList<User> Users){
        System.out.println("Tao tai khoan moi");
        System.out.println("Nhap username moi:");
        String username = utils.inputString(scanner);
        System.out.println("Nhap email :");
        String email= utils.inputString(scanner);
        System.out.println("Nhap mat khau :");
        String password = utils.inputString(scanner);
        if (findUserByUsername(username,Users) != null){
            System.out.println("Username da ton tai, vui long nhap lai:");
        }else if (findUserByEmail(email,Users) != null){
            System.out.println("Email da ton tai, vui long nhap lai:");
        }else if (!salesAccountService.isValidEmail(email)){
            System.out.println("Email khong hop le, vui long nhap lai:");
        }else if (!salesAccountService.isValidPassword(password)){
            System.out.println("Mat khau khong hop le, vui long nhap lai :");
        }else {
            User newUser = new User(username,email,password);
            Users.add(newUser);
            System.out.println("Tao tai khoan thanh cong ");
            inputMenu(scanner, Users);
        }
    }








// Register End -----------------------------------------------------------------------------------------------------

    private User findUserByUsername(String username, ArrayList<User> Users){
        for (User User : Users) {
            if (User.getUsername().equals(username)) {
                return User;
            }
        }
        return null;
    }

    private User findUserByEmail(String email,ArrayList<User> Users) {
        for (User User : Users) {
            if (User.getEmail().equals(email)) {
                return User;
            }
        }
        return null;
    }

}
