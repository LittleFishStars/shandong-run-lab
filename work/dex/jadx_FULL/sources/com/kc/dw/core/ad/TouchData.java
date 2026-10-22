package com.kc.dw.core.ad;

import com.kc.dw.core.view.TouchPositionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TouchData {
    private TouchPositionListener.TouchPosition touchPosition;

    public TouchPositionListener.TouchPosition getTouchPosition() {
        return this.touchPosition;
    }

    public void setTouchPosition(TouchPositionListener.TouchPosition touchPosition) {
        this.touchPosition = touchPosition;
    }
}
