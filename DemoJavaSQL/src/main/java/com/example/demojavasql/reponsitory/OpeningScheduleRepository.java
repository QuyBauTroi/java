package com.example.demojavasql.reponsitory;

import com.example.demojavasql.entities.OpeningSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface OpeningScheduleRepository extends JpaRepository<OpeningSchedule,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OpeningSchedule (start_date, address, study_day) VALUES (?,?,?)",nativeQuery = true)
    void insertOpeningSchedule( LocalDate startDate,String address, String studyDay);

}
