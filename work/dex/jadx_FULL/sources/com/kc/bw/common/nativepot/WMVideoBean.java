package com.kc.bw.common.nativepot;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMVideoBean {
    public WMVideoControl videoControl;
    public View videoView;

    public WMVideoBean(WMVideoControl wMVideoControl, View view) {
        this.videoControl = wMVideoControl;
        this.videoView = view;
    }

    public WMVideoControl getVideoControl() {
        return this.videoControl;
    }

    public View getVideoView() {
        return this.videoView;
    }

    public WMVideoBean setVideoControl(WMVideoControl wMVideoControl) {
        this.videoControl = wMVideoControl;
        return this;
    }

    public WMVideoBean setVideoView(View view) {
        this.videoView = view;
        return this;
    }
}
