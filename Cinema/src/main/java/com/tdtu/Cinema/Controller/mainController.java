package com.tdtu.Cinema.Controller;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Mapper.PhimMapper;
import com.tdtu.Cinema.Service.IKhuyenMaiService;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class mainController {

    @Autowired
    private IKhuyenMaiService khuyenMaiService;
    @Autowired
    private IPhimService phimService;

    @Autowired
    private IUserService userService;

    @GetMapping({"/home", "/"})
    public String home(Model model,@RequestParam(defaultValue = "0") String start,@RequestParam(value = "success",required = false) String success,
                       @RequestParam(defaultValue = "10") String end, @RequestParam(defaultValue = "none") String action ,  HttpSession session)  throws IOException {



        List<PhimEntity> list = phimService.findAll();
        List<PhimDTO> listMain = new ArrayList<>();
        List<PhimDTO> listMain_dangchieu = new ArrayList<>();
        List<PhimDTO> listMain_sapchieu = new ArrayList<>();
        for (PhimEntity phim: list) {
            listMain.add(PhimMapper.toDTO(phim));
        }

        for (PhimDTO phim: listMain) {
            if(phim.getTrangthai().equalsIgnoreCase("đang chiếu")){
                listMain_dangchieu.add(phim);
            }else{
                listMain_sapchieu.add(phim);
            }
        }

        model.addAttribute("khuyenmai", khuyenMaiService.getall());



        int bd = Integer.parseInt(start);
        int kt = Integer.parseInt(end);

        if(bd < 0 ){
            bd = 0;
        }


        if(action.equalsIgnoreCase("pre")){
            int pre1 = bd-1;

            model.addAttribute("bd1", pre1);


            int next1 = bd+1;


            model.addAttribute("bd", next1);


        }else if(action.equalsIgnoreCase("next")){
            model.addAttribute("bd1", bd);

            int next1 = bd+1;

            model.addAttribute("bd", next1);

        }else {
            int next1 = bd+1;


            model.addAttribute("bd", next1);

        }



        Page<PhimEntity> list_ = phimService.Page(bd,kt);

        model.addAttribute("movieList_dangchieu", list_);

        model.addAttribute("movieList_sapchieu", listMain_sapchieu);
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error",required = false) String error,
                        @RequestParam(value = "logout",	required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out from JournalDEV successfully.");
        }
        return "Login";
    }

    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    @GetMapping("/403page")
    public String _403page() {
        return "403Page";
    }
}
