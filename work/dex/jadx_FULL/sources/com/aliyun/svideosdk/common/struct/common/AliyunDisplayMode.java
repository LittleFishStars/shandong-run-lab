package com.aliyun.svideosdk.common.struct.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public enum AliyunDisplayMode {
    DEFAULT;

    public static AliyunDisplayMode getInstanceByValue(int i) {
        if (i != 0) {
            return null;
        }
        return DEFAULT;
    }
}
