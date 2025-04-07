package roboto.machineCruds.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import roboto.machineCruds.Repository.UserRepository;
import roboto.machineCruds.model.User;
import roboto.machineCruds.request.ApiRequest;

@RestController
@RequestMapping("/api")
public class ApiController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody ApiRequest request) {

        Optional<User> ouser = userRepository.findByEmail(request.getEmail());

        if (!request.validate()) {
            return new ResponseEntity<>(request.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (ouser.isPresent()) {
            User authUser = ouser.get();
            if (passwordEncoder.matches(request.getPassword(), authUser.getPassword())) {

                String token = UUID.randomUUID().toString();
                authUser.setRememberToken(token);
                userRepository.save(authUser);
                return new ResponseEntity<>("token: " + token, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Password invalid", HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("user no found", HttpStatus.NOT_FOUND);
        }
    }

}