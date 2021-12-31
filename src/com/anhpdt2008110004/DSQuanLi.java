package com.anhpdt2008110004;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class DSQuanLi {
    private ArrayList<HangHoa> list ;
    private Scanner bienNhap = new Scanner(System.in);

    DSQuanLi(){
        list = new ArrayList<HangHoa>();
    }
    public ArrayList<HangHoa> getList() {
        return list;
    }
    public void setList(ArrayList<HangHoa> list) {
        this.list = list;
    }
    //Thêm hàng hóa trực tiếp
    public void themMotHangHoa(HangHoa x) throws ParseException{
        int count = 0 ;
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa sp = list.get(i);
            if(sp.getMaHang().equalsIgnoreCase(x.getMaHang()) || sp.getMaHang().equalsIgnoreCase("Thực phẩm -") ||sp.getMaHang().equalsIgnoreCase("Sành sứ -") || sp.getMaHang().equalsIgnoreCase("Điện máy -") ){
                System.out.println("HANG HOA BI TRUNG. VUI LONG NHAP LAI!");
                count++ ;
                themHangHoa();
                break;
            }
        }
        if(count == 0){
            list.add(x);
        }
    }
    //Thêm hàng hóa bằng dữ liệu nhập từ bàn phím
    public void themHangHoa() throws ParseException {
        System.out.println("\n1. Thuc pham");
		System.out.println("2. Sanh su");
		System.out.println("3. Dien may");
		System.out.println("0.Quay lai");
        System.out.print("Hay chon mot loai hang hoa: ");
    	int luaChon = bienNhap.nextInt();
        HangHoa x;
        switch(luaChon){
            case 1 : {
				//THỰC PHẨM
				System.out.println("\nNHAP THONG TIN THUC PHAM NHAP KHO");
                System.out.print("Nhap ma hang hoa: ");
				bienNhap.nextLine();
				String mH = bienNhap.nextLine();
				System.out.print("Nhap ten hang hoa: ");
				String tH = bienNhap.nextLine();
				System.out.print("Nhap so luong ton kho: ");
				int sLTK = bienNhap.nextInt();
				System.out.print("Nhap gia: ");
				float gN = bienNhap.nextInt();				
				System.out.print("Nhap ngay nhap kho (dd/mm/yyyy): ");
                bienNhap.nextLine();
				String nNK = bienNhap.nextLine();
                System.out.print("Nhap ngay het han (dd/mm/yyyy): ");
				String nHH = bienNhap.nextLine();
				x = new ThucPham(mH, tH, gN, sLTK, nNK, nHH);
				themMotHangHoa(x);
                break;
            }
			case 2 : {
				//SÀNH SỨ
				System.out.println("\nNHAP THONG TIN SANH SU NHAP KHO"); 
                System.out.print("Nhap ma hang: ");
				bienNhap.nextLine();
				String mH = bienNhap.nextLine();
				System.out.print("Nhap ten hang: ");
				String tH = bienNhap.nextLine();
				System.out.print("Nhap so luong ton kho: ");
				int sLTK = bienNhap.nextInt();
				System.out.print("Nhap gia: ");
				float gN = bienNhap.nextInt();				
				System.out.print("Nhap ngay nhap kho (dd/mm/yyyy): ");
                bienNhap.nextLine();
				String nNK = bienNhap.nextLine();
                System.out.print("Nhap nha cung cap: ");
                String nCC = bienNhap.nextLine();
				x = new SanhSu(mH, tH, gN, sLTK, nNK, nCC);
                themMotHangHoa(x);
                break;
			}
			case 3 : {
				//ĐIỆN MÁY
				System.out.println("\nNHAP THONG TIN DIEN MAY NHAP KHO");
                System.out.print("Nhap ma hang: ");
				bienNhap.nextLine();
				String mH = bienNhap.nextLine();
				System.out.print("Nhap ten hang: ");
				String tH = bienNhap.nextLine();
				System.out.print("Nhap so luong ton kho: ");
				int sLTK = bienNhap.nextInt();
				System.out.print("Nhap gia: ");
				float gN = bienNhap.nextInt();				
				System.out.print("Nhap ngay nhap kho (dd/mm/yyyy): ");
                bienNhap.nextLine();
				String nNK = bienNhap.nextLine();
                System.out.print("Nhap cong suat: ");
                int cS =bienNhap.nextInt();
				x = new DienMay(mH, tH, gN, sLTK, nNK, cS) ;
				themMotHangHoa(x);
                break;
			}
			default : break;
        } 
	}
    //Sửa hàng hóa thông qua mã hàng
    public void suaHangHoa() throws ParseException{
        System.out.print("Nhap ma hang hoa can sua: ");
        String mH = bienNhap.nextLine();
        for(int i = 0; i < list.size(); i++){
            HangHoa x = list.get(i);
            if(x.getMaHang().equals(mH)){
                if(x instanceof ThucPham){
                    String[] maHang = mH.split("-",2);
                    System.out.println("\nNHAP THONG TIN THUC PHAM CAN SUA");
                    System.out.print("Nhap ten hang: ");
                    String tH = bienNhap.nextLine();
                    System.out.print("Nhap so luong ton kho: ");
                    int sLTK = bienNhap.nextInt();
                    System.out.print("Nhap gia: ");
                    float gN = bienNhap.nextInt();				
                    System.out.print("Nhap ngay nhap kho (dd/mm/yyyy): ");
                    bienNhap.nextLine();
                    String nNK = bienNhap.nextLine();
                    System.out.print("Nhap ngay het han (dd/mm/yyyy): ");
                    String nHH = bienNhap.nextLine();
                    HangHoa a = new ThucPham(maHang[1], tH, gN, sLTK, nNK, nHH);
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
                else if(x instanceof SanhSu){
                    String[] maHang = mH.split("-",2);
                    System.out.println("\nNHAP THONG TIN SANH SU CAN SUA"); 
                    System.out.print("Nhap ten hang: ");
                    String tH = bienNhap.nextLine();
                    System.out.print("Nhap so luong ton kho: ");
                    int sLTK = bienNhap.nextInt();
                    System.out.print("Nhap gia: ");
                    float gN = bienNhap.nextInt();				
                    System.out.print("Nhap ngay nhap kho (dd/mm/yyyy): ");
                    bienNhap.nextLine();
                    String nNK = bienNhap.nextLine();
                    System.out.print("Nhap nha cung cap: ");
                    String nCC = bienNhap.nextLine();
                    HangHoa a = new SanhSu(maHang[1], tH, gN, sLTK, nNK, nCC);
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
                else if(x instanceof DienMay){
                    String[] maHang = mH.split("-",2);
                    System.out.println("\nNHAP THONG TIN DIEN MAY CAN SUA");
                    System.out.print("Nhap ten hang: ");
                    String tH = bienNhap.nextLine();
                    System.out.print("Nhap so luong ton kho: ");
                    int sLTK = bienNhap.nextInt();
                    System.out.print("Nhap gia: ");
                    int gN = bienNhap.nextInt();				
                    System.out.print("Nhap ngay nhap kho (dd/mm/yyyy): ");
                    bienNhap.nextLine();
                    String nNK = bienNhap.nextLine();
                    System.out.print("Nhap cong suat: ");
                    int cS =bienNhap.nextInt();
                    HangHoa a = new DienMay(maHang[1], tH, gN, sLTK, nNK, cS) ;
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
            }
        }
    }
    //Xóa hàng hóa theo mã hàng
    public void xoaHangHoa(){
        System.out.print("Nhap ma hang hoa can xoa: ");
		String mH = bienNhap.nextLine();
		for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getMaHang().equals(mH)){
                list.remove(x);
            }
        }
    }
    //Các kiểu xuất hàng hóa
    public void xuatThucPham(){
        System.out.println("THUC PHAM");
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof ThucPham){
                System.out.println(hangHoa);
            }
        }
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatSanhSu(){
        System.out.println("SANH SU");
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof SanhSu){
                System.out.println(hangHoa);
            }
        }
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatDienMay(){
        System.out.println("DIEN MAY");
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof DienMay){
                System.out.println(hangHoa);
            }
        }
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatThucPhamTrucTiep(HangHoa x){
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(x);
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatSanhSuTrucTiep(HangHoa x){
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(x);
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatDienMayTrucTiep(HangHoa x){
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(x);
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatThucPhamTheoDS(ArrayList<HangHoa> l){
        System.out.println("\t\t\t\t\t\t\t\tTHUC PHAM");
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    
    public void xuatSanhSuTheoDS(ArrayList<HangHoa> l){
        System.out.println("\t\t\t\t\t\t\t\tSANH SU");
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatDienMayTheoDS(ArrayList<HangHoa> l){
        System.out.println("\t\t\t\t\t\t\t\tDIEN MAY");
		for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang","So Luong ton Kho","Gia Nhap","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }

    public void xuatTatCa(){
        for(int i = 0 ; i < list.size() ; i++){
           HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                xuatThucPhamTrucTiep(x);
            }
            else if(x instanceof SanhSu){
                xuatSanhSuTrucTiep(x);
            }
            else if(x instanceof DienMay){
                xuatDienMayTrucTiep(x);
            }
        }
    }
    //Các chức năng sắp xếp tăng dần, giảm dần
    public void sXHangHoaGiamDanTheoGia(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }

    public void sXHangHoaTangDanTheoGia(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }

    public void sXHangHoaTangDanTheoNgay(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().after(o2.getNNK())){
                    return 1 ;
                }
                else {
                    if(o1.getNNK().equals(o2.getNNK())){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }

    public void sXHangHoaGiamDanTheoNgay(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().compareTo(o2.getNNK()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNNK().compareTo(o2.getNNK()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }

    public void sXTangDanTheoLoaiVaTheoNgayNhap(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().compareTo(o2.getNNK()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNNK().compareTo(o2.getNNK()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDS(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().compareTo(o2.getNNK()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNNK().compareTo(o2.getNNK()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDS(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().compareTo(o2.getNNK()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNNK().compareTo(o2.getNNK()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDS(list3);
    }
    
    public void sXGiamDanTheoLoaiVaTheoNgayNhap(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().compareTo(o2.getNNK()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNNK().compareTo(o2.getNNK()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDS(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().compareTo(o2.getNNK()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNNK().compareTo(o2.getNNK()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDS(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNNK().compareTo(o2.getNNK()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNNK().compareTo(o2.getNNK()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDS(list3);
    }

    public void sXTangDanTheoLoaiVaTheoGia(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDS(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDS(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDS(list3);
    }

    public void sXGiamDanTheoLoaiVaTheoGia(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDS(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDS(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDS(list3);
    }
    //Các chức năng tìm kiếm 
    public void timKiemTheoLoai(){
        int luaChon = 0;
		System.out.println("1. Thuc pham");
		System.out.println("2. Sanh su");
		System.out.println("3. Dien may");
		System.out.print("Hay chon mot loai hang hoa: ");
		luaChon = bienNhap.nextInt();
		switch(luaChon){
			case 1 :{System.out.println("CAC LOAI THUC PHAM:");
					 xuatThucPham();
					 break;
			}
			case 2 :{System.out.println("CAC LOAI SANH SU: ");
					 xuatSanhSu();
					 break;
			}
			case 3 :{System.out.println("CAC LOAI ĐIEN MAY:");
					 xuatDienMay();
					 break;
			}
		}
    }

    public void timKiemTheoNgay() throws ParseException{
        System.out.println("Nhap khoang thoi gian can tim kiem tu ngay: ");
		String ngayBatDau = bienNhap.nextLine();
		System.out.println("den ngay:");
		String ngayKetThuc = bienNhap.nextLine();
		System.out.println("CAC LOAI HANG DA NHAP KHO TU NGAY "+ ngayBatDau +" DEN NGAY " + ngayKetThuc + ":");
        for(int i = 0 ; i<list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getNNK().compareTo(chuyenChuoiSangNgay(ngayBatDau)) >= 0 && x.getNNK().compareTo(chuyenChuoiSangNgay(ngayKetThuc))<=0  ){
                if(x instanceof ThucPham){
                    xuatThucPhamTrucTiep(x);
                }
                else if(x instanceof SanhSu){
                    xuatSanhSuTrucTiep(x);
                }
                else if(x instanceof DienMay){
                    xuatDienMayTrucTiep(x);
                }
            }
        }
    }

    public void timKiemTheoGia(){
        System.out.println("Nhap khoang gia can tim kiem tu: ");
		long giaBatDau = bienNhap.nextInt();
		System.out.println("den: ");
		long giaKetThuc = bienNhap.nextInt();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getGiaNhap() >= giaBatDau && x.getGiaNhap() <= giaKetThuc){
                if(x instanceof ThucPham){
                    xuatThucPhamTrucTiep(x);
                }
                else if(x instanceof SanhSu){
                    xuatSanhSuTrucTiep(x);
                }
                else if(x instanceof DienMay){
                    xuatDienMayTrucTiep(x);
                }
            }
        }
    }

    public void timKiemSanPhamGiaTriCao(){
        HangHoa y = list.get(0);
        float max = y.getGiaNhap();

        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getGiaNhap() > max){
                max = x.getGiaNhap();
            }
        }
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getGiaNhap() == max){
                System.out.println("San pham co gia tri cao nhat la : ");
                xuatSanhSuTrucTiep(x);
            }
        }
    } 

    public void timKiemSanPhamTongGiaTriCaoNhat(){
        HangHoa y = list.get(0);
        float max = y.tinhTien();

        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.tinhTien() > max){
                max = x.tinhTien();
            }
        }
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.tinhTien() == max){
                System.out.println("San pham co tong gia tri cao nhat la: ");
                xuatSanhSuTrucTiep(x);
            }
        }
    } 

    public static Date chuyenChuoiSangNgay(String chuoi) throws ParseException{
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoi);
        return date;
    }
    
    DecimalFormat df = new DecimalFormat("###,###,### VND");
    public void thongKeTongHangHoa(){
        float tongSoLuong = 0, tongChiPhi = 0;
        for (HangHoa hangHoa : list) {
            tongSoLuong += hangHoa.getSLTK();
            tongChiPhi += hangHoa.tinhTien();
        }
		sXTangDanTheoLoaiVaTheoGia();
        System.out.println("\t\t\t\t\t\t\t\tBANG THONG KE");
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-147s|\n","Tong so luong "+tongSoLuong);
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-147s|\n","Tong chi phi "+df.format(tongChiPhi));
        for (int i = 0; i < 149; i++) {
			System.out.print("-");
		}
		System.out.println();
    }
}
