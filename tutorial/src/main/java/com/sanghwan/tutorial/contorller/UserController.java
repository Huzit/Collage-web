package com.sanghwan.tutorial.contorller;

//import com.sanghwan.tutorial.domain.User;
import com.sanghwan.tutorial.domain.User;
import com.sanghwan.tutorial.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
       if (result.hasErrors()) {
            return "add-user";
        }
       userRepository.save(user);
       model.addAttribute("users", userRepository.findAll());
       return "index";
    }
 // additional CRUD methods
}
