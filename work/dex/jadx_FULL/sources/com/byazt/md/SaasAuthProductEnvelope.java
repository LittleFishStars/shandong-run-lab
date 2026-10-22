package com.byazt.md;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.aas.pf;
import com.byazt.ete.sv;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.fh.ve;
import com.byazt.xky.tt;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 1531})
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    public SaasAuthProductEnvelope(@NonNull Context context, sv.c cVar) {
        super(context);
        c(context, cVar);
    }

    private void c(Context context, sv.c cVar) {
        if (cVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutC = c(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            tt.c(ve.c("saas_reward_goods_bg.webp")).to(imageView);
        } catch (Error unused) {
        }
        relativeLayoutC.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387802);
        layoutParams.topMargin = pf.ve(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("超值好物");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        relativeLayoutC.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = pf.ve(context, 20.0f);
        textView2.setId(2114387462);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(pf.ve(context, 200.0f));
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(cVar.c());
        textView2.setTextColor(Color.parseColor("#161823"));
        relativeLayoutC.addView(textView2);
        int iVe = pf.ve(context, 80.0f);
        int iVe2 = pf.ve(context, 10.0f);
        ImageView tTRoundRectImageView = new TTRoundRectImageView(context, iVe2, iVe2);
        tTRoundRectImageView.setId(2114387456);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iVe, iVe);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.topMargin = pf.ve(context, 12.0f);
        tt.c(cVar.tt()).width(iVe).height(iVe).to(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(layoutParams3);
        relativeLayoutC.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387457);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, tTRoundRectImageView.getId());
        layoutParams4.topMargin = pf.ve(context, 12.0f);
        linearLayout.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("¥");
        linearLayout.addView(textView3);
        double dUj = cVar.uj();
        int iFloor = (int) Math.floor(dUj);
        int i = (int) ((dUj - ((double) iFloor)) * 100.0d);
        TextView textView4 = new TextView(context);
        textView4.setTextSize(2, 16.0f);
        textView4.setTypeface(null, 1);
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setText(String.valueOf(iFloor));
        linearLayout.addView(textView4);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(2, 11.0f);
        textView5.setTypeface(null, 1);
        textView5.setTextColor(Color.parseColor("#F93F3F"));
        StringBuilder sb = new StringBuilder(Consts.DOT);
        sb.append(i);
        sb.append(i >= 10 ? "" : "0");
        textView5.setText(sb.toString());
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("￥" + cVar.ve());
        linearLayout.addView(textView6);
        relativeLayoutC.addView(linearLayout);
        c(context, "一键关联抖音购买", relativeLayoutC);
        addView(relativeLayoutC);
    }

    @Override // com.byazt.md.BaseSaasEnvelope
    public void c() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt();
    }

    @Override // com.byazt.md.BaseSaasEnvelope
    public void tt() {
        super.tt();
    }
}
