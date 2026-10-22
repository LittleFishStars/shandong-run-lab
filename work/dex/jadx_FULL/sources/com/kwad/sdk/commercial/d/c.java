package com.kwad.sdk.commercial.d;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class c extends com.kwad.sdk.commercial.c.a {
    public String aKu;
    public String aKv;

    public static c Is() {
        return new c();
    }

    public final c dy(String str) {
        this.aKu = str;
        return this;
    }

    public final c dz(String str) {
        this.aKv = str;
        return this;
    }
}
