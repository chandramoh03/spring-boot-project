package com.example.emp.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.emp.system.entity.Employee;
import com.example.emp.system.service.EmpService;


@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> list = empService.getAllEmp();
        model.addAttribute("list",list);
        return "index";
    }

    @GetMapping("/add_emp")
    public String addemp() {
        return "add_emp";
    }

    @PostMapping("register")
    public String empRegister(@ModelAttribute Employee employee) {
        empService.addEmployee(employee);
        
        
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){

        Employee employee= empService.getEmpById(id);
        model.addAttribute("emp", employee);
        return "edit";

    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee){
        empService.addEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable  int id){
         empService.deleteEmp(id);
         return "redirect:/";

    }
    


    @RequestMapping(path = {"/","/search"})
    public String home(Employee employee, Model model, String keyword) {
     if(keyword!=null) {
      List<Employee> list = empService.getByKeyword(keyword);
      model.addAttribute("list", list);
     }else {
     List<Employee> list = empService.getAllEmp();
     model.addAttribute("list", list);}
     return "index";
    }

}
