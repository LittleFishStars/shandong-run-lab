package com.kc.bw.appsdkdex.crypt;

import com.kc.bw.dexb;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMStringFogImpl implements dexb {
    public String decode(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 1);
            }
            return new String(bytes, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // com.kc.bw.dexb
    public String decrypt(String str, String str2) {
        return decode(str);
    }

    public String encode(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] + 1);
            }
            return new String(bytes, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // com.kc.bw.dexb
    public String encrypt(String str, String str2) {
        return encode(str);
    }

    @Override // com.kc.bw.dexb
    public boolean overflow(String str, String str2) {
        return str != null && (str.length() * 4) / 3 >= 65535;
    }
}
