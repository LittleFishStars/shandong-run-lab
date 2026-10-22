package com.ipd.dsp.internal.k1;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspNativeExpressAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d extends com.ipd.dsp.internal.k1.a {
    public DspNativeExpressAd.InteractionListener n;
    public boolean o;
    public boolean p;

    public d(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        super(dVar, bVar);
        this.o = false;
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void g() {
        com.ipd.dsp.internal.x1.c cVar = this.i;
        if (cVar instanceof com.ipd.dsp.internal.p1.d) {
            ((com.ipd.dsp.internal.p1.d) cVar).i();
            ViewParent parent = this.i.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.i);
            }
            this.i = null;
        }
        this.n = null;
        super.g();
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void b(@NonNull Context context) {
        if (this.i == null) {
            this.i = new com.ipd.dsp.internal.p1.d(context, this.f, this.g);
        }
        ((com.ipd.dsp.internal.p1.d) this.i).setInternalListener(new a());
        ((com.ipd.dsp.internal.p1.d) this.i).b(this.p);
    }

    public void a(boolean z) {
        this.p = z;
    }

    public class a implements com.ipd.dsp.internal.p1.d.a {
        public a() {
        }

        @Override // com.ipd.dsp.internal.p1.d.a
        public void a() {
            if (d.this.o) {
                return;
            }
            d.this.o = true;
            com.ipd.dsp.internal.x1.c cVar = d.this.i;
            if (cVar != null) {
                cVar.post(new Runnable() { // from class: com.zj.adlib.mua
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43389a.d();
                    }
                });
            }
        }

        @Override // com.ipd.dsp.internal.p1.d.a
        public void b() {
            d.this.d();
            if (d.this.n != null) {
                d.this.n.onNativeExpressAdClick();
            }
        }

        @Override // com.ipd.dsp.internal.p1.d.a
        public void c() {
            com.ipd.dsp.internal.j1.b bVar = d.this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.D);
            }
            if (d.this.n != null) {
                d.this.n.onNativeExpressAdClose();
            }
        }

        public final /* synthetic */ void d() {
            d.this.h();
            if (d.this.n != null) {
                d.this.n.onNativeExpressAdShow();
            }
        }

        @Override // com.ipd.dsp.internal.p1.d.a
        public void onDetachedFromWindow() {
        }

        @Override // com.ipd.dsp.internal.p1.d.a
        public void a(int i, String str) {
            com.ipd.dsp.internal.j1.b bVar = d.this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, com.ipd.dsp.internal.f1.a.a(i, str));
            }
            if (d.this.n != null) {
                d.this.n.onNativeExpressAdRenderFail(i, str);
            }
        }
    }

    public void a(DspNativeExpressAd.InteractionListener interactionListener) {
        this.n = interactionListener;
    }
}
