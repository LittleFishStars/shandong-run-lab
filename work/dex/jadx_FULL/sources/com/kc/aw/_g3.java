package com.kc.aw;

import com.google.common.base.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g3 {
    public static int _a(int i, byte[] bArr) {
        int i2 = i << 2;
        return (bArr[i2 + 3] & 255) | (bArr[i2] << a.B) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
