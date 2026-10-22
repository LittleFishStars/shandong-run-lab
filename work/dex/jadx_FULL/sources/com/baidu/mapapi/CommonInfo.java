package com.baidu.mapapi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CommonInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26477a;
    private String b;
    private String c;
    private String d;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26478a = "";
        private String b = "";
        private String c = "";
        private String d = "";

        public Builder androidId(String str) {
            this.b = str;
            return this;
        }

        public CommonInfo build() {
            return new CommonInfo(this.b, this.f26478a, this.c, this.d);
        }

        public Builder channel(String str) {
            this.c = str;
            return this;
        }

        public Builder oaid(String str) {
            this.f26478a = str;
            return this;
        }

        public Builder shareDeviceId(String str) {
            this.d = str;
            return this;
        }
    }

    public String getAndroidID() {
        return this.b;
    }

    public String getChannel() {
        return this.c;
    }

    public String getOAID() {
        return this.f26477a;
    }

    public String getShareDeviceId() {
        return this.d;
    }

    public void updateShareDeviceId(String str) {
        this.d = str;
    }

    private CommonInfo(String str, String str2, String str3, String str4) {
        this.b = str;
        this.f26477a = str2;
        this.c = str3;
        this.d = str4;
    }
}
