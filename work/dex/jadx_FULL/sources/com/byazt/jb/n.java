package com.byazt.jb;

import android.taobao.windvane.util.WVConstants;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 46})
public final class n {
    public static final com.byazt.mk.a c = com.byazt.mk.a.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] uj = {WVConstants.INTENT_EXTRA_DATA, "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] tt = new String[64];
    public static final String[] ve = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = ve;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.byazt.kh.ve.c("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = tt;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = tt;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = tt;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = tt;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = tt;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = ve[i];
            }
            i++;
        }
    }

    private n() {
    }

    public static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(com.byazt.kh.ve.c(str, objArr));
    }

    public static IOException tt(String str, Object... objArr) throws IOException {
        throw new IOException(com.byazt.kh.ve.c(str, objArr));
    }

    public static String c(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = uj;
        String strC = b < strArr.length ? strArr[b] : com.byazt.kh.ve.c("0x%02x", Byte.valueOf(b));
        String strC2 = c(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strC;
        objArr[4] = strC2;
        return com.byazt.kh.ve.c("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static String c(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : ve[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = tt;
                String str = b2 < strArr.length ? strArr[b2] : ve[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return ve[b2];
    }
}
