package com.byazt.ij;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 71})
public class x implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28653a;
    public final com.byazt.nk.x c;
    public float n;
    public float sp;
    public final boolean tt;
    public float uj;
    public final int ve = 10;

    public x(com.byazt.nk.x xVar, boolean z) {
        this.c = xVar;
        this.tt = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.nk.x xVar;
        com.byazt.nk.x xVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.uj = motionEvent.getX();
            this.n = motionEvent.getY();
            new StringBuilder(", mStartY: ").append(this.n);
        } else if (action == 1) {
            this.f28653a = motionEvent.getX();
            this.sp = motionEvent.getY();
            new StringBuilder(", mEndY: ").append(this.sp);
            if (this.tt || (xVar2 = this.c) == null) {
                float f = this.f28653a - this.uj;
                float f2 = this.sp - this.n;
                if (com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), Math.abs((float) Math.sqrt((f * f) + (f2 * f2)))) > 10.0f && (xVar = this.c) != null) {
                    xVar.c();
                }
            } else {
                xVar2.c();
            }
        }
        return true;
    }
}
