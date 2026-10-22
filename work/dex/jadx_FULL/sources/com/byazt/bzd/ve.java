package com.byazt.bzd;

import com.byakv.z.TTEncryptUtils;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 54})
public class ve {
    public static byte[] c(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.c(bArr, i);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return null;
    }
}
