package cj.mobile.wm;

import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ld {

    public class dexa implements n9.dexa {
        public final /* synthetic */ kd dexa;

        public dexa(kd kdVar) {
            this.dexa = kdVar;
        }

        @Override // cj.mobile.wm.n9.dexa
        public void a(int i, String str) {
            f1.dexb("RewardTokenLoader", "onFailed: errorCode : " + i + " , msg : " + str);
            kd kdVar = this.dexa;
            if (kdVar != null) {
                kdVar.a(i, str);
            }
        }

        @Override // cj.mobile.wm.n9.dexa
        public void a(String str) {
            JSONObject jSONObject;
            JSONObject jSONObjectOptJSONObject;
            f1.dexa("RewardTokenLoader", "onSuccess: " + str);
            String strOptString = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null && jSONObjectOptJSONObject.has("token")) {
                strOptString = jSONObjectOptJSONObject.optString("token");
            }
            kd kdVar = this.dexa;
            if (kdVar != null) {
                kdVar.a(strOptString);
            }
        }
    }

    public void dexa(com.wangmai.insightvision.openadsdk.d.e eVar, kd<String> kdVar) {
        n9.dexa().dexa("POST", InsightProxy.getInstance().isDebugMode() ? "https://pre-ssp.iytcdn.com/reward/token" : "https://ssp.iytcdn.com/reward/token", eVar.a(), new dexa(kdVar));
    }
}
