package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SlideClickView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27965a;
    private ImageView b;
    private TextView c;
    private String d;
    private int e;
    private int f;
    private int g;
    private AnimationDrawable h;

    public SlideClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27965a = false;
        this.f = 45;
        this.g = 45;
        init(context);
    }

    private void a() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        this.h = animationDrawable;
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.beizi_slide_down_one), 600);
        this.h.addFrame(getResources().getDrawable(R.drawable.beizi_slide_down_two), 600);
        this.h.addFrame(getResources().getDrawable(R.drawable.beizi_slide_down_three), 600);
        this.h.setOneShot(false);
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageDrawable(this.h);
        }
    }

    public void init(Context context) {
        if (this.f27965a) {
            return;
        }
        this.f27965a = true;
        TextView textView = new TextView(context);
        this.c = textView;
        textView.setGravity(17);
        this.b = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(17);
        addView(this.c, layoutParams);
        addView(this.b, layoutParams2);
        a();
    }

    public void setImageWidthAndHeight(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
        }
    }

    public void setTitleFont(int i) {
        TextView textView;
        this.e = i;
        if (i == 0 || (textView = this.c) == null) {
            return;
        }
        textView.setTextSize(2, i);
    }

    public void setTitleText(String str) {
        TextView textView;
        this.d = str;
        if (TextUtils.isEmpty(str) || (textView = this.c) == null) {
            return;
        }
        textView.setText(str);
        this.c.setTypeface(Typeface.DEFAULT, 1);
        this.c.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.c.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
    }

    public void startAnim() {
        AnimationDrawable animationDrawable = this.h;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopAnim() {
        AnimationDrawable animationDrawable = this.h;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public SlideClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27965a = false;
        this.f = 45;
        this.g = 45;
        init(context);
    }

    public SlideClickView(Context context) {
        super(context);
        this.f27965a = false;
        this.f = 45;
        this.g = 45;
        init(context);
    }
}
