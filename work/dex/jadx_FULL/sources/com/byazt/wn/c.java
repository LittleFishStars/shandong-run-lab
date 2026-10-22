package com.byazt.wn;

import android.view.View;
import androidx.camera.video.AudioStats;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 20})
public class c extends tt {
    public com.byazt.uj.ve i;

    public c(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callBannerAdClicked() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.c.2
                @Override // com.byazt.ylx.c.InterfaceC0587c
                public void c() {
                    c.this.checkClick(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.c.2.1
                        @Override // com.byazt.ylx.c.InterfaceC0587c
                        public void c() {
                            com.byazt.oc.c cVar = (com.byazt.oc.c) c.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.c((View) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void callBannerAdClosed() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.c.3
                @Override // com.byazt.ylx.c.InterfaceC0587c
                public void c() {
                    com.byazt.oc.c cVar = (com.byazt.oc.c) c.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.c();
                    }
                }
            });
        }
    }

    public void callBannerAdShow() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.c.1
                @Override // com.byazt.ylx.c.InterfaceC0587c
                public void c() {
                    com.byazt.oc.c cVar = (com.byazt.oc.c) c.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.tt(null);
                    }
                }
            });
        }
    }

    public void callLoadFail(com.byazt.zm.c cVar) {
        if (hasNotifyFail()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
        } else {
            notifyLoadFail(new com.byazt.pp.c(49004, com.byazt.pp.c.c(49004), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.tt()));
        }
    }

    public void callLoadSucceed(double d, Map<String, Object> map) {
        if (hasNotifySuccess()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
        com.byazt.uj.tt ttVar = new com.byazt.uj.tt(this, ((tt) this).ve);
        this.i = ttVar;
        ttVar.setMediaExtraInfo(this.n);
        this.i.setAdType(this.uj.yv());
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE && getBiddingType() == 1) {
            this.i.setCpm(d);
        }
        if (map != null) {
            this.n.putAll(map);
        }
        this.i.putExtraMsg(this.n);
        notifyLoadSuccess(this.i);
    }

    @Override // com.byazt.wn.tt
    public <T> T callManager(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom banner loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                map = null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom banner loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            callLoadSucceed(dDoubleValue, map);
        } else if (i == 1008) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom banner loader : callBannerAdShow");
            callBannerAdShow();
        } else if (i == 1009) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClick");
            callBannerAdClicked();
        } else if (i == 1014) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClosed");
            callBannerAdClosed();
        }
        return null;
    }
}
