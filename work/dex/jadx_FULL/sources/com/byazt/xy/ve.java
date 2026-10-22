package com.byazt.xy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum ve {
    JSON(".json"),
    ZIP(".zip");

    public final String ve;

    ve(String str) {
        this.ve = str;
    }

    public String c() {
        return ".temp" + this.ve;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ve;
    }
}
