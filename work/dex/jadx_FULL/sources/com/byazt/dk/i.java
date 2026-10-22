package com.byazt.dk;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.byazt.ete.ic;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 42})
public class i {

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 64})
    public static class c extends com.byazt.bwm.sp {
        public x c;
        public com.byazt.qt.tt tt;
        public boolean uj;
        public ic ve;

        private c(x xVar, boolean z) {
            JSONObject jSONObjectUj;
            ic icVar;
            super("LogTask");
            this.c = xVar;
            this.uj = z;
            if (xVar == null || xVar.uj() == null || (jSONObjectUj = this.c.uj()) == null) {
                return;
            }
            String strOptString = jSONObjectUj.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("open_ad_sdk_download_extra");
                com.byazt.qt.tt ttVarC = com.byazt.qt.tt.c(jSONObjectOptJSONObject);
                this.tt = ttVarC;
                if (ttVarC == null) {
                    return;
                }
                ttVarC.c(xVar.tt());
                this.tt.tt(this.c.ve());
                this.ve = this.tt.c;
                JSONObject jSONObjectN = xVar.n();
                if (jSONObjectN == null || (icVar = this.ve) == null || c(jSONObjectN, icVar.q_())) {
                    return;
                }
                this.ve.gr(jSONObjectN.toString());
                this.ve.gu(String.valueOf(jSONObjectN.optLong("creative_id")));
                JSONObject jSONObjectYg = this.ve.yg();
                jSONObjectOptJSONObject.put("material_meta", jSONObjectYg);
                com.byazt.qt.tt ttVarC2 = com.byazt.qt.tt.c(jSONObjectOptJSONObject);
                if (ttVarC2 == null) {
                    return;
                }
                this.tt = ttVarC2;
                ttVarC2.tt(xVar.ve());
                this.c = x.c().c(xVar.tt()).tt(xVar.ve()).c(jSONObjectYg).tt(jSONObjectUj);
                this.ve = this.tt.c;
            } catch (Exception unused) {
            }
        }

        public static c c(x xVar, boolean z) {
            return new c(xVar, z);
        }

        private Context getContext() {
            return gt.getContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                x xVar = this.c;
                if (xVar == null) {
                    return;
                }
                String strTt = xVar.tt();
                com.byazt.nr.m.c("pl_LibEventLogger", "label: " + this.c.ve() + " tag: " + strTt);
                com.byazt.qt.tt ttVar = this.tt;
                if (ttVar != null && !TextUtils.isEmpty(ttVar.tt)) {
                    strTt = this.tt.tt;
                }
                if (!com.byazt.qt.ve.c(strTt, this.c.ve(), this.ve, 0) && this.tt != null && this.ve != null && !TextUtils.isEmpty(this.c.tt()) && !TextUtils.isEmpty(this.c.ve())) {
                    JSONObject jSONObjectC = i.c(this.c.uj());
                    String str = this.tt.tt;
                    if (!c(this.c.tt()) || "click".equals(this.c.ve())) {
                        return;
                    }
                    jSONObjectC.remove("open_ad_sdk_download_extra");
                    jSONObjectC.putOpt("obm_convert", com.byazt.ete.gt.ve(this.ve));
                    com.byazt.ddx.uj.tt(this.ve, str, this.c.ve(), jSONObjectC);
                }
            } catch (Throwable unused) {
            }
        }

        private boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null && jSONObject2 != null) {
                long jOptLong = jSONObject.optLong(MediationConstant.EXTRA_ADID);
                long jOptLong2 = jSONObject2.optLong(MediationConstant.EXTRA_ADID);
                String strOptString = jSONObject.optString("req_id");
                String strOptString2 = jSONObject2.optString("req_id");
                long jOptLong3 = jSONObject.optLong("creative_id");
                long jOptLong4 = jSONObject2.optLong("creative_id");
                String strOptString3 = jSONObject.optString("origin_req_id");
                String strOptString4 = jSONObject2.optString("origin_req_id");
                if (jOptLong != 0 && jOptLong == jOptLong2 && jOptLong3 != 0 && jOptLong3 == jOptLong4) {
                    return (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString4)) ? TextUtils.equals(strOptString, strOptString2) : TextUtils.equals(strOptString3, strOptString4);
                }
            }
            return false;
        }

        private boolean c(String str) {
            return this.uj || i.ve(str);
        }
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            return new JSONObject(strOptString);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.byazt.dyf.tt.AD_TAG_FEED.equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || com.byazt.dyf.tt.AD_TAG_BANNER.equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || com.byazt.dyf.tt.AD_TAG_EXPRESS_BANNER.equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("open_ad_sdk_download_extra");
    }
}
