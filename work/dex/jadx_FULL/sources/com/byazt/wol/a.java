package com.byazt.wol;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ff.RoundImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 352, 34})
public class a implements com.byazt.lbn.c {
    private View c(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387804);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setColorFilter(2130706432, PorterDuff.Mode.SRC_OVER);
        imageView.setImageTintMode(PorterDuff.Mode.SRC_OVER);
        return imageView;
    }

    private View tt(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387961);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387664);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(pf.ve(context, 44.0f), pf.ve(context, 44.0f));
        layoutParams2.addRule(14);
        roundImageView.setLayoutParams(layoutParams2);
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        relativeLayout.addView(roundImageView);
        TextView textView = new TextView(context);
        textView.setId(2114387957);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(pf.ve(context, 44.0f), pf.ve(context, 44.0f));
        layoutParams3.addRule(8, 2114387664);
        layoutParams3.addRule(19, 2114387664);
        layoutParams3.addRule(5, 2114387664);
        layoutParams3.addRule(7, 2114387664);
        layoutParams3.addRule(18, 2114387664);
        layoutParams3.addRule(14);
        textView.setLayoutParams(layoutParams3);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#E0E0E0"));
        textView.setBackground(shapeDrawable);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(2, 19.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setVisibility(8);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387764);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, 2114387664);
        layoutParams4.addRule(14);
        layoutParams4.setMargins(0, pf.ve(context, 6.0f), 0, pf.ve(context, 20.0f));
        textView2.setLayoutParams(layoutParams4);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 12.0f);
        relativeLayout.addView(textView2);
        TextView textView3 = new TextView(context);
        textView3.setId(2114387686);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, pf.ve(context, 28.0f));
        layoutParams5.addRule(3, 2114387764);
        layoutParams5.addRule(14);
        layoutParams5.addRule(15);
        layoutParams5.setMargins(0, 0, 0, 0);
        textView3.setLayoutParams(layoutParams5);
        textView3.setMinWidth(pf.ve(context, 72.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2A90D7"));
        gradientDrawable.setCornerRadius(pf.ve(context, 6.0f));
        textView3.setBackground(gradientDrawable);
        textView3.setGravity(17);
        textView3.setPadding(pf.ve(context, 2.0f), pf.ve(context, 2.0f), pf.ve(context, 2.0f), pf.ve(context, 2.0f));
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 14.0f);
        textView3.setVisibility(8);
        relativeLayout.addView(textView3);
        return relativeLayout;
    }

    private View ve(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387674);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387868);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(580, 98);
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, pf.ve(context, 20.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#D33F57"));
        gradientDrawable.setCornerRadius(4.0f);
        textView.setBackground(gradientDrawable);
        textView.setGravity(17);
        textView.setPadding(pf.ve(context, 2.0f), pf.ve(context, 2.0f), pf.ve(context, 2.0f), pf.ve(context, 2.0f));
        textView.setTextColor(-1);
        textView.setTextSize(0, 34.0f);
        textView.setText("立即下载");
        textView.setVisibility(8);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387842);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387868);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, 60, 0, 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setText("点击重播");
        textView2.setTextColor(-1);
        textView2.setTextSize(0, 34.0f);
        relativeLayout.addView(textView2);
        return relativeLayout;
    }

    @Override // com.byazt.lbn.c
    public View inflate(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387744);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-15066598);
        relativeLayout.addView(c(context));
        relativeLayout.addView(tt(context));
        relativeLayout.addView(ve(context));
        return relativeLayout;
    }
}
