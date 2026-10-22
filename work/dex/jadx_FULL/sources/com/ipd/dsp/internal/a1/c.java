package com.ipd.dsp.internal.a1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.ad.DspNativeAd;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.s1.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements DspNativeAd, com.ipd.dsp.internal.b1.b.c {
    public com.ipd.dsp.internal.e1.d f;
    public com.ipd.dsp.internal.j1.b g;
    public DspNativeAd.VideoListener h;
    public DspNativeAd.InteractionListener i;
    public com.ipd.dsp.internal.b1.b j;
    public com.ipd.dsp.internal.x1.a k;
    public int l;
    public ViewGroup n;
    public h o;
    public ViewTreeObserver.OnGlobalLayoutListener q;
    public com.ipd.dsp.internal.c2.f.b r;
    public boolean m = true;
    public List<View> p = new ArrayList();
    public View.OnClickListener s = new f();
    public View.OnClickListener t = new g();

    public class b implements com.ipd.dsp.internal.c2.f.b {
        public b() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onPause() {
            if (c.this.o != null) {
                c.this.o.m();
            }
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onResume() {
            if (c.this.o != null) {
                c.this.o.n();
            }
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.a1.c$c, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalLayoutListenerC0856c implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC0856c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c.this.n != null && c.this.n.getHeight() > 50) {
                c.this.g.a(new com.ipd.dsp.internal.j1.a(c.this.n));
                com.ipd.dsp.internal.h1.a.a(c.this.g, c.this.l);
                if (c.this.i != null) {
                    c.this.i.onNativeAdShow();
                }
                try {
                    c.this.n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class d implements ViewTreeObserver.OnWindowAttachListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            if (c.this.n != null) {
                c.this.n.setOnTouchListener(null);
                c.this.n.getViewTreeObserver().removeOnWindowAttachListener(this);
            }
            c.this.onDestroy();
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.n != null && c.this.k != null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    c.this.k.a(c.this.n.getWidth(), c.this.n.getHeight());
                    int[] iArr = new int[2];
                    c.this.n.getLocationOnScreen(iArr);
                    c.this.k.a(motionEvent.getX(), motionEvent.getY(), iArr[0], iArr[1]);
                } else if (action == 1) {
                    int[] iArr2 = new int[2];
                    c.this.n.getLocationOnScreen(iArr2);
                    c.this.k.b(motionEvent.getX(), motionEvent.getY(), iArr2[0], iArr2[1]);
                }
            }
            return true;
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.k == null) {
                return;
            }
            try {
                if (view instanceof com.ipd.dsp.internal.x1.c) {
                    c.this.a(((com.ipd.dsp.internal.x1.c) view).getTouchCoordsMap(), false);
                } else {
                    c cVar = c.this;
                    cVar.a(cVar.k.a(), false);
                }
            } catch (Throwable unused) {
            }
            if (c.this.i != null) {
                c.this.i.onNativeAdClick();
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.k == null) {
                return;
            }
            try {
                if (view instanceof com.ipd.dsp.internal.x1.c) {
                    c.this.a(((com.ipd.dsp.internal.x1.c) view).getTouchCoordsMap(), true);
                } else {
                    c cVar = c.this;
                    cVar.a(cVar.k.a(), true);
                }
            } catch (Throwable unused) {
            }
            if (c.this.i != null) {
                c.this.i.onNativeAdClick();
            }
        }
    }

    public c(com.ipd.dsp.internal.e1.d dVar) {
        this.f = dVar;
        com.ipd.dsp.internal.j1.b bVar = new com.ipd.dsp.internal.j1.b(dVar);
        this.g = bVar;
        com.ipd.dsp.internal.b1.b bVarA = com.ipd.dsp.internal.b1.b.a(dVar, bVar);
        this.j = bVarA;
        if (bVarA instanceof com.ipd.dsp.internal.b1.b.a) {
            ((com.ipd.dsp.internal.b1.b.a) bVarA).a(this);
        }
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public void bindAdView(ViewGroup viewGroup, List<View> list, List<View> list2) {
        this.n = viewGroup;
        if (list != null) {
            this.p.addAll(list);
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(this.s);
            }
        }
        if (list2 != null) {
            this.p.addAll(list2);
            Iterator<View> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().setOnClickListener(this.t);
            }
        }
        if (viewGroup != null) {
            this.k = new com.ipd.dsp.internal.x1.a();
            this.q = new ViewTreeObserverOnGlobalLayoutListenerC0856c();
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.q);
            viewGroup.getViewTreeObserver().addOnWindowAttachListener(new d());
            viewGroup.setOnTouchListener(new e());
            return;
        }
        if (this.i != null) {
            com.ipd.dsp.internal.f1.a aVarB = com.ipd.dsp.internal.f1.a.b();
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, aVarB.toString());
            }
            this.i.onNativeAdError(aVarB.f38306a, aVarB.b);
        }
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public void bindVideoView(ViewGroup viewGroup, boolean z, DspNativeAd.VideoListener videoListener) {
        bindVideoView(viewGroup, z, false, videoListener);
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    @Nullable
    public DspNativeAd.AppMiitInfo getAppMiitInfo() {
        if (com.ipd.dsp.internal.e1.b.F.equals(this.f.r.f)) {
            try {
                return this.f.r.D;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getCTAText() {
        return this.f.m;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getDesc() {
        return this.f.l;
    }

    @Override // com.ipd.dsp.api.IBid
    public int getEcpm() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        if (dVar != null) {
            return dVar.v;
        }
        return 0;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getIcon() {
        return this.f.n;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getImage() {
        return this.f.o;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public int getMaterialType() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        return (dVar == null || !o.c(dVar.q.f)) ? 1 : 3;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getRequestId() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        return o.b(dVar != null ? dVar.i : null);
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getSourceLogo() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        return (dVar == null || !o.c(dVar.t.j)) ? "" : this.f.t.j;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getSourceName() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        return (dVar == null || !o.c(dVar.t.h)) ? "广告" : this.f.t.h;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public String getTitle() {
        return this.f.k;
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public boolean isAppAd() {
        return com.ipd.dsp.internal.e1.b.F.equals(this.f.r.f);
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public void isDimBehind(boolean z) {
        this.m = z;
    }

    @Override // com.ipd.dsp.api.IBid
    public void onBiddingFailed(@NonNull BidFailedReason bidFailedReason) {
        com.ipd.dsp.internal.j1.b bVar = this.g;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, bidFailedReason, (String) null);
        }
    }

    @Override // com.ipd.dsp.api.IBid
    public void onBiddingSuccess(int i, int i2) {
        this.l = i;
        com.ipd.dsp.internal.j1.b bVar = this.g;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, i, i2, (String) null);
        }
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public void onDestroy() {
        List<View> list = this.p;
        if (list != null) {
            for (View view : list) {
                if (view != null) {
                    try {
                        view.setOnClickListener(null);
                    } catch (Throwable unused) {
                    }
                }
            }
            try {
                this.p.clear();
            } catch (Throwable unused2) {
            }
            this.p = null;
        }
        this.k = null;
        ViewGroup viewGroup = this.n;
        if (viewGroup != null) {
            if (this.q != null) {
                try {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this.q);
                } catch (Throwable unused3) {
                }
            }
            this.q = null;
            this.n = null;
        }
        h hVar = this.o;
        if (hVar != null) {
            try {
                hVar.k();
                this.o.l();
            } catch (Throwable unused4) {
            }
            this.o = null;
        }
        if (this.r != null) {
            com.ipd.dsp.internal.c2.f.a().b(this.r);
            this.r = null;
        }
        this.h = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.s = null;
        this.t = null;
        com.ipd.dsp.internal.b1.b bVar = this.j;
        if (bVar != null) {
            try {
                bVar.c();
            } catch (Throwable unused5) {
            }
            this.j = null;
        }
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogDismiss() {
        DspNativeAd.InteractionListener interactionListener = this.i;
        if (interactionListener != null) {
            try {
                interactionListener.onDownloadConfirmDialogDismiss();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogShow() {
        DspNativeAd.InteractionListener interactionListener = this.i;
        if (interactionListener != null) {
            try {
                interactionListener.onDownloadConfirmDialogShow();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public void setInteractionListener(DspNativeAd.InteractionListener interactionListener) {
        this.i = interactionListener;
    }

    public class a implements h.a {
        public a() {
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i) {
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i, int i2) {
            if (c.this.h != null) {
                c.this.h.onVideoPlayStart();
            }
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a() {
            if (c.this.h != null) {
                c.this.h.onVideoPlayComplete();
            }
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i, String str) {
            if (c.this.h != null) {
                c.this.h.onVideoPlayError(i, str);
            }
        }
    }

    @Override // com.ipd.dsp.ad.DspNativeAd
    public void bindVideoView(ViewGroup viewGroup, boolean z, final boolean z2, DspNativeAd.VideoListener videoListener) {
        if (viewGroup == null) {
            return;
        }
        this.h = videoListener;
        try {
            h hVar = new h(viewGroup.getContext(), this.f, this.g, z);
            this.o = hVar;
            this.p.add(hVar);
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.lpa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43125a.a(z2, view);
                }
            });
            this.o.h();
            this.o.setInteractionListener(new a());
            viewGroup.addView(this.o, new ViewGroup.LayoutParams(-1, -1));
            this.r = new b();
            com.ipd.dsp.internal.c2.f.a().a(this.r);
        } catch (Throwable th) {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, com.ipd.dsp.internal.f1.a.a(th.getMessage()).toString());
            }
            DspNativeAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onNativeAdError(com.ipd.dsp.internal.f1.a.g().f38306a, "绑定视频失败，未知错误");
            }
        }
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public boolean c() {
        return this.m;
    }

    public final /* synthetic */ void a(boolean z, View view) {
        h hVar = this.o;
        if (hVar == null || hVar.b(z) || this.f.p) {
            return;
        }
        this.t.onClick(this.o);
    }

    public final void a(Map<String, Object> map, final boolean z) {
        com.ipd.dsp.internal.j1.b bVar;
        if (this.k == null || (bVar = this.g) == null) {
            return;
        }
        com.ipd.dsp.internal.h1.a.a(bVar, this.l, 1, null, map, new com.ipd.dsp.internal.h1.a.d() { // from class: com.zj.adlib.roa
            @Override // com.ipd.dsp.internal.h1.a.d
            public final void a(Object obj) {
                this.f44501a.a(z, (String) obj);
            }
        });
    }

    public final /* synthetic */ void a(boolean z, String str) {
        if (!TextUtils.isEmpty(str)) {
            com.ipd.dsp.internal.b1.b bVar = this.j;
            if (bVar instanceof com.ipd.dsp.internal.b1.b.a) {
                this.f.r.k = str;
            } else if (bVar instanceof com.ipd.dsp.internal.b1.b.d) {
                this.f.r.j = str;
            }
        }
        com.ipd.dsp.internal.b1.b bVar2 = this.j;
        if (bVar2 != null) {
            bVar2.a(z);
        }
    }
}
