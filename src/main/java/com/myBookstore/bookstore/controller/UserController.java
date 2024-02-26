package com.myBookstore.bookstore.controller;

import com.myBookstore.bookstore.entity.Authority;
import com.myBookstore.bookstore.entity.User;
import com.myBookstore.bookstore.service.IAuthorityService;
import com.myBookstore.bookstore.service.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private IUserService iUserService;
    private IAuthorityService iAuthorityService;

    public UserController(IUserService theUserService, IAuthorityService theAuthorityService){
        iUserService = theUserService;
        iAuthorityService = theAuthorityService;
    }
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/showRegistration")
    public String showRegistration() {
        return "registration";
    }

    @PostMapping("/new/customer")
    public String addCustomer(@ModelAttribute("customer") User user){
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(1);
        iUserService.save(user);
        Authority newAuthority = new Authority(user.getUsername(), "ROLE_CUSTOMER");
        iAuthorityService.save(newAuthority);

        return "redirect:/showMyLoginPage?registrationSuccess";
    }
}
