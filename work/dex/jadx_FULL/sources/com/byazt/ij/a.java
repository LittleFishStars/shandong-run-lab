package com.byazt.ij;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 34})
public class a implements View.OnTouchListener {
    public static int ve = 10;
    public float c;
    public com.byazt.nk.x n;
    public float tt;
    public boolean uj;

    public a(com.byazt.nk.x xVar) {
        this.n = xVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
            this.tt = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.c) >= ve || Math.abs(y - this.tt) >= ve) {
                    this.uj = true;
                }
            } else if (action == 3) {
                this.uj = false;
            }
        } else {
            if (this.uj) {
                this.uj = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.c) >= ve || Math.abs(y2 - this.tt) >= ve) {
                this.uj = false;
            } else {
                com.byazt.nk.x xVar = this.n;
                if (xVar != null) {
                    xVar.c();
                }
            }
        }
        return true;
    }
}
