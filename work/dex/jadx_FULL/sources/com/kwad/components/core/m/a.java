package com.kwad.components.core.m;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    private static SimpleDateFormat abh = new SimpleDateFormat("yyyy-MM-dd");
    public int abi;
    public long abj;

    public final boolean l(int i, int i2) {
        c.d("AdForceActiveInfo", "checkAndAddCount forceActiveIntervalHour: " + i + ", forceActiveThreshold: " + i2);
        if (this.abj <= 0) {
            to();
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = abh.format(new Date(this.abj));
        String str2 = abh.format(new Date(jCurrentTimeMillis));
        c.d("AdForceActiveInfo", "checkAndAddCount lastDate: " + str + ", currentDate: " + str2);
        if (!str.equals(str2)) {
            this.abi = 0;
            to();
            return true;
        }
        long j = this.abj + (((long) i) * 60 * 60 * 1000);
        c.d("AdForceActiveInfo", "checkAndAddCount minTimestamp: " + j + ", currentActiveCount: " + this.abi);
        if (j >= jCurrentTimeMillis || this.abi > i2) {
            return false;
        }
        to();
        return true;
    }

    public final void to() {
        this.abj = System.currentTimeMillis();
        this.abi++;
        c.d("AdForceActiveInfo", "doAddCount, lastForceActiveTimestamp: " + this.abj + ", currentActiveCount " + this.abi);
    }
}
