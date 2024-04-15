package com.example.demojavasql.reponsitory;

import com.example.demojavasql.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface RoleReponsitory extends JpaRepository<Role,Integer> {
    @Query(value = "select * from  Role where name = ?", nativeQuery = true)
    Role findByRoleName(String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Role(name) VALUES (?)",nativeQuery = true)
    void createRole(String name);
}
