package com.beizi.fusion;

import android.graphics.Rect;
import android.view.View;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f27167a;
    private yn b;
    private ScheduledThreadPoolExecutor c;
    private Runnable d;
    private boolean e = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yn ynVar;
            d5 d5Var = d5.this;
            if (d5Var.e || d5Var.b()) {
                d5 d5Var2 = d5.this;
                if (d5Var2.e || (ynVar = d5Var2.b) == null) {
                    return;
                }
                d5Var2.e = true;
                ynVar.a();
                d5 d5Var3 = d5.this;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = d5Var3.c;
                if (scheduledThreadPoolExecutor != null) {
                    scheduledThreadPoolExecutor.remove(d5Var3.d);
                    d5.this.c = null;
                }
            }
        }
    }

    public d5(View view, yn ynVar) {
        this.f27167a = view;
        this.b = ynVar;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        try {
            View view = this.f27167a;
            if (view != null && view.getVisibility() == 0 && this.f27167a.getParent() != null) {
                Rect rect = new Rect();
                if (this.f27167a.getGlobalVisibleRect(rect)) {
                    return this.f27167a.getHeight() * this.f27167a.getWidth() > 0 && rect.height() * rect.width() > 0;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c() {
        if (this.f27167a == null) {
            return;
        }
        this.d = new a();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorD = w3.c().d();
        this.c = scheduledThreadPoolExecutorD;
        scheduledThreadPoolExecutorD.scheduleWithFixedDelay(this.d, 0L, 100L, TimeUnit.MILLISECONDS);
    }

    public void a() {
        Runnable runnable;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.c;
            if (scheduledThreadPoolExecutor != null && (runnable = this.d) != null) {
                scheduledThreadPoolExecutor.remove(runnable);
            }
            this.b = null;
            this.f27167a = null;
            this.c = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
