package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends b {
    public ImageView k;
    public ImageView l;
    public TextView m;

    public e(Context context) {
        super(context);
        int iA = (int) s.a(context, 12.0f);
        int iA2 = (int) s.a(context, 24.0f);
        int iA3 = (int) s.a(context, 36.0f);
        int iA4 = (int) s.a(context, 48.0f);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iA4);
        layoutParams.gravity = 1;
        TextView textView = new TextView(context);
        this.m = textView;
        textView.setBackgroundResource(R.drawable.ipd_bg_blue);
        this.m.setGravity(17);
        this.m.setSingleLine(true);
        this.m.setTextSize(18.0f);
        this.m.setTextColor(-1);
        this.m.setText("点击跳转详情页或第三方应用");
        frameLayout.addView(this.m, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA3, iA3);
        layoutParams2.gravity = 1;
        layoutParams2.setMargins(iA / 3, iA, 0, 0);
        ImageView imageView = new ImageView(context);
        this.l = imageView;
        imageView.setImageResource(R.drawable.ipd_ic_ring);
        this.l.setAlpha(0.8f);
        frameLayout.addView(this.l, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA3, iA3);
        layoutParams3.gravity = 1;
        layoutParams3.setMargins(iA2, iA2, 0, 0);
        ImageView imageView2 = new ImageView(context);
        this.k = imageView2;
        imageView2.setImageResource(R.drawable.ipd_ic_pointer);
        frameLayout.addView(this.k, layoutParams3);
    }

    @Override // com.ipd.dsp.internal.t1.b
    public void a(String str) {
        if (this.m == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.m.setText(str);
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void c() {
        View interactionView = getInteractionView();
        if (interactionView != null) {
            interactionView.setRotation(0.0f);
        }
    }

    @Override // com.ipd.dsp.internal.t1.c
    public int getAnimationDelayTime() {
        return 200;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public Animator getAnimator() {
        View interactionView;
        if (this.l == null || (interactionView = getInteractionView()) == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, -20.0f).setDuration(400L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, -20.0f, 0.0f).setDuration(400L));
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.l, "scaleX", 1.0f, 1.5f).setDuration(800L), ObjectAnimator.ofFloat(this.l, "scaleY", 1.0f, 1.5f).setDuration(800L), ObjectAnimator.ofFloat(this.l, "alpha", 0.8f, 0.6f, 0.0f).setDuration(800L));
        return animatorSet;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public View getInteractionView() {
        return this.k;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void setText(String str) {
        if (this.m == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.m.setText(String.format(Locale.getDefault(), "点击%s", str));
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void a() {
        super.a();
        this.k = null;
        this.l = null;
        this.m = null;
    }
}
