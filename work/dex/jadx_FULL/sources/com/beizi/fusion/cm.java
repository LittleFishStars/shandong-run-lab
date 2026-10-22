package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum cm {
    POST("POST"),
    GET("GET"),
    DOWNLOAD("DOWNLOAD"),
    STREAM("STREAM"),
    CACHE_IMAGE("CACHE");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27146a;

    cm(String str) {
        this.f27146a = str;
    }

    public String b() {
        return this.f27146a;
    }
}
