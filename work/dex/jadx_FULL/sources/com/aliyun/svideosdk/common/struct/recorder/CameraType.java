package com.aliyun.svideosdk.common.struct.recorder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public enum CameraType {
    FRONT(1),
    BACK(0);

    private int type;

    CameraType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
