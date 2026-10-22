package com.byazt.ij;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 15})
public class uj implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28651a;
    public float c;
    public int da;
    public com.byazt.nk.x i;
    public boolean n = true;
    public boolean sl;
    public float sp;
    public float tt;
    public float uj;
    public float ve;
    public boolean x;

    public uj(com.byazt.nk.x xVar, int i, boolean z) {
        this.i = xVar;
        this.da = i;
        this.sl = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.nk.x xVar;
        com.byazt.nk.x xVar2;
        com.byazt.nk.x xVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
            this.tt = motionEvent.getY();
            this.f28651a = motionEvent.getY();
            this.n = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.sp = y;
                if (Math.abs(y - this.f28651a) > 10.0f) {
                    this.x = true;
                }
                this.uj = motionEvent.getX();
                this.ve = motionEvent.getY();
                if (Math.abs(this.uj - this.c) > 8.0f || Math.abs(this.ve - this.tt) > 8.0f) {
                    this.n = false;
                }
            }
        } else {
            if (!this.x && !this.n) {
                return false;
            }
            if (this.sl || (xVar3 = this.i) == null) {
                int iTt = com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), Math.abs(this.sp - this.f28651a));
                if (this.sp - this.f28651a < 0.0f && iTt > this.da && (xVar2 = this.i) != null) {
                    xVar2.c();
                } else if (this.n && (xVar = this.i) != null) {
                    xVar.c();
                }
            } else {
                xVar3.c();
            }
        }
        return true;
    }
}
