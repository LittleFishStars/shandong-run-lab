package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.zj.adlib.as8;
import com.zj.adlib.bs8;
import com.zj.adlib.qk8;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class StoreHouseHeader extends InternalAbstract implements RefreshHeader {
    protected static final float mBarDarkAlpha = 0.4f;
    protected static final float mFromAlpha = 1.0f;
    protected static final float mInternalAnimationFactor = 0.7f;
    protected static final int mLoadingAniItemDuration = 400;
    protected static final float mToAlpha = 0.4f;
    protected b mAniController;
    protected int mBackgroundColor;
    protected int mDrawZoneHeight;
    protected int mDrawZoneWidth;
    protected int mDropHeight;
    protected boolean mEnableFadeAnimation;
    protected int mHorizontalRandomness;
    protected boolean mIsInLoading;
    public List<as8> mItemList;
    protected int mLineWidth;
    protected int mLoadingAniDuration;
    protected int mLoadingAniSegDuration;
    protected Matrix mMatrix;
    protected int mOffsetX;
    protected int mOffsetY;
    protected float mProgress;
    protected RefreshKernel mRefreshKernel;
    protected float mScale;
    protected int mTextColor;
    protected Transformation mTransformation;

    public class a extends Animation {
        public a() {
            super.setDuration(250L);
            super.setInterpolator(new AccelerateInterpolator());
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            StoreHouseHeader storeHouseHeader = StoreHouseHeader.this;
            storeHouseHeader.mProgress = 1.0f - f;
            storeHouseHeader.invalidate();
            if (f == 1.0f) {
                for (int i = 0; i < StoreHouseHeader.this.mItemList.size(); i++) {
                    StoreHouseHeader.this.mItemList.get(i).b(StoreHouseHeader.this.mHorizontalRandomness);
                }
            }
        }
    }

    public StoreHouseHeader(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int iSave = canvas.save();
        int size = this.mItemList.size();
        float f = isInEditMode() ? 1.0f : this.mProgress;
        for (int i = 0; i < size; i++) {
            canvas.save();
            as8 as8Var = this.mItemList.get(i);
            float f2 = this.mOffsetX;
            PointF pointF = as8Var.f15390a;
            float f3 = f2 + pointF.x;
            float f4 = this.mOffsetY + pointF.y;
            if (this.mIsInLoading) {
                as8Var.getTransformation(getDrawingTime(), this.mTransformation);
                canvas.translate(f3, f4);
            } else {
                if (f == 0.0f) {
                    as8Var.b(this.mHorizontalRandomness);
                } else {
                    float f5 = (i * 0.3f) / size;
                    float f6 = 0.3f - f5;
                    if (f == 1.0f || f >= 1.0f - f6) {
                        canvas.translate(f3, f4);
                        as8Var.d(0.4f);
                    } else {
                        float fMin = f > f5 ? Math.min(1.0f, (f - f5) / 0.7f) : 0.0f;
                        float f7 = 1.0f - fMin;
                        float f8 = f3 + (as8Var.f40601a * f7);
                        float f9 = f4 + ((-this.mDropHeight) * f7);
                        this.mMatrix.reset();
                        this.mMatrix.postRotate(360.0f * fMin);
                        this.mMatrix.postScale(fMin, fMin);
                        this.mMatrix.postTranslate(f8, f9);
                        as8Var.d(fMin * 0.4f);
                        canvas.concat(this.mMatrix);
                    }
                }
            }
            as8Var.a(canvas);
            canvas.restore();
        }
        if (this.mIsInLoading) {
            invalidate();
        }
        canvas.restoreToCount(iSave);
        super.dispatchDraw(canvas);
    }

    public StoreHouseHeader initWithPointList(List<float[]> list) {
        boolean z = this.mItemList.size() > 0;
        this.mItemList.clear();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            float[] fArr = list.get(i);
            PointF pointF = new PointF(qk8.d(fArr[0]) * this.mScale, qk8.d(fArr[1]) * this.mScale);
            PointF pointF2 = new PointF(qk8.d(fArr[2]) * this.mScale, qk8.d(fArr[3]) * this.mScale);
            fMax = Math.max(Math.max(fMax, pointF.x), pointF2.x);
            fMax2 = Math.max(Math.max(fMax2, pointF.y), pointF2.y);
            as8 as8Var = new as8(i, pointF, pointF2, this.mTextColor, this.mLineWidth);
            as8Var.b(this.mHorizontalRandomness);
            this.mItemList.add(as8Var);
        }
        this.mDrawZoneWidth = (int) Math.ceil(fMax);
        this.mDrawZoneHeight = (int) Math.ceil(fMax2);
        if (z) {
            requestLayout();
        }
        return this;
    }

    public StoreHouseHeader initWithString(String str) {
        initWithString(str, 25);
        return this;
    }

    public StoreHouseHeader initWithStringArray(int i) {
        String[] stringArray = getResources().getStringArray(i);
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            String[] strArrSplit = str.split(",");
            float[] fArr = new float[4];
            for (int i2 = 0; i2 < 4; i2++) {
                fArr[i2] = Float.parseFloat(strArrSplit[i2]);
            }
            arrayList.add(fArr);
        }
        initWithPointList(arrayList);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mIsInLoading = false;
        this.mAniController.d();
        if (z && this.mEnableFadeAnimation) {
            startAnimation(new a());
            return 250;
        }
        for (int i = 0; i < this.mItemList.size(); i++) {
            this.mItemList.get(i).b(this.mHorizontalRandomness);
        }
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        refreshKernel.f(this, this.mBackgroundColor);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(super.getSuggestedMinimumHeight(), i2));
        this.mOffsetX = (getMeasuredWidth() - this.mDrawZoneWidth) / 2;
        this.mOffsetY = (getMeasuredHeight() - this.mDrawZoneHeight) / 2;
        this.mDropHeight = getMeasuredHeight() / 2;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        this.mProgress = f * 0.8f;
        invalidate();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mIsInLoading = true;
        this.mAniController.c();
        invalidate();
    }

    public StoreHouseHeader setDropHeight(int i) {
        this.mDropHeight = i;
        return this;
    }

    public StoreHouseHeader setLineWidth(int i) {
        this.mLineWidth = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).i(i);
        }
        return this;
    }

    public StoreHouseHeader setLoadingAniDuration(int i) {
        this.mLoadingAniDuration = i;
        this.mLoadingAniSegDuration = i;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            int i = iArr[0];
            this.mBackgroundColor = i;
            RefreshKernel refreshKernel = this.mRefreshKernel;
            if (refreshKernel != null) {
                refreshKernel.f(this, i);
            }
            if (iArr.length > 1) {
                setTextColor(iArr[1]);
            }
        }
    }

    public StoreHouseHeader setScale(float f) {
        this.mScale = f;
        return this;
    }

    public StoreHouseHeader setTextColor(@ColorInt int i) {
        this.mTextColor = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).h(i);
        }
        return this;
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoreHouseHeader initWithString(String str, int i) {
        initWithPointList(bs8.a(str, i * 0.01f, 14));
        return this;
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItemList = new ArrayList();
        this.mScale = 1.0f;
        this.mLineWidth = -1;
        this.mDropHeight = -1;
        this.mHorizontalRandomness = -1;
        this.mProgress = 0.0f;
        this.mDrawZoneWidth = 0;
        this.mDrawZoneHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mLoadingAniDuration = 1000;
        this.mLoadingAniSegDuration = 1000;
        this.mTextColor = -1;
        this.mBackgroundColor = 0;
        this.mIsInLoading = false;
        this.mEnableFadeAnimation = false;
        this.mMatrix = new Matrix();
        this.mAniController = new b(this, null);
        this.mTransformation = new Transformation();
        this.mLineWidth = qk8.d(1.0f);
        this.mDropHeight = qk8.d(40.0f);
        this.mHorizontalRandomness = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        this.mBackgroundColor = -13421773;
        setTextColor(-3355444);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StoreHouseHeader);
        this.mLineWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhLineWidth, this.mLineWidth);
        this.mDropHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhDropHeight, this.mDropHeight);
        this.mEnableFadeAnimation = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StoreHouseHeader_shhEnableFadeAnimation, this.mEnableFadeAnimation);
        int i2 = R.styleable.StoreHouseHeader_shhText;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            initWithString(typedArrayObtainStyledAttributes.getString(i2));
        } else {
            initWithString("StoreHouse");
        }
        typedArrayObtainStyledAttributes.recycle();
        setMinimumHeight(this.mDrawZoneHeight + qk8.d(40.0f));
    }

    public class b implements Runnable {
        public int K;
        public int L;
        public int M;
        public int N;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f15079a;

        public b() {
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.f15079a = true;
        }

        public final void c() {
            this.f15079a = true;
            this.K = 0;
            StoreHouseHeader storeHouseHeader = StoreHouseHeader.this;
            int size = storeHouseHeader.mLoadingAniDuration / storeHouseHeader.mItemList.size();
            this.N = size;
            StoreHouseHeader storeHouseHeader2 = StoreHouseHeader.this;
            this.L = storeHouseHeader2.mLoadingAniSegDuration / size;
            this.M = (storeHouseHeader2.mItemList.size() / this.L) + 1;
            run();
        }

        public final void d() {
            this.f15079a = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            RefreshKernel refreshKernel;
            int i = this.K % this.L;
            for (int i2 = 0; i2 < this.M; i2++) {
                int i3 = (this.L * i2) + i;
                if (i3 <= this.K) {
                    as8 as8Var = StoreHouseHeader.this.mItemList.get(i3 % StoreHouseHeader.this.mItemList.size());
                    as8Var.setFillAfter(false);
                    as8Var.setFillEnabled(true);
                    as8Var.setFillBefore(false);
                    as8Var.setDuration(400L);
                    as8Var.k(1.0f, 0.4f);
                }
            }
            this.K++;
            if (!this.f15079a || (refreshKernel = StoreHouseHeader.this.mRefreshKernel) == null) {
                return;
            }
            refreshKernel.k().getLayout().postDelayed(this, this.N);
        }

        public /* synthetic */ b(StoreHouseHeader storeHouseHeader, a aVar) {
            this();
        }
    }
}
