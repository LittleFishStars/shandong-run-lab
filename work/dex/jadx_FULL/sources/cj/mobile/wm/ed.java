package cj.mobile.wm;

import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ed extends ad {
    public ed(Context context, com.wangmai.insightvision.openadsdk.template.rendering.feed.a aVar, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, aVar, adSlot, iNativeAd);
    }

    private void c() {
        AdSlot adSlot = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexd;
        String slotId = adSlot != null ? adSlot.getSlotId() : "";
        if (!o1.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc, slotId)) {
            dexa(this.dex04);
            dexb(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh);
            dexb(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg);
            return;
        }
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "isTouchJumpEnable: true, slotId = " + slotId);
        dexb(this.dex04);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexk = true;
    }

    @Override // cj.mobile.wm.ad
    public int a() {
        return R.layout.fanti_xadsdk_layout_feed_ad_lr;
    }

    @Override // cj.mobile.wm.ad
    public void b() {
        super.b();
        ViewGroup.LayoutParams layoutParams = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh.getLayoutParams();
        int i = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa.getResources().getDisplayMetrics().widthPixels;
        if (layoutParams != null) {
            int i2 = i / 3;
            layoutParams.width = i2;
            layoutParams.height = (i2 * 9) / 16;
        }
    }

    @Override // cj.mobile.wm.ad
    public void dex05() {
        super.dex05();
        c();
    }

    public boolean dex12() {
        return false;
    }

    public void dex13() {
        super.dex13();
        c();
    }
}
