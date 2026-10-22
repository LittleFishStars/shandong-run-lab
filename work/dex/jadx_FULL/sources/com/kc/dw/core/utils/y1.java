package com.kc.dw.core.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f39416a = new int[2];
    public int b;
    public int c;

    @Keep
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SoftReference f39417a;
        public final y1 b;

        public a(y1 y1Var, SoftReference softReference) {
            this.b = y1Var;
            this.f39417a = softReference;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                this.b.b = ((View) this.f39417a.get()).getWidth();
                this.b.c = ((View) this.f39417a.get()).getHeight();
                ((View) this.f39417a.get()).getLocationOnScreen(this.b.f39416a);
                ((View) this.f39417a.get()).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public y1(View view) {
        if (view == null) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, new SoftReference(view)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(float f, float f2) {
        try {
            int[] iArr = this.f39416a;
            int i = iArr[0];
            if (f <= i || f >= i + this.b) {
                return false;
            }
            int i2 = iArr[1];
            return f2 > ((float) i2) && f2 < ((float) (i2 + this.c));
        } catch (Exception unused) {
            return false;
        }
    }
}
