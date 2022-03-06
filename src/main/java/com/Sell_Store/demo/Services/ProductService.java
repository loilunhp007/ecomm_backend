package com.Sell_Store.demo.Services;

import java.util.List;
import java.util.Optional;

import com.Sell_Store.demo.Entity.Category;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Entity.UserDetail;
import com.Sell_Store.demo.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public Product findProductByID(String id){
        Optional<Product> op = productRepository.findById(id);
        if(op.isEmpty()){
            return null;
        }
        return op.get();
    }
    public void deteleProductByID(String id){
        productRepository.deleteById(id);
    }
    public List<Product> getProductByTrangthai(int trangthai){
        return productRepository.findByState(trangthai);
    }   public List<Product> getProductByLikeTensp(String tensp){
        return productRepository.findByProductNameContains(tensp);
    }
   public List<Product> getProductByCategory(Category category){
    return productRepository.findByCategory(category);
}
}
