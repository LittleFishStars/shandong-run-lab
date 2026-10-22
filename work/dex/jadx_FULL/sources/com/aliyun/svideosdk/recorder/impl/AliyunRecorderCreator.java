package com.aliyun.svideosdk.recorder.impl;

import android.content.Context;
import com.aliyun.Visible;
import com.aliyun.svideosdk.recorder.AliyunIAudioRecorder;
import com.aliyun.svideosdk.recorder.AliyunIRecorder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public class AliyunRecorderCreator {
    public static AliyunIAudioRecorder getAudioRecorderInstance() {
        return new b();
    }

    public static AliyunIRecorder getRecorderInstance(Context context) {
        return new g(context, com.aliyun.svideosdk.a.f.a.CAMERA1);
    }
}
