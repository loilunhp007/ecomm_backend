package com.Sell_Store.demo.Controller;

import java.sql.Array;
import java.util.List;

import com.Sell_Store.demo.Entity.OrderDetail;
import com.Sell_Store.demo.Entity.OrderDetail_ID;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Services.OrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "orderdetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/get/{orderID}")
    public List<OrderDetail> getOrderDetail(@PathVariable(name = "orderID")String orderID){
            return orderDetailService.getAllOrderDetailByMahd(orderID);
    }
    @PostMapping("/add")
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetail orderDetail){
        OrderDetail orderDetail2= orderDetailService.saveDathang(orderDetail);
             return ResponseEntity.status(HttpStatus.OK).body(orderDetail2);
             

    }
    @PutMapping("/put")
    public ResponseEntity<OrderDetail> UpdateOrderDetail(@RequestBody OrderDetail orderDetail){

        OrderDetail orderDetail2= orderDetail;
        orderDetail2.setTotalItem(orderDetail.getTotalItem());
        orderDetail2.setUserPay(orderDetail.getUserPay());
        OrderDetail orderDetail3= orderDetailService.saveDathang(orderDetail2);
        return   ResponseEntity.status(HttpStatus.OK).body(orderDetail3);

    }
    @GetMapping("/get/thongkedoanhthu/{thang}")
        public ResponseEntity<List<Object>> getDoanhThu(@PathVariable(name = "thang")int thang){
            List<Object> num = orderDetailService.getThanhtien(thang);
            return ResponseEntity.status(HttpStatus.OK).body(num);    
        }
        @GetMapping("/get/thongkesoluong/{thang}/{state}")
        public ResponseEntity<List<Object>> getSoluongBan(@PathVariable(name = "thang")int thang,@PathVariable(name ="state")int state){
            List<Object> num = orderDetailService.getThongKeSoluong(thang,state);
            return ResponseEntity.status(HttpStatus.OK).body(num);    
        }
        @GetMapping("/get/thongkengay/{ngay}/{state}")
        public ResponseEntity<List<Object>> getThongKeNgay(@PathVariable(name = "ngay")String ngay,@PathVariable(name ="state")int state){
            List<Object> num = orderDetailService.thongkeDonHangNgay(ngay,state);
            return ResponseEntity.status(HttpStatus.OK).body(num);    
        }
        
}
