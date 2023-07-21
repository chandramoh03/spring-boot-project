package com.example.emp.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import com.example.emp.system.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

    // Custom query
    @Query(value = "select * from employee e where e.name like %:keyword%OR e.address LIKE %:keyword%OR e.id LIKE %:keyword%", nativeQuery = true)
    List<Employee> findByKeyword(@Param("keyword") String keyword);

}
