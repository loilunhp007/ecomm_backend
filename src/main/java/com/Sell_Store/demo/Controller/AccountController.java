package com.Sell_Store.demo.Controller;

import java.util.List;

import com.Sell_Store.demo.Entity.Account;
import com.Sell_Store.demo.Services.AccountService;

import org.json.JSONObject;
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
@RequestMapping(path = "user")
public class AccountController {
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/get")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }
    @PostMapping("/add")
    public ResponseEntity<Account> addaccount(@RequestBody Account user ) throws Exception{ 
        Account _account = accountService.addAccount(user);
        return ResponseEntity.status(HttpStatus.OK).body(_account);
        
        
    }
    @GetMapping("/get/{id}") 
    public ResponseEntity<Account> findUserByID(@PathVariable(name = "id")Long id) throws Exception{
        Account account =null;
        
        if (id !=  null){
            account = accountService.findAccountByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(account);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(account);
    }
    
    @PutMapping("/put/{uid}")
    public ResponseEntity<Account> updateThanhVienByID(@PathVariable(name = "uid")Long id, @RequestBody Account account){
        Account  _account =accountService.findAccountByID(id);
        _account.setPassword(account.getPassword());
        _account.setEmail(account.getEmail());
        _account.setState(account.getState());
        Account account2 = accountService.addAccount(_account);
        return ResponseEntity.status(HttpStatus.OK).body(account2);
    }
    @PostMapping("/checkExistUser")
    public ResponseEntity<String> checkExistUser(@RequestBody Account account) throws Exception{
        Account  _account =accountService.findAccountByEmail(account.getEmail());
        JSONObject obj =new JSONObject();
        if(_account!=null){
            obj.put("user", "exist");
            return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
        }else{
            obj.put("user", "empty");
            return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
        }
    }
    

    @PostMapping("/login")
    public ResponseEntity<Account> loginUser(@RequestBody Account account) throws Exception{
        Account existAccount = null ;
        System.out.println(account);
        System.out.println("nek");
        if (account.getEmail() != null && account.getPassword() != null){
             existAccount = accountService.findAccountByEmailAndMatkhau(account.getEmail(),account.getPassword());
            if(existAccount == null){
                 String message = "Username"+account.getEmail()+"not exist";   
                 System.out.println(message);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(existAccount);
            }
        }
            return ResponseEntity.status(HttpStatus.OK).body(existAccount);
    }
    
    @GetMapping("/getMax")
    public ResponseEntity<Long> getMaxUser(){
        long count = accountService.count();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }
    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<String> deteleUser(@PathVariable(name = "uid")long uid){
        
       return ResponseEntity.status(HttpStatus.OK).body(accountService.deteleUser(uid));
    }
}
