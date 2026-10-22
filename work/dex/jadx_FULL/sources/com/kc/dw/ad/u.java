package com.kc.dw.ad;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class u extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f39173a;
    public final Bitmap b;

    public u(k kVar, ImageView imageView, Bitmap bitmap) {
        this.f39173a = imageView;
        this.b = bitmap;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        this.f39173a.setImageBitmap(this.b);
    }
}
