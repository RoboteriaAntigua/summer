package roboto.machineCruds.modules.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

    /**
     * Add here the fields of your entity.
     */
    // private String name;
    // private Double price;


    /**
     * Mapper to entity
     *
     * @return
     */
    public ProductEntity mapToEntity() {
        ProductEntity entity = new ProductEntity();
//        entity.setName(this.getName());
//        entity.setPrice(this.getPrice());
        return entity;
    }
}