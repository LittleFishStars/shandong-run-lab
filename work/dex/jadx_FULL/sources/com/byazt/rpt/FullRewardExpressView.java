package com.byazt.rpt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.lt;
import com.byazt.msx.FullSwiperItemView;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.byazt.ouz.FullRewardExpressBackupView;
import com.byazt.ouz.NativeExpressView;
import com.byazt.ouz.sl;
import com.byazt.ouz.z;
import com.byazt.xl.uj;
import com.byazt.xl.ve;
import com.byazt.xl.yp;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 311, 722})
public class FullRewardExpressView extends NativeExpressView implements sl {
    public sl c;
    public HashSet<String> gr;
    public ImageView gu;
    public com.byazt.qmz.c h;
    public FullSwiperItemView.c md;
    public yp n;
    public com.byazt.nj.c.InterfaceC0472c p;
    public FullRewardExpressBackupView tt;
    public uj uj;
    public com.byazt.zd.c ve;
    public View yv;
    public c zm;

    public interface c {
        void c(int i);
    }

    public FullRewardExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar, String str, boolean z, String str2) {
        super(context, icVar, ttVar, str, z, str2);
        this.gr = new HashSet<>();
    }

    private void gu() {
        com.byazt.zd.c cVar;
        if ((this.uj instanceof com.byazt.mt.c) && (cVar = this.ve) != null) {
            if (cVar.lr()) {
                this.ve.a();
                tt(true);
            } else {
                this.ve.x();
                tt(false);
            }
        }
    }

    private void yp() {
        setBackupListener(new ve() { // from class: com.byazt.rpt.FullRewardExpressView.1
            @Override // com.byazt.xl.ve
            public boolean c(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).my();
                    FullRewardExpressView.this.tt = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                    fullRewardExpressView.tt.c(fullRewardExpressView.i, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void da() {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.da();
        }
    }

    public yp getRenderResult() {
        return this.n;
    }

    @Override // com.byazt.ouz.NativeExpressView
    public com.byazt.dh.ve getVideoController() {
        return this.ve;
    }

    public FrameLayout getVideoFrameLayout() {
        return rl() ? this.tt.getVideoContainer() : this.yp;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void i() {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.i();
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj(z);
    }

    public void setEasyPlayableContainer(View view) {
        this.yv = view;
    }

    public void setExpressVideoListenerProxy(sl slVar) {
        this.c = slVar;
    }

    public void setInteractListener(FullSwiperItemView.c cVar) {
        this.md = cVar;
    }

    public void setOnVideoSizeChangeListener(c cVar) {
        this.zm = cVar;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void setPauseFromExpressView(boolean z) {
    }

    public void setVideoController(com.byazt.dh.ve veVar) {
        if (veVar instanceof com.byazt.zd.c) {
            com.byazt.zd.c cVar = (com.byazt.zd.c) veVar;
            this.ve = cVar;
            cVar.ve(50);
            this.ve.c(this.p);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView
    public void sl() {
        this.m = true;
        this.yp = new FrameLayout(this.f28916a);
        super.sl();
        yp();
        if (getJsObject() != null) {
            getJsObject().t(this.gt);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void sp() {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.sp();
        }
    }

    @Override // com.byazt.ouz.NativeExpressView
    public void t() {
        super.t();
        this.gr.clear();
    }

    public boolean u() {
        yp ypVar = this.n;
        if (ypVar == null) {
            return true;
        }
        if (ypVar instanceof com.byazt.atv.ve) {
            return ((com.byazt.atv.ve) ypVar).m() != null;
        }
        return (ypVar.x() == AudioStats.AUDIO_AMPLITUDE_NONE || this.n.i() == AudioStats.AUDIO_AMPLITUDE_NONE) ? false : true;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void x() {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.x();
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void a() {
        super.a();
        sl slVar = this.c;
        if (slVar != null) {
            slVar.a();
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void n(int i) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.n(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0054  */
    @Override // com.byazt.ouz.NativeExpressView
    public void tt(uj<? extends View> ujVar, yp ypVar) {
        boolean z;
        FrameLayout frameLayoutNu;
        View view;
        this.uj = ujVar;
        if (ujVar instanceof z) {
            z zVar = (z) ujVar;
            if (zVar.J_() != null) {
                zVar.J_().c((sl) this);
            }
            if (zVar.J_() != null) {
                zVar.J_().ve(this.da);
            }
        }
        if (ujVar instanceof com.byazt.atv.c) {
            ((com.byazt.atv.c) ujVar).c(this);
        }
        if (ypVar != null && ypVar.ve()) {
            this.n = ypVar;
            if (ypVar.tt() == 2) {
                View viewC = ypVar.c();
                if (viewC instanceof ViewGroup) {
                    ((ViewGroup) viewC).addView(getVideoContainer());
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (!z) {
                c((ViewGroup) this.yp, true);
            }
            if (ypVar.tt() == 10 && (ypVar instanceof com.byazt.atv.ve)) {
                this.h = ((com.byazt.atv.ve) ypVar).rh();
            }
            if (ypVar.tt() == 10 && (ypVar instanceof com.byazt.atv.ve) && (frameLayoutNu = ((com.byazt.atv.ve) ypVar).nu()) != null && (view = this.yv) != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.yv);
                }
                frameLayoutNu.addView(this.yv);
            }
        }
        super.tt(ujVar, ypVar);
        sp(getVisibility());
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void uj() {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.uj();
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public int ve() {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.ve();
        }
        return 0;
    }

    public void c(final ViewGroup viewGroup, final boolean z) {
        if (this.n == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt(viewGroup, z);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.rpt.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.tt(viewGroup, z);
                }
            });
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void n() {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.n();
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void uj(int i) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.uj(i);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void ve(int i) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.ve(i);
        }
    }

    private void uj(boolean z) {
        com.byazt.zd.c cVar;
        if ((this.uj instanceof com.byazt.mt.c) && z) {
            ImageView imageView = this.gu;
            if (imageView != null && imageView.getVisibility() == 0 && (cVar = this.ve) != null) {
                cVar.a();
            } else {
                c(this.gt);
            }
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(boolean z) {
        super.c(z);
        this.gt = z;
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(z);
        }
        uj ujVar = this.uj;
        if (ujVar == null || !(ujVar instanceof com.byazt.mt.c)) {
            return;
        }
        ((com.byazt.mt.c) ujVar).c(z);
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(int i) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(i);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public long c() {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.c();
        }
        return 0L;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(float f, float f2, float f3, float f4, int i) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(f, f2, f3, f4, i);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(ic icVar) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(icVar);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(final int i, final String str) {
        this.p = new com.byazt.nj.c.InterfaceC0472c() { // from class: com.byazt.rpt.FullRewardExpressView.3
            @Override // com.byazt.nj.c.InterfaceC0472c
            public void c(long j, long j2) {
                int iAbs = (int) Math.abs(((long) i) - j);
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                int i2 = fullRewardExpressView.ve instanceof com.byazt.iym.uj ? 200 : 50;
                int i3 = i;
                if (i3 < 0 || iAbs > i2 || i3 > j2 || iAbs >= i2 || fullRewardExpressView.gr.contains(str)) {
                    return;
                }
                if (i > j) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.byazt.rpt.FullRewardExpressView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.ve.a();
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            FullRewardExpressView.this.tt(i, str);
                            if (kp.nu(FullRewardExpressView.this.i) || lt.c(FullRewardExpressView.this.i)) {
                                FullRewardExpressView.this.c.c(2);
                            }
                            sl slVar = FullRewardExpressView.this.c;
                            if (slVar != null) {
                                slVar.setPauseFromExpressView(true);
                            }
                        }
                    }, iAbs);
                } else {
                    FullRewardExpressView.this.ve.a();
                    FullRewardExpressView.this.tt(i, str);
                    if (kp.nu(FullRewardExpressView.this.i) || lt.c(FullRewardExpressView.this.i)) {
                        FullRewardExpressView.this.c.c(2);
                    }
                    sl slVar = FullRewardExpressView.this.c;
                    if (slVar != null) {
                        slVar.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.gr.add(str);
            }
        };
        com.byazt.zd.c cVar = this.ve;
        if (cVar != null) {
            cVar.ve(50);
            this.ve.c(this.p);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void c(float f) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.c(f);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.xl.x
    public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
        FullSwiperItemView.c cVar = this.md;
        if (cVar != null) {
            cVar.c();
        }
        if (i != -1 && veVar != null && i == 3) {
            i();
            return;
        }
        if (i == 5) {
            c(!this.gt);
        } else if (i == 4) {
            gu();
        } else {
            super.c(view, i, veVar, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x0102  */
    public void tt(ViewGroup viewGroup, boolean z) {
        yp ypVar = this.n;
        if (ypVar == null) {
            return;
        }
        double dA = ypVar.a();
        double dSp = this.n.sp();
        double dX = this.n.x();
        double dI = this.n.i();
        int iVe = pf.ve(this.f28916a, (float) dA);
        int iVe2 = pf.ve(this.f28916a, (float) dSp);
        int iVe3 = pf.ve(this.f28916a, (float) dX);
        int iVe4 = pf.ve(this.f28916a, (float) dI);
        float fVe = this.n.t() > 0.0f ? pf.ve(this.f28916a, this.n.t()) : 0.0f;
        float fVe2 = this.n.u() > 0.0f ? pf.ve(this.f28916a, this.n.u()) : 0.0f;
        float fVe3 = this.n.yp() > 0.0f ? pf.ve(this.f28916a, this.n.yp()) : 0.0f;
        float fVe4 = this.n.z() > 0.0f ? pf.ve(this.f28916a, this.n.z()) : 0.0f;
        if (fVe2 < fVe) {
            fVe = fVe2;
        }
        if (fVe3 >= fVe) {
            fVe3 = fVe;
        }
        if (fVe4 >= fVe3) {
            fVe4 = fVe3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iVe3, iVe4);
        }
        layoutParams.width = iVe3;
        layoutParams.height = iVe4;
        layoutParams.topMargin = iVe2;
        layoutParams.leftMargin = iVe;
        viewGroup.setLayoutParams(layoutParams);
        pf.tt(viewGroup, fVe4);
        if (z) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (this.uj.ve() == 7 || this.uj.ve() == 10) {
                yp ypVar2 = this.n;
                if (ypVar2 instanceof com.byazt.atv.ve) {
                    FrameLayout frameLayoutM = ((com.byazt.atv.ve) ypVar2).m();
                    if (frameLayoutM != null) {
                        frameLayoutM.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else {
                    this.rl.addView(viewGroup);
                }
            } else {
                this.rl.addView(viewGroup);
            }
            c cVar = this.zm;
            if (cVar == null || iVe4 == 0) {
                return;
            }
            cVar.c(iVe4);
        }
    }

    public void c(int i, int i2, int i3, int i4) {
        com.byazt.qmz.c cVar = this.h;
        if (cVar != null) {
            cVar.c(i, i2, i3, i4);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public int tt() {
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.tt();
        }
        return 0;
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.ouz.sl
    public void tt(int i) {
        sl slVar = this.c;
        if (slVar != null) {
            slVar.tt(i);
        }
    }

    @Override // com.byazt.ouz.NativeExpressView, com.byazt.xl.x
    public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
        FullSwiperItemView.c cVar = this.md;
        if (cVar != null) {
            cVar.c();
        }
        if (i != -1 && veVar != null && i == 3) {
            i();
        } else {
            super.tt(view, i, veVar, i2);
        }
    }

    public void tt(boolean z) {
        if (this.gu == null) {
            this.gu = new ImageView(getContext());
            if (x.m().sv() != null) {
                this.gu.setImageBitmap(x.m().sv());
            } else {
                com.byazt.nr.z.c(gt.getContext(), "tt_new_play_video", this.gu, 320);
            }
            this.gu.setScaleType(ImageView.ScaleType.FIT_XY);
            int iVe = pf.ve(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iVe, iVe);
            layoutParams.gravity = 17;
            this.yp.addView(this.gu, layoutParams);
        }
        if (z) {
            this.gu.setVisibility(0);
        } else {
            this.gu.setVisibility(8);
        }
    }
}
