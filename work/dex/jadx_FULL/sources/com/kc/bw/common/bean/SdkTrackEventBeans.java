package com.kc.bw.common.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkTrackEventBeans {
    public int os = 1;
    public List<SdkTrackEventBean> sdk_track_event;

    public int getOs() {
        return this.os;
    }

    public List<SdkTrackEventBean> getSdk_track_event() {
        return this.sdk_track_event;
    }

    public void setOs(int i) {
        this.os = i;
    }

    public void setSdk_track_event(List<SdkTrackEventBean> list) {
        this.sdk_track_event = list;
    }
}
