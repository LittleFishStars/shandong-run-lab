package com.byazt.wol;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 352, 15})
public class uj extends c {
    private View c(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, pf.ve(context, 32.0f));
        layoutParams.addRule(3, 2114387807);
        layoutParams.addRule(14);
        layoutParams.topMargin = pf.ve(context, 17.0f);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(pf.ve(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setMinimumWidth(pf.ve(context, 110.0f));
        View imageView = new ImageView(context);
        imageView.setId(2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(pf.ve(context, 12.0f), pf.ve(context, 14.0f));
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = pf.ve(context, 6.0f);
        imageView.setLayoutParams(layoutParams2);
        z.c(context, "tt_live_ad_loading_btn_status", imageView, 320);
        TextView textView = new TextView(context);
        textView.setId(2114387752);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387876);
        layoutParams3.addRule(17, 2114387876);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText("进入直播间");
        textView.setTextColor(-1);
        textView.setTextSize(2, 11.0f);
        textView.setLayoutParams(layoutParams3);
        View imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(pf.ve(context, 12.0f), pf.ve(context, 14.0f));
        layoutParams4.addRule(13);
        layoutParams4.addRule(1, 2114387752);
        layoutParams4.addRule(17, 2114387752);
        imageView2.setLayoutParams(layoutParams4);
        z.c(context, "tt_splash_click_bar_go", imageView2, 320);
        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    @Override // com.byazt.lbn.c
    public View inflate(Context context) {
        RelativeLayout relativeLayoutC = c(context, 2114387616);
        relativeLayoutC.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        relativeLayoutC.addView(relativeLayout, layoutParams);
        relativeLayout.addView(tt(context, 0));
        TextView textView = new TextView(context);
        textView.setId(2114387742);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387911);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, pf.ve(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387807);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387742);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, pf.ve(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText("数据加载中...");
        relativeLayout.addView(textView2);
        relativeLayout.addView(c(context));
        return relativeLayoutC;
    }
}
