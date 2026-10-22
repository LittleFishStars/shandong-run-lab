package com.ipd.dsp.request;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DspRewardVideoAdRequest extends DspAdRequest {
    private int amount;
    private String extra;
    private int fallingRate;
    private boolean isDisableFallingView;
    private boolean isEnableSlideView;
    private boolean isOneClickShutdown;
    private boolean isShakeable;
    private String name;
    private int shakeRequireForce;

    @Keep
    public DspRewardVideoAdRequest(String str) {
        super(str);
        this.isShakeable = true;
        this.shakeRequireForce = 15;
        this.isDisableFallingView = true;
        this.fallingRate = 0;
        this.isEnableSlideView = true;
        this.isOneClickShutdown = false;
    }

    @Keep
    public int getAmount() {
        return this.amount;
    }

    @Keep
    public String getExtra() {
        return this.extra;
    }

    @Keep
    public int getFallingRate() {
        return this.fallingRate;
    }

    @Keep
    public String getName() {
        return this.name;
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
    public void isOneClickShutdown(boolean z) {
        this.isOneClickShutdown = z;
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
    public void setRewardAmount(int i) {
        this.amount = i;
    }

    @Keep
    public void setRewardExtra(String str) {
        this.extra = str;
    }

    @Keep
    public void setRewardName(String str) {
        this.name = str;
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
    public boolean isOneClickShutdown() {
        return this.isOneClickShutdown;
    }

    @Keep
    public boolean isShakeable() {
        return this.isShakeable;
    }
}
