package com.kwad.sdk.liteapi.report;

import androidx.annotation.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LiteApiReportResponse {
    String errorMsg;
    long result;

    public boolean isLegal() {
        return this.result == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.result = jSONObject.optLong("result");
        this.errorMsg = jSONObject.optString("errorMsg");
    }

    public String toString() {
        return "LiteApiReportResponse{result=" + this.result + ", errorMsg='" + this.errorMsg + "'}";
    }
}
