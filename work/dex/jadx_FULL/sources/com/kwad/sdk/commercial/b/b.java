package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class b extends com.kwad.sdk.commercial.c.a {
    public String aJY;
    public String aKf;
    public String aKg;
    public int aKh;
    public int aKi;
    public int status;
    public String url;

    public static b Ip() {
        return new b();
    }

    public final b dr(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aJY = url.getHost();
            this.aKf = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b ds(String str) {
        this.aKg = str;
        return this;
    }

    public final b dx(int i) {
        this.status = i;
        return this;
    }

    public final b dy(int i) {
        this.aKh = i;
        return this;
    }

    public final b dz(int i) {
        this.aKi = i;
        return this;
    }
}
