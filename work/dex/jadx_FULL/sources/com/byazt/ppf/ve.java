package com.byazt.ppf;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.it.n;
import com.byazt.nd.a;
import com.byazt.nr.m;
import com.byazt.ogz.sl;
import com.byazt.omf.gt;
import com.byazt.vif.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f28955a;
    public static long n;
    public static String sp;
    public static long uj;
    public static AtomicInteger c = new AtomicInteger(0);
    public static int tt = -1;
    public static int ve = -1;
    public static volatile int x = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str) {
        tt = 100008;
        long jCurrentTimeMillis = System.currentTimeMillis() - n;
        uj = jCurrentTimeMillis;
        tt(tt, ve, jCurrentTimeMillis);
        sp(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n n(String str) {
        return uj.tt(str, "uchain_data");
    }

    private static void sp(String str) {
        String strQt;
        String strFe;
        JSONObject jSONObjectTt;
        tt = -1;
        sl slVarTt = gt.tt();
        if (slVarTt != null && (jSONObjectTt = tt((strQt = slVarTt.qt()), (strFe = slVarTt.fe()), str)) != null && jSONObjectTt.length() > 0) {
            ve = 2;
            f28955a = strQt;
            sp = strFe;
            long jCurrentTimeMillis = System.currentTimeMillis() - n;
            uj = jCurrentTimeMillis;
            tt(tt, ve, jCurrentTimeMillis);
            ve(jSONObjectTt);
            return;
        }
        JSONObject jSONObjectVe = ve();
        if (jSONObjectVe == null || jSONObjectVe.length() <= 0) {
            c.set(3);
            tt(tt, ve, uj);
            return;
        }
        ve = 0;
        sp = "uc_dsl/uc_dsl.bin";
        long jCurrentTimeMillis2 = System.currentTimeMillis() - n;
        uj = jCurrentTimeMillis2;
        tt(tt, ve, jCurrentTimeMillis2);
        ve(jSONObjectVe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            jSONObject = ve();
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            c.set(3);
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
        if (jSONObjectOptJSONObject != null) {
            x = jSONObjectOptJSONObject.optInt("version");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("event_template");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
            c.set(3);
        } else {
            com.byazt.bh.tt.INSTANCE.c(jSONObjectOptJSONObject2);
            c.set(2);
        }
    }

    public static boolean tt() {
        boolean z = c() >= 3000;
        m.c("UChain_utils", "enableUChainModel: " + z);
        return z;
    }

    /* JADX INFO: renamed from: com.byazt.ppf.ve$4, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS})
    public static class AnonymousClass4 implements com.byazt.nd.ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UUID f28956a;
        public final /* synthetic */ Map c;
        public final /* synthetic */ long da;
        public final /* synthetic */ long i;
        public final /* synthetic */ ic n;
        public final /* synthetic */ String sp;
        public final /* synthetic */ AtomicBoolean tt;
        public final /* synthetic */ StringBuilder uj;
        public final /* synthetic */ JSONArray ve;
        public final /* synthetic */ String x;

        public AnonymousClass4(Map map, AtomicBoolean atomicBoolean, JSONArray jSONArray, StringBuilder sb, ic icVar, UUID uuid, String str, String str2, long j, long j2) {
            this.c = map;
            this.tt = atomicBoolean;
            this.ve = jSONArray;
            this.uj = sb;
            this.n = icVar;
            this.f28956a = uuid;
            this.sp = str;
            this.x = str2;
            this.i = j;
            this.da = j2;
        }

        @Override // com.byazt.nd.ve
        public void c(com.byazt.cq.c cVar) {
            this.c.put(cVar.x().c(), Long.valueOf(System.currentTimeMillis()));
            cVar.c(new com.byazt.nd.uj() { // from class: com.byazt.ppf.ve.4.1
                @Override // com.byazt.nd.uj
                public a tt() {
                    return new a() { // from class: com.byazt.ppf.ve.4.1.1
                        @Override // com.byazt.nd.a
                        public String c(String str, com.byazt.cq.c cVar2) {
                            return "";
                        }

                        @Override // com.byazt.nd.a
                        public JSONObject c(JSONObject jSONObject, com.byazt.cq.c cVar2) {
                            Map<String, Object> mapC = cVar2.c();
                            if (mapC != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    for (Map.Entry<String, Object> entry : mapC.entrySet()) {
                                        jSONObject2.put(entry.getKey(), entry.getValue());
                                    }
                                    jSONObject.put("u_context", jSONObject2);
                                } catch (JSONException unused) {
                                }
                            }
                            return jSONObject;
                        }

                        @Override // com.byazt.nd.a
                        public Map<String, Object> c(Map<String, Object> map, com.byazt.cq.c cVar2) {
                            return Collections.emptyMap();
                        }
                    };
                }

                @Override // com.byazt.nd.uj
                public com.byazt.nd.n ve() {
                    return new com.byazt.nd.n() { // from class: com.byazt.ppf.ve.4.1.2
                        @Override // com.byazt.nd.n
                        public void c(com.byazt.cq.c cVar2, Map<String, Object> map) {
                            try {
                                com.byazt.bh.c cVarX = cVar2.x();
                                String strC = cVarX.c();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event", strC);
                                jSONObject.put("status", true);
                                Long l = (Long) AnonymousClass4.this.c.remove(strC);
                                if (l != null) {
                                    jSONObject.put("duration", System.currentTimeMillis() - l.longValue());
                                }
                                ve.c(map, jSONObject);
                                AnonymousClass4.this.tt.set(true);
                                AnonymousClass4.this.ve.put(jSONObject);
                                if (TextUtils.isEmpty(cVarX.tt())) {
                                    return;
                                }
                                AnonymousClass4.this.uj.append(Uri.parse(cVarX.tt()).getHost());
                            } catch (JSONException e) {
                                m.c(e);
                            }
                        }

                        @Override // com.byazt.nd.n
                        public void c(com.byazt.cq.c cVar2, Map<String, Object> map, final com.byazt.qb.c cVar3) {
                            if (cVar3 != null) {
                                try {
                                    ve.c(map, new com.byazt.cr.c() { // from class: com.byazt.ppf.ve.4.1.2.1
                                        @Override // com.byazt.cr.c
                                        public int c() {
                                            return cVar3.c();
                                        }

                                        @Override // com.byazt.cr.c
                                        public String tt() {
                                            return cVar3.tt();
                                        }
                                    });
                                } catch (JSONException e) {
                                    m.c(e);
                                    return;
                                }
                            }
                            String strC = cVar2.x().c();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("event", strC);
                            jSONObject.put("status", false);
                            Long l = (Long) AnonymousClass4.this.c.remove(strC);
                            if (l != null) {
                                jSONObject.put("duration", System.currentTimeMillis() - l.longValue());
                            }
                            ve.c(map, jSONObject);
                            AnonymousClass4.this.ve.put(jSONObject);
                        }
                    };
                }
            });
        }

        @Override // com.byazt.nd.ve
        public void c(com.byazt.cq.tt ttVar) {
            if (ve.tt()) {
                com.byazt.ddx.uj.tt(this.n, ve.c(this.uj.toString(), this.n));
                ve.tt(this.f28956a, this.sp, this.ve, this.n, this.x, this.i > 0 ? System.currentTimeMillis() - this.i : -1L, this.da, this.tt.get());
            }
        }
    }

    private static JSONObject tt(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str4 = n(str3).get(str, "");
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            String strVe = com.byazt.nr.c.ve(str4);
            ve = 2;
            f28955a = str;
            sp = str2;
            return new JSONObject(strVe);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "95d9ae8de4e66aaf458fdd49879c67fa";
            str2 = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20108/uchain_dsl.bin";
        }
        f28955a = str;
        sp = str2;
        n = System.currentTimeMillis();
        JSONObject jSONObjectTt = tt(f28955a, sp, str3);
        if (jSONObjectTt != null && jSONObjectTt.length() > 0) {
            ve = 2;
            long jCurrentTimeMillis = System.currentTimeMillis() - n;
            uj = jCurrentTimeMillis;
            tt(tt, ve, jCurrentTimeMillis);
            ve(jSONObjectTt);
            return;
        }
        com.byazt.va.c cVarN = com.byazt.hy.n.c().tt().n();
        if (cVarN == null) {
            c.set(3);
            return;
        }
        cVarN.c(sp);
        final String str4 = f28955a;
        final String str5 = sp;
        cVarN.c(new com.byazt.mh.c() { // from class: com.byazt.ppf.ve.1
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                int unused = ve.ve = 1;
                String unused2 = ve.f28955a = str4;
                String unused3 = ve.sp = str5;
                if (ttVar != null) {
                    try {
                        if (ttVar.i()) {
                            JSONObject jSONObjectC = com.byazt.by.a.c(ttVar.sl(), "uchain_dsl");
                            long unused4 = ve.uj = System.currentTimeMillis() - ve.n;
                            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                                ve.tt(ve.tt, ve.ve, ve.uj);
                                ve.ve(jSONObjectC);
                                ve.n(str3).put(str4, com.byazt.nr.c.tt(jSONObjectC.toString()));
                                return;
                            }
                            ve.a(str3);
                            return;
                        }
                    } catch (Throwable unused5) {
                        ve.a(str3);
                        return;
                    }
                }
                ve.a(str3);
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                int unused = ve.ve = 1;
                ve.a(str3);
            }
        });
    }

    public static JSONObject ve() {
        try {
            return new JSONObject("{\"template_info\":{\"version\":\"2.1.8\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}&deep_link=${deep_link}&landing_type=${landing_type}&saas_info=${saas_info}\",\"priority\":1,\"condition\":\"${coupon!=null || (ec_schema!=null&&ec_schema!='') || (live_room_id!=null&&live_room_id!='')}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"condition\":\"${wc_miniapp_info!=null}\",\"priority\":2,\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(is_video_lp==true||if_both_open==1)&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||(is_video_lp!=true&&if_both_open==0)}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}&voice_control=${voice_control}&orientation=${orientation}&video_voice_control=${video_voice_control}&if_lpua_package=${if_lpua_package}\",\"priority\":4,\"condition\":\"${interaction_type==3||ext.interaction_type==3}\",\"params\":{},\"next\":[{\"condition\":\"${if_both_open==1&&(is_video_lp!=true||app.appleid==null||app.appleid=='0')}\",\"name\":\"download\"}],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"priority\":3,\"condition\":\"${deep_link!=null||ulink!=null}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}&skan=${skan}\",\"priority\":5,\"condition\":\"${exist(app.download_url, download_url) != null && exist(app.download_url, download_url) != '' && (interaction_type==4||ext.interaction_type==4)}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${if_both_open==0}\",\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception unused) {
            return null;
        }
    }

    private static ic ve(Map<String, Object> map) {
        if (map == null || !map.containsKey("material_meta")) {
            return null;
        }
        return (ic) map.get("material_meta");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final int i, final int i2, final long j) {
        com.byazt.ukr.tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.ppf.ve.3
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject.put("dsl_error_code", i3);
                    }
                    jSONObject.put("dsl_url", ve.sp);
                    jSONObject.put("dsl_md5", ve.f28955a);
                    jSONObject.put("dsl_load_type", i2);
                    jSONObject.put("dsl_load_time", j);
                    jSONObject.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("uchain_stats_tracker").tt(jSONObject.toString());
            }
        }, "uchain_stats_tracker", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(UUID uuid, String str, JSONArray jSONArray, ic icVar, String str2, long j, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uchain_event_id", uuid);
            jSONObject.put("pre_uchain", j2);
            jSONObject.put("duration", j);
            jSONObject.put("run_status", z);
            jSONObject.put("version", c());
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", nb.sl(icVar));
            com.byazt.ddx.uj.tt(icVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static String c(JSONObject jSONObject) {
        com.byazt.bh.ve veVarC = com.byazt.bh.tt.INSTANCE.c("clickEvent");
        if (veVarC == null) {
            return "";
        }
        ArrayList<com.byazt.bh.c> arrayList = new ArrayList(veVarC.c().values());
        Collections.sort(arrayList, new Comparator<com.byazt.bh.c>() { // from class: com.byazt.ppf.ve.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.bh.c cVar, com.byazt.bh.c cVar2) {
                return cVar.n() - cVar2.n();
            }
        });
        for (com.byazt.bh.c cVar : arrayList) {
            if (com.byazt.bh.ve.c(cVar.ve(), jSONObject, new HashMap())) {
                String strTt = cVar.tt();
                return !TextUtils.isEmpty(strTt) ? Uri.parse(strTt).getHost() : "";
            }
        }
        return "";
    }

    public static boolean tt(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("has_show_dl_factors");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static int c() {
        return x;
    }

    public static void c(ic icVar, Map<String, Object> map, String str, HashMap<String, Object> map2, String str2, HashMap<String, Object> map3, long j) {
        if (c.get() != 2) {
            n = System.currentTimeMillis();
            sp(icVar == null ? null : icVar.jl());
        }
        if (icVar == null) {
            return;
        }
        long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        JSONObject jSONObjectYg = icVar.yg();
        try {
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                jSONObjectYg.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            m.c(e);
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        JSONArray jSONArray = new JSONArray();
        HashMap map4 = new HashMap();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        StringBuilder sb = new StringBuilder("");
        c(str, jSONObjectYg, map2, new AnonymousClass4(map4, atomicBoolean, jSONArray, sb, icVar, uuidRandomUUID, str, str2, j, jCurrentTimeMillis), (JSONObject) null);
        if (map != null) {
            map.put("uchain_event_id", uuidRandomUUID);
        }
        if (tt()) {
            return;
        }
        com.byazt.ddx.uj.tt(icVar, c(sb.toString(), icVar));
        tt(uuidRandomUUID, str, jSONArray, icVar, str2, j > 0 ? System.currentTimeMillis() - j : -1L, jCurrentTimeMillis, atomicBoolean.get());
    }

    public static int c(String str, ic icVar) {
        int i = 4;
        if ("download".equals(str)) {
            String strLs = icVar.ls();
            if (icVar.z() != null && !TextUtils.isEmpty(icVar.z().uj())) {
                strLs = icVar.z().uj();
            }
            if (nb.tt(strLs)) {
                return 4;
            }
            i = 2;
            if (TextUtils.isEmpty(icVar.gr()) && icVar.ne() != 2 && !com.byazt.bzd.tt.c(icVar)) {
                return 1;
            }
        }
        return i;
    }

    public static boolean c(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("is_feed_register_direct_download");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void c(ic icVar, HashMap<String, Object> map, com.byazt.qdk.ve veVar) {
        nb.md();
        if (veVar == null || icVar == null) {
            return;
        }
        String strC = veVar.c("type");
        if (TextUtils.isEmpty(strC)) {
        }
        JSONObject jSONObjectYg = icVar.yg();
        strC.hashCode();
        switch (strC) {
            case "1":
                String strC2 = veVar.c("name");
                if (!TextUtils.isEmpty(strC2)) {
                    c(strC2, jSONObjectYg, map);
                    break;
                }
                break;
            case "2":
                String strC3 = veVar.c("data");
                if (!TextUtils.isEmpty(strC3)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strC3);
                        c(jSONObject.keys().next(), jSONObjectYg, map, (com.byazt.nd.ve) null, jSONObject);
                    } catch (JSONException e) {
                        m.c(e);
                        return;
                    }
                    break;
                }
                break;
            case "3":
                String strC4 = veVar.c(NativeModel.JSON_KEY_SCHEME);
                if (!TextUtils.isEmpty(strC4)) {
                    new com.byazt.cq.tt.c(strC4, 2).c(jSONObjectYg).c(map).c().c();
                    break;
                }
                break;
        }
    }

    public static void c(ic icVar, HashMap<String, Object> map, com.byazt.pm.a.c cVar) {
        String strValueOf;
        nb.md();
        if (cVar.ve() == null || icVar == null) {
            return;
        }
        Object obj = cVar.ve().get("type");
        String strValueOf2 = obj != null ? String.valueOf(obj) : "";
        if (TextUtils.isEmpty(strValueOf2)) {
        }
        JSONObject jSONObjectYg = icVar.yg();
        switch (strValueOf2) {
            case "1":
                Object obj2 = cVar.ve().get("name");
                strValueOf = obj2 != null ? String.valueOf(obj2) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    c(strValueOf, jSONObjectYg, map);
                    break;
                }
                break;
            case "2":
                Object obj3 = cVar.ve().get("data");
                strValueOf = obj3 != null ? String.valueOf(obj3) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strValueOf);
                        c(jSONObject.keys().next(), jSONObjectYg, map, (com.byazt.nd.ve) null, jSONObject);
                    } catch (JSONException e) {
                        m.c(e);
                        return;
                    }
                    break;
                }
                break;
            case "3":
                Object obj4 = cVar.ve().get(NativeModel.JSON_KEY_SCHEME);
                strValueOf = obj4 != null ? String.valueOf(obj4) : "";
                if (!TextUtils.isEmpty(strValueOf)) {
                    new com.byazt.cq.tt.c(strValueOf, 2).c(jSONObjectYg).c(map).c().c();
                    break;
                }
                break;
        }
    }

    public static void c(String str, JSONObject jSONObject, Map<String, Object> map, final com.byazt.nd.n nVar) {
        nb.md();
        new com.byazt.cq.tt.c(str, 3).c(jSONObject).c(map).c(new com.byazt.nd.ve() { // from class: com.byazt.ppf.ve.5
            @Override // com.byazt.nd.ve
            public void c(com.byazt.cq.c cVar) {
                cVar.c(new com.byazt.nd.uj() { // from class: com.byazt.ppf.ve.5.1
                    @Override // com.byazt.nd.uj
                    public a tt() {
                        return null;
                    }

                    @Override // com.byazt.nd.uj
                    public com.byazt.nd.n ve() {
                        return nVar;
                    }
                });
            }

            @Override // com.byazt.nd.ve
            public void c(com.byazt.cq.tt ttVar) {
            }
        }).c().c();
    }

    public static void c(com.byazt.eia.c cVar, JSONObject jSONObject, Map<String, Object> map, Map<String, Object> map2) {
        if (cVar == null || jSONObject == null) {
            return;
        }
        com.byazt.ow.c cVarC = com.byazt.ow.c.c();
        List<String> listTt = com.byazt.ow.c.tt(cVar.getClass());
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue() != null) {
                    if (cVar.c() != null && cVar.c().containsKey(key)) {
                        map4.put(cVar.c().get(key), entry.getValue());
                    }
                    map3.put(key, entry.getValue());
                }
            }
        }
        c(jSONObject, (Map<String, Object>) map4);
        for (String str : listTt) {
            if (!TextUtils.isEmpty(str)) {
                map3.put(str, c.c(jSONObject, str));
            }
        }
        if (map2 != null) {
            map3.putAll(map2);
        }
        cVarC.c(cVar, map3);
    }

    public static void c(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(jSONObject, entry.getKey(), entry.getValue());
        }
    }

    private static void c(JSONObject jSONObject, String str, Object obj) {
        String[] strArrSplit = str.split("\\.");
        for (int i = 0; i < strArrSplit.length - 1; i++) {
            try {
                String str2 = strArrSplit[i];
                if (!jSONObject.has(str2)) {
                    return;
                }
                jSONObject = jSONObject.getJSONObject(str2);
            } catch (Exception unused) {
                return;
            }
        }
        String str3 = strArrSplit[strArrSplit.length - 1];
        if (jSONObject.has(str3)) {
            jSONObject.put(str3, obj);
        }
    }

    public static ic c(Object obj, Map<String, Object> map) {
        if (obj instanceof ic) {
            return (ic) obj;
        }
        return ve(map);
    }

    public static void c(Map<String, Object> map, com.byazt.cr.c cVar) {
        if (map != null) {
            map.put("status_code", Integer.valueOf(cVar.c()));
            map.put("status_msg", cVar.tt());
        }
    }

    public static void c(Map<String, Object> map, JSONObject jSONObject) {
        if (map == null || !tt()) {
            return;
        }
        try {
            jSONObject.put("status_code", map.get("status_code"));
        } catch (JSONException unused) {
        }
    }

    public static void c(ic icVar, Context context, String str, Map<String, Object> map, com.byazt.nd.n nVar) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("material_meta", icVar);
        map2.put("context", context);
        map2.put("event_tag", str);
        map2.put("landing_page_source", Integer.valueOf(nb.uj(str)));
        c("open_landing_page", icVar.yg(), map2, nVar);
    }

    public static void c(String str, JSONObject jSONObject, Map<String, Object> map) {
        c(str, jSONObject, map, (com.byazt.nd.ve) null, (JSONObject) null);
    }

    public static void c(String str, JSONObject jSONObject, Map<String, Object> map, com.byazt.nd.ve veVar, JSONObject jSONObject2) {
        nb.md();
        try {
            jSONObject.put("u_setting", gt.tt().m173if());
        } catch (JSONException unused) {
        }
        new com.byazt.cq.tt.c(str).c(jSONObject).c(map).c(veVar).tt(jSONObject2).c().c();
    }
}
