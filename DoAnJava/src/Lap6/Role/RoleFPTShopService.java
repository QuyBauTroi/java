package Lap6.Role;

import Lap6.FPTShop.Account.SalesUser;
import Lap6.FPTShop.Account.User;
import Lap6.FPTShop.LogInOutService.SalesAccountService;
import Lap6.FPTShop.LogInOutService.UserAccountService;
import Lap6.Utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class RoleFPTShopService {
    Utils utils = new Utils();
    SalesAccountService salesAccountService = new SalesAccountService();
    UserAccountService userAccountService = new UserAccountService();

    public void roleAccount(Scanner scanner, ArrayList<SalesUser>salesUsers, ArrayList<User>Users){
        int choice;
        do {
            System.out.println("Chon role :");
            System.out.println("1. Staff Account");
            System.out.println("2. User Account");
            System.out.println("3. Manager Account");
            choice = utils.inputInt(scanner);
            switch (choice){
                case 1:
                    salesAccountService.inputMenu(scanner,salesUsers);
                    break;
                case 2:
                    userAccountService.inputMenu(scanner, Users);
            }
        }while (true);
    }
}
