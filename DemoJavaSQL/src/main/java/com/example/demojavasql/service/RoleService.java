package com.example.demojavasql.service;

import com.example.demojavasql.entities.Role;
import com.example.demojavasql.entities.User;
import com.example.demojavasql.reponsitory.RoleReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleReponsitory roleReponsitory;
    public void findRoleByName(String name){
        Role role = roleReponsitory.findByRoleName(name);

        if (role!=null)
            System.out.println(role);
        else System.out.println("Khong tìm thấy role " + role);
    }
}
