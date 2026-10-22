package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.zj.adlib.ax6;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DeferredReleaser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DeferredReleaser f29963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f1577a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<Releasable> f1578a = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f1576a = new Handler(Looper.getMainLooper());

    public interface Releasable {
        void release();
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DeferredReleaser.d();
            Iterator it = DeferredReleaser.this.f1578a.iterator();
            while (it.hasNext()) {
                ((Releasable) it.next()).release();
            }
            DeferredReleaser.this.f1578a.clear();
        }
    }

    public static void d() {
        ax6.o(Looper.getMainLooper().getThread() == Thread.currentThread());
    }

    public static synchronized DeferredReleaser e() {
        if (f29963a == null) {
            f29963a = new DeferredReleaser();
        }
        return f29963a;
    }

    public void c(Releasable releasable) {
        d();
        this.f1578a.remove(releasable);
    }

    public void f(Releasable releasable) {
        d();
        if (this.f1578a.add(releasable) && this.f1578a.size() == 1) {
            this.f1576a.post(this.f1577a);
        }
    }
}
