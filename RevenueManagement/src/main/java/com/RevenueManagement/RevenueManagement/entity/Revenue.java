package com.RevenueManagement.RevenueManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "revenue")
public class Revenue {
    @Id
    @GeneratedValue
    private int id;
    private double  totalRevenue;
    private double  monthlyRevenue;
    private double profit;
    private double profitPercentage;

}

