package cj.mobile.wm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class sd extends gc {
    public boolean dexi;

    public sd(Context context, AdSlot adSlot, INativeAd iNativeAd, boolean z, ITemplateInteractionListener iTemplateInteractionListener) {
        super(context, adSlot, iNativeAd, iTemplateInteractionListener);
        this.dexi = z;
    }

    private td dexe() {
        this.dexd.addView(LayoutInflater.from(this.dexa).inflate(R.layout.fanti_xadsdk_layout_splash_ad_stub_default, (ViewGroup) null));
        return new ud(this.dexa, this.dexd, this.dexe, this.dexc);
    }

    private td dexf() {
        this.dexd.addView(LayoutInflater.from(this.dexa).inflate(R.layout.fanti_xadsdk_layout_splash_ad_stub_default, (ViewGroup) null));
        return new vd(this.dexa, this.dexd, this.dexe, this.dexc);
    }

    private td dexg() {
        return be.dexa(this.dexc) ? dexe() : dexf();
    }

    @Override // cj.mobile.wm.gc
    public InsightAdView dexa(Context context) {
        com.wangmai.insightvision.openadsdk.template.rendering.splash.a aVar = new com.wangmai.insightvision.openadsdk.template.rendering.splash.a(this.dexa);
        aVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return aVar;
    }

    @Override // cj.mobile.wm.gc
    public com.wangmai.insightvision.openadsdk.o.a.a dexb(Context context) {
        return dexg();
    }
}
