package com.byazt.ws;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alibaba.android.arouter.utils.Consts;
import com.kuaishou.weapon.p0.bg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2290, 20})
public class c {
    public static String c(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(Consts.DOT);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            if (i2 > 0 && i2 % i == 0 && i2 != bArr.length - 1) {
                sb.append(bg.j);
            }
        }
        return sb.toString();
    }

    public static byte[] c(String str) {
        String strReplaceAll = str.replaceAll(WVNativeCallbackUtil.SEPERATER, "").replaceAll("\\.", "");
        int length = strReplaceAll.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(strReplaceAll.charAt(i), 16) << 4) + Character.digit(strReplaceAll.charAt(i + 1), 16));
        }
        return bArr;
    }
}
