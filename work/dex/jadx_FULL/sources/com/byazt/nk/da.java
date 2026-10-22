package com.byazt.nk;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.byazt.nr.eo;
import com.byazt.oq.DynamicLottieView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 72})
public class da implements sp<ViewGroup> {
    public final DynamicLottieView c;
    public final FrameLayout tt;

    public da(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar, String str, String str2) {
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.c = dynamicLottieView;
        dynamicLottieView.setAnimationsLoop(true);
        dynamicLottieView.setOnlyLoadNetImage(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.tt = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double dV = spVar.v();
        dV = dV == AudioStats.AUDIO_AMPLITUDE_NONE ? 1.0d : dV;
        double dOs = spVar.os();
        double d = dOs != AudioStats.AUDIO_AMPLITUDE_NONE ? dOs : 1.0d;
        if ("24".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/swiper_up_star.json" : str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.or.x.c(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.byazt.or.x.c(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if (!"20".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(str);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dV), (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d));
            layoutParams2.gravity = 17;
            frameLayout.setLayoutParams(layoutParams2);
            return;
        }
        dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/brush_mask.json" : str);
        c(context, frameLayout, spVar);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.byazt.or.x.c(context, spVar.lr() > 0 ? spVar.lr() : com.byazt.sr.uj.c() ? 0 : 120);
        frameLayout.setLayoutParams(layoutParams3);
        frameLayout.setClipChildren(false);
    }

    private void c(Context context, FrameLayout frameLayout, com.byazt.aq.sp spVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -eo.c(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("滑动或者点击擦亮");
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, eo.c(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText("跳转详情页或第三方应用");
        if (spVar != null && !TextUtils.isEmpty(spVar.lt())) {
            textView2.setText(spVar.lt());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.byazt.nk.sp
    public void tt() {
        try {
            this.c.sp();
            ViewParent parent = this.tt.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tt);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.nk.sp
    public ViewGroup ve() {
        return this.tt;
    }

    @Override // com.byazt.nk.sp
    public void c() {
        DynamicLottieView dynamicLottieView = this.c;
        if (dynamicLottieView != null) {
            dynamicLottieView.x();
        }
    }
}
