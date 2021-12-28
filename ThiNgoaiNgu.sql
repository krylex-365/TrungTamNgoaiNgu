use master;
go
drop database THINGOAINGU;
go
create database THINGOAINGU;
go
use THINGOAINGU;
go

create table KhoaThi(
	MaKhoaThi nvarchar(20) primary key,
	TenKhoaThi nvarchar(40),
	NgayThi date,
	Status int default 1
);

create table TrinhDo(
	MaTrinhDo nvarchar(20) primary key,
	TenTrinhDo nvarchar(20),
	LePhi nvarchar(20),
	SoLuongTS int,
	SoLuongPG int,
	Status int default 1
);

create table PhongThi(
	MaPhongThi nvarchar(20) primary key,
	TenPhongThi nvarchar(20),
	SoLuong int,
	MaKhoaThi nvarchar(20) not null, /*FK*/
	MaTrinhDo nvarchar(20) not null, /*FK*/
	Status int default 1
);

create table CaThi(
	MaCaThi nvarchar(20) primary key,
	GioBatDau nvarchar(10),
	GioKetThuc nvarchar(10),
	Status int default 1
);

create table GiaoVien(
	MaGiaoVien nvarchar(20) primary key,
	HoTen nvarchar(50),
	GioiTinh nvarchar(20),
	NgaySinh date,
	Sdt nvarchar(20),
	Mail nvarchar(40),
	DiaChi nvarchar(50),
	Status int default 1
);

create table PhanCong(
	MaPhongThi nvarchar(20) not null, /*PK FK*/
	MaCaThi nvarchar(20) not null, /*PK FK*/
	MaGiaoVien nvarchar(20) not null, /*PK FK*/
	NhiemVu nvarchar(20),
	Status int default 1,
	constraint PK_PhanCong primary key (MaPhongThi, MaCaThi, MaGiaoVien)
);

create table ThiSinh(
	MaThiSinh nvarchar(20) primary key,
	HoTen nvarchar(50),
	GioiTinh nvarchar(10),
	NgaySinh date,
	Cmnd nvarchar(20),
	NgayCap date,
	NoiCap nvarchar(30),
	Sdt nvarchar(20),
	Mail nvarchar(40),
	DiaChi nvarchar(50),
	MaKhoaThi nvarchar(20) not null, /*FK*/
	MaTrinhDo nvarchar(20) not null, /*FK*/
	Status int default 1
);

create table PhieuBaoDuThi(
	SoBaoDanh nvarchar(20) primary key, /*PK*/
	MaThiSinh nvarchar(20) not null, /*FK*/
	MaPhongThi nvarchar(20) not null, /*FK*/
	MaCaThi nvarchar(20) not null, /*FK*/
	NgayThi date,
	Status int default 1,
	/*constraint PK_PhieuBaoDuThi primary key (MaThiSinh, MaPhongThi, MaCaThi, SoBaoDanh)*/
);

create table KetQuaThi(
	SoBaoDanh nvarchar(20) primary key, /*PK FK*/
	Nghe float,
	Noi float,
	Doc float,
	Viet float,
	Status int default 1,
	/*constraint PK_KetQuaThi primary key (MaThiSinh, MaPhongThi)*/
);

create table MaDuLieuCuoi(
	MaKhoaThi nvarchar(20),
	MaTrinhDo nvarchar(20),
	MaPhongThi nvarchar(20),
	MaCaThi nvarchar(20),
	MaGiaoVien nvarchar(20),
	MaThiSinh nvarchar(20)
);

alter table PhongThi add constraint FK_PhongThi_KhoaThi
foreign key (MaKhoaThi) references KhoaThi(MaKhoaThi);
alter table PhongThi add constraint FK_PhongThi_TrinhDo
foreign key (MaTrinhDo) references TrinhDo(MaTrinhDo);

alter table PhanCong add constraint FK_PhanCong_PhongThi
foreign key (MaPhongThi) references PhongThi(MaPhongThi);
alter table PhanCong add constraint FK_PhanCong_CaThi
foreign key (MaCaThi) references CaThi(MaCaThi);
alter table PhanCong add constraint FK_PhanCong_GiaoVien
foreign key (MaGiaoVien) references GiaoVien(MaGiaoVien);

alter table ThiSinh add constraint FK_ThiSinh_KhoaThi
foreign key (MaKhoaThi) references KhoaThi(MaKhoaThi);
alter table ThiSinh add constraint FK_ThiSinh_TrinhDo
foreign key (MaTrinhDo) references TrinhDo(MaTrinhDo);

alter table PhieuBaoDuThi add constraint FK_PhieuBaoDuThi_ThiSinh
foreign key (MaThiSinh) references ThiSinh(MaThiSinh);
alter table PhieuBaoDuThi add constraint FK_PhieuBaoDuThi_PhongThi
foreign key (MaPhongThi) references PhongThi(MaPhongThi);
alter table PhieuBaoDuThi add constraint FK_PhieuBaoDuThi_CaThi
foreign key (MaCaThi) references CaThi(MaCaThi);

alter table KetQuaThi add constraint FK_KetQuaThi_PhieuBaoDuThi
foreign key (SoBaoDanh) references PhieuBaoDuThi(SoBaoDanh);

insert into KhoaThi
values ('KH000001','Khoa thi 1','2021-11-17',1),
('KH000002','Khoa thi 2','2021-12-17',1),
('KH000003','Khoa thi 3','2022-01-17',1),
('KH000004','Khoa thi 4','2022-02-17',1);

insert into TrinhDo
values ('TD000001','A2','500000',2,3,1),
('TD000002','B1','600000',4,3,1);

insert into PhongThi
values ('PG000001','A2P001',30,'KH000001','TD000001',1),
('PG000002','B1P002',32,'KH000001','TD000002',1),
('PG000003','A2P003',35,'KH000002','TD000001',1),
('PG000004','B1P004',30,'KH000002','TD000002',1),
('PG000005','A2P005',34,'KH000003','TD000001',1),
('PG000006','B1P006',32,'KH000003','TD000002',1);

insert into CaThi
values ('CA000001','07:00:00','10:00:00',1),
('CA000002','08:00:00','11:00:00',1),
('CA000003','13:00:00','16:00:00',1),
('CA000004','14:00:00','17:00:00',1);

insert into GiaoVien
values ('GV000001','Nguyen A','1','1972-11-17','0909090909','A@mail.com','123/ABC',1),
('GV000002','Tran B','1','1980-07-20','0909090909','B@mail.com','456/DEF',1),
('GV000003','Le C','0','1974-12-04','0909090909','C@mail.com','789/GHI',1),
('GV000004','Thai D','1','1976-02-21','0909090909','D@mail.com','123/JKL',1),
('GV000005','Phung E','0','1969-06-09','0909090909','E@mail.com','456/MNO',1);

insert into PhanCong
values ('PG000001','CA000001','GV000001','Canh thi',1),
('PG000001','CA000001','GV000002','Cham diem',1),
('PG000002','CA000003','GV000003','Canh thi',1),
('PG000002','CA000003','GV000004','Cham diem',1),
('PG000003','CA000001','GV000001','Canh thi',1),
('PG000003','CA000001','GV000003','Cham diem',1),
('PG000004','CA000001','GV000002','Canh thi',1),
('PG000004','CA000001','GV000004','Cham diem',1),
('PG000005','CA000001','GV000003','Canh thi',1),
('PG000005','CA000001','GV000001','Cham diem',1);

insert into ThiSinh
values ('TS000001','Tran O','1','2000-02-04','123456789000','2018-10-15','CATPHCM','0907020408','O@mail.com','234/REC','KH000001','TD000001',1),
('TS000002','Duong L','1','1994-09-12','357912547000','2017-02-12','CATPHCM','0902040606','L@mail.com','327/PRM','KH000001','TD000002',1),
('TS000003','Ho T','1','2002-06-24','254796428000','2018-10-17','CATPHCM','0904050607','T@mail.com','218/PEM','KH000002','TD000002',1),
('TS000004','Phuong R','1','1997-11-21','345976218000','2016-08-25','CATPHCM','0903040506','R@mail.com','884/EQM','KH000002','TD000002',1),
('TS000005','Thieu P','1','2001-07-02','243582197000','2020-12-24','CATPHCM','0901050807','P@mail.com','991/MTE','KH000003','TD000001',1),
('TS000006','Le Q','1','1999-12-04','326147824000','2019-02-09','CATPHCM','0903050807','Q@mail.com','653/TMW','KH000003','TD000002',1);

insert into PhieuBaoDuThi
values ('A201','TS000001','PG000001','CA000001','2021-11-17',1),
('B101','TS000002','PG000002','CA000003','2021-11-17',1);

insert into KetQuaThi
values ('A201','6','8','7','6',1),
('B101','6','8','7','6',1);

insert into MaDuLieuCuoi
values ('KH000004','TD000002','PG000006','CA000004','GV00005','TS000006');