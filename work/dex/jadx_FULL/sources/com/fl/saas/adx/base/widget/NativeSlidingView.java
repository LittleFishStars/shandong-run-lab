package com.fl.saas.adx.base.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fl.saas.R;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NativeSlidingView extends FrameLayout implements View.OnTouchListener {
    private boolean isCallback;
    private boolean isVisibility;
    private Animator mAnimator;
    private GestureDetector mGestureDetector;
    private ImageView mImageView;
    private SlidingListener mSlidingListener;
    private int slidingThreshold;

    public interface SlidingListener {
        void onDown(int i, int i2);

        void onSliding();

        void onUp(int i, int i2);
    }

    public NativeSlidingView(@NonNull Context context) {
        super(context);
        this.isCallback = false;
        this.slidingThreshold = 100;
        this.isVisibility = false;
    }

    private void cancelAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    private Animator createAnimatorSet(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getMeasuredHeight() / 2.0f);
        view.setPivotY(view.getMeasuredWidth() / 2.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f);
        objectAnimatorOfFloat.setDuration(j);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", f, 0.0f);
        objectAnimatorOfFloat2.setDuration(j);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, f);
        objectAnimatorOfFloat3.setDuration(j);
        objectAnimatorOfFloat3.setStartDelay(200L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "translationY", f, 0.0f);
        objectAnimatorOfFloat4.setDuration(j);
        float f2 = -f;
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f2);
        objectAnimatorOfFloat5.setDuration(j);
        objectAnimatorOfFloat5.setStartDelay(200L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, "translationX", f2, 0.0f);
        objectAnimatorOfFloat6.setDuration(j);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, f2);
        objectAnimatorOfFloat7.setDuration(j);
        objectAnimatorOfFloat7.setStartDelay(200L);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(view, "translationY", f2, 0.0f);
        objectAnimatorOfFloat8.setDuration(j);
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
        animatorSet.setStartDelay(400L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.adx.base.widget.NativeSlidingView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (NativeSlidingView.this.mImageView != null) {
                    NativeSlidingView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (NativeSlidingView.this.isVisibility) {
                    animator.start();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimator() {
        if (this.mAnimator == null) {
            this.mAnimator = createAnimatorSet(this.mImageView, 400L, DeviceUtil.dip2px(10.0f));
        }
        if (this.mAnimator.isRunning()) {
            return;
        }
        this.mAnimator.start();
    }

    public void createView(boolean z) {
        View viewInflate = ViewHelper.inflate(getContext(), R.layout.fl_adx_view_video_sliding_spread);
        this.mImageView = (ImageView) viewInflate.findViewById(R.id.iv_finger);
        FLImageLoader.getInstance(getContext()).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.mImageView, "https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp");
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_tips);
        if (!z) {
            linearLayout.setVisibility(8);
        }
        addView(viewInflate, new FrameLayout.LayoutParams(-1, -1));
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.fl.saas.adx.base.widget.NativeSlidingView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(@NonNull MotionEvent motionEvent) {
                NativeSlidingView.this.isCallback = false;
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(@NonNull MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
                if (NativeSlidingView.this.isCallback) {
                    return true;
                }
                float fAbs = Math.abs(motionEvent2.getX() - motionEvent.getX());
                float fAbs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
                if ((fAbs > NativeSlidingView.this.slidingThreshold || fAbs2 > NativeSlidingView.this.slidingThreshold) && NativeSlidingView.this.mSlidingListener != null) {
                    NativeSlidingView.this.mSlidingListener.onUp((int) motionEvent2.getX(), (int) motionEvent2.getY());
                    NativeSlidingView.this.mSlidingListener.onSliding();
                    NativeSlidingView.this.isCallback = true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(@NonNull MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                if (motionEvent.getY() <= NativeSlidingView.this.getHeight() - DeviceUtil.dip2px(40.0f)) {
                    return true;
                }
                NativeSlidingView.this.mSlidingListener.onSliding();
                return true;
            }
        });
        setOnTouchListener(this);
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimator();
        this.mAnimator = null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            SlidingListener slidingListener = this.mSlidingListener;
            if (slidingListener != null) {
                slidingListener.onDown(x, y);
            }
        }
        if (motionEvent.getAction() == 1) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            SlidingListener slidingListener2 = this.mSlidingListener;
            if (slidingListener2 != null) {
                slidingListener2.onUp(x2, y2);
            }
        }
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i == 0) {
            this.mImageView.post(new Runnable() { // from class: com.zj.adlib.kx5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42938a.playAnimator();
                }
            });
        } else {
            cancelAnimator();
        }
    }

    public void setSlidingListener(int i, SlidingListener slidingListener) {
        this.mSlidingListener = slidingListener;
        this.slidingThreshold = i * 4;
    }

    public NativeSlidingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeSlidingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isCallback = false;
        this.slidingThreshold = 100;
        this.isVisibility = false;
    }
}
