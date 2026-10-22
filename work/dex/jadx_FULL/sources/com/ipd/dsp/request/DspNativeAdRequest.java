package com.ipd.dsp.request;

import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DspNativeAdRequest extends DspAdRequest {
    private int adNum;

    @Keep
    public DspNativeAdRequest(String str) {
        super(str);
        this.adNum = 1;
    }

    @Keep
    public int getAdNum() {
        return this.adNum;
    }

    @Keep
    public void setAdNum(@IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS) int i) {
        this.adNum = i;
    }
}
