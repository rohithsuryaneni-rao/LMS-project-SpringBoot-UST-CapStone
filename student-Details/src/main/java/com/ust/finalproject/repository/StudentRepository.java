package com.ust.finalproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ust.finalproject.model.Student;
public interface StudentRepository extends JpaRepository<Student,Integer>
{
	List<Student> findByStudentName(String StudentName);
}