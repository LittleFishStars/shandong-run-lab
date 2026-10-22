package com.byazt.sp;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.dc.n;
import com.byazt.yf.i;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 91, 54})
public class ve extends tt {
    public c tt;
    public com.byazt.ll.tt uj;
    public com.byazt.dv.tt ve;

    public ve(com.byazt.db.tt ttVar) {
        super(ttVar);
    }

    private void c(Context context, String str, com.byazt.yxi.uj ujVar) {
        com.byazt.dv.tt ttVar = this.ve;
        Function<SparseArray<Object>, Object> functionC = (ttVar == null || this.uj == null) ? null : n.c(ttVar.u(), this.uj.my(), this.ve.z());
        com.byazt.px.c.c(str, functionC != null);
        if (functionC != null) {
            this.ve.tt(true);
            functionC.apply(com.byazt.yxi.uj.c().c(8241).c(Void.class).c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.eu.c.c(context)).c(8424, ujVar.tt()).tt());
        } else {
            this.ve.tt(false);
            c(context, ujVar);
        }
    }

    @Override // com.byazt.sp.tt, com.byazt.db.c
    public String getBiddingToken(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2) {
        if (ttVar != null && ttVar2 != null) {
            HashMap map = new HashMap();
            map.put("bidding_token", "true");
            if (this.tt == null) {
                this.tt = new c(ttVar2, ttVar, this);
                com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
                ujVarC.c(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.tt);
                ujVarC.c(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, ttVar.rh());
                com.byazt.yxi.uj ujVarC2 = com.byazt.yxi.uj.c();
                ujVarC2.c(8449, map);
                com.byazt.yxi.uj ujVarC3 = com.byazt.yxi.uj.c();
                ujVarC3.c(8443, ujVarC2.tt());
                ujVarC.c(8090, com.byazt.yxi.uj.c(ttVar2.qp()).c(8089, ujVarC3.tt()).tt());
                Function<SparseArray<Object>, Object> functionA = com.byazt.vq.c.c().a();
                if (functionA != null) {
                    com.byazt.yxi.uj ujVarC4 = com.byazt.yxi.uj.c();
                    ujVarC4.c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.eu.c.c(context)).c(8106).c(Void.class);
                    com.byazt.px.n.c(ujVarC4, ujVarC);
                    functionA.apply(ujVarC4.tt());
                } else {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "load ad class loader is null ");
                }
            }
            if (this.tt != null && ttVar2.rh() != null) {
                com.byazt.ch.tt ttVarMd = ttVar2.rh().md();
                return this.tt.getBiddingToken(context, ttVar.t(), com.byazt.hf.c.c(ttVarMd != null ? ttVarMd.a() : null));
            }
        }
        return null;
    }

    @Override // com.byazt.db.c
    public String getSdkVersion(String str) {
        com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c(str);
        if (ujVarC != null) {
            return ujVarC.getNetworkSdkVersion();
        }
        return null;
    }

    @Override // com.byazt.sp.tt
    public void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        this.ve = ttVar;
        this.uj = ttVar2;
        com.byazt.yxi.uj ujVarC = c(ttVar, ttVar2, map);
        if (ujVarC != null) {
            this.tt = new c(ttVar2, ttVar, this);
            ujVarC.c(8429, ttVar.m());
            ujVarC.c(8430, ttVar.nu());
            ujVarC.c(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.tt);
            ujVarC.c(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, ttVar.rh());
            ujVarC.c(8561, Integer.valueOf(ttVar.nb()));
            c(context, ttVar.u(), ujVarC);
        }
    }

    private void c(Context context, com.byazt.yxi.uj ujVar) {
        Function<SparseArray<Object>, Object> functionA = com.byazt.vq.c.c().a();
        if (functionA != null) {
            if (com.byazt.tjo.tt.c() >= 5900) {
                com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c().c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.eu.c.c(context)).c(8106).c(Void.class);
                com.byazt.px.n.c(ujVarC, ujVar);
                functionA.apply(ujVarC.tt());
                return;
            } else {
                ujVar.c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.eu.c.c(context)).c(8106).c(Void.class);
                functionA.apply(ujVar.tt());
                return;
            }
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, "load ad class loader is null ");
    }

    private com.byazt.yxi.uj c(com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        HashMap map2 = null;
        if (ttVar == null || ttVar2 == null || ttVar2.rh() == null) {
            return null;
        }
        com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
        com.byazt.ch.c cVarRh = ttVar2.rh();
        com.byazt.ch.tt ttVarMd = cVarRh.md();
        com.byazt.yxi.uj ujVarC2 = com.byazt.yxi.uj.c(ttVar2.qp()).c(15, cVarRh.yp()).c(13, Integer.valueOf(ttVar2.gr())).c(7, Integer.valueOf(cVarRh.a())).c(8, Integer.valueOf(cVarRh.sp())).c(16, Integer.valueOf(cVarRh.z())).c(20, Integer.valueOf(cVarRh.rh())).c(11, Boolean.valueOf(cVarRh.da())).c(17, Integer.valueOf(ttVar2.m()));
        com.byazt.yxi.uj ujVarC3 = com.byazt.yxi.uj.c();
        HashMap map3 = new HashMap();
        if (ttVarMd != null) {
            if (ttVarMd.a() != null) {
                map3.putAll(ttVarMd.a());
            }
            if (ttVar.x() != null) {
                map3.put("waterfall_config", ttVar.x());
            }
            map3.put("dynamic_adapter_type", Integer.valueOf(com.byazt.ck.tt.c().uj()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.byazt.ck.tt.c().n()));
            com.byazt.pl.c.c(ttVar2, ttVar.x(), map3);
            ujVarC3.c(8444, Boolean.valueOf(ttVarMd.ve())).c(8445, Boolean.valueOf(ttVarMd.c())).c(8446, Boolean.valueOf(ttVarMd.tt())).c(8447, Float.valueOf(ttVarMd.uj())).c(8448, Boolean.valueOf(ttVarMd.n())).c(8450, Boolean.valueOf(ttVarMd.sp())).c(8451, ttVarMd.x()).c(8454, Boolean.valueOf(ttVarMd.i())).c(8455, Float.valueOf(ttVarMd.sl())).c(8456, Float.valueOf(ttVarMd.t()));
        } else {
            map3.put("dynamic_adapter_type", Integer.valueOf(com.byazt.ck.tt.c().uj()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.byazt.ck.tt.c().n()));
        }
        i iVarTt = com.byazt.bp.c.t().qy().tt();
        if (iVarTt != null) {
            map3.put("lng", Double.valueOf(iVarTt.tt()));
            map3.put("lat", Double.valueOf(iVarTt.c()));
            map3.put("loc_time", Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            map3.put("lng", -1);
            map3.put("lat", -1);
            map3.put("loc_time", -1);
        }
        map3.put("load_can_log", Boolean.valueOf(com.byazt.ck.tt.c().sp()));
        ujVarC3.c(8449, map3);
        ujVarC3.c(8044, map3);
        c(ujVarC3, cVarRh, ttVarMd);
        ujVarC2.c(8443, ujVarC3.tt());
        ujVarC.c(8090, com.byazt.lq.uj.c(com.byazt.yxi.uj.c(ttVar2.qp()).c(8089, ujVarC2.tt()).tt()));
        ujVarC.c(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, ttVar.t());
        ujVarC.c(4, ttVar2.gt());
        ujVarC.c(8003, ttVar.u());
        ujVarC.c(17, Integer.valueOf(ttVar2.m()));
        if (ttVar2.cu() != null) {
            HashMap map4 = new HashMap();
            for (Map.Entry<String, Object> entry : ttVar2.cu().entrySet()) {
                Object value = entry.getValue();
                map4.put(entry.getKey(), value == null ? null : value.toString());
            }
            map2 = map4;
        }
        if (map2 != null) {
            ujVarC.c(8013, map2);
        }
        if (map != null) {
            ujVarC.c(8096, Integer.valueOf(map.get("ad_load_timeout") != null ? ((Integer) map.get("ad_load_timeout")).intValue() : 3000));
        }
        Object obj = map.get("contentUrl");
        if (obj instanceof String) {
            ujVarC.c(8083, (String) obj);
        }
        Object obj2 = map.get("testDevices");
        if (obj2 instanceof String) {
            ujVarC.c(8084, (String) obj2);
        }
        Object obj3 = map.get("tt_ad_origin_type");
        if (obj3 != null) {
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == 1 || iIntValue == 3) {
                ujVarC.c(8033, Boolean.TRUE);
            }
            ujVarC.c(8085, Integer.valueOf(iIntValue));
        }
        Object obj4 = map.get("tt_ad_sub_type");
        if (obj4 != null) {
            ujVarC.c(8094, Integer.valueOf(((Integer) obj4).intValue()));
        }
        Object obj5 = map.get("render_control");
        if (obj5 instanceof Integer) {
            ujVarC.c(8553, Integer.valueOf(((Integer) obj5).intValue()));
        }
        return ujVarC;
    }

    private void c(com.byazt.yxi.uj ujVar, com.byazt.ch.c cVar, com.byazt.ch.tt ttVar) {
        if (ujVar == null || cVar == null) {
            return;
        }
        if (ttVar != null && !TextUtils.isEmpty(ttVar.yp()) && ttVar.z() != 0) {
            ujVar.c(8452, ttVar.yp());
            ujVar.c(8453, Integer.valueOf(ttVar.z()));
        } else {
            if (TextUtils.isEmpty(cVar.gr()) || cVar.zm() == 0) {
                return;
            }
            ujVar.c(8452, cVar.gr());
            ujVar.c(8453, Integer.valueOf(cVar.zm()));
        }
    }
}
