package roboto.machineCruds.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import roboto.machineCruds.auth.Repository.UserRepository;

@Data
public class UserDTO {

    @NotBlank(message = "* Username cannot be null")
    @Size(min = 2, max = 30, message = "* Username must be between 2 and 30 characters")
    private String username;

    private String email;

    @NotBlank(message = "* Password cannot be null")
    @Size(min = 2, message = "* Password must be between 2 and 30 characters")
    private String password;

}