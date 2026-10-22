package com.acse.ottn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ContinueSlideScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23287a;
    public boolean b;
    public Context c;
    public a d;
    public float e;
    public float f;
    public boolean g;
    public int h;
    public b i;

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a();

        void b();
    }

    public ContinueSlideScrollView(Context context) {
        super(context);
        this.f23287a = true;
        this.b = false;
        this.g = false;
        this.h = 160;
        this.c = context;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.f23287a;
    }

    public final void c() {
        a aVar;
        if (this.f23287a) {
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.b();
                return;
            }
            return;
        }
        if (!this.b || (aVar = this.d) == null) {
            return;
        }
        aVar.a();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.f23287a = z2;
            this.b = false;
        } else {
            this.f23287a = false;
            this.b = z2;
        }
        c();
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getY();
            this.g = true;
        } else if (action == 1) {
            this.g = true;
            this.f = 0.0f;
            this.e = 0.0f;
        } else if (action == 2) {
            this.f = motionEvent.getY();
            if (this.g && b() && this.f - this.e > a(this.c, this.h)) {
                this.g = false;
                Log.i("ccb", "onTouchEvent: 回到顶部，继续滑动" + (this.f - this.e));
                b bVar = this.i;
                if (bVar != null) {
                    bVar.a();
                }
            }
            if (this.g && a() && this.f - this.e < (-a(this.c, this.h))) {
                this.g = false;
                Log.i("ccb", "onTouchEvent: 已经到底，继续滑动" + (this.f - this.e));
                b bVar2 = this.i;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScanScrollChangedListener(a aVar) {
        this.d = aVar;
    }

    public void setonContinueSlideListener(b bVar) {
        this.i = bVar;
    }

    public static int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23287a = true;
        this.b = false;
        this.g = false;
        this.h = 160;
        this.c = context;
    }

    public ContinueSlideScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23287a = true;
        this.b = false;
        this.g = false;
        this.h = 160;
        this.c = context;
    }
}
