package com.example.goodbyelion10th.controller;

import com.example.goodbyelion10th.domain.Users;
import com.example.goodbyelion10th.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    // 회원 등록
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

    // 회원 조회
    @GetMapping("/users/list")
    public String list(Model model) {
        List<Users> userList = userService.findUsers();
        model.addAttribute("userList", userList); // view에 (key, value) 쌍으로 데이터 전달

        return "users/userList.html";
    }
}
