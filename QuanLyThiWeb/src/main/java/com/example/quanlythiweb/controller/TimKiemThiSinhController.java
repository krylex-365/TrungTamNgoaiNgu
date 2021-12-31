package com.example.quanlythiweb.controller;

import BUS.KhoaThiBUS;
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


}
