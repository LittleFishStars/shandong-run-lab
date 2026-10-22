package cj.mobile.wm;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.player.ui.InsightPlayerView;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ad extends com.wangmai.insightvision.openadsdk.o.a.a {
    public TextView dex02;
    public ImageView dex03;
    public View dex04;

    public ad(Context context, InsightAdView insightAdView, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, insightAdView, adSlot, iNativeAd);
        View viewInflate = LayoutInflater.from(context).inflate(a(), (ViewGroup) null);
        this.dex04 = viewInflate;
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.addView(viewInflate);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa = context;
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc = iNativeAd;
    }

    private void c() {
        String title = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getTitle();
        if (TextUtils.isEmpty(title)) {
            this.dex02.setVisibility(8);
        } else {
            this.dex02.setVisibility(0);
            this.dex02.setText(title);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexe(View view) {
        dexw();
    }

    public abstract int a();

    public void b() {
        ViewGroup.LayoutParams layoutParams = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
            layoutParams.height = -2;
        }
    }

    public ImageView dex01() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_dsp_logo);
    }

    public TextView dex02() {
        return (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_txt_dsp_name);
    }

    public InsightPlayerView dex03() {
        return null;
    }

    public ImageView dex04() {
        return null;
    }

    public void dex05() {
        this.dex02 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_txt_title);
        this.dex03 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_close_view);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_video);
        this.dex03.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.jia
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f42596a.dexe(view);
            }
        });
        b();
        c();
    }

    public void dexa(int i, int i2, int i3, int i4) {
        super.dexa(i, i2, i3, i4);
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onSizeChanged: w = " + i + ", h = " + i2 + ", oldw = " + i3 + ", oldh = " + i4);
    }

    public ImageView dexz() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.feed_ad_image);
    }
}
