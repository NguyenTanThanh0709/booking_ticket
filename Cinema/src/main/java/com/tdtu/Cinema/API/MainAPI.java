package com.tdtu.Cinema.API;


import com.tdtu.Cinema.DTO.UserDTO;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class MainAPI {

    @Autowired
    private IUserService userService;


    @PostMapping("/signup")
    public UserDTO signUp(@RequestBody UserDTO user){
        if(userService.existsBySdt(user.getSdt())){
            return null;
        }
        return userService.save(user);
    }

    @PostMapping("/signin_")
    public UserDTO signIn(@RequestBody UserDTO user, HttpSession session){
        if(userService.existsBySdt(user.getSdt())){
            session.setAttribute("user",userService.findBySdt(user.getSdt()));
            return user;
        }
        return null;
    }





    @PutMapping("signup/{id}")
    public UserDTO update(@RequestBody UserDTO user, @PathVariable("id") long id){
        user.setId(id);
        return userService.save(user);
    }


    @GetMapping("/getallUser")
    public List<UserDTO> getall(){
        return userService.getall();
    }



    @GetMapping("/getoneUser")
    public UserDTO getone(@RequestBody String email){
        return userService.getbyemail(email);
    }


}
