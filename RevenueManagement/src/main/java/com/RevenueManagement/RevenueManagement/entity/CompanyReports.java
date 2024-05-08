package com.RevenueManagement.RevenueManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CompanyReports {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "company_report")
    public class Revenue {
        @Id
        @GeneratedValue
        private int id;
        private String name;
        private double  totalRevenue;
        private String date;
        private double profitPercentage;

    }


}
