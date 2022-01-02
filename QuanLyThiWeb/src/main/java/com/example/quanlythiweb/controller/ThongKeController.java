package com.example.quanlythiweb.controller;
import BUS.TrinhDoBUS;
import DTO.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

import BUS.KhoaThiBUS;
import BUS.PhongThiBUS;
import BUS.ThiSinhBUS;
@Controller
public class ThongKeController {
    @RequestMapping(method = RequestMethod.GET, value = "/thongke")
    public String loadThongKe(Model model){
        TrinhDoBUS trinhDoBUS= new TrinhDoBUS();
        ArrayList<TrinhDoDTO> listTrinhDo= trinhDoBUS.getList();
        model.addAttribute("listTrinhDo", listTrinhDo);
        return "thongke";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/thongke/result")
    public String thongketheotrinhdo(@RequestParam String matrinhdo, Model model){
        TrinhDoBUS trinhDoBUS= new TrinhDoBUS();

        ArrayList<TrinhDoDTO> listTrinhDo= trinhDoBUS.getList();
        PhongThiBUS phongThiBUS= new PhongThiBUS();
        ArrayList<PhongThiDTO> phongThiDTOs= phongThiBUS.getList();
        ArrayList<PhongThongKe> listPhongTK= phongThiBUS.getListTK(matrinhdo);
        int soluongPhong= listPhongTK.size();

        ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
        ArrayList<ThiSinhThongKe> listThisinhTK= thiSinhBUS.getThongke(matrinhdo);

        int soluongthisinh= listThisinhTK.size();


        KhoaThiBUS khoaThiBUS= new KhoaThiBUS();
        ArrayList<KhoaThiDTO> khoaThiDTOs= khoaThiBUS.getList();

       ArrayList<KhoaThiDTO> listKhoaTK= new ArrayList<>();


        for (KhoaThiDTO khoathi: khoaThiDTOs){
            for (PhongThiDTO phongThi: phongThiDTOs){
                if (khoathi.getMaKhoaThi().equals(phongThi.getMaKhoaThi()) && phongThi.getMaTrinhDo().equals(matrinhdo)){
                    listKhoaTK.add(khoathi);
                    break;
                }
            }

        }
        int soluongKhoa= listKhoaTK.size();



        model.addAttribute("listPhongTK", listPhongTK);
        model.addAttribute("soluongPhong", soluongPhong);
        model.addAttribute("listKhoaTK", listKhoaTK);
        model.addAttribute("soluongKhoa", soluongKhoa);
        model.addAttribute("listThisinhTK", listThisinhTK);
        model.addAttribute("soluongthisinh", soluongthisinh);
        model.addAttribute("listTrinhDo", listTrinhDo);
        return "thongke";

    }


}
