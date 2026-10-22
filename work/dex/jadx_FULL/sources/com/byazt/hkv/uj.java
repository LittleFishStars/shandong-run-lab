package com.byazt.hkv;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.byazt.ete.da;
import com.byazt.ete.gr;
import com.byazt.ogz.i;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 19, 15})
public abstract class uj implements View.OnClickListener, View.OnTouchListener {
    public static float c = 0.0f;
    public static int i = 8;
    public static long n;
    public static float tt;
    public static float uj;
    public static float ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28610a;
    public da sp = new da();
    public final com.byazt.zo.uj x = new com.byazt.zo.uj();

    @com.byazt.zqa.c(c = {0, 1, 19, 123})
    public static class c {
        public int c;
        public double tt;
        public long uj;
        public double ve;

        public c(int i, double d, double d2, long j) {
            this.c = i;
            this.tt = d;
            this.ve = d2;
            this.uj = j;
        }
    }

    static {
        try {
            if (ViewConfiguration.get(gt.getContext()) != null) {
                i = ViewConfiguration.get(gt.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public uj(Context context) {
        if (context == null) {
            this.f28610a = gt.getContext();
        } else {
            this.f28610a = context;
        }
    }

    public <T extends com.byazt.zo.c> T c(Class<T> cls) {
        return (T) this.x.c(cls);
    }

    public abstract void c(View view, da daVar);

    public void c(gr grVar) {
    }

    public void n(int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.c()) {
            c(view, this.sp);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i2;
        this.sp.ve(motionEvent.getDeviceId());
        this.sp.tt(motionEvent.getToolType(0));
        this.sp.uj(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        int i3 = 1;
        if (actionMasked == 0) {
            this.sp.n((int) motionEvent.getRawX());
            this.sp.a((int) motionEvent.getRawY());
            this.sp.c(motionEvent.getRawX());
            this.sp.tt(motionEvent.getRawY());
            this.sp.c(System.currentTimeMillis());
            this.sp.tt(motionEvent.getToolType(0));
            this.sp.ve(motionEvent.getDeviceId());
            this.sp.uj(motionEvent.getSource());
            n = System.currentTimeMillis();
            this.sp.tt(true);
            com.byazt.aas.gr.c(motionEvent);
            i2 = 0;
        } else if (actionMasked != 1) {
            i2 = 2;
            if (actionMasked == 2) {
                ve += Math.abs(motionEvent.getX() - c);
                uj += Math.abs(motionEvent.getY() - tt);
                c = motionEvent.getX();
                tt = motionEvent.getY();
                long jCurrentTimeMillis = System.currentTimeMillis() - n;
                this.sp.ve(motionEvent.getRawX());
                this.sp.uj(motionEvent.getRawY());
                if (Math.abs(this.sp.my() - this.sp.sl()) >= i || Math.abs(this.sp.gt() - this.sp.t()) >= i) {
                    this.sp.tt(false);
                }
                if (jCurrentTimeMillis > 200) {
                    float f = ve;
                    int i4 = i;
                    if (f > i4 || tt > i4) {
                    }
                }
            } else if (actionMasked != 3) {
                i3 = -1;
            } else {
                if (com.byazt.gd.c.c(view) && com.byazt.gd.c.tt(view)) {
                    view.post(new Runnable() { // from class: com.byazt.hkv.uj.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (view.isShown()) {
                                uj ujVar = uj.this;
                                ujVar.c(view, ujVar.sp);
                            }
                        }
                    });
                    return true;
                }
                i3 = 4;
            }
            i2 = i3;
        } else {
            this.sp.ve(motionEvent.getRawX());
            this.sp.uj(motionEvent.getRawY());
            if (Math.abs(this.sp.my() - this.sp.sl()) >= i || Math.abs(this.sp.gt() - this.sp.t()) >= i) {
                this.sp.tt(false);
            }
            this.sp.tt(System.currentTimeMillis());
            Context context = this.f28610a;
            if (context == null) {
                context = gt.getContext();
            }
            com.byazt.zo.tt ttVar = (com.byazt.zo.tt) c(com.byazt.zo.tt.class);
            if (ttVar != null) {
                ttVar.c(this.sp);
            }
            if (com.byazt.gd.c.c(view)) {
                if (com.byazt.gd.c.c(view, this.sp.my(), this.sp.gt(), this.sp.sl(), this.sp.t())) {
                    return false;
                }
                if (com.byazt.gd.c.tt(view)) {
                    c(view, this.sp);
                }
                return true;
            }
            if (ttVar != null) {
                Point point = new Point((int) this.sp.my(), (int) this.sp.gt());
                if (view != null && !ttVar.c(view, context) && ttVar.c((View) view.getParent(), point)) {
                    return true;
                }
            }
            i2 = 3;
        }
        this.sp.u().put(motionEvent.getActionMasked(), new c(i2, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public void uj() {
    }

    public void ve() {
    }
}
