package cj.mobile.wm;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
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
public class zd extends com.wangmai.insightvision.openadsdk.o.a.a {
    public boolean dex02;
    public boolean dex03;
    public View dex04;
    public ImageView dex05;
    public View dex06;
    public TextView dex07;

    public class dexa extends com.wangmai.insightvision.openadsdk.o.a.a.dexg {
        public dexa() {
        }

        public void dexa(boolean z, Bitmap bitmap, String str) {
            ImageView imageView;
            int i;
            if (!z || bitmap == null) {
                imageView = zd.this.dex05;
                i = 8;
            } else {
                zd.this.dex05.setImageBitmap(bitmap);
                imageView = zd.this.dex05;
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }

    public zd(Context context, InsightAdView insightAdView, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, insightAdView, adSlot, iNativeAd);
        this.dex02 = true;
        this.dex03 = false;
    }

    private void b() {
        String title = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.dex07.setText(title);
            this.dex07.setVisibility(0);
        }
        if (this.dex05 == null) {
            return;
        }
        String adLogoUrl = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getAdLogoUrl();
        if (TextUtils.isEmpty(adLogoUrl)) {
            this.dex05.setVisibility(8);
        } else {
            dexa(adLogoUrl, new dexa());
        }
    }

    private void c() {
        dexa((ViewGroup) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_shake_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexe(View view) {
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.setVisibility(8);
        dexw();
    }

    public void a() {
        dexb(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh);
        dexb(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg);
    }

    public ImageView dex01() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_dsp_logo);
    }

    public TextView dex02() {
        return (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_txt_dsp_name);
    }

    public InsightPlayerView dex03() {
        return ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_video_view);
    }

    public ImageView dex04() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_mute_view);
    }

    public void dex05() {
        InsightAdView insightAdView = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb;
        if (insightAdView == null) {
            dexa(20004, "根视图为空");
            return;
        }
        this.dex04 = insightAdView.findViewById(R.id.fanti_ad_click_message_container_ex);
        this.dex05 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_logo_image_view);
        this.dex06 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_close_view);
        this.dex07 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_logo_text_view);
        this.dex06.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.a6c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f40462a.dexe(view);
            }
        });
        if (be.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc)) {
            c();
        }
        a();
        b();
    }

    public ImageView dexz() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_image_view);
    }
}
