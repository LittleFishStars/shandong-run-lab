package com.kwad.components.core.innerEc.live.base;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    public int Tt;
    public long Tu;
    public String authorId;
    public String content;
    public String kwaiUserId;
    public String liveStreamId;

    public static b rv() {
        return new b();
    }

    public final b I(long j) {
        this.Tu = 1L;
        return this;
    }

    public final b aC(String str) {
        this.authorId = str;
        return this;
    }

    public final b aD(String str) {
        this.liveStreamId = str;
        return this;
    }

    public final b aE(String str) {
        this.kwaiUserId = str;
        return this;
    }

    public final b aF(String str) {
        this.content = str;
        return this;
    }

    public final b aV(int i) {
        this.Tt = i;
        return this;
    }
}
