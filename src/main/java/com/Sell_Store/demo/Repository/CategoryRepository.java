package com.Sell_Store.demo.Repository;

import java.util.List;

import com.Sell_Store.demo.Entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository< Category,Integer> {
    public List<Category> findByTenloaiContains(String name);
}
