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
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fl.saas.R;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FingerSlidingView extends FrameLayout implements View.OnTouchListener {
    private int bgHeight;
    private View bgView;
    private boolean isCallback;
    private boolean isVisibility;
    private Animator mAnimator;
    private GestureDetector mGestureDetector;
    private ImageView mImageView;
    private SlidingListener mSlidingListener;
    private int scale_type;
    private int slidingThreshold;

    public interface SlidingListener {
        void onDown(int i, int i2, View view);

        void onSliding();

        void onUp(int i, int i2, View view);
    }

    public FingerSlidingView(@NonNull Context context) {
        super(context);
        this.slidingThreshold = 100;
        this.isCallback = false;
        this.isVisibility = false;
    }

    private void cancelAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
        View view = this.bgView;
        if (view != null) {
            view.clearAnimation();
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
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.adx.base.widget.FingerSlidingView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (FingerSlidingView.this.mImageView != null) {
                    FingerSlidingView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (FingerSlidingView.this.isVisibility) {
                    animator.start();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimator() {
        if (this.mAnimator == null) {
            this.mAnimator = createAnimatorSet(this.mImageView, 400L, DeviceUtil.dip2px(20.0f));
        }
        if (!this.mAnimator.isRunning()) {
            this.mAnimator.start();
        }
        if (this.bgView != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.1f, 1, 0.5f, 1, 1.0f);
            scaleAnimation.setDuration(700L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.bgView.startAnimation(scaleAnimation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x006d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0075  */
    /* JADX WARN: Code duplicated, block: B:15:0x0078  */
    /* JADX WARN: Instruction removed from duplicated block: B:11:0x006d, please report this as an issue */
    public void createView() {
        int i;
        double d;
        float f;
        View viewInflate = ViewHelper.inflate(getContext(), R.layout.fl_adx_view_sliding_spread);
        this.mImageView = (ImageView) viewInflate.findViewById(R.id.iv_finger);
        FLImageLoader.getInstance(getContext()).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage((ImageView) viewInflate.findViewById(R.id.iv_all_arrow), "https://creative.medproad.com/medpro/imgs/yd_saas_icon_all_arrow.webp");
        FLImageLoader.getInstance(getContext()).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.mImageView, "https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp");
        int mobileHeight = DeviceUtil.getMobileHeight();
        if (mobileHeight > 0) {
            f = mobileHeight < DeviceUtil.px2dip(500.0f) ? 800.0f : 900.0f;
            double d2 = mobileHeight;
            int i2 = (int) (0.2d * d2);
            i = this.scale_type;
            if (i == 1) {
                d = i == 2 ? 0.4d : 0.3d;
                this.bgHeight = i2;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i2);
                layoutParams.gravity = 80;
                View view = new View(getContext());
                this.bgView = view;
                view.setBackgroundResource(R.drawable.fl_adx_slide_bg);
                addView(this.bgView, layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i2 + DeviceUtil.dip2px(140.0f));
                layoutParams2.gravity = 81;
                addView(viewInflate, layoutParams2);
                this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.fl.saas.adx.base.widget.FingerSlidingView.1
                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onDown(@NonNull MotionEvent motionEvent) {
                        FingerSlidingView.this.isCallback = false;
                        return true;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                        return true;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public void onLongPress(@NonNull MotionEvent motionEvent) {
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                        if (FingerSlidingView.this.isCallback) {
                            return true;
                        }
                        float fAbs = Math.abs(motionEvent2.getX() - motionEvent.getX());
                        float fAbs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
                        if ((fAbs > FingerSlidingView.this.slidingThreshold || fAbs2 > FingerSlidingView.this.slidingThreshold) && FingerSlidingView.this.mSlidingListener != null) {
                            FingerSlidingView.this.mSlidingListener.onUp((int) motionEvent2.getX(), (int) motionEvent2.getY(), FingerSlidingView.this);
                            FingerSlidingView.this.mSlidingListener.onSliding();
                            FingerSlidingView.this.isCallback = true;
                        }
                        return true;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public void onShowPress(@NonNull MotionEvent motionEvent) {
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                        if (motionEvent.getY() <= FingerSlidingView.this.getHeight() - FingerSlidingView.this.bgHeight) {
                            return true;
                        }
                        FingerSlidingView.this.mSlidingListener.onSliding();
                        return true;
                    }
                });
                setOnTouchListener(this);
                setFocusable(true);
                setClickable(true);
                setLongClickable(true);
            }
            i2 = (int) (d2 * d);
            this.bgHeight = i2;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
            layoutParams3.gravity = 80;
            View view2 = new View(getContext());
            this.bgView = view2;
            view2.setBackgroundResource(R.drawable.fl_adx_slide_bg);
            addView(this.bgView, layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, i2 + DeviceUtil.dip2px(140.0f));
            layoutParams4.gravity = 81;
            addView(viewInflate, layoutParams4);
            this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.fl.saas.adx.base.widget.FingerSlidingView.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(@NonNull MotionEvent motionEvent) {
                    FingerSlidingView.this.isCallback = false;
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(@NonNull MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                    if (FingerSlidingView.this.isCallback) {
                        return true;
                    }
                    float fAbs = Math.abs(motionEvent2.getX() - motionEvent.getX());
                    float fAbs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
                    if ((fAbs > FingerSlidingView.this.slidingThreshold || fAbs2 > FingerSlidingView.this.slidingThreshold) && FingerSlidingView.this.mSlidingListener != null) {
                        FingerSlidingView.this.mSlidingListener.onUp((int) motionEvent2.getX(), (int) motionEvent2.getY(), FingerSlidingView.this);
                        FingerSlidingView.this.mSlidingListener.onSliding();
                        FingerSlidingView.this.isCallback = true;
                    }
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(@NonNull MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                    if (motionEvent.getY() <= FingerSlidingView.this.getHeight() - FingerSlidingView.this.bgHeight) {
                        return true;
                    }
                    FingerSlidingView.this.mSlidingListener.onSliding();
                    return true;
                }
            });
            setOnTouchListener(this);
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
        }
        mobileHeight = DeviceUtil.dip2px(f);
        double d3 = mobileHeight;
        int i3 = (int) (0.2d * d3);
        i = this.scale_type;
        if (i == 1) {
            if (i == 2) {
            }
            this.bgHeight = i3;
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, i3);
            layoutParams5.gravity = 80;
            View view3 = new View(getContext());
            this.bgView = view3;
            view3.setBackgroundResource(R.drawable.fl_adx_slide_bg);
            addView(this.bgView, layoutParams5);
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, i3 + DeviceUtil.dip2px(140.0f));
            layoutParams6.gravity = 81;
            addView(viewInflate, layoutParams6);
            this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.fl.saas.adx.base.widget.FingerSlidingView.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(@NonNull MotionEvent motionEvent) {
                    FingerSlidingView.this.isCallback = false;
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(@NonNull MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                    if (FingerSlidingView.this.isCallback) {
                        return true;
                    }
                    float fAbs = Math.abs(motionEvent2.getX() - motionEvent.getX());
                    float fAbs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
                    if ((fAbs > FingerSlidingView.this.slidingThreshold || fAbs2 > FingerSlidingView.this.slidingThreshold) && FingerSlidingView.this.mSlidingListener != null) {
                        FingerSlidingView.this.mSlidingListener.onUp((int) motionEvent2.getX(), (int) motionEvent2.getY(), FingerSlidingView.this);
                        FingerSlidingView.this.mSlidingListener.onSliding();
                        FingerSlidingView.this.isCallback = true;
                    }
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(@NonNull MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                    if (motionEvent.getY() <= FingerSlidingView.this.getHeight() - FingerSlidingView.this.bgHeight) {
                        return true;
                    }
                    FingerSlidingView.this.mSlidingListener.onSliding();
                    return true;
                }
            });
            setOnTouchListener(this);
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
        }
        i3 = (int) (d3 * d);
        this.bgHeight = i3;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, i3);
        layoutParams7.gravity = 80;
        View view4 = new View(getContext());
        this.bgView = view4;
        view4.setBackgroundResource(R.drawable.fl_adx_slide_bg);
        addView(this.bgView, layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, i3 + DeviceUtil.dip2px(140.0f));
        layoutParams8.gravity = 81;
        addView(viewInflate, layoutParams8);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.fl.saas.adx.base.widget.FingerSlidingView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(@NonNull MotionEvent motionEvent) {
                FingerSlidingView.this.isCallback = false;
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(@NonNull MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f2, float f3) {
                if (FingerSlidingView.this.isCallback) {
                    return true;
                }
                float fAbs = Math.abs(motionEvent2.getX() - motionEvent.getX());
                float fAbs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
                if ((fAbs > FingerSlidingView.this.slidingThreshold || fAbs2 > FingerSlidingView.this.slidingThreshold) && FingerSlidingView.this.mSlidingListener != null) {
                    FingerSlidingView.this.mSlidingListener.onUp((int) motionEvent2.getX(), (int) motionEvent2.getY(), FingerSlidingView.this);
                    FingerSlidingView.this.mSlidingListener.onSliding();
                    FingerSlidingView.this.isCallback = true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(@NonNull MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                if (motionEvent.getY() <= FingerSlidingView.this.getHeight() - FingerSlidingView.this.bgHeight) {
                    return true;
                }
                FingerSlidingView.this.mSlidingListener.onSliding();
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
                slidingListener.onDown(x, y, this);
            }
        }
        if (motionEvent.getAction() == 1) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            SlidingListener slidingListener2 = this.mSlidingListener;
            if (slidingListener2 != null) {
                slidingListener2.onUp(x2, y2, this);
            }
        }
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i == 0) {
            this.mImageView.post(new Runnable() { // from class: com.zj.adlib.ih3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42357a.playAnimator();
                }
            });
        } else {
            cancelAnimator();
        }
    }

    public void setScale_type(int i) {
        this.scale_type = i;
    }

    public void setSlidingListener(int i, SlidingListener slidingListener) {
        this.mSlidingListener = slidingListener;
        this.slidingThreshold = i * 4;
    }

    public FingerSlidingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FingerSlidingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.slidingThreshold = 100;
        this.isCallback = false;
        this.isVisibility = false;
        createView();
    }
}
