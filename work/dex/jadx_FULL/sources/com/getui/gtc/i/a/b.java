package com.getui.gtc.i.a;

import com.getui.gtc.base.crypt.CryptTools;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {
    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        boolean z = false;
        if (length > 0 && length <= 256) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if ((bArr2[i] & 255) == 14 && (i2 = i2 + 1) > 3) {
                    break;
                }
                i++;
            }
        }
        if (!z) {
            throw new IllegalArgumentException("key is fail!");
        }
        if (bArr.length <= 0) {
            throw new IllegalArgumentException("data is fail!");
        }
        try {
            return CryptTools.encrypt("RC4", CryptTools.wrapperKey("RC4", bArr2), (IvParameterSpec) null, bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
