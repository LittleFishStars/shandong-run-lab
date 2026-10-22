package com.ipd.dsp.internal.z;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f38615a;

    @Nullable
    public final f b;
    public volatile e c;
    public volatile e d;

    @GuardedBy("requestLock")
    public f.a e;

    @GuardedBy("requestLock")
    public f.a f;

    public b(Object obj, @Nullable f fVar) {
        f.a aVar = f.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.f38615a = obj;
        this.b = fVar;
    }

    public void a(e eVar, e eVar2) {
        this.c = eVar;
        this.d = eVar2;
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean b() {
        boolean z;
        synchronized (this.f38615a) {
            f.a aVar = this.e;
            f.a aVar2 = f.a.CLEARED;
            z = aVar == aVar2 && this.f == aVar2;
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean c(e eVar) {
        if (eVar instanceof b) {
            b bVar = (b) eVar;
            if (this.c.c(bVar.c) && this.d.c(bVar.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.z.e
    public void clear() {
        synchronized (this.f38615a) {
            f.a aVar = f.a.CLEARED;
            this.e = aVar;
            this.c.clear();
            if (this.f != aVar) {
                this.f = aVar;
                this.d.clear();
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public void d() {
        synchronized (this.f38615a) {
            f.a aVar = this.e;
            f.a aVar2 = f.a.RUNNING;
            if (aVar != aVar2) {
                this.e = aVar2;
                this.c.d();
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean e() {
        boolean z;
        synchronized (this.f38615a) {
            f.a aVar = this.e;
            f.a aVar2 = f.a.SUCCESS;
            z = aVar == aVar2 || this.f == aVar2;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean f() {
        f fVar = this.b;
        return fVar == null || fVar.e(this);
    }

    @GuardedBy("requestLock")
    public final boolean g() {
        f fVar = this.b;
        return fVar == null || fVar.d(this);
    }

    @Override // com.ipd.dsp.internal.z.f
    public f getRoot() {
        f root;
        synchronized (this.f38615a) {
            f fVar = this.b;
            root = fVar != null ? fVar.getRoot() : this;
        }
        return root;
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean isRunning() {
        boolean z;
        synchronized (this.f38615a) {
            f.a aVar = this.e;
            f.a aVar2 = f.a.RUNNING;
            z = aVar == aVar2 || this.f == aVar2;
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.e
    public void pause() {
        synchronized (this.f38615a) {
            f.a aVar = this.e;
            f.a aVar2 = f.a.RUNNING;
            if (aVar == aVar2) {
                this.e = f.a.PAUSED;
                this.c.pause();
            }
            if (this.f == aVar2) {
                this.f = f.a.PAUSED;
                this.d.pause();
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.f
    public void f(e eVar) {
        synchronized (this.f38615a) {
            if (eVar.equals(this.c)) {
                this.e = f.a.SUCCESS;
            } else if (eVar.equals(this.d)) {
                this.f = f.a.SUCCESS;
            }
            f fVar = this.b;
            if (fVar != null) {
                fVar.f(this);
            }
        }
    }

    @GuardedBy("requestLock")
    public final boolean g(e eVar) {
        f.a aVar = this.e;
        f.a aVar2 = f.a.FAILED;
        if (aVar != aVar2) {
            return eVar.equals(this.c);
        }
        if (!eVar.equals(this.d)) {
            return false;
        }
        f.a aVar3 = this.f;
        return aVar3 == f.a.SUCCESS || aVar3 == aVar2;
    }

    @Override // com.ipd.dsp.internal.z.f, com.ipd.dsp.internal.z.e
    public boolean a() {
        boolean z;
        synchronized (this.f38615a) {
            z = this.c.a() || this.d.a();
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.f
    public boolean b(e eVar) {
        boolean z;
        synchronized (this.f38615a) {
            z = c() && eVar.equals(this.c);
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean c() {
        f fVar = this.b;
        return fVar == null || fVar.b(this);
    }

    @Override // com.ipd.dsp.internal.z.f
    public boolean e(e eVar) {
        boolean z;
        synchronized (this.f38615a) {
            z = f() && g(eVar);
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.f
    public void a(e eVar) {
        synchronized (this.f38615a) {
            if (!eVar.equals(this.d)) {
                this.e = f.a.FAILED;
                f.a aVar = this.f;
                f.a aVar2 = f.a.RUNNING;
                if (aVar != aVar2) {
                    this.f = aVar2;
                    this.d.d();
                }
                return;
            }
            this.f = f.a.FAILED;
            f fVar = this.b;
            if (fVar != null) {
                fVar.a(this);
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.f
    public boolean d(e eVar) {
        boolean zG;
        synchronized (this.f38615a) {
            zG = g();
        }
        return zG;
    }
}
