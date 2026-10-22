package com.byazt.nwh;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.aq.sp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 668, 669})
public class AnimationImageView extends ImageView implements tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sp f28853a;
    public c c;
    public float n;
    public float tt;
    public float uj;
    public float ve;

    public AnimationImageView(Context context) {
        super(context);
        this.c = new c();
    }

    public sp getBrickNativeValue() {
        return this.f28853a;
    }

    @Override // com.byazt.nwh.tt
    public float getMarqueeValue() {
        return this.uj;
    }

    @Override // com.byazt.nwh.tt
    public float getRippleValue() {
        return this.tt;
    }

    @Override // com.byazt.nwh.tt
    public float getShineValue() {
        return this.ve;
    }

    public float getStretchValue() {
        return this.n;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        sp spVar;
        super.onDraw(canvas);
        this.c.c(canvas, this, this);
        if (getRippleValue() == 0.0f || (spVar = this.f28853a) == null || spVar.tt() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.c(this, i, i2);
    }

    public void setBrickNativeValue(sp spVar) {
        this.f28853a = spVar;
    }

    public void setMarqueeValue(float f) {
        this.uj = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.tt = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.ve = f;
        postInvalidate();
    }

    public void setStretchValue(float f) {
        this.n = f;
        this.c.c(this, f);
    }
}
