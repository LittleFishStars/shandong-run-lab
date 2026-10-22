package com.ltmb.ltadsdk.api;

import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class SYAdLoadParams {
    public static int AD_ORI_AUTO = 0;
    public static int AD_ORI_LANDSCAPE = 2;
    public static int AD_ORI_PORTRAIT = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40327a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public HashMap<String, Object> f;
    public int g;
    public boolean h;
    public String i;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40328a;
        public Boolean b;
        public Boolean c;
        public int d;
        public int e;
        public HashMap<String, Object> f;
        public int g;
        public boolean h;
        public String i;

        public Builder() {
            Boolean bool = Boolean.TRUE;
            this.b = bool;
            this.c = bool;
            this.d = 1;
            this.e = SYAdLoadParams.AD_ORI_AUTO;
            this.g = -1;
            this.h = false;
        }

        public SYAdLoadParams build() {
            return new SYAdLoadParams(this);
        }

        public Builder putExt(String str, Object obj) {
            if (this.f == null) {
                this.f = new HashMap<>();
            }
            this.f.put(str, obj);
            return this;
        }

        public Builder setAdCount(int i) {
            this.d = i;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.b = Boolean.valueOf(z);
            return this;
        }

        public Builder setOrientation(int i) {
            this.e = i;
            return this;
        }

        public Builder setPreload(boolean z) {
            this.h = z;
            return this;
        }

        public Builder setSlotId(String str) {
            this.f40328a = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.c = Boolean.valueOf(z);
            return this;
        }

        public Builder setUserId(String str) {
            this.i = str;
            return this;
        }

        public Builder setVideoMute(boolean z) {
            this.g = z ? 1 : 0;
            return this;
        }
    }

    public SYAdLoadParams(Builder builder) {
        this.f40327a = builder.f40328a;
        this.b = builder.b.booleanValue();
        this.c = builder.c.booleanValue();
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    public int getAdCount() {
        return this.d;
    }

    public int getExpressViewAcceptedHeight() {
        return 0;
    }

    public int getExpressViewAcceptedWidth() {
        return 0;
    }

    public HashMap<String, Object> getExt() {
        return this.f;
    }

    public int getOrientation() {
        return this.e;
    }

    public String getSlotId() {
        return this.f40327a;
    }

    public String getUserId() {
        return this.i;
    }

    public int getVideoMute() {
        return this.g;
    }

    public boolean isAutoPlay() {
        return this.b;
    }

    public boolean isPreload() {
        return this.h;
    }

    public boolean isSupportDeepLink() {
        return this.c;
    }
}
