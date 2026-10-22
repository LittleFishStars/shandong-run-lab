package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a1<TResult> {
    public boolean b;
    public TResult c;
    public Exception d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f32637a = new Object();
    public List<j0<TResult>> e = new ArrayList();

    public final void a() {
        synchronized (this.f32637a) {
            Iterator<j0<TResult>> it = this.e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.f32637a) {
            exc = this.d;
        }
        return exc;
    }

    public final TResult c() {
        TResult tresult;
        synchronized (this.f32637a) {
            if (this.d != null) {
                throw new RuntimeException(this.d);
            }
            tresult = this.c;
        }
        return tresult;
    }

    public final boolean d() {
        synchronized (this.f32637a) {
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0010  */
    public final boolean e() {
        boolean z;
        synchronized (this.f32637a) {
            if (this.b) {
                d();
                if (this.d == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public final a1<TResult> a(j0<TResult> j0Var) {
        synchronized (this.f32637a) {
            if (!this.b) {
                this.e.add(j0Var);
            } else {
                j0Var.a(this);
            }
        }
        return this;
    }
}
