package com.kwad.sdk.api.model.liveModel;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class KsLiveBaseInfo implements Serializable {
    private static final long serialVersionUID = 6107250137063788330L;
    private long liveDisplayWatchingCount;
    private String portraitUrl;
    private String userName;

    public long getLiveDisplayWatchingCount() {
        return this.liveDisplayWatchingCount;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setLiveDisplayWatchingCount(long j) {
        this.liveDisplayWatchingCount = j;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "KsLiveBaseInfo{portraitUrl='" + this.portraitUrl + "', userName='" + this.userName + "', liveDisplayWatchingCount=" + this.liveDisplayWatchingCount + '}';
    }
}
