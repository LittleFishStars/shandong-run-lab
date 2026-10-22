package com.kwad.components.ad.c.c;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class a extends com.kwad.sdk.commercial.c.a {
    public int cO;
    public int cP;
    public int renderType;

    public static a au() {
        return new a();
    }

    public final a s(int i) {
        this.cO = i;
        return this;
    }

    public final a t(int i) {
        this.renderType = i;
        return this;
    }

    public final a u(int i) {
        this.cP = i;
        return this;
    }
}
