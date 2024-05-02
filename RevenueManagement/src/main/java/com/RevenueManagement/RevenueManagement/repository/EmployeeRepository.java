package com.RevenueManagement.RevenueManagement.repository;

import com.RevenueManagement.RevenueManagement.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails , Integer> {
}
