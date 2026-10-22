package com.kc.cw.ad.internal;

import android.graphics.Rect;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class y {
    private View c;
    private Runnable e;
    private ScheduledExecutorService f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f39068a = false;
    private boolean b = false;
    private ArrayList<a> d = new ArrayList<>();

    @Keep
    public interface a {
        void a(boolean z);
    }

    private y(View view) {
        this.c = view;
        a();
    }

    public static y a(View view) {
        if (view != null) {
            return new y(view);
        }
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.l, "Unable to check visibility");
        return null;
    }

    public void a() {
        if (this.f39068a) {
            return;
        }
        this.f39068a = true;
        this.e = new Runnable(this) { // from class: com.kc.cw.ad.internal.y.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final y f39069a;

            {
                this.f39069a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f39069a.d != null) {
                    ArrayList arrayList = new ArrayList(this.f39069a.d);
                    boolean zB = this.f39069a.b();
                    Iterator it = arrayList.iterator();
                    if (!zB) {
                        while (it.hasNext()) {
                            ((a) it.next()).a(false);
                        }
                    } else {
                        while (it.hasNext()) {
                            ((a) it.next()).a(true);
                        }
                        this.f39069a.b = true;
                    }
                }
            }
        };
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable(this) { // from class: com.kc.cw.ad.internal.y.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final y f39070a;

            {
                this.f39070a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f39070a.c.post(this.f39070a.e);
                if (!this.f39070a.b || this.f39070a.f == null) {
                    return;
                }
                this.f39070a.f.shutdownNow();
                this.f39070a.f = null;
            }
        }, 0L, 250L, TimeUnit.MILLISECONDS);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.d.add(aVar);
        }
    }

    public void b(a aVar) {
        this.d.remove(aVar);
    }

    public boolean b() {
        View view = this.c;
        if (view == null || view.getVisibility() != 0 || this.c.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!this.c.getGlobalVisibleRect(rect)) {
            return false;
        }
        int iHeight = rect.height();
        int iWidth = rect.width();
        int height = this.c.getHeight() * this.c.getWidth();
        return height > 0 && (iHeight * iWidth) * 100 >= height * 50;
    }

    public void c() {
        ScheduledExecutorService scheduledExecutorService = this.f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f = null;
        }
        View view = this.c;
        if (view != null) {
            view.removeCallbacks(this.e);
            this.c = null;
        }
        this.d = null;
    }
}
