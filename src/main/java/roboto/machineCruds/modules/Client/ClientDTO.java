package roboto.machineCruds.modules.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {

    @NotBlank
    private String name;

    @NotNull
    private Float price;

    private String message;

    public ClientEntity mapToEntity() {
        ClientEntity entity = new ClientEntity();
        entity.setName(this.getName());
        entity.setPrice(this.getPrice());
        return entity;
    }
}
