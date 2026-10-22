package com.kwad.sdk.api.loader;

import com.baidu.mapapi.SDKInitializer;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class l {
    public static int aIm;

    public static class a {
        private int aIn;
        private int aIo;
        private String aIp;
        private String aIq;
        private long aIr;
        private int aIs;
        private String aIt;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a av(long j) {
            this.aIr = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a db(String str) {
            this.aIp = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dc(String str) {
            this.aIq = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dd(String str) {
            this.aIt = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dp(int i) {
            this.aIn = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dq(int i) {
            this.aIo = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a dr(int i) {
            this.aIs = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.aIn));
                jSONObject.putOpt("update_count", Integer.valueOf(this.aIo));
                jSONObject.putOpt("dynamic_version", this.aIp);
                jSONObject.putOpt("download_url", this.aIq);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.aIr));
                jSONObject.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(this.aIs));
                jSONObject.putOpt("error_msg", this.aIt);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.aIn + ", update_count=" + this.aIo + ", dynamic_version='" + this.aIp + "', download_url='" + this.aIq + "', duration_ms=" + this.aIr + ", error_code=" + this.aIs + ", error_msg='" + this.aIt + "'}";
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void a(com.kwad.sdk.api.loader.a.C1266a c1266a) {
        aIm++;
        a(1, c1266a, 0L, 0, "");
    }

    public static void b(com.kwad.sdk.api.loader.a.C1266a c1266a) {
        a(5, c1266a, 0L, 0, "");
    }

    public static void b(com.kwad.sdk.api.loader.a.C1266a c1266a, long j) {
        a(6, c1266a, j, 0, "");
    }

    public static void a(com.kwad.sdk.api.loader.a.C1266a c1266a, long j) {
        a(2, c1266a, j, 0, "");
    }

    public static void b(com.kwad.sdk.api.loader.a.C1266a c1266a, int i, String str) {
        a(7, c1266a, 0L, i, str);
    }

    public static void a(com.kwad.sdk.api.loader.a.C1266a c1266a, long j, String str) {
        a(3, c1266a, j, 0, str);
    }

    public static void a(com.kwad.sdk.api.loader.a.C1266a c1266a, int i, String str) {
        a(4, c1266a, 0L, i, str);
    }

    private static void a(int i, com.kwad.sdk.api.loader.a.C1266a c1266a, long j, int i2, String str) {
        if (c1266a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).dp(i).dq(aIm).db(c1266a.sdkVersion).dc(c1266a.aHD).av(j).dr(i2).dd(str).toJson();
            Objects.toString(json);
            com.kwad.sdk.api.c.g("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
