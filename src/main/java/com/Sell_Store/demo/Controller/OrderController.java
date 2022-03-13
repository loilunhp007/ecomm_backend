package com.Sell_Store.demo.Controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.Sell_Store.demo.Entity.Order;
import com.Sell_Store.demo.Services.OrderDetailService;
import com.Sell_Store.demo.Services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@RequestMapping(path = "order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity<List<Order>> getAllOrder() throws Exception{
        List<Order> orders = orderService.getAllOrder();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
    @GetMapping("/get/{orderID}")
    public ResponseEntity<Order> getOrderById(@PathVariable(name = "orderID")String orderID) throws Exception{
        Order order = orderService.getOrderById(orderID);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
    @GetMapping("/get/user/{uid}")
    public ResponseEntity<List<Order>> getOrderByUser(@PathVariable(name = "uid")String uid ){
        List<Order> orders = orderService.getAllOrderByTVMua(uid);
        if(orders!=null){
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(orders);
    }
    @GetMapping("/get/state/{state}")
    public ResponseEntity<List<Order>> getAllOrderByState(@PathVariable(name = "trangthai")int trangthai,@PathVariable(name = "matvban" )String uid){
        List<Order> orders = orderService.getAllOrderByStateAndUserDetail(trangthai,uid);
        if(orders!=null){
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order order2 = orderService.saveDathang(order);
        return ResponseEntity.status(HttpStatus.OK).body(order2);
        
    }
    @PutMapping("/put/{orderID}/{state}")
    public ResponseEntity<Order> updateOrder(@PathVariable(name = "orderID")String orderID,@PathVariable(name = "state")int state) throws Exception{
        Order order= new Order(); 
         order = orderService.getOrderById(orderID);
        order.setState(state);
        if(state==4){
            Date date = new Date();
            Format formatter=new SimpleDateFormat("yyyy-MM-dd");
            order.setEndTime(formatter.format(date));
        }
        Order order2 = orderService.saveDathang(order);
        return ResponseEntity.status(HttpStatus.OK).body(order2);
    }
}
