package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class Timeline {

    @SerializedName("Duration")
    private float mDuration;

    @SerializedName("VideoTracks")
    private List<VideoTrack> mVideoTracks = new ArrayList();

    @SerializedName("AudioTracks")
    private List<AudioTrack> mAudioTracks = new ArrayList();

    @SerializedName("PasterTracks")
    private List<PasterTrack> mPasterTracks = new ArrayList();

    @SerializedName("GlobalTracks")
    private List<GlobalTrack> mGlobalTracks = new ArrayList();

    @SerializedName("EffectTracks")
    private List<EffectTrack> mEffectTracks = new ArrayList();

    public List<AudioTrack> getAudioTracks() {
        return this.mAudioTracks;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public List<EffectTrack> getEffectTracks() {
        return this.mEffectTracks;
    }

    public List<GlobalTrack> getGlobalTracks() {
        return this.mGlobalTracks;
    }

    public List<PasterTrack> getPasterTracks() {
        return this.mPasterTracks;
    }

    public List<VideoTrack> getPipTracks() {
        ArrayList arrayList = new ArrayList();
        if (this.mVideoTracks.size() > 1) {
            List<VideoTrack> list = this.mVideoTracks;
            arrayList.addAll(list.subList(1, list.size()));
        }
        return arrayList;
    }

    public VideoTrack getPrimaryTrack() {
        if (this.mVideoTracks.isEmpty()) {
            this.mVideoTracks.add(new VideoTrack());
        }
        return this.mVideoTracks.get(0);
    }

    public List<VideoTrack> getVideoTracks() {
        return this.mVideoTracks;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }
}
