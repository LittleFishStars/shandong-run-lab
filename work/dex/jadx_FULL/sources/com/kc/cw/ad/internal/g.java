package com.kc.cw.ad.internal;

import android.app.Activity;
import android.content.Context;
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
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f39035a;
    private NativeAdShownListener b;
    private ScheduledExecutorService c;
    private Runnable d;

    public g(View view, NativeAdShownListener nativeAdShownListener) {
        this.f39035a = view;
        this.b = nativeAdShownListener;
        b();
    }

    public static g a(View view, NativeAdShownListener nativeAdShownListener) {
        if (view == null) {
            return null;
        }
        return new g(view, nativeAdShownListener);
    }

    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        try {
            Object parent = view.getParent();
            Context context = parent != null ? ((View) parent).getContext() : view.getContext();
            if (!(context instanceof Activity)) {
                return false;
            }
            String simpleName = ((Activity) context).getClass().getSimpleName();
            String strA = com.kc.cw.ad.d.g.a(context).f38813a.a();
            return strA == null || simpleName.equals(strA);
        } catch (Exception unused) {
            return false;
        }
    }

    private void b() {
        this.d = new Runnable(this) { // from class: com.kc.cw.ad.internal.g.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final g f39036a;

            {
                this.f39036a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zC = this.f39036a.c();
                if (this.f39036a.b != null) {
                    this.f39036a.b.onAdShown(zC);
                }
            }
        };
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.c = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable(this) { // from class: com.kc.cw.ad.internal.g.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final g f39037a;

            {
                this.f39037a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f39037a.f39035a != null) {
                    this.f39037a.f39035a.post(this.f39037a.d);
                }
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i;
        View view = this.f39035a;
        if (view == null || view.getVisibility() != 0 || this.f39035a.getParent() == null) {
            return false;
        }
        try {
            if (!a(this.f39035a)) {
                return false;
            }
            Rect rect = new Rect();
            this.f39035a.getLocalVisibleRect(rect);
            DecimalFormat decimalFormat = new DecimalFormat("##0.00");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            return (rect.left == 0 && rect.top >= 0 && rect.bottom <= this.f39035a.getHeight() && ((double) Float.parseFloat(decimalFormat.format((((double) ((rect.bottom - rect.top) * rect.right)) * 1.0d) / ((double) (this.f39035a.getWidth() * this.f39035a.getHeight()))))) > 0.5d) || (rect.left > 0 && (i = rect.right) >= 0 && i <= this.f39035a.getWidth() && ((double) Float.parseFloat(decimalFormat.format((((double) ((rect.right - rect.left) * (rect.bottom - rect.top))) * 1.0d) / ((double) (this.f39035a.getWidth() * this.f39035a.getHeight()))))) > 0.5d);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            return true;
        }
    }

    public void a() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        this.b = null;
        this.f39035a = null;
        this.c = null;
    }
}
