package com.src.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.app.domain.User;
import com.src.app.services.UserServiceImp;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return"redirect:/users";
    }

    @GetMapping("/list")
    public String getUsers(Model model){
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
