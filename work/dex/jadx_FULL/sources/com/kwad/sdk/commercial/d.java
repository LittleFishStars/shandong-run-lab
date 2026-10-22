package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    public double aJM = 0.01d;
    public double aJN = 1.0d;
    public double aJO = 0.001d;
    public BusinessType aJP = BusinessType.OTHER;
    public SubBusinessType aJQ = SubBusinessType.OTHER;
    public com.kwai.adclient.kscommerciallogger.model.d aJR;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;

    private d() {
    }

    public static d In() {
        return new d();
    }

    public final d A(com.kwad.sdk.commercial.c.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    public final d Q(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final d a(SubBusinessType subBusinessType) {
        this.aJQ = subBusinessType;
        return this;
    }

    public final d b(BusinessType businessType) {
        this.aJP = businessType;
        return this;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final d m1062do(String str) {
        this.category = str;
        return this;
    }

    public final d dp(String str) {
        this.tag = str;
        return this;
    }

    public final d g(double d) {
        this.aJM = d;
        return this;
    }

    public final d h(double d) {
        this.aJN = d;
        return this;
    }

    public final d i(double d) {
        this.aJO = 0.001d;
        return this;
    }

    @NonNull
    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.aJP + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }

    public final d a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
        this.aJR = dVar;
        return this;
    }

    @Deprecated
    public final d i(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }
}
