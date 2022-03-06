package com.Sell_Store.demo.Repository;

import com.Sell_Store.demo.Entity.WareHouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,Long>{
    
}
