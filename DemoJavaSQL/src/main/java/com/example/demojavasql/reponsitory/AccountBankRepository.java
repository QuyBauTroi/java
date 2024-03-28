package com.example.demojavasql.reponsitory;

import com.example.demojavasql.entities.AccountBanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface AccountBankRepository extends JpaRepository<AccountBanking,Integer> {
    @Query(value = "INSERT INTO AccountBanking(nameBank,accoutNum) values(?,?)",nativeQuery = true)
    void insertAccountBank(String nameBank, BigDecimal accoutNum);
}
