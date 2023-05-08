package com.tdtu.Cinema.API;


import com.tdtu.Cinema.DTO.JwtReponse;
import com.tdtu.Cinema.DTO.ReponseMassage;
import com.tdtu.Cinema.DTO.UserDTO;
import com.tdtu.Cinema.Entity.RoleName;
import com.tdtu.Cinema.Entity.RolesEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Repository.RoleRepository;
import com.tdtu.Cinema.Security.jwt.JwtProvider;
import com.tdtu.Cinema.Security.userprincal.UserPrinciple;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class MainAPI {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDTO user){
        if(userService.existsBySdt(user.getSdt())){
            return new ResponseEntity<>(new ReponseMassage("Exits Phone Number!"), HttpStatus.OK);
        }

        Set<RolesEntity> roless = new HashSet<>();
        RolesEntity role = roleRepository.findByName(RoleName.USER).get();
        roless.add(role);

        UserEnity userEnity = new UserEnity();

        userEnity.setEmail(user.getEmail());
        userEnity.setSdt(user.getSdt());
        userEnity.setUser(user.getUser());
        userEnity.setPass(passwordEncoder.encode(user.getPass()));
        userEnity.setLikeRoles(roless);


        userService.save(userEnity);
        return new ResponseEntity<>(new ReponseMassage("Create Acc Success!"), HttpStatus.OK);
    }

    @PostMapping("/signin_")
    public ResponseEntity<?> signIn(@Valid @RequestBody UserDTO user, HttpSession session){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getSdt(), user.getPass()));


        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();

        String token = jwtProvider.createToken(authentication);
        //String token = "null";
        return  ResponseEntity.ok(new JwtReponse(token,userPrinciple.getUsername(), userPrinciple.getAuthorities()));
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
