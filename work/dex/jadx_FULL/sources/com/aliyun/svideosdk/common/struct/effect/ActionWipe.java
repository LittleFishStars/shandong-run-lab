package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionWipe extends ActionBase {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;
    public static final int WIPE_MODE_APPEAR = 0;
    public static final int WIPE_MODE_DISAPPEAR = 1;
    protected int mDirection;
    protected int mWipeMode;

    public ActionWipe() {
        this.mType = ActionBase.Type.swipe;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public int getWipeMode() {
        return this.mWipeMode;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setAnimationConfig(String str) {
        throw new RuntimeException("Not Support");
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setWipeMode(int i) {
        this.mWipeMode = i;
    }
}
