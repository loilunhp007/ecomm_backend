package com.Sell_Store.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import com.Sell_Store.demo.Entity.Cart;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Entity.UserDetail;
import com.Sell_Store.demo.Services.CartService;
import com.Sell_Store.demo.Services.ProductService;
import com.Sell_Store.demo.Services.UserService;

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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @GetMapping("/get/{uid}")
    public List<Cart> getCart(@PathVariable(name = "uid")String uid){
        UserDetail userDetail = userService.getUserDetailById(uid);
        List<Cart> carts = cartService.getCartItems(userDetail);
        return carts;
    }
    @PostMapping("/add/{pid}/{uid}")
    public ResponseEntity<String> addItem(@PathVariable(name = "pid")String pid,@PathVariable(name = "uid")String uid){
        
        UserDetail userDetail = userService.getUserDetailById(uid);
        int qt = cartService.addItem(userDetail, pid);
        JSONObject json = new JSONObject();
        json.put("string", qt+"add success");
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
    }
    @PutMapping("/put/{pid}/{uid}/{soluong}")
    public ResponseEntity<String> updateQuantityCart(@PathVariable(name = "pid")String pid,@PathVariable(name = "uid")String uid,@PathVariable(name = "soluong") int soluong){
        UserDetail userDetail = userService.getUserDetailById(uid);
        int qt = cartService.updateQuanCart(userDetail, pid,soluong);
        JSONObject json = new JSONObject();
        json.put("string",qt+"update succes");
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());

    }
    @PutMapping("/put/plus/{pid}/{uid}")
    public ResponseEntity<String> plusCart(@PathVariable(name = "pid")String pid,@PathVariable(name = "uid")String uid){
        UserDetail userDetail = userService.getUserDetailById(uid);
        int qt = cartService.plusQuanCart(userDetail, pid);
        JSONObject json = new JSONObject();
        json.put("string",qt+"update succes");
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());

    }
    @PutMapping("/put/minus/{pid}/{uid}")
    public ResponseEntity<String> minusCart(@PathVariable(name = "pid")String pid,@PathVariable(name = "uid")String uid){
        UserDetail userDetail = userService.getUserDetailById(uid);
        int qt = cartService.minusQuanCart(userDetail, pid);
        JSONObject json = new JSONObject();
        json.put("string",qt+"update succes");
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
    }     
    @DeleteMapping("/delete/{pid}/{uid}")
    public ResponseEntity<String> deleteCartItem(@PathVariable(name = "pid")String pid,@PathVariable(name = "uid")String uid){
        UserDetail userDetail = userService.getUserDetailById(uid);
        String delete = cartService.deleteCartItem(userDetail, pid);
        JSONObject json = new JSONObject();
        json.put("string",delete);
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
    }  
    @DeleteMapping("/delete/cart/{uid}")
    public ResponseEntity<String> deleteCart(@PathVariable(name = "uid")String uid){
        UserDetail userDetail = userService.getUserDetailById(uid);
        String delete = cartService.deleteCart(userDetail);
        JSONObject json = new JSONObject();
        json.put("string",delete);
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
    } 
}          
 