package com.kc.dw.core.ad.paster;

import android.os.Handler;
import android.os.SystemClock;
import com.kc.dw.ad.nativ.IPreparedListener;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PasterAdImpl extends a implements PasterAd {
    private com.kc.dw.ad.nativ.a adListener;
    private i nativeAdSlot;

    public PasterAdImpl(b bVar, i iVar) {
        super(null, "SSD");
        this.adWrapper = bVar;
        this.nativeAdSlot = iVar;
    }

    public PasterAdImpl(b bVar, String str) {
        super(bVar, str);
        this.adWrapper = bVar;
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void destroy() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).c();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public long getCurrentPosition() {
        try {
            if (getAdView() instanceof NormalMediaView) {
                return ((NormalMediaView) getAdView()).getCurrentPosition();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(this.nativeAdSlot.getCid());
            resultBean.setCat(this.nativeAdSlot.getCat());
            resultBean.setAderId(this.nativeAdSlot.getAder_id());
            resultBean.setFromId(this.nativeAdSlot.getFromId());
            resultBean.setDrawing(this.nativeAdSlot.getDrawing());
            resultBean.setPid(this.nativeAdSlot.getPosId());
            resultBean.setReqId(this.nativeAdSlot.getReq_id());
            resultBean.setPrice(this.nativeAdSlot.getEcpm());
            resultBean.setEcpm(String.valueOf(this.nativeAdSlot.getEcpm()));
            resultBean.setS_ext(this.nativeAdSlot.getS_ext());
            resultBean.setS_code(this.nativeAdSlot.getS_code());
            resultBean.setSdkName("SSD");
            resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.nativeAdSlot));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBean;
    }

    public String getDeepLink() {
        try {
            if (com.kc.dw.core.utils.a.a(this.nativeAdSlot.getAder_id())) {
                return this.nativeAdSlot.getDeep_link();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public long getDuration() {
        try {
            if (getAdView() instanceof NormalMediaView) {
                return ((NormalMediaView) getAdView()).getDuration();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public String[] getImgUrls() {
        try {
            return com.kc.dw.core.utils.a.a(this.nativeAdSlot.getAder_id()) ? this.nativeAdSlot.getImageUrls() : new String[0];
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public boolean getIsOperationContent() {
        try {
            return com.kc.dw.core.utils.a.a(this.nativeAdSlot.getAder_id());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = this.nativeAdSlot.getExpire_timestamp();
            return SystemClock.uptimeMillis() - this.nativeAdSlot.getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void mute() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).f();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void onPause() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).pause();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void onResume() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).resume();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void pause() {
        onPause();
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void render() {
        com.kc.dw.core.service.logrecord.a.a(5, "e5", this.adWrapper, new TypeMsg().setData(2));
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void replay() {
        if (getAdView() instanceof NormalMediaView) {
            new Handler().postDelayed(new j(this) { // from class: com.kc.dw.core.ad.paster.PasterAdImpl.1
                public final PasterAdImpl this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.safe.j
                public void safeRun() {
                    ((NormalMediaView) this.this$0.getAdView()).replay();
                }
            }, 300L);
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void resume() {
        onResume();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(this.adWrapper.getContext(), this.nativeAdSlot.getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(this.adWrapper.getContext(), this.nativeAdSlot.getWinUrl(), map);
    }

    public void setAdListener(com.kc.dw.ad.nativ.a aVar) {
        this.adListener = aVar;
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void setOnPreparedListener(IPreparedListener iPreparedListener) {
        try {
            if (getAdView() instanceof NormalMediaView) {
                ((NormalMediaView) getAdView()).setOnPreparedListener(iPreparedListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void start() {
        try {
            s1.b(this.nativeAdSlot.getEventUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).start();
        }
    }

    @Override // com.kc.dw.core.ad.paster.PasterAd
    public void unmute() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).i();
        }
    }
}
