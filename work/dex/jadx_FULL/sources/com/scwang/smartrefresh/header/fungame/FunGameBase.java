package com.scwang.smartrefresh.header.fungame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.zj.adlib.qk8;
import com.zj.adlib.xm8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@SuppressLint({"RestrictedApi"})
public abstract class FunGameBase extends InternalAbstract implements RefreshHeader {
    protected int mHeaderHeight;
    protected boolean mIsFinish;
    protected boolean mLastFinish;
    protected boolean mManualOperation;
    protected int mOffset;
    protected RefreshContent mRefreshContent;
    protected RefreshKernel mRefreshKernel;
    protected int mScreenHeightPixels;
    protected RefreshState mState;
    protected float mTouchY;

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMinimumHeight(qk8.d(100.0f));
        this.mScreenHeightPixels = getResources().getDisplayMetrics().heightPixels;
        this.mSpinnerStyle = xm8.e;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mLastFinish = z;
        if (!this.mIsFinish) {
            this.mIsFinish = true;
            if (this.mManualOperation) {
                if (this.mTouchY != -1.0f) {
                    return Integer.MAX_VALUE;
                }
                onManualOperationRelease();
                onFinish(refreshLayout, z);
                return 0;
            }
        }
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        this.mHeaderHeight = i;
        if (isInEditMode()) {
            return;
        }
        setTranslationY(this.mOffset - this.mHeaderHeight);
        refreshKernel.h(this, true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mState == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    public abstract void onManualOperationMove(float f, int i, int i2, int i3);

    public void onManualOperationRelease() {
        if (!this.mIsFinish) {
            this.mRefreshKernel.i(0, true);
            return;
        }
        this.mManualOperation = false;
        if (this.mTouchY != -1.0f) {
            onFinish(this.mRefreshKernel.k(), this.mLastFinish);
            this.mRefreshKernel.d(RefreshState.RefreshFinish);
            this.mRefreshKernel.b(0);
        } else {
            this.mRefreshKernel.i(this.mHeaderHeight, true);
        }
        View view = this.mRefreshContent.getView();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin -= this.mHeaderHeight;
        view.setLayoutParams(marginLayoutParams);
    }

    public void onManualOperationStart() {
        if (this.mManualOperation) {
            return;
        }
        this.mManualOperation = true;
        RefreshContent refreshContentE = this.mRefreshKernel.e();
        this.mRefreshContent = refreshContentE;
        View view = refreshContentE.getView();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin += this.mHeaderHeight;
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (this.mManualOperation) {
            onManualOperationMove(f, i, i2, i3);
        } else {
            this.mOffset = i;
            setTranslationY(i - this.mHeaderHeight);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mIsFinish = false;
        setTranslationY(0.0f);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        this.mState = refreshState2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006d  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState = this.mState;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshFinish) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.mManualOperation) {
            onManualOperationStart();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mTouchY = motionEvent.getRawY();
            this.mRefreshKernel.i(0, true);
        } else if (action == 1) {
            onManualOperationRelease();
            this.mTouchY = -1.0f;
            if (this.mIsFinish) {
                this.mRefreshKernel.i(this.mHeaderHeight, true);
            }
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.mTouchY;
            if (rawY >= 0.0f) {
                double d = this.mHeaderHeight * 2;
                double d2 = (this.mScreenHeightPixels * 2) / 3.0f;
                double dMax = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, ((double) rawY) * 0.5d);
                this.mRefreshKernel.i(Math.max(1, (int) Math.min(d * (1.0d - Math.pow(100.0d, (-dMax) / d2)), dMax)), false);
            } else {
                this.mRefreshKernel.i(1, false);
            }
        } else if (action == 3) {
            onManualOperationRelease();
            this.mTouchY = -1.0f;
            if (this.mIsFinish) {
                this.mRefreshKernel.i(this.mHeaderHeight, true);
            }
        }
        return true;
    }
}
