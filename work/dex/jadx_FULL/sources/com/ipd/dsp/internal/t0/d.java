package com.ipd.dsp.internal.t0;

import android.view.View;
import android.view.ViewGroup;
import com.ipd.dsp.internal.t0.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d<TARGET extends View & e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TARGET f38537a;
    public a b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public int g;
    public int h;

    public d(TARGET target) {
        this.f38537a = target;
    }

    public final int a(int i, int i2) {
        return i;
    }

    public final a a(ViewGroup.LayoutParams layoutParams) {
        a aVar = this.b;
        if (aVar != null && aVar != a.DATUM_AUTO) {
            return aVar;
        }
        int i = layoutParams.width;
        if (i > 0 || i == -1) {
            return a.DATUM_WIDTH;
        }
        int i2 = layoutParams.height;
        if (i2 > 0 || i2 == -1) {
            return a.DATUM_HEIGHT;
        }
        return null;
    }

    public void b(int i, int i2) {
        this.g = i;
        this.h = i2;
        a aVarA = a(this.f38537a.getLayoutParams());
        int paddingLeft = this.f38537a.getPaddingLeft() + this.f38537a.getPaddingRight();
        int paddingTop = this.f38537a.getPaddingTop() + this.f38537a.getPaddingBottom();
        if (aVarA == a.DATUM_WIDTH) {
            int size = View.MeasureSpec.getSize(i);
            if (this.f) {
                this.h = View.MeasureSpec.makeMeasureSpec(a((size - paddingLeft) + paddingTop, i2), 1073741824);
                return;
            }
            float f = this.e;
            if (f > 0.0f) {
                this.h = View.MeasureSpec.makeMeasureSpec(a(Math.round(((size - paddingLeft) / f) + paddingTop), i2), 1073741824);
                return;
            }
            float f2 = this.c;
            if (f2 > 0.0f) {
                float f3 = this.d;
                if (f3 > 0.0f) {
                    this.h = View.MeasureSpec.makeMeasureSpec(a(Math.round((((size - paddingLeft) / f2) * f3) + paddingTop), i2), 1073741824);
                    return;
                }
                return;
            }
            return;
        }
        if (aVarA == a.DATUM_HEIGHT) {
            int size2 = View.MeasureSpec.getSize(i2);
            if (this.f) {
                this.g = View.MeasureSpec.makeMeasureSpec(a((size2 - paddingTop) + paddingLeft, i), 1073741824);
                return;
            }
            float f4 = this.e;
            if (f4 > 0.0f) {
                this.g = View.MeasureSpec.makeMeasureSpec(a(Math.round(((size2 - paddingTop) / f4) + paddingLeft), i), 1073741824);
                return;
            }
            float f5 = this.c;
            if (f5 > 0.0f) {
                float f6 = this.d;
                if (f6 > 0.0f) {
                    this.g = View.MeasureSpec.makeMeasureSpec(a(Math.round((((size2 - paddingTop) / f6) * f5) + paddingLeft), i), 1073741824);
                }
            }
        }
    }

    public final void c() {
        this.f38537a.requestLayout();
    }

    public int a() {
        return this.h;
    }

    public void a(a aVar, float f, float f2) {
        this.b = aVar;
        this.c = f;
        this.d = f2;
        c();
    }

    public void a(boolean z) {
        this.f = z;
        c();
    }

    public void a(float f) {
        this.e = f;
        c();
    }

    public int b() {
        return this.g;
    }
}
