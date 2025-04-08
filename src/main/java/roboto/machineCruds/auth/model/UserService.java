package roboto.machineCruds.auth.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import roboto.machineCruds.auth.Repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserDTO userDTO) {
        try {
            UserEntity user = new UserEntity();
            user.setUsername(userDTO.getUsername());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setEnabled(true);
            user.setEmail(userDTO.getEmail());
            userRepository.save(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
