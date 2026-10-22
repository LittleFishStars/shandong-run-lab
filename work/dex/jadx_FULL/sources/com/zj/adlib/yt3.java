package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.google.android.exoplayer2.text.cea.a;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class yt3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46115a = 10;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f20926a = {0, a.e, -7, 4};
    public static final byte[] b = {0, a.m};
    public static final byte[] c = {0, a.e};

    @VisibleForTesting
    public static boolean a(byte[] bArr, int i, byte[] bArr2) {
        ax6.i(bArr);
        ax6.i(bArr2);
        ax6.d(i >= 0);
        if (bArr2.length > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[(i2 + i) % bArr.length] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(InputStream inputStream) {
        byte[] bArr = new byte[10];
        try {
            inputStream.read(bArr, 0, 10);
            int i = 0;
            int i2 = 0;
            while (inputStream.read(bArr, i, 1) > 0) {
                int i3 = i + 1;
                if (a(bArr, i3, f20926a)) {
                    int i4 = i + 9;
                    if ((a(bArr, i4, b) || a(bArr, i4, c)) && (i2 = i2 + 1) > 1) {
                        return true;
                    }
                }
                i = i3 % 10;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
