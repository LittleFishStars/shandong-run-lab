package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bz;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends com.kwad.sdk.core.response.a.a {
    public String aJS;
    public String aJT;
    public JSONObject aJU;
    public double aJV;
    public String maxVersion;
    public String minVersion;
    public String tag;
    public String type;
    public int category = -1;
    public double aJW = AudioStats.AUDIO_AMPLITUDE_NONE;
    public int aJX = 1;

    private boolean dq(String str) {
        if (str == null) {
            return false;
        }
        int i = this.category;
        if (i == 0) {
            return str.equals(ILoggerReporter.Category.APM_LOG);
        }
        if (i != 1) {
            return false;
        }
        return str.equals(ILoggerReporter.Category.ERROR_LOG);
    }

    private boolean f(d dVar) {
        if (dVar == null || dVar.msg == null) {
            return false;
        }
        JSONObject jSONObject = this.aJU;
        if (jSONObject == null) {
            return true;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = dVar.msg.opt(next);
            if (objOpt == null || !objOpt.equals(this.aJU.opt(next))) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(@Nullable d dVar) {
        if (dVar == null) {
            return false;
        }
        try {
            if (!dq(dVar.category)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch category not match " + dVar.category + " to " + this.category);
                return false;
            }
            String str = this.minVersion;
            if (str != null && !str.isEmpty() && !bz.aE(BuildConfig.VERSION_NAME, this.minVersion)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch minVersion not match 5.4.10.2 to " + this.minVersion);
                return false;
            }
            String str2 = this.maxVersion;
            if (str2 != null && !str2.isEmpty() && bz.aE(BuildConfig.VERSION_NAME, this.maxVersion)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch maxVersion not match 5.4.10.2 to " + this.maxVersion);
                return false;
            }
            String str3 = this.tag;
            if (str3 != null && !str3.isEmpty() && !this.tag.equals(dVar.tag)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch tag not match " + dVar.tag + " to " + this.tag);
                return false;
            }
            String str4 = this.aJS;
            if (str4 != null && !str4.isEmpty() && !this.aJS.equals(dVar.aJP.value)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch biz not match " + dVar.aJP.value + " to " + this.aJS);
                return false;
            }
            String str5 = this.aJT;
            if (str5 != null && !str5.isEmpty() && !this.aJT.equals(dVar.aJQ.value)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch subBiz not match " + dVar.aJQ.value + " to " + this.aJT);
                return false;
            }
            String str6 = this.type;
            if (str6 != null && !str6.isEmpty()) {
                com.kwai.adclient.kscommerciallogger.model.d dVar2 = dVar.aJR;
                if (dVar2 == null) {
                    return false;
                }
                if (!this.type.equals(dVar2.getValue())) {
                    com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatch type not match " + dVar.aJR.getValue() + " to " + this.type);
                    return false;
                }
            }
            if (f(dVar)) {
                return true;
            }
            com.kwad.sdk.core.d.c.d("KCLRefineReport", "isMatchForMsg not match " + dVar.msg + " to " + this.aJU);
            return false;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return false;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.category = jSONObject.optInt("category", 0);
        this.minVersion = jSONObject.optString("min_version");
        this.maxVersion = jSONObject.optString("max_version");
        this.tag = jSONObject.optString("tag");
        this.aJS = jSONObject.optString(com.alipay.sdk.m.m.b.l);
        this.aJT = jSONObject.optString("subBiz");
        this.type = jSONObject.optString("type");
        this.aJU = jSONObject.optJSONObject("custom_dimension");
        this.aJV = jSONObject.optDouble("ratio", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.aJW = jSONObject.optDouble("convert", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.aJX = jSONObject.optInt("device_mode", 1);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "category", this.category);
        ac.putValue(jSONObject, "min_version", this.minVersion);
        ac.putValue(jSONObject, "max_version", this.maxVersion);
        ac.putValue(jSONObject, "tag", this.tag);
        ac.putValue(jSONObject, com.alipay.sdk.m.m.b.l, this.aJS);
        ac.putValue(jSONObject, "subBiz", this.aJT);
        ac.putValue(jSONObject, "type", this.type);
        ac.putValue(jSONObject, "custom_dimension", this.aJU);
        ac.putValue(jSONObject, "ratio", this.aJV);
        ac.putValue(jSONObject, "convert", this.aJW);
        ac.putValue(jSONObject, "device_mode", this.aJX);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public final String toString() {
        return "KCEventRatioRule{category=" + this.category + ", minVersion='" + this.minVersion + "', maxVersion='" + this.maxVersion + "', tag='" + this.tag + "', biz='" + this.aJS + "', subBiz='" + this.aJT + "', type='" + this.type + "', customDimension=" + this.aJU + ", ratio=" + this.aJV + ", convert=" + this.aJW + ", device_mode=" + this.aJX + '}';
    }
}
