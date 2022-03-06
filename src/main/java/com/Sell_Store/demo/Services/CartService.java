package com.Sell_Store.demo.Services;

import java.util.List;
import java.util.Optional;

import com.Sell_Store.demo.Entity.Cart;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Entity.UserDetail;
import com.Sell_Store.demo.Repository.CartRepository;
import com.Sell_Store.demo.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(rollbackFor = Exception.class)
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    
    public List<Cart> getCartItems(UserDetail userDetail){
        return this.cartRepository.findByUserDetail(userDetail);
    }
    public Cart getCartById(int id){
        return cartRepository.findById(id).get();
    }

    public int addItem(UserDetail userDetail,String masp){
            int soluong=1;
         Product product = productRepository.findById(masp).get();
         Cart cart = cartRepository.findByProductAndUserDetail(product, userDetail);
        if(cart !=null){
                soluong = cart.getSoluong()+1;
                cart.setSoluong(soluong);
            }else{
                cart = new Cart();
                cart.setProduct(product);
                cart.setUserDetail(userDetail);
                cart.setSoluong(soluong);
            }
        cartRepository.save(cart); 
        return soluong;
    }
    public String deleteCartItem(UserDetail userDetail,String masp){
            Product product = productRepository.findById(masp).get();
            Cart cart = cartRepository.findByProductAndUserDetail(product, userDetail);
            cartRepository.delete(cart);
            return "delete Sucess";
    }
    public String deleteCart(UserDetail userDetail){
        List<Cart> carts = cartRepository.findByUserDetail(userDetail);
        for(int i=0;i<carts.size();i++){
            cartRepository.delete(carts.get(i));
        }
        return "delete Sucess";
}
    public int plusQuanCart(UserDetail userDetail,String masp){
        Product product = productRepository.findById(masp).get();
        Cart cart = cartRepository.findByProductAndUserDetail(product, userDetail);
        int soluong = cart.getSoluong()+1;
        cart.setSoluong(soluong);
        cartRepository.save(cart);
        return soluong;
    }
    public int minusQuanCart(UserDetail userDetail,String masp){
        Product product = productRepository.findById(masp).get();
        Cart cart = cartRepository.findByProductAndUserDetail(product, userDetail);
        int soluong = cart.getSoluong()-1;
        cart.setSoluong(soluong);
        cartRepository.save(cart);
        return soluong;
    }
    public int updateQuanCart(UserDetail userDetail,String masp,int soluong){
        Product product = productRepository.findById(masp).get();
        Cart cart = cartRepository.findByProductAndUserDetail(product, userDetail);
        cart.setSoluong(soluong);
        cartRepository.save(cart);
        return soluong;
    }
    
}
