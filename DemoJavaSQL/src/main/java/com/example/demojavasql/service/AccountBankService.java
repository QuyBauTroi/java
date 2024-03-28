package com.example.demojavasql.service;

import com.example.demojavasql.entities.OpeningSchedule;
import com.example.demojavasql.reponsitory.OpeningScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class AccountBankService {
    @Autowired
    private OpeningScheduleRepository openingScheduleRepository;
    public void insertOS(Scanner scanner){
        System.out.println("Mời bạn nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Mời bạn nhập ngày bắt đầu(dd/MM/yyyy):");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Mời bạn nhập ngày học");
        String studyDay = scanner.nextLine();
        openingScheduleRepository.insertOpeningSchedule(startDate,address,studyDay);
    }
}
