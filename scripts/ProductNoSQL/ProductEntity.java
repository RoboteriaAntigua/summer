package roboto.machineCruds.modules.Product;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
// Activate for mysql
//import jakarta.persistence.*;

import java.time.LocalDateTime;

@Document(collection = "products")
@Data
public class ProductEntity {

    @Id
    private String id;

    /**
     * Add here the fields of your entity.
     */
    // private String name;
    // private Double price;


    /**
     * Use Spring Data's @CreatedDate for automatic timestamping.
     *
     * @Field is the MongoDB equivalent of @Column. It's optional if the name matches.
     */
    @CreatedDate
    @Field("created_at")
    private LocalDateTime createdAt;

}