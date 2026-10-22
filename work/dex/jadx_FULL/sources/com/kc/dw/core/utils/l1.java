package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l1 implements com.kc.dw.cache.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.cache.d f39383a;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l1 f39384a;

        public a(l1 l1Var) {
            this.f39384a = l1Var;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            super.safeRun();
            this.f39384a.f39383a.a();
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f39385a;
        public final byte[] b;
        public final boolean c;
        public final l1 d;

        public b(l1 l1Var, Bitmap bitmap, byte[] bArr, boolean z) {
            this.d = l1Var;
            this.f39385a = bitmap;
            this.b = bArr;
            this.c = z;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            super.safeRun();
            this.d.f39383a.a(this.f39385a, this.b, this.c);
        }
    }

    public l1(com.kc.dw.cache.d dVar) {
        this.f39383a = dVar;
    }

    @Override // com.kc.dw.cache.d
    public void a() {
        SdkHandler.runOnMainThread(new a(this));
    }

    @Override // com.kc.dw.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        SdkHandler.runOnMainThread(new b(this, bitmap, bArr, z));
    }

    @Override // com.kc.dw.cache.d
    public void b(int i) {
        this.f39383a.b(i);
    }
}
