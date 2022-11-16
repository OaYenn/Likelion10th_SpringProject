package com.example.goodbyelion10th.controller;

import com.example.goodbyelion10th.domain.Users;
import com.example.goodbyelion10th.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String createForm() {
        return "users/createUserForm.html";
    }

    @PostMapping("/users/new")
    public String create(UserForm form) {
        Users user = new Users();
        user.setNickname(form.getNickname());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        System.out.println("user = " + user.getNickname());

        Long userId = userService.join(user);
        System.out.println("userId = " + userId);

        return "redirect:/home";
    }
}
