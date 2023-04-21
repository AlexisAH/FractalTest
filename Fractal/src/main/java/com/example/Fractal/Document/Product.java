package com.example.Fractal.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private ObjectId id;
    private String ProductName;
    private Float UnitPrice;
    private Integer Quantity;
    private Float TotalPrice;

}
