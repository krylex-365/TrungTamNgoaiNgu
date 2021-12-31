select
    ts.*,
    kt.TenKhoaThi,
    td.TenTrinhDo,
    pbdt.SoBaoDanh,
    pt.TenPhongThi,
    ct.GioBatDau,
    ct.GioKetThuc,
    kq.Nghe,
    kq.Noi,
    kq.Doc,
    kq.Viet

from ThiSinh ts
left join KhoaThi kt on kt.MaKhoaThi = ts.MaKhoaThi and kt.Status = 1
left join TrinhDo td on ts.MaTrinhDo = td.MaTrinhDo and td.Status = 1
left join PhieuBaoDuThi pbdt on pbdt.MaThiSinh = ts.MaThiSinh and pbdt.Status = 1
left join PhongThi pt on pt.MaPhongThi = pbdt.MaPhongThi and pt.Status = 1
left join CaThi ct on ct.MaCaThi = pbdt.MaCaThi and ct.Status = 1
left join KetQuaThi kq on kq.SoBaoDanh = pbdt.SoBaoDanh and kq.Status = 1

where
    ts.HoTen = N'Duong L'
    and ts.Sdt = '0902040606'
    and ts.Status <> 0