package com.Sell_Store.demo.Repository;

import java.util.List;

import com.Sell_Store.demo.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    public List<Product> findByState(int trangthai);
    public List<Product> findByProductNameContains(String tensp);
    public List<Product> findByCategory(Category category);
    
}   
