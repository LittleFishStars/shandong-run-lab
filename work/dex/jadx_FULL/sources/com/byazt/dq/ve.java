package com.byazt.dq;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.byazt.sz.m;
import com.byazt.sz.rh;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1212, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28421a;
    public float c;
    public boolean n;
    public float tt;
    public Context uj;
    public m ve;

    public ve(Context context, m mVar) {
        this.uj = context;
        this.ve = mVar;
        this.f28421a = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean c(rh rhVar, com.byazt.xj.ve veVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
            this.tt = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.c) >= this.f28421a || Math.abs(y - this.tt) >= this.f28421a) {
                    this.n = true;
                }
            } else if (action == 3) {
                this.n = false;
            }
        } else {
            if (this.n) {
                this.n = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.c) >= this.f28421a || Math.abs(y2 - this.tt) >= this.f28421a) {
                this.n = false;
            } else if (rhVar != null) {
                rhVar.c(this.ve, veVar, veVar);
                return true;
            }
        }
        return true;
    }
}
