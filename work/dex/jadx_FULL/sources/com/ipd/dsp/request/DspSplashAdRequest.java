package com.ipd.dsp.request;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DspSplashAdRequest extends DspAdRequest {
    private int fallingRate;
    private int fetchTimeOut;
    private boolean isDisableFallingView;
    private boolean isEnableSlideView;
    private boolean isShakeable;
    private int shakeRequireForce;

    @Keep
    public DspSplashAdRequest(String str) {
        super(str);
        this.fetchTimeOut = 5;
        this.isShakeable = true;
        this.shakeRequireForce = 15;
        this.isDisableFallingView = true;
        this.fallingRate = 0;
        this.isEnableSlideView = true;
    }

    @Keep
    public int getFallingRate() {
        return this.fallingRate;
    }

    @Keep
    public int getFetchTimeOut() {
        return this.fetchTimeOut;
    }

    @Keep
    public int getShakeRequireForce() {
        return this.shakeRequireForce;
    }

    @Keep
    public void isDisableFallingView(boolean z) {
        this.isDisableFallingView = z;
    }

    @Keep
    public void isEnableSlideView(boolean z) {
        this.isEnableSlideView = z;
    }

    @Keep
    public void isShakeable(boolean z) {
        this.isShakeable = z;
    }

    @Keep
    public void setFallingRate(int i) {
        this.fallingRate = i;
    }

    @Keep
    public void setFetchTimeOut(int i) {
        this.fetchTimeOut = i;
    }

    @Keep
    public void setShakeRequireForce(int i) {
        this.shakeRequireForce = i;
    }

    @Keep
    public boolean isDisableFallingView() {
        return this.isDisableFallingView;
    }

    @Keep
    public boolean isEnableSlideView() {
        return this.isEnableSlideView;
    }

    @Keep
    public boolean isShakeable() {
        return this.isShakeable;
    }
}
