package com.facebook.common.references;

import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.ad3;
import com.zj.adlib.ax6;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting
public class SharedReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("itself")
    public static final Map<Object, Integer> f29954a = new IdentityHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public int f1558a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ResourceReleaser<T> f1559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public T f1560a;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        this.f1560a = (T) ax6.i(t);
        this.f1559a = (ResourceReleaser) ax6.i(resourceReleaser);
        a(t);
    }

    public static void a(Object obj) {
        Map<Object, Integer> map = f29954a;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    public static boolean i(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.h();
    }

    public static void j(Object obj) {
        Map<Object, Integer> map = f29954a;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                ad3.y0("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                map.remove(obj);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized void b() {
        e();
        this.f1558a++;
    }

    public final synchronized int c() {
        int i;
        e();
        ax6.d(this.f1558a > 0);
        i = this.f1558a - 1;
        this.f1558a = i;
        return i;
    }

    public void d() {
        T t;
        if (c() == 0) {
            synchronized (this) {
                t = this.f1560a;
                this.f1560a = null;
            }
            this.f1559a.a(t);
            j(t);
        }
    }

    public final void e() {
        if (!i(this)) {
            throw new NullReferenceException();
        }
    }

    public synchronized T f() {
        return this.f1560a;
    }

    public synchronized int g() {
        return this.f1558a;
    }

    public synchronized boolean h() {
        return this.f1558a > 0;
    }
}
