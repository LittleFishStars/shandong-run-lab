package com.aliyun.svideosdk.multirecorder.impl;

import android.content.Context;
import com.aliyun.Visible;
import com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder;
import com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunMultiRecorderCreator {
    public static AliyunIVideoRecorder getVideoRecorderInstance(Context context, AliyunVideoRecorderConfig aliyunVideoRecorderConfig) {
        return new a(context, aliyunVideoRecorderConfig);
    }
}
