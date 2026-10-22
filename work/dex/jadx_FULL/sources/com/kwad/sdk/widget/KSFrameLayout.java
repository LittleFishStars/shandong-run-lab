package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class KSFrameLayout extends FrameLayout implements com.kwad.sdk.core.view.e, g, k {
    private com.kwad.sdk.core.view.d baK;
    private final al.a baL;
    private i btg;
    private k bth;
    private View bti;
    private final AtomicBoolean cb;
    private float mRatio;
    private j mViewRCHelper;
    private boolean widthBasedRatio;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.cb = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.baL = new al.a();
        this.baK = new com.kwad.sdk.core.view.d();
        this.widthBasedRatio = true;
        init(context, null);
    }

    private View getPvView() {
        View view = this.bti;
        return view == null ? this : view;
    }

    private static float[] getRadius(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    private void zP() {
        try {
            if (this.cb.getAndSet(false)) {
                ae();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void zQ() {
        try {
            if (this.cb.getAndSet(true)) {
                return;
            }
            af();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @CallSuper
    public void H(View view) {
        k kVar = this.bth;
        if (kVar != null) {
            kVar.H(view);
        }
    }

    @CallSuper
    public void ae() {
        this.btg.onAttachedToWindow();
    }

    @CallSuper
    public void af() {
        this.btg.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.baL.H(getWidth(), getHeight());
            this.baL.j(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.baL.k(motionEvent.getX(), motionEvent.getY());
        }
        com.kwad.sdk.core.e.j(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @Override // com.kwad.sdk.widget.g
    @MainThread
    public al.a getTouchCoords() {
        return this.baL;
    }

    public float getVisiblePercent() {
        return this.btg.getVisiblePercent();
    }

    @Override // com.kwad.sdk.core.view.e
    @NonNull
    public com.kwad.sdk.core.view.d getWindowFocusChangeHelper() {
        return this.baK;
    }

    public void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = typedArrayObtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        i iVar = new i(getPvView(), this);
        this.btg = iVar;
        iVar.cG(true);
        j jVar = new j();
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        zP();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zQ();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        zP();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.btg.d(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.btg.XM();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        zQ();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.baK.j(this, z);
    }

    public void setAllCorner(boolean z) {
        this.mViewRCHelper.getCornerConf().setAllCorner(z);
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public void setViewVisibleListener(k kVar) {
        this.bth = kVar;
    }

    public void setVisiblePercent(float f) {
        this.btg.setVisiblePercent(f);
    }

    public void setWidthBasedRatio(boolean z) {
        this.widthBasedRatio = z;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mViewRCHelper.setRadius(getRadius(f, f2, f3, f4));
        postInvalidate();
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cb = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.baL = new al.a();
        this.baK = new com.kwad.sdk.core.view.d();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cb = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.baL = new al.a();
        this.baK = new com.kwad.sdk.core.view.d();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, View view) {
        super(context);
        this.cb = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.baL = new al.a();
        this.baK = new com.kwad.sdk.core.view.d();
        this.widthBasedRatio = true;
        this.bti = view;
        init(context, null);
    }
}
