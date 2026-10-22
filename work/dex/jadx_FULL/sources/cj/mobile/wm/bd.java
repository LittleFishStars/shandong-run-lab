package cj.mobile.wm;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.entity.insight.AdApkInfo;
import com.wangmai.insightvision.openadsdk.player.ui.InsightPlayerView;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.wangmai.insightvision.openadsdk.utils.DimenUtil;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class bd extends ad {
    public ImageView dex05;
    public TextView dex06;
    public TextView dex07;
    public View dex08;
    public ImageView dex09;
    public TextView dex10;
    public LinearLayout dex11;
    public ObjectAnimator dex12;

    public class dexa extends com.wangmai.insightvision.openadsdk.o.a.a.dexg {
        public dexa() {
        }

        public void dexa(boolean z, Bitmap bitmap, String str) {
            if (!z || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bd.this.dex05.setImageBitmap(bitmap);
            bd.this.dex05.setVisibility(0);
        }
    }

    public bd(Context context, com.wangmai.insightvision.openadsdk.template.rendering.feed.a aVar, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, aVar, adSlot, iNativeAd);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void d() {
        String str;
        AdApkInfo adApkInfoF = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.f();
        if (adApkInfoF != null) {
            String packageName = adApkInfoF.getPackageName();
            str = (TextUtils.isEmpty(packageName) || he.dexd(InsightProxy.getApplication(), packageName) == null) ? "立即下载" : "打开应用";
        } else {
            str = "查看详情";
        }
        this.dex07.setText(str);
        dexb(this.dex07);
    }

    private int dexa(String str, int i) {
        String str2;
        Map extMap = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexd.getExtMap();
        if (extMap != null && extMap.containsKey(str) && (str2 = (String) extMap.get(str)) != null && !str2.isEmpty()) {
            try {
                return Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                f1.dexb("FeedCountDownTemplateA", "Invalid value for " + str + ": " + str2, e);
            }
        }
        return i;
    }

    private void e() {
        Map extMap = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexd.getExtMap();
        if (extMap == null || extMap.isEmpty()) {
            return;
        }
        int iDexa = dexa("ad_margin_top", 70);
        int iDexa2 = dexa("ad_margin_right", 20);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dex08.getLayoutParams();
        layoutParams.topMargin = (int) DimenUtil.dpToPixel(iDexa);
        float f = iDexa2;
        layoutParams.rightMargin = (int) DimenUtil.dpToPixel(f);
        int iDexa3 = dexa("ad_margin_left", 20);
        int iDexa4 = dexa("ad_margin_bottom", 100);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dex11.getLayoutParams();
        layoutParams2.leftMargin = (int) DimenUtil.dpToPixel(iDexa3);
        layoutParams2.rightMargin = (int) DimenUtil.dpToPixel(f);
        layoutParams2.bottomMargin = (int) DimenUtil.dpToPixel(iDexa4);
    }

    private void f() {
        this.dex08.setVisibility(be.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        ImageView imageView = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void h() {
        com.wangmai.insightvision.openadsdk.common.f fVar = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc;
        String adLogoUrl = (fVar.f() == null || TextUtils.isEmpty(fVar.f().getAppIconUrl())) ? fVar.getAdLogoUrl() : fVar.f().getAppIconUrl();
        this.dex05.setVisibility(8);
        if (TextUtils.isEmpty(adLogoUrl)) {
            return;
        }
        dexa(adLogoUrl, new dexa());
    }

    private void i() {
        if (be.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc)) {
            dexu();
            fc.dexd().dexc();
        }
    }

    @Override // cj.mobile.wm.ad
    public int a() {
        return R.layout.fanti_xadsdk_layout_feed_count_down_ad;
    }

    @Override // cj.mobile.wm.ad
    public void b() {
        ViewGroup.LayoutParams layoutParams = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
    }

    public void c() {
        if (dex12()) {
            if (((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg.getInsightPlayer() == null || ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg.getInsightPlayer().b() != com.wangmai.insightvision.openadsdk.l.d.i.g) {
                dex07();
            } else {
                dexo();
            }
        }
    }

    @Override // cj.mobile.wm.ad
    public InsightPlayerView dex03() {
        return ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_video);
    }

    @Override // cj.mobile.wm.ad
    public void dex05() {
        super.dex05();
        this.dex05 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_app_image_logo);
        this.dex06 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_txt_subtitle);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg.setVideoScaleMode(com.wangmai.insightvision.openadsdk.l.c.b);
        this.dex07 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_btn_download);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg.setLooping(true);
        this.dex08 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_phone_shake_layout);
        this.dex09 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_phone_image_shake);
        this.dex10 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_phone_shake_text_view);
        this.dex11 = (LinearLayout) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_app_info_layout);
        String subtitle = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getSubtitle();
        if (!TextUtils.isEmpty(subtitle)) {
            this.dex06.setText(subtitle);
        }
        this.dex06.setVisibility(TextUtils.isEmpty(subtitle) ? 8 : 0);
        d();
        h();
        f();
        e();
    }

    public void dexf() {
        super.dexf();
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexy.postDelayed(new Runnable() { // from class: com.zj.adlib.ona
            @Override // java.lang.Runnable
            public final void run() {
                this.f43789a.g();
            }
        }, 500L);
    }

    public void dexi() {
        super.dexi();
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onViewAttachedToWindow ... " + this);
        c();
        dext();
    }

    public void dexj() {
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onViewDetachedFromWindow ... " + this);
        super.dexj();
        if (dex12()) {
            dexl();
        }
        i();
    }

    @SuppressLint({"Recycle"})
    public void dexr() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.dex09, Key.ROTATION, 0.0f, 20.0f, -30.0f, 20.0f, -10.0f, 0.0f);
        this.dex12 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(1000L);
        this.dex12.setStartDelay(333L);
        this.dex12.setRepeatCount(-1);
        this.dex12.setRepeatMode(1);
        this.dex12.start();
    }

    public void dexu() {
        ObjectAnimator objectAnimator = this.dex12;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.dex12.cancel();
    }

    public boolean dexv() {
        return true;
    }

    public rb dexx() {
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "createInsightPlayer ... " + this);
        rb rbVarDexa = pb.dexc().dexa();
        rbVarDexa.dexb(dexv());
        return rbVarDexa;
    }
}
