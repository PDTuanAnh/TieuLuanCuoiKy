package com.anhpdt2008110004;

import java.text.DecimalFormat;
import java.text.ParseException;

public class SanhSu extends HangHoa{
    
    private String xuatXu;

    public SanhSu(String mH, String tH, float gN, int sLTK, String nNK, String xX)throws ParseException {
        super("- "+ mH, tH, gN, sLTK, nNK);
        this.xuatXu = xX;
    }
    
    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xX) {
        this.xuatXu = xX;
    }
    DecimalFormat df = new DecimalFormat("###,###,### VND");

    @Override
    public String toString() {
        String s;
        s = super.toString() + String.format("%-20s|%-20s|", getXuatXu(), df.format(tinhTien()));
        return s;
    }
}
