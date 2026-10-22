package com.zj.adlib;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class kp8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f42881a = kp8.class;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public Map<CacheKey, q13> f17771a = new HashMap();

    public static kp8 d() {
        return new kp8();
    }

    public void a() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f17771a.values());
            this.f17771a.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            q13 q13Var = (q13) arrayList.get(i);
            if (q13Var != null) {
                q13Var.close();
            }
        }
    }

    public synchronized boolean b(CacheKey cacheKey) {
        ax6.i(cacheKey);
        if (!this.f17771a.containsKey(cacheKey)) {
            return false;
        }
        q13 q13Var = this.f17771a.get(cacheKey);
        synchronized (q13Var) {
            if (q13.H(q13Var)) {
                return true;
            }
            this.f17771a.remove(cacheKey);
            ad3.m0(f42881a, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(q13Var)), cacheKey.toString(), Integer.valueOf(System.identityHashCode(cacheKey)));
            return false;
        }
    }

    public synchronized q13 c(CacheKey cacheKey) {
        ax6.i(cacheKey);
        q13 q13VarH = this.f17771a.get(cacheKey);
        if (q13VarH != null) {
            synchronized (q13VarH) {
                if (!q13.H(q13VarH)) {
                    this.f17771a.remove(cacheKey);
                    ad3.m0(f42881a, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(q13VarH)), cacheKey.toString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                q13VarH = q13.h(q13VarH);
            }
        }
        return q13VarH;
    }

    public final synchronized void e() {
        ad3.V(f42881a, "Count = %d", Integer.valueOf(this.f17771a.size()));
    }

    public synchronized void f(CacheKey cacheKey, q13 q13Var) {
        ax6.i(cacheKey);
        ax6.d(q13.H(q13Var));
        q13.j(this.f17771a.put(cacheKey, q13.h(q13Var)));
        e();
    }

    public boolean g(CacheKey cacheKey) {
        q13 q13VarRemove;
        ax6.i(cacheKey);
        synchronized (this) {
            q13VarRemove = this.f17771a.remove(cacheKey);
        }
        if (q13VarRemove == null) {
            return false;
        }
        try {
            return q13VarRemove.F();
        } finally {
            q13VarRemove.close();
        }
    }

    public synchronized boolean h(CacheKey cacheKey, q13 q13Var) {
        ax6.i(cacheKey);
        ax6.i(q13Var);
        ax6.d(q13.H(q13Var));
        q13 q13Var2 = this.f17771a.get(cacheKey);
        if (q13Var2 == null) {
            return false;
        }
        rm1<PooledByteBuffer> rm1VarL = q13Var2.l();
        rm1<PooledByteBuffer> rm1VarL2 = q13Var.l();
        if (rm1VarL != null && rm1VarL2 != null) {
            try {
                if (rm1VarL.s() == rm1VarL2.s()) {
                    this.f17771a.remove(cacheKey);
                    rm1.p(rm1VarL2);
                    rm1.p(rm1VarL);
                    q13.j(q13Var2);
                    e();
                    return true;
                }
            } catch (Throwable th) {
                rm1.p(rm1VarL2);
                rm1.p(rm1VarL);
                q13.j(q13Var2);
                throw th;
            }
        }
        rm1.p(rm1VarL2);
        rm1.p(rm1VarL);
        q13.j(q13Var2);
        return false;
    }
}
