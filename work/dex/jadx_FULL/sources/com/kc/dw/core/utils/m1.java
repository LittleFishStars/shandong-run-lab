package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m1 {
    public static void a(Bitmap bitmap, byte[] bArr, boolean z, int i, int i2, int i3, w wVar) {
        SdkHandler.runOnMainThread(new i1(wVar, bArr, a(bitmap, bArr, i, i2, i3), z));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    public static Bitmap[] a(Bitmap bitmap, byte[] bArr, int i, int i2, int i3) {
        Bitmap bitmap2;
        if (bArr != null) {
            try {
                if (d0.b(bArr)) {
                    bitmap2 = null;
                } else {
                    Bitmap[] bitmapArrA = com.kc.dw.ad.k.a(i, bitmap, i2, i3);
                    if (bitmapArrA.length == 2) {
                        bitmap = bitmapArrA[0];
                        bitmap2 = bitmapArrA[1];
                    } else {
                        bitmap2 = null;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            bitmap2 = null;
        }
        return new Bitmap[]{bitmap, bitmap2};
    }
}
