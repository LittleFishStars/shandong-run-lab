package com.byazt.wg;

import android.app.Activity;
import android.view.View;
import com.byazt.aas.pf;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1071, 13})
public class tt {
    public boolean c;
    public boolean uj;
    public long tt = 0;
    public long ve = 0;

    public tt(String str) {
        this.uj = "rewarded_video".equalsIgnoreCase(str) || "fullscreen_interstitial_ad".equalsIgnoreCase(str);
    }

    public void c(final Activity activity, ic icVar) {
        if (activity == null || icVar == null || !icVar.qp()) {
            return;
        }
        pf.ve(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.byazt.wg.tt.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        tt.this.c();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.byazt.wg.tt.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    pf.ve(activity);
                                }
                            }, 5000L);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean tt(Activity activity, ic icVar) {
        boolean zC = false;
        if (activity != null && icVar != null) {
            boolean z = this.c;
            this.c = false;
            if (!icVar.qp() || !z) {
                return false;
            }
            if (c.c(activity) || tt()) {
                return true;
            }
            try {
                if (!this.uj || !c.c()) {
                    zC = c(activity);
                }
            } catch (Throwable unused) {
            }
        }
        return zC;
    }

    public void c(int i) {
        boolean z = i == 4;
        this.c = z;
        if (z) {
            this.tt = System.currentTimeMillis();
        }
    }

    public void c() {
        this.ve = System.currentTimeMillis();
    }

    private boolean c(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean tt() {
        long j = this.tt;
        long jAbs = j > 0 ? Math.abs(j - this.ve) : -1L;
        return jAbs >= 0 && jAbs < 300;
    }
}
