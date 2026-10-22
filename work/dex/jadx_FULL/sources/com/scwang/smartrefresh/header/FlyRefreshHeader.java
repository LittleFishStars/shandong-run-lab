package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.scwang.smartrefresh.header.flyrefresh.MountainSceneView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.zj.adlib.qk8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FlyRefreshHeader extends FalsifyHeader implements RefreshHeader {
    protected float mCurrentPercent;
    protected AnimatorSet mFlyAnimator;
    protected View mFlyView;
    protected boolean mIsRefreshing;
    protected int mOffset;
    protected RefreshKernel mRefreshKernel;
    protected RefreshLayout mRefreshLayout;
    protected MountainSceneView mSceneView;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FlyRefreshHeader.this.onMoving(true, ((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = FlyRefreshHeader.this.mFlyView;
            if (view != null) {
                view.setRotationY(180.0f);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimatorListenerAdapter f40369a;

        public c(AnimatorListenerAdapter animatorListenerAdapter) {
            this.f40369a = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshLayout refreshLayout = FlyRefreshHeader.this.mRefreshLayout;
            if (refreshLayout != null) {
                refreshLayout.setEnableRefresh(true);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.f40369a;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = FlyRefreshHeader.this.mFlyView;
            if (view != null) {
                view.setRotationY(0.0f);
            }
        }
    }

    public FlyRefreshHeader(Context context) {
        super(context);
        this.mOffset = 0;
        this.mIsRefreshing = false;
    }

    public void finishRefresh() {
        finishRefresh(null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        if (this.mIsRefreshing) {
            finishRefresh();
        }
        return super.onFinish(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
        RefreshLayout refreshLayoutK = refreshKernel.k();
        this.mRefreshLayout = refreshLayoutK;
        refreshLayoutK.setEnableOverScrollDrag(false);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z || !this.mIsRefreshing) {
            if (i < 0) {
                if (this.mOffset <= 0) {
                    return;
                }
                i = 0;
                f = 0.0f;
            }
            this.mOffset = i;
            this.mCurrentPercent = f;
            MountainSceneView mountainSceneView = this.mSceneView;
            if (mountainSceneView != null) {
                mountainSceneView.updatePercent(f);
                this.mSceneView.postInvalidate();
            }
            View view = this.mFlyView;
            if (view != null) {
                int i4 = i2 + i3;
                if (i4 > 0) {
                    view.setRotation((i * (-45.0f)) / i4);
                } else {
                    view.setRotation(f * (-45.0f));
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mRefreshKernel.b(0);
        float f = this.mCurrentPercent;
        if (f > 0.0f) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.start();
            this.mCurrentPercent = 0.0f;
        }
        if (this.mFlyView == null || this.mIsRefreshing) {
            return;
        }
        AnimatorSet animatorSet = this.mFlyAnimator;
        if (animatorSet != null) {
            animatorSet.end();
            this.mFlyView.clearAnimation();
        }
        this.mIsRefreshing = true;
        refreshLayout.setEnableRefresh(false);
        int width = ((View) this.mRefreshLayout).getWidth() - this.mFlyView.getLeft();
        int i3 = ((-(this.mFlyView.getTop() - this.mOffset)) * 2) / 3;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mFlyView, "translationX", 0.0f, width);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mFlyView, "translationY", 0.0f, i3);
        objectAnimatorOfFloat2.setInterpolator(PathInterpolatorCompat.create(0.7f, 1.0f));
        View view = this.mFlyView;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.ROTATION, view.getRotation(), 0.0f);
        objectAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator());
        View view2 = this.mFlyView;
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "rotationX", view2.getRotationX(), 50.0f);
        objectAnimatorOfFloat4.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        View view3 = this.mFlyView;
        float[] fArr = {view3.getScaleX(), 0.5f};
        View view4 = this.mFlyView;
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, ObjectAnimator.ofFloat(view3, "scaleX", fArr), ObjectAnimator.ofFloat(view4, "scaleY", view4.getScaleY(), 0.5f));
        this.mFlyAnimator = animatorSet2;
        animatorSet2.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        MountainSceneView mountainSceneView;
        if (iArr.length <= 0 || (mountainSceneView = this.mSceneView) == null) {
            return;
        }
        mountainSceneView.setPrimaryColor(iArr[0]);
    }

    public void setUp(@Nullable MountainSceneView mountainSceneView, @Nullable View view) {
        this.mFlyView = view;
        this.mSceneView = mountainSceneView;
    }

    public void finishRefresh(AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.mFlyView == null || !this.mIsRefreshing || this.mRefreshLayout == null) {
            return;
        }
        AnimatorSet animatorSet = this.mFlyAnimator;
        if (animatorSet != null) {
            animatorSet.end();
            this.mFlyView.clearAnimation();
        }
        this.mIsRefreshing = false;
        this.mRefreshLayout.finishRefresh(0);
        int i = -this.mFlyView.getRight();
        int i2 = -qk8.d(10.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        View view = this.mFlyView;
        float f = i;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), f);
        View view2 = this.mFlyView;
        float f2 = i2;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, "translationY", view2.getTranslationY(), f2);
        objectAnimatorOfFloat2.setInterpolator(PathInterpolatorCompat.create(0.1f, 1.0f));
        View view3 = this.mFlyView;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view3, Key.ROTATION, view3.getRotation(), 0.0f);
        View view4 = this.mFlyView;
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view4, "rotationX", view4.getRotationX(), 30.0f);
        objectAnimatorOfFloat3.setInterpolator(new AccelerateInterpolator());
        View view5 = this.mFlyView;
        float[] fArr = {view5.getScaleX(), 0.9f};
        View view6 = this.mFlyView;
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, ObjectAnimator.ofFloat(view5, "scaleX", fArr), ObjectAnimator.ofFloat(view6, "scaleY", view6.getScaleY(), 0.9f));
        animatorSet2.addListener(new b());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(800L);
        animatorSet3.setInterpolator(new DecelerateInterpolator());
        animatorSet3.playTogether(ObjectAnimator.ofFloat(this.mFlyView, "translationX", f, 0.0f), ObjectAnimator.ofFloat(this.mFlyView, "translationY", f2, 0.0f), ObjectAnimator.ofFloat(this.mFlyView, "rotationX", 30.0f, 0.0f), ObjectAnimator.ofFloat(this.mFlyView, "scaleX", 0.9f, 1.0f), ObjectAnimator.ofFloat(this.mFlyView, "scaleY", 0.9f, 1.0f));
        animatorSet3.setStartDelay(100L);
        animatorSet3.addListener(new c(animatorListenerAdapter));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.mFlyAnimator = animatorSet4;
        animatorSet4.playSequentially(animatorSet2, animatorSet3);
        this.mFlyAnimator.start();
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOffset = 0;
        this.mIsRefreshing = false;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOffset = 0;
        this.mIsRefreshing = false;
    }
}
