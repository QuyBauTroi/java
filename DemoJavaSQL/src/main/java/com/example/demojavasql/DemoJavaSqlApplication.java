package com.example.demojavasql;

import com.example.demojavasql.entities.User;
import com.example.demojavasql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoJavaSqlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoJavaSqlApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
Scanner scanner = new Scanner(System.in);
        do {
        System.out.println("Menu");
        System.out.println("1-Insert người dùng            2-Delete người dùng");
        System.out.println("3-Update người dùng            4-Tìm kiếm người dùng");
            System.out.print("Chọn đáp án đúng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                userService.createUser(scanner);
                break;
            case 2:
                userService.deleteUser(scanner);
                break;
            case 3:
                userService.updateUser(scanner);
                break;
            case 4:
                System.out.println("Mời bạn nhập tên user muốn tìm:");
                String name  = new Scanner(System.in).nextLine();
                userService.findUserByName(name);
                break;
        }
        }while (true);
    }
}
