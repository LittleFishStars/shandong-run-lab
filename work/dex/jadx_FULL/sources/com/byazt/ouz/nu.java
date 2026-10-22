package com.byazt.ouz;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 137})
public class nu {
    public View c;
    public float da;
    public float i;
    public float sl;
    public float tt;
    public float ve;
    public float x;
    public float uj = 0.0f;
    public float n = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28921a = 0.0f;
    public float sp = 0.0f;
    public boolean t = false;
    public boolean u = false;
    public boolean yp = false;
    public boolean z = false;

    public nu(View view) {
        this.c = view;
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.uj = motionEvent.getX();
            this.n = motionEvent.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        this.f28921a = motionEvent.getX();
        this.sp = motionEvent.getY();
        if (Math.abs(this.f28921a - this.uj) < 5.0f || Math.abs(this.sp - this.n) < 5.0f) {
            this.z = false;
            return false;
        }
        this.z = true;
        return true;
    }

    public boolean tt(MotionEvent motionEvent) {
        this.tt = ((ViewGroup) this.c.getParent()).getWidth();
        this.ve = ((ViewGroup) this.c.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.u = false;
                this.yp = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.uj;
                float f2 = y - this.n;
                this.x = this.c.getLeft() + f;
                this.i = this.c.getTop() + f2;
                this.da = this.c.getRight() + f;
                this.sl = this.c.getBottom() + f2;
                if (this.x < 0.0f) {
                    this.yp = true;
                    this.x = 0.0f;
                    this.da = this.c.getWidth() + 0.0f;
                }
                float f3 = this.da;
                float f4 = this.tt;
                if (f3 > f4) {
                    this.u = true;
                    this.da = f4;
                    this.x = f4 - this.c.getWidth();
                }
                if (this.i < 0.0f) {
                    this.i = 0.0f;
                    this.sl = 0.0f + this.c.getHeight();
                }
                float f5 = this.sl;
                float f6 = this.ve;
                if (f5 > f6) {
                    this.sl = f6;
                    this.i = f6 - this.c.getHeight();
                }
                this.c.offsetLeftAndRight((int) f);
                this.c.offsetTopAndBottom((int) f2);
                if (this.yp) {
                    View view = this.c;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.u) {
                    View view2 = this.c;
                    view2.offsetLeftAndRight((int) (this.tt - view2.getRight()));
                }
            }
        } else {
            if (!this.z) {
                return false;
            }
            if (((int) motionEvent.getRawX()) > this.tt / 2.0f) {
                this.t = false;
                this.c.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.tt - this.c.getWidth()).start();
                View view3 = this.c;
                view3.offsetLeftAndRight((int) (this.tt - view3.getRight()));
            } else {
                this.t = true;
                this.c.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view4 = this.c;
                view4.offsetLeftAndRight(-view4.getLeft());
            }
            this.c.invalidate();
        }
        return true;
    }
}
