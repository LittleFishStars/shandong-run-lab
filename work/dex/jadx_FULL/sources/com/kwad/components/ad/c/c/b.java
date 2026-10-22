package com.kwad.components.ad.c.c;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public int cP;
    public long cQ;
    public int cR;
    public long loadTime;
    public int materialType;
    public String materialUrl;
    public long renderTime;
    public int renderType;
    public int status;

    public static b av() {
        return new b();
    }

    public final b A(int i) {
        this.cR = i;
        return this;
    }

    public final b e(long j) {
        this.loadTime = j;
        return this;
    }

    public final b f(long j) {
        this.renderTime = j;
        return this;
    }

    public final b g(long j) {
        this.cQ = j;
        return this;
    }

    public final b p(String str) {
        this.materialUrl = str;
        return this;
    }

    public final b v(int i) {
        this.status = i;
        return this;
    }

    public final b w(int i) {
        this.adNum = i;
        return this;
    }

    public final b x(int i) {
        this.materialType = i;
        return this;
    }

    public final b y(int i) {
        this.renderType = i;
        return this;
    }

    public final b z(int i) {
        this.cP = i;
        return this;
    }
}
