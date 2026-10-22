package cj.mobile.jt.core;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class JuTuiAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22455a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22456a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public boolean g;

        public JuTuiAdSlot build() {
        }

        public Builder setAdType(int i) {
            this.b = i;
            return this;
        }

        public Builder setFetchTime(int i) {
            this.f = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.e = i;
            return this;
        }

        public Builder setMaxAdNum(int i) {
        }

        public Builder setShakeAble(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setSlotId(String str) {
            this.f22456a = str;
            return this;
        }

        public Builder setWidth(int i) {
            this.d = i;
            return this;
        }
    }

    public JuTuiAdSlot(Builder builder) {
    }

    public int getAdType() {
        return this.b;
    }

    public int getFetchTime() {
        return this.f;
    }

    public int getHeight() {
        return this.e;
    }

    public boolean getIsMute() {
        return true;
    }

    public int getMaxAdNum() {
        return this.c;
    }

    public String getSlotId() {
        return this.f22455a;
    }

    public int getWidth() {
        return this.d;
    }

    public boolean isShakeAble() {
        return this.g;
    }
}
