package cj.mobile.wm;

import com.kc.openset.constant.DeviceIdType;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.zj.adlib.ze1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class md {

    public class dexa implements n9.dexa {
        public final /* synthetic */ kd dexa;

        public dexa(kd kdVar) {
            this.dexa = kdVar;
        }

        @Override // cj.mobile.wm.n9.dexa
        public void a(int i, String str) {
            f1.dexb("RewardValidLoader", "onFailed: errorCode : " + i + " , msg : " + str);
            kd kdVar = this.dexa;
            if (kdVar != null) {
                kdVar.a(i, str);
            }
        }

        @Override // cj.mobile.wm.n9.dexa
        public void a(String str) {
            JSONObject jSONObjectOptJSONObject;
            f1.dexa("RewardValidLoader", "onSuccess: " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("data") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("is_valid");
                    kd kdVar = this.dexa;
                    if (kdVar != null) {
                        kdVar.a(Boolean.valueOf(zOptBoolean));
                        return;
                    }
                    return;
                }
            } catch (JSONException unused) {
            }
            kd kdVar2 = this.dexa;
            if (kdVar2 != null) {
                kdVar2.a(-1, "response is invalid");
            }
        }
    }

    public void dexa(com.wangmai.insightvision.openadsdk.d.e eVar, kd<Boolean> kdVar) {
        dexx systemInfo = InsightProxy.getInstance().getSystemInfo();
        eVar.a("device", Integer.valueOf(de.dexc(InsightProxy.getApplication().getApplicationContext())));
        eVar.a("os", "android");
        eVar.a(DeviceIdType.OAID, systemInfo.dexh());
        eVar.a("brand", systemInfo.dexb());
        eVar.a(ze1.k, systemInfo.dexg());
        String str = InsightProxy.getInstance().isDebugMode() ? "https://pre-ssp.iytcdn.com/reward/valid" : "https://ssp.iytcdn.com/reward/valid";
        String strA = eVar.a();
        f1.dexa("RewardValidLoader", "validRewardVideo jsonData : " + strA);
        n9.dexa().dexa("POST", str, strA, new dexa(kdVar));
    }
}
