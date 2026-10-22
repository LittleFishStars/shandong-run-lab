package com.kwad.sdk.f.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ai;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    private static volatile a bgv;
    private Activity mActivity;
    private int bgw = 3;
    private int bgx = 3;
    private int bgy = 3;
    private int bgz = 3;
    private AtomicBoolean bgA = new AtomicBoolean(false);
    private boolean bgB = false;
    private AtomicBoolean bgC = new AtomicBoolean(false);
    private AtomicBoolean mHasInit = new AtomicBoolean(false);

    private static int F(int i, int i2) {
        return (Build.VERSION.SDK_INT >= 34 && fa(i) && fa(i2)) ? 1 : 2;
    }

    public static a Ra() {
        if (bgv == null) {
            synchronized (a.class) {
                if (bgv == null) {
                    bgv = new a();
                }
            }
        }
        return bgv;
    }

    private void Rb() {
        this.bgw = Build.VERSION.SDK_INT;
        b.LW();
        b.a(new d() { // from class: com.kwad.sdk.f.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.this.mActivity = activity;
                    if (a.this.bgC.get()) {
                        return;
                    }
                    a aVar = a.this;
                    aVar.bgy = a.b(aVar, activity);
                    a aVar2 = a.this;
                    aVar2.bgx = a.c(aVar2, activity);
                    a.this.Rc();
                } catch (Throwable th) {
                    c.e("HdrHelper", "collectHdrAbility error", th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                a.this.mActivity = null;
                b.LW();
                b.b((com.kwad.sdk.core.c.c) this);
                super.b(activity);
            }
        });
    }

    private boolean Rd() {
        if (this.bgC.get()) {
            return true;
        }
        this.bgC.set(ai.m("ksadsdk_pref", "hdr_has_reported", false));
        return this.bgC.get();
    }

    public static /* synthetic */ int c(a aVar, Activity activity) {
        return o(activity);
    }

    private static boolean eY(int i) {
        return (i & 1) != 0;
    }

    private static boolean eZ(int i) {
        return (i & 2) != 0;
    }

    private static boolean fa(int i) {
        return i == 1;
    }

    private static int o(Activity activity) {
        try {
            int colorMode = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(2);
            int colorMode2 = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(colorMode);
            return colorMode2 == 2 ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getColorModeSupport error", th);
            return 3;
        }
    }

    private static int p(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT < 34) {
                return 3;
            }
            Display display = activity.getDisplay();
            return display != null ? ((Boolean) ab.f(display, "isHdrSdrRatioAvailable", new Object[0])).booleanValue() : false ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getScreenHdrAvailable error", th);
            return 3;
        }
    }

    private void report() {
        this.bgz = F(this.bgx, this.bgy);
        this.bgw = Build.VERSION.SDK_INT;
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(1.0d).Q("ad_sdk_hdr", "stats_ranger").A(new com.kwad.sdk.f.a.a.a(this.bgw, this.bgx, this.bgy, this.bgz)).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
    }

    public final void Rc() {
        if (!this.bgB || Rd()) {
            return;
        }
        report();
        ai.l("ksadsdk_pref", "hdr_has_reported", true);
        this.bgC.set(true);
    }

    public final void init(int i) {
        if (this.mHasInit.get() || i == 0) {
            return;
        }
        Rb();
        if (eY(i)) {
            this.bgB = true;
        }
        if (eZ(i)) {
            this.bgA.set(true);
        }
        this.mHasInit.set(true);
    }

    public static /* synthetic */ int b(a aVar, Activity activity) {
        return p(activity);
    }
}
