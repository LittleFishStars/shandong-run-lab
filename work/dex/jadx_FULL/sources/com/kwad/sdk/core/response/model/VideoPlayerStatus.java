package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class VideoPlayerStatus extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -9021213312245598171L;
    public int mVideoPlayerBehavior = 1;
    public int mVideoPlayerType;

    public void setVideoPlayerBehavior(int i) {
        this.mVideoPlayerBehavior = i;
    }

    public void setVideoPlayerType(int i) {
        this.mVideoPlayerType = i;
    }
}
