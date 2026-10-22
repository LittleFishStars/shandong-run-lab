package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AudioTrack extends MediaTrack {

    @SerializedName("ClipList")
    private List<AudioTrackClip> mAudioTrackClips = new ArrayList();

    public List<AudioTrackClip> getAudioTrackClips() {
        return this.mAudioTrackClips;
    }
}
