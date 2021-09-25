package com.procrastinator.demo.JPADemo.controller;

import com.procrastinator.demo.JPADemo.model.Product;
import com.procrastinator.demo.JPADemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;




    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addAllProduct(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/getAllProducts")
    public List<Product> fetchAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/getProductById")
    public Product fetchProductById(@RequestParam int id){
        return productService.getProductById(id);
    }

    @GetMapping("/getProductByName")
    public Product fetchProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }

    @DeleteMapping("/deleteProductById")
    public String deleteById(@RequestParam int id){
        try {
            productService.deleteProduct(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            return "Unexpected exception";
        }
        return "Data deleted successfully";
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

}

/*
* @PathVariable and @RequestParam is used to fetch data only by passing just a variable value.
* e.g. for @PathVariable
*
* @GetMapping("/getProductByName/{name}")
    public Product fetchProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
    *
    * while calling this method via Get call
    * http://localhost:9191/getProductByName?name=TV  no need use it in this way
    * Instead use the below way
    * http://localhost:9191/getProductByName/TV
* */