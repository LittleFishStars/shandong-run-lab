package com.aliyun.svideosdk.editor;

import android.graphics.PointF;
import com.aliyun.Visible;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIPipManager {
    AliyunIPipController createNewPip(String str);

    AliyunIPipController createPipInTrack(String str, AliyunIPipTrack aliyunIPipTrack);

    AliyunIPipController findTopPipController(long j, PointF pointF);

    List<AliyunIPipController> getAllPip();

    List<AliyunIPipTrack> getPipTracks();

    boolean movePipIntoTrack(AliyunIPipController aliyunIPipController, AliyunIPipTrack aliyunIPipTrack, long j);

    boolean removePip(AliyunIPipController aliyunIPipController);
}
