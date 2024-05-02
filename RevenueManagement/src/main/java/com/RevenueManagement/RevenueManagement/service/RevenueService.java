package com.RevenueManagement.RevenueManagement.service;

import com.RevenueManagement.RevenueManagement.entity.EmployeeDetails;
import com.RevenueManagement.RevenueManagement.repository.EmployeeRepository;
import com.RevenueManagement.RevenueManagement.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RevenueService {
@Autowired
    private EmployeeRepository repository;
@Autowired
private RevenueRepository revenueRepository;

    public List<EmployeeDetails> getAllEmployeeInfo() {
        return repository.findAll();
    }
    public EmployeeDetails  getEmployeedetailById(int id){
        return repository.findById(id).orElse(null);
    }
    public List<EmployeeDetails> saveAllEmployeeDetails(List<EmployeeDetails> employees){
        return repository.saveAll(employees);
    }
    public EmployeeDetails saveEmployeeDetail(EmployeeDetails employee){
        return repository. save(employee);
    }
    public EmployeeDetails updateEmployeeDetail (EmployeeDetails employee){
        EmployeeDetails e = repository.findById(employee.getId()).orElse(null);
        e.setName(employee.getName());
        e.setRoles(employee.getRoles());
        e.setSal(employee.getSal());
        e.setDoj(employee.getDoj());
        return repository.save(e);

    }
    public String deleteEmployeeDetails(int id){
        repository.deleteById(id);
        return "deleted successfully"+id;
    }
}
