package com.ipd.dsp.internal.s1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class h extends com.ipd.dsp.internal.x1.c implements e.b {
    public com.ipd.dsp.internal.e1.d g;
    public com.ipd.dsp.internal.j1.b h;
    public com.ipd.dsp.internal.j1.c i;
    public final boolean j;
    public e k;
    public a l;
    public b m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public int r;
    public final AtomicBoolean s;
    public final AtomicBoolean t;
    public final AtomicBoolean u;

    public interface a {
        void a();

        void a(int i);

        void a(int i, int i2);

        void a(int i, String str);
    }

    public interface b {
        void g();
    }

    public h(Context context, com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, boolean z) {
        this(context, dVar, bVar, z, false);
    }

    public void a(b bVar, boolean z) {
        this.m = bVar;
        this.n = z;
    }

    public boolean b(boolean z) {
        if (!z) {
            return false;
        }
        if (this.g != null && this.k != null && j()) {
            m();
            return true;
        }
        if (this.q) {
            return false;
        }
        n();
        return true;
    }

    public Bitmap getCapture() {
        e eVar = this.k;
        if (eVar == null || !this.p) {
            return null;
        }
        try {
            return eVar.getCurrentFrame();
        } catch (Throwable th) {
            k.a("TVA", th);
            return null;
        }
    }

    public void h() {
        if (this.k == null || !o.c(this.g.q.f)) {
            return;
        }
        this.k.setVideo(this.g.q.f);
        this.k.b();
    }

    public void i() {
        if (this.q) {
            return;
        }
        this.q = true;
        m();
    }

    public final boolean j() {
        e eVar = this.k;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.isPlaying();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void k() {
        com.ipd.dsp.internal.j1.b bVar;
        if (this.g == null || (bVar = this.h) == null) {
            return;
        }
        com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.B);
    }

    public void l() {
        e eVar = this.k;
        if (eVar != null) {
            try {
                eVar.d();
            } catch (Throwable th) {
                r.a(th);
            }
            this.k = null;
        }
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.m = null;
    }

    public void m() {
        if (this.g == null || this.k == null || !j()) {
            return;
        }
        try {
            this.r = this.k.c();
            com.ipd.dsp.internal.h1.a.a(this.h, com.ipd.dsp.internal.h1.a.e.v);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public void n() {
        e eVar = this.k;
        if (eVar == null || !this.p) {
            return;
        }
        try {
            if (this.q) {
                eVar.seekTo(this.o * 1000);
                return;
            }
            com.ipd.dsp.internal.j1.c cVar = this.i;
            if (cVar != null) {
                cVar.f();
            }
            this.k.a(this.r);
            if (this.r != 0) {
                com.ipd.dsp.internal.h1.a.a(this.h, com.ipd.dsp.internal.h1.a.e.w);
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public void o() {
        com.ipd.dsp.internal.j1.b bVar;
        if (this.g == null || this.q || (bVar = this.h) == null) {
            return;
        }
        com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.A);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        e eVar = this.k;
        if (eVar != null) {
            eVar.setBackgroundColor(i);
        }
    }

    public void setInteractionListener(a aVar) {
        this.l = aVar;
    }

    public void setVideoCoverCallback(b bVar) {
        a(bVar, false);
    }

    public h(Context context, com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, boolean z, boolean z2) {
        super(context);
        this.p = false;
        this.q = false;
        this.s = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.g = dVar;
        this.h = bVar;
        com.ipd.dsp.internal.j1.c cVar = new com.ipd.dsp.internal.j1.c();
        this.i = cVar;
        bVar.a(cVar);
        this.j = z2;
        e eVar = new e(context);
        this.k = eVar;
        eVar.setListener(this);
        this.k.a(z);
        this.k.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.k, layoutParams);
    }

    public void a(boolean z) {
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(z);
        }
        com.ipd.dsp.internal.h1.a.a(this.h, z ? com.ipd.dsp.internal.h1.a.e.y : com.ipd.dsp.internal.h1.a.e.x);
    }

    @Override // com.ipd.dsp.internal.s1.e.b
    public void b(int i) {
        e eVar;
        b bVar;
        if (this.q || (eVar = this.k) == null) {
            return;
        }
        this.p = true;
        this.o = i;
        if ((this.n || eVar.a()) && (bVar = this.m) != null) {
            bVar.g();
        }
        this.k.a(this.r);
        com.ipd.dsp.internal.j1.c cVar = this.i;
        if (cVar != null) {
            cVar.a(i);
        }
        if (this.g != null) {
            com.ipd.dsp.internal.h1.a.a(this.h, com.ipd.dsp.internal.h1.a.e.o);
            if (this.j) {
                com.ipd.dsp.internal.h1.a.a(this.h, com.ipd.dsp.internal.h1.a.e.z);
            }
        }
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.r / 1000, this.o);
        }
    }

    @Override // com.ipd.dsp.internal.s1.e.b
    public void a(int i) {
        e eVar = this.k;
        if (eVar != null) {
            int playDuration = eVar.getPlayDuration();
            int i2 = playDuration / 1000;
            com.ipd.dsp.internal.j1.c cVar = this.i;
            if (cVar != null) {
                cVar.b(playDuration);
            }
            a aVar = this.l;
            if (aVar != null) {
                aVar.a(i2);
            }
            com.ipd.dsp.internal.j1.b bVar = this.h;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar);
                float f = i2;
                if (f / this.o > 0.25f && !this.s.getAndSet(true)) {
                    com.ipd.dsp.internal.h1.a.a(this.h, com.ipd.dsp.internal.h1.a.e.p);
                }
                if (f / this.o > 0.5f && !this.t.getAndSet(true)) {
                    com.ipd.dsp.internal.h1.a.a(this.h, com.ipd.dsp.internal.h1.a.e.q);
                }
                if (f / this.o <= 0.75f || this.u.getAndSet(true)) {
                    return;
                }
                com.ipd.dsp.internal.h1.a.a(this.h, com.ipd.dsp.internal.h1.a.e.r);
            }
        }
    }

    @Override // com.ipd.dsp.internal.s1.e.b
    public void a() {
        this.q = true;
        com.ipd.dsp.internal.j1.c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
        a aVar = this.l;
        if (aVar != null) {
            aVar.a();
        }
        com.ipd.dsp.internal.j1.b bVar = this.h;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.s);
        }
    }

    @Override // com.ipd.dsp.internal.s1.e.b
    public void a(int i, String str) {
        com.ipd.dsp.internal.j1.c cVar = this.i;
        if (cVar != null) {
            cVar.d();
        }
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }
}
