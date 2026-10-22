package com.byazt.sgn;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.aas.pf;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 215})
public class yp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29020a;
    public final c c;
    public float n;
    public boolean sl;
    public int sp;
    public float uj;
    public boolean tt = false;
    public boolean ve = false;
    public boolean x = true;
    public boolean i = false;
    public final View.OnTouchListener da = new View.OnTouchListener() { // from class: com.byazt.sgn.yp.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (yp.this.c.z()) {
                return yp.this.tt || !yp.this.ve;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                yp ypVar = yp.this;
                ypVar.sl = ypVar.c(motionEvent);
                yp.this.uj = x;
                yp.this.n = y;
                yp.this.f29020a = (int) x;
                yp.this.sp = (int) y;
                yp.this.x = true;
                if (yp.this.c != null && yp.this.ve && !yp.this.tt) {
                    yp.this.c.c(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - yp.this.f29020a) > 20.0f || Math.abs(y - yp.this.sp) > 20.0f) {
                    yp.this.x = false;
                }
                if (!yp.this.tt) {
                    yp.this.x = true;
                }
                yp.this.i = false;
                yp.this.uj = 0.0f;
                yp.this.n = 0.0f;
                yp.this.f29020a = 0;
                if (yp.this.c != null) {
                    yp.this.c.c(view, yp.this.x);
                }
                yp.this.sl = false;
            } else if (action != 2) {
                if (action == 3) {
                    yp.this.sl = false;
                }
            } else if (yp.this.tt && !yp.this.sl) {
                float f = x - yp.this.uj;
                float f2 = y - yp.this.n;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (!yp.this.i) {
                    if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                        return true;
                    }
                    yp.this.i = true;
                }
                if (yp.this.c != null) {
                    yp.this.c.yp();
                }
                yp.this.uj = x;
                yp.this.n = y;
            }
            return yp.this.tt || !yp.this.ve;
        }
    };

    public interface c {
        void c(View view, boolean z);

        void yp();

        boolean z();
    }

    public yp(c cVar) {
        this.c = cVar;
    }

    public void c(View view) {
        if (view != null) {
            view.setOnTouchListener(this.da);
        }
    }

    public void c(boolean z) {
        this.ve = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iUj = pf.uj(gt.getContext().getApplicationContext());
        int iN = pf.n(gt.getContext().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iUj;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = iN;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
