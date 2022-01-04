package com.example.quanlythiweb.controller;

import BUS.ThiSinhBUS;
import BUS.TrinhDoBUS;
import DTO.DataThiSinh;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ChungNhanKetQuaController {

    @RequestMapping(method = RequestMethod.GET, value = "/chungnhan")
    public String chungNhan(){
        return "chungnhan";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/chungnhanKQ")
    public String timKiemTs(@RequestParam String SBD, Model model){
        ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
        ArrayList<DataThiSinh> dataThiSinhs = thiSinhBUS.timKiemThiSinhSoBaoDanh(SBD);
        DataThiSinh dataThiSinh = null;
        if(dataThiSinhs.size() > 0){
            dataThiSinh = dataThiSinhs.get(0);
        }

        //Tinh diem
        float diem = 0;
        diem += dataThiSinh.nghe + dataThiSinh.noi + dataThiSinh.doc + dataThiSinh.viet;
        dataThiSinh.diemTrungBinh = (float) Math.ceil(diem / 4 * 10) / 10;
        if(dataThiSinh.tenTrinhDo.equals("A2")){
            if(dataThiSinh.nghe > 0 && dataThiSinh.noi > 0 && dataThiSinh.doc > 0 && dataThiSinh.viet > 0 && dataThiSinh.diemTrungBinh >= 6.5){
                dataThiSinh.ketQua = "Đạt";
            }else {
                dataThiSinh.ketQua = "Không đạt";
            }
        }else {
            if(dataThiSinh.nghe > 0 && dataThiSinh.noi > 0 && dataThiSinh.doc > 0 && dataThiSinh.viet > 0 && dataThiSinh.diemTrungBinh >= 4){
                dataThiSinh.ketQua = "Đạt";
            }else {
                dataThiSinh.ketQua = "Không đạt";
            }
        }

        model.addAttribute("dataThiSinh", dataThiSinh);
        return "chungnhanKQ";
    }
}
