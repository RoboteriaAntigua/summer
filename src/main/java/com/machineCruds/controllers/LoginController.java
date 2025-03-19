package com.machineCruds.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.machineCruds.Repository.UserRepository;
import com.machineCruds.forms.FormData;
import com.machineCruds.model.User;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        model.addAttribute("formData", new FormData());

        String token = (String) session.getAttribute("token");

        if (token == null) {
            return "login";
        }

        Optional<User> user = userRepository.findByRememberToken(token);
        if (user.isPresent()) {
            System.out.println("Usuario encontrado por token");
            return "redirect:/home";
        } else {
            System.out.println("no encontro el usuario con este token");
            return "login";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("formData", new FormData());
        return "register";
    }

    @PostMapping("/registerHandle")
    public String registerHandle(@ModelAttribute FormData formData, Model model) {

        String name = (String) formData.getName();
        String email = (String) formData.getEmail();
        String password = (String) formData.getPassword();

        if(! formData.validateRegistration()) {
            model.addAttribute("message",formData.getMessage());
            return "register";
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginHandle(@ModelAttribute FormData formData, HttpSession session) {
        String email = (String) formData.getEmail();
        String password = (String) formData.getPassword();

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(password, user.getPassword())) {

                String token = UUID.randomUUID().toString();
                user.setRememberToken(token);
                session.setAttribute("token", token);

                userRepository.save(user);
                return "redirect:/home";
            }
        }
        return "erro";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        String token = (String) session.getAttribute("token");
        if (token == null || !userRepository.findByRememberToken(token).isPresent()) {
            return "redirect:/login";
        }
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String token = (String) session.getAttribute("token");
        Optional<User> user = userRepository.findByRememberToken(token);

        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setRememberToken(null);
            userRepository.save(foundUser);
        }

        session.removeAttribute("token");
        return "redirect:/login";
    }

}