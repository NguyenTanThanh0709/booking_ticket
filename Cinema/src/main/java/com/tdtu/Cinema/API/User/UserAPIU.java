package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.DTO.UserDTO;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/user")
public class UserAPIU {

    @Autowired
    private IUserService userService;

    @Autowired
    private ServletContext app;

    @PostMapping("/updateu")
    public void update(@RequestParam("user") String user,
                       @RequestParam("id") Long id,
                       @RequestParam("sdt") String sdt,
                       @RequestParam("email") String email,
                       @RequestParam("pass") String pass,
                       @RequestParam("avatar") MultipartFile avatar,
                       HttpServletResponse response) throws IOException {

        Path staticPath = Paths.get("src/main/resources/static/assets");

         File uploadDIR = new File(staticPath.toString());

         try {
             String filename = avatar.getOriginalFilename();
             File serverfile = new File(uploadDIR.getAbsoluteFile()+File.separator + filename);
             BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverfile));
             stream.write(avatar.getBytes());
             stream.close();






             UserEnity u = userService.getonrbyid(id);
             UserDTO user_ = new UserDTO(id,user,email,sdt, "../assets/" + avatar.getOriginalFilename(), pass,u.getDiemtich());
             userService.save(user_);
         }catch (Exception e){

         }

        response.sendRedirect("/inforuser");
    }
}
