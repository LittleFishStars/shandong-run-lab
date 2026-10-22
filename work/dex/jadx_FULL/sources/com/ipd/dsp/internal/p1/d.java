package com.ipd.dsp.internal.p1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.c2.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class d extends com.ipd.dsp.internal.t0.b {
    public float h;
    public String i;
    public float j;
    public a k;
    public com.ipd.dsp.internal.e1.d l;
    public com.ipd.dsp.internal.j1.b m;
    public com.ipd.dsp.internal.q1.a n;

    public interface a {
        void a();

        void a(int i, String str);

        void b();

        void c();

        void onDetachedFromWindow();
    }

    public d(@NonNull Context context, com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        super(context);
        this.i = "center";
        a(dVar, bVar);
        j();
    }

    private void j() {
        a(com.ipd.dsp.internal.t0.a.DATUM_WIDTH, this.h, 1.0f);
        setBackgroundColor(-1);
    }

    public final void a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        this.l = dVar;
        this.m = bVar;
        this.h = com.ipd.dsp.internal.e1.f.a(dVar.s.i, 1.6519824f);
        com.ipd.dsp.internal.e1.f fVar = dVar.s;
        this.i = fVar.f;
        this.j = com.ipd.dsp.internal.e1.f.a(fVar.g, 1.7777778f);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x008b A[Catch: all -> 0x00af, TryCatch #0 {all -> 0x00af, blocks: (B:5:0x0007, B:6:0x000f, B:24:0x008b, B:25:0x0098, B:8:0x0014, B:10:0x001d, B:11:0x002b, B:13:0x0033, B:14:0x0041, B:16:0x004a, B:17:0x0058, B:18:0x005e, B:20:0x0066, B:21:0x0075, B:23:0x007d), top: B:32:0x0007 }] */
    public void b(boolean z) {
        if (this.n != null) {
            k();
        }
        try {
            String str = this.i;
            switch (str.hashCode()) {
                case -2048587032:
                    if (!str.equals(com.ipd.dsp.internal.e1.f.p)) {
                        this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 0);
                    } else {
                        this.n = new com.ipd.dsp.internal.q1.c(getContext(), this.k);
                    }
                    break;
                case -1383228885:
                    if (!str.equals(com.ipd.dsp.internal.e1.f.n)) {
                        this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 0);
                    } else {
                        this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 2);
                    }
                    break;
                case -1364013995:
                    str.equals("center");
                    this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 0);
                    break;
                case 115029:
                    if (!str.equals(com.ipd.dsp.internal.e1.f.l)) {
                        this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 0);
                    } else {
                        this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 1);
                    }
                    break;
                case 3317767:
                    if (!str.equals("left")) {
                        this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 0);
                    } else {
                        this.n = new com.ipd.dsp.internal.q1.b(getContext(), this.k, true);
                    }
                    break;
                case 108511772:
                    if (!str.equals("right")) {
                        this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 0);
                    } else {
                        this.n = new com.ipd.dsp.internal.q1.b(getContext(), this.k, false);
                    }
                    break;
                default:
                    this.n = new com.ipd.dsp.internal.q1.d(getContext(), this.k, 0);
                    break;
            }
            this.n.a(this.l, this.m, this.j, z);
            addView(this.n, new FrameLayout.LayoutParams(-1, -1));
        } catch (Throwable th) {
            r.a(th);
            if (this.k != null) {
                com.ipd.dsp.internal.f1.a aVarH = com.ipd.dsp.internal.f1.a.h();
                this.k.a(aVarH.f38306a, aVarH.b);
            }
        }
    }

    public void i() {
        k();
        this.k = null;
    }

    public final void k() {
        removeAllViews();
        com.ipd.dsp.internal.q1.a aVar = this.n;
        if (aVar != null) {
            aVar.a();
            this.n = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.k;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        a aVar;
        super.onVisibilityChanged(view, i);
        if (i != 0 || (aVar = this.k) == null) {
            return;
        }
        aVar.a();
    }

    public void setInternalListener(a aVar) {
        this.k = aVar;
    }
}
