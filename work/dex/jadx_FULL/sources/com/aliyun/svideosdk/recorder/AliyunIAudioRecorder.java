package com.aliyun.svideosdk.recorder;

import android.content.Context;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioRecordCallback;
import com.aliyun.svideosdk.common.struct.common.AliyunAudioClip;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public interface AliyunIAudioRecorder {
    AliyunAudioClip[] allClips();

    AliyunAudioClip breakTag();

    int connectClip();

    int deleteClip(AliyunAudioClip aliyunAudioClip);

    long getRecordDuration();

    int init(Context context);

    int release();

    void setOnAudioRecordCallback(OnAudioRecordCallback onAudioRecordCallback);

    int setOutputPath(String str);

    int startRecord();

    AliyunAudioClip stopRecord();
}
