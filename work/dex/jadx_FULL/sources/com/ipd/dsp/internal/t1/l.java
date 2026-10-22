package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class l extends c {
    public final int k;
    public final double l;
    public final k m;
    public final TextView n;

    public l(Context context, n nVar, int i) {
        super(context);
        this.l = 50.0d;
        nVar.setOnSlideTouchListener(new a());
        this.k = i;
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        k kVar = new k(context, i);
        this.m = kVar;
        imageView.setImageDrawable(kVar);
        addView(imageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, 0, 0, (int) s.a(context, 30.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#00000000"), Color.parseColor("#80000000")});
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setGravity(17);
        textView.setShadowLayer(4.0f, 1.0f, 2.0f, Color.parseColor("#66000000"));
        textView.setText(getTitle());
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.n = textView2;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (int) s.a(context, 4.0f);
        layoutParams2.bottomMargin = (int) s.a(context, 26.0f);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        textView2.setShadowLayer(4.0f, 1.0f, 2.0f, Color.parseColor("#66000000"));
        textView2.setText("跳转详情页或第三方应用");
        linearLayout.addView(textView2);
        addView(linearLayout);
        this.f.add(textView);
        this.f.add(textView2);
    }

    private String getTitle() {
        int i = this.k;
        if (i != 1) {
            return i != 2 ? "向上滑动" : "向右滑动";
        }
        return "向左滑动";
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void c() {
    }

    @Override // com.ipd.dsp.internal.t1.c
    public int getAnimationDelayTime() {
        return 200;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public Animator getAnimator() {
        this.m.start();
        return null;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public View getInteractionView() {
        return null;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void setText(String str) {
        if (this.n == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.n.setText(String.format(Locale.getDefault(), "%s", str));
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void a() {
        super.a();
        this.m.stop();
    }

    public class a implements n.b {
        public a() {
        }

        @Override // com.ipd.dsp.internal.t1.n.b
        public void a(float f, float f2, float f3, float f4, com.ipd.dsp.internal.x1.a aVar) {
            View childAt;
            float f5 = f3 - f;
            float f6 = f4 - f2;
            boolean z = Math.abs(f5) >= Math.abs(f6);
            int i = l.this.k;
            if (i != 1) {
                if (i != 2) {
                    if (z || f6 >= 0.0f) {
                        return;
                    }
                } else if (!z || f5 <= 0.0f) {
                    return;
                }
            } else if (!z || f5 >= 0.0f) {
                return;
            }
            if (s.b(l.this.getContext(), (float) Math.hypot(f5, f6)) < 50.0d || (childAt = ((ViewGroup) l.this.getChildAt(1)).getChildAt(0)) == null) {
                return;
            }
            childAt.setTag(R.id.ipd_custom_key_1, Boolean.TRUE);
            childAt.setTag(R.id.ipd_custom_key_2, aVar);
            childAt.performClick();
        }

        @Override // com.ipd.dsp.internal.t1.n.b
        public void a(MotionEvent motionEvent, com.ipd.dsp.internal.x1.a aVar) {
            ViewGroup viewGroup = l.this;
            ViewParent parent = viewGroup.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            View viewA = j.a(viewGroup, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (viewA != null) {
                viewA.setTag(R.id.ipd_custom_key_1, Boolean.FALSE);
                viewA.setTag(R.id.ipd_custom_key_2, aVar);
                viewA.performClick();
            }
        }
    }
}
