package com.zj.adlib;

import com.blankj.utilcode.constant.PermissionConstants;
import com.google.zxing.client.result.ResultParser;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class wk9 extends ResultParser {
    public static String i(CharSequence charSequence, String str) {
        List<String> listL = vk9.l(charSequence, str, true, false);
        if (listL == null || listL.isEmpty()) {
            return null;
        }
        return listL.get(0);
    }

    public static String[] j(CharSequence charSequence, String str) {
        List<List<String>> listM = vk9.m(charSequence, str, true, false);
        if (listM == null || listM.isEmpty()) {
            return null;
        }
        int size = listM.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = listM.get(i).get(0);
        }
        return strArr;
    }

    public static String l(String str) {
        if (str != null) {
            return (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str;
        }
        return str;
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public fa1 e(ug7 ug7Var) {
        double d;
        double d2;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (massagedText.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String strI = i("SUMMARY", massagedText);
        String strI2 = i("DTSTART", massagedText);
        if (strI2 == null) {
            return null;
        }
        String strI3 = i("DTEND", massagedText);
        String strI4 = i("DURATION", massagedText);
        String strI5 = i(PermissionConstants.d, massagedText);
        String strL = l(i("ORGANIZER", massagedText));
        String[] strArrJ = j("ATTENDEE", massagedText);
        if (strArrJ != null) {
            for (int i = 0; i < strArrJ.length; i++) {
                strArrJ[i] = l(strArrJ[i]);
            }
        }
        String strI6 = i("DESCRIPTION", massagedText);
        String strI7 = i("GEO", massagedText);
        if (strI7 == null) {
            d = Double.NaN;
            d2 = Double.NaN;
        } else {
            int iIndexOf = strI7.indexOf(59);
            if (iIndexOf < 0) {
                return null;
            }
            try {
                d = Double.parseDouble(strI7.substring(0, iIndexOf));
                d2 = Double.parseDouble(strI7.substring(iIndexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new fa1(strI, strI2, strI3, strI4, strI5, strL, strArrJ, strI6, d, d2);
    }
}
