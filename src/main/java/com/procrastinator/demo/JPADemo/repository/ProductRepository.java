package com.procrastinator.demo.JPADemo.repository;

import com.procrastinator.demo.JPADemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*The Generic values for Repository means that to which Model this JPA Repo belongs.
* So Repo belongs to Product Model and
* the second Generic Type is to tell what kind of Primary key the model is going  to Hold.
* therefore, <Product,Integer>

* So here we are telling JpaRepository that to what kind of model it belongs(i.e. Product in our case.
* */

public interface ProductRepository extends JpaRepository<Product,Integer> {
/* We can extend JpaRepository or CRUDRepository
* But we go with JPA as it gives more functionalities. */
    Product findByName(String name);
}
