package com.srvcode.rest.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srvcode.rest.jpa.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
