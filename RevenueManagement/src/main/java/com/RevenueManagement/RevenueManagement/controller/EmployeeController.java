package com.RevenueManagement.RevenueManagement.controller;

import com.RevenueManagement.RevenueManagement.entity.EmployeeDetails;
import com.RevenueManagement.RevenueManagement.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revenue")
public class EmployeeController {
 @Autowired
    private RevenueService service;
    @PostMapping("/add/ListOfEmployees")
    public List<EmployeeDetails> addEmployeeDetails(@RequestBody List<EmployeeDetails> employees) {
        return service.saveAllEmployeeDetails(employees);
    }
    @PostMapping("/add/DetailOfEmployee")
    public EmployeeDetails addEmployeeDetail(@RequestBody EmployeeDetails employee) {
        return service.saveEmployeeDetail(employee);
    }
    @GetMapping("/display/AllEmployeeDetails")
    public List<EmployeeDetails> findAllEmployees() {
        return service.getAllEmployeeInfo();
    }
    @GetMapping("/display/EmployeeById/{id}")
    public EmployeeDetails findEmployeeById(@PathVariable int id) {
        return service.getEmployeedetailById(id);
    }
    @PutMapping("/update/employeeDetail")
    public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
        return service.updateEmployeeDetail(employeeDetails);
    }
    @DeleteMapping("/delete/employeeDetails/{id}")
    public String deleteEmployeeDetailById(@PathVariable int id){
        service.deleteEmployeeDetails(id);
        return "Successfully deleted";
    }
}
