package roboto.machineCruds.modules.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    private String name;

    @NotNull
    private Float price;

    private String message;

    public ProductEntity mapToEntity() {
        ProductEntity entity = new ProductEntity();
        entity.setName(this.getName());
        entity.setPrice(this.getPrice());
        return entity;
    }
}