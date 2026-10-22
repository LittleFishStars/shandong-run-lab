package com.byazt.dqg;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.nr.z;
import com.ipd.dsp.internal.v1.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 340})
public class RewardAuthToastLayout extends RelativeLayout {
    public RewardAuthToastLayout(Context context, int i) {
        super(context);
        c(context, i);
    }

    private void c(Context context, int i) {
        setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, pf.ve(context, 36.0f));
        layoutParams.topMargin = pf.ve(context, 160.0f);
        setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#55161823"));
        gradientDrawable.setCornerRadius(pf.ve(context, 50.0f));
        linearLayout.setBackground(gradientDrawable);
        layoutParams2.addRule(14);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout);
        ImageView imageView = new ImageView(context);
        z.c(context, "tt_reward_auth_gold_icon", imageView, 160);
        int iVe = pf.ve(context, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iVe, iVe);
        layoutParams3.leftMargin = pf.ve(context, 12.0f);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(layoutParams3);
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setTypeface(null, 1);
        textView.setText("授权抖音账号得" + i + "金币");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = pf.ve(context, 8.0f);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams4);
        linearLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        z.c(context, "tt_ic_top_arrow_right", imageView2, 160);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, iVe);
        layoutParams5.rightMargin = pf.ve(context, 12.0f);
        imageView2.setLayoutParams(layoutParams5);
        linearLayout.addView(imageView2);
        postDelayed(new Runnable() { // from class: com.byazt.dqg.RewardAuthToastLayout.1
            @Override // java.lang.Runnable
            public void run() {
                RewardAuthToastLayout.this.setVisibility(0);
            }
        }, b.C0923b.f);
        postDelayed(new Runnable() { // from class: com.byazt.dqg.RewardAuthToastLayout.2
            @Override // java.lang.Runnable
            public void run() {
                RewardAuthToastLayout.this.setVisibility(8);
            }
        }, 5500L);
    }
}
