package com.byazt.ab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.byazt.aas.pf;
import com.byazt.bzd.t;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.ete.lo;
import com.byazt.ete.my;
import com.byazt.ete.xd;
import com.byazt.jzl.a;
import com.byazt.nr.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 757, 20})
public class c implements qp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f28281a;
    public final String c;
    public final int n;
    public boolean sl;
    public PlayableVideoContainer sp;
    public final Context tt;
    public final ic ve;
    public ve x;
    public final com.byazt.zd.tt yp;
    public final d uj = new d(Looper.getMainLooper(), this);
    public boolean i = false;
    public boolean da = true;
    public boolean t = false;
    public boolean u = false;

    public c(String str, Activity activity, ic icVar, int i, com.byazt.zd.tt ttVar, FrameLayout frameLayout) {
        this.c = str;
        this.tt = activity;
        this.ve = icVar;
        this.n = i;
        if (!my.uj(icVar)) {
            this.f28281a = frameLayout;
        }
        n();
        this.yp = ttVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        if (this.sp == null || this.f28281a == null) {
            return;
        }
        sp();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.sp, "translationX", -pf.ve(this.tt, 150.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.sp, "translationY", -pf.ve(this.tt, 100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.sp, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    private void i() {
        PlayableVideoContainer playableVideoContainer = this.sp;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.tt(true);
        this.uj.sendEmptyMessageDelayed(1, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.t = true;
        if (this.sl) {
            this.sl = false;
            tt();
        }
        c(this.da);
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        PlayableVideoContainer playableVideoContainer = this.sp;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.tt(false);
    }

    private void a() {
        pf.c((View) this.f28281a, 8);
        pf.c((View) this.sp, 8);
    }

    private void n() {
        if (this.f28281a == null) {
            return;
        }
        if (lo.tt(this.ve) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.tt);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pf.ve(this.tt, 156.0f), pf.ve(this.tt, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = pf.ve(this.tt, 55.0f);
            layoutParams.rightMargin = pf.ve(this.tt, 20.0f);
            this.f28281a.addView(playableVideoContainer, layoutParams);
            this.sp = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.tt);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(pf.ve(this.tt, 73.0f), pf.ve(this.tt, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = pf.ve(this.tt, 55.0f);
        layoutParams2.rightMargin = pf.ve(this.tt, 30.0f);
        this.f28281a.addView(playableVideoContainer2, layoutParams2);
        this.sp = playableVideoContainer2;
    }

    private void sp() {
        pf.c((View) this.f28281a, 0);
        pf.c((View) this.sp, 0);
    }

    public void c(long j, boolean z) {
        PlayableVideoContainer playableVideoContainer;
        this.u = true;
        this.da = z;
        c(j);
        if (this.i) {
            if (this.yp != null && (playableVideoContainer = this.sp) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.byazt.ab.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.da();
                    }
                }, 500L);
                this.sp.setCustomClickListener(new View.OnClickListener() { // from class: com.byazt.ab.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.f28281a != null) {
                            c.this.c();
                            c.this.yp.tt();
                        }
                    }
                });
            } else if (t.c(this.ve)) {
                a();
            } else {
                sp();
            }
        }
    }

    public void tt() {
        if (this.u && this.i && this.x != null) {
            this.uj.removeMessages(1);
            if (this.t) {
                this.x.a();
            } else {
                this.sl = true;
            }
        }
    }

    public void uj() {
        ve veVar = this.x;
        if (veVar == null) {
            return;
        }
        veVar.da();
        this.x = null;
        this.i = false;
        this.sl = false;
        this.t = false;
    }

    public void ve() {
        if (this.u && this.i && this.x != null) {
            this.sl = false;
            this.uj.sendEmptyMessageDelayed(1, 2000L);
            if (this.x.lr()) {
                return;
            }
            this.x.x();
        }
    }

    public void c() {
        this.u = false;
        uj();
        a();
    }

    private void c(long j) {
        if (this.sp == null) {
            return;
        }
        if (this.yp != null || t.c(this.ve)) {
            if (this.i) {
                ve veVar = this.x;
                if (veVar != null) {
                    veVar.tt(j);
                    this.x.c(j);
                    return;
                }
                return;
            }
            this.i = true;
            a aVarC = xd.c(1, this.ve);
            aVarC.setCid(this.ve.uj());
            aVarC.setWidth(this.sp.getWidth());
            aVarC.setHeight(this.sp.getHeight());
            aVarC.setLogExtra(this.ve.w_());
            aVarC.setCurrent(j);
            aVarC.setQuiet(this.da);
            if (t.c(this.ve)) {
                aVarC.setAudio(true);
            }
            ve veVar2 = new ve(this.tt, this.sp.getVideoContainer(), this.ve, null);
            this.x = veVar2;
            veVar2.c(new com.byazt.zd.c.InterfaceC0595c() { // from class: com.byazt.ab.c.3
                @Override // com.byazt.zd.c.InterfaceC0595c
                public void c() {
                    if (c.this.yp != null) {
                        c.this.c();
                        c.this.yp.ve();
                    } else {
                        if (!t.c(c.this.ve) || c.this.x == null || c.this.x.n()) {
                            return;
                        }
                        c.this.c();
                    }
                }

                @Override // com.byazt.zd.c.InterfaceC0595c
                public void tt() {
                    c.this.sp.c(true);
                    if (c.this.yp != null) {
                        c.this.yp.da();
                    }
                }

                @Override // com.byazt.zd.c.InterfaceC0595c
                public void ve() {
                    c.this.x();
                }

                @Override // com.byazt.zd.c.InterfaceC0595c
                public void c(int i, String str) {
                    if (i == 308) {
                        return;
                    }
                    c.this.sp.c(true);
                }

                @Override // com.byazt.zd.c.InterfaceC0595c
                public void c(long j2, long j3) {
                    c.this.sp.c(false);
                    if (c.this.yp != null) {
                        c.this.yp.c(j2, j3);
                    }
                }
            });
            this.x.tt(j);
            this.x.c(aVarC);
            if (this.yp != null) {
                this.x.gr();
                this.x.sp(false);
                this.sp.c();
            } else {
                if (t.c(this.ve)) {
                    this.x.sp(true);
                }
                i();
            }
        }
    }

    public void c(boolean z) {
        ve veVar = this.x;
        if (veVar == null) {
            return;
        }
        this.da = z;
        veVar.tt(z);
    }
}
