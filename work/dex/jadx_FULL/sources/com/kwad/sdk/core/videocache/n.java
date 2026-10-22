package com.kwad.sdk.core.videocache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class n {
    public final long baB;
    public final String baC;
    public final String url;

    public n(String str, long j, String str2) {
        this.url = str;
        this.baB = j;
        this.baC = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.baB + ", mime='" + this.baC + "'}";
    }
}
