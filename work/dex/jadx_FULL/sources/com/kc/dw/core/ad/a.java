package com.kc.dw.core.ad;

import android.os.SystemClock;
import android.view.View;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.BasePlatformLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class a<T extends InteractionListener> implements IAd<T> {
    private static final String TAG = "BaseAd";
    public View adView;
    public com.kc.dw.core.loader.b adWrapper;
    public T interactionListener;
    private String platform;
    public TouchData touchData = new TouchData();

    public a() {
    }

    public a(com.kc.dw.core.loader.b bVar, String str) {
        this.adWrapper = bVar;
        this.platform = str;
    }

    @Override // com.kc.dw.core.ad.IAd
    public View getAdView() {
        return this.adView;
    }

    @Override // com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        String strValueOf;
        ResultBean resultBean = new ResultBean();
        resultBean.setSdkName(this.platform);
        com.kc.dw.core.loader.b bVar = this.adWrapper;
        if (bVar != null && bVar.getSdkAdInfo() != null) {
            resultBean.setPid(this.adWrapper.getSdkAdInfo().getPid());
            resultBean.setAppid(this.adWrapper.getSdkAdInfo().getApp_id());
            resultBean.setReqId(this.adWrapper.getSdkAdInfo().getReq_id());
            resultBean.setPrice(this.adWrapper.getSdkAdInfo().getCodPrice());
            resultBean.setDrawing(this.adWrapper.getSdkAdInfo().getDrawing());
            if (this.adWrapper.getSdkAdInfo().isCsjGM() && this.adWrapper.getSdkAdInfo().isCsjGMBidding()) {
                strValueOf = String.valueOf(this.adWrapper.getSdkAdInfo().getGmShowEcpm());
            } else {
                strValueOf = String.valueOf("bidding".equals(this.adWrapper.getSdkAdInfo().getOtype()) ? this.adWrapper.getSdkAdInfo().getEcpm() : this.adWrapper.getSdkAdInfo().getCodPrice());
            }
            resultBean.setEcpm(strValueOf);
            resultBean.setReward_name(this.adWrapper.getSdkAdInfo().getReward_name());
            resultBean.setReward_num(this.adWrapper.getSdkAdInfo().getReward_num());
            resultBean.setS_ext(this.adWrapper.getSdkAdInfo().getS_ext());
            resultBean.setS_code(this.adWrapper.getSdkAdInfo().getS_code());
            resultBean.setExtraMap(getExtraMap());
        }
        return resultBean;
    }

    public HashMap<String, Object> getExtraMap() {
        return null;
    }

    @Override // com.kc.dw.core.ad.IAd
    public T getInteractionListener() {
        return this.interactionListener;
    }

    public com.kc.dw.core.loader.b getPlatformLoader() {
        return this.adWrapper;
    }

    public Object getSdkAd() {
        return null;
    }

    @Override // com.kc.dw.core.ad.IAd
    public TouchData getTouchData() {
        return this.touchData;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    @Override // com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        byte b;
        com.kc.dw.core.loader.b bVar = this.adWrapper;
        if (bVar != null && bVar.getSdkAdInfo() != null) {
            int expire_timestamp = this.adWrapper.getSdkAdInfo().getExpire_timestamp();
            String sdk = this.adWrapper.getSdkAdInfo().getSdk();
            sdk.getClass();
            int iHashCode = sdk.hashCode();
            if (iHashCode != 2319) {
                if (iHashCode != 2362) {
                    if (iHashCode != 2408) {
                        if (iHashCode != 67034) {
                            if (iHashCode != 82041) {
                                if (iHashCode == 62961147 && sdk.equals("BAIDU")) {
                                    b = 5;
                                } else {
                                    b = -1;
                                }
                            } else if (sdk.equals("SGM")) {
                                b = 4;
                            } else {
                                b = -1;
                            }
                        } else if (sdk.equals("CSJ")) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                    } else if (sdk.equals("KS")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (sdk.equals("JD")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (sdk.equals("HW")) {
                b = 0;
            } else {
                b = -1;
            }
            long j = (b == 2 || b == 3) ? 3540000L : 1740000L;
            if (expire_timestamp > 0) {
                j = expire_timestamp * 1000;
            }
            if (SystemClock.uptimeMillis() - this.adWrapper.getSdkAdInfo().getLoadedTime() >= j) {
                return false;
            }
        }
        return true;
    }

    public boolean isAutoRender() {
        com.kc.dw.core.loader.b bVar = this.adWrapper;
        if (bVar == null || !(bVar instanceof BasePlatformLoader)) {
            return true;
        }
        return ((BasePlatformLoader) bVar).isAutoRender();
    }

    public boolean isMSPlatform() {
        return "SSD".equals(this.platform);
    }

    @Override // com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map<String, Object> map) {
    }

    @Override // com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map<String, Object> map) {
    }

    @Override // com.kc.dw.core.ad.IAd
    public void setAdView(View view) {
        this.adView = view;
    }

    @Override // com.kc.dw.core.ad.IAd
    public void setInteractionListener(T t) {
        this.interactionListener = t;
    }
}
