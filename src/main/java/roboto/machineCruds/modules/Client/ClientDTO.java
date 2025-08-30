package roboto.machineCruds.modules.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {


    /**
     * Add here the fields of your entity.
     */
    private String name;
    private Double price;


    /**
     * Mapper to entity
     *
     * @return
     */
    public ClientEntity mapToEntity() {
        ClientEntity entity = new ClientEntity();
        entity.setName(this.getName());
        entity.setPrice(this.getPrice());
        return entity;
    }
}
