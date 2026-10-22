package com.kc.dw.ad;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class n extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f39124a;
    public final RelativeLayout b;
    public final RelativeLayout c;
    public final ImageView d;
    public final k e;

    public n(k kVar, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2) {
        this.e = kVar;
        this.f39124a = imageView;
        this.b = relativeLayout;
        this.c = relativeLayout2;
        this.d = imageView2;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        k kVar = this.e;
        int i = kVar.c + 1;
        kVar.c = i;
        if (i % 2 == 0) {
            this.f39124a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.d.setVisibility(0);
            k kVar2 = this.e;
            ImageView imageView = this.d;
            kVar2.getClass();
            if (imageView != null) {
                imageView.post(new o(kVar2, imageView, 1));
            }
        } else {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            k kVar3 = this.e;
            RelativeLayout relativeLayout = this.b;
            ImageView imageView2 = this.f39124a;
            kVar3.getClass();
            if (imageView2 != null) {
                imageView2.post(new q(kVar3, relativeLayout, imageView2, 1));
            }
        }
        Handler handler = k.E;
        this.e.getClass();
        handler.postDelayed(this, 800L);
    }
}
