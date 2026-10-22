package com.kc.dw.platform.ad_adapter.splash;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ShakeResult implements Serializable {
    private float shakeX;
    private float shakeY;
    private float shakeZ;
    private long totalTurnTime;
    private float turnX;
    private float turnY;
    private float turnZ;

    public float getShakeX() {
        return this.shakeX;
    }

    public float getShakeY() {
        return this.shakeY;
    }

    public float getShakeZ() {
        return this.shakeZ;
    }

    public long getTotalTurnTime() {
        return this.totalTurnTime;
    }

    public float getTurnX() {
        return this.turnX;
    }

    public float getTurnY() {
        return this.turnY;
    }

    public float getTurnZ() {
        return this.turnZ;
    }

    public void setShakeX(float f) {
        this.shakeX = f;
    }

    public void setShakeY(float f) {
        this.shakeY = f;
    }

    public void setShakeZ(float f) {
        this.shakeZ = f;
    }

    public void setTotalTurnTime(long j) {
        this.totalTurnTime = j;
    }

    public void setTurnX(float f) {
        this.turnX = f;
    }

    public void setTurnY(float f) {
        this.turnY = f;
    }

    public void setTurnZ(float f) {
        this.turnZ = f;
    }
}
