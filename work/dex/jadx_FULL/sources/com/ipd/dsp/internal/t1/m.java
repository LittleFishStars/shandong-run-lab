package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class m extends b implements com.ipd.dsp.internal.s1.c {
    public final int k;
    public final double l;
    public final k m;
    public TextView n;

    public m(Context context, n nVar, int i) {
        super(context);
        this.l = 50.0d;
        nVar.setOnSlideTouchListener(new a());
        this.k = i;
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(context);
        k kVar = new k(context, i, 3);
        this.m = kVar;
        imageView.setImageDrawable(kVar);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setTextColor(-1);
        this.n.setTextSize(16.0f);
        this.n.setGravity(17);
        this.n.setText(String.format(Locale.getDefault(), getCTATextPrefix(), "跳转详情页/第三方应用"));
        frameLayout.addView(this.n, new FrameLayout.LayoutParams(-1, -1));
    }

    private String getCTATextPrefix() {
        return (this.k != 2 ? "向左滑动" : "向右滑动") + "或点击\n%s";
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
        this.n.setText(String.format(Locale.getDefault(), getCTATextPrefix(), str));
    }

    @Override // com.ipd.dsp.internal.t1.b
    public void a(String str) {
        if (this.n == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.n.setText(str);
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void a() {
        super.a();
        this.m.stop();
        this.n = null;
    }

    public class a implements n.b {
        public a() {
        }

        @Override // com.ipd.dsp.internal.t1.n.b
        public void a(float f, float f2, float f3, float f4, com.ipd.dsp.internal.x1.a aVar) {
            float f5 = f3 - f;
            float f6 = f4 - f2;
            boolean z = Math.abs(f5) >= Math.abs(f6);
            int i = m.this.k;
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
            if (s.b(m.this.getContext(), (float) Math.hypot(f5, f6)) >= 50.0d) {
                m.this.setTag(R.id.ipd_custom_key_1, Boolean.TRUE);
                m.this.setTag(R.id.ipd_custom_key_2, aVar);
                m.this.performClick();
            }
        }

        @Override // com.ipd.dsp.internal.t1.n.b
        public void a(MotionEvent motionEvent, com.ipd.dsp.internal.x1.a aVar) {
            ViewGroup viewGroup = m.this;
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
