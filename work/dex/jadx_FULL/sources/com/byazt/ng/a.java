package com.byazt.ng;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.bzd.u;
import com.byazt.dna.gu;
import com.byazt.ng.a;
import com.byazt.nr.m;
import com.byazt.vx.nu;
import com.byazt.vx.yv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 34})
public class a {
    public static int c;
    public static int tt;
    public static int ve;

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, int i, String str, long j, int i2, int i3, String str2) {
        com.byazt.qe.ve veVarTt;
        com.byazt.nbs.tt ttVarC;
        uj ujVarTt = uj.tt();
        ujVarTt.c("media_reward_verify").c("adn_preload", Integer.valueOf((veVar == null || !veVar.isAdnPreload()) ? 0 : 1)).c(MediationConstant.KEY_REASON, Integer.valueOf(i2)).c("play_again", Integer.valueOf(i));
        if (i3 != 0 && i3 != 20000) {
            ujVarTt.tt(i3).sl(str2);
        }
        HashMap map = new HashMap();
        boolean z = j >= 0;
        if (veVar != null && veVar.isCustomAd()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(nu.ve()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        if (ttVar != null && (veVarTt = com.byazt.bp.tt.tt()) != null && (ttVarC = veVarTt.c(ttVar.gt(), ttVar.my(), 101)) != null) {
            map.put("reward_callback_type", Integer.valueOf(ttVarC.bm()));
            map.put("reward_start_time", Integer.valueOf(ttVarC.hd()));
        }
        if (str != null) {
            ujVarTt.c("sub_adn_name", str);
        }
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void tt(final com.byazt.ll.tt ttVar, final int i) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.7
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, ttVar, i);
            }
        });
    }

    private static int uj() {
        gu guVar = (gu) com.byazt.ut.uj.getService("m_d_s");
        if (guVar != null) {
            Object data = guVar.getData(3);
            if (data instanceof Integer) {
                return ((Integer) data).intValue();
            }
        }
        return -1;
    }

    public static void ve() {
        uj ujVarTt = uj.tt();
        ujVarTt.c("start_up");
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, (Map<String, Object>) null);
    }

    public static void tt() {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.zj.adlib.mda
            @Override // java.lang.Runnable
            public final void run() {
                a.c(ujVarVe);
            }
        });
    }

    public static void tt(long j) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("sdk_backstage").c(j);
        HashMap map = new HashMap();
        if (com.byazt.ii.c.c().sl()) {
            if (com.byazt.ii.c.c().x() > 0) {
                com.byazt.ii.c.c().c(c.ve);
                map.put("call_init_method_duration", Long.valueOf(com.byazt.ii.c.c().x()));
            }
        } else if (com.byazt.ii.c.c().t()) {
            map.put("call_init_method_duration", Long.valueOf(com.byazt.ii.c.c().x()));
        }
        map.put("v2Enc_config", yv.c("v2Enc_config"));
        map.put("v4Enc_config", yv.c("v4Enc_config"));
        map.put("v2Enc_exchange", yv.c("v2Enc_exchange"));
        map.put("v4Enc_exchange", yv.c("v4Enc_exchange"));
        map.put("v2Enc_reward", yv.c("v2Enc_reward"));
        map.put("v4Enc_reward", yv.c("v4Enc_reward"));
        map.put("enable_label_return", Integer.valueOf(com.byazt.bp.tt.tt().lr() ? 1 : 0));
        map.put("if_labelapi_call", Integer.valueOf(com.byazt.bp.c.t().c() ? 1 : 0));
        map.put("adn_init_duration", com.byazt.px.n.tt());
        map.put("sdk_boost_type", Integer.valueOf(com.byazt.xo.c.n()));
        map.put("layer_init_type", Integer.valueOf(uj()));
        com.byazt.dc.n.c(map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, int i, String str, long j, boolean z, int i2) {
        c(veVar, ttVar, i, str, j, (String) null, z, i2);
    }

    public static void c() {
        uj ujVarTt = uj.tt();
        ujVarTt.c("mediation_sdk_init");
        try {
            c(ujVarTt, (com.byazt.ll.tt) null, (com.byazt.nbs.da) null, (com.byazt.yl.ve) null, (Map<String, Object>) null);
            ve.c(com.byazt.bp.tt.getContext(), ujVarTt, (Map<String, Object>) null);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void c(final com.byazt.yl.ve veVar, final com.byazt.ll.tt ttVar, final int i, final String str, final long j, final String str2, final boolean z, final int i2) {
        final uj ujVarVe = uj.ve();
        com.byazt.nr.da.ve().post(new Runnable() { // from class: com.byazt.ng.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, veVar, ttVar, i, str, j, str2, z, i2);
            }
        });
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, String str) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("media_show_dislike").sl(str);
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, int i, String str, long j, boolean z) {
        c(veVar, ttVar, i, str, j, (String) null, z);
    }

    public static void c(final com.byazt.yl.ve veVar, final com.byazt.ll.tt ttVar, final int i, final String str, final long j, final String str2, final boolean z) {
        final uj ujVarVe = uj.ve();
        com.byazt.nr.da.ve().post(new Runnable() { // from class: com.byazt.ng.a.12
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, veVar, ttVar, i, str, j, str2, z);
            }
        });
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, boolean z, int i) {
        c(veVar, ttVar, z, i, (Map<String, Object>) null);
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, boolean z, int i, Map<String, Object> map) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("media_show").c("adn_preload", Integer.valueOf((veVar == null || !veVar.isAdnPreload()) ? 0 : 1)).c("play_again", Integer.valueOf(i)).c("is_repeat", Integer.valueOf(z ? 1 : 0));
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map2);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map2);
    }

    public static void c(List<com.byazt.yl.ve> list, List<com.byazt.yl.ve> list2, List<com.byazt.yl.ve> list3, com.byazt.ll.tt ttVar, int i) {
        boolean zIsReady;
        ArrayList<com.byazt.yl.ve> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i2 = 0;
        com.byazt.yl.ve veVar = arrayList.size() > 0 ? (com.byazt.yl.ve) arrayList.get(0) : null;
        uj ujVarTt = uj.tt();
        ujVarTt.c("media_show_is_ready");
        if (i == 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                loop0: while (true) {
                    zIsReady = false;
                    for (com.byazt.yl.ve veVar2 : arrayList) {
                        if (veVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", veVar2.getAdNetWorkName());
                            jSONObject.put("type", com.byazt.yl.c.c(veVar2.getAdType(), veVar2.getSubAdType()));
                            jSONObject.put("adnSlotId", veVar2.getAdNetworkSlotId());
                            jSONObject.put("loadSort", veVar2.getLoadSort());
                            jSONObject.put("showSort", veVar2.getShowSort());
                            if (ttVar != null) {
                                jSONObject.put("isReady", veVar2.isReady(ttVar.gt()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", veVar2.isHasShown() ? 1 : 0);
                            if (veVar2.adnHasAdVideoCachedApi()) {
                                jSONObject.put("is_video_cache_success", veVar2.isCacheSuccess() ? 1 : 0);
                            }
                            jSONObject.put("mediationrit_req_type", veVar2.getMediationRitReqType(ttVar != null ? ttVar.c() : null));
                            jSONObject.put("mediationrit_req_type_src", veVar2.getMediationRitReqTypeSrc(ttVar != null ? ttVar.c() : null));
                            jSONArray.put(jSONObject);
                            if (!zIsReady && ttVar != null) {
                                if (ttVar.my() == 5) {
                                    zIsReady = veVar2.isReady(ttVar.gt());
                                } else if (veVar2.isReady(ttVar.gt()) && !veVar2.isHasShown()) {
                                    zIsReady = true;
                                }
                            }
                        }
                    }
                    break loop0;
                }
                if (!zIsReady) {
                    i2 = -1;
                }
                ujVarTt.tt(i2);
                ujVarTt.sl(jSONArray.toString());
            } catch (JSONException e) {
                m.c(e);
            }
        } else {
            ujVarTt.tt(2);
            ujVarTt.sl(com.byazt.pp.c.c(i));
        }
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(List<com.byazt.yl.ve> list, com.byazt.ll.tt ttVar, int i) {
        com.byazt.yl.ve veVar = (list == null || list.size() <= 0) ? null : list.get(0);
        uj ujVarTt = uj.tt();
        ujVarTt.c("media_show_fail");
        if (i == 0) {
            ujVarTt.tt(40052);
            if (veVar != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.byazt.yl.ve veVar2 : list) {
                        if (veVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", veVar2.getAdNetWorkName());
                            jSONObject.put("type", com.byazt.yl.c.c(veVar2.getAdType(), veVar2.getSubAdType()));
                            jSONObject.put("adnSlotId", veVar2.getAdNetworkSlotId());
                            jSONObject.put("loadSort", veVar2.getLoadSort());
                            jSONObject.put("showSort", veVar2.getShowSort());
                            int i2 = 1;
                            if (ttVar != null) {
                                jSONObject.put("isReady", veVar2.isReady(ttVar.gt()) ? 1 : 0);
                            }
                            if (!veVar2.isHasShown()) {
                                i2 = 0;
                            }
                            jSONObject.put("hasShown", i2);
                            jSONArray.put(jSONObject);
                        }
                    }
                    ujVarTt.sl(jSONArray.toString());
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        } else {
            ujVarTt.tt(i);
            ujVarTt.sl(com.byazt.pp.c.c(i));
        }
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map);
        ujVarTt.c("is_video_cache_success", 0);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(com.byazt.ll.tt ttVar, int i) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("media_carousel_fail").tt(i).sl(com.byazt.pp.c.c(i));
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, (com.byazt.yl.ve) null, map);
        ujVarTt.c("is_video_cache_success", 0);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(final int i, final int i2, final long j, final String str, final String str2) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.18
            @Override // java.lang.Runnable
            public void run() {
                ujVarVe.c("rit_map_query").setResult(i2).c(j).n(i);
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    ujVarVe.x(str);
                    map.put("origin_rit", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    ujVarVe.tt(str2);
                    map.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
                }
                ve.c(com.byazt.bp.tt.getContext(), ujVarVe, map);
            }
        });
    }

    public static void c(final com.byazt.nbs.da daVar, final com.byazt.ll.tt ttVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.byazt.pp.c cVar, final long j, final boolean z2, final boolean z3, final long j2) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.19
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, daVar, ttVar, str, z, i, i2, i3, i4, cVar, j, z2, z3, null, j2);
            }
        });
    }

    public static void c(final com.byazt.nbs.da daVar, final com.byazt.ll.tt ttVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.byazt.pp.c cVar, final long j, final boolean z2, final boolean z3, final String str2, final long j2) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.20
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, daVar, ttVar, str, z, i, i2, i3, i4, cVar, j, z2, z3, str2, j2);
            }
        });
    }

    public static void c(com.byazt.nbs.da daVar, com.byazt.ll.tt ttVar, com.byazt.yl.ve veVar, int i, String str) {
        uj ujVarTt = uj.tt();
        uj ujVarC = ujVarTt.c("bidding_info_invalid").tt(i).sl(str).c("ad_count", Integer.valueOf(ttVar != null ? ttVar.gr() : 0));
        com.byazt.qe.tt.c(com.byazt.bp.tt.tt());
        ujVarC.c("grouping_params", com.byazt.qe.tt.c(com.byazt.bp.c.t().rl())).c("log_source", 2);
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, daVar, veVar, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(final com.byazt.yl.ve veVar, final int i, final String str, final long j, final com.byazt.ll.tt ttVar, final int i2, final int i3, final int i4, final String str2, final long j2, final long j3) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.21
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, veVar, i, str, j, ttVar, i2, i3, i4, str2, j2, j3);
            }
        });
    }

    public static void c(final com.byazt.pp.c cVar, final com.byazt.ll.tt ttVar, final com.byazt.nbs.da daVar, final int i, final int i2, final int i3, final String str, final long j, final String str2, final String str3, final String str4, final long j2) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.22
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, cVar, ttVar, daVar, i, i2, i3, str, j, str2, str3, str4, j2);
            }
        });
    }

    public static void c(com.byazt.pp.c cVar, com.byazt.ll.tt ttVar, com.byazt.nbs.da daVar, int i, int i2, int i3, String str, long j) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("bidding_adm_load_fail").c(j).a(str).tt(cVar != null ? cVar.ve : -1).sl(cVar != null ? cVar.uj : "unknown error").c("adn_count", Integer.valueOf(i)).c("adn_preload", 0).c("mediationrit_req_type", Integer.valueOf(i2)).c("mediationrit_req_type_src", Integer.valueOf(i3));
        if (cVar instanceof com.byazt.bnd.c) {
            ujVarTt.z = cVar.c;
            ujVarTt.t = cVar.tt;
        }
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, daVar, (com.byazt.yl.ve) null, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(@Nullable final com.byazt.ll.tt ttVar, final com.byazt.pp.c cVar, final String str) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.23
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, ttVar, cVar, str);
            }
        });
    }

    public static void c(final com.byazt.nbs.da daVar, final com.byazt.ll.tt ttVar, final int i, final int i2) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.24
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, daVar, ttVar, i, i2);
            }
        });
    }

    public static void c(final com.byazt.ll.tt ttVar, final String str, final boolean z, final String str2, final int i, final Map<String, Object> map) {
        if (ttVar != null) {
            com.byazt.lx.c.getInstance().startRequestRit(ttVar.c(), c.ve);
        }
        final uj ujVarVe = uj.ve();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.2
            @Override // java.lang.Runnable
            public void run() {
                ujVarVe.c(System.currentTimeMillis() - jCurrentTimeMillis);
                com.byazt.tw.c.c().c(ujVarVe, ttVar, str, z, str2, i, map);
            }
        });
    }

    public static void c(Map<String, Object> map, final com.byazt.ll.tt ttVar, final com.byazt.yl.ve veVar, final long j, final int i, final int i2, final int i3, final String str, final int i4, final int i5, final com.byazt.nbs.tt ttVar2, final JSONObject jSONObject) {
        final JSONObject jSONObject2;
        int i6;
        final uj ujVarVe = uj.ve();
        if (map != null) {
            int iIntValue = map.get("group_type") instanceof Integer ? ((Integer) map.get("group_type")).intValue() : 0;
            double dDoubleValue = map.get("ecpm") instanceof Double ? ((Double) map.get("ecpm")).doubleValue() : 0.0d;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("price_from", map.get("price_from"));
                jSONObject3.put("grout_type", iIntValue);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("target_ecpm_origin", dDoubleValue);
                jSONObject4.put("target_ecpm_upper", map.get("upper_cpm_x"));
                jSONObject3.put("price", jSONObject4);
                if (map.get("price_source") != null) {
                    jSONObject3.put("price_source", map.get("price_source"));
                }
                int iIntValue2 = map.get("rule_in_use") instanceof Integer ? ((Integer) map.get("rule_in_use")).intValue() : 0;
                boolean zBooleanValue = map.get("has_serverBidding") instanceof Boolean ? ((Boolean) map.get("has_serverBidding")).booleanValue() : false;
                if (iIntValue != 3 && iIntValue != 4) {
                    i6 = 0;
                } else if (!zBooleanValue) {
                    i6 = 1;
                } else if (dDoubleValue == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    i6 = 2;
                } else if (iIntValue2 == 0) {
                    i6 = 5;
                } else {
                    i6 = (iIntValue != 4 || (map.get("serverBidding_timeout") instanceof Boolean ? ((Boolean) map.get("serverBidding_timeout")).booleanValue() : false)) ? 4 : 3;
                }
                jSONObject3.put("pos_state", i6);
                jSONObject3.put("rule_id", map.get("rule_id"));
                jSONObject3.put("rule_inuse", iIntValue2);
            } catch (JSONException unused) {
            }
            jSONObject2 = jSONObject3;
        } else {
            jSONObject2 = null;
        }
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, ttVar, veVar, j, i, i2, i3, str, i4, i5, ttVar2, jSONObject2, jSONObject);
            }
        });
    }

    public static void c(final com.byazt.ll.tt ttVar, final com.byazt.yl.ve veVar, final long j) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, ttVar, veVar, j);
            }
        });
    }

    public static void c(final com.byazt.ll.tt ttVar, final com.byazt.yl.ve veVar, final com.byazt.nbs.da daVar) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, ttVar, veVar, daVar);
            }
        });
    }

    public static void c(final com.byazt.yl.ve veVar, final com.byazt.ll.tt ttVar, final com.byazt.nbs.tt ttVar2, final long j, final String str, final boolean z, final int i, final boolean z2, final boolean z3) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.6
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, veVar, ttVar, ttVar2, j, str, z, i, z2, z3);
            }
        });
    }

    public static void c(final boolean z) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.8
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                boolean z2 = com.byazt.rq.c.c().getBoolean("is_config_from_assert", false);
                if (z) {
                    i = z2 ? 2 : 1;
                }
                ujVarVe.c("get_config_start").c(MediationConstant.KEY_REASON, Integer.valueOf(i));
                ve.c(com.byazt.bp.tt.getContext(), ujVarVe, (Map<String, Object>) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(uj ujVar) {
        ujVar.c("init_adn_splash_info_request");
        ve.c(com.byazt.bp.tt.getContext(), ujVar, (Map<String, Object>) null);
    }

    public static void c(final long j, final boolean z, final String str, final int i) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.zj.adlib.kea
            @Override // java.lang.Runnable
            public final void run() {
                a.c(ujVarVe, z, j, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(uj ujVar, boolean z, long j, int i, String str) {
        ujVar.c("init_adn_splash_info_result").c("result", Integer.valueOf(z ? 1 : 0)).c("duration", Long.valueOf(j));
        if (!z) {
            ujVar.c(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i)).c("error_msg", str);
        }
        ve.c(com.byazt.bp.tt.getContext(), ujVar, (Map<String, Object>) null);
    }

    public static void c(long j) {
        String str;
        uj ujVarTt = uj.tt();
        ujVarTt.c("sdk_init").ve(j);
        com.byazt.it.ve veVarA = com.byazt.rq.c.a();
        boolean z = veVarA.getBoolean("check_unity3d", false);
        long j2 = veVarA.getLong("check_unity3d_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z && jCurrentTimeMillis - j2 > 2592000000L) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                str = "unity_pure";
                try {
                    Class.forName("com.bytedance.android.NativeAdManager");
                    str = MediationConstant.ADN_UNITY;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = null;
            }
            if (str != null) {
                ujVarTt.c("develop_type", str);
            }
            veVarA.put("check_unity3d", true);
            veVarA.put("check_unity3d_time", jCurrentTimeMillis);
        }
        HashMap map = new HashMap();
        int iUj = com.byazt.ii.c.c().uj();
        if (iUj > 0) {
            com.byazt.ii.c.c().n();
            map.put("discard_num", Integer.valueOf(iUj));
        }
        map.put("csj_plugin_version", com.byazt.sx.ve.uj());
        map.put("init_count", Integer.valueOf(yv.tt()));
        JSONObject jSONObjectC = yv.c();
        if (jSONObjectC != null) {
            map.put("init_time", jSONObjectC);
        }
        yv.c(map);
        yv.tt(map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.9
            @Override // java.lang.Runnable
            public void run() {
                ujVarVe.c("callstack_dynamic");
                ujVarVe.c("callstack_message", str);
                ujVarVe.c("callstack_report_time", 1);
                ve.c(com.byazt.bp.tt.getContext(), ujVarVe, (Map<String, Object>) null);
            }
        });
    }

    public static void c(final com.byazt.yl.ve veVar, final com.byazt.ll.tt ttVar, final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.10
            @Override // java.lang.Runnable
            public void run() {
                ujVarVe.c("callstack_static").c("callstack_message", str).c("callstack_report_time", Integer.valueOf(i));
                HashMap map = new HashMap();
                a.c(ujVarVe, ttVar, (com.byazt.nbs.da) null, veVar, map);
                ve.c(com.byazt.bp.tt.getContext(), ujVarVe, map);
            }
        });
    }

    public static void c(long j, int i, int i2, long j2, JSONObject jSONObject, Map<String, Object> map) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("sdk_init_end");
        ujVarTt.c(j);
        ujVarTt.ve(j2);
        ujVarTt.c("adn_count", Integer.valueOf(i));
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        map2.put("is_from_local_config", Integer.valueOf(i2));
        JSONObject adnAdapterVersion = com.byazt.px.uj.getAdnAdapterVersion();
        if (adnAdapterVersion != null) {
            map2.put("adapter_version_list", adnAdapterVersion);
        }
        if (jSONObject != null) {
            map2.put("init_stage_time", jSONObject);
        }
        map2.put("init_count", Integer.valueOf(yv.tt()));
        map2.put("sdk_boost_type", Integer.valueOf(com.byazt.xo.c.n()));
        map2.put("layer_init_type", Integer.valueOf(uj()));
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map2);
    }

    public static void c(int i, int i2, long j, boolean z, boolean z2, JSONObject jSONObject, long j2, JSONObject jSONObject2) {
        uj ujVarTt = uj.tt();
        boolean z3 = com.byazt.rq.c.c().getBoolean("is_config_from_assert", false);
        if (i != 1) {
            i = (z || (i == 0 && z3)) ? 2 : 0;
        }
        ujVarTt.setResult(i).c(j).c("get_config_final").a(i2).tt(i2).c("transparent_params", com.byazt.bp.tt.tt().u());
        HashMap map = new HashMap();
        com.byazt.psp.uj.c(z2, ujVarTt, jSONObject, map);
        if (jSONObject2 != null) {
            map.put("cfg_handle_time", jSONObject2);
        }
        map.put("config_size", Long.valueOf(j2));
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(final com.byazt.ll.tt ttVar, final JSONObject jSONObject) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.11
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, ttVar, jSONObject);
            }
        });
    }

    public static void c(final com.byazt.ll.tt ttVar, final com.byazt.pl.tt ttVar2, final int i) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.13
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, ttVar, ttVar2, i);
            }
        });
    }

    public static void c(final com.byazt.yl.ve veVar, final com.byazt.ll.tt ttVar, final List<com.byazt.yl.ve> list, final List<com.byazt.yl.ve> list2) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.14
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, veVar, ttVar, list, list2);
            }
        });
    }

    public static void c(final com.byazt.nbs.da daVar, final com.byazt.ll.tt ttVar, final String str) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.15
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, daVar, ttVar, str);
            }
        });
    }

    public static void c(final com.byazt.yl.ve veVar, final com.byazt.ll.tt ttVar, final com.byazt.nbs.da daVar, final long j) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.16
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, veVar, ttVar, daVar, j);
            }
        });
    }

    public static void c(final com.byazt.yl.ve veVar, final com.byazt.ll.tt ttVar, final com.byazt.nbs.da daVar) {
        final uj ujVarVe = uj.ve();
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ng.a.17
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tw.c.c().c(ujVarVe, veVar, ttVar, daVar);
            }
        });
    }

    public static void c(com.byazt.ll.tt ttVar, String str) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("cache_cannot_use").c("cache_invalid_info", str);
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, (com.byazt.yl.ve) null, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(com.byazt.ll.tt ttVar, com.byazt.yl.ve veVar, String str) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("rit_cache_cannot_use").c("cache_invalid_info", str);
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map);
        ujVarTt.c("mediationrit_req_type", 2);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(com.byazt.ll.tt ttVar) {
        uj ujVarTt = uj.tt();
        ujVarTt.c("media_will_show");
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, (com.byazt.yl.ve) null, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, com.byazt.pp.c cVar, int i, int i2, String str, long j) {
        c(veVar, ttVar, cVar, i, i2, str, j, (String) null);
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, com.byazt.pp.c cVar, int i, int i2, String str, long j, String str2) {
        uj ujVarTt = uj.tt();
        ujVarTt.setResult(i).tt(cVar != null ? cVar.ve : 0).sl(cVar != null ? cVar.uj : null).c("media_show_fail_listen").c("play_again", Integer.valueOf(i2));
        if (str != null) {
            ujVarTt.c("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            ujVarTt.c("callstack_message", str2);
        }
        HashMap map = new HashMap();
        boolean z = j >= 0;
        if (veVar != null && veVar.isCustomAd()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(nu.ve()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, int i, int i2, int i3, String str) {
        uj ujVarTt = uj.tt();
        ujVarTt.setResult(i2).c("media_show_after").c("play_again", Integer.valueOf(i3)).c(MediationConstant.KEY_REASON, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            ujVarTt.c("callstack_message", str);
        }
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, (com.byazt.nbs.da) null, veVar, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    public static void c(String str, com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar, com.byazt.nbs.da daVar, com.byazt.pp.c cVar) {
        uj ujVarTt = uj.tt();
        uj ujVarSl = ujVarTt.tt(cVar != null ? cVar.c : 0).sl(cVar != null ? cVar.tt : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        ujVarSl.n(str).c("custom_adn_init_fail");
        HashMap map = new HashMap();
        c(ujVarTt, ttVar, daVar, veVar, map);
        ve.c(com.byazt.bp.tt.getContext(), ujVarTt, map);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0127  */
    /* JADX WARN: Code duplicated, block: B:42:0x0139  */
    /* JADX WARN: Code duplicated, block: B:44:0x0140  */
    /* JADX WARN: Code duplicated, block: B:45:0x0146  */
    /* JADX WARN: Code duplicated, block: B:48:0x016b  */
    /* JADX WARN: Code duplicated, block: B:51:0x017a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r20v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.Object>] */
    public static void c(uj ujVar, com.byazt.ll.tt ttVar, com.byazt.nbs.da daVar, com.byazt.yl.ve veVar, Map<String, Object> map) {
        ?? map2;
        Throwable th;
        int[] iArr;
        ?? map3;
        String strC;
        if (ujVar != null) {
            if (ttVar != null) {
                uj ujVarC = ujVar.tt(ttVar.gt()).uj(ttVar.c()).ve(ttVar.ic()).tt(ttVar.aw()).n(ttVar.my()).c("waterfall_abtest", com.byazt.vq.c.c().ve(ttVar.l())).c("if_test", Integer.valueOf(ttVar.n() != 1 ? 0 : ttVar.n())).c("segment_id", Integer.valueOf(ttVar.lo())).c("segment_version", ttVar.pu()).c("waterfall_extra", ttVar.lt()).c("transparent_params", ttVar.a());
                StringBuilder sb = new StringBuilder();
                sb.append(ttVar.ve());
                ujVarC.c("primerit_req_type", sb.toString()).c("req_type", Integer.valueOf(ttVar.uj())).c("parallel_type", Integer.valueOf(ttVar.bm())).c("req_parallel_num", Integer.valueOf(ttVar.lr()));
                if (ttVar.hd() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    ujVar.c("waterfall_bidfloor", Double.valueOf(ttVar.hd()));
                }
                if (ttVar.rl() != null) {
                    ujVar.c("scenario_id", ttVar.rl());
                }
                Map<String, Object> mapCu = ttVar.cu();
                if (mapCu != null) {
                    try {
                        Object obj = mapCu.get(MediationConstant.PANGLE_VID);
                        if (obj instanceof int[]) {
                            iArr = (int[]) obj;
                        } else if (obj instanceof Integer[]) {
                            Integer[] numArr = (Integer[]) obj;
                            int[] iArr2 = new int[numArr.length];
                            for (int i = 0; i < numArr.length; i++) {
                                try {
                                    iArr2[i] = numArr[i].intValue();
                                } catch (Throwable th2) {
                                    th = th2;
                                    iArr = iArr2;
                                    m.c(th);
                                }
                            }
                            iArr = iArr2;
                        } else {
                            iArr = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        iArr = null;
                    }
                    if (iArr != null && iArr.length > 0 && map != 0) {
                        strC = com.byazt.vx.m.c(iArr);
                        if (!TextUtils.isEmpty(strC)) {
                            map.put("external_vid", strC);
                        }
                    }
                    if (map == 0) {
                        map3 = new HashMap();
                    } else {
                        map3 = map;
                    }
                    map3.put("ad_req_optmize", Integer.valueOf(ttVar.sp() ? 1 : 0));
                    map3.put("fill_strategy", Integer.valueOf(ttVar.to()));
                    if (!TextUtils.isEmpty(ttVar.bx())) {
                        map3.put("mediation_map_request", 1);
                    }
                    if (ttVar.tk()) {
                        ujVar.c("share_cache", 1);
                    }
                    map2 = map3;
                    if (ttVar.kp() && TextUtils.equals(ujVar.c, "mediation_request")) {
                        map2 = map3;
                        map3.put("width_equal", Boolean.TRUE);
                        map3.put("accepted_width", Integer.valueOf(ttVar.qy()));
                        map2 = map3;
                    }
                } else {
                    iArr = null;
                    if (iArr != null) {
                        strC = com.byazt.vx.m.c(iArr);
                        if (!TextUtils.isEmpty(strC)) {
                            map.put("external_vid", strC);
                        }
                    }
                    if (map == 0) {
                        map3 = new HashMap();
                    } else {
                        map3 = map;
                    }
                    map3.put("ad_req_optmize", Integer.valueOf(ttVar.sp() ? 1 : 0));
                    map3.put("fill_strategy", Integer.valueOf(ttVar.to()));
                    if (!TextUtils.isEmpty(ttVar.bx())) {
                        map3.put("mediation_map_request", 1);
                    }
                    if (ttVar.tk()) {
                        ujVar.c("share_cache", 1);
                    }
                    map2 = map3;
                    if (ttVar.kp()) {
                        map2 = map3;
                        map3.put("width_equal", Boolean.TRUE);
                        map3.put("accepted_width", Integer.valueOf(ttVar.qy()));
                        map2 = map3;
                    }
                }
            } else {
                map2 = map;
            }
            map2 = map3;
            ?? map4 = map2;
            if (daVar != null) {
                ujVar.n(daVar.z()).x(daVar.rh()).ve(daVar.yv()).uj(daVar.p()).c(daVar.my()).i(String.valueOf(daVar.gr())).t(daVar.yp()).c("server_bidding_extra", daVar.h()).c("origin_type", Integer.valueOf(daVar.da())).c("sub_adtype", Integer.valueOf(daVar.a()));
                if (!TextUtils.isEmpty(daVar.gu())) {
                    ujVar.da(daVar.gu());
                }
                if (daVar.d() != null) {
                    String strVe = daVar.d().ve();
                    String strUj = daVar.d().uj();
                    ujVar.c("pricing_type", Integer.valueOf(daVar.d().c()));
                    if (!TextUtils.isEmpty(strVe)) {
                        ujVar.c("m_aid", strVe);
                    }
                    if (!TextUtils.isEmpty(strUj) && map2 != 0) {
                        map2.put("ad_extra", strUj);
                    }
                }
                if (map2 == 0) {
                    map2 = new HashMap();
                }
                map2.put("if_reuse", Integer.valueOf(daVar.i()));
                map4 = map2;
            }
            if (veVar != null) {
                ujVar.n(veVar.getAdNetWorkName()).x(veVar.getAdNetworkSlotId()).n(veVar.getAdType()).c(veVar.getAdNetworkSlotType()).t(veVar.getExchangeRate()).sp(veVar.getReqId()).a(veVar.getSdkVersion()).ve(veVar.getLoadSort()).uj(veVar.getShowSort()).i(String.valueOf(veVar.getCpm())).da(veVar.getDiscount()).c(veVar.getEventMap()).c("mediationrit_req_type", Integer.valueOf(veVar.getMediationRitReqType(ttVar != null ? ttVar.c() : null))).c("mediationrit_req_type_src", Integer.valueOf(veVar.getMediationRitReqTypeSrc(ttVar != null ? ttVar.c() : null))).c("origin_type", Integer.valueOf(veVar.getOriginType())).c("sub_adtype", Integer.valueOf(veVar.getSubAdType()));
                if (veVar.getAdType() == 8 || veVar.getAdType() == 7) {
                    ujVar.c("is_video_cache_success", Integer.valueOf(veVar.isCacheSuccess() ? 1 : 0)).c("is_mock_video_cache_api", Integer.valueOf(!veVar.adnHasAdVideoCachedApi() ? 1 : 0));
                }
                if (!TextUtils.isEmpty(veVar.getDiscount())) {
                    ujVar.da(veVar.getDiscount());
                }
                if (!TextUtils.isEmpty(veVar.getLevelTag())) {
                    ujVar.c("level_tag", veVar.getLevelTag());
                }
                String aid = veVar.getAid();
                String adExtra = veVar.getAdExtra();
                if (!TextUtils.isEmpty(aid) && !TextUtils.equals(ujVar.c, "media_show_fail")) {
                    ujVar.c("m_aid", aid);
                }
                if (!TextUtils.isEmpty(adExtra) && map4 != 0) {
                    map4.put("ad_extra", adExtra);
                }
                if (TextUtils.equals(ujVar.c, "bidding_win_event")) {
                    if (!TextUtils.isEmpty(veVar.getWinCallback())) {
                        ujVar.c("win_callback", veVar.getWinCallback());
                    }
                    if (!TextUtils.isEmpty(veVar.getFailCallback())) {
                        ujVar.c("fail_callback", veVar.getFailCallback());
                    }
                }
                if (veVar.isServerBiddingAd()) {
                    ujVar.c("pricing_type", Integer.valueOf(veVar.getPricingType()));
                }
                if (map4 == 0) {
                    map4 = new HashMap();
                }
                map4.put("if_reuse", Integer.valueOf(veVar.getIfReuseAds()));
                map4.put("timeout_req", Integer.valueOf(veVar.isTimeoutFill() ? 1 : 0));
                map4.put("is_callback", Integer.valueOf(veVar.isIsCallback() ? 1 : 0));
            }
            if (ttVar != null && ttVar.tk()) {
                if (veVar != null && !TextUtils.isEmpty(veVar.getOriginLinkId())) {
                    map4.put("origin_link_id", veVar.getOriginLinkId());
                }
                if (!TextUtils.isEmpty(ttVar.da())) {
                    map4.put("cur_prime_rit", ttVar.da());
                }
            }
            if (ttVar != null && ttVar.tk() && veVar != null && !TextUtils.isEmpty(veVar.getOriginPrimeRit())) {
                ujVar.tt(veVar.getOriginPrimeRit());
            }
            if (ttVar != null) {
                String str = ttVar.c() + LoginConstants.UNDER_LINE;
                if (daVar != null) {
                    ujVar.c("client_req_id", str + daVar.rh());
                } else if (veVar != null) {
                    ujVar.c("client_req_id", str + veVar.getAdNetworkSlotId());
                }
            }
            if (com.byazt.dc.n.n(ujVar.ve)) {
                if (TextUtils.equals(ujVar.c, "media_request")) {
                    if (com.byazt.dc.n.c(ujVar.ve)) {
                        map4.put("is_dex_adapter", 1);
                        map4.put("dex_adapter_version", Integer.valueOf(u.ve("com.byted.mixed")));
                    } else {
                        map4.put("is_dex_adapter", 0);
                    }
                } else if (veVar != null) {
                    boolean zIsLoadByDexPl = veVar.isLoadByDexPl();
                    map4.put("is_dex_adapter", Integer.valueOf(zIsLoadByDexPl ? 1 : 0));
                    if (zIsLoadByDexPl) {
                        map4.put("dex_adapter_version", Integer.valueOf(u.ve("com.byted.mixed")));
                    }
                } else if (map4.containsKey("is_dex_adapter")) {
                    map4.put("is_dex_adapter", 2);
                }
                map4.put("dex_status", Integer.valueOf(com.byazt.xiv.n.tt(ujVar.ve)));
                m.c("AdapterPl", ujVar.ve + ",  " + ujVar.c + ", is_dex_adapter: " + map4.get("is_dex_adapter") + ", dex_adapter_version: " + map4.get("dex_adapter_version") + ", dex_status: " + map4.get("dex_status"));
            }
            ujVar.c("isFusion", Boolean.TRUE);
        }
    }
}
