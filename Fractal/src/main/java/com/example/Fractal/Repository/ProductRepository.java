package com.example.Fractal.Repository;

import com.example.Fractal.Document.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//Espeficicamos el tipo de dato que vamos a utilizar y el tipo de dato del id
@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
}
