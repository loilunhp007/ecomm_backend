package com.Sell_Store.demo.Services;

import java.util.List;
import java.util.Optional;

import com.Sell_Store.demo.Entity.*;
import com.Sell_Store.demo.Repository.OrderRepository;
import com.Sell_Store.demo.Repository.UserDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserDetailRepository userDetailRepository;

    public Order getOrderById(String madh) throws Exception{
        Optional<Order> op = orderRepository.findById(madh);
        if(op.isEmpty()){
            throw new Exception("not found");
        }
        else{
           return  op.get();
        }

    }
    public List<Order> getAllOrderByStateAndUserDetail(int trangthai,String matvban){
        UserDetail userDetail = userDetailRepository.findById(matvban).get();
        return orderRepository.findByStateAndUserDetail(trangthai,userDetail);
    }
    public List<Order> getAllOrderByState(int state){
        return orderRepository.findByState(state);
    }
    public List<Order> getAllOrderByTVMua(String matvmua){
        UserDetail userDetail = userDetailRepository.findById(matvmua).get();
        return orderRepository.findByUserDetail(userDetail);
    }
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
    public Order saveDathang(Order order){
         return orderRepository.save(order);

    }
}
