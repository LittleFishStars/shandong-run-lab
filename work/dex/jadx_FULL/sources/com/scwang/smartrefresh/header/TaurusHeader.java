package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.zj.adlib.fn6;
import com.zj.adlib.qk8;
import com.zj.adlib.xm8;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class TaurusHeader extends InternalAbstract implements RefreshHeader {
    protected static final int ANIMATION_DURATION = 1000;
    protected static final float CENTER_CLOUDS_FINAL_SCALE = 1.0f;
    protected static final float CENTER_CLOUDS_INITIAL_SCALE = 0.8f;
    protected static final int LOADING_ANIMATION_COEFFICIENT = 80;
    protected static final int MAX_WIND_LINE_WIDTH = 300;
    protected static final int MAX_WIND_X_OFFSET = 2000;
    protected static final int MIN_WIND_LINE_WIDTH = 50;
    protected static final int MIN_WIND_X_OFFSET = 1000;
    protected static final int RANDOM_Y_COEFFICIENT = 5;
    protected static final float SCALE_START_PERCENT = 0.5f;
    protected static final float SIDE_CLOUDS_FINAL_SCALE = 1.0f;
    protected static final float SIDE_CLOUDS_INITIAL_SCALE = 0.6f;
    protected static final int SLOW_DOWN_ANIMATION_COEFFICIENT = 6;
    protected static final int WIND_SET_AMOUNT = 10;
    protected static final int X_SIDE_CLOUDS_SLOW_DOWN_COF = 2;
    protected static final int Y_SIDE_CLOUDS_SLOW_DOWN_COF = 4;
    protected boolean isRefreshing;
    protected Drawable mAirplane;
    protected Animation mAnimation;
    protected Drawable mCloudCenter;
    protected float mFinishTransformation;
    protected int mHeaderHeight;
    protected boolean mInverseDirection;
    protected float mLastAnimationTime;
    protected float mLoadingAnimationTime;
    protected Matrix mMatrix;
    protected boolean mNewWindSet;
    protected float mPercent;
    protected Random mRandom;
    protected float mWindLineWidth;
    protected Paint mWindPaint;
    protected Map<Float, Float> mWinds;
    protected static String[] airplanePaths = {"m23.01,81.48c-0.21,-0.3 -0.38,-0.83 -0.38,-1.19 0,-0.55 0.24,-0.78 1.5,-1.48 1.78,-0.97 2.62,-1.94 2.24,-2.57 -0.57,-0.93 -1.97,-1.24 -11.64,-2.59 -5.35,-0.74 -10.21,-1.44 -10.82,-1.54l-1.09,-0.18 1.19,-0.91c0.99,-0.76 1.38,-0.91 2.35,-0.91 0.64,0 6.39,0.33 12.79,0.74 6.39,0.41 12.09,0.71 12.65,0.67l1.03,-0.07 -1.24,-2.19C30.18,66.77 15.91,42 15.13,40.68l-0.51,-0.87 4.19,-1.26c2.3,-0.69 4.27,-1.26 4.37,-1.26 0.1,0 5.95,3.85 13,8.55 14.69,9.81 17.1,11.31 19.7,12.31 4.63,1.78 6.45,1.69 12.94,-0.64 13.18,-4.73 25.22,-9.13 25.75,-9.4 0.69,-0.36 3.6,1.33 -24.38,-14.22L50.73,23.07 46.74,16.42 42.75,9.77 43.63,8.89c0.83,-0.83 0.91,-0.86 1.46,-0.52 0.32,0.2 3.72,3.09 7.55,6.44 3.83,3.34 7.21,6.16 7.5,6.27 0.29,0.11 13.6,2.82 29.58,6.03 15.98,3.21 31.86,6.4 35.3,7.1l6.26,1.26 3.22,-1.13c41.63,-14.63 67.88,-23.23 85.38,-28 14.83,-4.04 23.75,-4.75 32.07,-2.57 7.04,1.84 9.87,4.88 7.71,8.27 -1.6,2.5 -4.6,4.63 -10.61,7.54 -5.94,2.88 -10.22,4.46 -25.4,9.41 -8.15,2.66 -16.66,5.72 -39.01,14.02 -66.79,24.82 -88.49,31.25 -121.66,36.07 -14.56,2.11 -24.17,2.95 -34.08,2.95 -5.43,0 -5.52,-0.01 -5.89,-0.54z"};
    protected static int[] airplaneColors = {-1};
    protected static String[] cloudPaths = {"M551.81,1.01A65.42,65.42 0,0 0,504.38 21.5A50.65,50.65 0,0 0,492.4 20A50.65,50.65 0,0 0,441.75 70.65A50.65,50.65 0,0 0,492.4 121.3A50.65,50.65 0,0 0,511.22 117.64A65.42,65.42 0,0 0,517.45 122L586.25,122A65.42,65.42 0,0 0,599.79 110.78A59.79,59.79 0,0 0,607.81 122L696.34,122A59.79,59.79 0,0 0,711.87 81.9A59.79,59.79 0,0 0,652.07 22.11A59.79,59.79 0,0 0,610.93 38.57A65.42,65.42 0,0 0,551.81 1.01zM246.2,1.71A54.87,54.87 0,0 0,195.14 36.64A46.78,46.78 0,0 0,167.77 27.74A46.78,46.78 0,0 0,120.99 74.52A46.78,46.78 0,0 0,167.77 121.3A46.78,46.78 0,0 0,208.92 96.74A54.87,54.87 0,0 0,246.2 111.45A54.87,54.87 0,0 0,268.71 106.54A39.04,39.04 0,0 0,281.09 122L327.6,122A39.04,39.04 0,0 0,343.38 90.7A39.04,39.04 0,0 0,304.34 51.66A39.04,39.04 0,0 0,300.82 51.85A54.87,54.87 0,0 0,246.2 1.71z", "m506.71,31.37a53.11,53.11 0,0 0,-53.11 53.11,53.11 53.11,0 0,0 15.55,37.5h75.12a53.11,53.11 0,0 0,1.88 -2.01,28.49 28.49,0 0,0 0.81,2.01h212.96a96.72,96.72 0,0 0,-87.09 -54.85,96.72 96.72,0 0,0 -73.14,33.52 28.49,28.49 0,0 0,-26.74 -18.74,28.49 28.49,0 0,0 -13.16,3.23 53.11,53.11 0,0 0,0.03 -0.66,53.11 53.11,0 0,0 -53.11,-53.11zM206.23,31.81a53.81,53.81 0,0 0,-49.99 34.03,74.91 74.91,0 0,0 -47.45,-17 74.91,74.91 0,0 0,-73.54 60.82,31.3 31.3,0 0,0 -10.17,-1.73 31.3,31.3 0,0 0,-26.09 14.05L300.86,121.98a37.63,37.63 0,0 0,0.2 -3.85,37.63 37.63,0 0,0 -37.63,-37.63 37.63,37.63 0,0 0,-3.65 0.21,53.81 53.81,0 0,0 -53.54,-48.9z", "m424.05,36.88a53.46,53.46 0,0 0,-40.89 19.02,53.46 53.46,0 0,0 -1.34,1.76 62.6,62.6 0,0 0,-5.39 -0.27,62.6 62.6,0 0,0 -61.36,50.17 62.6,62.6 0,0 0,-0.53 3.51,15.83 15.83,0 0,0 -10.33,-3.84 15.83,15.83 0,0 0,-8.06 2.23,21.1 21.1,0 0,0 -18.31,-10.67 21.1,21.1 0,0 0,-19.47 12.97,21.81 21.81,0 0,0 -6.56,-1.01 21.81,21.81 0,0 0,-19.09 11.32L522.84,122.07a43.61,43.61 0,0 0,-43.11 -37.35,43.61 43.61,0 0,0 -2.57,0.09 53.46,53.46 0,0 0,-53.11 -47.93zM129.08,38.4a50.29,50.29 0,0 0,-50.29 50.29,50.29 50.29,0 0,0 2.37,15.06 15.48,15.83 0,0 0,-5.87 1.68,15.48 15.83,0 0,0 -0.98,0.58 16.53,16.18 0,0 0,-0.19 -0.21,16.53 16.18,0 0,0 -11.86,-4.91 16.53,16.18 0,0 0,-16.38 14.13,20.05 16.18,0 0,0 -14.97,7.04L223.95,122.07a42.56,42.56 0,0 0,1.14 -9.56,42.56 42.56,0 0,0 -42.56,-42.56 42.56,42.56 0,0 0,-6.58 0.54,50.29 50.29,0 0,0 -0,-0.01 50.29,50.29 0,0 0,-46.88 -32.07zM631.67,82.61a64.01,64.01 0,0 0,-44.9 18.42,26.73 26.73,0 0,0 -10.67,-2.24 26.73,26.73 0,0 0,-22.72 12.71,16.88 16.88,0 0,0 -0.25,-0.12 16.88,16.88 0,0 0,-6.57 -1.33,16.88 16.88,0 0,0 -16.15,12.03h160.36a64.01,64.01 0,0 0,-59.1 -39.46z"};
    protected static int[] cloudColors = {-1429742351, -571935747, -131587};
    protected static final Interpolator ACCELERATE_DECELERATE_INTERPOLATOR = new AccelerateDecelerateInterpolator();

    public enum AnimationPart {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public class a extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40374a;

        public a(View view) {
            this.f40374a = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, @NonNull Transformation transformation) {
            TaurusHeader.this.mLoadingAnimationTime = (f / 6.0f) * 80.0f;
            this.f40374a.invalidate();
        }
    }

    public class b extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40375a;

        public b(View view) {
            this.f40375a = view;
            super.setDuration(100L);
            super.setInterpolator(new AccelerateInterpolator());
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            if (f == 1.0f) {
                TaurusHeader.this.isRefreshing = false;
            }
            TaurusHeader.this.mFinishTransformation = f;
            this.f40375a.invalidate();
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40376a;

        static {
            int[] iArr = new int[AnimationPart.values().length];
            f40376a = iArr;
            try {
                iArr[AnimationPart.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40376a[AnimationPart.SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40376a[AnimationPart.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40376a[AnimationPart.FOURTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public TaurusHeader(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        int width = getWidth();
        int height = getHeight();
        if (this.isRefreshing) {
            while (this.mWinds.size() < 10) {
                float fRandom = (float) (((double) this.mHeaderHeight) / (Math.random() * 5.0d));
                float fP = p(1000, 2000);
                if (this.mWinds.size() > 1) {
                    while (true) {
                        f = 0.0f;
                        while (true) {
                            if (f != 0.0f) {
                                break;
                            }
                            float fRandom2 = (float) (((double) this.mHeaderHeight) / (Math.random() * 5.0d));
                            Iterator<Map.Entry<Float, Float>> it = this.mWinds.entrySet().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (Math.abs(it.next().getKey().floatValue() - fRandom2) > this.mHeaderHeight / 5) {
                                        f = fRandom2;
                                    }
                                }
                            }
                        }
                    }
                    fRandom = f;
                }
                this.mWinds.put(Float.valueOf(fRandom), Float.valueOf(fP));
                m(canvas, fRandom, fP, width);
            }
            if (this.mWinds.size() >= 10) {
                for (Map.Entry<Float, Float> entry : this.mWinds.entrySet()) {
                    m(canvas, entry.getKey().floatValue(), entry.getValue().floatValue(), width);
                }
            }
            if (this.mInverseDirection && this.mNewWindSet) {
                this.mWinds.clear();
                this.mNewWindSet = false;
                this.mWindLineWidth = p(50, 300);
            }
            this.mLastAnimationTime = this.mLoadingAnimationTime;
        }
        j(canvas, width, height);
        l(canvas, width, height);
        k(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    public final boolean i(AnimationPart animationPart) {
        int i = c.f40376a[animationPart.ordinal()];
        if (i == 1) {
            return this.mLoadingAnimationTime < ((float) o(AnimationPart.FOURTH));
        }
        if (i == 2 || i == 3) {
            return this.mLoadingAnimationTime < ((float) o(animationPart));
        }
        return i == 4 && this.mLoadingAnimationTime > ((float) o(AnimationPart.THIRD));
    }

    public final void j(Canvas canvas, int i, int i2) {
        float fPow;
        float fN;
        float fN2;
        Matrix matrix = this.mMatrix;
        matrix.reset();
        float f = this.mPercent;
        if (isInEditMode()) {
            this.mHeaderHeight = i2;
            f = 1.0f;
        }
        if (f > 1.0f) {
            fPow = ((float) (1.0d - Math.pow(100.0d, (-(f - 1.0f)) / 2.0f))) * 20.0f;
            f = 1.0f;
        } else {
            fPow = 0.0f;
        }
        float fWidth = ((i * f) / 2.0f) - (this.mAirplane.getBounds().width() / 2.0f);
        float fHeight = (this.mHeaderHeight * (1.0f - (f / 2.0f))) - (this.mAirplane.getBounds().height() / 2.0f);
        float f2 = this.mFinishTransformation;
        if (f2 > 0.0f) {
            fHeight += (0.0f - fHeight) * f2;
            fWidth += ((i + this.mAirplane.getBounds().width()) - fWidth) * this.mFinishTransformation;
        }
        if (this.isRefreshing) {
            AnimationPart animationPart = AnimationPart.FIRST;
            if (i(animationPart)) {
                fN2 = n(animationPart);
            } else {
                AnimationPart animationPart2 = AnimationPart.SECOND;
                if (i(animationPart2)) {
                    fN2 = n(animationPart2);
                } else {
                    AnimationPart animationPart3 = AnimationPart.THIRD;
                    if (i(animationPart3)) {
                        fN = n(animationPart3);
                    } else {
                        AnimationPart animationPart4 = AnimationPart.FOURTH;
                        if (i(animationPart4)) {
                            fN = n(animationPart4);
                        }
                    }
                    fHeight += fN;
                }
            }
            fHeight -= fN2;
        }
        if (fPow > 0.0f) {
            matrix.postRotate(fPow, this.mAirplane.getBounds().width() / 2.0f, this.mAirplane.getBounds().height() / 2.0f);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(fWidth, fHeight);
        canvas.concat(matrix);
        this.mAirplane.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public final void k(Canvas canvas, int i, int i2) {
        boolean z;
        float fAbs;
        float f;
        float fN;
        float f2;
        float fN2;
        Matrix matrix = this.mMatrix;
        matrix.reset();
        float fMin = Math.min(1.0f, Math.abs(this.mPercent));
        if (isInEditMode()) {
            this.mHeaderHeight = i2;
            fMin = 1.0f;
        }
        float f3 = this.mPercent;
        boolean z2 = true;
        if (f3 > 1.0f) {
            fAbs = Math.abs(1.0f - f3);
            z = true;
        } else {
            z = false;
            fAbs = 0.0f;
        }
        float f4 = fMin - 0.5f;
        float f5 = f4 > 0.0f ? 0.8f + ((f4 / 0.5f) * 0.19999999f) : 0.8f;
        int i3 = this.mHeaderHeight;
        float f6 = i3 * fMin;
        float fHeight = i3 - (this.mCloudCenter.getBounds().height() / 2);
        if (f6 > fHeight) {
            f = f6 - fHeight;
        } else {
            z2 = false;
            f = 0.0f;
        }
        float fWidth = (i / 2.0f) - (this.mCloudCenter.getBounds().width() / 2.0f);
        float fHeight2 = f6 - (z2 ? (this.mCloudCenter.getBounds().height() / 2.0f) + f : this.mCloudCenter.getBounds().height() / 2.0f);
        float f7 = z ? (fAbs / 4.0f) + f5 : f5;
        float f8 = z ? (fAbs / 2.0f) + f5 : f5;
        if (this.isRefreshing && !z) {
            AnimationPart animationPart = AnimationPart.FIRST;
            if (i(animationPart)) {
                fN2 = n(animationPart);
            } else {
                AnimationPart animationPart2 = AnimationPart.SECOND;
                if (i(animationPart2)) {
                    fN2 = n(animationPart2);
                } else {
                    AnimationPart animationPart3 = AnimationPart.THIRD;
                    if (i(animationPart3)) {
                        fN = n(animationPart3);
                    } else {
                        AnimationPart animationPart4 = AnimationPart.FOURTH;
                        if (i(animationPart4)) {
                            fN = n(animationPart4);
                        }
                    }
                    f2 = f5 + ((fN / 80.0f) / 6.0f);
                    f7 = f2;
                }
                f8 = f7;
            }
            f2 = f5 - ((fN2 / 80.0f) / 8.0f);
            f7 = f2;
            f8 = f7;
        }
        matrix.postScale(f7, f8, this.mCloudCenter.getBounds().width() / 2.0f, 0.0f);
        float f9 = i2 + 2;
        if ((this.mCloudCenter.getBounds().height() * f8) + fHeight2 < f9) {
            fHeight2 = f9 - (f8 * this.mCloudCenter.getBounds().height());
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(fWidth, fHeight2);
        canvas.concat(matrix);
        this.mCloudCenter.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public final void l(Canvas canvas, int i, int i2) {
        float fN;
        float fN2;
        Matrix matrix = this.mMatrix;
        matrix.reset();
        Drawable drawable = this.mCloudCenter;
        float fMin = Math.min(1.0f, Math.abs(this.mPercent));
        if (isInEditMode()) {
            this.mHeaderHeight = i2;
            fMin = 1.0f;
        }
        float f = fMin - 0.5f;
        float f2 = SIDE_CLOUDS_INITIAL_SCALE;
        if (f > 0.0f) {
            f2 = SIDE_CLOUDS_INITIAL_SCALE + ((f / 0.5f) * 0.39999998f);
        }
        float fHeight = this.mHeaderHeight * (1.0f - fMin);
        float fWidth = 0.0f - (drawable.getBounds().width() / 2.0f);
        float fWidth2 = i - (drawable.getBounds().width() / 2.0f);
        if (this.isRefreshing) {
            AnimationPart animationPart = AnimationPart.FIRST;
            if (i(animationPart)) {
                fWidth -= (n(animationPart) * 2.0f) / 4.0f;
                fN2 = n(animationPart);
            } else {
                AnimationPart animationPart2 = AnimationPart.SECOND;
                if (i(animationPart2)) {
                    fWidth -= (n(animationPart2) * 2.0f) / 4.0f;
                    fN2 = n(animationPart2);
                } else {
                    AnimationPart animationPart3 = AnimationPart.THIRD;
                    if (i(animationPart3)) {
                        fWidth -= n(animationPart3) / 4.0f;
                        fN2 = n(animationPart3) * 2.0f;
                    } else {
                        AnimationPart animationPart4 = AnimationPart.FOURTH;
                        if (i(animationPart4)) {
                            fWidth -= n(animationPart4) / 2.0f;
                            fN = (n(animationPart4) * 2.0f) / 4.0f;
                            fWidth2 += fN;
                        }
                    }
                }
            }
            fN = fN2 / 2.0f;
            fWidth2 += fN;
        }
        float f3 = i2 + 2;
        float fHeight2 = (((float) drawable.getBounds().height()) * f2) + fHeight < f3 ? f3 - (drawable.getBounds().height() * f2) : fHeight;
        if ((drawable.getBounds().height() * f2) + fHeight < f3) {
            fHeight = f3 - (drawable.getBounds().height() * f2);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(fWidth, fHeight2);
        matrix.postScale(f2, f2, (drawable.getBounds().width() * 3) / 4.0f, drawable.getBounds().height());
        canvas.concat(matrix);
        drawable.setAlpha(100);
        drawable.draw(canvas);
        drawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
        canvas.save();
        canvas.translate(fWidth2, fHeight);
        matrix.postScale(f2, f2, 0.0f, drawable.getBounds().height());
        canvas.concat(matrix);
        drawable.setAlpha(100);
        drawable.draw(canvas);
        drawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
    }

    public final void m(Canvas canvas, float f, float f2, int i) {
        float f3 = i;
        float f4 = (f3 + f2) / 13.333333f;
        float f5 = this.mLoadingAnimationTime;
        if (this.mLastAnimationTime - f5 > 0.0f) {
            this.mInverseDirection = true;
            f5 = 13.333333f - f5;
        } else {
            this.mNewWindSet = true;
            this.mInverseDirection = false;
        }
        float f6 = (f3 - (f5 * f4)) + f2;
        float f7 = this.mWindLineWidth;
        float f8 = f6 - f7;
        canvas.drawLine(f8, f, f8 + f7, f, this.mWindPaint);
    }

    public final float n(AnimationPart animationPart) {
        float fO;
        float fO2;
        int i = c.f40376a[animationPart.ordinal()];
        if (i == 1) {
            return this.mLoadingAnimationTime;
        }
        if (i == 2) {
            AnimationPart animationPart2 = AnimationPart.FOURTH;
            return o(animationPart2) - (this.mLoadingAnimationTime - o(animationPart2));
        }
        if (i == 3) {
            fO = this.mLoadingAnimationTime;
            fO2 = o(AnimationPart.SECOND);
        } else {
            if (i != 4) {
                return 0.0f;
            }
            fO = o(AnimationPart.THIRD);
            fO2 = this.mLoadingAnimationTime - o(AnimationPart.FOURTH);
        }
        return fO - fO2;
    }

    public final int o(AnimationPart animationPart) {
        int i = c.f40376a[animationPart.ordinal()];
        if (i == 2) {
            return 40;
        }
        if (i != 3) {
            return i != 4 ? 0 : 20;
        }
        return o(AnimationPart.FOURTH) * 3;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        clearAnimation();
        if (z) {
            startAnimation(new b(this));
            return 200;
        }
        this.isRefreshing = false;
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        this.mPercent = f;
        this.mHeaderHeight = i2;
        if (z) {
            this.mFinishTransformation = 0.0f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.isRefreshing = true;
        this.mFinishTransformation = 0.0f;
        startAnimation(this.mAnimation);
    }

    public final float p(int i, int i2) {
        return this.mRandom.nextInt((i2 - i) + 1) + i;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        setBackgroundColor(iArr[0]);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isRefreshing = false;
        setMinimumHeight(qk8.d(100.0f));
        this.mMatrix = new Matrix();
        this.mWinds = new HashMap();
        this.mRandom = new Random();
        Paint paint = new Paint();
        this.mWindPaint = paint;
        paint.setColor(-1);
        this.mWindPaint.setStrokeWidth(qk8.d(3.0f));
        this.mWindPaint.setAlpha(50);
        this.mSpinnerStyle = xm8.b;
        a aVar = new a(this);
        this.mAnimation = aVar;
        aVar.setRepeatCount(-1);
        this.mAnimation.setRepeatMode(2);
        this.mAnimation.setInterpolator(ACCELERATE_DECELERATE_INTERPOLATOR);
        this.mAnimation.setDuration(1000L);
        fn6 fn6Var = new fn6();
        if (!fn6Var.f(airplanePaths)) {
            fn6Var.c(3, 3, 257, 79);
        }
        fn6Var.e(airplaneColors);
        fn6 fn6Var2 = new fn6();
        if (!fn6Var2.f(cloudPaths)) {
            fn6Var2.c(-1, 1, 761, 121);
        }
        fn6Var2.e(cloudColors);
        this.mAirplane = fn6Var;
        this.mCloudCenter = fn6Var2;
        fn6Var.setBounds(0, 0, qk8.d(65.0f), qk8.d(20.0f));
        this.mCloudCenter.setBounds(0, 0, qk8.d(260.0f), qk8.d(45.0f));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TaurusHeader);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.TaurusHeader_thPrimaryColor, 0);
        if (color != 0) {
            setBackgroundColor(color);
        } else {
            setBackgroundColor(-15614977);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
