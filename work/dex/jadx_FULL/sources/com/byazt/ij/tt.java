package com.byazt.ij;

import android.view.MotionEvent;
import android.view.View;
import com.byazt.nk.InteractViewContainer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 13})
public class tt implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.nk.x f28650a;
    public float c;
    public InteractViewContainer n;
    public float tt;
    public boolean uj;
    public long ve;

    public tt(InteractViewContainer interactViewContainer, com.byazt.nk.x xVar) {
        this.n = interactViewContainer;
        this.f28650a = xVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.ve = System.currentTimeMillis();
            this.c = motionEvent.getX();
            this.tt = motionEvent.getY();
            this.n.n();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.c) >= com.byazt.or.x.c(com.byazt.sr.uj.getContext(), 10.0f) || Math.abs(y - this.tt) >= com.byazt.or.x.c(com.byazt.sr.uj.getContext(), 10.0f)) {
                    this.uj = true;
                    this.n.a();
                }
            }
        } else {
            if (this.uj) {
                return false;
            }
            if (System.currentTimeMillis() - this.ve >= com.igexin.push.config.c.j) {
                com.byazt.nk.x xVar = this.f28650a;
                if (xVar != null) {
                    xVar.c();
                }
            } else {
                this.n.a();
            }
        }
        return true;
    }
}
