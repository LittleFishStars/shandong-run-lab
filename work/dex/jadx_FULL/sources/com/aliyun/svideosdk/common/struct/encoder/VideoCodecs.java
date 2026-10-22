package com.aliyun.svideosdk.common.struct.encoder;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public enum VideoCodecs {
    H264_HARDWARE,
    H264_SOFT_OPENH264;

    public static VideoCodecs getInstanceByValue(int i) {
        return i != 1 ? H264_HARDWARE : H264_SOFT_OPENH264;
    }
}
