package com.byazt.wol;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ff.RoundImageView;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 352, 20})
public abstract class c implements com.byazt.lbn.c {
    public RelativeLayout c(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        if (i != 0) {
            relativeLayout.setId(i);
        }
        return relativeLayout;
    }

    public View tt(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387911);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pf.ve(context, 66.0f), pf.ve(context, 66.0f));
        layoutParams.addRule(14);
        if (i != 0) {
            layoutParams.setMargins(0, pf.ve(context, i), 0, 0);
        }
        relativeLayout.setLayoutParams(layoutParams);
        z.c(context, "tt_live_avatar_bg", relativeLayout, 320);
        View roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387831);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(pf.ve(context, 65.0f), pf.ve(context, 65.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        roundImageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(roundImageView);
        View imageView = new ImageView(context);
        imageView.setId(2114387608);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(pf.ve(context, 42.0f), pf.ve(context, 18.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(12);
        imageView.setLayoutParams(layoutParams3);
        z.c(context, "tt_live_ad_status_icon", imageView, 320);
        relativeLayout.addView(imageView);
        return relativeLayout;
    }

    public View c(Context context, int i, int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, pf.ve(context, 44.0f));
        layoutParams.addRule(12);
        layoutParams.setMargins(pf.ve(context, 40.0f), 0, pf.ve(context, 40.0f), pf.ve(context, i));
        relativeLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(pf.ve(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(17);
        View imageView = new ImageView(context);
        imageView.setId(2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(pf.ve(context, 14.0f), pf.ve(context, 16.0f));
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, pf.ve(context, i2), 0);
        imageView.setLayoutParams(layoutParams2);
        z.c(context, "tt_live_ad_loading_btn_status", imageView, 320);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387752);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387876);
        layoutParams3.addRule(17, 2114387876);
        layoutParams3.addRule(15);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText("进入直播间");
        textView.setTextColor(-1);
        relativeLayout.addView(textView);
        View imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(pf.ve(context, 14.0f), pf.ve(context, 16.0f));
        layoutParams4.addRule(1, 2114387752);
        layoutParams4.addRule(13);
        layoutParams4.setMargins(0, 0, pf.ve(context, 6.0f), 0);
        imageView2.setLayoutParams(layoutParams4);
        z.c(context, "tt_splash_click_bar_go", imageView2, 320);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
