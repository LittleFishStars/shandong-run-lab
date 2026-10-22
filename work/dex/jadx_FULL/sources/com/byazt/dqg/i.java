package com.byazt.dqg;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.vrg.DoubleColorBallAnimationView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 42})
public class i extends tt {
    public DoubleColorBallAnimationView m;
    public LinearLayout yp;
    public ImageView z;

    public i(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, boolean z) {
        super(tTBaseVideoActivity, icVar, z);
    }

    @Override // com.byazt.dqg.tt
    public void c() {
        super.c();
        this.z = new ImageView(this.tt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.z.setAdjustViewBounds(true);
        this.z.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.z.setLayoutParams(layoutParams);
        this.sp.addView(this.z);
        View view = new View(this.tt);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.sp.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.tt);
        this.yp = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.tt);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText("\"奖励发放中\"");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.m = new DoubleColorBallAnimationView(this.tt);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(pf.ve(this.tt, 60.0f), pf.ve(this.tt, 60.0f));
        layoutParams3.gravity = 17;
        this.m.setLayoutParams(layoutParams3);
        this.yp.addView(this.m);
        this.yp.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.yp.setLayoutParams(layoutParams4);
        this.sp.addView(this.yp);
        this.yp.setVisibility(8);
        String strTt = xd.tt(this.ve);
        if (TextUtils.isEmpty(strTt)) {
            return;
        }
        com.byazt.xky.tt.c(strTt).width(this.sp.getWidth()).height(this.sp.getHeight()).to(this.z);
    }

    public void tt() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.m;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.tt();
            this.yp.setVisibility(0);
        }
    }

    public void ve() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.m;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.ve();
            this.yp.setVisibility(8);
        }
    }
}
