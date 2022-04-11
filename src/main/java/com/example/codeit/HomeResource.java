package com.example.codeit;

import com.example.codeit.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeResource {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user")
    public String user(){
        return "userhome";
    }

    @GetMapping("/admin")
    public String admin(){
        return "adminhome";
    }

    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }

    //sign up for users
    @GetMapping("/signup")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
        user.setRoles("ROLE_USER");
        user.setActive(true);
        userRepo.save(user);
        return "signup";
    }

    //sign up for organization

    @GetMapping("/signuporg")
    public String registerOrg(Model model){
        model.addAttribute("user", new User());
        return "signuporg";
    }

    @PostMapping("/process_register_org")
    public String processRegisterOrg(User user){
        user.setRoles("ROLE_ADMIN");
        user.setActive(true);
        userRepo.save(user);
        return "signuporg";
    }

    @GetMapping("/admin/test")
    public String test(){
        return "userhome";
    }

    @PostMapping("/admin/createtest")
    public String createTest(){


        return "adminhome";
    }

}
