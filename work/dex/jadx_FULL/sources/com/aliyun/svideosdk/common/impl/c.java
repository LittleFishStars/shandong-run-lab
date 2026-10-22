package com.aliyun.svideosdk.common.impl;

import com.aliyun.svideosdk.common.AliyunIClipManager;
import com.aliyun.svideosdk.common.struct.common.AliyunClip;
import com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode;
import com.aliyun.svideosdk.common.struct.common.AliyunImageClip;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoClip;
import com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements AliyunIClipManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<AliyunClip> f25634a = new ArrayList();

    public c(List<VideoTrackClip> list) throws Throwable {
        if (list != null) {
            AliyunClip aliyunClipBuild = null;
            for (VideoTrackClip videoTrackClip : list) {
                if (videoTrackClip instanceof MainVideoTrackClip) {
                    MainVideoTrackClip mainVideoTrackClip = (MainVideoTrackClip) videoTrackClip;
                    if (videoTrackClip.getType() == 0) {
                        aliyunClipBuild = new AliyunVideoClip.Builder().source(videoTrackClip.getSource().getPath()).startTime((long) (videoTrackClip.getIn() * 1000.0f)).endTime((long) (videoTrackClip.getOut() * 1000.0f)).displayMode(AliyunDisplayMode.getInstanceByValue(mainVideoTrackClip.getDisplayMode())).rotation(videoTrackClip.getRotation()).transition(videoTrackClip.getTransition()).id(videoTrackClip.getClipId()).build();
                    } else if (videoTrackClip.getType() == 1) {
                        aliyunClipBuild = new AliyunImageClip.Builder().displayMode(AliyunDisplayMode.getInstanceByValue(mainVideoTrackClip.getDisplayMode())).duration((long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f)).id(videoTrackClip.getClipId()).transition(videoTrackClip.getTransition()).source(videoTrackClip.getSource().getPath()).build();
                    }
                    this.f25634a.add(aliyunClipBuild);
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(int i, AliyunClip aliyunClip) {
        if (aliyunClip == null) {
            return -20003007;
        }
        if (i < 0 || i >= getMediaClipCount()) {
            return -20003006;
        }
        this.f25634a.add(i, aliyunClip);
        return i;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int addMediaClip(AliyunClip aliyunClip) {
        if (aliyunClip == null) {
            return -20003007;
        }
        this.f25634a.add(aliyunClip);
        return getMediaClipCount() - 1;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteLastMediaClip() {
        if (getMediaClipCount() == 0) {
            return -20003008;
        }
        this.f25634a.remove(getMediaClipCount() - 1);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int deleteMediaClip(int i) {
        if (i < 0 || i >= getMediaClipCount()) {
            return -20003006;
        }
        this.f25634a.remove(i);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void deleteMediaClip(AliyunClip aliyunClip) {
        this.f25634a.remove(aliyunClip);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public List<AliyunClip> getAllClips() {
        ArrayList arrayList = new ArrayList(Arrays.asList(new AliyunClip[getMediaClipCount()]));
        Collections.copy(arrayList, this.f25634a);
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public AliyunClip getMediaClip(int i) {
        if (i < 0 || i >= getMediaClipCount()) {
            return null;
        }
        return this.f25634a.get(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int getMediaClipCount() {
        return this.f25634a.size();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void swap(int i, int i2) {
        if (i == i2 || i >= getMediaClipCount() || i2 >= getMediaClipCount() || i < 0 || i >= getMediaClipCount() || i2 < 0 || i2 >= getMediaClipCount()) {
            return;
        }
        Collections.swap(this.f25634a, i, i2);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public void updateAllClips(List<AliyunClip> list) {
        this.f25634a.clear();
        Collections.addAll(this.f25634a, new AliyunClip[list.size()]);
        Collections.copy(this.f25634a, list);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipManager
    public int updateMediaClip(int i, AliyunClip aliyunClip) {
        if (aliyunClip == null) {
            return -20003007;
        }
        if (i < 0 || i >= getMediaClipCount()) {
            return -20003006;
        }
        this.f25634a.set(i, aliyunClip);
        return i;
    }
}
