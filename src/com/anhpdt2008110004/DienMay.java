package com.anhpdt2008110004;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DienMay extends HangHoa{

    private int congSuat;

    public DienMay(String mH, String tH, float gN, int sLTK, String nNK, int cS) throws ParseException {
        super("- " + mH, tH, gN, sLTK, nNK);
        this.congSuat = cS;
    }

    public void setCongSuat(int cS) {
        this.congSuat = cS;
    }

    public int getCongSuat() {
        return congSuat;
    }
    DecimalFormat df = new DecimalFormat("##### W");
    DecimalFormat dF = new DecimalFormat("###,###,### VND");

    @Override
    public String toString() {
        String s ;
        s = super.toString() + String.format("%-20s|%-20s|", df.format(getCongSuat()), dF.format(tinhTien()));
        return s ;
    }
}
