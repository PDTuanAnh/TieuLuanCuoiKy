package com.anhpdt2008110004;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangHoa {

    private String maHang;
    private String tenHang;
    private float giaNhap;
    private int soLuongTonKho;
    private Date ngayNhapKho;

    public HangHoa(String mH, String tH, float gN, int sLTK, String nNK) throws ParseException {
        this.maHang = mH;
        this.tenHang = tH;
        this.giaNhap = gN;
        this.soLuongTonKho = sLTK;
        this.ngayNhapKho = chuoiSangNgay(nNK);
    }

    public String getMaHang() {
        return maHang;
    }
 
    public void setMaHang(String mH) {
        this.maHang = mH;
    }
 
    public String getTenHang() {
        return tenHang;
    }
 
    public void setTenHang(String tH) {
        this.tenHang = tH;
    }
 
    public float getGiaNhap() {
        return giaNhap;
    }
 
    public void setGiaNhap(float gN) {
        this.giaNhap = gN;
    }

    public int getSLTK(){
        return soLuongTonKho;
    }

    public void setSLTK(int sLTK){
        this.soLuongTonKho = sLTK;
    }

    public Date getNNK(){
        return ngayNhapKho;
    }

    public void setNNK(Date nNK){
        this.ngayNhapKho = nNK;
    }

    public static Date chuoiSangNgay(String chuoi) throws ParseException{
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoi);
        return date;
    }

	public static String ngaySangChuoi(Date date){
        String ngay = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        ngay =  simpleDateFormat.format(date);
        return ngay;
    }

    public float tinhTien(){
        return getSLTK()*getGiaNhap();
    }
    DecimalFormat df = new DecimalFormat("###,###,### VND");

    public String toString() {
		String s = "";
		s += String.format("|%-8s|%-25s|%-25s|%-23s|%-20s|", getMaHang(), getTenHang(), getSLTK(), df.format(getGiaNhap()), ngaySangChuoi(getNNK()));
		return s;
	}
}
