package com.example.demojavasql.reponsitory;

import com.example.demojavasql.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface CourseReponsitory extends JpaRepository<Course,Integer> {
    @Query(value = "select * from Course where price = 500000 and vote > 4 and timeline = 6",nativeQuery = true)
    List<Course>findCourseByPriceAndVote();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Course(name,timeLine,description,price,typeCourse,vote) values(?,?,?,?,?,?)",nativeQuery = true)
    void insertCourse(String name, LocalDate timeline, String escription, BigDecimal price , String typeCourse, int vote);
}
