package com.byazt.ij;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 54})
public class ve implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.nk.x f28652a;
    public float c;
    public boolean i;
    public boolean n;
    public int sp;
    public float tt;
    public float uj;
    public float ve;
    public boolean x;

    public ve(com.byazt.nk.x xVar) {
        this(xVar, 5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.nk.x xVar;
        com.byazt.nk.x xVar2;
        com.byazt.nk.x xVar3;
        if (this.i) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
            this.tt = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.uj = motionEvent.getX();
                this.ve = motionEvent.getY();
                if (Math.abs(this.uj - this.c) > 10.0f) {
                    this.n = true;
                }
                if (Math.abs(this.uj - this.c) > 8.0f || Math.abs(this.ve - this.tt) > 8.0f) {
                    this.x = false;
                }
                int iTt = com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), Math.abs(this.uj - this.c));
                if (this.uj > this.c && iTt > this.sp && (xVar3 = this.f28652a) != null) {
                    xVar3.c();
                    this.i = true;
                }
            }
        } else {
            if (!this.n && !this.x) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iTt2 = com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), Math.abs(this.uj - this.c));
            if (this.uj > this.c && iTt2 > this.sp && (xVar2 = this.f28652a) != null) {
                xVar2.c();
                this.i = true;
            }
            float fAbs = Math.abs(x - this.c);
            float fAbs2 = Math.abs(y - this.tt);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (xVar = this.f28652a) != null) {
                xVar.tt();
                this.i = true;
            }
        }
        return true;
    }

    public ve(com.byazt.nk.x xVar, int i) {
        this.sp = 5;
        this.x = true;
        this.f28652a = xVar;
        if (i > 0) {
            this.sp = i;
        }
    }
}
