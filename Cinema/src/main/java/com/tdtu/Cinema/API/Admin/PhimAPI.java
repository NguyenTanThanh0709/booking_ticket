package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.DTO.UserDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/admin")
public class PhimAPI {

    @Autowired
    private IPhimService phimService;
    @PostMapping("/film")
    public PhimEntity save(@RequestBody PhimDTO model){

        return phimService.save(model);
    }

    @PutMapping(value = "/film/{id}")
    public PhimEntity updateNew(@RequestBody PhimDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return  phimService.update(model);
    }

    @PostMapping("/upload-file")
    public void uploadFile(@RequestParam("file") MultipartFile avatar) {
        Path staticPath = Paths.get("src/main/resources/static/assets");

        File uploadDIR = new File(staticPath.toString());

        try {
            String filename = avatar.getOriginalFilename();
            File serverfile = new File(uploadDIR.getAbsoluteFile()+File.separator + filename);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverfile));
            stream.write(avatar.getBytes());
            stream.close();

        }catch (Exception e){

        }
    }



}
