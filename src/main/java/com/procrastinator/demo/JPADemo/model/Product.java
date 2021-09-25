package com.procrastinator.demo.JPADemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*Model class */

@Data
@Entity
@Table(name="product")
public class Product {

    /*@Id ==> Annotation used for making the variable id unique like PRIMARY KEY in DBMS
    * @GeneratedValue ==> auto increment/auto generated the value to keep it unique */
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int quantity;
    private double price;
}
