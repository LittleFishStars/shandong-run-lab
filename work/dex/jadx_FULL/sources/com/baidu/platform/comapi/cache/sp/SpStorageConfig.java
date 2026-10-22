package com.baidu.platform.comapi.cache.sp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SpStorageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26783a;
    private boolean b;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26784a;
        private boolean b;

        public Builder() {
            this(null);
        }

        public SpStorageConfig build() {
            return new SpStorageConfig(this.f26784a, this.b);
        }

        public Builder setCacheModel(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setStorageName(String str) {
            this.f26784a = str;
            return this;
        }

        public Builder(SpStorageConfig spStorageConfig) {
            if (spStorageConfig != null) {
                this.f26784a = spStorageConfig.f26783a;
                this.b = spStorageConfig.b;
            }
        }
    }

    private SpStorageConfig(String str, boolean z) {
        this.f26783a = str;
        this.b = z;
    }

    public String a() {
        return this.f26783a;
    }

    public boolean b() {
        return this.b;
    }
}
