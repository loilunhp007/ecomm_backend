package com.Sell_Store.demo.Repository;
import com.Sell_Store.demo.Entity.PaymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Long> {
    
}
