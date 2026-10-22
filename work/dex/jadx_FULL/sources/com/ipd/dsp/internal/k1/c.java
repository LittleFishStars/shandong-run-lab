package com.ipd.dsp.internal.k1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspDrawAd;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.s1.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends com.ipd.dsp.internal.k1.a {
    public DspDrawAd.InteractionListener n;
    public final boolean o;
    public final boolean p;
    public com.ipd.dsp.internal.s1.d q;
    public boolean r;
    public boolean s;
    public boolean t;

    public class a implements com.ipd.dsp.internal.b1.b.e {
        public a() {
        }

        @Override // com.ipd.dsp.internal.b1.b.e
        public void a(long j, long j2) {
            if (c.this.q != null && c.this.r) {
                c.this.q.setCTABtnText(o.a(j, j2));
                return;
            }
            c cVar = c.this;
            if (!(cVar.i instanceof com.ipd.dsp.internal.p1.c) || cVar.r) {
                return;
            }
            ((com.ipd.dsp.internal.p1.c) c.this.i).a(o.a(j, j2));
        }

        @Override // com.ipd.dsp.internal.b1.b.e
        public void c(String str) {
            if (c.this.q != null && c.this.r) {
                c.this.q.setCTABtnText(str);
                return;
            }
            c cVar = c.this;
            if (!(cVar.i instanceof com.ipd.dsp.internal.p1.c) || cVar.r) {
                return;
            }
            ((com.ipd.dsp.internal.p1.c) c.this.i).a(str);
        }
    }

    public class b implements com.ipd.dsp.internal.k1.a.c {
        public b() {
        }

        @Override // com.ipd.dsp.internal.k1.a.c
        public void a() {
            c cVar = c.this;
            if (cVar.j) {
                cVar.i();
            }
        }

        @Override // com.ipd.dsp.internal.k1.a.c
        public void b() {
            c cVar = c.this;
            if (cVar.j) {
                cVar.k();
            }
        }

        @Override // com.ipd.dsp.internal.k1.a.c
        public void onDetachedFromWindow() {
            c.this.g();
        }
    }

    public c(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, boolean z, boolean z2) {
        super(dVar, bVar);
        this.s = false;
        this.t = false;
        this.o = z;
        this.p = z2;
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void g() {
        this.n = null;
        this.q = null;
        try {
            super.g();
        } catch (Throwable unused) {
        }
    }

    @Override // com.ipd.dsp.internal.k1.a, com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogDismiss() {
        super.onDownloadConfirmDialogDismiss();
        this.t = false;
        DspDrawAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            try {
                interactionListener.onDownloadConfirmDialogDismiss();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ipd.dsp.internal.k1.a, com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogShow() {
        super.onDownloadConfirmDialogShow();
        this.t = true;
        DspDrawAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            try {
                interactionListener.onDownloadConfirmDialogShow();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ipd.dsp.internal.k1.a, com.ipd.dsp.internal.b1.b.c
    public boolean c() {
        return this.o;
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void b(@NonNull Context context) {
        com.ipd.dsp.internal.p1.c cVar = new com.ipd.dsp.internal.p1.c(context, this.f, this.g, this.p);
        cVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        a(new a());
        cVar.setVisibilityListener(new b());
        cVar.setVideoListener(new C0893c());
        cVar.h();
        List<View> clickableViews = cVar.getClickableViews();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.yoa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46086a.a(view);
            }
        };
        for (View view : clickableViews) {
            if (!view.hasOnClickListeners()) {
                view.setOnClickListener(onClickListener);
            }
        }
        this.i = cVar;
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.k1.c$c, reason: collision with other inner class name */
    public class C0893c implements h.a {
        public C0893c() {
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i) {
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i, int i2) {
            if (c.this.s) {
                return;
            }
            c.this.s = true;
            com.ipd.dsp.internal.x1.c cVar = c.this.i;
            if (cVar != null) {
                cVar.post(new Runnable() { // from class: com.zj.adlib.cra
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41031a.b();
                    }
                });
            }
        }

        public final /* synthetic */ void b() {
            c.this.h();
            if (c.this.n != null) {
                c.this.n.onDrawAdShow();
            }
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a() {
            c cVar = c.this;
            if ((cVar.i instanceof com.ipd.dsp.internal.p1.c) && cVar.q == null && !c.this.r) {
                c.this.r = true;
                c cVar2 = c.this;
                Context context = c.this.i.getContext();
                int width = c.this.i.getWidth();
                int height = c.this.i.getHeight();
                com.ipd.dsp.internal.e1.d dVar = c.this.f;
                cVar2.q = new com.ipd.dsp.internal.s1.d(context, true, width, height, dVar, TextUtils.isEmpty(dVar.o) ? ((com.ipd.dsp.internal.p1.c) c.this.i).getVideoCapture() : null, new com.ipd.dsp.internal.s1.d.a() { // from class: com.zj.adlib.bra
                    @Override // com.ipd.dsp.internal.s1.d.a
                    public final void a(Map map) {
                        this.f40826a.a(map);
                    }
                });
                c cVar3 = c.this;
                cVar3.i.addView(cVar3.q);
                ((com.ipd.dsp.internal.p1.c) c.this.i).e();
            }
        }

        public final /* synthetic */ void a(Map map) {
            c.this.b(1, null, map);
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i, String str) {
            if (c.this.n != null) {
                c.this.n.onDrawAdPlayError(i, str);
            }
        }
    }

    public void a(DspDrawAd.InteractionListener interactionListener) {
        this.n = interactionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Map<String, Object> touchCoordsMap;
        if (view instanceof com.ipd.dsp.internal.x1.c) {
            touchCoordsMap = ((com.ipd.dsp.internal.x1.c) view).getTouchCoordsMap();
        } else {
            com.ipd.dsp.internal.x1.c cVar = this.i;
            touchCoordsMap = cVar != null ? cVar.getTouchCoordsMap() : null;
        }
        b(1, null, touchCoordsMap);
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void a(float[] fArr) {
        super.a(fArr);
        b(3, fArr, null);
    }

    public final void b(int i, float[] fArr, Map<String, Object> map) {
        if (this.t) {
            return;
        }
        a(i, fArr, map);
        DspDrawAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            interactionListener.onDrawAdClick();
        }
    }
}
