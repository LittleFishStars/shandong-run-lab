package com.acse.ottn;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c4 extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22908a;
    public int b;
    public int c;
    public a d;
    public boolean e;

    public interface a {
        void a(int i);
    }

    public c4(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (getScrollY() > 300) {
            this.e = true;
        } else {
            this.e = false;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f22908a = (int) motionEvent.getRawX();
            this.b = (int) motionEvent.getRawY();
        } else if (action == 2) {
            return Math.abs(((int) motionEvent.getRawY()) - this.b) < 10;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnScrollListener(a aVar) {
        this.d = aVar;
    }

    public c4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @TargetApi(21)
    public c4(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = false;
        this.c = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
