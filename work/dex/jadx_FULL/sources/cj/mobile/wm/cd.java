package cj.mobile.wm;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.player.ui.InsightPlayerView;
import com.wangmai.insightvision.openadsdk.utils.DimenUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class cd extends ad {
    public View dex05;
    public ImageView dex06;
    public TextView dex07;
    public ObjectAnimator dex08;

    public class dexa extends ViewOutlineProvider {
        public final /* synthetic */ RelativeLayout dexa;

        public dexa(RelativeLayout relativeLayout) {
            this.dexa = relativeLayout;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (int) (this.dexa.getResources().getDisplayMetrics().density * 7.0f));
        }
    }

    public cd(Context context, com.wangmai.insightvision.openadsdk.template.rendering.feed.a aVar, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, aVar, adSlot, iNativeAd);
    }

    private void c() {
        this.dex05.setVisibility(be.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        ImageView imageView = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void e() {
        if (be.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc)) {
            dexu();
            fc.dexd().dexc();
        }
    }

    @Override // cj.mobile.wm.ad
    public int a() {
        return R.layout.fanti_xadsdk_layout_feed_ad_pause;
    }

    @Override // cj.mobile.wm.ad
    public void b() {
        super.b();
        RelativeLayout relativeLayout = (RelativeLayout) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.tm_feed_view_group);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        int iDpToPixel = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa.getResources().getDisplayMetrics().widthPixels - (((int) DimenUtil.dpToPixel(12.0f)) * 2);
        int i = (iDpToPixel * 9) / 16;
        if (layoutParams != null) {
            layoutParams.width = iDpToPixel;
            layoutParams.height = i;
        }
        relativeLayout.setOutlineProvider(new dexa(relativeLayout));
        relativeLayout.setClipToOutline(true);
    }

    @Override // cj.mobile.wm.ad
    public InsightPlayerView dex03() {
        return ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_video);
    }

    @Override // cj.mobile.wm.ad
    public ImageView dex04() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_mute);
    }

    @Override // cj.mobile.wm.ad
    public void dex05() {
        super.dex05();
        this.dex05 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_phone_shake_layout);
        this.dex06 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_phone_image_shake);
        this.dex07 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_phone_shake_text_view);
        this.dex02.setVisibility(8);
        InsightPlayerView insightPlayerView = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg;
        if (insightPlayerView != null) {
            insightPlayerView.setLooping(true);
        }
        c();
        dexb(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh);
        InsightPlayerView insightPlayerView2 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg;
        if (insightPlayerView2 != null) {
            insightPlayerView2.setVideoScaleMode(com.wangmai.insightvision.openadsdk.l.c.b);
            dexb(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg);
        }
    }

    public void dexf() {
        super.dexf();
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexy.postDelayed(new Runnable() { // from class: com.zj.adlib.zra
            @Override // java.lang.Runnable
            public final void run() {
                this.f46328a.d();
            }
        }, 500L);
    }

    public void dexi() {
        super.dexi();
        dext();
    }

    public void dexj() {
        super.dexj();
        e();
    }

    @SuppressLint({"Recycle"})
    public void dexr() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.dex06, Key.ROTATION, 0.0f, 20.0f, -30.0f, 20.0f, -10.0f, 0.0f);
        this.dex08 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(1000L);
        this.dex08.setStartDelay(333L);
        this.dex08.setRepeatCount(-1);
        this.dex08.setRepeatMode(1);
        this.dex08.start();
    }

    public void dexu() {
        ObjectAnimator objectAnimator = this.dex08;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.dex08.cancel();
    }
}
