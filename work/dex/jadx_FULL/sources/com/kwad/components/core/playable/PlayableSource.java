package com.kwad.components.core.playable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public enum PlayableSource {
    UNKNOWN_TRYPLAY_ENTRY_SOURCE(0),
    PLAY_FINISHED_NORMAL(1),
    PENDANT_CLICK_NOT_AUTO(2),
    PENDANT_CLICK_AUTO(3),
    PENDANT_AUTO(4),
    ACTIONBAR_CLICK(5),
    ENDCARD_CLICK(6);

    private int code;

    PlayableSource(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
