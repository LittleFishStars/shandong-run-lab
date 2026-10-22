package com.kwad.sdk.commercial.f;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class b extends com.kwad.sdk.commercial.c.a {
    public String aJY;
    public String aKf;
    public int ads;
    public int status;
    public String url;

    public static b Iu() {
        return new b();
    }

    public final b dB(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.aJY = url.getHost();
            this.aKf = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b dC(int i) {
        this.status = i;
        return this;
    }

    public final b dD(int i) {
        this.ads = i;
        return this;
    }
}
