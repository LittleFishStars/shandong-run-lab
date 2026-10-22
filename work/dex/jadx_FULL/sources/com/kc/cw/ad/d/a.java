package com.kc.cw.ad.d;

import android.content.Context;
import android.os.Handler;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38770a = 0;
    public int b = 0;

    public void a(Context context, double d, double d2, int i) {
        if (context == null) {
            return;
        }
        try {
            this.f38770a = ViewUtil.getScreenWidth(context);
            this.b = ViewUtil.getScreenHeight(context);
            new Handler().postDelayed(new Runnable(this, d, d2) { // from class: com.kc.cw.ad.d.a.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final double f38771a;
                final double b;
                final a c;

                {
                    this.c = this;
                    this.f38771a = d;
                    this.b = d2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = this.c;
                    int i2 = (int) (((double) aVar.f38770a) * this.f38771a);
                    try {
                        new ProcessBuilder(com.alibaba.triver.triver_render.view.input.a.f25238a, "tap", "" + i2, "" + ((int) (((double) aVar.b) * this.b))).start();
                    } catch (Exception e) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
            }, i);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }
}
