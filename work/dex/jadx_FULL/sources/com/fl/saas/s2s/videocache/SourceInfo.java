package com.fl.saas.s2s.videocache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SourceInfo {
    public final long length;
    public final String mime;
    public final String url;

    public SourceInfo(String str, long j, String str2) {
        this.url = str;
        this.length = j;
        this.mime = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.length + ", mime='" + this.mime + "'}";
    }
}
