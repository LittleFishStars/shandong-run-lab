package com.byazt.md;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.byazt.aas.pf;
import com.byazt.ete.sv;
import com.byazt.fh.ve;
import com.byazt.xky.tt;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 2294})
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {
    public TextView c;

    public SaasAuthCouponEnvelope(@NonNull Context context, sv.tt ttVar) {
        super(context);
        c(context, ttVar);
    }

    private void c(Context context, sv.tt ttVar) {
        if (ttVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutC = c(context);
        ImageView imageView = new ImageView(context);
        try {
            tt.c(ve.c("saas_reward_coupon_bg.webp")).to(imageView);
        } catch (Error unused) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayoutC.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387802);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = pf.ve(context, 20.0f);
        textView.setText("优惠券");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        relativeLayoutC.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387461);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        this.c = textView2;
        textView2.setId(2114387460);
        this.c.setText(String.valueOf(ttVar.c()));
        this.c.setTextColor(Color.parseColor("#F93F3F"));
        this.c.setTextSize(2, 60.0f);
        linearLayout.addView(this.c, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("元");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        relativeLayoutC.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387459);
        textView4.setText("满" + ttVar.tt() + "元可用");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = pf.ve(context, -4.0f);
        relativeLayoutC.addView(textView4, layoutParams3);
        TextView textView5 = new TextView(context);
        textView5.setText("领取后30分钟内有效");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, textView4.getId());
        layoutParams4.topMargin = pf.ve(context, 8.0f);
        relativeLayoutC.addView(textView5, layoutParams4);
        c(context, "一键关联抖音领取", relativeLayoutC);
        addView(relativeLayoutC);
    }

    @Override // com.byazt.md.BaseSaasEnvelope
    public void tt() {
        setVisibility(8);
        super.tt();
    }

    @Override // com.byazt.md.BaseSaasEnvelope
    public void c() {
        setVisibility(0);
    }
}
