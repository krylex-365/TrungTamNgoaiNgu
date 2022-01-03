package com.example.quanlythiweb.controller;

import BUS.KhoaThiBUS;
import BUS.PhongThiBUS;
import BUS.ThiSinhBUS;
import BUS.TrinhDoBUS;
import DTO.DataThiSinh;
import DTO.KhoaThiDTO;
import DTO.ThiSinhDTO;
import DTO.TrinhDoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TimKiemThiSinhController {
    @RequestMapping(method = RequestMethod.GET, value = "/timkiemTS")
    public String timKiemTs(){
        return "timkiemTS";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/timkiemTS")
    public String danhSachTimKiemTs(@RequestParam String HoTenThiSinh, String SDT, Model model){
        ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
        ArrayList<DataThiSinh> dataThiSinhs = thiSinhBUS.timKiemThiSinh(HoTenThiSinh, SDT);
        model.addAttribute("dataThiSinhs", dataThiSinhs);
        return "timkiemTS";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/timkiemTSDT")
    public String timKiemTsdt(Model model){
        KhoaThiBUS khoaThiBUS = new KhoaThiBUS();
        PhongThiBUS phongThiBUS = new PhongThiBUS();
        model.addAttribute("khoaThis", khoaThiBUS.khoaThiDAO.getList());
        model.addAttribute("phongThis", phongThiBUS.phongThiDAO.getList());
        return "timkiem";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/timkiemTSDT")
    public String danhSachTimKiemTsdt(@RequestParam String makhoathi, String maphongthi, Model model){
        ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
        ArrayList<DataThiSinh> dataThiSinhs = thiSinhBUS.timKiemThiSinhDuThi(makhoathi, maphongthi);
        KhoaThiBUS khoaThiBUS = new KhoaThiBUS();
        PhongThiBUS phongThiBUS = new PhongThiBUS();
        model.addAttribute("khoaThis", khoaThiBUS.khoaThiDAO.getList());
        model.addAttribute("phongThis", phongThiBUS.phongThiDAO.getList());
        model.addAttribute("dataThiSinhs", dataThiSinhs);
        return "timkiem";
    }


}
