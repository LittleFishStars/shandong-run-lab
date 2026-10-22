package com.ltmb.gromoreadapter;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawNativeEventListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTAdDrawGroMoreExpressAd extends MediationCustomNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LTDrawAd f40269a;
    public final Context b;
    public DrawAdKeView c;

    public LTAdDrawGroMoreExpressAd(Context context, LTDrawAd lTDrawAd) {
        this.f40269a = lTDrawAd;
        this.b = context;
        setExpressAd(true);
        lTDrawAd.setLTAdEventListener(new LTAdDrawNativeEventListener() { // from class: com.ltmb.gromoreadapter.LTAdDrawGroMoreExpressAd.1
            public void onAdClicked() {
                LTAdDrawGroMoreExpressAd.this.callAdClick();
            }

            public void onAdRenderFail(int i, String str) {
                LTAdDrawGroMoreExpressAd.this.callRenderFail(null, i, str);
            }

            public void onAdShow() {
                LTAdDrawGroMoreExpressAd.this.callAdShow();
            }

            public void onClosed() {
                LTAdDrawGroMoreExpressAd.this.callDislikeSelected(-1, "ks信息流模板dislike接口无关闭原因");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
        super.render();
        if (this.f40269a == null) {
            callRenderFail(null, 0, "render fail");
        } else {
            this.c = new DrawAdKeView(this.b, this.f40269a);
            callRenderSuccess(-1.0f, -2.0f);
        }
    }
}
