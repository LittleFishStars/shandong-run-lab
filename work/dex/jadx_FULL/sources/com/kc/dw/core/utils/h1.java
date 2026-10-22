package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h1 implements com.kc.dw.cache.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f39368a;
    public final int b;
    public final int c;
    public final int d;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1 f39369a;

        public a(h1 h1Var) {
            this.f39369a = h1Var;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39369a.f39368a.onStartDownload();
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39370a;
        public final h1 b;

        public b(h1 h1Var, int i) {
            this.b = h1Var;
            this.f39370a = i;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.b.f39368a.b(this.f39370a, new IOException("image download error"));
        }
    }

    public h1(w wVar, int i, int i2, int i3) {
        this.f39368a = wVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // com.kc.dw.cache.d
    public void a() {
        SdkHandler.runOnMainThread(new a(this));
    }

    @Override // com.kc.dw.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        m1.a(bitmap, bArr, z, this.b, this.c, this.d, this.f39368a);
    }

    @Override // com.kc.dw.cache.d
    public void b(int i) {
        this.f39368a.a(i, new IOException("image download error"));
        SdkHandler.runOnMainThread(new b(this, i));
    }
}
