package cj.mobile.jt.core.modle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class AdError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22494a;
    public final String b;
    public final String c;
    public final String d;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22495a;
        public String b;
        public String c;
        public String d;

        public AdError build() {
        }

        public Builder fromAdErrorCode(AdErrorCode adErrorCode) {
        }

        public Builder setCode(int i) {
            this.f22495a = i;
            return this;
        }

        public Builder setMessage(String str) {
            this.b = str;
            return this;
        }

        public Builder setPlatFormCode(String str) {
            this.c = str;
            return this;
        }

        public Builder setPlatFormMsg(String str) {
            this.d = str;
            return this;
        }
    }

    public AdError(Builder builder) {
    }

    public int getCode() {
        return this.f22494a;
    }

    public String getMessage() {
        return this.b;
    }

    public String getPlatFormCode() {
        return this.c;
    }

    public String getPlatFormMsg() {
        return this.d;
    }

    public String toString() {
    }
}
