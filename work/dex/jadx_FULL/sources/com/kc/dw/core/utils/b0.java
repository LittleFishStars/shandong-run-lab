package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import android.os.Looper;
import com.kc.dw.core.domain.HttpResponse;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b0 implements com.kc.dw.cache.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f39350a;
    public final x b;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f39351a;
        public final b0 b;

        public a(b0 b0Var, byte[] bArr) {
            this.b = b0Var;
            this.f39351a = bArr;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.b.a(this.f39351a);
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39352a;
        public final b0 b;

        public b(b0 b0Var, int i) {
            this.b = b0Var;
            this.f39352a = i;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            x xVar = this.b.b;
            if (xVar != null) {
                StringBuilder sbA = com.kc.dw.activity.a.a("download image error2:");
                sbA.append(this.f39352a);
                xVar.onFailure(new IOException(sbA.toString()));
            }
        }
    }

    public b0(boolean z, x xVar) {
        this.f39350a = z;
        this.b = xVar;
    }

    @Override // com.kc.dw.cache.d
    public void a() {
    }

    @Override // com.kc.dw.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        if (Looper.getMainLooper() == Looper.myLooper() || !this.f39350a) {
            a(bArr);
        } else {
            SdkHandler.runOnMainThread(new a(this, bArr));
        }
    }

    public final void a(byte[] bArr) {
        try {
            if (this.b != null) {
                HttpResponse<byte[]> httpResponse = new HttpResponse<>();
                httpResponse.setSuccessful(true);
                httpResponse.setResponseBody(bArr);
                this.b.onResponse(httpResponse);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.cache.d
    public void b(int i) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper() || !this.f39350a) {
                x xVar = this.b;
                if (xVar != null) {
                    xVar.onFailure(new IOException("download image error2:" + i));
                }
            } else {
                SdkHandler.runOnMainThread(new b(this, i));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
