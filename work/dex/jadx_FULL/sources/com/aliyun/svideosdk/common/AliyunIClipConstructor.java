package com.aliyun.svideosdk.common;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.AliyunClip;
import com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunIClipConstructor extends AliyunIClipManager {
    @Deprecated
    int addImage(String str, long j, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode);

    @Deprecated
    int addVideo(String str, long j, long j2, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode);

    @Deprecated
    int addVideo(String str, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode);

    @Deprecated
    int deleteMediaClip();

    @Deprecated
    AliyunClip getMediaPart(int i);

    @Deprecated
    int getMediaPartCount();

    void removeMedia(int i);

    void removeVideo(String str) throws IllegalAccessException;
}
