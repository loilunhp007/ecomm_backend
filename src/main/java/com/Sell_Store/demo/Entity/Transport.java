package com.Sell_Store.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "transport")
public class Transport {
    @Id
    @Column(name = "tid",nullable = false) 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    @Column(name = "name",columnDefinition = 
    "nvarchar(50)",length = 50,nullable = false)
    private String name;
    @Column(name = "fee",columnDefinition = "double",nullable = false)
    private Double fee;

}
