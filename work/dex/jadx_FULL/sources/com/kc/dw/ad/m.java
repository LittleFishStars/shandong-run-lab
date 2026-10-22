package com.kc.dw.ad;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f39123a;
    public final ImageView b;
    public final RelativeLayout c;
    public final k d;

    public m(k kVar, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout) {
        this.d = kVar;
        this.f39123a = imageView;
        this.b = imageView2;
        this.c = relativeLayout;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        ImageView imageView;
        Runnable pVar;
        k kVar = this.d;
        int i = kVar.c + 1;
        kVar.c = i;
        if (i % 2 == 0) {
            this.f39123a.setVisibility(8);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            k kVar2 = this.d;
            imageView = this.b;
            kVar2.getClass();
            if (imageView != null) {
                pVar = new o(kVar2, imageView, 1);
                imageView.post(pVar);
            }
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.f39123a.setVisibility(0);
            k kVar3 = this.d;
            imageView = this.f39123a;
            kVar3.getClass();
            if (imageView != null) {
                pVar = new p(kVar3, imageView, 1);
                imageView.post(pVar);
            }
        }
        Handler handler = k.E;
        this.d.getClass();
        handler.postDelayed(this, 800L);
    }
}
