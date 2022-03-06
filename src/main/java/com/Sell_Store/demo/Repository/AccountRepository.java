package com.Sell_Store.demo.Repository;

import java.util.List;

import com.Sell_Store.demo.Entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    public Account findAccountByEmail(String email);
    public Account findAccountByEmailAndPassword(String email,String password);
    long count();

}
