package com.byazt.nm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.camera.video.AudioStats;
import com.byazt.omf.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 34})
public class a extends tt {
    public static final String TAG = "PangleFullVideoAdapter";

    @com.byazt.zqa.c(c = {0, 1, 585, 464})
    public class c extends com.byazt.yl.ve {
        public com.byazt.nc.sl da;
        public boolean sl;
        public boolean t;
        public com.byazt.dv.tt u;
        public com.byazt.nh.uj x = new com.byazt.nh.uj(null) { // from class: com.byazt.nm.a.c.1
            @Override // com.byazt.nh.uj
            public void c(int i, String str) {
                c.this.sl = false;
                c.this.yp.notifyLoadFail(new com.byazt.pp.c(i, str));
            }

            @Override // com.byazt.nh.uj
            public void tt(com.byazt.nc.sl slVar) {
                com.byazt.eu.tt.c("TMe", "pangle full cached 2");
                c.this.sl = true;
                c.this.yp.notifyVideoCache(c.this, (com.byazt.pp.c) null);
            }

            @Override // com.byazt.nh.uj
            public void c(com.byazt.nc.sl slVar) {
                if (slVar != null) {
                    c.this.da = slVar;
                    c.this.setExpressAd(true);
                    c cVar = c.this;
                    cVar.setInteractionType(cVar.da.getInteractionType());
                    Map<String, Object> mediaExtraInfo = c.this.da.getMediaExtraInfo();
                    com.byazt.eu.tt.uj(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader extraInfo :".concat(String.valueOf(mediaExtraInfo)));
                    if (c.this.u.c() && mediaExtraInfo != null) {
                        double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
                        com.byazt.eu.tt.c("TTMediationSDK_ECMP", com.byazt.eu.uj.tt(c.this.u.tt(), c.this.u.t()) + "pangle 全屏 返回的 cpm价格：" + dC);
                        c cVar2 = c.this;
                        if (dC <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                            dC = 0.0d;
                        }
                        cVar2.setCpm(dC);
                    }
                    if (mediaExtraInfo != null) {
                        c.this.putExtraMsg(mediaExtraInfo);
                        Object obj = mediaExtraInfo.get("materialMetaIsFromPreload");
                        if (obj instanceof Boolean) {
                            c.this.t = ((Boolean) obj).booleanValue();
                            com.byazt.eu.tt.c(MediationConstant.TAG, "pangle 全屏 返回的adnPreload：" + c.this.t);
                        }
                    }
                    Function function = null;
                    c.this.da.setDownloadListener(new com.byazt.ocd.ve(function) { // from class: com.byazt.nm.a.c.1.1
                        @Override // com.byazt.ocd.ve
                        public void c() {
                            if (c.this.ve != null) {
                                c.this.ve.c();
                            }
                        }

                        @Override // com.byazt.ocd.ve
                        public void tt(long j, long j2, String str, String str2) {
                            if (c.this.ve != null) {
                                c.this.ve.c(j, j2, str, str2);
                            }
                        }

                        @Override // com.byazt.ocd.ve
                        public void ve(long j, long j2, String str, String str2) {
                            if (c.this.ve != null) {
                                c.this.ve.tt(j, j2, str, str2);
                            }
                        }

                        @Override // com.byazt.ocd.ve
                        public void c(long j, long j2, String str, String str2) {
                            if (c.this.ve != null) {
                                c.this.ve.c(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                            }
                        }

                        @Override // com.byazt.ocd.ve
                        public void c(long j, String str, String str2) {
                            if (c.this.ve != null) {
                                c.this.ve.c(j, str, str2);
                            }
                        }

                        @Override // com.byazt.ocd.ve
                        public void c(String str, String str2) {
                            if (c.this.ve != null) {
                                c.this.ve.c(str, str2);
                            }
                        }
                    });
                    c.this.da.setFullScreenVideoAdInteractionListener(new com.byazt.gl.c(function) { // from class: com.byazt.nm.a.c.1.2
                        @Override // com.byazt.gl.c
                        public void c(Bundle bundle) {
                            if (c.this.sp instanceof com.byazt.zq.tt) {
                                c.this.c().c();
                            }
                        }

                        @Override // com.byazt.gl.c
                        public void tt() {
                            if (c.this.sp instanceof com.byazt.zq.tt) {
                                c.this.c().h_();
                            }
                        }

                        @Override // com.byazt.gl.c
                        public void uj() {
                            if (c.this.sp instanceof com.byazt.zq.tt) {
                                c.this.c().a();
                            }
                        }

                        @Override // com.byazt.gl.c
                        public void ve() {
                            if (c.this.sp instanceof com.byazt.zq.tt) {
                                c.this.c().uj();
                            }
                        }

                        @Override // com.byazt.gl.c
                        public void c() {
                            if (c.this.sp instanceof com.byazt.zq.tt) {
                                c.this.c().g_();
                            }
                        }
                    });
                    c.this.sl = true;
                    c.this.yp.notifyLoadSuccess(c.this);
                    return;
                }
                c.this.yp.notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用"));
            }

            @Override // com.byazt.nh.uj
            public void c() {
                com.byazt.eu.tt.c("TMe", "pangle full cached");
            }
        };
        public com.byazt.sp.tt yp;
        public com.byazt.ll.tt z;

        public c() {
        }

        @Override // com.byazt.yl.ve
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            com.byazt.nc.sl slVar = this.da;
            if (slVar != null) {
                return com.byazt.xf.tt.tt(slVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            com.byazt.nc.sl slVar = this.da;
            if (slVar != null) {
                return com.byazt.xf.tt.c(slVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            com.byazt.nc.sl slVar = this.da;
            if (slVar == null || (mediaExtraInfo = slVar.getMediaExtraInfo()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mediaExtraInfo.get("coupon"));
            map.put("live_room", mediaExtraInfo.get("live_room"));
            map.put(ze1.n, mediaExtraInfo.get(ze1.n));
            setMediaExtraInfo(map);
            return super.getMediaExtraInfo();
        }

        @Override // com.byazt.yl.ve
        public String getReqId() {
            com.byazt.nc.sl slVar = this.da;
            return slVar != null ? com.byazt.xf.tt.ve(slVar.getMediaExtraInfo()) : "";
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.da == null;
        }

        @Override // com.byazt.yl.ve
        public boolean isAdnPreload() {
            return this.t;
        }

        @Override // com.byazt.yl.ve
        public Integer isReadyStatus() {
            com.byazt.nc.sl slVar = this.da;
            return (slVar == null || slVar.getExpirationTimestamp() <= System.currentTimeMillis()) ? 3 : 2;
        }

        public void loadAd(Context context, com.byazt.ll.tt ttVar, com.byazt.dv.tt ttVar2, com.byazt.sp.tt ttVar3) {
            this.u = ttVar2;
            this.yp = ttVar3;
            this.z = ttVar;
            h pluginCSJLoader = a.this.getPluginCSJLoader(context);
            if (pluginCSJLoader == null) {
                return;
            }
            com.byazt.dj.tt.c cVarC = com.byazt.xf.tt.c(this.z, this.u, false);
            cVarC.c(1080).tt(1920).uj(this.z.d());
            pluginCSJLoader.loadFullScreenVideoAd(cVarC.c(), this.x);
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            com.byazt.nc.sl slVar = this.da;
            if (slVar != null) {
                slVar.setFullScreenVideoAdInteractionListener(null);
                this.da.setDownloadListener(null);
                this.da.setAdInteractionListener(null);
                this.da = null;
            }
        }

        @Override // com.byazt.yl.ve
        public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
            com.byazt.nc.sl slVar = this.da;
            if (slVar != null) {
                slVar.setAdInteractionListener(ttVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void showAd(Activity activity, Object obj, String str) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader showAd ritScenes:" + obj + "  ritScenesContent: " + str + "  mTTFullScreenVideoAd:" + this.da + "  activity:" + activity);
            com.byazt.nc.sl slVar = this.da;
            if (slVar != null) {
                if (obj != null) {
                    slVar.showFullScreenVideoAd(activity, obj, str);
                } else {
                    slVar.showFullScreenVideoAd(activity);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.zq.tt c() {
            return (com.byazt.zq.tt) this.sp;
        }
    }

    public a(com.byazt.db.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.sp.tt
    public void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        if (ttVar2 == null) {
            notifyLoadFail(new com.byazt.pp.c("load ad fail adSlot is null"));
        } else {
            new c().loadAd(context.getApplicationContext(), ttVar2, ttVar, this);
        }
    }
}
