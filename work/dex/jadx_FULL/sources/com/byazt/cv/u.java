package com.byazt.cv;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 67})
public class u extends com.byazt.nc.t {
    public String c;
    public int tt;
    public int ve;

    public u(String str) {
        this.c = str;
    }

    @Override // com.byazt.nc.t
    public double getDuration() {
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.byazt.nc.t
    public int getHeight() {
        return this.ve;
    }

    @Override // com.byazt.nc.t
    public String getImageUrl() {
        return !TextUtils.isEmpty(this.c) ? this.c : "";
    }

    @Override // com.byazt.nc.t
    public int getWidth() {
        return this.tt;
    }

    @Override // com.byazt.nc.t
    public boolean isValid() {
        return !TextUtils.isEmpty(this.c);
    }

    public u(String str, int i, int i2) {
        this.c = str;
        this.tt = i;
        this.ve = i2;
    }
}
