package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity.PaymentMethod;
import com.Sell_Store.demo.Repository.PaymentMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    public PaymentMethod addPaymentMethod(PaymentMethod paymentMethod){
        return paymentMethodRepository.save(paymentMethod);
    }
    public List<PaymentMethod> getAllPaymentMethod(){
        return paymentMethodRepository.findAll();
    }
    public PaymentMethod getByID(long id){
        return paymentMethodRepository.findById(id).get();
    }
}
