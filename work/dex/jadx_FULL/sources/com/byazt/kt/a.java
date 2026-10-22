package com.byazt.kt;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 34})
public class a extends RecyclerView.my {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f28745a;
    public PointF ve;
    public final LinearInterpolator c = new LinearInterpolator();
    public final DecelerateInterpolator tt = new DecelerateInterpolator();
    public int uj = 0;
    public int n = 0;

    public a(Context context) {
        this.f28745a = c(context.getResources().getDisplayMetrics());
    }

    private int tt(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    @Override // com.byazt.kt.RecyclerView.my
    public void c(View view, RecyclerView.gt gtVar, RecyclerView.my.c cVar) {
        int iTt = tt(view, tt());
        int iC = c(view, ve());
        int iC2 = c((int) Math.sqrt((iTt * iTt) + (iC * iC)));
        if (iC2 > 0) {
            cVar.update(-iTt, -iC, iC2, this.tt);
        }
    }

    public int tt(int i) {
        return (int) Math.ceil(Math.abs(i) * this.f28745a);
    }

    public int ve() {
        PointF pointF = this.ve;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.y;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        return 0;
    }

    public int tt() {
        PointF pointF = this.ve;
        if (pointF == null) {
            return 0;
        }
        float f = pointF.x;
        if (f != 0.0f) {
            return f > 0.0f ? 1 : -1;
        }
        return 0;
    }

    public int tt(View view, int i) {
        RecyclerView.i iVarUj = uj();
        if (iVarUj == null || !iVarUj.ve()) {
            return 0;
        }
        RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
        return c(iVarUj.sp(view) - ((ViewGroup.MarginLayoutParams) daVar).leftMargin, iVarUj.i(view) + ((ViewGroup.MarginLayoutParams) daVar).rightMargin, iVarUj.gr(), iVarUj.qy() - iVarUj.yv(), i);
    }

    @Override // com.byazt.kt.RecyclerView.my
    public void c(int i, int i2, RecyclerView.gt gtVar, RecyclerView.my.c cVar) {
        if (i() == 0) {
            n();
            return;
        }
        this.uj = tt(this.uj, i);
        int iTt = tt(this.n, i2);
        this.n = iTt;
        if (this.uj == 0 && iTt == 0) {
            c(cVar);
        }
    }

    @Override // com.byazt.kt.RecyclerView.my
    public void c() {
        this.n = 0;
        this.uj = 0;
        this.ve = null;
    }

    public float c(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int c(int i) {
        return (int) Math.ceil(((double) tt(i)) / 0.3356d);
    }

    public void c(RecyclerView.my.c cVar) {
        PointF pointFUj = uj(x());
        if (pointFUj != null && (pointFUj.x != 0.0f || pointFUj.y != 0.0f)) {
            c(pointFUj);
            this.ve = pointFUj;
            this.uj = (int) (pointFUj.x * 10000.0f);
            this.n = (int) (pointFUj.y * 10000.0f);
            cVar.update((int) (this.uj * 1.2f), (int) (this.n * 1.2f), (int) (tt(10000) * 1.2f), this.c);
            return;
        }
        cVar.c(x());
        n();
    }

    public int c(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int c(View view, int i) {
        RecyclerView.i iVarUj = uj();
        if (iVarUj == null || !iVarUj.uj()) {
            return 0;
        }
        RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
        return c(iVarUj.x(view) - ((ViewGroup.MarginLayoutParams) daVar).topMargin, iVarUj.da(view) + ((ViewGroup.MarginLayoutParams) daVar).bottomMargin, iVarUj.zm(), iVarUj.gu() - iVarUj.p(), i);
    }
}
