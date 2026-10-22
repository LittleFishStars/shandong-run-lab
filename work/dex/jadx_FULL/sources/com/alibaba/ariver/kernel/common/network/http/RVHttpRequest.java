package com.alibaba.ariver.kernel.common.network.http;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVHttpRequest {
    public static final String APP_ID = "appId";
    public static final String PLUGIN_ID = "pluginId";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24263a;
    private String b;
    private Map<String, String> c;
    private byte[] d;
    private long e;
    private boolean f;
    private boolean g;
    private boolean h;
    private Map<String, String> i;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RVHttpRequest f24264a = new RVHttpRequest();

        public RVHttpRequest build() {
            return this.f24264a;
        }

        public Builder headers(@NonNull Map<String, String> map) {
            this.f24264a.c = map;
            return this;
        }

        public Builder method(String str) {
            this.f24264a.b = str;
            return this;
        }

        public Builder requestData(byte[] bArr) {
            this.f24264a.d = bArr;
            return this;
        }

        public Builder setPackageRequest(boolean z) {
            this.f24264a.g = z;
            return this;
        }

        public Builder timeout(long j) {
            this.f24264a.e = j;
            return this;
        }

        public Builder url(String str) {
            this.f24264a.f24263a = str;
            return this;
        }

        public Builder useCache(boolean z) {
            this.f24264a.h = z;
            return this;
        }

        public Builder useSpdy(boolean z) {
            this.f24264a.f = z;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void addExtParams(String str, String str2) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.i.put(str, str2);
    }

    public String getExtParams(String str) {
        Map<String, String> map = this.i;
        return (map == null || !map.containsKey(str)) ? "" : this.i.get(str);
    }

    public Map<String, String> getHeaders() {
        return this.c;
    }

    public String getMethod() {
        return TextUtils.isEmpty(this.b) ? "GET" : this.b;
    }

    public byte[] getRequestData() {
        return this.d;
    }

    public long getTimeout() {
        return this.e;
    }

    public String getUrl() {
        return this.f24263a;
    }

    public boolean isPackageRequest() {
        return this.g;
    }

    public boolean isUseCache() {
        return this.h;
    }

    public boolean isUseSpdy() {
        return this.f;
    }

    private RVHttpRequest() {
        this.i = new HashMap();
    }
}
