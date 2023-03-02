package com.stormsidali2001.productservice.Repository;

import com.stormsidali2001.productservice.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository  extends MongoRepository<Product,String> {
}
