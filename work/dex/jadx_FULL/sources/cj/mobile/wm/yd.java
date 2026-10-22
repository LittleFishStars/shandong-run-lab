package cj.mobile.wm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.IImageInfo;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.IVideoInfo;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class yd extends gc {
    public zd dexi;

    public yd(Context context, AdSlot adSlot, INativeAd iNativeAd, ITemplateInteractionListener iTemplateInteractionListener) {
        super(context, adSlot, iNativeAd, iTemplateInteractionListener);
    }

    private void dexa(com.wangmai.insightvision.openadsdk.template.rendering.table.b bVar) {
        int width;
        int height;
        int i;
        int i2;
        IVideoInfo videoInfo = this.dexc.getVideoInfo();
        IImageInfo imageInfo = this.dexc.getImageInfo();
        if (imageInfo != null) {
            width = imageInfo.getWidth();
            height = imageInfo.getHeight();
        } else {
            width = 0;
            height = 0;
        }
        if (videoInfo != null) {
            width = videoInfo.getWidth();
            height = videoInfo.getHeight();
        }
        int i3 = this.dexa.getResources().getDisplayMetrics().widthPixels;
        int i4 = this.dexa.getResources().getDisplayMetrics().heightPixels;
        if (i3 > i4) {
            i2 = (int) (i4 * 0.8f);
            i = (width * i2) / height;
        } else {
            int i5 = (int) (i3 * 0.8f);
            int i6 = (height * i5) / width;
            i = i5;
            i2 = i6;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams == null) {
            bVar.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
    }

    @Override // cj.mobile.wm.gc
    public InsightAdView dexa(Context context) {
        com.wangmai.insightvision.openadsdk.template.rendering.table.b bVar = new com.wangmai.insightvision.openadsdk.template.rendering.table.b(context);
        bVar.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        dexa(bVar);
        return bVar;
    }

    @Override // cj.mobile.wm.gc
    public com.wangmai.insightvision.openadsdk.o.a.a dexb(Context context) {
        return dexe();
    }

    public zd dexe() {
        this.dexi = new zd(this.dexd.getContext(), this.dexd, this.dexe, this.dexc);
        this.dexd.addView(LayoutInflater.from(this.dexa).inflate(R.layout.fanti_xadsdk_layout_table_screen_ad, (ViewGroup) null));
        return this.dexi;
    }
}
