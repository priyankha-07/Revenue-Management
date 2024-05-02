package com.RevenueManagement.RevenueManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_Details")
public class EmployeeDetails {
    @Id
    @GeneratedValue
    private int id;
    private  String name;
    private String roles;
    private double sal;
    private String  doj;
}
