package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ku {
    public static String _a(String str) {
        try {
            _kr._e.getClass();
            byte[] bArr_a = _kr._a(str);
            byte[] bArr = _kt._a;
            int length = bArr_a.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                if (i2 >= 3) {
                    i2 = 0;
                }
                bArr_a[i] = (byte) (bArr_a[i] ^ bArr[i2]);
                i++;
                i2++;
            }
            return new String(bArr_a, Charset.forName("UTF-8"));
        } catch (Exception unused) {
            return "";
        }
    }
}
