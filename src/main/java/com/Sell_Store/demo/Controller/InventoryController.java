package com.Sell_Store.demo.Controller;

import java.util.List;

import com.Sell_Store.demo.Entity.Inventory;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Entity.WareHouse;
import com.Sell_Store.demo.Services.InventoryService;
import com.Sell_Store.demo.Services.ProductService;
import com.Sell_Store.demo.Services.WareHouseService;

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

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private WareHouseService wareHouseService;
    @GetMapping("/get")
    public ResponseEntity<List<Inventory>> getAllInventories(){
        List<Inventory> list= inventoryService.getAllInventories();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    } 
    @GetMapping("/get/{id}")
    public ResponseEntity<Inventory> getInventoryByID(@PathVariable(name = "id")String id){
        Product p = productService.findProductByID(id);
        WareHouse w = wareHouseService.findByid(1);
        Inventory inventory = inventoryService.getInventoryByProduct(p,w);
        return ResponseEntity.status(HttpStatus.OK).body(inventory);
    } 
    @PostMapping("/add")
    public ResponseEntity<Inventory> addProductToInventory(@RequestBody Inventory inventory){
        Inventory inventory2 = inventoryService.addProductToInventory(inventory);
        return ResponseEntity.status(HttpStatus.OK).body(inventory2);
    }
   @DeleteMapping("/delete/{productID}")
   public ResponseEntity<String> deleteInventory(@PathVariable(name="productID")String productID){
       Product product = productService.findProductByID(productID);
              int result = this.inventoryService.deteleProductByID(product);
              JSONObject obj = new JSONObject();
              if(result==0){
                obj.put("result", "fail");
              }
              else{
                  obj.put("result", "success");
              }
              return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
   }
   @PutMapping("/put/{productID}/{quantity}")
   public ResponseEntity<Inventory> updateInventory(@PathVariable(name="productID")String productID,@PathVariable(name="quantity")int quantity){
    Product product = productService.findProductByID(productID); 
    WareHouse w = wareHouseService.findByid(1);  
    Inventory inventory2 = this.inventoryService.getInventoryByProduct(product,w);
    
    inventory2.setQuantity(quantity);
    this.inventoryService.addProductToInventory(inventory2);
    return ResponseEntity.status(HttpStatus.OK).body(inventory2);
   }
}
