package com.kwad.components.ad.reward.c;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int vg = 1;
    public static int vh = 3;
    public int vi;
    public int vj;

    public b() {
        this.vi = STATUS_NONE;
    }

    public final void ak(int i) {
        this.vj = i;
    }

    public final int getType() {
        return this.vi;
    }

    public final int ik() {
        return this.vj;
    }

    public b(int i) {
        this.vi = 1;
    }
}
