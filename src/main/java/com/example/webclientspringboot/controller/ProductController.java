package com.example.webclientspringboot.controller;

import com.example.webclientspringboot.model.Product;
import com.example.webclientspringboot.service.ProductsService;
import com.example.webclientspringboot.service.RecipesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductsService myService;

    public ProductController(ProductsService myService){
        this.myService = myService;
    }

    @GetMapping("")
    public ResponseEntity<?> getLimitSkipProducts(@RequestParam Integer limit,
                                                  @RequestParam Integer skip,
                                                  @RequestParam String select){
        return ResponseEntity.ok(myService.getLimitSkipProducts(limit,skip, select));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product body){
        return ResponseEntity.ok((myService.postProduct(body)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Map<String, Object> body){
        return ResponseEntity.ok(myService.updateProduct(id, body));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        return ResponseEntity.ok(myService.deleteProduct(id));
    }


}
