package com.example.javaserver.controller;
import com.example.javaserver.models.LoginRegister;
import com.example.javaserver.services.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://petfindersearchlogin.herokuapp.com"}, allowCredentials = "true")
//@CrossOrigin(origins = "https://petfindersearchlogin.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "*", allowCredentials = "true")
public class LoginRegisterController {
    @Autowired
    LoginRegisterService service;

    @PostMapping("/api/users/username/{username}")
    public LoginRegister createUser(
            @PathVariable("username") String username,
            @RequestBody LoginRegister user) {
        return service.createUser(user);
//        return service.createUser(username, user);
    }

    //added by Meng Wang
    @PostMapping("/api/users/register")
    public LoginRegister register(
            @RequestBody LoginRegister credentials, HttpSession session) {
        return service.register(credentials, session);
    }

    //added by Meng Wang
    @PostMapping("/api/users/create")
    public LoginRegister createUserWithoutLogin(
            @RequestBody LoginRegister credentials) {
        return service.createUserWithoutLogin(credentials);
    }

    //added by Meng Wang
    @PostMapping("/api/users/login")
    public LoginRegister login(
            @RequestBody LoginRegister credentials,
            HttpSession session
    ) {
        return service.login(credentials, session);
    }

    //added by Meng Wang
    @PostMapping("/api/users/profile")
    public LoginRegister getCurrentUserFromSession(HttpSession session) {
//        LoginRegister currentUser = (LoginRegister)session.getAttribute("profile");
//        return currentUser;
        if(session.getAttribute("profile") != null){
            LoginRegister currentUser = (LoginRegister)session.getAttribute("profile");
            System.out.println("server: currentUser=" +  currentUser.getUsername());
            return currentUser;
        }else{
            System.out.println("server: currentUser is null");
            return new LoginRegister();
        }
    }

    //added by Meng Wang
    @PostMapping("/api/users/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }


    @GetMapping("/api/users")
    public List<LoginRegister> findAllUsers() {
        return service.findAllUsers();
    }

//    @GetMapping("/api/widgets/{wid}")
//    public Widget findWidgetForDelete(@PathVariable("wid")Long widgetId) {
//        return service.findWidgetForDelete(widgetId);
//    }

    @GetMapping("/api/users/username/{user}")
    public LoginRegister findUserbyUsername(@PathVariable("user") String user) {
        return service.findUserByUsername(user);
    }

    @GetMapping("/api/users/userid/{uid}")
    public LoginRegister findUserByUid(@PathVariable("uid") Long uid) {
        return service.findUserByUid(uid);
    }

    @DeleteMapping("/api/users/userid/{uid}")
    public Integer deleteUser(
            @PathVariable("uid")Long userId) {
        return service.deleteUser(userId);

    }

    @PutMapping("/api/users/userid/{uid}")
    public Integer updateUser(
            @PathVariable("uid") Long userId,
            @RequestBody LoginRegister user) {
        return service.updateUser(userId, user);
    }
}
