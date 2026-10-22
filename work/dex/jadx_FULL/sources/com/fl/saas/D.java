package com.fl.saas;

import android.app.Activity;
import com.fl.saas.adx.base.interfaces.DeepLinkOpenListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DeepLinkOpenListener f30040a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final D f30041a = new D();
    }

    private D() {
    }

    public static D a() {
        return b.f30041a;
    }

    public void b() {
        this.f30040a = null;
    }

    public void a(int i, int i2, Activity activity) {
        DeepLinkOpenListener deepLinkOpenListener;
        if (i == 10001 && i2 == 0 && (deepLinkOpenListener = this.f30040a) != null) {
            deepLinkOpenListener.onDeepLinkOpenFailed(activity);
            this.f30040a = null;
        }
    }

    public void a(DeepLinkOpenListener deepLinkOpenListener) {
        this.f30040a = deepLinkOpenListener;
    }
}
