package com.huachenjie.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CircleLoadingView extends LottieAnimationView {
    public CircleLoadingView(Context context) {
        super(context);
        initAttrs(context);
    }

    private void initAttrs(Context context) {
        setImageAssetsFolder(com.ipd.dsp.internal.l.a.l);
        setRepeatCount(-1);
        setAnimation("animation/pull_to_refresh.json");
    }

    public void setSize(int width, int height) {
        setLayoutParams(new ViewGroup.LayoutParams(jj8.a(width), jj8.a(height)));
    }

    public CircleLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context);
    }

    public CircleLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context);
    }
}
