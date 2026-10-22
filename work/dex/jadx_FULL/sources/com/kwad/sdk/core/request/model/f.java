package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public long aXx;
    public int adStyle;
    public int count;
    public int taskType;

    public f() {
    }

    public final void aL(long j) {
        this.aXx = j;
    }

    public f(int i, int i2, int i3, long j) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = 1;
        this.aXx = j;
    }
}
