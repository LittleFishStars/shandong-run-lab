package com.zj.adlib;

import android.text.TextUtils;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class or6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43823a = "PinYinUtil";

    public static String a(String chinese) {
        if (TextUtils.isEmpty(chinese)) {
            return null;
        }
        ny3 ny3Var = new ny3();
        ny3Var.e(my3.a);
        ny3Var.f(oy3.b);
        StringBuilder sb = new StringBuilder();
        for (char c : chinese.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                if (c > 127) {
                    try {
                        String[] strArrH = qr6.h(c, ny3Var);
                        if (strArrH != null && strArrH.length > 0) {
                            sb.append(strArrH[0]);
                        }
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                        e.printStackTrace();
                    }
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
