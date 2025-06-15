package roboto.machineCruds.modules.Llave;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LlaveDTO {

    @NotBlank
    private String name;

    @NotNull
    private Float price;

    private String message;

    public LlaveEntity mapToEntity() {
        LlaveEntity entity = new LlaveEntity();
        entity.setName(this.getName());
        entity.setPrice(this.getPrice());
        return entity;
    }
}
