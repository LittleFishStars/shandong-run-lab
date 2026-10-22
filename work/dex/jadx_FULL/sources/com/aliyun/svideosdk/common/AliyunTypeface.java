package com.aliyun.svideosdk.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public enum AliyunTypeface {
    NORMAL,
    BOLD,
    ITALIC,
    BOLD_ITALIC;

    public static AliyunTypeface get(int i) {
        return values()[i];
    }
}
