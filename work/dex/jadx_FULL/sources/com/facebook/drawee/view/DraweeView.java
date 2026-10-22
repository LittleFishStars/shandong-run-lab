package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.zj.adlib.h76;
import com.zj.adlib.nr2;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DraweeView<DH extends DraweeHierarchy> extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a.C0635a f1630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nr2<DH> f1631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1632a;

    public DraweeView(Context context) {
        super(context);
        this.f1630a = new a.C0635a();
        this.f29978a = 0.0f;
        this.f1632a = false;
        a(context);
    }

    public final void a(Context context) {
        if (this.f1632a) {
            return;
        }
        this.f1632a = true;
        this.f1631a = nr2.d(null, context);
        ColorStateList imageTintList = getImageTintList();
        if (imageTintList == null) {
            return;
        }
        setColorFilter(imageTintList.getDefaultColor());
    }

    public float getAspectRatio() {
        return this.f29978a;
    }

    @Nullable
    public DraweeController getController() {
        return this.f1631a.f();
    }

    public DH getHierarchy() {
        return (DH) this.f1631a.g();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.f1631a.h();
    }

    public boolean hasController() {
        return this.f1631a.f() != null;
    }

    public boolean hasHierarchy() {
        return this.f1631a.i();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1631a.j();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1631a.k();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f1631a.j();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        a.C0635a c0635a = this.f1630a;
        c0635a.f29980a = i;
        c0635a.b = i2;
        a.b(c0635a, this.f29978a, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        a.C0635a c0635a2 = this.f1630a;
        super.onMeasure(c0635a2.f29980a, c0635a2.b);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f1631a.k();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1631a.l(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAspectRatio(float f) {
        if (f == this.f29978a) {
            return;
        }
        this.f29978a = f;
        requestLayout();
    }

    public void setController(@Nullable DraweeController draweeController) {
        this.f1631a.o(draweeController);
        super.setImageDrawable(this.f1631a.h());
    }

    public void setHierarchy(DH dh) {
        this.f1631a.p(dh);
        super.setImageDrawable(this.f1631a.h());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        a(getContext());
        this.f1631a.o(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        a(getContext());
        this.f1631a.o(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        a(getContext());
        this.f1631a.o(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        a(getContext());
        this.f1631a.o(null);
        super.setImageURI(uri);
    }

    @Override // android.view.View
    public String toString() {
        h76.b bVarF = h76.f(this);
        nr2<DH> nr2Var = this.f1631a;
        return bVarF.f("holder", nr2Var != null ? nr2Var.toString() : "<no holder set>").toString();
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1630a = new a.C0635a();
        this.f29978a = 0.0f;
        this.f1632a = false;
        a(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1630a = new a.C0635a();
        this.f29978a = 0.0f;
        this.f1632a = false;
        a(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1630a = new a.C0635a();
        this.f29978a = 0.0f;
        this.f1632a = false;
        a(context);
    }
}
