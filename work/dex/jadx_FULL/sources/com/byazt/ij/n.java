package com.byazt.ij;

import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 46})
public class n implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28648a;
    public boolean i;
    public float n;
    public com.byazt.nk.x sp;
    public float uj;
    public int x;
    public Map<Integer, Float> c = new HashMap();
    public Map<Integer, Float> tt = new HashMap();
    public Map<Integer, Boolean> ve = new HashMap();

    public n(com.byazt.nk.x xVar, int i, boolean z) {
        this.sp = xVar;
        this.x = i;
        this.i = z;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d2  */
    private boolean c(MotionEvent motionEvent) {
        Boolean bool;
        com.byazt.nk.x xVar;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                bool = this.ve.get(Integer.valueOf(pointerId));
                if (bool != null || !bool.booleanValue()) {
                    c(pointerId);
                    return false;
                }
                Float f = this.c.get(Integer.valueOf(pointerId));
                Float f2 = this.tt.get(Integer.valueOf(pointerId));
                if (f != null && f2 != null) {
                    int iTt = com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), Math.abs(f2.floatValue() - f.floatValue()));
                    if (f2.floatValue() - f.floatValue() < 0.0f && iTt > this.x && (xVar = this.sp) != null) {
                        xVar.c();
                    }
                }
                c(pointerId);
            } else if (actionMasked == 2) {
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    int pointerId2 = motionEvent.getPointerId(i);
                    float y = motionEvent.getY(i);
                    Float f3 = this.c.get(Integer.valueOf(pointerId2));
                    if (f3 != null) {
                        this.tt.put(Integer.valueOf(pointerId2), Float.valueOf(y));
                        if (Math.abs(y - f3.floatValue()) > 10.0f) {
                            this.ve.put(Integer.valueOf(pointerId2), Boolean.TRUE);
                        }
                    }
                }
            } else if (actionMasked == 3) {
                c();
            } else if (actionMasked == 5) {
                this.c.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
                this.ve.put(Integer.valueOf(pointerId), Boolean.FALSE);
            } else if (actionMasked == 6) {
                bool = this.ve.get(Integer.valueOf(pointerId));
                if (bool != null) {
                }
                c(pointerId);
                return false;
            }
        } else {
            this.c.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
            this.ve.put(Integer.valueOf(pointerId), Boolean.FALSE);
        }
        return true;
    }

    private boolean tt(MotionEvent motionEvent) {
        com.byazt.nk.x xVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.uj = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.n = y;
                if (Math.abs(y - this.uj) > 10.0f) {
                    this.f28648a = true;
                }
            }
        } else {
            if (!this.f28648a) {
                return false;
            }
            int iTt = com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), Math.abs(this.n - this.uj));
            if (this.n - this.uj < 0.0f && iTt > this.x && (xVar = this.sp) != null) {
                xVar.c();
                this.uj = 0.0f;
                this.n = 0.0f;
                this.f28648a = false;
            }
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.i ? c(motionEvent) : tt(motionEvent);
    }

    private void c(int i) {
        this.c.remove(Integer.valueOf(i));
        this.tt.remove(Integer.valueOf(i));
        this.ve.remove(Integer.valueOf(i));
    }

    private void c() {
        this.c.clear();
        this.tt.clear();
        this.ve.clear();
    }
}
