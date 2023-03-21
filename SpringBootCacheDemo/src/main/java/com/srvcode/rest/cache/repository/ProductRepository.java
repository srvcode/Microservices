package com.srvcode.rest.cache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srvcode.rest.cache.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
