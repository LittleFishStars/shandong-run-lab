package com.aliyun.svideosdk.common;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.AliyunClip;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunIClipManager {
    int addMediaClip(int i, AliyunClip aliyunClip);

    int addMediaClip(AliyunClip aliyunClip);

    int deleteLastMediaClip();

    int deleteMediaClip(int i);

    void deleteMediaClip(AliyunClip aliyunClip);

    List<AliyunClip> getAllClips();

    AliyunClip getMediaClip(int i);

    int getMediaClipCount();

    void swap(int i, int i2);

    void updateAllClips(List<AliyunClip> list);

    int updateMediaClip(int i, AliyunClip aliyunClip);
}
