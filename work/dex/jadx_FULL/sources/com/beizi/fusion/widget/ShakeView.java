package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ShakeView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27962a;
    ImageView b;
    TextView c;
    private String d;
    private AnimationDrawable e;
    private boolean f;

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27962a = false;
        init(context);
    }

    private void a() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.b = imageView;
        imageView.setBackgroundResource(R.drawable.beizi_anim_shake_download);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.b, layoutParams);
        this.e = (AnimationDrawable) this.b.getBackground();
    }

    public void init(Context context) {
        if (this.f27962a) {
            return;
        }
        this.f27962a = true;
        ImageView imageView = new ImageView(context);
        this.b = imageView;
        imageView.setBackgroundResource(R.drawable.beizi_anim_shake);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.b, layoutParams);
        this.e = (AnimationDrawable) this.b.getBackground();
    }

    public void setDownloadApp(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        this.f = zBooleanValue;
        if (zBooleanValue) {
            a();
        }
    }

    public void setTitleText(String str) {
        this.d = str;
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void startShake() {
        AnimationDrawable animationDrawable = this.e;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopShake() {
        AnimationDrawable animationDrawable = this.e;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void updateTwistRollAnim() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.b = imageView;
        imageView.setBackgroundResource(R.drawable.beizi_twist_roll);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.b, layoutParams);
        this.e = (AnimationDrawable) this.b.getBackground();
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27962a = false;
        init(context);
    }

    public ShakeView(Context context) {
        super(context);
        this.f27962a = false;
        init(context);
    }
}
