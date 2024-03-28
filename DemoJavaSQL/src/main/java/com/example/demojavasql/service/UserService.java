package com.example.demojavasql.service;

import com.example.demojavasql.entities.User;
import com.example.demojavasql.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;
    public void findUserById(int id){
        User user = userReponsitory.findByUserID(id);
        if (user!=null)
            System.out.println(user);
        else System.out.println("Khong tìm thấy" +id);
    }
    public void findUserByName(String name){
        List<User> users = userReponsitory.findUsersByName(name);

        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Không tìm thấy User nào có tên " + name);
        }
    }
    public void createUser(Scanner scanner){
        System.out.println("Mời bạn nhập role id:");
        int roleId = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập số đt: ");
        String phone = scanner.nextLine();
        System.out.println("Mời bạn nhập email:");
        String email = scanner.nextLine();
        System.out.println("Mời bạn nhập account banking id:");
        int accBankingId = Integer.parseInt(scanner.nextLine());
        userReponsitory.createUser(roleId,name,phone,email,accBankingId);
    }

    public void deleteUser(Scanner scanner){
        System.out.println("Mời bạn nhập id người dùng muốn xóa :");
        int id = Integer.parseInt(scanner.nextLine());
        userReponsitory.deleteUserById(id);
    }
    public void updateUser(Scanner scanner) {
        System.out.println("Mời bạn nhập id user:");
        int id = Integer.parseInt(scanner.nextLine());
        findUserById(id);
        if(userReponsitory.findByUserID(id)!=null){
            System.out.println("Mời b nhập tên b muốn thay đổi");
            String name = scanner.nextLine();
            System.out.println("Mời b nhập SĐT bạn muốn thay đổi:");
            String phone = scanner.nextLine();
            System.out.println("Mời b nhập Email b muốn thay đổi: ");
            String email = scanner.nextLine();
            userReponsitory.updateUser(id,name,email,phone);
        }
    }
}
