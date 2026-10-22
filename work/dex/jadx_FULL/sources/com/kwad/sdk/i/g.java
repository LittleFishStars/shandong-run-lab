package com.kwad.sdk.i;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g {
    private String Nt;
    private Map<String, String> aAS;
    private JSONObject aLM;
    private String aQZ;
    private String aRa;
    private String aWY;
    private String aWc;
    private String appId;
    private JSONObject biw;
    private boolean bix;
    private String sdkVersion;

    private g() {
    }

    public static g RL() {
        return new g();
    }

    public final JSONObject RM() {
        return this.biw;
    }

    public final boolean RN() {
        return this.bix;
    }

    public final String RO() {
        return this.aWc;
    }

    public final JSONObject RP() {
        return this.aLM;
    }

    public final g cd(boolean z) {
        this.bix = z;
        return this;
    }

    public final g gP(String str) {
        this.appId = str;
        return this;
    }

    public final g gQ(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g gR(String str) {
        this.aRa = str;
        return this;
    }

    public final g gS(String str) {
        this.Nt = str;
        return this;
    }

    public final g gT(String str) {
        this.aWY = str;
        return this;
    }

    public final g gU(String str) {
        this.aQZ = str;
        return this;
    }

    public final g gV(String str) {
        this.aWc = str;
        return this;
    }

    public final String getAndroidId() {
        return this.aWY;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.Nt;
    }

    public final String getImei() {
        return this.aQZ;
    }

    public final String getOaid() {
        return this.aRa;
    }

    public final Map<String, String> getRequestHeader() {
        return this.aAS;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final g i(Map<String, String> map) {
        this.aAS = map;
        return this;
    }

    public final g n(JSONObject jSONObject) {
        this.biw = jSONObject;
        return this;
    }

    public final g o(JSONObject jSONObject) {
        this.aLM = jSONObject;
        return this;
    }
}
