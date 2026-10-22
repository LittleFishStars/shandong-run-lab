package com.kc.cw.ad.internal;

import android.graphics.Rect;
import android.view.View;
import com.kc.cw.ad.internal.nativead.NativeAdShownListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f39038a;
    private NativeAdShownListener b;
    private ScheduledExecutorService c;
    private Runnable d;

    public h(View view, NativeAdShownListener nativeAdShownListener) {
        this.f39038a = view;
        this.b = nativeAdShownListener;
        b();
    }

    public static h a(View view, NativeAdShownListener nativeAdShownListener) {
        if (view == null) {
            return null;
        }
        return new h(view, nativeAdShownListener);
    }

    private void b() {
        this.d = new Runnable(this) { // from class: com.kc.cw.ad.internal.h.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final h f39039a;

            {
                this.f39039a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f39039a.c()) {
                    if (this.f39039a.b != null) {
                        this.f39039a.b.onAdShown(true);
                    }
                    if (this.f39039a.c != null) {
                        this.f39039a.c.shutdownNow();
                    }
                    this.f39039a.b = null;
                    this.f39039a.f39038a = null;
                    this.f39039a.c = null;
                }
            }
        };
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.c = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable(this) { // from class: com.kc.cw.ad.internal.h.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final h f39040a;

            {
                this.f39040a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f39040a.f39038a != null) {
                    this.f39040a.f39038a.post(this.f39040a.d);
                }
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i;
        View view = this.f39038a;
        if (view == null || view.getVisibility() != 0 || this.f39038a.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        this.f39038a.getLocalVisibleRect(rect);
        try {
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            return (rect.left == 0 && rect.top >= 0 && rect.bottom <= this.f39038a.getHeight() && ((double) Float.parseFloat(decimalFormat.format((((double) ((rect.bottom - rect.top) * rect.right)) * 1.0d) / ((double) (this.f39038a.getWidth() * this.f39038a.getHeight()))))) > 0.5d) || (rect.left > 0 && (i = rect.right) >= 0 && i <= this.f39038a.getWidth() && ((double) Float.parseFloat(decimalFormat.format((((double) ((rect.right - rect.left) * (rect.bottom - rect.top))) * 1.0d) / ((double) (this.f39038a.getWidth() * this.f39038a.getHeight()))))) > 0.5d);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            return true;
        }
    }

    public void a() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.c = null;
        }
        View view = this.f39038a;
        if (view != null) {
            view.removeCallbacks(this.d);
            this.f39038a = null;
        }
        this.b = null;
    }
}
