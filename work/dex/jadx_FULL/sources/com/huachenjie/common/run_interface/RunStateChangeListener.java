package com.huachenjie.common.run_interface;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public interface RunStateChangeListener {

    public enum State {
        preStart,
        normal,
        userPause,
        autoPause,
        faceRecognition,
        nfcCheck,
        finish
    }

    void b(State state, Map<String, Object> map);
}
