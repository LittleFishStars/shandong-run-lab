package com.alibaba.analytics.a;

import android.content.Context;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p {
    public static String getImei(Context context) {
        String strD = o.d(context);
        return u.isEmpty(strD) ? getUniqueID() : strD;
    }

    public static String getImsi(Context context) {
        String strE = o.e(context);
        return u.isEmpty(strE) ? getUniqueID() : strE;
    }

    public static final String getUniqueID() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        int iNextInt = new Random().nextInt();
        int iNextInt2 = new Random().nextInt();
        byte[] bytes = h.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = h.getBytes(iNanoTime);
        byte[] bytes3 = h.getBytes(iNextInt);
        byte[] bytes4 = h.getBytes(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return c.b(bArr);
    }
}
