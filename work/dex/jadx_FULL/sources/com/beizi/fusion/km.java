package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum km implements nc {
    ERROR_INVALID_URL(1, "url invalid"),
    ERROR_NULL_MODEL_BUILD(2, "model builder is null"),
    ERROR_EMPTY_CONTENT(3, "request content is null");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27478a;
    private final String b;

    km(int i, String str) {
        this.f27478a = i;
        this.b = str;
    }

    @Override // com.beizi.fusion.nc
    public String a() {
        return this.b;
    }

    @Override // com.beizi.fusion.nc
    public int b() {
        return this.f27478a;
    }
}
