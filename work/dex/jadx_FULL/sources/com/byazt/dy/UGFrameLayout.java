package com.byazt.dy;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.byazt.sa.uj;
import com.byazt.sz.m;
import com.zj.adlib.ue5;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, ue5.b, 1401})
public class UGFrameLayout extends FrameLayout {
    public uj c;
    public Map<Integer, m> tt;

    public UGFrameLayout(Context context) {
        super(context);
    }

    public void c(uj ujVar) {
        this.c = ujVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, m> map = this.tt;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.uj();
        }
        super.onLayout(z, i, i2, i3, i4);
        uj ujVar2 = this.c;
        if (ujVar2 != null) {
            ujVar2.c(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.c;
        if (ujVar != null) {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        } else {
            super.onMeasure(i, i2);
        }
        uj ujVar2 = this.c;
        if (ujVar2 != null) {
            ujVar2.ve();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    public void setEventMap(Map<Integer, m> map) {
        this.tt = map;
    }
}
