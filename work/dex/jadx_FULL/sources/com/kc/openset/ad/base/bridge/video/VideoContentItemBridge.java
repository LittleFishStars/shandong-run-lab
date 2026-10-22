package com.kc.openset.ad.base.bridge.video;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class VideoContentItemBridge {
    private boolean ad;
    private String id;
    private int position;

    public String getId() {
        return this.id;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isAd() {
        return this.ad;
    }

    public void setAd(boolean z) {
        this.ad = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
