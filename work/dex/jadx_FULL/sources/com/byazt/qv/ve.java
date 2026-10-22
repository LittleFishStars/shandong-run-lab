package com.byazt.qv;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.nbs.i;
import com.byazt.vx.md;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 54})
public class ve {
    public static com.byazt.db.c c(com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, com.byazt.db.tt ttVar3) {
        com.byazt.nbs.c cVarC;
        com.byazt.ih.c cVarC2;
        if (ttVar == null || ttVar2 == null) {
            return null;
        }
        ttVar.c(c(ttVar2, ttVar));
        ttVar.tt(ttVar2.gt());
        if (!ttVar.da()) {
            if (ttVar.sl()) {
                return com.byazt.sp.uj.c(ttVar, ttVar3);
            }
            if (com.byazt.oi.ve.c(ttVar.x())) {
                return new com.byazt.sp.ve(ttVar3);
            }
            return null;
        }
        com.byazt.sx.tt.c(com.byazt.bp.tt.getContext(), ttVar.u());
        if (com.byazt.px.c.c(ttVar.u()) == null || (cVarC = com.byazt.ck.ve.c().c(ttVar.u())) == null || cVarC.uj() == null || (cVarC2 = cVarC.uj().c(ttVar.yv(), ttVar.z())) == null || !c(cVarC2)) {
            return null;
        }
        return com.byazt.sp.uj.c(cVarC2.c(), ttVar, ttVar3);
    }

    public static String c(com.byazt.ll.tt ttVar, com.byazt.dv.tt ttVar2) {
        if (ttVar == null || ttVar2 == null) {
            return null;
        }
        String strC = TextUtils.isEmpty(ttVar.c()) ? null : ttVar.c();
        if (TextUtils.isEmpty(ttVar2.t())) {
            return strC;
        }
        return (strC + LoginConstants.UNDER_LINE) + ttVar2.t();
    }

    public static boolean c(com.byazt.ih.c cVar) {
        if (cVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionA = com.byazt.vq.c.c().a();
        if (functionA != null) {
            if (!TextUtils.isEmpty(cVar.c())) {
                com.byazt.rl.c cVarC = com.byazt.rl.c.c();
                cVarC.c(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, cVar.c());
                com.byazt.eu.tt.tt("TMe", "custom className is " + cVar.c());
                cVarC.c(-99999987, 8229);
                cVarC.c(-99999985, Boolean.class);
                return ((Boolean) functionA.apply(cVarC.tt().sparseArray())).booleanValue();
            }
            com.byazt.eu.tt.tt("TMe", "custom className is empty");
        } else {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "load ad check custom name class loader is null ");
        }
        return false;
    }

    public static Map<String, Object> c(com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (ttVar != null && ttVar2 != null) {
            com.byazt.nbs.c cVarC = com.byazt.bp.tt.tt().c(ttVar.u());
            if (cVarC != null) {
                concurrentHashMap.put("tt_ad_network_config_appid", cVarC.tt());
                concurrentHashMap.put("tt_ad_network_config_appKey", cVarC.ve());
            }
            concurrentHashMap.put("tt_ad_origin_type", Integer.valueOf(ttVar.yp()));
            concurrentHashMap.put("tt_ad_sub_type", Integer.valueOf(ttVar.z()));
            Map<String, Object> mapCu = ttVar2.cu();
            if (mapCu != null && mapCu.size() > 0) {
                for (Map.Entry<String, Object> entry : mapCu.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        concurrentHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            int iQy = ttVar2.qy();
            int iGu = ttVar2.gu();
            if (iQy < 0) {
                iQy = 0;
            }
            if (iGu < 0) {
                iGu = 0;
            }
            concurrentHashMap.put("ad_height", Integer.valueOf(iGu));
            concurrentHashMap.put("ad_width", Integer.valueOf(iQy));
            concurrentHashMap.put("ad_type", Integer.valueOf(ttVar2.my()));
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    if (entry2.getKey() != null && entry2.getValue() != null) {
                        concurrentHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, com.byazt.dv.tt ttVar2, i iVar, String str) {
        if (veVar == null || ttVar2 == null || ttVar == null) {
            return;
        }
        if ((ttVar2.my() == 0 || ttVar2.my() == 100) && ttVar2.md() != AudioStats.AUDIO_AMPLITUDE_NONE) {
            veVar.setCpm(ttVar2.md());
        }
        if (ttVar2.gu()) {
            veVar.setServerBiddingShowCpm(ttVar2.h());
            veVar.setServerBiddingLoadCpm(ttVar2.d());
            if (ttVar2.eo() != null) {
                veVar.setAid(ttVar2.eo().ve());
                veVar.setAdExtra(ttVar2.eo().uj());
                veVar.setWinCallback(ttVar2.eo().x());
                veVar.setFailCallback(ttVar2.eo().i());
                veVar.setPricingType(ttVar2.eo().c());
            }
        }
        veVar.setAdNetworkSlotType(ttVar2.my());
        veVar.setLoadSort(ttVar2.gt());
        veVar.setShowSort(ttVar2.rl());
        if (str == null) {
            str = "";
        }
        veVar.setSdkVersion(str);
        veVar.setAdNetWorkName(ttVar2.u());
        veVar.setCustomAdNetWorkName(ttVar2.x() != null ? ttVar2.x().m() : "");
        veVar.setExchangeRate(ttVar2.zb());
        veVar.setDiscount(ttVar2.x() != null ? ttVar2.x().gu() : null);
        veVar.setFillTime(SystemClock.elapsedRealtime());
        veVar.setAdNetworkSlotId(ttVar2.t());
        veVar.setRit(ttVar2.tt());
        veVar.setSdkNum(com.byazt.yl.c.tt(ttVar2.u()));
        veVar.setMediationRitReqTypeFromRealReq(ttVar2.sp());
        veVar.setMediationRitReqTypeSrcFromRealReq(ttVar2.a());
        veVar.setLinkIdFromRealReq(ttVar.c());
        veVar.setMediationRitReqType(ttVar2.sp());
        veVar.setMediationRitReqTypeSrc(ttVar2.a());
        veVar.setOriginType(ttVar2.yp());
        veVar.setSubAdType(ttVar2.z());
        veVar.setAdType(ttVar.my());
        veVar.setIfReuseAds(ttVar2.or());
        veVar.setIsRefresh(ttVar2.p());
        md.c(veVar, ttVar2.x(), ttVar, false);
        if (iVar != null) {
            int i = iVar.tt;
            veVar.putEventParam("if_test", Integer.valueOf(i == 1 ? i : 0));
            veVar.putEventParam("server_bidding_extra", iVar.c);
            int mediationRitReqType = veVar.getMediationRitReqType(ttVar.c());
            if (mediationRitReqType == 1 || mediationRitReqType == 2) {
                veVar.setTimeoutFill(iVar.n);
            }
        }
        if (ttVar2.eo() != null && ttVar2.eo() != null) {
            veVar.putExtraMsg("extra_data_and_no_parse", ttVar2.eo().tt());
        }
        veVar.setLoadByDexPl(ttVar2.pf());
    }
}
