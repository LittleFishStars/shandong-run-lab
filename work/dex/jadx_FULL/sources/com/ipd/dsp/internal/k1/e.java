package com.ipd.dsp.internal.k1;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ipd.dsp.R;
import com.ipd.dsp.ad.DspSplashAd;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.n;
import com.ipd.dsp.internal.c2.r;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends com.ipd.dsp.internal.k1.a implements View.OnClickListener, com.ipd.dsp.internal.k1.a.c {
    public DspSplashAd.InteractionListener n;
    public n o;
    public final AtomicBoolean p;
    public final AtomicBoolean q;
    public final boolean r;
    public final int s;
    public final boolean t;
    public com.ipd.dsp.internal.v1.a u;
    public boolean v;
    public TextView w;
    public final f.b x;

    public class a implements f.b {
        public a() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onPause() {
            e.this.b();
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onResume() {
            e.this.a();
        }
    }

    public class b extends n {
        public b(long j, long j2) {
            super(j, j2);
        }

        @Override // com.ipd.dsp.internal.c2.n
        public void a(long j) {
            if (e.this.w == null) {
                return;
            }
            try {
                e.this.w.setText("跳过 " + (j / 1000) + "s");
            } catch (Throwable th) {
                r.a(th);
            }
        }

        @Override // com.ipd.dsp.internal.c2.n
        public void c() {
            if (e.this.w == null) {
                return;
            }
            e.this.w.setText("跳过");
            e.this.q();
        }
    }

    public e(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        super(dVar, bVar);
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.v = false;
        this.x = new a();
        com.ipd.dsp.internal.e1.c cVar = dVar.w;
        this.r = cVar.j;
        this.s = cVar.k;
        this.t = cVar.i;
    }

    private void p() {
        if (this.i == null) {
            return;
        }
        com.ipd.dsp.internal.j1.b bVar = this.g;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.D);
        }
        try {
            this.i.post(new Runnable() { // from class: com.zj.adlib.cza
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41076a.m();
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final com.ipd.dsp.internal.v1.a d(Context context) {
        com.ipd.dsp.internal.v1.b bVar = new com.ipd.dsp.internal.v1.b(context);
        bVar.setOnStopListener(new com.ipd.dsp.internal.v1.a.e() { // from class: com.zj.adlib.oya
            @Override // com.ipd.dsp.internal.v1.a.e
            public final void onStop() {
                this.f43856a.l();
            }
        });
        bVar.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.uya
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45253a.a(view);
            }
        });
        return bVar;
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void g() {
        try {
            f.a().b(this.x);
            b();
            this.u = null;
            this.w = null;
            this.i = null;
        } catch (Throwable unused) {
        }
        try {
            super.g();
        } catch (Throwable unused2) {
        }
    }

    public final /* synthetic */ void l() {
        com.ipd.dsp.internal.x1.c cVar = this.i;
        if (cVar != null) {
            try {
                cVar.removeView(this.u);
            } catch (Throwable unused) {
            }
        }
    }

    public final /* synthetic */ void m() {
        g();
        DspSplashAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            interactionListener.onSplashAdSkip();
            this.n = null;
        }
    }

    public final /* synthetic */ void n() {
        h();
        DspSplashAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            interactionListener.onSplashAdShow();
        }
        r();
    }

    public final /* synthetic */ void o() {
        com.ipd.dsp.internal.v1.a aVar = this.u;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.w) {
            try {
                this.o.a();
            } catch (Throwable unused) {
            }
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.A);
            }
            p();
            return;
        }
        Object tag = view.getTag(R.id.ipd_custom_key_2);
        if (tag instanceof com.ipd.dsp.internal.x1.a) {
            try {
                b(view.getTag(R.id.ipd_custom_key_1) == Boolean.TRUE ? 2 : 1, null, ((com.ipd.dsp.internal.x1.a) tag).a());
            } catch (Throwable unused2) {
            }
        } else {
            com.ipd.dsp.internal.x1.c cVar = this.i;
            b(1, null, cVar != null ? cVar.getTouchCoordsMap() : null);
        }
    }

    @Override // com.ipd.dsp.internal.k1.a.c
    public void onDetachedFromWindow() {
        if (this.n != null) {
            this.n = null;
            g();
        }
    }

    @Override // com.ipd.dsp.internal.k1.a, com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogDismiss() {
        super.onDownloadConfirmDialogDismiss();
        n nVar = this.o;
        if (nVar != null) {
            try {
                nVar.e();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ipd.dsp.internal.k1.a, com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogShow() {
        super.onDownloadConfirmDialogShow();
        n nVar = this.o;
        if (nVar != null) {
            try {
                nVar.d();
            } catch (Throwable unused) {
            }
        }
    }

    public final void q() {
        com.ipd.dsp.internal.j1.b bVar = this.g;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.C, "tick");
        }
        DspSplashAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            interactionListener.onSplashAdDismiss();
        }
    }

    public final void r() {
        f.a().a(this.x);
        n nVar = this.o;
        if (nVar != null) {
            try {
                nVar.a();
                this.o = null;
            } catch (Throwable th) {
                r.a(th);
            }
        }
        this.o = new b(5000L, 1000L).f();
    }

    public void a(DspSplashAd.InteractionListener interactionListener) {
        this.n = interactionListener;
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void b(@NonNull Context context) {
        com.ipd.dsp.internal.p1.f fVar = new com.ipd.dsp.internal.p1.f(context, this, this.j, this.t);
        fVar.a(this.f);
        this.w = fVar.getSkipBtn();
        ArrayList<View> clickableViews = fVar.getClickableViews();
        int size = clickableViews.size();
        int i = 0;
        while (i < size) {
            View view = clickableViews.get(i);
            i++;
            view.setOnClickListener(this);
        }
        if (!this.r && new Random().nextInt(100) < this.s) {
            com.ipd.dsp.internal.v1.a aVarD = d(context);
            this.u = aVarD;
            fVar.addView(aVarD);
            this.u.postDelayed(new Runnable() { // from class: com.zj.adlib.hza
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42238a.o();
                }
            }, 500L);
        }
        this.i = fVar;
    }

    public final /* synthetic */ void a(View view) {
        b(1, null, view instanceof com.ipd.dsp.internal.x1.c ? ((com.ipd.dsp.internal.x1.c) view).getTouchCoordsMap() : null);
        if (view instanceof com.ipd.dsp.internal.v1.a) {
            try {
                ((com.ipd.dsp.internal.v1.a) view).j();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void a(float[] fArr) {
        if (this.p.get() && b(3, fArr, null)) {
            super.a(fArr);
        }
    }

    @Override // com.ipd.dsp.internal.k1.a.c
    public synchronized void a() {
        if (!this.p.get()) {
            if (this.j) {
                i();
            }
            this.p.set(true);
            if (!this.q.getAndSet(true)) {
                com.ipd.dsp.internal.x1.c cVar = this.i;
                if (cVar != null) {
                    cVar.post(new Runnable() { // from class: com.zj.adlib.uxa
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f45248a.n();
                        }
                    });
                }
            } else if (this.v) {
                this.v = false;
                this.o.e();
            }
        }
    }

    private boolean b(int i, float[] fArr, Map<String, Object> map) {
        try {
            n nVar = this.o;
            if (nVar != null && !nVar.b() && this.p.get()) {
                a(i, fArr, map);
                DspSplashAd.InteractionListener interactionListener = this.n;
                if (interactionListener == null) {
                    return true;
                }
                interactionListener.onSplashAdClick();
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.k1.a.c
    public synchronized void b() {
        if (this.p.get()) {
            this.p.set(false);
            if (this.j) {
                k();
            }
            n nVar = this.o;
            if (nVar != null && !nVar.b()) {
                this.v = true;
                this.o.d();
            }
        }
    }
}
