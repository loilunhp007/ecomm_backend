package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity.*;
import com.Sell_Store.demo.Repository.OrderDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public List<OrderDetail> getAllOrderDetailByMahd(String madh){
        return orderDetailRepository.findByOrderID(madh);
    }
    public List<OrderDetail> getAllOrder(){
        return orderDetailRepository.findAll();
    }
    public OrderDetail findByMadhAndMasp(OrderDetail_ID ctdh_Id){
        return orderDetailRepository.findById(ctdh_Id).get();
    }
    public OrderDetail saveDathang(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);

    }
    public List<Object> getThanhtien(int thang){
        return orderDetailRepository.findTotalItemGroupbyProductID(thang);
    }
    public List<Object> getThongKeSoluong(int thang,int state){
        return orderDetailRepository.thongkesoluong(thang,state);
    }
    public List<Object> thongkeDonHangNgay(String date,int state){
        return orderDetailRepository.thongkeNgay(date, state);
    }

}
