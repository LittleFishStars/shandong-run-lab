package com.byazt.ij;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 20})
public class c implements View.OnTouchListener {
    public static int ve = 10;
    public float c;
    public int n;
    public float tt;
    public com.byazt.nk.x uj;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f28647a = new RectF();
    public long sp = 0;
    public final int x = 200;
    public final int i = 3;
    public SoftReference<ViewGroup> da = new SoftReference<>(null);

    public c(com.byazt.nk.x xVar, int i, final ViewGroup viewGroup) {
        this.n = ve;
        this.uj = xVar;
        if (i > 0) {
            this.n = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.byazt.ij.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.da = new SoftReference(viewGroup);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.nk.x xVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f28647a = c(this.da.get());
            this.c = motionEvent.getRawX();
            this.tt = motionEvent.getRawY();
            this.sp = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.f28647a;
            if (rectF != null && !rectF.contains(this.c, this.tt)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.c);
            float fAbs2 = Math.abs(rawY - this.tt);
            int i = this.n;
            if (fAbs >= i && fAbs2 >= i) {
                com.byazt.nk.x xVar2 = this.uj;
                if (xVar2 != null) {
                    xVar2.c();
                }
            } else if ((System.currentTimeMillis() - this.sp < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (xVar = this.uj) != null) {
                xVar.c();
            }
        }
        return true;
    }

    private RectF c(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new RectF(i, iArr[1], i + view.getWidth(), iArr[1] + view.getHeight());
    }
}
