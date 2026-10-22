package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.utils.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject aWN;
    private String aWO;
    private String appId;
    private String name;
    private String packageName;
    private String version;
    private int versionCode;

    public static JSONObject Np() {
        if (!m(aWN)) {
            aWN = Nq().toJson();
        }
        return aWN;
    }

    public static a Nq() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.getSDKConfig().appId;
            aVar.name = ServiceProvider.getSDKConfig().appName;
            aVar.packageName = ServiceProvider.Ud().getPackageName();
            aVar.version = n.cZ(ServiceProvider.Ud());
            aVar.versionCode = n.db(ServiceProvider.Ud());
            aVar.aWO = com.kwad.sdk.utils.g.cN(ServiceProvider.Ud());
            if (!TextUtils.isEmpty(bu.getAppId())) {
                aVar.appId = bu.getAppId();
            }
            if (!TextUtils.isEmpty(bu.getPackageName())) {
                aVar.packageName = bu.getPackageName();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aVar;
    }

    private static boolean m(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("appId");
        String strOptString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString) && strOptString.equals(ServiceProvider.getSDKConfig().appId) && strOptString2.equals(ServiceProvider.getSDKConfig().appName);
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "appId", this.appId);
        ac.putValue(jSONObject, "name", this.name);
        ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, this.packageName);
        ac.putValue(jSONObject, "version", this.version);
        ac.putValue(jSONObject, "versionCode", this.versionCode);
        ac.putValue(jSONObject, "sha1", this.aWO);
        return jSONObject;
    }
}
