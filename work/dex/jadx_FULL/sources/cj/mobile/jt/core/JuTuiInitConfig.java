package cj.mobile.jt.core;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class JuTuiInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22458a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final JuTuiPrivacyController e;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22459a;
        public boolean b;
        public String c;
        public boolean d;
        public JuTuiPrivacyController e;

        public JuTuiInitConfig build() {
        }

        public Builder setAppId(String str) {
            this.f22459a = str;
            return this;
        }

        public Builder setEnable(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setNeedPersonalRecommend(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setPrivateController(JuTuiPrivacyController juTuiPrivacyController) {
            this.e = juTuiPrivacyController;
            return this;
        }

        public Builder setToken(String str) {
            this.c = str;
            return this;
        }
    }

    public JuTuiInitConfig(Builder builder) {
    }

    public String getAppId() {
        return this.f22458a;
    }

    public JuTuiPrivacyController getPrivateController() {
        return this.e;
    }

    public String getToken() {
        return this.b;
    }

    public boolean isEnable() {
        return this.c;
    }

    public boolean isNeedPersonalRecommend() {
        return this.d;
    }
}
