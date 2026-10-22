package com.alibaba.ariver.commonability.device.jsapi.nfc;

import android.content.Context;
import android.nfc.NfcAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
    }

    public static boolean b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public static boolean c(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] a(String str) {
        int length = str.length();
        if (length % 2 != 1) {
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string must have even number of characters");
    }
}
