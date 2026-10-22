package com.aliyun.svideosdk.crop;

import com.aliyun.Visible;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunICrop {
    void cancel();

    void dispose();

    long getVideoDuration(String str) throws Exception;

    void setCropCallback(CropCallback cropCallback);

    int setCropParam(CropParam cropParam);

    void setUseHW(boolean z);

    int startCrop();

    int startCropAudio(String str, String str2, long j, long j2);

    int startCropAudio(String str, String str2, long j, long j2, TimeUnit timeUnit);

    String version();
}
