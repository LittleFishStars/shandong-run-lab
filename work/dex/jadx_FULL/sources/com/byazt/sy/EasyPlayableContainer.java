package com.byazt.sy;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.m;
import com.byazt.ete.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 1633})
public class EasyPlayableContainer extends FrameLayout {
    public final sp c;
    public u n;
    public final m tt;
    public int uj;
    public final ic ve;

    public EasyPlayableContainer(@NonNull Context context, sp spVar, m mVar, ic icVar, u uVar) {
        super(context);
        this.uj = 0;
        this.c = spVar;
        this.tt = mVar;
        this.ve = icVar;
        this.n = uVar;
    }

    public boolean c() {
        return this.uj == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        sp spVar = this.c;
        if (spVar != null) {
            spVar.tt();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sp spVar = this.c;
        if (spVar != null) {
            spVar.ve();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.tt == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        float fUj = pf.uj(getContext(), motionEvent.getX());
        float fUj2 = pf.uj(getContext(), motionEvent.getY());
        if (this.tt.c(fUj, fUj2)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            new com.byazt.kyz.c(this.ve, this.n).c(this.ve, fUj, fUj2, 1);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tt == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.tt.c(pf.uj(getContext(), motionEvent.getX()), pf.uj(getContext(), motionEvent.getY()))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setIfStayTop(int i) {
        this.uj = i;
    }

    public static void c(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EasyPlayableContainer) {
                EasyPlayableContainer easyPlayableContainer = (EasyPlayableContainer) childAt;
                if (easyPlayableContainer.c()) {
                    easyPlayableContainer.bringToFront();
                    z = true;
                }
            }
        }
        if (z) {
            viewGroup.invalidate();
        }
    }
}
