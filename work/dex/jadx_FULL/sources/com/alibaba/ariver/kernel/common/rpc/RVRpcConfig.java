package com.alibaba.ariver.kernel.common.rpc;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVRpcConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f24266a;
    private String b;
    private Map<String, String> c;
    private Map<String, String> d;
    private Boolean e;
    private String f;
    private String g;
    private String h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;
    private Boolean n;
    private Boolean o;
    private Boolean p;
    private Boolean q;
    private Boolean r;
    private Boolean s;
    private Boolean t;
    private Boolean u;
    private String v;
    private Boolean w;
    private String x;
    private Boolean y;
    private String z;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f24267a;
        private String b;
        private Map<String, String> c;
        private Map<String, String> d;
        private Boolean e;
        private String f;
        private String g;
        private String h;
        private Boolean i;
        private Boolean j;
        private Boolean k;
        private Boolean l;
        private Boolean m;
        private Boolean n;
        private Boolean o;
        private Boolean p;
        private Boolean q;
        private Boolean r;
        private Boolean s;
        private Boolean t;
        private Boolean u;
        private String v;
        private Boolean w;
        private Boolean x;
        private String y;
        private String z;

        public Builder allowBgLogin(Boolean bool) {
            this.n = bool;
            return this;
        }

        public Builder allowNonNet(Boolean bool) {
            this.o = bool;
            return this;
        }

        public Builder allowRetry(Boolean bool) {
            this.k = bool;
            return this;
        }

        public Builder appId(String str) {
            this.g = str;
            return this;
        }

        public Builder appKey(String str) {
            this.f = str;
            return this;
        }

        public Builder bgRpc(Boolean bool) {
            this.j = bool;
            return this;
        }

        public Builder bizLog(String str) {
            this.y = str;
            return this;
        }

        public RVRpcConfig build() {
            return new RVRpcConfig(this);
        }

        public Builder compress(Boolean bool) {
            this.e = bool;
            return this;
        }

        public Builder disableEncrypt(Boolean bool) {
            this.r = bool;
            return this;
        }

        public Builder enableEncrypt(Boolean bool) {
            this.s = bool;
            return this;
        }

        public Builder extParasm(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public Builder getMethod(Boolean bool) {
            this.q = bool;
            return this;
        }

        public Builder gwUrl(String str) {
            this.b = str;
            return this;
        }

        public Builder needSignature(Boolean bool) {
            this.w = bool;
            return this;
        }

        public Builder region(String str) {
            this.z = str;
            return this;
        }

        public Builder requestHeader(Map<String, String> map) {
            this.c = map;
            return this;
        }

        public Builder resetCookie(Boolean bool) {
            this.i = bool;
            return this;
        }

        public Builder rpcLoggerLevel(Boolean bool) {
            this.t = bool;
            return this;
        }

        public Builder rpcV2(Boolean bool) {
            this.m = bool;
            return this;
        }

        public Builder shortLinkIPList(String str) {
            this.v = str;
            return this;
        }

        public Builder shortLinkOnly(Boolean bool) {
            this.u = bool;
            return this;
        }

        public Builder switchUserLoginRpc(Boolean bool) {
            this.p = bool;
            return this;
        }

        public Builder timeout(Long l) {
            this.f24267a = l;
            return this;
        }

        public Builder tinyAppId(String str) {
            this.h = str;
            return this;
        }

        public Builder urgent(Boolean bool) {
            this.l = bool;
            return this;
        }

        public Builder useMultiplexLink(Boolean bool) {
            this.x = bool;
            return this;
        }
    }

    public String getAppId() {
        return this.g;
    }

    public String getAppKey() {
        return this.f;
    }

    public String getBizLog() {
        return this.z;
    }

    public Map<String, String> getExtParams() {
        return this.d;
    }

    public String getGwUrl() {
        return this.b;
    }

    public String getRegion() {
        return this.x;
    }

    public Map<String, String> getRequestHeader() {
        return this.c;
    }

    public String getShortLinkIPList() {
        return this.v;
    }

    public Long getTimeout() {
        return this.f24266a;
    }

    public String getTinyAppId() {
        return this.h;
    }

    public Boolean isAllowBgLogin() {
        return this.n;
    }

    public Boolean isAllowNonNet() {
        return this.o;
    }

    public Boolean isAllowRetry() {
        return this.k;
    }

    public Boolean isBgRpc() {
        return this.j;
    }

    public Boolean isCompress() {
        return this.e;
    }

    public Boolean isDisableEncrypt() {
        return this.r;
    }

    public Boolean isEnableEncrypt() {
        return this.s;
    }

    public Boolean isGetMethod() {
        return this.q;
    }

    public Boolean isNeedSignature() {
        return this.w;
    }

    public Boolean isResetCookie() {
        return this.i;
    }

    public Boolean isRpcLoggerLevel() {
        return this.t;
    }

    public Boolean isRpcV2() {
        return this.m;
    }

    public Boolean isShortLinkOnly() {
        return this.u;
    }

    public Boolean isSwitchUserLoginRpc() {
        return this.p;
    }

    public Boolean isUrgent() {
        return this.l;
    }

    public Boolean isUseMultiplexLink() {
        return this.y;
    }

    private RVRpcConfig(Builder builder) {
        this.f24266a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.f24266a = builder.f24267a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
        this.w = builder.w;
        this.y = builder.x;
        this.z = builder.y;
        this.x = builder.z;
    }
}
