package com.aliyun.svideosdk.recorder;

import com.aliyun.Visible;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public interface AliyunIClipManager {
    void deleteAllPart();

    void deleteLastPart();

    @Deprecated
    void deletePart();

    void deletePart(int i);

    int getDuration();

    long getDuration(TimeUnit timeUnit);

    int getMaxDuration();

    int getMinDuration();

    int getPartCount();

    List<String> getVideoPathList();

    void setMaxDuration(int i);

    void setMinDuration(int i);
}
