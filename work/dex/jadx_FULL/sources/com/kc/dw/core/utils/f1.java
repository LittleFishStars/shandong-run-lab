package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f1 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f39364a;
    public final byte[] b;
    public final int c;
    public final int d;
    public final int e;
    public final w f;

    public f1(Bitmap bitmap, byte[] bArr, int i, int i2, int i3, w wVar) {
        this.f39364a = bitmap;
        this.b = bArr;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = wVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        super.safeRun();
        Bitmap bitmap = this.f39364a;
        if (bitmap != null) {
            m1.a(bitmap, this.b, true, this.c, this.d, this.e, this.f);
        } else {
            this.f.b(4, new IOException("response invalid"));
        }
    }
}
