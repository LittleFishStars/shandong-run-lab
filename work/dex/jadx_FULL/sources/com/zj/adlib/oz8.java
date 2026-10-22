package com.zj.adlib;

import android.util.Log;
import android.widget.TextView;
import com.flyco.tablayout.SlidingTabLayoutBase;
import com.flyco.tablayout.transition.ITabScaleTransformer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class oz8 implements ITabScaleTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f43862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SlidingTabLayoutBase f18745a;
    public float b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f43863a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TextView f18746a;

        public a(float f, TextView textView) {
            this.f43863a = f;
            this.f18746a = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fAbs = (int) (oz8.this.f43862a - Math.abs((oz8.this.f43862a - oz8.this.b) * this.f43863a));
            if (this.f18746a.getTextSize() != fAbs) {
                this.f18746a.setTextSize(0, fAbs);
                this.f18746a.requestLayout();
            }
        }
    }

    public oz8(SlidingTabLayoutBase slidingTabLayoutBase, float f, float f2) {
        this.f18745a = slidingTabLayoutBase;
        this.f43862a = f;
        this.b = f2;
    }

    public final void c(int i, float f) {
        d(i, f);
        int i2 = i + 1;
        if (i2 < this.f18745a.getTabCount()) {
            d(i2, 1.0f - f);
        }
    }

    public final void d(int i, float f) {
        TextView tabTitleView = this.f18745a.getTabTitleView(i);
        tabTitleView.post(new a(f, tabTitleView));
    }

    @Override // com.flyco.tablayout.transition.ITabScaleTransformer
    public void onPageScrolled(int i, float f, int i2) {
        Log.i("TabScaleTransformer", "position:" + i);
        if (this.f43862a == this.b) {
            return;
        }
        for (int i3 = 0; i3 < this.f18745a.getTabCount(); i3++) {
            if (i3 != i && i3 != i + 1) {
                d(i3, 1.0f);
            }
        }
        c(i, f);
    }
}
