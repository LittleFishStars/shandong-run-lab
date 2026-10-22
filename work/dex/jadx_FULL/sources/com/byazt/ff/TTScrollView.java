package com.byazt.ff;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 142, 2423})
public class TTScrollView extends ScrollView {
    public int c;
    public boolean tt;
    public boolean uj;
    public c ve;

    public interface c {
        void c(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.tt = false;
        this.uj = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.tt) {
            return;
        }
        try {
            this.tt = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            m.uj("TTScrollView", "onLayout error" + th.toString());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.byazt.ff.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.c);
            }
        });
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        boolean z = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.c) {
            if (getScrollY() > this.c / 2) {
                post(new Runnable() { // from class: com.byazt.ff.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.c);
                    }
                });
            } else {
                if (getScrollY() > 0) {
                    post(new Runnable() { // from class: com.byazt.ff.TTScrollView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TTScrollView.this.smoothScrollTo(0, 0);
                        }
                    });
                } else if (getScrollY() != 0) {
                }
                cVar = this.ve;
                if (cVar != null && z != this.uj) {
                    cVar.c(z);
                }
                this.uj = z;
            }
            z = false;
            cVar = this.ve;
            if (cVar != null) {
                cVar.c(z);
            }
            this.uj = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(c cVar) {
        this.ve = cVar;
    }

    public boolean c() {
        return this.uj;
    }
}
