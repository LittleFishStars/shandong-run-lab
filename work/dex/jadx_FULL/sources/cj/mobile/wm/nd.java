package cj.mobile.wm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class nd extends gc {
    public com.wangmai.insightvision.openadsdk.template.rendering.reward.b dexi;

    public nd(Context context, AdSlot adSlot, INativeAd iNativeAd, ITemplateInteractionListener iTemplateInteractionListener) {
        super(context, adSlot, iNativeAd, iTemplateInteractionListener);
    }

    @Override // cj.mobile.wm.gc
    public InsightAdView dexa(Context context) {
        if (this.dexi == null) {
            this.dexi = new com.wangmai.insightvision.openadsdk.template.rendering.reward.b(this.dexa);
        }
        this.dexi.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return this.dexi;
    }

    public void dexa(boolean z) {
        com.wangmai.insightvision.openadsdk.o.a.a aVar = this.dexf;
        if (aVar != null) {
            ((od) aVar).dexd(z);
        }
    }

    @Override // cj.mobile.wm.gc
    public com.wangmai.insightvision.openadsdk.o.a.a dexb(Context context) {
        if (this.dexf == null) {
            this.dexf = new pd(this.dexa, this.dexd, this.dexe, this.dexc);
        }
        this.dexd.addView(LayoutInflater.from(this.dexa).inflate(((od) this.dexf).a(), (ViewGroup) null));
        return this.dexf;
    }

    public void dexe() {
        com.wangmai.insightvision.openadsdk.o.a.a aVar = this.dexf;
        if (aVar != null) {
            ((od) aVar).c();
        }
    }
}
