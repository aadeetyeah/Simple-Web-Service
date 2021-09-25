package com.procrastinator.demo.JPADemo.service;

import com.procrastinator.demo.JPADemo.model.Product;
import com.procrastinator.demo.JPADemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    /*@Autowired means we are injecting the dependency and not doing it manually. */


    /*ProductService will do multiple functionalities. */

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return  productRepository.saveAll(products);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    /*Find the product with any attribute
    * So apart from ID if we want to search with any other attribute then
    * we need to make our custom method in our ProductRepository */

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public void deleteProduct(int id){
         productRepository.deleteById(id);
    }

    public Product updateProduct(Product product){
        Product existingProduct= productRepository.getById(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }


}
