package com.byazt.ddx;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.gr;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.z;
import com.byazt.aas.zm;
import com.byazt.bv.BaseConstants;
import com.byazt.dna.u;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.ete.q;
import com.byazt.ete.to;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.rh;
import com.byazt.ukr.yp;
import com.byazt.whk.sl;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 15})
public class uj {
    public static int c;

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ic icVar, String str, JSONObject jSONObject) throws JSONException {
        com.byazt.dj.tt ttVarIj;
        if (p.x() && (ttVarIj = icVar.ij()) != null) {
            String strU = ttVarIj.u();
            if (TextUtils.isEmpty(strU)) {
                return;
            }
            jSONObject.putOpt("media_extra", strU);
        }
    }

    public static void c(ic icVar) {
    }

    public static void c(String str, String str2, String str3, String str4, com.byazt.ya.c cVar) {
        new c.C0382c().n(str3).uj(str4).c(str).tt(str2).c(cVar);
    }

    public static void i(ic icVar, String str, String str2, Map<String, Object> map) {
        hq hqVarA_ = icVar.A_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (hqVarA_ != null) {
            map.put("wc_type", Integer.valueOf(hqVarA_.n()));
        }
        map.put("rom_new_version", zm.yp());
        map.put("is_background", Boolean.valueOf(com.byazt.omf.x.m().c()));
        map.put("interaction_type", Integer.valueOf(icVar.i()));
        map.put("can_query", Boolean.valueOf(nb.yv()));
        c(icVar, str, str2, map);
    }

    public static void sp(ic icVar, String str, String str2, Map<String, Object> map) {
        c(icVar, str, str2, map);
    }

    public static void tt(final ic icVar, final String str, final Map<String, Object> map, final Double d) {
        if (icVar == null) {
            return;
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - nb.z(icVar)).floatValue();
        final String strC = gr.c(str, ((u) com.byazt.ut.uj.getService("device_info_new")).getUnlockTime(), nb.t(icVar), com.byazt.ue.tt.c());
        icVar.bn().ve();
        c++;
        c(icVar, str, "show", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.38
            public void c(ic icVar2, Double d2, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> mapYt = icVar2.yt();
                    if (mapYt == null || (obj = mapYt.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d2 != null) {
                        jSONObject.put("ttdsp_price", d2);
                    } else if (icVar2.nq() && (obj2 = mapYt.get("price")) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.byazt.by.c.c(gt.getContext(), com.byazt.ouz.i.c(str)).toString());
                jSONObject2.put("is_cache", icVar.up() ? 1 : 0);
                ic icVar2 = icVar;
                jSONObject2.put("cache_type", icVar2.sl(icVar2.up()));
                com.byazt.dbo.ve.c(icVar, jSONObject2, true);
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - rh.n);
                jSONObject2.put("start_type", !rh.tt.get() ? 1 : 0);
                jSONObject2.put("show_count", uj.c);
                String strN = com.byazt.omf.x.m().n();
                if (!TextUtils.isEmpty(strN)) {
                    jSONObject2.put("can_use_sensor", strN);
                }
                if (gt.tt().bx()) {
                    jSONObject2.put("mcod", "-1");
                } else if (!com.byazt.omf.x.m().da()) {
                    jSONObject2.put("mcod", "0");
                }
                if (!com.byazt.omf.x.m().sp()) {
                    jSONObject2.put("od", "0");
                }
                jSONObject2.put("is_shake_ads", com.byazt.omf.x.m().rh());
                jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.byazt.pf.c.c().a());
                uj.a(icVar, str, jSONObject2);
                String str2 = strC;
                if (str2 != null) {
                    pf.c(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.byazt.apd.tt.c().ve());
                com.byazt.ic.c.c(jSONObject2, icVar);
                jSONObject2.put("shakeLiSize", com.byazt.nr.n.c(gt.getContext()).c());
                if (icVar.hs()) {
                    jSONObject2.put("reward_show_type", icVar.ne());
                    jSONObject2.put("browse_time", icVar.lz());
                }
                uj.c(jSONObject2);
                icVar.bn().c(jSONObject2, true);
                JSONObject jSONObjectUr = icVar.ur();
                if (jSONObjectUr != null) {
                    nb.c(icVar, jSONObjectUr);
                    jSONObject2.putOpt("applist_info", jSONObjectUr);
                }
                sl.c(icVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                com.byazt.qw.ve.ve().c(icVar, fFloatValue);
                String strEm = icVar.em();
                if (!TextUtils.isEmpty(strEm)) {
                    try {
                        double d2 = Double.parseDouble(strEm);
                        if (d2 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                            jSONObject.put("ttdsp_price", 0);
                            return;
                        }
                        jSONObject.put("ttdsp_price", d2);
                    } catch (Throwable th) {
                        jSONObject.put("ttdsp_price", 0);
                        m.c(th);
                    }
                }
                c(icVar, d, jSONObject);
            }
        });
        String strC2 = z.c();
        List<String> listPr = icVar.pr();
        if (!TextUtils.isEmpty(strC2)) {
            HashMap map2 = new HashMap();
            map2.put("aid", icVar.gu());
            map2.put("cid", icVar.uj());
            map2.put("req_id", icVar.qy());
            map2.put("customer_id", nb.yp(icVar));
            com.byazt.ukr.tt.c(strC2, listPr, true, map2, c(icVar, str, "show"));
        } else if (listPr != null && listPr.size() != 0) {
            c(icVar, listPr, str, "no did", "show");
        }
        if (c % 5 == 0 && com.byazt.lkt.c.c() != null) {
            com.byazt.lkt.c.c().tt("AdShow" + System.currentTimeMillis());
        }
        if (com.byazt.apd.tt.c().a(icVar)) {
            yp.c(icVar);
            com.byazt.ex.c.c(LiveMetrics.EVENT_LIVESDK_LIVE_SHOW, icVar, 0L);
        }
        nb.ve();
        com.byazt.qh.tt.c(icVar.jl());
        com.byazt.apd.tt.c().uj();
        com.byazt.omf.x.m().ve().uj();
        gr.c(c, 1);
        com.byazt.omf.uj.c().ve(icVar.mk());
        com.byazt.qw.ve.ve().a();
    }

    public static void uj(ic icVar, String str, String str2, Map<String, Object> map) {
        c(icVar, str, str2, map);
    }

    public static void ve(ic icVar, String str, String str2, Map<String, Object> map) {
        c(icVar, str, str2, map);
    }

    public static void x(ic icVar, String str, String str2, Map<String, Object> map) {
        hq hqVarA_ = icVar.A_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (hqVarA_ != null) {
            map.put("wc_type", Integer.valueOf(hqVarA_.n()));
        }
        map.put("rom_new_version", zm.yp());
        map.put("is_background", Boolean.valueOf(com.byazt.omf.x.m().c()));
        map.put("interaction_type", Integer.valueOf(icVar.i()));
        map.put("can_query", Boolean.valueOf(nb.yv()));
        c(icVar, str, str2, map);
    }

    public static void n(ic icVar, String str, String str2, Map<String, Object> map) {
        c(icVar, str, str2, map);
    }

    public static void uj(ic icVar, String str, final long j) {
        c(icVar, str, "render_live_picture_success", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.23
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, new JSONObject().toString());
            }
        });
    }

    public static void ve(final ic icVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (icVar == null) {
            return;
        }
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.15
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.byazt.ic.c.c(jSONObject, icVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void uj(ic icVar, String str, final JSONObject jSONObject) {
        if (icVar == null || jSONObject == null) {
            return;
        }
        c(icVar, str, "splash_ad_showstat", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.36
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void ve(ic icVar, String str, String str2) {
        c(icVar, str, str2, (com.byazt.ya.c) null);
    }

    public static void ve(ic icVar, String str, String str2, JSONObject jSONObject) {
        if (icVar == null) {
            return;
        }
        new c.C0382c().n(icVar.uj()).uj(icVar.w_()).c(str).tt(str2).c(jSONObject).c((com.byazt.ya.c) null);
    }

    public static void a(ic icVar, String str, String str2, Map<String, Object> map) {
        c(icVar, str, str2, map);
    }

    public static void c(ic icVar, String str, String str2, com.byazt.ya.c cVar) {
        if (icVar == null) {
            return;
        }
        new c.C0382c().n(icVar.uj()).uj(icVar.w_()).c(str).tt(str2).sp(icVar.qy()).c(cVar);
    }

    public static void ve(final ic icVar, String str, final long j) {
        c(icVar, str, TrackLoadSettingsAtom.TYPE, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.21
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.byazt.ic.c.c(jSONObject2, icVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put("duration", Math.min(j, 600000L));
            }
        });
    }

    public static void ve(ic icVar, String str, final JSONObject jSONObject) {
        if (icVar == null || jSONObject == null) {
            return;
        }
        c(icVar, str, "cache_correct_details", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.31
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void ve(final ic icVar, String str) {
        c(icVar, str, "cache_ana_upload", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.37
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                icVar.bn().c(jSONObject2, false);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void c(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, com.byazt.ya.c cVar) {
        new c.C0382c().uj(str4).c(str).ve(str3).tt(str2).n(str5).c(jSONObject).c(cVar);
    }

    public static void c(ic icVar, String str, String str2, JSONObject jSONObject, com.byazt.ya.c cVar) {
        if (icVar == null) {
            return;
        }
        new c.C0382c().n(icVar.uj()).uj(icVar.w_()).c(str).tt(str2).c(jSONObject).sp(icVar.qy()).c(cVar);
    }

    public static void c(final ic icVar, String str, String str2, final JSONObject jSONObject) {
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.1
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.byazt.ic.c.c(jSONObject3, icVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
            }
        });
    }

    public static void c(final ic icVar, String str, String str2, final Map<String, Object> map) {
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.12
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.byazt.ic.c.c(jSONObject2, icVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        });
    }

    public static void tt(ic icVar, String str, String str2, Map<String, Object> map) {
        c(icVar, str, str2, map);
    }

    public static void c(final ic icVar, final String str, final Map<String, Object> map) {
        com.byazt.bzd.x.c((Runnable) new com.byazt.bwm.sp("repost_show_check") { // from class: com.byazt.ddx.uj.22
            @Override // java.lang.Runnable
            public void run() {
                if (icVar == null) {
                    return;
                }
                final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - nb.z(icVar)).floatValue();
                uj.c(icVar, str, "show_check", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.22.1
                    @Override // com.byazt.ya.c
                    public void onSend(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("device", com.byazt.by.c.c(gt.getContext(), com.byazt.ouz.i.c(str)).toString());
                        jSONObject2.put("is_cache", icVar.up() ? 1 : 0);
                        ic icVar2 = icVar;
                        jSONObject2.put("cache_type", icVar2.sl(icVar2.up()));
                        com.byazt.dbo.ve.c(icVar, jSONObject2, false);
                        Map map2 = map;
                        if (map2 != null) {
                            for (Map.Entry entry : map2.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - rh.n);
                        jSONObject2.put("start_type", !rh.tt.get() ? 1 : 0);
                        jSONObject2.put("show_count", uj.c);
                        jSONObject2.put("can_use_sensor", com.byazt.omf.x.m().n());
                        jSONObject2.put("is_shake_ads", com.byazt.omf.x.m().rh());
                        jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.byazt.pf.c.c().a());
                        AnonymousClass22 anonymousClass22 = AnonymousClass22.this;
                        uj.a(icVar, str, jSONObject2);
                        com.byazt.ic.c.c(jSONObject2, icVar);
                        jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                        float f = fFloatValue;
                        if (f <= 0.0f) {
                            f = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f));
                    }
                });
            }
        });
    }

    public static void tt(ic icVar, String str) {
        if (icVar != null) {
            com.byazt.vo.ve veVar = new com.byazt.vo.ve();
            veVar.setId("0:00");
            veVar.setName(str);
            com.byazt.qw.ve.ve().c(FreeSpaceBox.TYPE, icVar.uj(), icVar.qy(), icVar.q_(), (String) null);
            c(icVar.wq(), veVar);
        }
    }

    public static void c(final ic icVar, final String str, final Map<String, Object> map, final Double d) {
        com.byazt.bzd.x.c(new com.byazt.bwm.sp("report_show") { // from class: com.byazt.ddx.uj.33
            @Override // java.lang.Runnable
            public void run() {
                uj.tt(icVar, str, (Map<String, Object>) map, d);
            }
        });
    }

    private static void c(ic icVar, List<String> list, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_type", str3);
            jSONObject.put("error_msg", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i == size - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            jSONObject.put("url", sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception unused) {
        }
        c(str, icVar.uj(), icVar.w_(), jSONObject);
    }

    public static void tt(ic icVar, String str, final JSONObject jSONObject) {
        c(icVar, nb.tt(icVar), str, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.7
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3);
                }
            }
        });
    }

    public static void tt(final ic icVar, final int i) {
        if (icVar.hs()) {
            c(icVar, nb.tt(icVar), "reward_task_diff", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.10
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("reward_show_type", icVar.ne());
                    jSONObject2.put("reward_action_type", i);
                    jSONObject2.put("task_action", icVar.ne() == i ? 0 : 1);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    public static void tt(ic icVar, String str, String str2, final long j) {
        if (icVar == null) {
            return;
        }
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.13
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                jSONObject.put("timestamp", j);
            }
        });
    }

    public static void tt(final ic icVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (icVar == null || jSONObject == null) {
            return;
        }
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.14
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.byazt.ic.c.c(jSONObject, icVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void tt(ic icVar, String str, String str2) {
        c(icVar, str, str2, (com.byazt.ya.c) null);
    }

    public static void tt(ic icVar, String str, String str2, JSONObject jSONObject) {
        c(icVar, str, str2, jSONObject);
    }

    public static void tt(ic icVar, String str, long j) {
        String str2;
        if (gt.tt().hj()) {
            final long jCurrentTimeMillis = System.currentTimeMillis() - j;
            str.hashCode();
            switch (str) {
                case "banner_ad":
                    str2 = "banner_ad_loadtime";
                    break;
                case "rewarded_video":
                    str2 = "rewarded_video_loadtime";
                    break;
                case "stream":
                    str2 = "stream_loadtime";
                    break;
                case "fullscreen_interstitial_ad":
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case "embeded_ad":
                    str2 = "embeded_ad_loadtime";
                    break;
                case "interaction":
                    str2 = "interaction_loadtime";
                    break;
                case "draw_ad":
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.16
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("duration", jCurrentTimeMillis);
                }
            });
        }
    }

    public static void c(final ic icVar, final String str, final long j) {
        c(icVar, str, "download_creative_duration", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.39
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.byazt.by.c.c(gt.getContext(), com.byazt.ouz.i.c(str)).toString());
                jSONObject2.put("download_creative_duration", j);
                com.byazt.ic.c.c(jSONObject2, icVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(final String str, ic icVar, String str2, final int i, final Map<String, Long> map) {
        if (icVar == null) {
            return;
        }
        c(icVar, str2, "ad_show_time", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.40
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("source", Integer.valueOf(i));
                Map map2 = map;
                if (map2 != null) {
                    for (Map.Entry entry : map2.entrySet()) {
                        jSONObject2.putOpt((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                jSONObject.put("duration", str);
            }
        });
    }

    public static void c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("tag");
        String strOptString2 = jSONObject.optString(MediationConstant.EXTRA_ADID);
        String strOptString3 = jSONObject.optString("log_extra");
        if (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString)) {
            return;
        }
        c(strOptString, strOptString2, strOptString3, jSONObject2);
    }

    public static void tt(final ic icVar) {
        c(icVar, "landingpage", "open_url_h5", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.20
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.byazt.ic.c.c(jSONObject2, icVar);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void tt(final ic icVar, String str, final int i) {
        c(icVar, str, "qpon_apply", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.30
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("qpon_apply_status", i);
                    com.byazt.ic.c.c(jSONObject2, icVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception e) {
                    m.c(e);
                }
            }
        });
    }

    public static void tt(long j, final ic icVar) {
        if (icVar != null && ic.ve(icVar)) {
            final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
            c(icVar, "splash_ad", "play_duration_sum", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.32
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", jCurrentTimeMillis);
                    com.byazt.ic.c.c(jSONObject2, icVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    public static void c(String str, String str2, String str3, final JSONObject jSONObject) {
        c(str, "show_url", str2, str3, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.41
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                }
            }
        });
    }

    public static void c(final ic icVar, final String str) {
        String strTt;
        if (icVar == null || str == null || (strTt = nb.tt(icVar)) == null) {
            return;
        }
        c(icVar, strTt, "page_on_create", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.42
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("page_name", str);
                pf.c(jSONObject2, "");
                com.byazt.ic.c.c(jSONObject2, icVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void c(String str, final ic icVar, final com.byazt.ete.i iVar, final String str2, final boolean z, final Map<String, Object> map, final int i, boolean z2, final boolean z3) {
        if (icVar == null || z2) {
            return;
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - nb.z(icVar)).floatValue();
        c(icVar, str2, str, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.2
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                com.byazt.ete.i iVar2 = iVar;
                if (iVar2 != null) {
                    JSONObject jSONObjectC = iVar2.c(icVar);
                    jSONObjectC.put("device", com.byazt.by.c.c(gt.getContext(), com.byazt.ouz.i.c(str2)).toString());
                    jSONObjectC.put("is_valid", z);
                    int i2 = i;
                    if (i2 > 0 && i2 <= 2) {
                        jSONObjectC.put("user_behavior_type", i2);
                    }
                    pf.c(jSONObjectC, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObjectC.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    uj.a(icVar, str2, jSONObjectC);
                    jSONObjectC.putOpt("obm_convert", com.byazt.ete.gt.ve(icVar));
                    jSONObjectC.put("can_use_sensor", com.byazt.omf.x.m().n());
                    if (gt.tt().bx()) {
                        jSONObjectC.put("mcod", "-1");
                    } else if (!com.byazt.omf.x.m().da()) {
                        jSONObjectC.put("mcod", "0");
                    }
                    if (!com.byazt.omf.x.m().sp()) {
                        jSONObjectC.put("od", "0");
                    }
                    jSONObjectC.put("is_shake_ads", com.byazt.omf.x.m().rh());
                    jSONObjectC.put("live_sdk_config", com.byazt.apd.tt.c().x());
                    jSONObjectC.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.byazt.pf.c.c().a());
                    jSONObjectC.put("is_cache", icVar.up() ? 1 : 0);
                    ic icVar2 = icVar;
                    jSONObjectC.put("cache_type", icVar2.sl(icVar2.up()));
                    com.byazt.dbo.ve.c(icVar, jSONObjectC, false);
                    jSONObjectC.put("source", z3 ? 1 : 0);
                    com.byazt.ic.c.c(jSONObjectC, icVar);
                    com.byazt.aas.p.c(jSONObjectC, icVar);
                    uj.c(jSONObjectC);
                    if (icVar.hs()) {
                        jSONObjectC.put("reward_show_type", icVar.ne());
                        jSONObjectC.put("browse_time", icVar.lz());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectC.toString());
                }
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
            }
        });
        String strC = z.c();
        List<String> listGl = icVar.gl();
        if (!TextUtils.isEmpty(strC) && "click".equals(str)) {
            HashMap map2 = new HashMap();
            map2.put("aid", icVar.gu());
            map2.put("cid", icVar.uj());
            map2.put("req_id", icVar.qy());
            map2.put("customer_id", nb.yp(icVar));
            com.byazt.ukr.tt.c(strC, listGl, true, map2, c(icVar, str2, "click"));
        } else if (listGl != null && listGl.size() != 0 && "click".equals(str)) {
            c(icVar, listGl, str2, "no did", "click");
        }
        if (str == "click") {
            if (com.byazt.ex.c.c(icVar)) {
                com.byazt.ex.c.c(LiveMetrics.EVENT_LIVESDK_REC_LIVE_PLAY, icVar, 0L);
            }
            com.byazt.apd.tt.c().uj(icVar);
        }
        gr.c(1, 2);
        if (m.ve()) {
            m.c("AdEvent", str + " " + icVar.uj());
        }
    }

    public static JSONObject c(ic icVar, String str, String str2) {
        return c(icVar.w_(), icVar.uj(), icVar.qy(), str, str2);
    }

    public static JSONObject c(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_extra", str);
            jSONObject.put(MediationConstant.EXTRA_ADID, str2);
            jSONObject.put("req_id", str3);
            jSONObject.put("tag", str4);
            jSONObject.put("track_type", str5);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void c(final ic icVar, String str, String str2, final long j) {
        if (icVar == null) {
            return;
        }
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.3
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", j);
                jSONObject2.put("rom_new_version", zm.yp());
                jSONObject2.put("is_background", com.byazt.omf.x.m().c());
                com.byazt.ic.c.c(jSONObject2, icVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(com.byazt.vo.tt ttVar, com.byazt.nc.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        gt.c().c(ttVar, arrayList);
        if (m.ve()) {
            m.c("AdEvent", "tt_dislike_icon " + ttVar.uj());
        }
    }

    public static void c(Context context, ic icVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || icVar == null || jSONObject == null) {
            return;
        }
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            objOpt = icVar.uj();
        }
        String strOptString = jSONObject.optString("category");
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "app_union";
        }
        Object objOpt2 = jSONObject.opt("log_extra");
        if (objOpt2 == null) {
            objOpt2 = icVar.w_();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(com.byazt.nr.rh.ve(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt("tag", "7.6.1.1");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e) {
            m.ve(e.getMessage());
        }
        new c.C0382c().n(objOpt == null ? "" : objOpt.toString()).ve(strOptString).uj(objOpt2 != null ? objOpt2.toString() : "").c(str).c(jSONObject).tt(str2).c(new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.4
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
            }
        });
    }

    public static void c(final long j, final ic icVar) {
        if (icVar == null) {
            return;
        }
        c(icVar, "splash_ad", FreeSpaceBox.TYPE, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.5
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                com.byazt.ic.c.c(jSONObject2, icVar);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(final ic icVar, String str, final JSONObject jSONObject) {
        c(icVar, nb.tt(icVar), str, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.6
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.byazt.ic.c.c(jSONObject3, icVar);
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            }
        });
    }

    public static void c(final ic icVar, String str, String str2, final long j, final int i, final Map<String, Object> map) {
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.8
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.put("percent", i);
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.byazt.ic.c.c(jSONObject2, icVar);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        });
    }

    public static void c(final ic icVar, final int i) {
        c(icVar, nb.tt(icVar), "reward_callback", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.9
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_show_type", icVar.ne());
                jSONObject2.put("browse_time", icVar.lz());
                jSONObject2.put("reward_action_type", i);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(final ic icVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (icVar == null || jSONObject == null) {
            return;
        }
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.11
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.byazt.ic.c.c(jSONObject, icVar);
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
            }
        });
    }

    public static void c(String str, String str2, String str3, String str4) {
        new c.C0382c().c(str3).tt(str4).n(str).uj(str2).c((com.byazt.ya.c) null);
        if (m.ve()) {
            m.c("AdEvent", "tag: " + str3 + "label: " + str4 + " " + str);
        }
    }

    public static void c(ic icVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
                com.byazt.ic.c.c(jSONObject, icVar);
            }
        } catch (Throwable unused) {
        }
        c(icVar, str, str2, new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.17
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            }
        });
    }

    public static void c(String str, final String str2, final String str3, long j, long j2, JSONObject jSONObject, final byte b) {
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - nb.x(jSONObject.optString("log_extra"))).floatValue();
        new c.C0382c().c(str2).tt(str3).ve(str).n(String.valueOf(j)).a(String.valueOf(j2)).c(jSONObject).c(new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.18
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String strOptString = jSONObject2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                jSONObject3.put("device", com.byazt.by.c.c(gt.getContext(), com.byazt.ouz.i.c(str2)).toString());
                jSONObject3.put("js_event", 1);
                byte b2 = b;
                if (b2 != -1) {
                    jSONObject3.put("biz_type", (int) b2);
                }
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
                jSONObject2.put("tag", str2);
                if ("click".equals(str3)) {
                    float f = fFloatValue;
                    if (f <= 0.0f) {
                        f = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f));
                }
            }
        });
        if (m.ve()) {
            m.c("AdEvent", "sendJsAdEvent");
        }
    }

    public static void c(ic icVar, String str, Map<String, Object> map, boolean z) {
        if (z) {
            c(icVar, str, "lp_open_dpl", map);
            return;
        }
        hq hqVarA_ = icVar.A_();
        if (map == null) {
            map = new HashMap<>();
        }
        if (hqVarA_ != null) {
            map.put("wc_type", Integer.valueOf(hqVarA_.n()));
        }
        map.put("rom_new_version", zm.yp());
        map.put("is_background", Boolean.valueOf(com.byazt.omf.x.m().c()));
        map.put("interaction_type", Integer.valueOf(icVar.i()));
        map.put("can_query", Boolean.valueOf(nb.yv()));
        c(icVar, str, "open_url_app", map);
    }

    public static void c(ic icVar, String str, Throwable th, boolean z, boolean z2) {
        if (z2) {
            if (z) {
                c(icVar, str, "lp_openurl", th);
                c(icVar, str, "lp_deeplink_success_realtime", th);
                return;
            } else {
                c(icVar, str, "deeplink_success_realtime", th);
                return;
            }
        }
        if (z) {
            c(icVar, str, "lp_openurl_failed", th);
            c(icVar, str, "lp_deeplink_fail_realtime", th);
        } else {
            c(icVar, str, "deeplink_fail_realtime", th);
        }
    }

    public static void c(ic icVar, String str, String str2, Throwable th) {
        hq hqVarA_ = icVar.A_();
        JSONObject jSONObject = null;
        if (hqVarA_ != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", hqVarA_.n());
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused2) {
            }
        }
        if (th != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("throwable", th.getMessage());
            } catch (Exception unused3) {
            }
        }
        c(icVar, str, str2, jSONObject);
    }

    public static void c(final long j, String str, ic icVar) {
        if (icVar == null) {
            return;
        }
        c(icVar, str, "open_appback", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.19
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
            }
        });
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        veVarC.put("save_jump_success_time", 0L);
        veVarC.put("save_jump_success_ad_tag", "");
    }

    public static void c(ic icVar, String str, final int i, final String str2) {
        c(icVar, str, "render_live_picture_fail", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.24
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
                jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(ic icVar, String str, final long j, final String str2) {
        c(icVar, str, "live_play_success", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.25
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("session_id", str2);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(ic icVar, String str, final int i, final String str2, final String str3) {
        c(icVar, str, "live_play_fail", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.26
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
                jSONObject2.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, str2);
                jSONObject2.putOpt("session_id", str3);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(ic icVar, String str, final long j, final JSONObject jSONObject, final String str2) {
        c(icVar, str, "live_play_close", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.27
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt("session_id", str2);
                    jSONObject2.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                }
                jSONObject2.put("duration", j);
            }
        });
    }

    public static void c(final ic icVar, String str, final int i, final int i2, final int i3, final boolean z) {
        if (icVar != null && icVar.xl() == 1) {
            c(icVar, str, "open_live", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.28
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    int i4 = i3;
                    int iN = icVar.n();
                    jSONObject2.put("live_interaction_type", iN);
                    jSONObject2.put("client_live_interaction_type", i);
                    jSONObject2.put("real_live_interaction_type", i2);
                    jSONObject2.put("reward_live_type", to.tt(icVar));
                    jSONObject2.put("is_inner", z);
                    q qVarC_ = icVar.C_();
                    if (icVar.n() == 9 && icVar.D_() != null) {
                        qVarC_ = icVar.D_().uj();
                    }
                    if (qVarC_ != null) {
                        jSONObject2.putOpt("saas_info", qVarC_.c());
                    }
                    nu nuVarYp = icVar.yp();
                    if (nuVarYp != null) {
                        String strTt = nuVarYp.tt();
                        if (strTt.length() > 500) {
                            strTt = strTt.substring(0, 500);
                        }
                        jSONObject2.put("deep_link", strTt);
                        if (!strTt.startsWith("snssdk1128") && !strTt.startsWith("snssdk2329") && iN == 1 && i4 != 0) {
                            i4 = 2;
                        }
                    }
                    jSONObject2.put("live_interaction_status", i4);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    public static void c(final ic icVar, String str, final int i) {
        c(icVar, str, "qpon_join", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.29
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("join_status", i);
                    com.byazt.ic.c.c(jSONObject2, icVar);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                } catch (Exception e) {
                    m.c(e);
                }
            }
        });
    }

    public static void c(final int i, String str, final ic icVar) {
        if (icVar == null) {
            return;
        }
        c(icVar, str, "saas_auth", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.34
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i);
                q qVarC_ = icVar.C_();
                if (qVarC_ != null) {
                    jSONObject2.put("saas_auth_type", qVarC_.tt());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(String str, ic icVar) {
        if (icVar == null) {
            return;
        }
        c(icVar, str, "ec_mall_task", new com.byazt.ya.c() { // from class: com.byazt.ddx.uj.35
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            com.byazt.dj.uj ujVarNu = com.byazt.omf.x.m().nu();
            jSONObject2.put("isCanUseLocation", ujVarNu.isCanUseLocation());
            jSONObject2.put("isCanUsePhoneState", ujVarNu.isCanUsePhoneState());
            jSONObject2.put("isCanUseWifiState", ujVarNu.isCanUseWifiState());
            jSONObject2.put("isCanUseWriteExternal", ujVarNu.isCanUseWriteExternal());
            jSONObject2.put("alist", ujVarNu.alist());
            jSONObject2.put("isCanUseAndroidId", ujVarNu.isCanUseAndroidId());
            jSONObject2.put("isCanUsePermissionRecordAudio", ujVarNu.isCanUsePermissionRecordAudio());
            Map<String, Object> mapUserPrivacyConfig = ujVarNu.userPrivacyConfig();
            if (mapUserPrivacyConfig != null && !mapUserPrivacyConfig.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, Object> entry : mapUserPrivacyConfig.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (TextUtils.equals(key, "mcod") && gt.tt().bx()) {
                        jSONObject3.put(key, "-1");
                    } else {
                        jSONObject3.put(key, value);
                    }
                }
                jSONObject2.put("update_privacyConfig", jSONObject3);
            }
            jSONObject.put("regulation_data", jSONObject2);
        } catch (JSONException unused) {
        }
    }
}
