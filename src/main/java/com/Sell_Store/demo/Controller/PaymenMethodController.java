package com.Sell_Store.demo.Controller;

import java.util.List;

import com.Sell_Store.demo.Entity.Account;
import com.Sell_Store.demo.Entity.PaymentMethod;
import com.Sell_Store.demo.Services.AccountService;
import com.Sell_Store.demo.Services.PaymentMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "paymentmethod")
public class PaymenMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;
    @GetMapping("/get")
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethod(){
        List<PaymentMethod> list= paymentMethodService.getAllPaymentMethod();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    } 
    @GetMapping("/get/{payment_id}")
    public ResponseEntity<PaymentMethod> getPaymentMethod(@PathVariable(name = "tid")long id){
        PaymentMethod PaymentMethod= paymentMethodService.getByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(PaymentMethod);
    } 
    @PostMapping("/add")
    public ResponseEntity<PaymentMethod> addPaymentMethod(@RequestBody PaymentMethod PaymentMethod){
        PaymentMethod PaymentMethod2= paymentMethodService.addPaymentMethod(PaymentMethod);
        return ResponseEntity.status(HttpStatus.OK).body(PaymentMethod2);
    }
}
