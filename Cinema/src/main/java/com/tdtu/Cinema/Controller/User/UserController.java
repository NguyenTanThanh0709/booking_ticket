package com.tdtu.Cinema.Controller.User;

import com.tdtu.Cinema.Entity.*;
import com.tdtu.Cinema.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IPhimService phimService;

    @Autowired
    private IRapService rapService;

    @Autowired
    private ITinhThanhService tinhThanhService;

    @Autowired
    private ISuatChieuService suatChieuService;

    @Autowired
    private IVeService veService;

    @Autowired
    private IFoodService foodService;


    @Autowired
    private IThanhToanService thanhToanService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDanhGiaPhimService danhGiaPhimService;

    @Autowired
    private IKhuyenMaiService khuyenMaiService;



    @GetMapping("/detailfilm/{id}")
    @CrossOrigin(origins = "https://www.youtube.com")
    public  String detailfilm(Model model,@PathVariable("id") Long id){
        PhimEntity phim = phimService.findOneById(id);
        List<RapEntity> listRaps = rapService.getall();
        List<TinhThanhEntity> listTinhs = tinhThanhService.getall();
        List<SuatChieuEntity> listSuatChieu = suatChieuService.getByIdPhim(id);
        model.addAttribute("film", phim);
        model.addAttribute("tinh", listTinhs);
        model.addAttribute("rap", listRaps);
        model.addAttribute("suatchieu", listSuatChieu);

        List<PhimEntity> list = phimService.findAll();
        Collections.sort(list, (a, b) -> b.getId().compareTo(a.getId()));
        List<PhimEntity> top5 = list.subList(0, Math.min(list.size(), 5));
        model.addAttribute("phimtemp", top5);

        return "/User/detailsFilm";
    }

    @GetMapping("/foodBill/{id}")
    public  String food(Model model,@PathVariable("id") Long id){

        List<FoodEntity> listfood = foodService.getall();
        List<VeEntity> listVe = veService.getall();
        SuatChieuEntity suatchieu = suatChieuService.getByid(id);

        List<KhuyenMaiEntity> listkms = khuyenMaiService.getall();

        for (KhuyenMaiEntity km:
             listkms) {
            if(km.getTrangthai().equals("kết thúc")){
                listkms.remove(km);
            }
        }

        model.addAttribute("food", listfood);
        model.addAttribute("khuyenmai", listkms);
        model.addAttribute("ve", listVe);
        model.addAttribute("suatchieu", suatchieu);
        return "/User/foorForFilm";
    }

    @GetMapping("/muave")
    public  String muave(Model model,  HttpSession session){

        List<PhimEntity> listphim = new ArrayList<>();
        listphim = phimService.findByTrangthai("đang chiếu");
        model.addAttribute("phim",listphim);
        return "/User/muaVe";
    }


    @GetMapping("/comments/{id}")
    public String comment(Model model,@PathVariable("id") Long id){
        PhimEntity phim = phimService.findOneById(id);
        model.addAttribute("film", phim);

        List<PhimEntity> list = phimService.findAll();
        Collections.sort(list, (a, b) -> b.getId().compareTo(a.getId()));
        List<PhimEntity> top5 = list.subList(0, Math.min(list.size(), 4));
        model.addAttribute("phimtemp", top5);


        UserEnity userEnity = userService.getonrbyid(3L);
        model.addAttribute("user",userEnity);

        List<DanhGiaPhimEntity> listdanhgiaphim = danhGiaPhimService.getDanhGiaPhimByPhim(id);
        model.addAttribute("danhgiaphim",listdanhgiaphim);


        return "/User/comment";
    }



    @GetMapping("/inforuser")
    public  String inforUser(Model model){
        UserEnity userEnity = userService.getonrbyid(3L);

        List<ThanhToanEntity> list = thanhToanService.getTTUser(userEnity);
        model.addAttribute("soluongvedamua", list.size());
        model.addAttribute("thanhtoanuser",list );
        model.addAttribute("user",userEnity);
        return "/User/infoUser";
    }


}
