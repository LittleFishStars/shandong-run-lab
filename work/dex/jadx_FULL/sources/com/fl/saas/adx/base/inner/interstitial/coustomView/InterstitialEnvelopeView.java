package com.fl.saas.adx.base.inner.interstitial.coustomView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.EnumC1430q0;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.InnerNativeAdLogo;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.base.innterNative.BindActionView;
import com.fl.saas.adx.base.widget.CountDownTextView;
import com.fl.saas.adx.base.widget.ShakeView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialEnvelopeView implements InnerNativeCustomView, InnerNativeAdLogo, BindActionView {
    private final LinearLayout CATView;
    private final ImageView adImage;
    private final ImageView adLogo;
    private final View adView;
    private int animalTime;
    private final ImageView bgImageView;
    private final RelativeLayout bgView;
    private final ImageView closeView;
    private final ImageView closeViewTop;
    private final TextView desView;
    private boolean isOnlyButton;
    private final ImageView iv_arrow1;
    private final ImageView iv_arrow2;
    private Animator mAnimator;
    private String mCat;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private final RelativeLayout mRlTopCLose;
    private final CountDownTextView mSkip;
    private final CountDownTextView mSkipTop;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final EnumC1430q0 orientation;
    private int speed;
    private int startTime;
    private final TextView titleView;
    private boolean topClose;
    private final TextView tv_action;
    private final TextView tv_arrow;
    private final View vClose;
    private final View vCloseTop;
    private final ShakeView ydShakeView;

    public InterstitialEnvelopeView(Context context, EnumC1430q0 enumC1430q0, boolean z, boolean z2, int i, int i2) {
        this.orientation = enumC1430q0;
        this.startTime = i;
        this.animalTime = i2;
        this.topClose = z2;
        this.mContext = context;
        View viewInflate = ViewHelper.inflate(context, z ? R.layout.fl_adx_interstitial_small_envelope : R.layout.fl_adx_interstitial_envelope);
        this.adView = viewInflate;
        ShakeView shakeView = (ShakeView) viewInflate.findViewById(R.id.yd_shake_view);
        this.ydShakeView = shakeView;
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_des);
        this.CATView = (LinearLayout) viewInflate.findViewById(R.id.ll_action);
        this.tv_action = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_btn);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_img);
        this.bgImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_bg_img);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.iv_yd_saas_custom_video);
        this.adLogo = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_logo);
        this.adImage = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_img_small);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rl_close);
        this.mRlTopCLose = relativeLayout;
        CountDownTextView countDownTextView = (CountDownTextView) viewInflate.findViewById(R.id.tv_skip);
        this.mSkip = countDownTextView;
        this.mSkipTop = (CountDownTextView) viewInflate.findViewById(R.id.tv_skip_top);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_close);
        this.closeView = imageView;
        this.closeViewTop = (ImageView) viewInflate.findViewById(R.id.iv_close_top);
        View viewFindViewById = viewInflate.findViewById(R.id.v_close);
        this.vClose = viewFindViewById;
        this.vCloseTop = viewInflate.findViewById(R.id.v_close_top);
        this.iv_arrow1 = (ImageView) viewInflate.findViewById(R.id.iv_arrow1);
        this.iv_arrow2 = (ImageView) viewInflate.findViewById(R.id.iv_arrow2);
        this.tv_arrow = (TextView) viewInflate.findViewById(R.id.tv_arrow);
        this.bgView = (RelativeLayout) viewInflate.findViewById(R.id.rl_yd_saas_ad_card);
        shakeView.setCallback(true);
        if (z2) {
            relativeLayout.setVisibility(0);
            countDownTextView.setVisibility(8);
            imageView.setVisibility(8);
            viewFindViewById.setVisibility(8);
        } else {
            relativeLayout.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv_top_bg);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.iv_bottom_bg);
        FLImageLoader.getInstance(this.mContext).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(imageView2, "https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_top.webp");
        FLImageLoader.getInstance(this.mContext).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(imageView3, "https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_bottom.webp");
    }

    public static /* synthetic */ int access$210(InterstitialEnvelopeView interstitialEnvelopeView) {
        int i = interstitialEnvelopeView.animalTime;
        interstitialEnvelopeView.animalTime = i - 1;
        return i;
    }

    private Animator createAnimatorSet(View view, float f) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getMeasuredHeight() / 2.0f);
        view.setPivotY(view.getMeasuredWidth() / 2.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        float f2 = -f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, f2);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setStartDelay(500L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", f2, 0.0f);
        objectAnimatorOfFloat2.setDuration(250L);
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialEnvelopeView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (InterstitialEnvelopeView.this.animalTime > 1) {
                    InterstitialEnvelopeView.access$210(InterstitialEnvelopeView.this);
                    animator.setStartDelay(0L);
                    animator.start();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindActionView$1(int i, int i2, int i3) {
        LinearLayout linearLayout = this.CATView;
        if (linearLayout != null) {
            linearLayout.performClick();
            ViewHelper.setTextView(this.tv_action, this.mCat);
            ShakeView shakeView = this.ydShakeView;
            if (shakeView != null) {
                ViewHelper.removeParent(shakeView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$2(Bitmap bitmap) {
        this.adImage.setVisibility(0);
        this.adImage.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setSpeed$0(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    private void playAnimal() {
        if (this.iv_arrow1 != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
            alphaAnimation.setDuration(700L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            this.iv_arrow1.startAnimation(alphaAnimation);
        }
        if (this.iv_arrow2 != null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.5f);
            alphaAnimation2.setDuration(700L);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setRepeatCount(-1);
            alphaAnimation2.setRepeatMode(2);
            this.iv_arrow2.startAnimation(alphaAnimation2);
        }
        RelativeLayout relativeLayout = this.bgView;
        if (relativeLayout != null) {
            if (this.mAnimator == null) {
                this.mAnimator = createAnimatorSet(relativeLayout, DeviceUtil.dip2px(15.0f));
            }
            if (this.mAnimator.isRunning()) {
                return;
            }
            this.mAnimator.setStartDelay(this.startTime);
            this.mAnimator.start();
        }
    }

    @Override // com.fl.saas.adx.base.innterNative.BindActionView
    public void bindActionView(View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        ShakeView shakeView = this.ydShakeView;
        if (shakeView == null) {
            return;
        }
        shakeView.setCallback(false);
        this.ydShakeView.setVisibility(0);
        this.ydShakeView.setShakeListener(this.speed, new ShakeView.ShakeListener() { // from class: com.zj.adlib.rd4
            @Override // com.fl.saas.adx.base.widget.ShakeView.ShakeListener
            public final void onShake(int i, int i2, int i3) {
                this.f44425a.lambda$bindActionView$1(i, i2, i3);
            }
        });
    }

    public void cancelAnimal() {
        this.animalTime = 0;
        ImageView imageView = this.iv_arrow1;
        if (imageView != null) {
            imageView.clearAnimation();
        }
        ImageView imageView2 = this.iv_arrow2;
        if (imageView2 != null) {
            imageView2.clearAnimation();
        }
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getCATView() {
        return this.CATView;
    }

    public ImageView getCloseView() {
        return this.topClose ? this.closeViewTop : this.closeView;
    }

    public CountDownTextView getSkip() {
        return this.topClose ? this.mSkipTop : this.mSkip;
    }

    public View getSpaceView() {
        return this.topClose ? this.vCloseTop : this.vClose;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public B loadIcon() {
        return new B() { // from class: com.zj.adlib.pd4
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f43955a.lambda$loadIcon$2((Bitmap) obj);
            }
        };
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeAdLogo
    public void setAdLogo(Bitmap bitmap) {
        this.adLogo.setImageBitmap(bitmap);
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        this.mCat = str;
        ShakeView shakeView = this.ydShakeView;
        if (shakeView == null || shakeView.getVisibility() != 0) {
            ViewHelper.setTextView(this.tv_action, str);
        } else {
            ViewHelper.setTextView(this.tv_action, "摇一摇或点击了解更多");
        }
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, @Nullable Drawable drawable) {
        if (view != null) {
            this.mediaContainer.removeAllViews();
            this.mediaContainer.addView(view, ViewHelper.getMatchParent());
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.adImage.setImageDrawable(drawable);
            this.adImage.setVisibility(0);
            if (this.orientation == EnumC1430q0.VERTICAL) {
                this.mainImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                AbstractC1398a0.a(this.bgImageView, drawable);
            } else {
                this.mainImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
        }
        playAnimal();
        return this;
    }

    public void setOnlyButton(boolean z) {
        this.isOnlyButton = z;
    }

    public void setSpeed(int i) {
        this.speed = i;
        try {
            if (this.mGestureDetector == null) {
                this.mGestureDetector = new GestureDetector(this.mContext, new GestureDetector.OnGestureListener() { // from class: com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialEnvelopeView.1
                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onDown(@NonNull MotionEvent motionEvent) {
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
                        float fAbs = Math.abs(motionEvent2.getX() - motionEvent.getX());
                        float fAbs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
                        if ((fAbs <= 50.0f && fAbs2 <= 50.0f) || InterstitialEnvelopeView.this.CATView == null) {
                            return true;
                        }
                        InterstitialEnvelopeView.this.CATView.performClick();
                        return true;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public void onShowPress(@NonNull MotionEvent motionEvent) {
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                        if (InterstitialEnvelopeView.this.CATView == null || InterstitialEnvelopeView.this.isOnlyButton) {
                            return true;
                        }
                        InterstitialEnvelopeView.this.CATView.performClick();
                        return true;
                    }
                });
                this.bgView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.td4
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return this.f44895a.lambda$setSpeed$0(view, motionEvent);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
