package com.example.webclientspringboot.controller;

import com.example.webclientspringboot.service.ProductsService;
import com.example.webclientspringboot.service.RecipesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
