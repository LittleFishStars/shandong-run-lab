package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bu;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b implements f {
    private static final String COOKIE_KEY = "cookie";
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    public b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader(COOKIE_KEY, com.kwad.sdk.core.response.helper.f.Nz().NA());
            com.kwad.sdk.core.a.d.h(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.Mi());
            addHeader("SystemUa", p.Mh());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    public static String mergeCookies(String... strArr) {
        String strTrim;
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : strArr) {
            if (str != null && !str.trim().isEmpty()) {
                for (String str2 : str.split(com.alipay.sdk.m.y.l.b)) {
                    String strTrim2 = str2.trim();
                    if (!strTrim2.isEmpty()) {
                        int iIndexOf = strTrim2.indexOf(61);
                        if (iIndexOf > 0) {
                            String strTrim3 = strTrim2.substring(0, iIndexOf).trim();
                            strTrim = strTrim2.substring(iIndexOf + 1).trim();
                            strTrim2 = strTrim3;
                        } else {
                            strTrim = "";
                        }
                        if (!strTrim2.isEmpty()) {
                            linkedHashMap.put(strTrim2, strTrim);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append((String) entry.getKey());
            if (!((String) entry.getValue()).isEmpty()) {
                sb.append("=");
                sb.append((String) entry.getValue());
            }
        }
        return sb.toString();
    }

    public final void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str.equalsIgnoreCase(COOKIE_KEY) ? COOKIE_KEY : str;
        if (str.equalsIgnoreCase(COOKIE_KEY) && this.mHeader.containsKey(COOKIE_KEY)) {
            this.mHeader.put(COOKIE_KEY, mergeCookies(this.mHeader.get(COOKIE_KEY), str2));
        } else {
            this.mHeader.put(str3, str2);
        }
    }

    public abstract void buildBaseBody();

    public abstract void buildBaseHeader();

    public boolean enableCrashReport() {
        return true;
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.g.encryptDisable();
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        ac.putValue(jSONObject, "version", fVar.getSDKVersion());
        if (TextUtils.isEmpty(bu.getAppId())) {
            ac.putValue(jSONObject, "appId", fVar.getAppId());
        } else {
            ac.putValue(jSONObject, "appId", bu.getAppId());
        }
        ac.putValue(jSONObject, "message", com.kwad.sdk.core.a.d.ax(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    public String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    public String getRequestHost() {
        return com.kwad.sdk.i.EI();
    }

    @Override // com.kwad.sdk.core.network.f
    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    public void onCreate() {
    }

    public void putBody(String str, String str2) {
        ac.putValue(this.mBodyParams, str, str2);
    }

    public void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public void putBody(String str, double d) {
        ac.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, int i) {
        ac.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, float f) {
        ac.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, byte b) {
        ac.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, long j) {
        ac.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, boolean z) {
        ac.putValue(this.mBodyParams, str, z);
    }

    public void putBody(String str, JSONObject jSONObject) {
        ac.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        ac.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        ac.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        ac.putValue(this.mBodyParams, str, list);
    }
}
