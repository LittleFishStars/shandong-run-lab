package com.byazt.tw;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.eu.n;
import com.byazt.ll.tt;
import com.byazt.nbs.da;
import com.byazt.ng.a;
import com.byazt.ng.uj;
import com.byazt.ng.x;
import com.byazt.nr.m;
import com.byazt.sx.ve;
import com.byazt.vx.nu;
import com.byazt.vx.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 69, 20})
public class c {
    public static volatile c c;

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private static void tt(uj ujVar) {
        ujVar.c("block_pacing", "-1");
        ujVar.c("rit_adn_show_rule_id", "-1");
        ujVar.c("block_show_count", "-1");
    }

    public void c(uj ujVar, tt ttVar, String str, boolean z, String str2, int i, Map<String, Object> map) {
        String strC;
        int i2;
        if (i > 0) {
            strC = com.byazt.pp.c.c(i);
        } else {
            strC = "";
            i = 0;
        }
        if (i != 0) {
            i2 = z ? 2 : 3;
        } else {
            i2 = !z ? 1 : 0;
        }
        ujVar.c("mediation_request").c("server_bidding_extra", str2).c("mediation_req_type", Integer.valueOf(i2)).c("ad_count", Integer.valueOf(ttVar != null ? ttVar.gr() : 0)).tt(i).sl(strC);
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        if (ttVar != null && ttVar.ve() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", com.byazt.ix.uj.c().ve());
                jSONObject.put("interval", com.byazt.ix.uj.c().uj());
                jSONObject.put("primerit_list", com.byazt.ix.uj.c().tt());
                map2.put("preload_info", jSONObject);
            } catch (JSONException e) {
                m.c(e);
            }
        }
        if (ttVar != null && ttVar.my() == 3 && (com.byazt.ii.c.c().sl() || com.byazt.ii.c.c().t())) {
            map2.put("init_splash_request_duration", Long.valueOf(com.byazt.ii.c.c().i()));
        }
        if (ttVar != null && ttVar.nb() != null && !ttVar.nb().isEmpty()) {
            map2.putAll(ttVar.nb());
        }
        map2.put("csj_plugin_version", ve.uj());
        a.c(ujVar, ttVar, (da) null, (com.byazt.yl.ve) null, map2);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map2);
    }

    public void c(uj ujVar, com.byazt.yl.ve veVar, tt ttVar, com.byazt.nbs.tt ttVar2, long j, String str, boolean z, int i, boolean z2, boolean z3) {
        ujVar.c("mediation_fill").c(j).c("server_bidding_extra", str).c("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).c("ad_count", Integer.valueOf(i)).tt(0).sl("");
        HashMap map = new HashMap();
        if (ttVar != null && ttVar.my() == 3) {
            if (com.byazt.ii.c.c().sl()) {
                com.byazt.ii.c.c().c(com.byazt.ng.c.ve);
                map.put("init_splash_fill_duration", Long.valueOf(com.byazt.ii.c.c().da()));
            } else if (com.byazt.ii.c.c().t()) {
                map.put("init_splash_fill_duration", Long.valueOf(com.byazt.ii.c.c().da()));
            }
        }
        a.c(ujVar, ttVar, (da) null, veVar, map);
        map.put("timeout_req", Integer.valueOf(z2 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z3 ? 1 : 0));
        if (ttVar != null && ttVar.nb() != null && !ttVar.nb().isEmpty()) {
            map.putAll(ttVar.nb());
        }
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, tt ttVar, com.byazt.yl.ve veVar, long j, int i, int i2, int i3, String str, int i4, int i5, com.byazt.nbs.tt ttVar2, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectI;
        ujVar.c("mediation_request_end").c(j).c("ad_count", Integer.valueOf(i4)).c(MediationConstant.KEY_REASON, Integer.valueOf(i5)).tt(i3);
        HashMap map = new HashMap();
        a.c(ujVar, ttVar, (da) null, veVar, map);
        map.put("requested_adn_count", Integer.valueOf(i));
        map.put("requested_level_count", Integer.valueOf(i2));
        if (jSONObject != null) {
            map.put("auto_detail", jSONObject);
        }
        if (jSONObject2 != null) {
            map.put("req_time", jSONObject2);
        }
        if (ttVar2 != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("layer_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(ttVar2.n())));
                jSONObject3.putOpt("req_interval", Long.valueOf(ttVar2.sp()));
                jSONObject3.putOpt("total_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(ttVar2.a())));
                map.put("preload_req", jSONObject3);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        if (ttVar != null && (jSONObjectI = ttVar.i()) != null) {
            map.put("behavior", jSONObjectI);
        }
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, @Nullable tt ttVar, com.byazt.pp.c cVar, String str) {
        JSONObject jSONObjectI;
        ujVar.c("total_load_fail").c("server_bidding_extra", str);
        int i = cVar.c;
        if (i == 10003) {
            ujVar.tt(10010).sl("延长瀑布流总超时时长或者缩短层超时并添加兜底代码位");
            c(ujVar);
        } else if (i == 810085) {
            ujVar.tt(i).sl(cVar.tt);
            c(ujVar);
        } else if (cVar instanceof com.byazt.bnd.ve) {
            com.byazt.bnd.ve veVar = (com.byazt.bnd.ve) cVar;
            ujVar.tt(i).sl(cVar.tt);
            ujVar.c("block_pacing", veVar.c());
            ujVar.c("waterfall_show_rule_id", veVar.tt());
        } else if (cVar instanceof com.byazt.bnd.tt) {
            com.byazt.bnd.tt ttVar2 = (com.byazt.bnd.tt) cVar;
            ujVar.tt(i).sl(cVar.tt);
            ujVar.c("block_show_count", ttVar2.c());
            ujVar.c("waterfall_show_rule_id", ttVar2.tt());
        } else if (cVar instanceof com.byazt.bnd.c) {
            ujVar.tt(i).sl(cVar.tt);
            c(ujVar);
        } else {
            ujVar.tt(10086).sl("Ad load fail all loadsorts! ");
            c(ujVar);
        }
        HashMap map = new HashMap();
        if (ttVar != null && (jSONObjectI = ttVar.i()) != null) {
            map.put("behavior", jSONObjectI);
        }
        if (ttVar != null && ttVar.nb() != null && !ttVar.nb().isEmpty()) {
            map.putAll(ttVar.nb());
        }
        ujVar.c("ad_count", Integer.valueOf(ttVar != null ? ttVar.gr() : 0));
        a.c(ujVar, ttVar, (da) null, (com.byazt.yl.ve) null, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, da daVar, tt ttVar, String str, boolean z, int i, int i2, int i3, int i4, com.byazt.pp.c cVar, long j, boolean z2, boolean z3, String str2, long j2) {
        int iUj;
        if ((cVar instanceof com.byazt.bnd.ve) || (cVar instanceof com.byazt.bnd.tt) || (cVar instanceof com.byazt.bnd.c)) {
            ujVar.tt(cVar.c).sl(cVar.tt);
        }
        ujVar.c("media_request").a(str).c(j2).c("ad_count", Integer.valueOf(ttVar != null ? ttVar.gr() : 0)).c("adn_count", Integer.valueOf(i2)).c("mediationrit_req_type", Integer.valueOf(i3)).c("mediationrit_req_type_src", Integer.valueOf(i4)).c("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).c("media_req_type", Integer.valueOf(i));
        HashMap map = new HashMap();
        map.put("timeout_req", Integer.valueOf(z2 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z3 ? 1 : 0));
        if (ttVar != null && ttVar.tk() && !TextUtils.isEmpty(str2)) {
            map.put("origin_link_id", str2);
        }
        if (ttVar != null && ttVar.pf() != null && daVar != null && MediationConstant.ADN_PANGLE.equals(daVar.z()) && daVar.u() == 5 && (iUj = ttVar.pf().uj()) == 1) {
            map.put("support_render_control", Integer.valueOf(iUj));
        }
        if (j != -1) {
            map.put(CropKey.RESULT_KEY_START_TIME, Long.valueOf(SystemClock.elapsedRealtime() - j));
        }
        a.c(ujVar, ttVar, daVar, (com.byazt.yl.ve) null, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, com.byazt.yl.ve veVar, int i, String str, long j, tt ttVar, int i2, int i3, int i4, String str2, long j2, long j3) {
        ujVar.c("media_fill").c(j).tt(i).sl(str).c("adn_count", Integer.valueOf(i2)).c("adn_preload", Integer.valueOf((veVar == null || !veVar.isAdnPreload()) ? 0 : 1)).c("ad_count", Integer.valueOf(i3));
        ujVar.c("fill_type", Integer.valueOf(i4));
        if (str2 != null) {
            ujVar.c("sub_adn_name", str2);
        }
        HashMap map = new HashMap();
        boolean z = j2 >= 0;
        if (veVar != null && veVar.isCustomAd()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(nu.ve()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        if (j3 != -1) {
            map.put("end_time", Long.valueOf(j3));
        }
        if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName()) && veVar.getAdType() == 5 && veVar.getSupportRender() == 1) {
            map.put("if_to_express", Integer.valueOf(veVar.getSupportRender()));
        }
        if (com.byazt.bp.tt.tt().b() && veVar != null && 5 == veVar.getAdType()) {
            ujVar.c("ex_info", x.c().c(veVar));
        }
        Long lC = c(veVar);
        if (lC != null) {
            ujVar.c("cid", String.valueOf(lC));
        }
        a.c(ujVar, ttVar, (da) null, veVar, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    private Long c(com.byazt.yl.ve veVar) {
        Map<String, Object> extraMsg;
        if (veVar == null || (extraMsg = veVar.getExtraMsg()) == null || !(extraMsg.get("creative_id") instanceof Long)) {
            return null;
        }
        return (Long) extraMsg.get("creative_id");
    }

    public void c(uj ujVar, com.byazt.pp.c cVar, tt ttVar, da daVar, int i, int i2, int i3, String str, long j, String str2, String str3, String str4, long j2) {
        if (cVar instanceof com.byazt.bnd.ve) {
            com.byazt.bnd.ve veVar = (com.byazt.bnd.ve) cVar;
            ujVar.tt(cVar.c).sl(cVar.tt);
            ujVar.c("block_pacing", veVar.c());
            ujVar.c("adn_rit_show_rule_id", veVar.tt());
        } else if (cVar instanceof com.byazt.bnd.tt) {
            com.byazt.bnd.tt ttVar2 = (com.byazt.bnd.tt) cVar;
            ujVar.tt(cVar.c).sl(cVar.tt);
            ujVar.c("block_show_count", ttVar2.c());
            ujVar.c("adn_rit_show_rule_id", ttVar2.tt());
        } else if (cVar instanceof com.byazt.bnd.c) {
            ujVar.tt(cVar.c);
            ujVar.sl(cVar.tt);
            tt(ujVar);
        } else {
            ujVar.tt(cVar != null ? cVar.ve : -1).sl(cVar != null ? cVar.uj : "unknown error");
            tt(ujVar);
        }
        ujVar.c("media_fill_fail").c(j).a(str).c("adn_count", Integer.valueOf(i)).c("adn_preload", 0).c("mediationrit_req_type", Integer.valueOf(i2)).c("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap map = new HashMap();
        Object objC = cVar.c("is_dex_adapter");
        if (objC != null) {
            map.put("is_dex_adapter", objC);
        }
        boolean z = j2 >= 0;
        if (daVar != null && daVar.sv()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(nu.ve()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        a.c(ujVar, ttVar, daVar, (com.byazt.yl.ve) null, map);
        if (!TextUtils.isEmpty(str2)) {
            ujVar.i(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            ujVar.c("level_tag", str3);
        }
        if (str4 != null) {
            ujVar.c("sub_adn_name", str4);
        }
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, da daVar, tt ttVar, int i, int i2) {
        ujVar.c("adapter_request_fail").c(0L).a((String) null).tt(-99999).sl("adapter create fail !").c("mediationrit_req_type", Integer.valueOf(i)).c("mediationrit_req_type_src", Integer.valueOf(i2));
        HashMap map = new HashMap();
        a.c(ujVar, ttVar, daVar, (com.byazt.yl.ve) null, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, tt ttVar, int i) {
        ujVar.c("get_config_error").tt(i);
        HashMap map = new HashMap();
        a.c(ujVar, ttVar, (da) null, (com.byazt.yl.ve) null, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, com.byazt.yl.ve veVar, tt ttVar, List<com.byazt.yl.ve> list, List<com.byazt.yl.ve> list2) {
        Iterator<com.byazt.yl.ve> it;
        HashMap map;
        Iterator<com.byazt.yl.ve> it2;
        ujVar.c("bidding_win_event");
        HashMap map2 = new HashMap();
        a.c(ujVar, ttVar, (da) null, veVar, map2);
        JSONArray jSONArray = new JSONArray();
        if (!p.c(list)) {
            Iterator<com.byazt.yl.ve> it3 = list.iterator();
            while (it3.hasNext()) {
                com.byazt.yl.ve next = it3.next();
                if (next != null) {
                    it2 = it3;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        map = map2;
                        try {
                            jSONObject.putOpt("mediation_rit", next.getAdNetworkSlotId());
                            jSONObject.putOpt(MediationConstant.EXTRA_ADN_NAME, next.getAdNetWorkName());
                            jSONObject.putOpt("load_sort", Integer.valueOf(next.getLoadSort()));
                            jSONObject.putOpt("show_sort", Integer.valueOf(next.getShowSort()));
                            jSONObject.putOpt("exchange_rate", next.getExchangeRate());
                            jSONObject.putOpt("rit_cpm", Double.valueOf(next.getCpm()));
                            jSONObject.putOpt("m_aid", next.getAid());
                            jSONObject.putOpt("req_bidding_type", Integer.valueOf(next.getAdNetworkSlotType()));
                            jSONObject.putOpt("win_state", 1);
                            jSONObject.putOpt("ad_extra", next.getAdExtra());
                            jSONObject.putOpt("win_callback", next.getWinCallback());
                            jSONObject.putOpt("loss_callback", next.getFailCallback());
                            if (next.isServerBiddingAd()) {
                                jSONObject.putOpt("pricing_type", Integer.valueOf(next.getPricingType()));
                            }
                            jSONArray.put(jSONObject);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        map = map2;
                    }
                } else {
                    map = map2;
                    it2 = it3;
                }
                it3 = it2;
                map2 = map;
            }
        }
        HashMap map3 = map2;
        if (!p.c(list2)) {
            Iterator<com.byazt.yl.ve> it4 = list2.iterator();
            while (it4.hasNext()) {
                com.byazt.yl.ve next2 = it4.next();
                if (next2 != null) {
                    it = it4;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = jSONArray;
                        try {
                            jSONObject2.putOpt("mediation_rit", next2.getAdNetworkSlotId());
                            jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, next2.getAdNetWorkName());
                            jSONObject2.putOpt("load_sort", Integer.valueOf(next2.getLoadSort()));
                            jSONObject2.putOpt("show_sort", Integer.valueOf(next2.getShowSort()));
                            jSONObject2.putOpt("exchange_rate", next2.getExchangeRate());
                            jSONObject2.putOpt("rit_cpm", Double.valueOf(next2.getCpm()));
                            jSONObject2.putOpt("m_aid", next2.getAid());
                            jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next2.getAdNetworkSlotType()));
                            jSONObject2.putOpt("win_state", 0);
                            jSONObject2.putOpt("ad_extra", next2.getAdExtra());
                            jSONObject2.putOpt("win_callback", next2.getWinCallback());
                            jSONObject2.putOpt("loss_callback", next2.getFailCallback());
                            if (next2.isServerBiddingAd()) {
                                jSONObject2.putOpt("pricing_type", Integer.valueOf(next2.getPricingType()));
                            }
                            jSONArray = jSONArray2;
                            jSONArray.put(jSONObject2);
                        } catch (Exception unused3) {
                            jSONArray = jSONArray2;
                        }
                    } catch (Exception unused4) {
                    }
                } else {
                    it = it4;
                }
                it4 = it;
            }
        }
        map3.put("others", jSONArray);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map3);
    }

    public void c(uj ujVar, tt ttVar, JSONObject jSONObject) {
        ujVar.c("start_bidding_request").c(2).c("ad_count", Integer.valueOf(ttVar != null ? ttVar.gr() : 0));
        HashMap map = new HashMap();
        if (jSONObject != null) {
            map.put("exchange_time", jSONObject);
        }
        a.c(ujVar, ttVar, (da) null, (com.byazt.yl.ve) null, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, tt ttVar, com.byazt.pl.tt ttVar2, int i) {
        if (ttVar2 == null) {
            return;
        }
        uj result = ujVar.c("return_bidding_result").c(ttVar2.sp).setResult(ttVar2.f28946a);
        com.byazt.pp.c cVar = ttVar2.x;
        uj ujVarTt = result.tt(cVar == null ? 0 : cVar.c);
        com.byazt.pp.c cVar2 = ttVar2.x;
        ujVarTt.sl(cVar2 == null ? "" : cVar2.tt).c(2).c("fill_type", Integer.valueOf(i)).c("server_bidding_extra", ttVar2.uj).c("ad_count", Integer.valueOf(ttVar2.i));
        HashMap map = new HashMap();
        com.byazt.psp.uj.c(ttVar2.da, ttVar2.c, map);
        JSONObject jSONObject = ttVar2.sl;
        if (jSONObject != null) {
            map.put("exchange_time", jSONObject);
        }
        a.c(ujVar, ttVar, (da) null, (com.byazt.yl.ve) null, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, da daVar, tt ttVar, String str) {
        ujVar.c("get_bidding_adm_to_adn").a(str);
        HashMap map = new HashMap();
        a.c(ujVar, ttVar, daVar, (com.byazt.yl.ve) null, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, com.byazt.yl.ve veVar, tt ttVar, da daVar, long j) {
        ujVar.c("bidding_adm_load").c(j);
        HashMap map = new HashMap();
        if (com.byazt.bp.tt.tt().b() && veVar != null && 5 == veVar.getAdType()) {
            ujVar.c("ex_info", x.c().c(veVar));
        }
        a.c(ujVar, ttVar, daVar, veVar, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, com.byazt.yl.ve veVar, tt ttVar, da daVar) {
        ujVar.c("bidding_adm_cache");
        HashMap map = new HashMap();
        a.c(ujVar, ttVar, daVar, veVar, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, tt ttVar, com.byazt.yl.ve veVar, da daVar) {
        ujVar.c("media_cache_success");
        HashMap map = new HashMap();
        a.c(ujVar, ttVar, daVar, veVar, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(uj ujVar, tt ttVar, com.byazt.yl.ve veVar, long j) {
        ujVar.c("mediation_video_cached").c(j);
        HashMap map = new HashMap();
        a.c(ujVar, ttVar, (da) null, veVar, map);
        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
    }

    public void c(final uj ujVar, final com.byazt.yl.ve veVar, final tt ttVar, final int i, final String str, final long j, final String str2, final boolean z, final int i2) {
        n.uj(new Runnable() { // from class: com.byazt.tw.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yl.ve veVar2;
                com.byazt.yl.ve veVar3 = veVar;
                ujVar.c("media_show_listen").c("adn_preload", Integer.valueOf((veVar3 == null || !veVar3.isAdnPreload()) ? 0 : 1)).c("play_again", Integer.valueOf(i)).c("is_repeat", Integer.valueOf(z ? 1 : 0));
                String str3 = str;
                if (str3 != null) {
                    ujVar.c("sub_adn_name", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    ujVar.c("callstack_message", str2);
                }
                HashMap map = new HashMap();
                map.put("enable_label_return", Integer.valueOf(com.byazt.bp.tt.tt().lr() ? 1 : 0));
                map.put("if_labelapi_call", Integer.valueOf(com.byazt.bp.c.t().c() ? 1 : 0));
                map.put("is_fill_quick_ad", Integer.valueOf(i2));
                com.byazt.bg.ve.c(veVar, ttVar, map);
                boolean z2 = j >= 0;
                com.byazt.yl.ve veVar4 = veVar;
                if (veVar4 != null && veVar4.isCustomAd()) {
                    map.put("custom_adn_sample_ratio", Double.valueOf(nu.ve()));
                    map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
                    if (z2) {
                        map.put("custom_adn_rec_time", Long.valueOf(j));
                    }
                }
                com.byazt.yl.ve veVar5 = veVar;
                if (veVar5 != null && !TextUtils.isEmpty(veVar5.getAdLifecycleId())) {
                    com.byazt.gc.c.c(map, veVar.getAdLifecycleId());
                }
                a.c(ujVar, ttVar, (da) null, veVar, map);
                com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
                if (com.byazt.bp.tt.tt().da() && (veVar2 = veVar) != null && MediationConstant.ADN_PANGLE.equals(veVar2.getAdNetWorkName())) {
                    com.byazt.ng.ve.uj();
                }
            }
        });
    }

    public void c(final uj ujVar, final com.byazt.yl.ve veVar, final tt ttVar, final int i, final String str, final long j, final String str2, final boolean z) {
        n.uj(new Runnable() { // from class: com.byazt.tw.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yl.ve veVar2 = veVar;
                ujVar.c("media_click_listen").c("adn_preload", Integer.valueOf((veVar2 == null || !veVar2.isAdnPreload()) ? 0 : 1)).c("play_again", Integer.valueOf(i)).c("is_repeat", Integer.valueOf(z ? 1 : 0));
                String str3 = str;
                if (str3 != null) {
                    ujVar.c("sub_adn_name", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    ujVar.c("callstack_message", str2);
                }
                HashMap map = new HashMap();
                boolean z2 = j >= 0;
                com.byazt.yl.ve veVar3 = veVar;
                if (veVar3 != null && veVar3.isCustomAd()) {
                    map.put("custom_adn_sample_ratio", Double.valueOf(nu.ve()));
                    map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
                    if (z2) {
                        map.put("custom_adn_rec_time", Long.valueOf(j));
                    }
                }
                com.byazt.yl.ve veVar4 = veVar;
                if (veVar4 != null && !TextUtils.isEmpty(veVar4.getAdLifecycleId())) {
                    com.byazt.gc.c.c(map, veVar.getAdLifecycleId());
                }
                a.c(ujVar, ttVar, (da) null, veVar, map);
                com.byazt.ng.ve.c(com.byazt.bp.tt.getContext(), ujVar, map);
            }
        });
    }

    private static void c(uj ujVar) {
        ujVar.c("block_pacing", "-1");
        ujVar.c("waterfall_show_rule_id", "-1");
        ujVar.c("block_show_count", "-1");
    }
}
