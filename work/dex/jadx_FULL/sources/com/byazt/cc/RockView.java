package com.byazt.cc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.s;
import com.byazt.nr.z;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 2068})
public class RockView extends LinearLayout {
    public ImageView c;
    public TextView tt;
    public TextView ve;

    @com.byazt.zqa.c(c = {0, 1, 448, 1454})
    public static class c implements Interpolator {
        private c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            return f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }
    }

    public RockView(Context context) {
        super(context);
        tt(context);
    }

    private void tt(Context context) {
        if (context == null) {
            context = gt.getContext();
        }
        View viewC = c(context);
        if (viewC == null) {
            return;
        }
        addView(viewC);
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 17;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        OvalShape ovalShape = new OvalShape();
        int iVe = pf.ve(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(iVe);
        shapeDrawable.setIntrinsicWidth(iVe);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setId(2114387566);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        z.c(context, "tt_splash_rock", this.c, 320);
        this.c.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.c);
        TextView textView = new TextView(context);
        this.tt = textView;
        textView.setId(2114387564);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.tt.setSingleLine();
        this.tt.setText("摇一摇");
        this.tt.setTextColor(-1);
        this.tt.setTextSize(14.0f);
        this.tt.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.tt);
        TextView textView2 = new TextView(context);
        this.ve = textView2;
        textView2.setId(2114387563);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.topMargin = pf.ve(context, 12.0f);
        this.ve.setLayoutParams(layoutParams5);
        this.ve.setText("前往详情页或第三方应用");
        this.ve.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.ve.setTextColor(-1);
        linearLayout.addView(this.ve);
        return linearLayout;
    }

    public void c(s sVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.tt;
        if (textView != null) {
            textView.setText(sVar.sl());
            this.tt.setTextSize(2, sVar.u().tt());
        }
        TextView textView2 = this.ve;
        if (textView2 != null) {
            textView2.setText(sVar.tt());
            this.ve.setTextSize(2, sVar.t().tt());
            this.ve.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void c() {
        if (this.c != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new c());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.cc.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.byazt.cc.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.c.startAnimation(rotateAnimation);
                        }
                    }, 250L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.c.startAnimation(rotateAnimation);
        }
    }
}
