package cj.mobile.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f22667a;
    public Paint b;
    public RectF c;
    public int[] d;
    public int e;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircularProgressView f22668a;

        public a(CircularProgressView circularProgressView) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    public CircularProgressView(Context context) {
        this(context, null);
    }

    public int getProgress() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
    }

    public void setBackColor(@ColorRes int i) {
    }

    public void setBackWidth(int i) {
    }

    public void setProgColor(@ColorRes int i) {
    }

    public void setProgWidth(int i) {
    }

    public void setProgress(int i) {
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
    }

    public void setProgress(int i, long j) {
    }

    public void setProgColor(@ColorRes int i, @ColorRes int i2) {
    }

    public void setProgColor(@ColorRes int[] iArr) {
    }
}
