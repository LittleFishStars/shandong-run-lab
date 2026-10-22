package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i1 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f39374a;
    public final byte[] b;
    public final Bitmap[] c;
    public final boolean d;

    public i1(w wVar, byte[] bArr, Bitmap[] bitmapArr, boolean z) {
        this.f39374a = wVar;
        this.b = bArr;
        this.c = bitmapArr;
        this.d = z;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            w wVar = this.f39374a;
            byte[] bArr = this.b;
            Bitmap[] bitmapArr = this.c;
            wVar.a(bArr, bitmapArr[0], bitmapArr[1], this.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
