package com.example.demojavasql.service;

import com.example.demojavasql.entities.Course;
import com.example.demojavasql.reponsitory.CourseReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseReponsitory courseReponsitory;
    public void findCourseByPriceAndVote(){
        List<Course> courseList = courseReponsitory.findCourseByPriceAndVote();
        if(courseList.isEmpty()){
            System.out.println("Khong co khoa hoc");
        }
        else {
            System.out.println("Danh sách các khóa học:");
        for (Course course : courseList) {
            System.out.println(course);
        }
        }
    }
}
