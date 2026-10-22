package com.ipd.dsp.internal.w;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class o {
    public static final String d = "RequestTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<com.ipd.dsp.internal.z.e> f38584a = Collections.newSetFromMap(new WeakHashMap());
    public final Set<com.ipd.dsp.internal.z.e> b = new HashSet();
    public boolean c;

    @VisibleForTesting
    public void a(com.ipd.dsp.internal.z.e eVar) {
        this.f38584a.add(eVar);
    }

    public boolean b(@Nullable com.ipd.dsp.internal.z.e eVar) {
        boolean z = true;
        if (eVar == null) {
            return true;
        }
        boolean zRemove = this.f38584a.remove(eVar);
        if (!this.b.remove(eVar) && !zRemove) {
            z = false;
        }
        if (z) {
            eVar.clear();
        }
        return z;
    }

    public void c(@NonNull com.ipd.dsp.internal.z.e eVar) {
        this.f38584a.add(eVar);
        if (!this.c) {
            eVar.d();
            return;
        }
        eVar.clear();
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(d, "Paused, delaying request");
        }
        this.b.add(eVar);
    }

    public void d() {
        this.c = true;
        for (com.ipd.dsp.internal.z.e eVar : com.ipd.dsp.internal.d0.o.a(this.f38584a)) {
            if (eVar.isRunning()) {
                eVar.pause();
                this.b.add(eVar);
            }
        }
    }

    public void e() {
        for (com.ipd.dsp.internal.z.e eVar : com.ipd.dsp.internal.d0.o.a(this.f38584a)) {
            if (!eVar.e() && !eVar.b()) {
                eVar.clear();
                if (this.c) {
                    this.b.add(eVar);
                } else {
                    eVar.d();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (com.ipd.dsp.internal.z.e eVar : com.ipd.dsp.internal.d0.o.a(this.f38584a)) {
            if (!eVar.e() && !eVar.isRunning()) {
                eVar.d();
            }
        }
        this.b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f38584a.size() + ", isPaused=" + this.c + "}";
    }

    public void a() {
        Iterator it = com.ipd.dsp.internal.d0.o.a(this.f38584a).iterator();
        while (it.hasNext()) {
            b((com.ipd.dsp.internal.z.e) it.next());
        }
        this.b.clear();
    }

    public boolean b() {
        return this.c;
    }

    public void c() {
        this.c = true;
        for (com.ipd.dsp.internal.z.e eVar : com.ipd.dsp.internal.d0.o.a(this.f38584a)) {
            if (eVar.isRunning() || eVar.e()) {
                eVar.clear();
                this.b.add(eVar);
            }
        }
    }
}
