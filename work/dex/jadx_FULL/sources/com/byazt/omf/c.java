package com.byazt.omf;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.ete.bm;
import com.byazt.ete.bx;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.ete.iu;
import com.byazt.ete.j;
import com.byazt.ete.kk;
import com.byazt.ete.kp;
import com.byazt.ete.l;
import com.byazt.ete.lo;
import com.byazt.ete.lr;
import com.byazt.ete.lt;
import com.byazt.ete.oz;
import com.byazt.ete.pf;
import com.byazt.ete.pu;
import com.byazt.ete.q;
import com.byazt.ete.qp;
import com.byazt.ete.r;
import com.byazt.ete.s;
import com.byazt.ete.sv;
import com.byazt.ete.to;
import com.byazt.ete.tx;
import com.byazt.ete.xd;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zj.adlib.ha0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 20})
public class c {
    private static com.byazt.ete.rl a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.ete.rl rlVar = new com.byazt.ete.rl();
        rlVar.c(jSONObject.optInt("ah", 1));
        rlVar.tt(jSONObject.optInt("am", 1));
        return rlVar;
    }

    public static Pair<com.byazt.ete.c, ArrayList<Integer>> c(JSONObject jSONObject, com.byazt.dj.tt ttVar, bm bmVar, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.byazt.ete.c cVar = new com.byazt.ete.c();
            cVar.c(jSONObject.optString("request_id"));
            cVar.c(jSONObject.optInt("ret"));
            cVar.tt(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("auction_price");
            com.byazt.aas.my.c(jSONObject.optString("client_ipv4", ""));
            boolean zOptBoolean = jSONObject.optBoolean("need_get_materials");
            if (cVar.c() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    i++;
                    ic icVarC = c(jSONObjectOptJSONObject, ttVar, bmVar, i);
                    int iC = c(icVarC, ttVar != null ? ttVar.gt() : 0);
                    boolean zR = icVarC.r();
                    String strY = icVarC.y();
                    if (iC == 200 || ((zOptBoolean || zR) && !TextUtils.isEmpty(strY))) {
                        icVarC.eo(strOptString);
                        icVarC.ve(j);
                        icVarC.x(zOptBoolean);
                        cVar.c(icVarC);
                    } else {
                        arrayList.add(Integer.valueOf(iC));
                    }
                }
            }
            return new Pair<>(cVar, arrayList);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return null;
        }
    }

    public static com.byazt.ete.a n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.ete.a aVar = new com.byazt.ete.a();
        aVar.uj(jSONObject.optString("developer_name"));
        aVar.tt(jSONObject.optString(AlibcCommonConstant.APP_VERSION));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(RequestPermission.PERMISSIONS);
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            aVar.tt(jSONArrayOptJSONArray);
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    aVar.c(jSONObjectOptJSONObject.optString("permission_name"), jSONObjectOptJSONObject.optString("permission_desc"));
                }
            }
        }
        aVar.c(jSONObject.optString("permissions_url"));
        aVar.c(jSONObject.optInt("score", 0));
        aVar.c(jSONObject.optJSONArray("creative_tags"));
        aVar.n(jSONObject.optString("privacy_policy_url"));
        aVar.a(jSONObject.optString("desc_url"));
        aVar.sp(jSONObject.optString("reg_number"));
        aVar.x(jSONObject.optString("reg_url"));
        aVar.da(jSONObject.optString("app_name"));
        aVar.i(jSONObject.optString("package_name"));
        return aVar;
    }

    private static Map<String, Object> sp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    public static com.byazt.ete.n tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.ete.n nVar = new com.byazt.ete.n();
        nVar.ve(jSONObject.optString("app_name"));
        nVar.uj(jSONObject.optString("package_name"));
        nVar.tt(jSONObject.optString("download_url"));
        nVar.c(jSONObject.optInt("score", 4));
        nVar.tt(jSONObject.optInt("comment_num", 0));
        nVar.ve(jSONObject.optInt("app_size", 0));
        nVar.c(jSONObject.optString("quick_app_url", ""));
        return nVar;
    }

    public static com.byazt.ete.yv uj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.ete.yv yvVar = new com.byazt.ete.yv();
        yvVar.uj(jSONObject.optString("bg_url"));
        yvVar.ve(jSONObject.optString("title"));
        yvVar.c(jSONObject.optString("reward_image_url"));
        yvVar.tt(jSONObject.optString("reward_title"));
        yvVar.n(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return yvVar;
    }

    public static com.byazt.ete.zm ve(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.byazt.ete.zm zmVar = new com.byazt.ete.zm();
        zmVar.ve(jSONObject.optString("ugen_dialog_md5"));
        zmVar.tt(jSONObject.optString("ugen_dialog_url"));
        zmVar.c(jSONObject.optString("dialog_style"));
        return zmVar;
    }

    private static int x(JSONObject jSONObject) {
        int i = 4;
        if ("download".equals(com.byazt.ppf.ve.c(jSONObject))) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(NativeCallContext.DOMAIN_APP);
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("package_name") : null;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObject.optString("package_name");
            }
            if (com.byazt.hu.u.n(gt.getContext(), strOptString)) {
                return 4;
            }
            i = 2;
            if (TextUtils.isEmpty(jSONObject.optString("market_url", ""))) {
                return com.byazt.bzd.tt.c(jSONObject) ? 2 : 1;
            }
        }
        return i;
    }

    private static int tt(ic icVar, int i) {
        if (i != 3 && i != 4 && i != 0) {
            if (!bx.c(icVar)) {
                return 416;
            }
            if (TextUtils.isEmpty(bx.sp(icVar))) {
                return TTAdConstant.LIVE_FEED_URL_CODE;
            }
        }
        return 200;
    }

    private static int tt(List<com.byazt.ete.zb> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return 410;
        }
        for (com.byazt.ete.zb zbVar : list) {
            if (zbVar == null) {
                return 411;
            }
            if (TextUtils.isEmpty(zbVar.c())) {
                return 412;
            }
        }
        return 200;
    }

    public static ic c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return c(jSONObject, (com.byazt.dj.tt) null, (bm) null, 0);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:102:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:105:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:108:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:111:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:114:0x0602  */
    /* JADX WARN: Code duplicated, block: B:118:0x0610  */
    /* JADX WARN: Code duplicated, block: B:121:0x065e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0660  */
    /* JADX WARN: Code duplicated, block: B:125:0x0672  */
    /* JADX WARN: Code duplicated, block: B:127:0x0678  */
    /* JADX WARN: Code duplicated, block: B:128:0x067d  */
    /* JADX WARN: Code duplicated, block: B:131:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:134:0x0723  */
    /* JADX WARN: Code duplicated, block: B:142:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:145:0x0892  */
    /* JADX WARN: Code duplicated, block: B:148:0x08b5  */
    /* JADX WARN: Code duplicated, block: B:151:0x0906  */
    /* JADX WARN: Code duplicated, block: B:154:0x0914  */
    /* JADX WARN: Code duplicated, block: B:161:0x09c4  */
    /* JADX WARN: Code duplicated, block: B:164:0x09cb A[LOOP:3: B:162:0x09c5->B:164:0x09cb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:167:0x09ee  */
    /* JADX WARN: Code duplicated, block: B:168:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:91:0x0560  */
    /* JADX WARN: Code duplicated, block: B:94:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:96:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:97:0x05ac  */
    public static ic c(JSONObject jSONObject, com.byazt.dj.tt ttVar, bm bmVar, int i) {
        String strVe;
        int i2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        boolean z;
        bx bxVar;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        String strOptString;
        JSONObject jSONObjectOptJSONObject5;
        JSONObject jSONObjectOptJSONObject6;
        JSONObject jSONObjectOptJSONObject7;
        Map<String, Object> mapYt;
        String strMk;
        JSONArray jSONArrayOptJSONArray;
        int iOptInt;
        int i3;
        com.byazt.lo.c cVar;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObjectOptJSONObject8;
        JSONObject jSONObjectOptJSONObject9;
        JSONObject jSONObjectOptJSONObject10;
        JSONObject jSONObjectOptJSONObject11;
        JSONObject jSONObjectOptJSONObject12;
        JSONObject jSONObjectOptJSONObject13;
        com.byazt.seg.c cVarC;
        if (jSONObject == null) {
            return null;
        }
        if (bmVar != null && ttVar != null) {
            gt.tt().ve(jSONObject.optInt("settings_open", 1));
        }
        final ic icVar = new ic();
        icVar.or(jSONObject.optString("s_sig_ts"));
        icVar.sl(jSONObject.optLong("ad_rec_stamp", 0L));
        icVar.nb(jSONObject.optInt("interaction_type"));
        icVar.nu(jSONObject.optString(ha0.c));
        icVar.z(jSONObject.optInt("use_sdk_player", 0));
        icVar.yp(jSONObject.optInt("use_media_video_player", 0));
        icVar.bx(jSONObject.optInt("landing_scroll_percentage", -1));
        icVar.rh(jSONObject.optString("gecko_id"));
        icVar.da(jSONObject.optBoolean("is_cache"));
        icVar.lr(jSONObject.optInt("cache_type", 100));
        com.byazt.dbo.ve.c(icVar, jSONObject);
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("set_click_type");
            icVar.tt(jSONObjectOptJSONObject14.optDouble("cta", 2.0d));
            icVar.c(jSONObjectOptJSONObject14.optDouble("other", 2.0d));
        }
        icVar.u(jSONObject.optInt("feed_video_finish_type"));
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("extension");
        icVar.uj(jSONObjectOptJSONObject15);
        icVar.n(jSONObject.optJSONObject("overlay"));
        icVar.gu(jSONObject.optString(MediationConstant.EXTRA_ADID));
        icVar.uj(jSONObject.optInt("get_phone_num_status"));
        icVar.m(jSONObject.optString("source"));
        icVar.d(jSONObject.optString("package_name"));
        icVar.zm(jSONObject.optInt("play_bar_show_time", IOfflineCompo.Priority.HIGHEST));
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject(RemoteMessageConst.Notification.ICON);
        icVar.i(jSONObject.optBoolean("screenshot", false));
        icVar.qy(jSONObject.optInt("play_bar_style", 0));
        icVar.h(jSONObject.optString("market_url", ""));
        icVar.gt(jSONObject.optInt("video_adaptation", 0));
        icVar.rh(jSONObject.optInt("feed_video_opentype", 0));
        icVar.my(jSONObject.optInt("feed_reward_type", -1));
        icVar.a(jSONObject.optJSONObject("session_params"));
        icVar.sp(jSONObject.optJSONObject("cache_control"));
        icVar.eo(jSONObject.optString("auction_price", ""));
        icVar.pu(jSONObject.optInt("no_default_ttdsp_price", 0));
        int iOptInt2 = jSONObject.optInt("meta_hashcode", 0);
        icVar.a(iOptInt2 != 0 ? iOptInt2 : (int) SystemClock.elapsedRealtime());
        String str = "width";
        String str2 = "height";
        if (jSONObjectOptJSONObject16 != null) {
            com.byazt.ete.zb zbVar = new com.byazt.ete.zb();
            zbVar.c(jSONObjectOptJSONObject16.optString("url"));
            zbVar.tt(jSONObjectOptJSONObject16.optInt("height"));
            zbVar.c(jSONObjectOptJSONObject16.optInt("width"));
            icVar.c(zbVar);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray3 != null) {
            int i4 = 0;
            while (i4 < jSONArrayOptJSONArray3.length()) {
                com.byazt.ete.zb zbVar2 = new com.byazt.ete.zb();
                JSONObject jSONObject2 = jSONObjectOptJSONObject15;
                JSONObject jSONObjectOptJSONObject17 = jSONArrayOptJSONArray3.optJSONObject(i4);
                zbVar2.c(jSONObjectOptJSONObject17.optString("url"));
                zbVar2.tt(jSONObjectOptJSONObject17.optInt(str2));
                zbVar2.c(jSONObjectOptJSONObject17.optInt(str));
                zbVar2.c(jSONObjectOptJSONObject17.optInt("duration"));
                zbVar2.c(jSONObjectOptJSONObject17.optBoolean("image_preview"));
                zbVar2.tt(jSONObjectOptJSONObject17.optString("image_key"));
                icVar.tt(zbVar2);
                i4++;
                jSONObjectOptJSONObject15 = jSONObject2;
                jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                str = str;
                str2 = str2;
            }
        }
        JSONObject jSONObject3 = jSONObjectOptJSONObject15;
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                icVar.pr().add(jSONArrayOptJSONArray4.optString(i5));
            }
        }
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("click_url");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                icVar.gl().add(jSONArrayOptJSONArray5.optString(i6));
            }
        }
        icVar.c(new com.byazt.ete.p(jSONObject.optJSONObject("extension")));
        icVar.c(new lr(jSONObject.optJSONObject("overlay")));
        icVar.c(new com.byazt.ete.md(jSONObject.optJSONArray("effects")));
        icVar.gu(jSONObject.optInt("intercept_flag", 0));
        icVar.gr(jSONObject.optInt("web_inspector", 0));
        icVar.my(jSONObject.optString("phone_num"));
        icVar.gt(jSONObject.optString("title"));
        icVar.uj(jSONObject.optLong("download_num"));
        icVar.rl(jSONObject.optString("description"));
        icVar.qy(jSONObject.optString("button_text"));
        icVar.rl(jSONObject.optInt("ad_logo", 1));
        icVar.ve(jSONObject.optBoolean("isDirectDownload", false));
        String strOptString2 = jSONObject.optString(LoginConstants.EXT);
        icVar.gr(strOptString2);
        try {
            if (TextUtils.isEmpty(strOptString2)) {
                strVe = null;
            } else {
                JSONObject jSONObject4 = new JSONObject(strOptString2);
                icVar.zm(jSONObject4.optString("req_id"));
                icVar.i(jSONObject4.optString("req_id"));
                icVar.yv(jSONObject4.optString(MediationConstant.EXTRA_ADID));
                DeviceUtils.c(jSONObject4.optLong("global_did", -1L));
                strVe = jSONObject4.optString("app_id");
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        if (TextUtils.isEmpty(strVe)) {
            strVe = com.byazt.vxy.c.ve();
        }
        icVar.qp(strVe);
        JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("adslot");
        if (jSONObjectOptJSONObject18 != null) {
            icVar.c(com.byazt.aas.md.c(jSONObjectOptJSONObject18.toString(), strVe));
        } else {
            icVar.c(ttVar);
        }
        icVar.t(jSONObject.optString("price"));
        icVar.ic(jSONObject.optInt("image_mode"));
        icVar.lt(jSONObject.optInt("orientation", 1));
        icVar.c((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        icVar.tt((float) jSONObject.optDouble("aspect_margin", 0.07000000029802322d));
        icVar.ve((float) jSONObject.optDouble("corner_radius", AudioStats.AUDIO_AMPLITUDE_NONE));
        JSONObject jSONObjectOptJSONObject19 = jSONObject.optJSONObject(NativeCallContext.DOMAIN_APP);
        JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject("download_sdk_conf");
        icVar.c(tt(jSONObjectOptJSONObject19));
        icVar.c(a(jSONObjectOptJSONObject20));
        icVar.tt(jSONObject.optLong("parse_material_ts", System.currentTimeMillis()));
        JSONObject jSONObjectOptJSONObject21 = jSONObject.optJSONObject("deep_link");
        if (jSONObjectOptJSONObject21 != null) {
            icVar.c(new com.byazt.ete.nu(jSONObjectOptJSONObject21));
        }
        icVar.c(new kp(jSONObject));
        icVar.c(new pu(jSONObject, String.valueOf(nb.t(icVar)), bmVar));
        icVar.c(new lo(jSONObject));
        icVar.c(new com.byazt.ete.my(jSONObject));
        icVar.c(new oz(jSONObject));
        icVar.c(new com.byazt.vo.tt(jSONObject, com.byazt.tl.uj.c()));
        icVar.c(new l(jSONObject));
        icVar.c(new qp(jSONObject));
        icVar.c(new to(jSONObject));
        icVar.c(new lt(jSONObject));
        icVar.c(new com.byazt.ete.or(jSONObject));
        icVar.hd(jSONObject.optInt("count_down"));
        icVar.n(jSONObject.optLong("expiration_time"));
        icVar.a(jSONObject.optLong("client_expiration_time"));
        icVar.sv(jSONObject.optString("_child_metas"));
        icVar.md(jSONObject.optString("src_req_id"));
        icVar.or(jSONObject.optInt("video_encode_type", 0));
        icVar.q(jSONObject.optInt("player_type", 0));
        icVar.cu(jSONObject.optInt("video_voice_control", -1));
        icVar.qp(jSONObject.optInt("if_show_win", 1));
        if (!p.n() && icVar.xx() == 1) {
            icVar.or(0);
            icVar.q(0);
        }
        JSONObject jSONObjectOptJSONObject22 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject22 != null) {
            icVar.c(new com.byazt.ete.gt(jSONObjectOptJSONObject22));
        }
        JSONObject jSONObjectOptJSONObject23 = jSONObject.optJSONObject("self_reward_callback");
        if (jSONObjectOptJSONObject23 != null) {
            tx txVar = new tx(jSONObjectOptJSONObject23);
            icVar.c(txVar);
            if (txVar.c()) {
                icVar.pf(x(jSONObject));
            }
        }
        icVar.l(jSONObject.optInt("if_both_open"));
        icVar.lo(jSONObject.optInt("if_double_deeplink"));
        JSONObject jSONObjectOptJSONObject24 = jSONObject.optJSONObject("app_manage");
        if (jSONObjectOptJSONObject24 != null) {
            icVar.c(n(jSONObjectOptJSONObject24));
            icVar.z(jSONObjectOptJSONObject24.toString());
        }
        JSONObject jSONObjectOptJSONObject25 = jSONObject.optJSONObject("easy_dl_dialog");
        if (jSONObjectOptJSONObject25 != null) {
            icVar.c(ve(jSONObjectOptJSONObject25));
        }
        JSONObject jSONObjectOptJSONObject26 = jSONObject.optJSONObject("easy_pl_material");
        if (jSONObjectOptJSONObject26 != null) {
            icVar.x(jSONObjectOptJSONObject26);
            icVar.c(uj(jSONObjectOptJSONObject26));
        }
        icVar.zb(jSONObject.optString("lp_down_rule", "0").equals("1") ? 1 : 0);
        icVar.c(jSONObject.optInt("micro_app_type", -1));
        String strOptString3 = jSONObject.optString("app_manage_type", "0");
        if (strOptString3.equals("1")) {
            icVar.eo(1);
        } else {
            if (strOptString3.equals("2")) {
                icVar.eo(2);
            } else {
                i2 = 0;
                icVar.eo(0);
            }
            icVar.c(sp(jSONObject.optJSONObject("media_ext")));
            icVar.m(jSONObject.optInt("if_block_lp", i2));
            icVar.yv(jSONObject.optInt("cache_sort", 1));
            icVar.p(jSONObject.optInt("if_sp_cache", 1));
            icVar.md(jSONObject.optInt("splash_timeout_stage", 1));
            icVar.sl(jSONObject.optInt("page_render_type", 0));
            if (icVar.tx() == 1 && (jSONObjectOptJSONObject13 = jSONObject.optJSONObject("ugeno")) != null) {
                cVarC = c(jSONObjectOptJSONObject13, icVar);
                icVar.c(cVarC);
                if (!com.byazt.xs.sp.c().tt(cVarC.c(), cVarC.tt())) {
                    com.byazt.hy.tt.c(cVarC, (com.byazt.hy.tt.InterfaceC0432tt) null);
                }
            }
            icVar.da(jSONObject.optInt("native_lp_tpl_id"));
            icVar.n(jSONObject.optString("native_lp_data"));
            icVar.a(jSONObject.optString("native_lp_ugen_url"));
            icVar.sp(jSONObject.optString("native_lp_ugen_md5"));
            icVar.a(jSONObject.optBoolean("native_lp_is_preload"));
            icVar.uj(jSONObject.optString("download_url"));
            if (icVar.tk()) {
                jSONObjectOptJSONObject12 = jSONObject.optJSONObject("native_lp_content");
                if (jSONObjectOptJSONObject12 != null) {
                    icVar.tt(jSONObjectOptJSONObject12);
                } else {
                    com.byazt.hy.tt.c(icVar.lo(), new com.byazt.hy.tt.c() { // from class: com.byazt.omf.c.1
                        @Override // com.byazt.hy.tt.c
                        public void c(int i7, String str3) {
                        }

                        @Override // com.byazt.hy.tt.c
                        public void c(JSONObject jSONObject5) {
                            icVar.tt(jSONObject5);
                        }
                    });
                }
            }
            icVar.t(jSONObject.optInt("promotion_type"));
            jSONObjectOptJSONObject = jSONObject.optJSONObject("dylite_info");
            if (jSONObjectOptJSONObject != null) {
                cVar = new com.byazt.lo.c();
                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("product_infos");
                if (jSONArrayOptJSONArray2 != null) {
                    cVar.c(jSONArrayOptJSONArray2);
                }
                jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("coupon");
                if (jSONObjectOptJSONObject8 != null) {
                    cVar.c(jSONObjectOptJSONObject8);
                }
                jSONObjectOptJSONObject9 = jSONObjectOptJSONObject.optJSONObject("render_config");
                if (jSONObjectOptJSONObject9 != null) {
                    cVar.tt(jSONObjectOptJSONObject9);
                }
                jSONObjectOptJSONObject10 = jSONObjectOptJSONObject.optJSONObject("live_room_data");
                if (jSONObjectOptJSONObject10 != null) {
                    cVar.ve(jSONObjectOptJSONObject10);
                }
                jSONObjectOptJSONObject11 = jSONObjectOptJSONObject.optJSONObject("ec_mall_conf");
                if (jSONObjectOptJSONObject11 != null) {
                    cVar.uj(jSONObjectOptJSONObject11);
                }
                icVar.c(cVar);
            }
            jSONObjectOptJSONObject2 = jSONObject.optJSONObject("splash_control");
            if (jSONObjectOptJSONObject2 != null) {
                icVar.c(c(jSONObjectOptJSONObject2, icVar.by()));
            }
            icVar.zb(jSONObject.optString("ad_info"));
            icVar.yp(jSONObject.optBoolean("close_on_dislike", false));
            icVar.cu(jSONObject.optString("adx_name"));
            icVar.kp(jSONObject.optInt("endcard_close_time", 0));
            icVar.b(jSONObject.optInt("proportion_watching", 100));
            icVar.os(jSONObject.optInt("video_skip_result", 3));
            if (jSONObject.optInt("is_ec_mall", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            icVar.z(z);
            bxVar = new bx(jSONObject);
            icVar.c(bxVar);
            if (bxVar.c()) {
                if (p.n()) {
                    icVar.q(-2);
                } else {
                    icVar.q(0);
                }
            }
            icVar.c(new xd(jSONObject));
            icVar.c(new com.byazt.ete.qy(jSONObject, true));
            icVar.c(new com.byazt.ete.cu(jSONObject));
            c(icVar, jSONObject);
            jSONObjectOptJSONObject3 = jSONObject.optJSONObject("skip_control");
            if (jSONObjectOptJSONObject3 != null) {
                iu iuVar = new iu();
                iuVar.c(jSONObjectOptJSONObject3.optInt("position", 2));
                iuVar.tt(jSONObjectOptJSONObject3.optInt("left_or_right_margin", 16));
                iuVar.ve(jSONObjectOptJSONObject3.optInt("top_or_bottom_margin", 30));
                iuVar.uj(jSONObjectOptJSONObject3.optInt("skip_style", 1));
                iuVar.n(jSONObjectOptJSONObject3.optInt("hide_native_skip_logo", 0));
                icVar.c(iuVar);
            }
            icVar.to(jSONObject.optInt("shake_value", 13));
            icVar.oz(jSONObject.optInt("deep_shake_value"));
            icVar.tk(jSONObject.optInt("rotation_angle", 50));
            icVar.sv(jSONObject.optInt("dynamic_join_type", 0));
            icVar.aw(jSONObject.optInt("dynamic_join_duration", 0));
            icVar.h(jSONObject.optInt("calculation_method", 0));
            jSONObjectOptJSONObject4 = jSONObject.optJSONObject("splash_compliance_bar");
            if (jSONObjectOptJSONObject4 != null) {
                r rVar = new r();
                rVar.c(jSONObjectOptJSONObject4.optInt("show_type", 0));
                rVar.tt(jSONObjectOptJSONObject4.optInt("blank", 90));
                rVar.ve(jSONObjectOptJSONObject4.optInt("half_blank", 90));
                icVar.c(rVar);
            }
            icVar.kk(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
            icVar.u(jSONObject.optString("adm"));
            icVar.sp(jSONObject.optBoolean("is_cache"));
            icVar.da(jSONObject.optString("log_ext"));
            icVar.x(jSONObject.optString("cache_ext"));
            strOptString = jSONObject.optString("req_id");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(icVar.oz())) {
                icVar.i(strOptString);
            }
            icVar.c(jSONObject.optLong("cache_time"));
            icVar.sl(jSONObject.optString("material_key"));
            icVar.x(jSONObject.optBoolean("need_get_materials"));
            icVar.ve(jSONObject.optLong("s_send_ts"));
            icVar.c(hq.c(jSONObject.optJSONObject("wc_miniapp_info")));
            icVar.pf(jSONObject.optString("live_room_id", ""));
            icVar.tx(jSONObject.optInt("ad_type", 0));
            icVar.v(jSONObject.optInt("live_interaction_type", 1));
            icVar.yp(jSONObject.optString("ec_schema", ""));
            icVar.nu(jSONObject.optInt("draw_video_playcount", 2));
            jSONObjectOptJSONObject5 = jSONObject.optJSONObject("dynamic_join_coupon_style");
            if (jSONObjectOptJSONObject5 != null) {
                com.byazt.ete.z zVar = new com.byazt.ete.z();
                zVar.c(jSONObjectOptJSONObject5.optInt("style_type"));
                zVar.c(jSONObjectOptJSONObject5.optString("image_url"));
                zVar.tt(jSONObjectOptJSONObject5.optInt("position"));
                zVar.c(jSONObjectOptJSONObject5.optDouble("image_height"));
                zVar.tt(jSONObjectOptJSONObject5.optString("image_gif_url"));
                zVar.tt(jSONObjectOptJSONObject5.optDouble("image_scale_rate"));
                zVar.ve(jSONObjectOptJSONObject5.optDouble("image_gif_aspect_ratio"));
                icVar.c(zVar);
            }
            icVar.bx(jSONObject.optString("ecom_live_params"));
            icVar.ve(jSONObject.optJSONObject("group_info"));
            icVar.c(com.byazt.ete.yp.c(jSONObject.optJSONObject("coupon")));
            icVar.c(sv.c(jSONObject.optJSONObject("live_info")));
            icVar.c(q.c(jSONObject.optJSONObject("saas_info")));
            icVar.c(kk.c(jSONObject.optJSONObject("saas_on_click_material")));
            icVar.iu(jSONObject.optInt("live_sdk_status_while_first_click", -1001));
            jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_config");
            if (jSONObjectOptJSONObject6 != null) {
                j jVar = new j();
                jVar.c(jSONObjectOptJSONObject6.optInt("video_adapter_type", 1));
                jVar.tt(jSONObjectOptJSONObject6.optInt("video_mute_type", 1));
                icVar.c(jVar);
            }
            jSONObjectOptJSONObject7 = jSONObject.optJSONObject("click_trigger_config");
            if (jSONObjectOptJSONObject7 != null) {
                com.byazt.ete.sl slVar = new com.byazt.ete.sl();
                slVar.c(jSONObjectOptJSONObject7.optInt("click_trigger_type"));
                slVar.c((float) jSONObjectOptJSONObject7.optDouble("shake_start_time", AudioStats.AUDIO_AMPLITUDE_NONE));
                slVar.tt((float) jSONObjectOptJSONObject7.optDouble("shake_end_time", 2.147483648E9d));
                icVar.c(slVar);
            }
            icVar.d(jSONObject.optInt("calculation_method_twist"));
            icVar.nb(jSONObject.optString("dynamic_configs"));
            icVar.r(jSONObject.optInt("gnd_prefetch_timing"));
            icVar.aw(jSONObject.optString("gnd_prefetch_cache_key"));
            mapYt = icVar.yt();
            if (mapYt == null) {
                mapYt = new HashMap<>();
                icVar.c(mapYt);
            }
            strMk = icVar.mk();
            if (strMk != null) {
                mapYt.put("ad_token", strMk);
                uj.c().tt(strMk);
            }
            if (jSONObject3 != null && com.byazt.ete.p.c(icVar)) {
                mapYt.put("style_category", Integer.valueOf(com.byazt.ete.p.uj(icVar)));
            }
            icVar.u(jSONObject.optJSONObject("applist_info"));
            icVar.s(jSONObject.optInt("click_freq"));
            icVar.y(jSONObject.optInt("if_lpua_package"));
            icVar.i(jSONObject.optJSONObject("twist_config"));
            icVar.da(jSONObject.optJSONObject("shake_interact_conf"));
            icVar.sl(jSONObject.optJSONObject("twist_interact_conf"));
            icVar.c(com.byazt.ete.h.c(jSONObject));
            icVar.c(jSONObject.optJSONObject("sdk_derive_info"));
            icVar.n(jSONObject.optInt("disable_video_join"));
            icVar.x(jSONObject.optInt("disable_top_bar"));
            icVar.i(jSONObject.optInt("disable_rtn_button"));
            icVar.tt(jSONObject.optInt("web_monitor_rate", 0));
            icVar.sp(jSONObject.optInt("disable_slide_return"));
            icVar.j(jSONObject.optInt("is_height_resize", 1));
            icVar.tt(jSONObject.optBoolean("disable_safe_area"));
            jSONArrayOptJSONArray = jSONObject.optJSONArray("haptic");
            if (jSONArrayOptJSONArray != null) {
                for (i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    icVar.c(new com.byazt.ete.eo(jSONArrayOptJSONArray.optJSONObject(i3)));
                }
            }
            icVar.ve(jSONObject.optInt("fix_click_sequence"));
            icVar.t(jSONObject.optJSONObject("_meta_life_record"));
            if (i > 0) {
                iOptInt = i;
            } else {
                iOptInt = jSONObject.optInt("_ad_index", 1);
            }
            icVar.bm(iOptInt);
            return icVar;
        }
        i2 = 0;
        icVar.c(sp(jSONObject.optJSONObject("media_ext")));
        icVar.m(jSONObject.optInt("if_block_lp", i2));
        icVar.yv(jSONObject.optInt("cache_sort", 1));
        icVar.p(jSONObject.optInt("if_sp_cache", 1));
        icVar.md(jSONObject.optInt("splash_timeout_stage", 1));
        icVar.sl(jSONObject.optInt("page_render_type", 0));
        if (icVar.tx() == 1) {
            cVarC = c(jSONObjectOptJSONObject13, icVar);
            icVar.c(cVarC);
            if (!com.byazt.xs.sp.c().tt(cVarC.c(), cVarC.tt())) {
                com.byazt.hy.tt.c(cVarC, (com.byazt.hy.tt.InterfaceC0432tt) null);
            }
        }
        icVar.da(jSONObject.optInt("native_lp_tpl_id"));
        icVar.n(jSONObject.optString("native_lp_data"));
        icVar.a(jSONObject.optString("native_lp_ugen_url"));
        icVar.sp(jSONObject.optString("native_lp_ugen_md5"));
        icVar.a(jSONObject.optBoolean("native_lp_is_preload"));
        icVar.uj(jSONObject.optString("download_url"));
        if (icVar.tk()) {
            jSONObjectOptJSONObject12 = jSONObject.optJSONObject("native_lp_content");
            if (jSONObjectOptJSONObject12 != null) {
                icVar.tt(jSONObjectOptJSONObject12);
            } else {
                com.byazt.hy.tt.c(icVar.lo(), new com.byazt.hy.tt.c() { // from class: com.byazt.omf.c.1
                    @Override // com.byazt.hy.tt.c
                    public void c(int i7, String str3) {
                    }

                    @Override // com.byazt.hy.tt.c
                    public void c(JSONObject jSONObject5) {
                        icVar.tt(jSONObject5);
                    }
                });
            }
        }
        icVar.t(jSONObject.optInt("promotion_type"));
        jSONObjectOptJSONObject = jSONObject.optJSONObject("dylite_info");
        if (jSONObjectOptJSONObject != null) {
            cVar = new com.byazt.lo.c();
            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("product_infos");
            if (jSONArrayOptJSONArray2 != null) {
                cVar.c(jSONArrayOptJSONArray2);
            }
            jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("coupon");
            if (jSONObjectOptJSONObject8 != null) {
                cVar.c(jSONObjectOptJSONObject8);
            }
            jSONObjectOptJSONObject9 = jSONObjectOptJSONObject.optJSONObject("render_config");
            if (jSONObjectOptJSONObject9 != null) {
                cVar.tt(jSONObjectOptJSONObject9);
            }
            jSONObjectOptJSONObject10 = jSONObjectOptJSONObject.optJSONObject("live_room_data");
            if (jSONObjectOptJSONObject10 != null) {
                cVar.ve(jSONObjectOptJSONObject10);
            }
            jSONObjectOptJSONObject11 = jSONObjectOptJSONObject.optJSONObject("ec_mall_conf");
            if (jSONObjectOptJSONObject11 != null) {
                cVar.uj(jSONObjectOptJSONObject11);
            }
            icVar.c(cVar);
        }
        jSONObjectOptJSONObject2 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject2 != null) {
            icVar.c(c(jSONObjectOptJSONObject2, icVar.by()));
        }
        icVar.zb(jSONObject.optString("ad_info"));
        icVar.yp(jSONObject.optBoolean("close_on_dislike", false));
        icVar.cu(jSONObject.optString("adx_name"));
        icVar.kp(jSONObject.optInt("endcard_close_time", 0));
        icVar.b(jSONObject.optInt("proportion_watching", 100));
        icVar.os(jSONObject.optInt("video_skip_result", 3));
        if (jSONObject.optInt("is_ec_mall", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        icVar.z(z);
        bxVar = new bx(jSONObject);
        icVar.c(bxVar);
        if (bxVar.c()) {
            if (p.n()) {
                icVar.q(-2);
            } else {
                icVar.q(0);
            }
        }
        icVar.c(new xd(jSONObject));
        icVar.c(new com.byazt.ete.qy(jSONObject, true));
        icVar.c(new com.byazt.ete.cu(jSONObject));
        c(icVar, jSONObject);
        jSONObjectOptJSONObject3 = jSONObject.optJSONObject("skip_control");
        if (jSONObjectOptJSONObject3 != null) {
            iu iuVar2 = new iu();
            iuVar2.c(jSONObjectOptJSONObject3.optInt("position", 2));
            iuVar2.tt(jSONObjectOptJSONObject3.optInt("left_or_right_margin", 16));
            iuVar2.ve(jSONObjectOptJSONObject3.optInt("top_or_bottom_margin", 30));
            iuVar2.uj(jSONObjectOptJSONObject3.optInt("skip_style", 1));
            iuVar2.n(jSONObjectOptJSONObject3.optInt("hide_native_skip_logo", 0));
            icVar.c(iuVar2);
        }
        icVar.to(jSONObject.optInt("shake_value", 13));
        icVar.oz(jSONObject.optInt("deep_shake_value"));
        icVar.tk(jSONObject.optInt("rotation_angle", 50));
        icVar.sv(jSONObject.optInt("dynamic_join_type", 0));
        icVar.aw(jSONObject.optInt("dynamic_join_duration", 0));
        icVar.h(jSONObject.optInt("calculation_method", 0));
        jSONObjectOptJSONObject4 = jSONObject.optJSONObject("splash_compliance_bar");
        if (jSONObjectOptJSONObject4 != null) {
            r rVar2 = new r();
            rVar2.c(jSONObjectOptJSONObject4.optInt("show_type", 0));
            rVar2.tt(jSONObjectOptJSONObject4.optInt("blank", 90));
            rVar2.ve(jSONObjectOptJSONObject4.optInt("half_blank", 90));
            icVar.c(rVar2);
        }
        icVar.kk(jSONObject.optInt("show_poll_time", Integer.MIN_VALUE));
        icVar.u(jSONObject.optString("adm"));
        icVar.sp(jSONObject.optBoolean("is_cache"));
        icVar.da(jSONObject.optString("log_ext"));
        icVar.x(jSONObject.optString("cache_ext"));
        strOptString = jSONObject.optString("req_id");
        if (!TextUtils.isEmpty(strOptString)) {
            icVar.i(strOptString);
        }
        icVar.c(jSONObject.optLong("cache_time"));
        icVar.sl(jSONObject.optString("material_key"));
        icVar.x(jSONObject.optBoolean("need_get_materials"));
        icVar.ve(jSONObject.optLong("s_send_ts"));
        icVar.c(hq.c(jSONObject.optJSONObject("wc_miniapp_info")));
        icVar.pf(jSONObject.optString("live_room_id", ""));
        icVar.tx(jSONObject.optInt("ad_type", 0));
        icVar.v(jSONObject.optInt("live_interaction_type", 1));
        icVar.yp(jSONObject.optString("ec_schema", ""));
        icVar.nu(jSONObject.optInt("draw_video_playcount", 2));
        jSONObjectOptJSONObject5 = jSONObject.optJSONObject("dynamic_join_coupon_style");
        if (jSONObjectOptJSONObject5 != null) {
            com.byazt.ete.z zVar2 = new com.byazt.ete.z();
            zVar2.c(jSONObjectOptJSONObject5.optInt("style_type"));
            zVar2.c(jSONObjectOptJSONObject5.optString("image_url"));
            zVar2.tt(jSONObjectOptJSONObject5.optInt("position"));
            zVar2.c(jSONObjectOptJSONObject5.optDouble("image_height"));
            zVar2.tt(jSONObjectOptJSONObject5.optString("image_gif_url"));
            zVar2.tt(jSONObjectOptJSONObject5.optDouble("image_scale_rate"));
            zVar2.ve(jSONObjectOptJSONObject5.optDouble("image_gif_aspect_ratio"));
            icVar.c(zVar2);
        }
        icVar.bx(jSONObject.optString("ecom_live_params"));
        icVar.ve(jSONObject.optJSONObject("group_info"));
        icVar.c(com.byazt.ete.yp.c(jSONObject.optJSONObject("coupon")));
        icVar.c(sv.c(jSONObject.optJSONObject("live_info")));
        icVar.c(q.c(jSONObject.optJSONObject("saas_info")));
        icVar.c(kk.c(jSONObject.optJSONObject("saas_on_click_material")));
        icVar.iu(jSONObject.optInt("live_sdk_status_while_first_click", -1001));
        jSONObjectOptJSONObject6 = jSONObject.optJSONObject("video_config");
        if (jSONObjectOptJSONObject6 != null) {
            j jVar2 = new j();
            jVar2.c(jSONObjectOptJSONObject6.optInt("video_adapter_type", 1));
            jVar2.tt(jSONObjectOptJSONObject6.optInt("video_mute_type", 1));
            icVar.c(jVar2);
        }
        jSONObjectOptJSONObject7 = jSONObject.optJSONObject("click_trigger_config");
        if (jSONObjectOptJSONObject7 != null) {
            com.byazt.ete.sl slVar2 = new com.byazt.ete.sl();
            slVar2.c(jSONObjectOptJSONObject7.optInt("click_trigger_type"));
            slVar2.c((float) jSONObjectOptJSONObject7.optDouble("shake_start_time", AudioStats.AUDIO_AMPLITUDE_NONE));
            slVar2.tt((float) jSONObjectOptJSONObject7.optDouble("shake_end_time", 2.147483648E9d));
            icVar.c(slVar2);
        }
        icVar.d(jSONObject.optInt("calculation_method_twist"));
        icVar.nb(jSONObject.optString("dynamic_configs"));
        icVar.r(jSONObject.optInt("gnd_prefetch_timing"));
        icVar.aw(jSONObject.optString("gnd_prefetch_cache_key"));
        mapYt = icVar.yt();
        if (mapYt == null) {
            mapYt = new HashMap<>();
            icVar.c(mapYt);
        }
        strMk = icVar.mk();
        if (strMk != null) {
            mapYt.put("ad_token", strMk);
            uj.c().tt(strMk);
        }
        if (jSONObject3 != null) {
            mapYt.put("style_category", Integer.valueOf(com.byazt.ete.p.uj(icVar)));
        }
        icVar.u(jSONObject.optJSONObject("applist_info"));
        icVar.s(jSONObject.optInt("click_freq"));
        icVar.y(jSONObject.optInt("if_lpua_package"));
        icVar.i(jSONObject.optJSONObject("twist_config"));
        icVar.da(jSONObject.optJSONObject("shake_interact_conf"));
        icVar.sl(jSONObject.optJSONObject("twist_interact_conf"));
        icVar.c(com.byazt.ete.h.c(jSONObject));
        icVar.c(jSONObject.optJSONObject("sdk_derive_info"));
        icVar.n(jSONObject.optInt("disable_video_join"));
        icVar.x(jSONObject.optInt("disable_top_bar"));
        icVar.i(jSONObject.optInt("disable_rtn_button"));
        icVar.tt(jSONObject.optInt("web_monitor_rate", 0));
        icVar.sp(jSONObject.optInt("disable_slide_return"));
        icVar.j(jSONObject.optInt("is_height_resize", 1));
        icVar.tt(jSONObject.optBoolean("disable_safe_area"));
        jSONArrayOptJSONArray = jSONObject.optJSONArray("haptic");
        if (jSONArrayOptJSONArray != null) {
            while (i3 < jSONArrayOptJSONArray.length()) {
                icVar.c(new com.byazt.ete.eo(jSONArrayOptJSONArray.optJSONObject(i3)));
            }
        }
        icVar.ve(jSONObject.optInt("fix_click_sequence"));
        icVar.t(jSONObject.optJSONObject("_meta_life_record"));
        if (i > 0) {
            iOptInt = i;
        } else {
            iOptInt = jSONObject.optInt("_ad_index", 1);
        }
        icVar.bm(iOptInt);
        return icVar;
    }

    private static com.byazt.seg.c c(JSONObject jSONObject, ic icVar) {
        com.byazt.seg.c cVar = new com.byazt.seg.c();
        cVar.c(jSONObject.optString("id"));
        cVar.tt(jSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
        cVar.ve(jSONObject.optString("url"));
        cVar.c(jSONObject.optInt("scene"));
        return cVar;
    }

    private static void c(ic icVar, JSONObject jSONObject) {
        com.byazt.ete.nu nuVarYp;
        if (icVar == null || jSONObject == null) {
            return;
        }
        if ((bx.c(icVar) || to.c(icVar)) && (nuVarYp = icVar.yp()) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            pf pfVar = new pf();
            if (jSONObjectOptJSONObject != null) {
                pfVar.c(jSONObjectOptJSONObject.optString("reward_live_deep_link_user_id"));
                pfVar.n(jSONObjectOptJSONObject.optString("reward_live_deep_link_request_id"));
                pfVar.tt(jSONObjectOptJSONObject.optString("reward_live_deep_link_room_id"));
                pfVar.ve(jSONObjectOptJSONObject.optString("reawrd_live_short_touch_params"));
                pfVar.uj(jSONObjectOptJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                pfVar.c(jSONObjectOptJSONObject.optLong("reward_live_last_time"));
                icVar.c(pfVar);
            } else {
                Map<String, String> mapC = com.byazt.aas.bx.c(nuVarYp.tt());
                if (mapC == null || mapC.size() <= 0) {
                    return;
                }
                pfVar.c(mapC.get(PtgRewardConstant.REWARD_PARAMS.USER_ID));
                pfVar.n(mapC.get("request_id"));
                pfVar.tt(mapC.get("room_id"));
                pfVar.ve(mapC.get("live_short_touch_params"));
                pfVar.uj(mapC.get("extra_pangle_scheme_params"));
                icVar.c(pfVar);
            }
            icVar.u(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    private static s c(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        s sVar = new s();
        double dOptDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        sVar.c((int) ((dOptDouble == 1.0d || dOptDouble == 2.0d) ? dOptDouble : 1.0d));
        sVar.sp(jSONObject.optInt("splash_style_id", 0));
        sVar.c(jSONObject.optString("splash_clicktext", ""));
        sVar.tt(jSONObject.optInt("area_height", 50));
        sVar.ve(jSONObject.optInt("area_width", 236));
        if (i == 2) {
            sVar.uj(jSONObject.optInt("area_blank_height", 32));
        } else {
            sVar.uj(jSONObject.optInt("area_blank_height", 82));
        }
        sVar.n(jSONObject.optInt("half_blank_height", 56));
        sVar.tt(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        sVar.ve(jSONObject.optString("top_splash_clicktext"));
        sVar.c(jSONObject.optJSONObject("text_config"));
        sVar.tt(jSONObject.optJSONObject("top_text_config"));
        sVar.x(jSONObject.optInt("sliding_distance", 5));
        sVar.c(jSONObject.optJSONObject("slide_area"), i);
        sVar.a(jSONObject.optInt("splash_load_time_optimization"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mock_interact");
        if (jSONObjectOptJSONObject != null) {
            try {
                sVar.c((float) jSONObjectOptJSONObject.optDouble("enable_ratio", AudioStats.AUDIO_AMPLITUDE_NONE));
                sVar.i(jSONObjectOptJSONObject.optInt("backup_add", 0));
                sVar.da(jSONObjectOptJSONObject.optInt("slide_direction", 0));
                sVar.sl(jSONObjectOptJSONObject.optInt("slide_threshold", 55));
                sVar.t(jSONObjectOptJSONObject.optInt("view_height_dynamic", 0));
                sVar.tt((float) jSONObjectOptJSONObject.optDouble("view_height_percent", AudioStats.AUDIO_AMPLITUDE_NONE));
                sVar.u(jSONObjectOptJSONObject.optInt("view_post", 100));
                sVar.yp(jSONObjectOptJSONObject.optInt("ignore_up", 0));
                sVar.z(jSONObjectOptJSONObject.optInt("long_press_duration", 0));
                sVar.m(jSONObjectOptJSONObject.optInt("long_press_threshold", 10));
            } catch (Exception unused) {
                com.byazt.nr.m.uj("SplashControl", "interact parse error");
            }
        }
        return sVar;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    public static int c(ic icVar, int i) {
        if (TextUtils.isEmpty(icVar.uj()) || icVar.uj().length() <= 1) {
            return 401;
        }
        int iC = c(icVar.yp());
        if (iC != 200) {
            return iC;
        }
        int iC2 = c(icVar);
        if (iC2 != 200) {
            return iC2;
        }
        int i2 = icVar.i();
        if (i2 == 2 || i2 == 3) {
            if (TextUtils.isEmpty(icVar.x())) {
                return 405;
            }
        } else if (i2 != 4) {
            if (i2 == 5 && TextUtils.isEmpty(icVar.tp())) {
                return 408;
            }
        } else {
            iC2 = c(icVar.z());
            if (iC2 != 200) {
                return iC2;
            }
        }
        int iId = icVar.id();
        if (iId == 2 || iId == 3 || iId == 4) {
            iC2 = tt(icVar.pa());
            if (iC2 != 200) {
            }
        } else if (iId == 5 || iId == 15) {
            iC2 = xd.da(icVar);
            if (iC2 != 200) {
                return iC2;
            }
        } else if (iId == 16) {
            iC2 = tt(icVar.pa());
            if (iC2 != 200) {
            }
        } else if (iId == 166 && (iC2 = tt(icVar, i)) != 200) {
            return iC2;
        }
        return iC2;
    }

    private static int c(ic icVar) {
        if (!(icVar.id() == 166 && bx.c(icVar)) || p.n()) {
            return 200;
        }
        com.byazt.nr.m.ve("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int c(com.byazt.ete.nu nuVar) {
        if (nuVar == null) {
            return 200;
        }
        if (!TextUtils.isEmpty(nuVar.tt()) && !TextUtils.isEmpty(nuVar.uj())) {
            return (nuVar.n() == 1 || nuVar.n() == 2) ? 200 : 403;
        }
        if (TextUtils.isEmpty(nuVar.tt())) {
            return 402;
        }
        return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
    }

    private static int c(com.byazt.ete.n nVar) {
        if (nVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(nVar.tt()) ? 407 : 200;
    }

    public static void c(List<ic> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        List<ic> listSubList = list.subList(1, list.size());
        JSONArray jSONArray = new JSONArray();
        Iterator<ic> it = listSubList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().yg());
        }
        if (jSONArray.length() > 0) {
            list.get(0).sv(jSONArray.toString());
        }
    }
}
