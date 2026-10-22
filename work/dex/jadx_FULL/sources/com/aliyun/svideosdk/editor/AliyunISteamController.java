package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunISteamController {
    int apply();

    AliyunIAnimationController getAnimationController();

    AliyunIAudioController getAudioController();

    AliyunIAugmentationController getAugmentationController();

    long getClipDurationInMillis();

    long getClipStartTimeInMillis();

    int getHeight();

    AliyunILayoutController getLayoutController();

    String getPath();

    int getStreamId();

    long getTimeLineEndTimeInMillis();

    long getTimeLineStartTimeInMillis();

    int getWidth();

    AliyunISteamController setBorderColor(int i);

    AliyunISteamController setBorderCornerRadius(float f);

    AliyunISteamController setBorderWidth(float f);

    AliyunISteamController setClipEndTime(long j, TimeUnit timeUnit);

    AliyunISteamController setClipStartTime(long j, TimeUnit timeUnit);

    AliyunISteamController setHorizontalFlip(boolean z);

    AliyunISteamController setTimelineStartTime(long j, TimeUnit timeUnit);
}
