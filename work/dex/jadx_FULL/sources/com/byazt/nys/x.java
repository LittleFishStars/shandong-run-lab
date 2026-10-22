package com.byazt.nys;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.kc.openset.constant.DeviceIdType;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zj.adlib.xh9;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 71})
public class x implements Runnable {
    public final Context c;
    public String tt;
    public final Map<String, String> uj = a.tt();
    public String ve;

    @com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 62})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28860a;
        public String c;
        public boolean da;
        public String i;
        public String n;
        public int sp;
        public int tt;
        public String uj;
        public String ve;
        public int x;

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.c).put("version_code", this.tt).put(UserTrackConstant.SIGN, this.uj).put("max_version", this.sp).put("min_version", this.f28860a).put("is_revert", this.da).put(TKDownloadReason.KSAD_TK_MD5, this.n).put("plugin_file", this.i).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }

    public x(Context context) {
        this.c = context;
    }

    private JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conn_type", com.byazt.zyp.n.tt(this.c));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", "7.6.1.1");
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            jSONObject.put(AlibcCommonConstant.APP_VERSION, uj());
            jSONObject.put("package_name", this.ve);
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String str = this.uj.get("appid");
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("app_id", str);
            jSONObject.put("req_sign", com.byazt.zyp.uj.c(str != null ? str.concat(String.valueOf(jCurrentTimeMillis)).concat("7.6.1.1") : ""));
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, "main");
            jSONObject.put(DeviceIdType.IMEI, this.uj.get(DeviceIdType.IMEI));
            jSONObject.put("source", 0);
            jSONObject.put("device_abi", com.byazt.th.tt.c());
            jSONObject.put("pl_update_type", com.byazt.zyp.ve.tt() ? 2 : 1);
            jSONObject.put("plugins", ve());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String uj() {
        Context context;
        if (TextUtils.isEmpty(this.tt) && (context = this.c) != null) {
            try {
                this.ve = context.getPackageName();
                this.tt = this.c.getPackageManager().getPackageInfo(this.ve, 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return this.tt;
    }

    private JSONObject ve() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("app_id", this.uj.get("appid"));
        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
        jSONObject2.put("sdk_version", "7.6.1.1");
        jSONObject2.put("plugin_update_network", "2");
        jSONObject.put("com.byted.pangle", jSONObject2);
        return jSONObject;
    }

    public void c() throws Throwable {
        if (com.byazt.zyp.n.c(this.c)) {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        n.c("plugin_download", "start run");
        String strC = com.byazt.uc.ve.c().c(true, "https://api-access.pangolin-sdk-toutiao.com/api/ad/union/sdk/settings/plugins", com.byazt.zyp.tt.c(tt()).toString().getBytes());
        if (strC == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strC);
            if (jSONObject.optInt("cypher") == 3) {
                String strTt = com.byazt.zyp.tt.tt(jSONObject.optString("message"));
                if (TextUtils.isEmpty(strTt)) {
                    return;
                }
                ve.c(this.c).c(c(new JSONObject(strTt).optJSONArray("plugins")));
            }
        } catch (JSONException e) {
            n.c("plugin_download", "failed:".concat(String.valueOf(e)));
        }
    }

    private List<c> c(JSONArray jSONArray) {
        n.c("plugin_download", "parse start");
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                c cVar = new c();
                cVar.c = jSONObjectOptJSONObject.optString("package_name");
                cVar.tt = jSONObjectOptJSONObject.optInt("version_code");
                cVar.ve = jSONObjectOptJSONObject.optString("download_url");
                cVar.uj = jSONObjectOptJSONObject.optString(UserTrackConstant.SIGN);
                cVar.f28860a = c(jSONObjectOptJSONObject.optString("min_version"));
                cVar.sp = c(jSONObjectOptJSONObject.optString("max_version"));
                cVar.x = jSONObjectOptJSONObject.optInt("plugin_update_network");
                arrayList.add(cVar);
                n.c("plugin_download", "parse " + i + " : " + cVar);
            }
        }
        return arrayList;
    }

    private int c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str.replace(Consts.DOT, ""));
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }
}
