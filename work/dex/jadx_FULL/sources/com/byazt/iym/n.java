package com.byazt.iym;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.ete.zb;
import com.byazt.ff.TTProgressBar;
import com.byazt.ff.TTRatingBar;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.kt.RecyclerView;
import com.byazt.nr.d;
import com.byazt.nr.z;
import com.byazt.ouz.sl;
import com.byazt.rpt.FullRewardExpressView;
import com.byazt.vfu.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 46})
public class n extends RecyclerView.gu implements qp.c {
    public int bx;
    public com.byazt.fcd.ve.c cu;
    public boolean d;
    public com.byazt.iym.tt eo;
    public TTProgressBar gr;
    public FrameLayout gt;
    public FrameLayout gu;
    public boolean h;
    public boolean md;
    public FrameLayout my;
    public LinearLayout nb;
    public FullRewardExpressView nu;
    public int or;
    public final AtomicBoolean p;
    public final AnimatorSet pf;
    public final d qp;
    public FrameLayout qy;
    public ViewGroup rh;
    public FrameLayout rl;
    public final AtomicBoolean yv;
    public boolean zb;
    public uj zm;

    @com.byazt.zqa.c(c = {0, 1, 784, 151})
    public static class c implements Interpolator {
        private c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public n(View view) {
        super(view);
        this.qp = new d(Looper.getMainLooper(), this);
        this.pf = new AnimatorSet();
        this.yv = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.bx = Integer.MAX_VALUE;
        this.rh = (ViewGroup) view.findViewById(2114387892);
        this.my = (FrameLayout) view.findViewById(2114387778);
        this.gt = (FrameLayout) view.findViewById(2114387812);
        this.rl = (FrameLayout) view.findViewById(2114387670);
        this.qy = (FrameLayout) view.findViewById(2114387821);
        this.gu = (FrameLayout) view.findViewById(2114387679);
        this.gr = (TTProgressBar) view.findViewById(2114387767);
        c(view.getContext());
    }

    private void bx() {
        FullRewardExpressView fullRewardExpressView = this.nu;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.t();
        }
        this.bx = Integer.MAX_VALUE;
        this.d = false;
        this.h = false;
        this.zb = false;
        this.gt.removeAllViews();
        this.rl.removeAllViews();
        this.qy.removeAllViews();
        this.gu.removeAllViews();
        this.yv.set(false);
        this.p.set(false);
        this.my.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        uj ujVar = this.zm;
        if (ujVar != null) {
            ujVar.da();
        }
    }

    public void cu() {
        FullRewardExpressView fullRewardExpressView = this.nu;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.t();
        }
        uj ujVar = this.zm;
        if (ujVar != null) {
            ujVar.i();
        }
    }

    public void d() {
        if (this.zm != null && this.h && this.d) {
            this.eo.i();
            this.nu.z();
            if (this.zb && this.zm.gr()) {
                ve(this.eo.a());
                or();
            } else {
                this.zb = true;
                this.qp.sendEmptyMessageDelayed(101, 5000L);
                this.eo.c(this.nu);
                this.zm.c(this.eo.da());
            }
        }
    }

    public long eo() {
        com.byazt.iym.tt ttVar = this.eo;
        if (ttVar == null) {
            return -1L;
        }
        return ttVar.sl();
    }

    public void h() {
        if (this.pf.isStarted() && this.pf.isRunning()) {
            this.pf.cancel();
        }
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what != 101) {
            return;
        }
        uj(true);
        com.byazt.iym.tt ttVar = this.eo;
        if (ttVar != null) {
            ttVar.sp();
        }
    }

    public void md() {
        if (this.pf.isStarted() && this.pf.isPaused()) {
            this.pf.resume();
        }
    }

    public boolean nb() {
        uj ujVar = this.zm;
        if (ujVar == null) {
            return false;
        }
        return ujVar.zm();
    }

    public void or() {
        uj ujVar = this.zm;
        if (ujVar != null) {
            ujVar.x();
        }
    }

    public void p() {
        if (this.pf.isStarted() && this.pf.isRunning()) {
            this.pf.pause();
        }
    }

    public boolean pf() {
        return this.p.get();
    }

    public com.byazt.dh.ve qp() {
        return this.zm;
    }

    public void zb() {
        uj ujVar = this.zm;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(boolean z) {
        if (this.h) {
            if (this.bx > pf.n(this.c.getContext()) * 0.7f) {
                pf.c((View) this.nb, 0);
                this.pf.start();
            }
            if (!z || this.yv.get()) {
                return;
            }
            this.yv.set(true);
        }
    }

    public void ve(boolean z) {
        uj ujVar = this.zm;
        if (ujVar != null) {
            ujVar.tt(z);
        }
    }

    public void c(final com.byazt.iym.tt ttVar, float f, float f2) {
        this.eo = ttVar;
        this.gr.setVisibility(0);
        bx();
        FullRewardExpressView fullRewardExpressViewTt = ttVar.tt(f, f2);
        this.nu = fullRewardExpressViewTt;
        if (ttVar.n) {
            if (fullRewardExpressViewTt.rl()) {
                this.qy.setVisibility(8);
                this.gu.addView(c(this.c.getContext(), ttVar));
                this.gu.setVisibility(0);
            } else {
                this.nu.c((ViewGroup) this.my, false);
            }
            this.or = this.nu.getDynamicShowType();
            this.d = true;
            d();
            this.gr.setVisibility(8);
        } else {
            fullRewardExpressViewTt.setExpressInteractionListener(new com.byazt.ouz.c() { // from class: com.byazt.iym.n.1
                @Override // com.byazt.ouz.c
                public void c(View view, float f3, float f4) {
                    if (n.this.nu.rl()) {
                        n.this.qy.setVisibility(8);
                        n nVar = n.this;
                        nVar.gu.addView(nVar.c(view.getContext(), ttVar));
                        n.this.gu.setVisibility(0);
                    } else {
                        n nVar2 = n.this;
                        nVar2.nu.c((ViewGroup) nVar2.my, false);
                    }
                    n nVar3 = n.this;
                    nVar3.or = nVar3.nu.getDynamicShowType();
                    n.this.d = true;
                    n.this.d();
                    n.this.gr.setVisibility(8);
                }
            });
        }
        this.nu.setExpressVideoListenerProxy(new sl() { // from class: com.byazt.iym.n.2
            @Override // com.byazt.ouz.sl
            public void a() {
            }

            @Override // com.byazt.ouz.sl
            public void c(float f3) {
            }

            @Override // com.byazt.ouz.sl
            public void c(int i) {
                n nVar = n.this;
                uj ujVar = nVar.zm;
                if (ujVar == null) {
                    return;
                }
                if (i == 2) {
                    ujVar.sp(true);
                    if (n.this.h) {
                        n.this.cu.c();
                        n.this.zb();
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                nVar.p.set(false);
                n.this.zm.sp(false);
                if (n.this.h) {
                    n.this.cu.tt();
                    n.this.or();
                }
            }

            @Override // com.byazt.ouz.sl
            public void c(int i, String str) {
            }

            @Override // com.byazt.ouz.sl
            public void c(ic icVar) {
            }

            @Override // com.byazt.ouz.sl
            public void c(boolean z) {
            }

            @Override // com.byazt.ouz.sl
            public void da() {
            }

            @Override // com.byazt.ouz.sl
            public void i() {
            }

            @Override // com.byazt.ouz.sl
            public void n() {
            }

            @Override // com.byazt.ouz.sl
            public void n(int i) {
            }

            @Override // com.byazt.ouz.sl
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.byazt.ouz.sl
            public void sp() {
            }

            @Override // com.byazt.ouz.sl
            public int tt() {
                if (n.this.yv.get()) {
                    return 4;
                }
                n nVar = n.this;
                if (nVar.zm == null || !nVar.zb) {
                    return 2;
                }
                if (n.this.zm.bm()) {
                    return 5;
                }
                if (n.this.zm.qy()) {
                    return 1;
                }
                if (n.this.zm.lr()) {
                    return 2;
                }
                n.this.zm.gr();
                return 3;
            }

            @Override // com.byazt.ouz.sl
            public void uj() {
                n.this.p.set(true);
                if (n.this.h) {
                    n.this.cu.c();
                    n.this.eo.tt(false);
                }
            }

            @Override // com.byazt.ouz.sl
            public void uj(int i) {
            }

            @Override // com.byazt.ouz.sl
            public int ve() {
                uj ujVar = n.this.zm;
                if (ujVar == null) {
                    return 0;
                }
                return (int) (ujVar.sl() / 1000);
            }

            @Override // com.byazt.ouz.sl
            public void ve(int i) {
            }

            @Override // com.byazt.ouz.sl
            public void x() {
            }

            @Override // com.byazt.ouz.sl
            public void tt(int i) {
                n.this.cu.c(i);
            }

            @Override // com.byazt.ouz.sl
            public long c() {
                return n.this.zm.sl();
            }

            @Override // com.byazt.ouz.sl
            public void c(float f3, float f4, float f5, float f6, int i) {
                n.this.c(f3, f4, f5, f6, i);
            }
        });
        this.nu.setOnVideoSizeChangeListener(new FullRewardExpressView.c() { // from class: com.byazt.iym.n.3
            @Override // com.byazt.rpt.FullRewardExpressView.c
            public void c(int i) {
                n.this.bx = i;
            }
        });
        this.qy.addView(this.nu);
        uj ujVar = new uj(this.rh.getContext(), this.gt, ttVar.c());
        this.zm = ujVar;
        this.nu.setVideoController(ujVar);
        ttVar.c(this.gt, this.rl, this.nu);
        this.zm.c(new tt(ttVar.n(), lt.ve(this.eo.c()), new tt.c() { // from class: com.byazt.iym.n.4
            @Override // com.byazt.iym.n.tt.c
            public void c(boolean z) {
                n.this.uj(z);
            }

            @Override // com.byazt.iym.n.tt.c
            public void c() {
                n.this.cu.uj();
            }

            @Override // com.byazt.iym.n.tt.c
            public void c(long j, long j2) {
                n.this.cu.c(j, j2);
            }
        }, this.qp));
        this.zm.tt(this.eo.sl());
        this.nu.nu();
    }

    public void tt(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        if (z) {
            d();
            return;
        }
        zb();
        pf.c((View) this.nb, 8);
        this.pf.cancel();
    }

    @com.byazt.zqa.c(c = {0, 1, 784, 934})
    public static class tt implements com.byazt.zd.c.InterfaceC0595c {
        public final com.byazt.zd.c.InterfaceC0595c c;
        public final d n;
        public final c tt;
        public final int uj;
        public boolean ve = false;

        public interface c {
            void c();

            void c(long j, long j2);

            void c(boolean z);
        }

        public tt(com.byazt.zd.c.InterfaceC0595c interfaceC0595c, int i, c cVar, d dVar) {
            this.c = interfaceC0595c;
            this.tt = cVar;
            this.uj = i;
            this.n = dVar;
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void c() {
            this.ve = false;
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.c();
            }
            c cVar = this.tt;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void tt() {
            c(true);
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.tt();
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void ve() {
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.ve();
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void c(int i, String str) {
            c(true);
            this.ve = false;
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.c(i, str);
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void c(long j, long j2) {
            this.n.removeMessages(101);
            if (j2 > 20000 && j > Math.min(((long) this.uj) * 1000, j2) * 0.75f) {
                c(false);
                this.ve = true;
            }
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.c(j, j2);
            }
            c cVar = this.tt;
            if (cVar != null) {
                cVar.c(j, j2);
            }
        }

        private void c(boolean z) {
            c cVar;
            if (this.ve || (cVar = this.tt) == null) {
                return;
            }
            cVar.c(z);
        }
    }

    public View c(Context context, com.byazt.iym.tt ttVar) {
        String strTj;
        String strValueOf;
        View viewYp = a.yp(context);
        RelativeLayout relativeLayout = (RelativeLayout) viewYp.findViewById(2114387649);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) viewYp.findViewById(2114387793);
        TextView textView = (TextView) viewYp.findViewById(2114387875);
        TextView textView2 = (TextView) viewYp.findViewById(2114387630);
        TextView textView3 = (TextView) viewYp.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) viewYp.findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(pf.ve(context, 15.0f));
            tTRatingBar.setStarImageHeight(pf.ve(context, 14.0f));
            tTRatingBar.setStarImagePadding(pf.ve(context, 4.0f));
            tTRatingBar.c();
        }
        if (tTRoundRectImageView != null) {
            zb zbVarTe = ttVar.c().te();
            if (zbVarTe != null && !TextUtils.isEmpty(zbVarTe.c())) {
                com.byazt.xky.tt.c(zbVarTe).to(tTRoundRectImageView);
            } else {
                z.c(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView, 320);
            }
        }
        if (textView != null) {
            if (ttVar.c().z() != null && !TextUtils.isEmpty(ttVar.c().z().ve())) {
                textView.setText(ttVar.c().z().ve());
            } else {
                textView.setText(ttVar.c().v_());
            }
        }
        if (textView2 != null) {
            int iA = ttVar.c().z() != null ? ttVar.c().z().a() : 6870;
            if (iA > 10000) {
                strValueOf = (iA / 10000) + "万";
            } else {
                strValueOf = String.valueOf(iA);
            }
            textView2.setText(String.format("%1$s个评分", strValueOf));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(ttVar.c().tj())) {
                strTj = ttVar.c().i() != 4 ? "查看详情" : "立即下载";
            } else {
                strTj = ttVar.c().tj();
            }
            textView3.setText(strTj);
        }
        pf.c((View) relativeLayout, (View.OnClickListener) ttVar.ve(), "reward_draw_listener");
        return viewYp;
    }

    private void c(Context context) {
        if (this.md) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.nb = linearLayout;
            linearLayout.setClipChildren(false);
            this.nb.setGravity(1);
            this.nb.setOrientation(1);
            ImageView imageView = new ImageView(context);
            z.c(context, "tt_ic_back_light", imageView, 320);
            this.nb.addView(imageView, -1, -2);
            ImageView imageView2 = new ImageView(context);
            z.c(context, "tt_ic_back_light", imageView2, 320);
            imageView2.setAlpha(0.7f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = pf.ve(context, -8.0f);
            this.nb.addView(imageView2, layoutParams);
            TextView textView = new TextView(context);
            textView.setGravity(1);
            textView.setTextColor(-1);
            textView.setText("上滑浏览更多内容");
            this.nb.addView(textView);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = pf.ve(context, 156.0f);
            this.rh.addView(this.nb, layoutParams2);
            this.rh.setClipChildren(false);
            this.nb.setVisibility(8);
            c(imageView, imageView2);
        }
    }

    private void c(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new c());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, pf.ve(this.rh.getContext(), -5.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new c());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationY", pf.ve(this.rh.getContext(), -6.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        this.pf.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat2, objectAnimatorOfFloat4);
    }

    public void c(View view) {
        com.byazt.iym.tt ttVar = this.eo;
        if (ttVar == null || ttVar.ve() == null) {
            return;
        }
        this.eo.ve().onClick(view);
    }

    public void c(float f, float f2, float f3, float f4, int i) {
        FullRewardExpressView fullRewardExpressView = this.nu;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.nu.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.nu.getVideoFrameLayout().getMeasuredHeight();
        if (this.zm.hd()) {
            this.nu.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.nu.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    public void c(com.byazt.fcd.ve.c cVar) {
        uj ujVar;
        this.cu = cVar;
        if (cVar == null || (ujVar = this.zm) == null) {
            return;
        }
        ujVar.tt(cVar.ve());
    }
}
