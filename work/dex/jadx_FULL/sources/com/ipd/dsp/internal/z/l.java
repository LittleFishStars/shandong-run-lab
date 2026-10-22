package com.ipd.dsp.internal.z;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final f f38617a;
    public final Object b;
    public volatile e c;
    public volatile e d;

    @GuardedBy("requestLock")
    public f.a e;

    @GuardedBy("requestLock")
    public f.a f;

    @GuardedBy("requestLock")
    public boolean g;

    public l(Object obj, @Nullable f fVar) {
        f.a aVar = f.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.b = obj;
        this.f38617a = fVar;
    }

    @GuardedBy("requestLock")
    private boolean c() {
        f fVar = this.f38617a;
        return fVar == null || fVar.b(this);
    }

    @GuardedBy("requestLock")
    private boolean f() {
        f fVar = this.f38617a;
        return fVar == null || fVar.e(this);
    }

    @GuardedBy("requestLock")
    private boolean g() {
        f fVar = this.f38617a;
        return fVar == null || fVar.d(this);
    }

    public void a(e eVar, e eVar2) {
        this.c = eVar;
        this.d = eVar2;
    }

    @Override // com.ipd.dsp.internal.z.f
    public boolean b(e eVar) {
        boolean z;
        synchronized (this.b) {
            z = c() && eVar.equals(this.c) && this.e != f.a.PAUSED;
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.e
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            f.a aVar = f.a.CLEARED;
            this.e = aVar;
            this.f = aVar;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // com.ipd.dsp.internal.z.f
    public boolean d(e eVar) {
        boolean z;
        synchronized (this.b) {
            z = g() && (eVar.equals(this.c) || this.e != f.a.SUCCESS);
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.f
    public boolean e(e eVar) {
        boolean z;
        synchronized (this.b) {
            z = f() && eVar.equals(this.c) && !a();
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.f
    public f getRoot() {
        f root;
        synchronized (this.b) {
            f fVar = this.f38617a;
            root = fVar != null ? fVar.getRoot() : this;
        }
        return root;
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == f.a.RUNNING;
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.e
    public void pause() {
        synchronized (this.b) {
            if (!this.f.a()) {
                this.f = f.a.PAUSED;
                this.d.pause();
            }
            if (!this.e.a()) {
                this.e = f.a.PAUSED;
                this.c.pause();
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean c(e eVar) {
        if (eVar instanceof l) {
            l lVar = (l) eVar;
            if (this.c != null ? this.c.c(lVar.c) : lVar.c == null) {
                if (this.d == null) {
                    if (lVar.d == null) {
                        return true;
                    }
                } else if (this.d.c(lVar.d)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.z.f
    public void f(e eVar) {
        synchronized (this.b) {
            if (eVar.equals(this.d)) {
                this.f = f.a.SUCCESS;
                return;
            }
            this.e = f.a.SUCCESS;
            f fVar = this.f38617a;
            if (fVar != null) {
                fVar.f(this);
            }
            if (!this.f.a()) {
                this.d.clear();
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.f, com.ipd.dsp.internal.z.e
    public boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.d.a() || this.c.a();
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.e == f.a.CLEARED;
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.e
    public void d() {
        synchronized (this.b) {
            this.g = true;
            try {
                if (this.e != f.a.SUCCESS) {
                    f.a aVar = this.f;
                    f.a aVar2 = f.a.RUNNING;
                    if (aVar != aVar2) {
                        this.f = aVar2;
                        this.d.d();
                    }
                }
                if (this.g) {
                    f.a aVar3 = this.e;
                    f.a aVar4 = f.a.RUNNING;
                    if (aVar3 != aVar4) {
                        this.e = aVar4;
                        this.c.d();
                    }
                }
                this.g = false;
            } catch (Throwable th) {
                this.g = false;
                throw th;
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.e == f.a.SUCCESS;
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.f
    public void a(e eVar) {
        synchronized (this.b) {
            if (!eVar.equals(this.c)) {
                this.f = f.a.FAILED;
                return;
            }
            this.e = f.a.FAILED;
            f fVar = this.f38617a;
            if (fVar != null) {
                fVar.a(this);
            }
        }
    }
}
