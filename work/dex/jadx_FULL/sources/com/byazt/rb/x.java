package com.byazt.rb;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 23, 71})
public class x implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28995a;
    public View c;
    public float n;
    public float tt;
    public float uj;
    public float ve;

    public x(View view) {
        this.c = view;
    }

    public void c(float f) {
        View view = this.c;
        if (view == null) {
            return;
        }
        this.tt = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    @Override // com.byazt.rb.sp
    public float getRipple() {
        return this.ve;
    }

    @Override // com.byazt.rb.sp
    public float getRubIn() {
        return this.f28995a;
    }

    @Override // com.byazt.rb.sp
    public float getShine() {
        return this.uj;
    }

    @Override // com.byazt.rb.sp
    public float getStretch() {
        return this.n;
    }

    public void n(float f) {
        this.f28995a = f;
        this.c.postInvalidate();
    }

    public void tt(float f) {
        View view = this.c;
        if (view == null) {
            return;
        }
        this.ve = f;
        view.postInvalidate();
    }

    public void uj(float f) {
        this.n = f;
        this.c.postInvalidate();
    }

    public void ve(float f) {
        View view = this.c;
        if (view == null) {
            return;
        }
        this.uj = f;
        view.postInvalidate();
    }

    public float c() {
        return this.tt;
    }

    public void c(int i) {
        View view = this.c;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
