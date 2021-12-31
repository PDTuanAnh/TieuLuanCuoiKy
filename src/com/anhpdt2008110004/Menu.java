package com.anhpdt2008110004;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) throws ParseException {

    DSQuanLi dS = new DSQuanLi(); 
    
    HangHoa sp1 = new ThucPham("01", "Rau ngot", 10000, 1000, "11/11/2021","14/11/2021");
    HangHoa sp2 = new ThucPham("02", "Rau Muong", 10000, 1000, "11/11/2021","14/11/2021");
    HangHoa sp3 = new ThucPham("03", "Rau mung toi", 10000, 1000, "11/11/2021","14/11/2021");
    HangHoa sp4 = new ThucPham("04", "Thit hun khoi", 20000, 2000, "12/11/2021","12/09/2022");
    HangHoa sp5 = new ThucPham("05", "Thit ba chi", 20000, 2000, "12/11/2021","12/09/2022");
    HangHoa sp6 = new ThucPham("06", "Ca hoi", 25000, 2500, "12/11/2021","12/09/2022");
    
    HangHoa sp7 = new SanhSu("07", "Chen", 50000, 500, "13/10/2021", "Nghe An");
    HangHoa sp8 = new SanhSu("08", "Ly", 50000, 500, "13/10/2021", "Thanh Hoa");
    HangHoa sp9 = new SanhSu("09", "Dia", 50000, 500, "13/10/2021", "Nghe An");
    HangHoa sp10 = new SanhSu("10", "Am Tra", 50000, 500, "14/10/2021", "Thanh Hoa");
    HangHoa sp11 = new SanhSu("11", "Ban", 50000, 5000, "14/10/2021", "Nghe An");
    HangHoa sp12 = new SanhSu("12", "To", 50000, 500, "15/10/2021", "Thanh Hoa");
    HangHoa sp13 = new SanhSu("13", "Muong", 50000, 500, "18/10/2021", "Nghe An");
    
    HangHoa sp14 = new DienMay("14", "Tu lanh", 2500000, 100,"13/12/2021", 200);
    HangHoa sp15 = new DienMay("15", "May lanh", 8900000, 100,"13/12/2021", 100);
    HangHoa sp16 = new DienMay("16", "May say", 100000, 100,"12/12/2021", 50);
    HangHoa sp17 = new DienMay("17", "May quat", 150000, 100,"11/12/2021", 20);
    HangHoa sp18 = new DienMay("18", "May tinh", 15000000, 100,"19/12/2021", 300);
    HangHoa sp19 = new DienMay("19", "May loc nuoc", 22000000, 100,"23/12/2021", 400);
    HangHoa sp20 = new DienMay("20", "May Loc khong khi", 25000000, 100,"22/12/2021", 500);
    //Thêm hàng hóa vào danh sách    
    dS.themMotHangHoa(sp1);
    dS.themMotHangHoa(sp2);
    dS.themMotHangHoa(sp3);
    dS.themMotHangHoa(sp4);
    dS.themMotHangHoa(sp5);
    dS.themMotHangHoa(sp6);
    dS.themMotHangHoa(sp7);
    dS.themMotHangHoa(sp8);
    dS.themMotHangHoa(sp9);
    dS.themMotHangHoa(sp10);
    dS.themMotHangHoa(sp11);
    dS.themMotHangHoa(sp12);
    dS.themMotHangHoa(sp13);
    dS.themMotHangHoa(sp14);
    dS.themMotHangHoa(sp15);
    dS.themMotHangHoa(sp16);
    dS.themMotHangHoa(sp17);
    dS.themMotHangHoa(sp18);
    dS.themMotHangHoa(sp19);
    dS.themMotHangHoa(sp20);

    Scanner bienNhap = new Scanner(System.in);
    int suLuaChon;
    do{
        System.out.println("O>>>>>>>>-----Welcom to Menu Program-----<<<<<<<<O");
        System.out.println("|-->1. Them, xoa, sua hang hoa.                  |");
        System.out.println("|-->2. Tim kiem hang hoa.                        |");
        System.out.println("|-->3. Sap xep hang hoa theo tang dan.           |");
        System.out.println("|-->4. Sap xep hang hoa theo giam dan.           |");
        System.out.println("|-->5. Thong ke hang hoa.                        |");
        System.out.println("|-->6. Ket thuc menu.                            |");
        System.out.println("O>>>>>>>>--------------End---------------<<<<<<<<O");
        System.out.print("Chon chuc nang: ");
        suLuaChon = bienNhap.nextInt();
        switch (suLuaChon) {
            case 1:
                System.out.println("\nThem, xoa, sua hang hoa.");
                System.out.println("1. Them hang hoa");
                System.out.println("2. Sua hang hoa");
                System.out.println("3. Xoa hang hoa");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon cua ban : ");
                suLuaChon = bienNhap.nextInt();
                switch(suLuaChon){
                    case 1 : dS.themHangHoa();break;
                    case 2 : dS.suaHangHoa();break;
                    case 3 : dS.xoaHangHoa();break;
                    case 0 : System.out.println("Thoat");
                    default : break;
                }break;
            case 2:
                System.out.println("\nTim kiem hang hoa theo:");
                System.out.println("1. Loai");
                System.out.println("2. Gia nhap");
                System.out.println("3. Ngay nhap");
                System.out.println("4. Gia tri cao nhat");
                System.out.println("5. Tong gia tri cao nhat");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon cua ban : ");
                suLuaChon = bienNhap.nextInt();
                switch(suLuaChon){
                    case 1 : dS.timKiemTheoLoai();break;
                    case 2 : dS.timKiemTheoGia();break;
                    case 3 : dS.timKiemTheoNgay();break;
                    case 4 : dS.timKiemSanPhamGiaTriCao();break;
                    case 5 : dS.timKiemSanPhamTongGiaTriCaoNhat();break;
                    case 0 : System.out.println("Thoat");
                    default : break;    
                }break;
            case 3:
                System.out.println("\nSap xep hang hoa tang dan theo:");
                System.out.println("1. Gia nhap");
                System.out.println("2. Ngay nhap");
                System.out.println("3. Loai va gia nhap");
                System.out.println("4. Loai va ngay nhap");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon cua ban : ");
                suLuaChon = bienNhap.nextInt();
                switch(suLuaChon){
                    case 1 : dS.sXHangHoaTangDanTheoGia();break;
                    case 2 : dS.sXHangHoaTangDanTheoNgay();break;
                    case 3 : dS.sXTangDanTheoLoaiVaTheoGia();break;
                    case 4 : dS.sXTangDanTheoLoaiVaTheoNgayNhap();break;
                    case 0 : System.out.println("Thoat");
                    default : break;
                }break;
            case 4:
                System.out.println("\nSap xep hang hoa giam dan theo:");
                System.out.println("1. Gia nhap");
                System.out.println("2. Ngay nhap");
                System.out.println("3. Loai va gia nhap");
                System.out.println("4. Loai va ngay nhap");
                System.out.println("0. Thoat");
                System.out.print("Nhap lua chon cua ban : ");
                suLuaChon = bienNhap.nextInt();
                switch(suLuaChon){
                    case 1 : dS.sXHangHoaGiamDanTheoGia();break;
                    case 2 : dS.sXHangHoaGiamDanTheoNgay();break;
                    case 3 : dS.sXGiamDanTheoLoaiVaTheoGia();break;
                    case 4 : dS.sXGiamDanTheoLoaiVaTheoNgayNhap();break;
                    case 0 : System.out.println("Thoat");
                    default : break;
                }break;
            case 5:
                System.out.println("Thong ke hang hoa.");
                dS.thongKeTongHangHoa();
                default : break;
            case 6: 
                System.out.println("Ket thuc!"); break;
        }if(suLuaChon == 0){
            System.out.println("Thanks For Using The Program! Goodbye And See You Later!");
        }
    }while(0 < suLuaChon && suLuaChon < 6);
    }
}
    
    