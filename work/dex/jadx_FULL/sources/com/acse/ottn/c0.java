package com.acse.ottn;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c0 extends View implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v1 f22906a;
    public Paint b;
    public float c;

    public c0(Context context) {
        this(context, null);
    }

    @Override // com.acse.ottn.u1
    public void a(int i, int i2) {
        this.f22906a.d(i);
        this.f22906a.a(i2);
        requestLayout();
    }

    @Override // com.acse.ottn.u1
    public v1 getIndicatorConfig() {
        return this.f22906a;
    }

    @Override // com.acse.ottn.u1
    @NonNull
    public View getIndicatorView() {
        if (this.f22906a.l()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int iB = this.f22906a.b();
            if (iB == 0) {
                layoutParams.gravity = 8388691;
            } else if (iB == 1) {
                layoutParams.gravity = 81;
            } else if (iB == 2) {
                layoutParams.gravity = 8388693;
            }
            layoutParams.leftMargin = this.f22906a.f().f23275a;
            layoutParams.rightMargin = this.f22906a.f().c;
            layoutParams.topMargin = this.f22906a.f().b;
            layoutParams.bottomMargin = this.f22906a.f().d;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.acse.ottn.c3
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.acse.ottn.c3
    public void onPageScrolled(int i, float f, int i2) {
        this.c = f;
        invalidate();
    }

    @Override // com.acse.ottn.c3
    public void onPageSelected(int i) {
        this.f22906a.a(i);
        invalidate();
    }

    public c0(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c0(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22906a = new v1();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(this.f22906a.g());
    }
}
