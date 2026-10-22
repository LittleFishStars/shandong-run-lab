package com.beizi.fusion;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPLandingPageActivity;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class a0 implements Application.ActivityLifecycleCallbacks, gd {
    private int c = 0;
    private long d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f26989a = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    private boolean a(Activity activity) {
        return b0.a().b(activity.getApplicationContext());
    }

    private void b() {
        if (this.f26989a.isEmpty()) {
            return;
        }
        Iterator it = this.f26989a.iterator();
        while (it.hasNext()) {
            ((hd) it.next()).a();
        }
    }

    private void c() {
        if (!this.f26989a.isEmpty()) {
            Iterator it = this.f26989a.iterator();
            while (it.hasNext()) {
                ((hd) it.next()).b();
            }
        }
        if (this.b.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.d;
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((z9) it2.next()).a(jCurrentTimeMillis);
        }
    }

    private void d(Activity activity) {
        if (this.f26989a.isEmpty()) {
            return;
        }
        Iterator it = this.f26989a.iterator();
        while (it.hasNext()) {
            ((hd) it.next()).c(activity);
        }
    }

    private void e(Activity activity) {
        if (this.f26989a.isEmpty()) {
            return;
        }
        Iterator it = this.f26989a.iterator();
        while (it.hasNext()) {
            ((hd) it.next()).d(activity);
        }
    }

    @Override // com.beizi.fusion.gd
    public Application.ActivityLifecycleCallbacks a() {
        return this;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof ASNPLandingPageActivity) {
            a((ASNPLandingPageActivity) activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        c(activity);
        if (!a(activity) || this.c <= 0) {
            return;
        }
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.c++;
        d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.c - 1;
        this.c = i;
        if (i < 0) {
            this.c = 0;
        }
        e(activity);
        if (a(activity) || this.c != 0) {
            return;
        }
        this.d = System.currentTimeMillis();
        b();
    }

    private void a(ASNPLandingPageActivity aSNPLandingPageActivity) {
        if (this.f26989a.isEmpty()) {
            return;
        }
        Iterator it = this.f26989a.iterator();
        while (it.hasNext()) {
            ((hd) it.next()).a(aSNPLandingPageActivity);
        }
    }

    private void b(Activity activity) {
        if (this.f26989a.isEmpty()) {
            return;
        }
        Iterator it = this.f26989a.iterator();
        while (it.hasNext()) {
            ((hd) it.next()).a(activity);
        }
    }

    @Override // com.beizi.fusion.gd
    public void a(hd hdVar) {
        this.f26989a.remove(hdVar);
    }

    @Override // com.beizi.fusion.gd
    public void a(z9 z9Var) {
        this.b.add(z9Var);
    }

    @Override // com.beizi.fusion.gd
    public void b(hd hdVar) {
        this.f26989a.add(hdVar);
    }

    private void c(Activity activity) {
        if (this.f26989a.isEmpty()) {
            return;
        }
        Iterator it = this.f26989a.iterator();
        while (it.hasNext()) {
            ((hd) it.next()).b(activity);
        }
    }

    @Override // com.beizi.fusion.gd
    public void b(z9 z9Var) {
        this.b.remove(z9Var);
    }
}
