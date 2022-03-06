package com.Sell_Store.demo.Repository;

import java.util.List;

import com.Sell_Store.demo.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String>{
    public List<Order> findByUserDetail(UserDetail userDetail);
    public List<Order> findByStateAndUserDetail(int state,UserDetail userDetail);
    public List<Order> findByState(int state);
}
