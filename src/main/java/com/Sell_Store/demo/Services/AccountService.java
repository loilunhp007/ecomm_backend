package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity.Account;
import com.Sell_Store.demo.Repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }
    public Account addAccount(Account taikhoan){
        return accountRepository.save(taikhoan);
    }
    public Account findAccountByID(Long id){
        return accountRepository.findById(id).get();
    }
    public Account findAccountByEmail(String email){
        return accountRepository.findAccountByEmail(email);
    }
    public Account findAccountByEmailAndMatkhau(String email,String password) throws Exception{
        return accountRepository.findAccountByEmailAndPassword(email,password);
    }
    public long count(){
        return accountRepository.count();
    }
    public String deteleUser(Long uid){
        Account tk = accountRepository.findById(uid).get();
         accountRepository.delete(tk);
         return "xoa success";
    }
    
    
}
