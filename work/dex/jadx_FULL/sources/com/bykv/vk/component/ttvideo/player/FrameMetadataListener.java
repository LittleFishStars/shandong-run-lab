package com.bykv.vk.component.ttvideo.player;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface FrameMetadataListener {
    void frameDTSNotify(int i, long j, long j2);

    void onFrameAboutToBeRendered(int i, long j, long j2, Map<Integer, String> map);

    void updateFrameTerminatedDTS(int i, long j, long j2);
}
