package com.kc.dw.platform.ad_adapter.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.kc.dw.ad.interstitial.d;
import com.kc.dw.ad.interstitial.f;
import com.kc.dw.ad.interstitial.g;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.kc.dw.core.ad.interstitial.InterstitialAdListener;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.router.log.bean.CodeMsg;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdInterstitialAdAdapter extends InterstitialAd {
    private InterstitialAdListener apiAdListener;
    private g interstitialAd;

    public SsdInterstitialAdAdapter(g gVar, InterstitialAdListener interstitialAdListener) {
        super(null, "SSD");
        this.interstitialAd = gVar;
        this.apiAdListener = interstitialAdListener;
    }

    public InterstitialAdListener getAdListener() {
        return this.apiAdListener;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCid(this.interstitialAd.a().getCid());
        resultBean.setCat(this.interstitialAd.a().getCat());
        resultBean.setAderId(this.interstitialAd.a().getAder_id());
        resultBean.setFromId(this.interstitialAd.a().getFromId());
        resultBean.setDrawing(this.interstitialAd.a().getDrawing());
        resultBean.setPid(this.interstitialAd.a().getPosId());
        resultBean.setReqId(this.interstitialAd.a().getReq_id());
        resultBean.setPrice(this.interstitialAd.a().getEcpm());
        resultBean.setEcpm(this.interstitialAd.a().getEcpm() + "");
        resultBean.setS_code(this.interstitialAd.a().getS_code());
        resultBean.setS_ext(this.interstitialAd.a().getS_ext());
        resultBean.setSdkName("SSD");
        resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.interstitialAd.a()));
        return resultBean;
    }

    public String getDeepLink() {
        if (com.kc.dw.core.utils.a.a(this.interstitialAd.a().getAder_id())) {
            return this.interstitialAd.a().getDeep_link();
        }
        return null;
    }

    public String[] getImgUrls() {
        if (com.kc.dw.core.utils.a.a(this.interstitialAd.a().getAder_id())) {
            return this.interstitialAd.a().getImageUrls();
        }
        return null;
    }

    public boolean getIsOperationContent() {
        return com.kc.dw.core.utils.a.a(this.interstitialAd.a().getAder_id());
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = this.interstitialAd.a().getExpire_timestamp();
            return SystemClock.uptimeMillis() - this.interstitialAd.a().getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.kc.dw.core.ad.interstitial.InterstitialAd, com.kc.dw.core.ad.interstitial.IInterstitialAd
    public void render() {
        g gVar = this.interstitialAd;
        if (gVar != null) {
            try {
                if (gVar.h != 0) {
                    return;
                }
                gVar.h = System.currentTimeMillis();
                com.kc.dw.core.service.logrecord.a.a(5, "e5", gVar.f39103a, new CodeMsg().setData(gVar.isAutoRender() ? 1 : 2, ""));
                if (gVar.getAdView() != null) {
                    gVar.getAdView().getContext();
                }
                Context context = gVar.f39103a.getContext();
                Activity activity = context instanceof Activity ? (Activity) context : null;
                b bVar = gVar.f39103a;
                if (bVar != null && activity != null) {
                    com.kc.dw.core.service.logrecord.a.a(5, "e4", bVar);
                    if (gVar.a().getAdPatternType() == 2) {
                        z.a(gVar.a().getImageUrls()[0], new d(gVar, activity));
                        return;
                    }
                    String str = gVar.a().getImageUrls()[0];
                    if (gVar.h == 0) {
                        gVar.h = System.currentTimeMillis();
                    }
                    c0.a(str, new f(gVar, str, activity));
                    return;
                }
                com.kc.dw.ad.interstitial.a aVar = gVar.b;
                if (aVar != null) {
                    ((a) aVar).onAdRenderFail("插屏渲染失败1", com.kc.dw.core.exception.b.c.intValue());
                }
            } catch (Throwable th) {
                LogUtil.e("NativeInterstitialAd", "render error", th);
                com.kc.dw.ad.interstitial.a aVar2 = gVar.b;
                if (aVar2 != null) {
                    ((a) aVar2).onAdRenderFail("插屏渲染失败2", com.kc.dw.core.exception.b.c.intValue());
                }
            }
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(com.kc.dw.base.a.getContext(), this.interstitialAd.a().getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(com.kc.dw.base.a.getContext(), this.interstitialAd.a().getWinUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        super.setInteractionListener(interactionListener);
        g gVar = this.interstitialAd;
        if (gVar != null) {
            gVar.setInteractionListener(interactionListener);
        }
    }

    public void setInterstitialAd(g gVar) {
        this.interstitialAd = gVar;
    }

    @Override // com.kc.dw.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        g gVar = this.interstitialAd;
        if (gVar != null) {
            try {
                if (gVar.isAutoRender() || gVar.h != 0) {
                    gVar.a(activity);
                } else {
                    LogUtil.w("NativeInterstitialAd", "插屏渲染失败3. show方法应在收到renderSuccess后调用。(autoRender为false时)请在收到loadSuccess后，调用render接口");
                    com.kc.dw.ad.interstitial.a aVar = gVar.b;
                    if (aVar != null) {
                        ((a) aVar).onAdRenderFail("插屏渲染失败3. show方法应在收到renderSuccess后调用。(autoRender为false时)请在收到loadSuccess后，调用render接口", 9000002);
                    }
                }
            } catch (Exception e) {
                com.kc.dw.ad.interstitial.a aVar2 = gVar.b;
                if (aVar2 != null) {
                    ((a) aVar2).onAdRenderFail("插屏渲染失败,showAd", com.kc.dw.core.exception.b.c.intValue());
                }
                e.printStackTrace();
            }
        }
    }
}
