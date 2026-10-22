package com.kwad.components.ad.fullscreen.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat kc = new SimpleDateFormat("yyyy-MM-dd");
    public long kd;
    public int ke;

    public b() {
        this.kd = -1L;
        this.ke = -1;
    }

    public final boolean Q(int i) {
        int i2 = this.ke;
        return i2 > 0 && i2 >= i;
    }

    public final boolean m(long j) {
        if (this.kd > 0 && j > 0) {
            try {
                return kc.format(new Date(this.kd)).equals(kc.format(new Date(j)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public b(long j, int i) {
        this.kd = j;
        this.ke = 1;
    }
}
