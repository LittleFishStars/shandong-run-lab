package com.byazt.msx;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.dl.uj;
import com.byazt.ete.h;
import com.byazt.ete.ic;
import com.byazt.ete.or;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nw.BaseSwiper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 341, 704})
public class FullSwiperView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28798a;
    public BaseSwiper<ViewGroup> c;
    public List<Long> da;
    public List<Integer> i;
    public float n;
    public List<FullSwiperItemView> sl;
    public boolean sp;
    public int t;
    public List<c> tt;
    public boolean u;
    public float uj;
    public TTBaseVideoActivity ve;
    public List<Integer> x;
    public boolean yp;
    public AtomicBoolean z;

    public FullSwiperView(TTBaseVideoActivity tTBaseVideoActivity) {
        super(tTBaseVideoActivity);
        this.sp = false;
        this.u = true;
        this.yp = true;
        this.z = new AtomicBoolean(false);
        this.ve = tTBaseVideoActivity;
        this.x = new ArrayList();
        this.i = new ArrayList();
        this.da = new ArrayList();
        this.c = new SwiperView(tTBaseVideoActivity);
        this.sl = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.c, layoutParams);
    }

    public int getCurrentPosition() {
        return this.t;
    }

    public void a() {
        BaseSwiper<ViewGroup> baseSwiper = this.c;
        if (baseSwiper != null) {
            baseSwiper.sp();
        }
    }

    public void n() {
        for (FullSwiperItemView fullSwiperItemView : this.sl) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.rh();
            }
        }
    }

    public void sp() {
        BaseSwiper<ViewGroup> baseSwiper = this.c;
        if (baseSwiper != null) {
            baseSwiper.yp(this.t + 1);
        }
    }

    public void uj() {
        a();
    }

    public void ve() {
        FullSwiperItemView fullSwiperItemViewVe = ve(this.t);
        if (fullSwiperItemViewVe != null) {
            fullSwiperItemViewVe.m();
        }
        if (this.t == this.sl.size() - 1) {
            return;
        }
        this.c.yp(this.t);
        List<Integer> list = this.i;
        if (list == null || this.t >= list.size()) {
            return;
        }
        if (!this.u && (!this.z.get() || or.yp() == 1)) {
            c(this.i.get(this.t).intValue());
        }
        this.u = false;
    }

    public FullSwiperView c(List<c> list) {
        this.tt = list;
        return this;
    }

    public FullSwiperView tt(float f) {
        this.n = f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i) {
        FullSwiperItemView fullSwiperItemViewVe = ve(i);
        if (fullSwiperItemViewVe != null) {
            fullSwiperItemViewVe.u();
        }
    }

    public FullSwiperView c(float f) {
        this.uj = f;
        return this;
    }

    public FullSwiperView c(String str) {
        this.f28798a = str;
        return this;
    }

    public void c() {
        h hVarZo;
        List<c> list = this.tt;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.c.c(false).c("dot").uj(false).ve(false).tt(false);
        this.c.setOnPageChangeListener(new com.byazt.nw.c() { // from class: com.byazt.msx.FullSwiperView.1
            @Override // com.byazt.nw.c
            public void c(boolean z, int i) {
            }

            @Override // com.byazt.nw.c
            public void c(boolean z, int i, float f, int i2) {
            }

            @Override // com.byazt.nw.c
            public void c(boolean z, int i, int i2, boolean z2, boolean z3) {
                if (FullSwiperView.this.yp && i == 1) {
                    return;
                }
                FullSwiperView.this.yp = false;
                FullSwiperView.this.t = i;
                FullSwiperItemView fullSwiperItemViewVe = FullSwiperView.this.ve(i);
                if (fullSwiperItemViewVe != null && FullSwiperView.this.t != 0) {
                    fullSwiperItemViewVe.tt(false);
                }
                FullSwiperItemView fullSwiperItemViewVe2 = FullSwiperView.this.ve(i - 1);
                if (fullSwiperItemViewVe2 != null) {
                    fullSwiperItemViewVe2.z();
                    fullSwiperItemViewVe2.nu();
                }
                FullSwiperView.this.tt(i + 1);
                if (!FullSwiperView.this.sp && i > 0) {
                    FullSwiperView.this.sp = true;
                    uj.tt(FullSwiperView.this.f28798a);
                }
                int iIntValue = ((Integer) FullSwiperView.this.x.get(i)).intValue();
                if (iIntValue > 0 && i != FullSwiperView.this.sl.size() - 1) {
                    FullSwiperView.this.da.add(i, Long.valueOf(System.currentTimeMillis()));
                    int i3 = iIntValue / 1000;
                    int iMin = Math.min(or.tt(false), i3);
                    int iMax = Math.max(i3 - or.tt(false), 0);
                    if (iMin > 0) {
                        FullSwiperView.this.z.set(false);
                        FullSwiperView.this.ve.c(-1, iMin, iMax);
                    } else if (or.yp() == 1) {
                        FullSwiperView.this.c(iIntValue);
                    } else {
                        if (FullSwiperView.this.z.get()) {
                            return;
                        }
                        FullSwiperView.this.c(iIntValue);
                    }
                }
            }
        });
        for (c cVar : this.tt) {
            ic icVarC = cVar.c();
            if (icVarC != null && (hVarZo = icVarC.zo()) != null) {
                this.x.add(Integer.valueOf((int) hVarZo.tt()));
                this.i.add(0);
                this.da.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.ve, cVar, this.uj, this.n);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.c() { // from class: com.byazt.msx.FullSwiperView.2
                    @Override // com.byazt.msx.FullSwiperItemView.c
                    public void c() {
                        if (or.yp() == 0) {
                            FullSwiperView.this.a();
                            FullSwiperView.this.ve.tx();
                        }
                        FullSwiperView.this.z.set(true);
                    }
                });
                this.c.c(fullSwiperItemView);
                this.sl.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.sl.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.tt() { // from class: com.byazt.msx.FullSwiperView.3
            @Override // com.byazt.msx.FullSwiperItemView.tt
            public void c(View view, float f, float f2) {
                int iIntValue = ((Integer) FullSwiperView.this.x.get(0)).intValue();
                if (iIntValue <= 0) {
                    FullSwiperView.this.c.a();
                } else {
                    FullSwiperView.this.da.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.c.a();
                    if (FullSwiperView.this.sl.size() > 1) {
                        int i = iIntValue / 1000;
                        int iMin = Math.min(or.tt(false), i);
                        int iMax = Math.max(i - or.tt(false), 0);
                        if (iMin > 0) {
                            FullSwiperView.this.ve.c(-1, iMin, iMax);
                        } else {
                            FullSwiperView.this.c(iIntValue);
                        }
                    }
                }
                fullSwiperItemView2.tt(true);
                FullSwiperView.this.tt(1);
            }
        });
        fullSwiperItemView2.u();
    }

    public void tt() {
        FullSwiperItemView fullSwiperItemViewVe = ve(this.t);
        if (fullSwiperItemViewVe != null) {
            fullSwiperItemViewVe.z();
        }
        List<Long> list = this.da;
        if (list != null && this.t < list.size()) {
            this.i.add(this.t, Integer.valueOf(this.x.get(this.t).intValue() - ((int) (System.currentTimeMillis() - this.da.get(this.t).longValue()))));
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView ve(int i) {
        List<FullSwiperItemView> list = this.sl;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.sl.get(i);
    }

    public void c(int i) {
        BaseSwiper<ViewGroup> baseSwiper;
        if (Math.min(or.tt(false), i / 1000) <= 0 && (baseSwiper = this.c) != null) {
            baseSwiper.z(i);
        }
    }
}
