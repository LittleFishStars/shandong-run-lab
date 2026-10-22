package com.byazt.hs;

import androidx.camera.video.AudioStats;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SECURITYBODY_SERVER_ERROR, 15})
public class uj {
    public final double c;
    public final int tt;
    public int uj;
    public double ve = -1.0d;

    public uj(double d) {
        this.c = d;
        this.tt = d == AudioStats.AUDIO_AMPLITUDE_NONE ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void c(double d) {
        double d2 = 1.0d - this.c;
        int i = this.uj;
        if (i > this.tt) {
            this.ve = Math.exp((d2 * Math.log(this.ve)) + (this.c * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.ve = Math.exp((d3 * Math.log(this.ve)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.ve = d;
        }
        this.uj++;
    }

    public double c() {
        return this.ve;
    }
}
