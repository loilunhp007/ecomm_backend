package com.Sell_Store.demo.Repository;

import java.util.List;

import com.Sell_Store.demo.Entity.Cart;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Entity.UserDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

    public List<Cart> findByUserDetail(UserDetail userDetail);
    public Cart findByProductAndUserDetail(Product product,UserDetail userDetail);
}
