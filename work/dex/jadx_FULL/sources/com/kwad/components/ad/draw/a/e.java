package com.kwad.components.ad.draw.a;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class e extends com.kwad.sdk.commercial.c.a {
    public long dP;
    public int materialType;
    public String materialUrl;
    public int status;

    public static e aT() {
        return new e();
    }

    public final e J(int i) {
        this.status = i;
        return this;
    }

    public final e K(int i) {
        this.materialType = i;
        return this;
    }

    public final e k(long j) {
        this.dP = j;
        return this;
    }

    public final e s(String str) {
        this.materialUrl = str;
        return this;
    }
}
