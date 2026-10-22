package com.beizi.fusion;

import android.graphics.Rect;
import android.view.View;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f27210a;
    private oi b;
    private yn c;
    private ScheduledThreadPoolExecutor d;
    private Runnable e;
    private DecimalFormatSymbols f = new DecimalFormatSymbols(Locale.ENGLISH);
    private Format g = new DecimalFormat("0.00", this.f);
    private boolean h = false;
    private boolean i = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: com.beizi.fusion.e5$a$a, reason: collision with other inner class name */
        public class RunnableC0306a implements Runnable {

            /* JADX INFO: renamed from: com.beizi.fusion.e5$a$a$a, reason: collision with other inner class name */
            public class RunnableC0307a implements Runnable {
                public RunnableC0307a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    oi oiVar = e5.this.b;
                    if (oiVar != null) {
                        oiVar.onAdShown();
                    }
                }
            }

            public RunnableC0306a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                yn ynVar;
                e5 e5Var = e5.this;
                if (e5Var.h || e5Var.a(10)) {
                    e5 e5Var2 = e5.this;
                    if (!e5Var2.h && (ynVar = e5Var2.c) != null) {
                        e5Var2.h = true;
                        ynVar.a();
                    }
                    e5 e5Var3 = e5.this;
                    if (!e5Var3.i && e5Var3.a(50)) {
                        e5 e5Var4 = e5.this;
                        e5Var4.i = true;
                        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = e5Var4.d;
                        if (scheduledThreadPoolExecutor != null) {
                            scheduledThreadPoolExecutor.remove(e5Var4.e);
                            e5.this.d = null;
                        }
                        View view = e5.this.f27210a;
                        if (view != null) {
                            view.post(new RunnableC0307a());
                        }
                    }
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e5.this.e = new RunnableC0306a();
            e5.this.d = w3.c().d();
            e5 e5Var = e5.this;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = e5Var.d;
            if (scheduledThreadPoolExecutor == null) {
                return;
            }
            scheduledThreadPoolExecutor.scheduleWithFixedDelay(e5Var.e, 0L, 250L, TimeUnit.MILLISECONDS);
        }
    }

    public e5(View view, oi oiVar, yn ynVar) {
        this.f27210a = view;
        this.b = oiVar;
        this.c = ynVar;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        try {
            View view = this.f27210a;
            if (view != null && view.getVisibility() == 0 && this.f27210a.getParent() != null) {
                Rect rect = new Rect();
                if (!this.f27210a.getGlobalVisibleRect(rect)) {
                    return false;
                }
                int iHeight = rect.height() * rect.width();
                int height = this.f27210a.getHeight() * this.f27210a.getWidth();
                if (height > 0 && iHeight * 100 >= i * height) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void b() {
        View view = this.f27210a;
        if (view == null) {
            return;
        }
        view.post(new a());
    }

    public void a() {
        Runnable runnable;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.d;
            if (scheduledThreadPoolExecutor != null && (runnable = this.e) != null) {
                scheduledThreadPoolExecutor.remove(runnable);
            }
            this.c = null;
            this.b = null;
            this.f27210a = null;
            this.d = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
