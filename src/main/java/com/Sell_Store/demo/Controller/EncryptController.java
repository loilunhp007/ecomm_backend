package com.Sell_Store.demo.Controller;

import java.util.List;

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

import com.Sell_Store.demo.Utils.RSA;



@Controller
@RestController
@CrossOrigin(origins = "https://pvloi-ecommerce.netlify.app")
@RequestMapping(path = "encrypt")
public class EncryptController {
    private static final String publicKey = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAxnvPjlA/K/adq6mA6+uU tlyBBxFaKeK+WD2FypOeCAP0qtucmaDrIbxirykrxQjRpGxl2HKRBwGd2h/hDuk9 CxRUXD2p0Hrzb1Hb9M5px19TPXM6AWSClR1kozehRusIFrxP6PHqDLx5prJFLlSZ zg3N3oGhS6oP/a4Ku/iAdCUCiHb5TX3b3+y4Ll/QViZhpKZjU6BhIOsiVIJhyXvn 0cSqLXPjNuXR5A4JkmRl9T9cWncEHTKmoVUyXQJaDZa3yH/OJSEmhhGyKNKkM5so lasJWSBKenFnFvphw3+KG8BGfJwGkvtRAVbS1ljduH8z8fxALxHgUdnTtgpxB+KZ /CVnNr97EGqYPLVlX+duGkuy1yCunqVTiY2HyL/0bMTBK84oCQjtMVAHgZ345hZn mGST71D8+i5HGtOOFoRyP6qK6ex1qfEROzWsmVDA00aHLlQcKOLaHvT/DB30aeUs ZoL/kQo100XccufpHESrits0mEuoyza4CCFM04F3pDOXAgMBAAE=";
    @PostMapping("/getEncrypt")
    public ResponseEntity<String> getEncrypt(@RequestBody String data) throws Exception{
            RSA rsa = new RSA();
            byte[] encryptData =  rsa.encrypt(data, publicKey);
            return ResponseEntity.status(HttpStatus.OK).body(encryptData.toString());
    } 

}