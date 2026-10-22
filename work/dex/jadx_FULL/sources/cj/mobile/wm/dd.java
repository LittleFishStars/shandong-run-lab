package cj.mobile.wm;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.player.ui.InsightPlayerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dd extends ad {
    public int dex05;
    public int dex06;

    public dd(Context context, com.wangmai.insightvision.openadsdk.template.rendering.feed.a aVar, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, aVar, adSlot, iNativeAd);
        this.dex05 = 0;
        this.dex06 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        InsightPlayerView insightPlayerView;
        ViewGroup.LayoutParams layoutParams;
        int iDexa = this.dex05 - (((int) le.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa, 1.0f)) * 2);
        ViewGroup.LayoutParams layoutParams2 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh.getLayoutParams();
        int i = (this.dex05 * 9) / 16;
        Log.e(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "resetContentView: contentWidth = " + iDexa + ", contentHeight = " + i);
        if (layoutParams2 != null) {
            layoutParams2.width = iDexa;
            layoutParams2.height = i;
        }
        if (dex12() && (insightPlayerView = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexg) != null && (layoutParams = insightPlayerView.getLayoutParams()) != null) {
            layoutParams.width = iDexa;
            layoutParams.height = i;
        }
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.getLayoutParams().width = this.dex05;
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.getLayoutParams().height = this.dex06 - ((((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh.getHeight() <= 0 || ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh.getHeight() - i <= 0) ? 0 : ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexh.getHeight() - i);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.requestLayout();
    }

    private void d() {
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.post(new Runnable() { // from class: com.zj.adlib.bva
            @Override // java.lang.Runnable
            public final void run() {
                this.f40848a.c();
            }
        });
    }

    private void e() {
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
        return R.layout.fanti_xadsdk_layout_feed_ad_bt;
    }

    @Override // cj.mobile.wm.ad
    public void dex05() {
        super.dex05();
        e();
    }

    public void dex13() {
        super.dex13();
        e();
    }

    @Override // cj.mobile.wm.ad
    public void dexa(int i, int i2, int i3, int i4) {
        super.dexa(i, i2, i3, i4);
        Log.e(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onSizeChanged: contentWidth = " + i + ", contentHeight = " + i2);
        if (this.dex05 == i) {
            return;
        }
        this.dex05 = i;
        this.dex06 = i2;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        d();
    }
}
