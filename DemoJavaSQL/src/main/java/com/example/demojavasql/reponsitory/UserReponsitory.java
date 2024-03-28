package com.example.demojavasql.reponsitory;

import com.example.demojavasql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface UserReponsitory extends JpaRepository<User , Integer> {
    @Query(value = "select * from User where  id = ?", nativeQuery = true)
    User findByUserID(int id);

    @Query(value = "select  * from  User where name = ?", nativeQuery = true)
    List<User> findUsersByName(String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO User(name) VALUES (?)",nativeQuery = true)
    void createUser(int roleId,String name,String phone,String email,int accoutBankId);

    @Modifying
    @Transactional
    @Query(value = "DELETE from Users where id=?",nativeQuery = true)
    void deleteUserById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Users set name = ? and email = ? and phone = ? where id =? ",nativeQuery = true)
    void updateUser(int id, String name,String email,String phone);

}
