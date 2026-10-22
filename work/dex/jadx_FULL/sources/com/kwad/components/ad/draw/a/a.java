package com.kwad.components.ad.draw.a;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class a extends com.kwad.sdk.commercial.c.a {
    public int callbackType;
    public String dO;
    public int renderType;

    public static a aR() {
        return new a();
    }

    public final a B(int i) {
        this.renderType = i;
        return this;
    }

    public final a C(int i) {
        this.callbackType = i;
        return this;
    }
}
