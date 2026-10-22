package cj.mobile.jt.core.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class s extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f22603a;
    public int b;
    public Paint c;
    public int d;
    public Paint e;
    public int f;
    public Paint g;
    public int h;
    public float i;
    public String j;
    public int k;
    public int l;
    public long m;
    public long n;
    public o o;
    public boolean p;
    public final int q;
    public final int r;
    public int s;
    public int t;
    public r u;
    public ValueAnimator v;

    public s(Context context, AttributeSet attributeSet) {
    }

    public final void a(AttributeSet attributeSet) {
    }

    public final int b() {
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f() {
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
    }

    public void setBgColor(int i) {
        this.b = i;
    }

    public void setCountdownListener(o oVar) {
        this.o = oVar;
    }

    public void setDuration(long j) {
        this.m = j;
        this.n = j;
    }

    public void setProgressColor(int i) {
        this.d = i;
    }

    public void setProgressLightColor(int i) {
        this.f = i;
    }

    public void setText(String str) {
        this.j = str;
    }

    public void setTextAlign(int i) {
    }

    public void setTextColor(int i) {
        this.h = i;
    }

    public void setTextFormatter(r rVar) {
    }

    public void setTextPaddingHorizontal(int i) {
    }

    public void setTextSize(float f) {
    }

    public void setUseDefaultSize(boolean z) {
    }

    public final void a() {
    }

    public s(Context context, AttributeSet attributeSet, int i) {
    }

    public static int a(Context context, float f) {
    }

    public s(Context context) {
    }
}
