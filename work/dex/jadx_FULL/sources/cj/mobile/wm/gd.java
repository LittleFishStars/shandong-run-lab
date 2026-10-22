package cj.mobile.wm;

import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.player.ui.InsightPlayerView;
import com.wangmai.insightvision.openadsdk.utils.DimenUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class gd extends ad {
    public gd(Context context, com.wangmai.insightvision.openadsdk.template.rendering.feed.a aVar, AdSlot adSlot, INativeAd iNativeAd) {
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
        return R.layout.fanti_xadsdk_layout_feed_ad_ss;
    }

    @Override // cj.mobile.wm.ad
    public void b() {
        InsightPlayerView insightPlayerView;
        ViewGroup.LayoutParams layoutParams;
        super.b();
        ViewGroup.LayoutParams layoutParams2 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh.getLayoutParams();
        int iDpToPixel = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa.getResources().getDisplayMetrics().widthPixels - (((int) DimenUtil.dpToPixel(12.0f)) * 2);
        int i = (iDpToPixel * 9) / 16;
        if (layoutParams2 != null) {
            layoutParams2.width = iDpToPixel;
            layoutParams2.height = i;
        }
        if (!dex12() || (insightPlayerView = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg) == null || (layoutParams = insightPlayerView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = iDpToPixel;
        layoutParams.height = i;
    }

    @Override // cj.mobile.wm.ad
    public void dex05() {
        super.dex05();
        c();
    }

    public void dex13() {
        super.dex13();
        c();
    }
}
