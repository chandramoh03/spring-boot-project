package com.example.emp.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.system.entity.Employee;
import com.example.emp.system.repository.EmpRepository;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    public void addEmployee(Employee employee) {
        empRepository.save(employee);

    }

    public List<Employee> getAllEmp() {
        return empRepository.findAll();
    }

    public Employee getEmpById(int id) {
        Optional<Employee> list = empRepository.findById(id);
        if (list.isPresent()) {
            return list.get();
        }
        return null;

    }

    public void deleteEmp(int id) {
        empRepository.deleteById(id);

    }



    public List<Employee> getByKeyword(String keyword){
        return empRepository.findByKeyword(keyword);
       }

}
