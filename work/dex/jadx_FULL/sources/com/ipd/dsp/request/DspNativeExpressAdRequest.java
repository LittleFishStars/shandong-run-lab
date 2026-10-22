package com.ipd.dsp.request;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DspNativeExpressAdRequest extends DspAdRequest {
    private int adNum;

    @Keep
    public DspNativeExpressAdRequest(String str) {
        super(str);
    }

    @Keep
    public int getAdNum() {
        return this.adNum;
    }

    @Keep
    public void setAdNum(int i) {
        this.adNum = i;
    }
}
