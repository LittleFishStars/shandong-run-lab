package com.aliyun.svideosdk.common.struct.project;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RollCaptionTrack extends PasterTrack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("Items")
    private List<RollCaptionTrackClip> f25681a = new ArrayList();

    public RollCaptionTrack() {
        setType(PasterTrack.Type.roll_captions);
    }

    public List<RollCaptionTrackClip> getRollCaptionTrackClips() {
        return this.f25681a;
    }
}
