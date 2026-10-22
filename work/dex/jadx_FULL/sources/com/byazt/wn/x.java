package com.byazt.wn;

import androidx.camera.video.AudioStats;
import com.byazt.uj.da;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 71})
public class x extends tt {
    public com.byazt.uj.ve i;

    public x(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
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
        da daVar = new da(this, ((tt) this).ve);
        this.i = daVar;
        c(daVar, d, map);
    }

    @Override // com.byazt.wn.tt
    public <T> T callManager(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom splash loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                map = null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom splash loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            callLoadSucceed(dDoubleValue, map);
        } else if (i == 1009) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdClicked");
            callSplashAdClicked();
        } else if (i == 1008) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdShow");
            callSplashAdShow();
        } else if (i == 1019) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdSkip");
            callSplashAdSkip();
        } else if (i == 1011) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "Adn custom splash loader : callSplashAdDismiss");
            callSplashAdDismiss();
        }
        return null;
    }

    public void callSplashAdClicked() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.x.1
                @Override // com.byazt.ylx.c.InterfaceC0587c
                public void c() {
                    x.this.checkClick(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.x.1.1
                        @Override // com.byazt.ylx.c.InterfaceC0587c
                        public void c() {
                            com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                            if (ttVar != null) {
                                ttVar.uj();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callSplashAdDismiss() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.x.4
                @Override // com.byazt.ylx.c.InterfaceC0587c
                public void c() {
                    com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                    if (ttVar != null) {
                        ttVar.tt(2);
                    }
                }
            });
        }
    }

    public void callSplashAdShow() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.x.2
                @Override // com.byazt.ylx.c.InterfaceC0587c
                public void c() {
                    x.this.checkShow(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.x.2.1
                        @Override // com.byazt.ylx.c.InterfaceC0587c
                        public void c() {
                            com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                            if (ttVar != null) {
                                ttVar.n();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callSplashAdSkip() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0587c() { // from class: com.byazt.wn.x.3
                @Override // com.byazt.ylx.c.InterfaceC0587c
                public void c() {
                    com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                    if (ttVar != null) {
                        ttVar.c(1);
                    }
                }
            });
        }
    }
}
