package cj.mobile.wm;

import android.content.Context;
import android.widget.FrameLayout;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ud extends td {
    public com.wangmai.insightvision.openadsdk.n.g.b dex12;
    public final dc dex13;

    public ud(Context context, com.wangmai.insightvision.openadsdk.template.rendering.splash.a aVar, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, aVar, adSlot, iNativeAd);
        this.dex13 = new dc() { // from class: com.zj.adlib.qub
            @Override // cj.mobile.wm.dc
            public final void a() {
                this.f44301a.h();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.C()) {
            return;
        }
        ITemplateInteractionListener iTemplateInteractionListener = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexo;
        if (iTemplateInteractionListener != null) {
            iTemplateInteractionListener.onAdShake();
        }
        d();
        dexb(true);
    }

    @Override // cj.mobile.wm.td
    public void dex05() {
        super.dex05();
        if (a() != null) {
            a().setVisibility(0);
        }
        com.wangmai.insightvision.openadsdk.n.g.b bVar = new com.wangmai.insightvision.openadsdk.n.g.b(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa);
        this.dex12 = bVar;
        bVar.setShakeInfo(be.dexd(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) le.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa, 120.0f);
        this.dex12.setVisibility(0);
        this.dex12.setClickable(false);
        this.dex12.dexa(this.dex13, true);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.addView(this.dex12, layoutParams);
        this.dex09.setText(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa.getResources().getString(R.string.fanti_ad_splash_shake_tips_pre) + w1.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc, ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa));
    }
}
