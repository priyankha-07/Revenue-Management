package com.RevenueManagement.RevenueManagement.repository;

import com.RevenueManagement.RevenueManagement.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueRepository extends JpaRepository<Revenue ,Integer> {
}
