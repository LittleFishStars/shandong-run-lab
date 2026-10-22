package com.byazt.jlk;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.bx;
import com.byazt.ete.gt;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.ma;
import com.byazt.ete.my;
import com.byazt.ete.pu;
import com.byazt.ete.to;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.nr.m;
import com.byazt.omf.d;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 249, 13})
public class tt {
    private static JSONObject a(ic icVar) {
        JSONObject jSONObject = new JSONObject();
        if (icVar != null && com.byazt.ex.c.c(icVar)) {
            try {
                jSONObject.put("live_show_time", bx.tt(icVar));
                jSONObject.put("live_author_nickname", bx.ve(icVar));
                if (bx.uj(icVar) > 0) {
                    jSONObject.put("live_author_follower_count", bx.uj(icVar));
                }
                if (bx.n(icVar) > 0) {
                    jSONObject.put("live_watch_count", bx.n(icVar));
                }
                jSONObject.put("live_description", bx.a(icVar));
                jSONObject.put("live_feed_url", bx.sp(icVar));
                jSONObject.put("live_cover_image_url", bx.x(icVar));
                jSONObject.put("live_avatar_url", bx.i(icVar));
                jSONObject.put("live_cover_image_width", bx.t(icVar));
                jSONObject.put("live_cover_image_height", bx.u(icVar));
                jSONObject.put("live_avatar_width", bx.da(icVar));
                jSONObject.put("live_avatar_height", bx.sl(icVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject c(float f, float f2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f);
            jSONObject.put("height", f2);
            if (z) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    public static Map<String, String> n(ic icVar) {
        HashMap map = null;
        if (icVar == null) {
            return null;
        }
        List<zb> listPa = icVar.pa();
        if (listPa != null && listPa.size() > 0) {
            map = new HashMap();
            for (zb zbVar : listPa) {
                if (zbVar != null) {
                    map.put(zbVar.c(), zbVar.sp());
                }
            }
        }
        return map;
    }

    public static JSONObject tt(ic icVar) {
        int[] iArrN;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", icVar.tj());
            if (icVar.te() != null) {
                jSONObject.put(RemoteMessageConst.Notification.ICON, icVar.te().c());
            }
            JSONArray jSONArray = new JSONArray();
            if (icVar.pa() != null) {
                for (int i = 0; i < icVar.pa().size(); i++) {
                    zb zbVar = icVar.pa().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", zbVar.ve());
                    jSONObject2.put("width", zbVar.tt());
                    jSONObject2.put("url", zbVar.c());
                    jSONObject2.put("image_key", zbVar.sp());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", icVar.id());
            jSONObject.put("interaction_type", icVar.i());
            jSONObject.put("is_compliance_template", ve(icVar));
            jSONObject.put("title", icVar.v_());
            jSONObject.put("description", icVar.op());
            jSONObject.put("source", icVar.an());
            if (icVar.z() != null) {
                jSONObject.put("comment_num", icVar.z().a());
                jSONObject.put("score", icVar.z().n());
                jSONObject.put("app_size", icVar.z().sp());
                jSONObject.put(NativeCallContext.DOMAIN_APP, icVar.z().x());
            }
            if (xd.z(icVar) != null) {
                JSONObject jsonObj = xd.yp(icVar).toJsonObj();
                if (icVar.pb() > 0 && xd.sp(icVar) > icVar.pb()) {
                    jsonObj.put(CropKey.VIDEO_DURATION, icVar.pb());
                }
                if (com.byazt.ic.c.c(icVar) && (iArrN = xd.n(icVar)) != null && iArrN.length >= 2 && !com.byazt.ic.c.sp(icVar)) {
                    jsonObj.put("cover_width", iArrN[0]);
                    jsonObj.put("cover_height", iArrN[1]);
                }
                xd.sp(icVar);
                jSONObject.put("video", jsonObj);
            }
            if (kp.nu(icVar)) {
                jSONObject.put("reward_full_play_time", kp.z(icVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", kp.p(icVar));
            if (pu.a(icVar) != null) {
                jSONObject.put("dynamic_creative", pu.a(icVar).sp());
            }
            jSONObject.put("live_ad", a(icVar));
            c(icVar, jSONObject);
            if (com.byazt.apd.tt.c().tt(icVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", icVar.dn());
            jSONObject.put("can_show_interactive", icVar.wj());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String uj(ic icVar) {
        if (pu.a(icVar) == null) {
            return null;
        }
        return pu.a(icVar).tt();
    }

    public static boolean ve(ic icVar) {
        return icVar != null && gt.t(icVar) == 2;
    }

    public static JSONObject c(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return null;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            Context context = com.byazt.omf.gt.getContext();
            jSONObject.put("width", pf.uj(context, width) * 1.0f);
            jSONObject.put("height", pf.uj(context, height) * 1.0f);
            return jSONObject;
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    public static JSONObject c(ic icVar) {
        ma maVarSp = pu.sp(icVar);
        if (maVarSp == null) {
            return null;
        }
        String strUj = maVarSp.uj();
        try {
            if (!TextUtils.isEmpty(strUj)) {
                return new JSONObject(strUj);
            }
            String strC = com.byazt.nq.tt.c().c("ad", maVarSp.c(), maVarSp.tt());
            if (!TextUtils.isEmpty(strC)) {
                return new JSONObject(strC);
            }
            m.uj("TemplateUtils", "template is null");
            return null;
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    public static JSONObject c(ic icVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z, String str, boolean z2) {
        JSONObject jSONObjectYg = icVar.yg();
        try {
            jSONObjectYg.put("xSetting", d.c(icVar, (AtomicBoolean) null));
            jSONObjectYg.put("xAdInfo", c(icVar, str));
            JSONObject jSONObject3 = new JSONObject();
            d.c(jSONObject3, nb.sl(icVar));
            jSONObject3.put("platform", "android");
            jSONObjectYg.put("xAppInfo", jSONObject3);
            jSONObjectYg.put("xCreative", tt(icVar));
            if (jSONObject2 != null) {
                jSONObjectYg.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                float fOptDouble = (float) jSONObject.optDouble("width");
                float fOptDouble2 = (float) jSONObject.optDouble("height");
                boolean zOptBoolean = jSONObject.optBoolean("isLandscape");
                if (!Float.isNaN(fOptDouble) && !Float.isNaN(fOptDouble2)) {
                    if (z2 && com.byazt.omf.gt.tt().qe()) {
                        float f = com.byazt.omf.gt.getContext().getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        jSONObject.put("width", pf.tt(f2, pf.c(f, fOptDouble)));
                        jSONObject.put("height", pf.tt(f2, pf.c(f, fOptDouble2)));
                    } else {
                        if (!z2 && com.byazt.omf.gt.tt().jy() && !zOptBoolean) {
                            jSONObject.put("width", Math.min(fOptDouble, pf.uj(com.byazt.omf.gt.getContext(), pf.uj(com.byazt.omf.gt.getContext()))));
                        }
                        jSONObject.put("height", fOptDouble2);
                    }
                } else {
                    jSONObject.put("width", AudioStats.AUDIO_AMPLITUDE_NONE);
                    jSONObject.put("height", AudioStats.AUDIO_AMPLITUDE_NONE);
                }
                try {
                    jSONObject.put("render_height_limit", pu.c(icVar, jSONObject.optInt("width")));
                } catch (JSONException unused) {
                }
                jSONObjectYg.put("xSize", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            Context context = com.byazt.omf.gt.getContext();
            jSONObject5.put("width", pf.uj(context, pf.uj(context)));
            jSONObject5.put("height", pf.uj(context, pf.n(context)));
            jSONObject4.put("screen_size", jSONObject5);
            jSONObject4.put("content_size", jSONObject);
            jSONObject4.put("platform", "android");
            jSONObjectYg.put("xEnvInfo", jSONObject4);
            jSONObjectYg.put("gesture_through_enable", z && com.byazt.omf.gt.tt().nx());
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObjectYg;
    }

    public static String tt(ic icVar, String str) {
        List<zb> listPa;
        if (icVar != null && (listPa = icVar.pa()) != null && listPa.size() > 0) {
            for (zb zbVar : listPa) {
                if (zbVar != null && TextUtils.equals(str, zbVar.c())) {
                    return zbVar.sp();
                }
            }
        }
        return null;
    }

    public static JSONObject c(ic icVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strUj = icVar.uj();
            if (!TextUtils.isEmpty(strUj)) {
                jSONObject.put("cid", strUj);
            }
            String strW_ = icVar.w_();
            if (!TextUtils.isEmpty(strW_)) {
                jSONObject.put("log_extra", strW_);
            }
            String strMy = nb.my(icVar);
            if (!TextUtils.isEmpty(strMy)) {
                jSONObject.put("download_url", strMy);
            }
            jSONObject.put("isDirectDownload", icVar.hd());
            jSONObject.put("dynamic_configs", icVar.m());
            if (!TextUtils.isEmpty(str) && str.contains("advance_reward")) {
                jSONObject.put("userData", str);
            }
            if (my.u(icVar)) {
                jSONObject.put("voice_btn_position", my.nu(icVar));
            }
            jSONObject.put("if_show_win", icVar.oq());
            String strHl = icVar.hl();
            if (!TextUtils.isEmpty(strHl) && strHl.contains(",")) {
                jSONObject.put("isMultAd", 1);
            }
            jSONObject.put("is_derive_image", com.byazt.ic.c.uj(icVar));
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject;
    }

    public static JSONObject c(float f, float f2, boolean z, ic icVar, boolean z2) {
        String strN;
        String strA;
        com.byazt.ku.tt ttVarC;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            if (z2 && com.byazt.omf.gt.tt().qe()) {
                float f3 = com.byazt.omf.gt.getContext().getResources().getDisplayMetrics().density;
                float f4 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put("width", pf.tt(f4, pf.c(f3, f)));
                jSONObject2.put("height", pf.tt(f4, pf.c(f3, f2)));
            } else {
                jSONObject2.put("width", f);
                jSONObject2.put("height", f2);
            }
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", tt(icVar));
            if (pu.a(icVar) != null) {
                strN = pu.a(icVar).n();
                strA = pu.a(icVar).a();
            } else {
                strN = null;
                strA = null;
            }
            if (TextUtils.isEmpty(strN)) {
                strN = (pu.a(icVar) == null || (ttVarC = com.byazt.six.tt.c(pu.a(icVar).tt())) == null) ? null : ttVarC.n();
            }
            jSONObject.put("template_Plugin", strN);
            jSONObject.put("diff_template_Plugin", strA);
            jSONObject.put("dynamic_configs", icVar.m());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("keys");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (jSONObject.has(strOptString)) {
                        jSONObject3.put(strOptString, jSONObject.opt(strOptString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void c(ic icVar, JSONObject jSONObject) {
        if (nb.sl(icVar) == 7 && to.c(icVar)) {
            icVar.jc().c(jSONObject);
        }
    }
}
