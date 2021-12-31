package com.anhpdt2008110004;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class ThucPham extends HangHoa{
    
    private Date ngayHetHan;

    public ThucPham(String mH, String tH, float gN, int sLTK, String nNK, String nHH)throws ParseException {
        super("- " + mH, tH, gN, sLTK, nNK);
        this.ngayHetHan = chuoiSangNgay(nHH);
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date nHH) {
        this.ngayHetHan = nHH;
    }
    DecimalFormat df = new DecimalFormat("###,###,### VND");

    @Override
    public String toString() {
        String s ;
        s = super.toString() + String.format("%-20s|%-20s|", ngaySangChuoi(getNgayHetHan()), df.format(tinhTien()));
        return s;
    }
}
