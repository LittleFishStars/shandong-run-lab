package com.byazt.nm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.nc.z;
import com.byazt.omf.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 158})
public class sl extends tt {
    public static final String TAG = "PgRewardVideoAdapter";
    public static final String VERSION_4400 = "4.4.0.0";
    public com.byazt.ll.tt tt;
    public com.byazt.dv.tt ve;

    @com.byazt.zqa.c(c = {0, 1, 585, 925})
    public class c extends com.byazt.yl.ve {
        public z da;
        public boolean sl;
        public Map<String, Object> t;
        public com.byazt.nh.sp x = new AnonymousClass1(null);

        public c(Map<String, Object> map) {
            this.t = map;
        }

        @Override // com.byazt.yl.ve
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            z zVar = this.da;
            if (zVar != null) {
                return com.byazt.xf.tt.tt(zVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public String getAdLifecycleId() {
            z zVar = this.da;
            if (zVar instanceof com.byazt.yi.ve) {
                return ((com.byazt.yi.ve) zVar).getLifecycleId();
            }
            return null;
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            z zVar = this.da;
            if (zVar != null) {
                return com.byazt.xf.tt.c(zVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            z zVar = this.da;
            if (zVar != null) {
                setMediaExtraInfo(zVar.getMediaExtraInfo());
            }
            return super.getMediaExtraInfo();
        }

        @Override // com.byazt.yl.ve
        public String getReqId() {
            z zVar = this.da;
            return zVar != null ? com.byazt.xf.tt.ve(zVar.getMediaExtraInfo()) : "";
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.da == null;
        }

        @Override // com.byazt.yl.ve
        public boolean isAdnPreload() {
            return this.sl;
        }

        @Override // com.byazt.yl.ve
        public Integer isReadyStatus() {
            z zVar = this.da;
            return (zVar == null || zVar.getExpirationTimestamp() <= System.currentTimeMillis()) ? 3 : 2;
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            z zVar = this.da;
            if (zVar != null) {
                zVar.setDownloadListener(null);
                this.da.setRewardAdInteractionListener(null);
                this.da.setAdInteractionListener(null);
                this.da = null;
            }
        }

        @Override // com.byazt.yl.ve
        public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader setAdInteractionListener pluginTTAdInteractionListener:" + ttVar + "  mTTRewardVideoAd: " + this.da);
            z zVar = this.da;
            if (zVar != null) {
                zVar.setAdInteractionListener(ttVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void showAd(Activity activity, Object obj, String str) {
            z zVar = this.da;
            if (zVar != null) {
                if (obj != null) {
                    zVar.showRewardVideoAd(activity, obj, str);
                } else {
                    zVar.showRewardVideoAd(activity);
                }
            }
        }

        /* JADX INFO: renamed from: com.byazt.nm.sl$c$1, reason: invalid class name */
        @com.byazt.zqa.c(c = {0, 1, 585, 901})
        public class AnonymousClass1 extends com.byazt.nh.sp {
            public AnonymousClass1(Function function) {
                super(function);
            }

            @Override // com.byazt.nh.sp
            public void c(int i, String str) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward_onError code:" + i + "  message:" + str);
                sl.this.notifyLoadFail(new com.byazt.pp.c(i, str));
            }

            @Override // com.byazt.nh.sp
            public void tt(z zVar) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward_onRewardVideoCached 2");
                c cVar = c.this;
                sl.this.notifyVideoCache(cVar, (com.byazt.pp.c) null);
            }

            @Override // com.byazt.nh.sp
            public void c(z zVar) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward_onRewardVideoAdLoad");
                if (zVar != null) {
                    c.this.da = zVar;
                    c.this.setExpressAd(true);
                    c cVar = c.this;
                    cVar.setInteractionType(cVar.da.getInteractionType());
                    Map<String, Object> mediaExtraInfo = c.this.da.getMediaExtraInfo();
                    com.byazt.eu.tt.uj(MediationConstant.TAG, "PangleRewardLoader WaterfallPangleRewardLoader extraInfo :".concat(String.valueOf(mediaExtraInfo)));
                    if (sl.this.ve.c() && mediaExtraInfo != null) {
                        double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
                        com.byazt.eu.tt.c("TTMediationSDK_ECMP", com.byazt.eu.uj.tt(sl.this.ve.tt(), sl.this.ve.t()) + "pangle reward 返回的 cpm价格：" + dC);
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
                            c.this.sl = ((Boolean) obj).booleanValue();
                            com.byazt.eu.tt.c(MediationConstant.TAG, "pangle 激励 返回的adnPreload：" + c.this.sl);
                        }
                    }
                    Function function = null;
                    c.this.da.setDownloadListener(new com.byazt.ocd.ve(function) { // from class: com.byazt.nm.sl.c.1.1
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
                    c.this.da.setRewardAdInteractionListener(new com.byazt.tn.c(function) { // from class: com.byazt.nm.sl.c.1.2
                        @Override // com.byazt.tn.c
                        public void c(Bundle bundle) {
                            com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward:onAdShow");
                            if (c.this.sp instanceof com.byazt.uhf.c) {
                                c.this.c().c();
                            }
                        }

                        @Override // com.byazt.tn.c
                        public void n() {
                            com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward:onSkippedVideo");
                            if (c.this.sp instanceof com.byazt.uhf.c) {
                                c.this.c().a();
                            }
                        }

                        @Override // com.byazt.tn.c
                        public void tt() {
                            com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward:onAdClose");
                            if (c.this.sp instanceof com.byazt.uhf.c) {
                                c.this.c().j_();
                            }
                        }

                        @Override // com.byazt.tn.c
                        public void uj() {
                            com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward:onVideoError");
                            if (c.this.sp instanceof com.byazt.uhf.c) {
                                c.this.c().n();
                            }
                        }

                        @Override // com.byazt.tn.c
                        public void ve() {
                            com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward:onVideoComplete");
                            if (c.this.sp instanceof com.byazt.uhf.c) {
                                c.this.c().uj();
                            }
                        }

                        @Override // com.byazt.tn.c
                        public void c() {
                            com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward:onAdVideoBarClick");
                            if (c.this.sp instanceof com.byazt.uhf.c) {
                                c.this.c().i_();
                            }
                        }

                        @Override // com.byazt.tn.c
                        @Deprecated
                        public void c(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (c.this.tt()) {
                                com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward:onRewardVerify-------------2");
                                if (c.this.sp instanceof com.byazt.uhf.c) {
                                    c.this.c().c(new com.byazt.bo.c() { // from class: com.byazt.nm.sl.c.1.2.1
                                        @Override // com.byazt.bo.c
                                        public boolean c() {
                                            return z;
                                        }

                                        @Override // com.byazt.bo.c
                                        public float tt() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (sl.this.tt != null) {
                                                return sl.this.tt.p();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.byazt.bo.c
                                        public Map<String, Object> uj() {
                                            HashMap map = new HashMap();
                                            map.put("errorCode", Integer.valueOf(i2));
                                            map.put("errorMsg", str2);
                                            return map;
                                        }

                                        @Override // com.byazt.bo.c
                                        public String ve() {
                                            if (TextUtils.isEmpty(str)) {
                                                return sl.this.tt != null ? sl.this.tt.yv() : "";
                                            }
                                            return str;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.byazt.tn.c
                        public void c(final boolean z, final int i, final Bundle bundle) {
                            if (c.this.tt()) {
                                return;
                            }
                            com.byazt.eu.tt.uj("GROMORE_SS_REWARD_VERIFY", "csj-onRewardArrived =".concat(String.valueOf(z)));
                            if (c.this.sp instanceof com.byazt.uhf.c) {
                                c.this.c().c(new com.byazt.bo.c() { // from class: com.byazt.nm.sl.c.1.2.2
                                    @Override // com.byazt.bo.c
                                    public boolean c() {
                                        return z;
                                    }

                                    @Override // com.byazt.bo.c
                                    public float tt() {
                                        Bundle bundle2 = bundle;
                                        float f = bundle2 != null ? bundle2.getInt("reward_extra_key_reward_amount") : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (sl.this.tt != null) {
                                            return sl.this.tt.p();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.byazt.bo.c
                                    public Map<String, Object> uj() {
                                        HashMap map = new HashMap();
                                        map.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        map.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                                        return map;
                                    }

                                    @Override // com.byazt.bo.c
                                    public String ve() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString("reward_extra_key_reward_name") : "";
                                        if (TextUtils.isEmpty(string)) {
                                            return sl.this.tt != null ? sl.this.tt.yv() : "";
                                        }
                                        return string;
                                    }
                                });
                            }
                        }
                    });
                    c cVar3 = c.this;
                    sl.this.notifyLoadSuccess(cVar3);
                    return;
                }
                sl.this.notifyLoadFail(new com.byazt.pp.c("请求成功，但无广告可用"));
            }

            @Override // com.byazt.nh.sp
            public void c() {
                com.byazt.eu.tt.uj(MediationConstant.TAG, "pangle_reward_onRewardVideoCached");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean tt() {
            return !"0.0".equals(sl.this.getSdkVersion(MediationConstant.ADN_PANGLE)) && sl.VERSION_4400.compareTo(sl.this.getSdkVersion(MediationConstant.ADN_PANGLE)) > 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.uhf.c c() {
            return (com.byazt.uhf.c) this.sp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:12:0x0028  */
        public void c(Context context) {
            String str;
            h pluginCSJLoader = sl.this.getPluginCSJLoader(context);
            if (pluginCSJLoader == null) {
                return;
            }
            Map<String, Object> mapCu = sl.this.tt.cu();
            if (mapCu != null) {
                Object obj = mapCu.get(MediationConstant.ADN_PANGLE);
                if (obj instanceof String) {
                    str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                } else {
                    str = "";
                }
            } else {
                str = "";
            }
            com.byazt.dj.tt.c cVarC = com.byazt.xf.tt.c(sl.this.tt, sl.this.ve.t(), sl.this.ve.m(), sl.this.ve.nu(), sl.this.ve.zm(), false);
            cVarC.a(sl.this.tt.h()).n(str).da(sl.this.tt.yv()).x(sl.this.tt.p()).c(1080).tt(1920).uj(sl.this.tt.d());
            pluginCSJLoader.loadRewardVideoAd(cVarC.c(), this.x);
        }
    }

    public sl(com.byazt.db.tt ttVar) {
        super(ttVar);
    }

    public void notifyLoadFailBecauseGMAdSlotIsNull() {
        notifyLoadFail(new com.byazt.pp.c("load ad fail adSlot is null"));
    }

    @Override // com.byazt.sp.tt
    public void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        this.tt = ttVar2;
        this.ve = ttVar;
        if (ttVar2 == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
        } else {
            new c(map).c(context != null ? context.getApplicationContext() : com.byazt.bp.tt.getContext());
        }
    }
}
