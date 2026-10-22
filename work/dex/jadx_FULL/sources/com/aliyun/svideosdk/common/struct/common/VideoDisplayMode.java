package com.aliyun.svideosdk.common.struct.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public enum VideoDisplayMode {
    SCALE(0),
    FILL(1);

    private int displayMode;

    VideoDisplayMode(int i) {
        this.displayMode = i;
    }

    public static VideoDisplayMode valueOf(int i) {
        return values()[i];
    }

    public int getDisplayMode() {
        return this.displayMode;
    }
}
