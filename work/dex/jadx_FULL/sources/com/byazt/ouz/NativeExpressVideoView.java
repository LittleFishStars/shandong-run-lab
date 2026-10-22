package com.byazt.ouz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.un.NativeVideoTsView;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 1208})
public class NativeExpressVideoView extends NativeExpressView implements com.byazt.dh.ve.uj, com.byazt.dh.ve.InterfaceC0386ve, sl {
    public int c;
    public long gr;
    public com.byazt.ua.c gu;
    public boolean n;
    public HashSet<String> p;
    public boolean tt;
    public int uj;
    public boolean ve;
    public com.byazt.xl.uj yv;
    public long zm;

    public NativeExpressVideoView(Context context, ic icVar, com.byazt.dj.tt ttVar, String str) {
        super(context, icVar, ttVar, str, true);
        this.c = 1;
        this.tt = false;
        this.ve = true;
        this.n = true;
        this.gt = this.i.ab() == 1;
        u();
    }

    private void gr() {
        ExpressVideoView expressVideoView;
        com.byazt.xl.uj ujVar = this.yv;
        if (((ujVar instanceof com.byazt.mt.c) || (ujVar instanceof com.byazt.atv.n)) && (expressVideoView = this.sl) != null) {
            expressVideoView.tt(true);
            if (this.sl.G_()) {
                this.sl.setPauseIcon(true);
                this.sl.setVideoPlayStatus(2);
            } else {
                this.sl.setVideoPlayStatus(3);
                this.sl.setPauseIcon(false);
            }
            this.sl.performClick();
            this.sl.a();
        }
    }

    private void gu() {
        ExpressVideoView expressVideoView;
        try {
            this.gu = new com.byazt.ua.c();
            ExpressVideoView expressVideoViewC = c(this.f28916a, this.i, this.sp);
            this.sl = expressVideoViewC;
            expressVideoViewC.setNativeExpressVideoView(this);
            this.sl.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.byazt.ouz.NativeExpressVideoView.1
                @Override // com.byazt.un.NativeVideoTsView.c
                public void c(View view, int i) {
                    c expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.c(view, i);
                }
            });
            boolean z = false;
            this.sl.setShouldCheckNetChange(false);
            this.sl.setControllerStatusCallBack(new NativeVideoTsView.uj() { // from class: com.byazt.ouz.NativeExpressVideoView.2
                @Override // com.byazt.un.NativeVideoTsView.uj
                public void c(boolean z2, long j, long j2, long j3, boolean z3, boolean z4) {
                    NativeExpressVideoView.this.gu.c = z2;
                    NativeExpressVideoView.this.gu.n = j;
                    NativeExpressVideoView.this.gu.f29083a = j2;
                    NativeExpressVideoView.this.gu.sp = j3;
                    NativeExpressVideoView.this.gu.uj = z3;
                    NativeExpressVideoView.this.gu.x = z4;
                }
            });
            this.sl.setVideoAdLoadListener(this);
            this.sl.setVideoAdInteractionListener(this);
            if (com.byazt.dyf.tt.AD_TAG_FEED.equals(this.sp)) {
                this.sl.setIsAutoPlay(this.tt ? this.x.n() : this.ve);
            } else if ("splash_ad".equals(this.sp)) {
                this.sl.setIsAutoPlay(true);
            } else {
                this.sl.setIsAutoPlay(this.ve);
            }
            if (!"splash_ad".equals(this.sp)) {
                expressVideoView = this.sl;
                if (this.i.ab() == 1) {
                }
                expressVideoView.setIsQuiet(z);
                this.sl.ve();
            }
            expressVideoView = this.sl;
            z = true;
            expressVideoView.setIsQuiet(z);
            this.sl.ve();
        } catch (Exception e) {
            this.sl = null;
            com.byazt.nr.m.uj("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    public void a(int i) {
        int iA = com.byazt.omf.gt.tt().a(i);
        if (3 == iA) {
            this.tt = false;
            this.ve = false;
        } else if (1 == iA) {
            this.tt = false;
            this.ve = com.byazt.nr.rh.uj(this.f28916a);
        } else if (2 == iA) {
            if (com.byazt.nr.rh.n(this.f28916a) || com.byazt.nr.rh.uj(this.f28916a) || com.byazt.nr.rh.a(this.f28916a)) {
                this.tt = false;
                this.ve = true;
            }
        } else if (5 == iA) {
            if (com.byazt.nr.rh.uj(this.f28916a) || com.byazt.nr.rh.a(this.f28916a)) {
                this.tt = false;
                this.ve = true;
            }
        } else if (4 == iA) {
            this.tt = true;
        }
        if (!this.ve) {
            this.c = 3;
        }
        com.byazt.nr.m.c("NativeVideoAdView", "mIsAutoPlay=" + this.ve + ",status=" + iA);
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(float f) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void da() {
    }

    @Override // com.byazt.ouz.NativeExpressView
    public com.byazt.dh.ve getVideoController() {
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView != null) {
            return expressVideoView.getVideoController();
        }
        return null;
    }

    public com.byazt.ua.c getVideoModel() {
        return this.gu;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void i() {
        super.i();
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void n(int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ExpressVideoView expressVideoView;
        int i;
        super.onAttachedToWindow();
        com.byazt.xl.uj ujVar = this.yv;
        if ((!(ujVar instanceof com.byazt.mt.c) && !(ujVar instanceof com.byazt.atv.n)) || (expressVideoView = this.sl) == null || (i = this.c) == 2 || i == 5) {
            return;
        }
        expressVideoView.setNeedNativeVideoPlayBtnVisible(true);
        this.sl.F_();
        this.sl.E_();
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onProgressUpdate(long j, long j2) {
        this.n = false;
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.u;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onProgressUpdate(j, j2);
        }
        if (c(j)) {
            this.c = 2;
        }
        this.gr = j;
        this.zm = j2;
        if (!this.p.isEmpty()) {
            com.byazt.dh.ve videoController = this.sl.getVideoController();
            if (videoController instanceof com.byazt.un.uj) {
                ((com.byazt.un.uj) videoController).ve(50);
            }
        }
        com.byazt.ua.c cVar = this.gu;
        if (cVar != null) {
            cVar.sp = j;
        }
        com.byazt.xl.uj ujVar = this.yv;
        if (ujVar instanceof com.byazt.atv.n) {
            ((com.byazt.atv.n) ujVar).c(j, j2);
        }
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdContinuePlay() {
        this.n = false;
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.u;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onVideoAdContinuePlay();
        }
        this.z = false;
        this.c = 2;
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdPaused() {
        this.n = false;
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.u;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onVideoAdPaused();
        }
        this.z = true;
        this.c = 3;
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdStartPlay() {
        this.n = false;
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.u;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onVideoAdStartPlay();
        }
        this.c = 2;
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoComplete() {
        this.n = false;
        com.byazt.xl.uj ujVar = this.yv;
        if (ujVar != null) {
            if (ujVar instanceof com.byazt.mt.c) {
                ((com.byazt.mt.c) ujVar).uj();
            }
            com.byazt.xl.uj ujVar2 = this.yv;
            if (ujVar2 instanceof com.byazt.atv.n) {
                ((com.byazt.atv.n) ujVar2).u();
            }
        }
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.u;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onVideoComplete();
        }
        this.c = 5;
        com.byazt.ua.c cVar = this.gu;
        if (cVar != null) {
            cVar.c = true;
        }
    }

    @Override // com.byazt.dh.ve.uj
    public void onVideoError(int i, int i2) {
        com.byazt.dh.ve.uj ujVar = this.t;
        if (ujVar != null) {
            ujVar.onVideoError(i, i2);
        }
        this.gr = this.zm;
        this.c = 4;
    }

    @Override // com.byazt.dh.ve.uj
    public void onVideoLoad() {
        com.byazt.dh.ve.uj ujVar = this.t;
        if (ujVar != null) {
            ujVar.onVideoLoad();
        }
        com.byazt.xl.uj ujVar2 = this.yv;
        if (ujVar2 != null) {
            if (ujVar2 instanceof com.byazt.mt.c) {
                ((com.byazt.mt.c) ujVar2).n();
            }
            com.byazt.xl.uj ujVar3 = this.yv;
            if (ujVar3 instanceof com.byazt.atv.n) {
                ((com.byazt.atv.n) ujVar3).yp();
            }
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ExpressVideoView expressVideoView;
        ImageView imageView;
        super.onWindowFocusChanged(z);
        com.byazt.xl.uj ujVar = this.yv;
        if (((ujVar instanceof com.byazt.mt.c) || (ujVar instanceof com.byazt.atv.n)) && (expressVideoView = this.sl) != null && z && (imageView = expressVideoView.tt) != null && imageView.getVisibility() == 0) {
            this.sl.tt.setVisibility(8);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void sp() {
        super.sp();
    }

    @Override // com.byazt.ouz.NativeExpressView
    public void t() {
        super.t();
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView != null) {
            expressVideoView.gt();
        }
    }

    public void u() {
        this.yp = new FrameLayout(this.f28916a);
        this.uj = nb.t(this.i);
        this.p = new HashSet<>();
        a(this.uj);
        gu();
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void uj(int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void ve(int i) {
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void x() {
    }

    public void yp() {
        this.sl.sl();
    }

    @Override // com.byazt.ouz.NativeExpressView
    public void tt(com.byazt.xl.uj<? extends View> ujVar, com.byazt.xl.yp ypVar) {
        ExpressVideoView expressVideoView;
        this.yv = ujVar;
        if ((ujVar instanceof z) && ((z) ujVar).J_() != null) {
            ((z) this.yv).J_().c((sl) this);
        }
        if (ypVar != null && ypVar.ve()) {
            if ((ypVar.tt() == 2 || ypVar.tt() == 7) && (expressVideoView = this.sl) != null) {
                expressVideoView.c(this.f28916a, 25, xd.tt(this.i));
            }
            c(ypVar);
        }
        com.byazt.xl.uj ujVar2 = this.yv;
        if (ujVar2 != null && (ujVar2 instanceof com.byazt.mt.c)) {
            ((com.byazt.mt.c) ujVar2).c(this.i.ab() == 1);
        }
        super.tt(ujVar, ypVar);
    }

    public ExpressVideoView c(Context context, ic icVar, String str) {
        return new ExpressVideoView(context, icVar, str, false);
    }

    private void c(final com.byazt.xl.yp ypVar) {
        if (ypVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt(ypVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.ouz.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.tt(ypVar);
                }
            });
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(boolean z) {
        super.c(z);
        this.gt = z;
        this.sl.tt(z, true);
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView != null && expressVideoView.getNativeVideoController() != null) {
            this.sl.getNativeVideoController().tt(z);
        }
        com.byazt.xl.uj ujVar = this.yv;
        if (ujVar == null || !(ujVar instanceof com.byazt.mt.c)) {
            return;
        }
        ((com.byazt.mt.c) ujVar).c(z);
    }

    public NativeExpressVideoView(boolean z, Context context, ic icVar, com.byazt.dj.tt ttVar, String str) {
        super(z, context, icVar, ttVar, str, true);
        this.c = 1;
        this.tt = false;
        this.ve = true;
        this.n = true;
        this.gt = this.i.ab() == 1;
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.xl.yp ypVar) {
        if (ypVar == null) {
            return;
        }
        double dA = ypVar.a();
        double dSp = ypVar.sp();
        double dX = ypVar.x();
        double dI = ypVar.i();
        int iVe = pf.ve(this.f28916a, (float) dA);
        int iVe2 = pf.ve(this.f28916a, (float) dSp);
        int iVe3 = pf.ve(this.f28916a, (float) dX);
        int iVe4 = pf.ve(this.f28916a, (float) dI);
        float fVe = ypVar.t() > 0.0f ? pf.ve(this.f28916a, ypVar.t()) : 0.0f;
        float fVe2 = ypVar.u() > 0.0f ? pf.ve(this.f28916a, ypVar.u()) : 0.0f;
        float fVe3 = ypVar.yp() > 0.0f ? pf.ve(this.f28916a, ypVar.yp()) : 0.0f;
        float fVe4 = ypVar.z() > 0.0f ? pf.ve(this.f28916a, ypVar.z()) : 0.0f;
        if (fVe2 < fVe) {
            fVe = fVe2;
        }
        if (fVe3 >= fVe) {
            fVe3 = fVe;
        }
        if (fVe4 >= fVe3) {
            fVe4 = fVe3;
        }
        if (ypVar.tt() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.yp.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iVe3, iVe4);
            }
            layoutParams.width = iVe3;
            layoutParams.height = iVe4;
            layoutParams.topMargin = iVe2;
            layoutParams.leftMargin = iVe;
            this.yp.setLayoutParams(layoutParams);
        }
        pf.tt(this.yp, fVe4);
        this.yp.removeAllViews();
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView != null) {
            this.yp.addView(expressVideoView);
            this.sl.c(0L, true, false);
            a(this.uj);
            if (!com.byazt.nr.rh.uj(this.f28916a) && !this.ve && this.n) {
                this.sl.F_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.yp.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.yp);
        }
        if (ypVar instanceof com.byazt.atv.ve) {
            FrameLayout frameLayoutM = ((com.byazt.atv.ve) ypVar).m();
            if (frameLayoutM != null) {
                ExpressVideoView expressVideoView2 = this.sl;
                if (expressVideoView2 != null) {
                    expressVideoView2.setClickable(false);
                }
                frameLayoutM.addView(this.yp, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (ypVar.tt() == 2) {
            View viewC = ypVar.c();
            if (viewC instanceof ViewGroup) {
                ExpressVideoView expressVideoView3 = this.sl;
                if (expressVideoView3 != null) {
                    expressVideoView3.setClickable(false);
                }
                ((ViewGroup) viewC).addView(this.yp);
                return;
            }
            return;
        }
        this.rl.addView(this.yp);
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(int i) {
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView == null) {
            com.byazt.nr.m.uj("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            expressVideoView.c(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            expressVideoView.setVideoPlayStatus(i);
            this.sl.setCanInterruptVideoPlay(true);
            this.sl.performClick();
        } else if (i == 4) {
            expressVideoView.getNativeVideoController().da();
        } else {
            if (i != 5) {
                return;
            }
            expressVideoView.c(0L, true, false);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void a() {
        super.a();
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.xl.x
    public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
        if (i == -1 || veVar == null) {
            return;
        }
        if (i == 4) {
            gr();
        } else if (i != 5) {
            super.c(view, i, veVar, i2);
        } else {
            c(!this.gt);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public long c() {
        return this.gr;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(final int i, final String str) {
        super.c(i, str);
        com.byazt.dh.ve videoController = this.sl.getVideoController();
        if (videoController instanceof com.byazt.un.uj) {
            com.byazt.un.uj ujVar = (com.byazt.un.uj) videoController;
            ujVar.ve(50);
            ujVar.c(new com.byazt.nj.c.InterfaceC0472c() { // from class: com.byazt.ouz.NativeExpressVideoView.4
                @Override // com.byazt.nj.c.InterfaceC0472c
                public void c(long j, long j2) {
                    int iAbs = (int) Math.abs(((long) i) - j);
                    int i2 = i;
                    if (i2 < 0 || iAbs > 50 || i2 > j2 || iAbs >= 50 || NativeExpressVideoView.this.p.contains(str)) {
                        return;
                    }
                    if (i > j) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.byazt.ouz.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.sl.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.sl.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.sl.performClick();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                NativeExpressVideoView.this.tt(i, str);
                            }
                        }, iAbs);
                    } else {
                        NativeExpressVideoView.this.sl.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.sl.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.sl.performClick();
                        NativeExpressVideoView.this.tt(i, str);
                    }
                    NativeExpressVideoView.this.p.add(str);
                }
            });
        }
    }

    private boolean c(long j) {
        int i = this.c;
        if (i != 5 && i != 3 && j > this.gr) {
            return true;
        }
        ExpressVideoView expressVideoView = this.sl;
        return expressVideoView != null && expressVideoView.G_();
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.xl.x
    public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
        if (i == -1 || veVar == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.tt(view, i, veVar, i2);
                return;
            }
        } else if (this.sp == "draw_ad") {
            ExpressVideoView expressVideoView = this.sl;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        c(!this.gt);
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public int tt() {
        ExpressVideoView expressVideoView;
        if (this.c == 3 && (expressVideoView = this.sl) != null) {
            expressVideoView.ve();
        }
        ExpressVideoView expressVideoView2 = this.sl;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().qy()) {
            return this.c;
        }
        return 1;
    }
}
