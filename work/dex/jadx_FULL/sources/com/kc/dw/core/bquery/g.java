package com.kc.dw.core.bquery;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.d0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g implements com.kc.dw.cache.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoftReference f39239a;
    public final String b;
    public final boolean c;

    @Keep
    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f39240a;
        public final Bitmap b;

        public a(g gVar, ImageView imageView, Bitmap bitmap) {
            this.f39240a = imageView;
            this.b = bitmap;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39240a.setImageBitmap(this.b);
        }
    }

    public g(SoftReference softReference, String str, boolean z) {
        this.f39239a = softReference;
        this.b = str;
        this.c = z;
    }

    @Override // com.kc.dw.cache.d
    public void a() {
    }

    @Override // com.kc.dw.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        if (bitmap != null) {
            try {
                ImageView imageView = (ImageView) this.f39239a.get();
                if (imageView == null || imageView.getTag() == null || !imageView.getTag().equals(this.b)) {
                    return;
                }
                if (this.c) {
                    com.kc.dw.base.a.getContext();
                    bitmap = d0.a(bitmap, 25);
                }
                SdkHandler.runOnMainThread(new a(this, imageView, bitmap));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.cache.d
    public void b(int i) {
    }
}
