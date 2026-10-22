package com.huachenjie.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class LoadingLineView extends View {
    public LoadingLineView(Context context) {
        super(context);
        initView();
    }

    public void initView() {
        setBackgroundColor(-1);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0) {
            startAnimation();
        } else {
            Animation animation = getAnimation();
            if (animation != null) {
                animation.cancel();
                setAnimation(null);
            }
        }
        super.setVisibility(visibility);
    }

    public void startAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.3f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        scaleAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatCount(-1);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(500L);
        startAnimation(animationSet);
    }

    public LoadingLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
}
