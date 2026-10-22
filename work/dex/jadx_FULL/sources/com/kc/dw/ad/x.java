package com.kc.dw.ad;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.d0;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class x extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39213a;
    public final ImageView b;
    public final k c;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f39214a;
        public final x b;

        public a(x xVar, Bitmap bitmap) {
            this.b = xVar;
            this.f39214a = bitmap;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                if (this.f39214a != null) {
                    this.b.c.f39105a.getApplicationContext();
                    this.b.b.setImageBitmap(d0.a(this.f39214a, 25));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public x(k kVar, NormalMediaView normalMediaView, ImageView imageView) {
        this.c = kVar;
        this.f39213a = normalMediaView;
        this.b = imageView;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            Bitmap videoThumb = this.f39213a.getVideoThumb();
            if (videoThumb != null) {
                SdkHandler.getInstance().runOnUiThread(new a(this, videoThumb));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
