package cj.mobile.wm.appsdkdex.crypt;

import cj.mobile.wm.dexn;
import cj.mobile.wm.dexp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@dexp
public class WMStringFogImpl implements dexn {
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

    @Override // cj.mobile.wm.dexn
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

    @Override // cj.mobile.wm.dexn
    public String encrypt(String str, String str2) {
        return encode(str);
    }

    @Override // cj.mobile.wm.dexn
    public boolean overflow(String str, String str2) {
        return str != null && (str.length() * 4) / 3 >= 65535;
    }
}
