package com.byazt.h;

import androidx.annotation.NonNull;
import com.huachenjie.base.widget.OperatePopupWindow;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 13})
public class tt implements n, uj, ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f28598a;
    public final int c;
    public volatile boolean da;
    public c i;
    public c n;
    public int sl;
    public c sp;
    public final int tt;
    public c x;
    public final Object ve = new Object();
    public final Object uj = new Object();

    public tt(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.c = i;
        this.tt = i2;
    }

    @Override // com.byazt.h.uj
    @NonNull
    public c c() throws InterruptedException, m {
        c cVar;
        c cVar2 = this.i;
        if (cVar2 != null) {
            this.i = cVar2.uj;
            cVar2.uj = null;
            return cVar2;
        }
        synchronized (this.uj) {
            cVar = this.sp;
            while (cVar == null) {
                if (this.da) {
                    throw new m(OperatePopupWindow.h);
                }
                this.uj.wait();
                cVar = this.sp;
            }
            this.i = cVar.uj;
            this.x = null;
            this.sp = null;
            cVar.uj = null;
        }
        return cVar;
    }

    @Override // com.byazt.h.ve
    @NonNull
    public c tt() throws InterruptedException, m {
        synchronized (this.ve) {
            if (this.da) {
                throw new m("obtain");
            }
            c cVar = this.n;
            if (cVar == null) {
                int i = this.sl;
                if (i < this.c) {
                    this.sl = i + 1;
                    return new c(this.tt);
                }
                do {
                    this.ve.wait();
                    if (this.da) {
                        throw new m("obtain");
                    }
                    cVar = this.n;
                } while (cVar == null);
            }
            this.n = cVar.uj;
            if (cVar == this.f28598a) {
                this.f28598a = null;
            }
            cVar.uj = null;
            return cVar;
        }
    }

    public void ve() {
        this.da = true;
        synchronized (this.ve) {
            this.ve.notifyAll();
        }
        synchronized (this.uj) {
            this.uj.notifyAll();
        }
    }

    @Override // com.byazt.h.ve
    public void c(@NonNull c cVar) {
        synchronized (this.ve) {
            c cVar2 = this.f28598a;
            if (cVar2 == null) {
                this.f28598a = cVar;
                this.n = cVar;
            } else {
                cVar2.uj = cVar;
                this.f28598a = cVar;
            }
            this.ve.notify();
        }
    }

    @Override // com.byazt.h.n
    public void tt(@NonNull c cVar) {
        synchronized (this.uj) {
            c cVar2 = this.x;
            if (cVar2 == null) {
                this.x = cVar;
                this.sp = cVar;
                this.uj.notify();
            } else {
                cVar2.uj = cVar;
                this.x = cVar;
            }
        }
    }
}
