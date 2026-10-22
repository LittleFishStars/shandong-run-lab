package cj.mobile.wm.common.nativepot;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WMVideoOption {
    public boolean isAutoPlay;
    public boolean isSilence = true;

    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public boolean isSilence() {
        return this.isSilence;
    }

    public WMVideoOption setAutoPlay(boolean z) {
        this.isAutoPlay = z;
        return this;
    }

    public WMVideoOption setSilence(boolean z) {
        this.isSilence = z;
        return this;
    }
}
