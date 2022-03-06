package com.Sell_Store.demo.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.Sell_Store.demo.Entity.Category;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Entity.UserDetail;
import com.Sell_Store.demo.Services.CategoryService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "products")
public class ProductController {
    private byte[] bytes;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get")
    public List<Product> getAllProduct()  {
        return this.productService.getAllProducts();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id")String id){
        Product existproduct = productService.findProductByID(id);
        if(existproduct != null){
            return ResponseEntity.status(HttpStatus.OK).body(existproduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(existproduct);

    }
    @GetMapping("/get/category/{cateID}")
    public ResponseEntity<List<Product>> getProductById(@PathVariable(name = "cateID")int id) throws Exception{
        Category category = categoryService.getByID(id);
        List<Product> products = productService.getProductByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(products);

    }
    @GetMapping("/get/state/{state}")
    public ResponseEntity<List<Product>> getProductByTrangthai(@PathVariable(name = "state")int state){
        List<Product> listProduct= productService.getProductByTrangthai(state); 
        if(listProduct != null){
            return ResponseEntity.status(HttpStatus.OK).body(listProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
    /*(@GetMapping("/get/uid/{uid}")
    public ResponseEntity<List<Product>> getProductByMatv(@PathVariable(name = "uid")String uid){
        UserDetail userDetail =  userService.getUserDetailById(uid);
        List<Product> listProduct= productService.getProductByUserDetail(userDetail); 
        if(listProduct != null){
            return ResponseEntity.status(HttpStatus.OK).body(listProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }*/
    @GetMapping("/get/us/{tensp}")
    public ResponseEntity<List<Product>> getProductByTensp(@PathVariable(name = "tensp")String tensp){
        List<Product> listProduct= productService.getProductByLikeTensp(tensp);
        if(listProduct != null){
            return ResponseEntity.status(HttpStatus.OK).body(listProduct);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product,@RequestBody MultipartFile s) throws IOException{
        Product _product = null;
        //_product.setImages(s.getBytes());
        _product = this.productService.addProduct(product);
        
        return ResponseEntity.status(HttpStatus.OK).body(_product);

    }
    @PutMapping("/put/{productID}")
    public ResponseEntity<Product> updateProductById(@PathVariable(name = "productID")String productID,@RequestBody Product product){
        Product _Product = this.productService.findProductByID(productID);
        _Product.setProductID(product.getProductID());
        _Product.setProductName(product.getProductName());
        _Product.setInfo(product.getInfo());
        _Product.setPrice(product.getPrice());
        _Product.setViews(product.getViews());
        _Product.setImages(product.getImages());
        _Product.setLikes(product.getLikes());
        _Product.setState(product.getState());
        _Product.setPercent_discount(product.getPercent_discount());
        _Product.setInventory(product.getInventory());
        Product newProduct= this.productService.addProduct(_Product);
        return ResponseEntity.status(HttpStatus.OK).body(newProduct);
    }

    @DeleteMapping("/delete/{productID}")
    public ResponseEntity<String> deteleProductById(@PathVariable(name = "productID")String productID){
        this.productService.deteleProductByID(productID);
        JSONObject obj = new JSONObject();
        obj.put("result", "success");
        return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
    }
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile[] file) throws IOException{
        String folder= "./frontend/Clothing-store/src/assets/images/products/";
        File fi = new File("");
        System.out.println("fi:"+fi.getAbsolutePath());
        for(int i=0;i<file.length;i++){
            bytes = file[i].getBytes();
            String name = file[i].getOriginalFilename();
            
        if (name != null && name.length() > 0) {
            // Create the file at server
            File serverFile = new File(folder + name);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();                    
        }
        }
       

        
      
    }
}
