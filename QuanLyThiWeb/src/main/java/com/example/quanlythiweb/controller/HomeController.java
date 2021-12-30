package com.example.quanlythiweb.controller;

import BUS.KhoaThiBUS;
import BUS.ThiSinhBUS;
import BUS.TrinhDoBUS;
import DTO.KhoaThiDTO;
import DTO.ThiSinhDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = {"/", "/dangky"})
    public String dangKy(Model model){
        TrinhDoBUS trinhDoBUS = new TrinhDoBUS();
        model.addAttribute("trinhDos", trinhDoBUS.getList());
        return "dangky";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dangky")
    public String themDangKy(@RequestParam String TrinhDo, String HoTenThiSinh, String GioiTinh, String NgaySinh,
                             String CMND, String NgayCap, String NoiCap, String SDT, String Mail, String DiaChi,
                             RedirectAttributes redirectAttributes){

        /*try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date tgBD = simpleDateFormat.parse(ngayKH);
            Date tgKT = simpleDateFormat.parse(ngayKT);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ngayKH = format.format(tgBD);
            ngayKT = format.format(tgKT);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateNow = simpleDateFormat.format(date);

        KhoaThiBUS khoaThiBUS = new KhoaThiBUS();
        ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
        String maThiSinh = thiSinhBUS.capPhat();

        ArrayList<KhoaThiDTO> khoaThiDTOs = khoaThiBUS.khoaThiDAO.getList();
        khoaThiDTOs.sort(new Comparator<KhoaThiDTO>() {
            @Override
            public int compare(KhoaThiDTO o1, KhoaThiDTO o2) {
                return o1.getNgayThi().compareTo(o2.getNgayThi());
            }
        });

        for (KhoaThiDTO khoaThiDTO: khoaThiDTOs){
            if(khoaThiDTO.getNgayThi().compareTo(dateNow) > 0){
                ThiSinhDTO thiSinhDTO = new ThiSinhDTO(maThiSinh, HoTenThiSinh, GioiTinh, NgaySinh, CMND, NgayCap, NoiCap,
                        SDT, Mail, DiaChi, khoaThiDTO.getMaKhoaThi(), TrinhDo, 1);
                if(thiSinhBUS.Add(thiSinhDTO)){
                    redirectAttributes.addFlashAttribute("success", "Đăng ký thành công.");
                    return "redirect:/dangky";
                }
                break;
            }
        }
        redirectAttributes.addFlashAttribute("error", "Đăng ký thất bại.");
        return "redirect:/dangky";
    }

}
