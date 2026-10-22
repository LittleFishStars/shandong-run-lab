package com.kc.dw.core.view.gif;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GifHeader {
    public int bgColor;
    public int bgIndex;
    public GifFrame currentFrame;
    public boolean gctFlag;
    public int gctSize;
    public int height;
    public int pixelAspect;
    public int width;
    public int[] gct = null;
    public int status = 0;
    public int frameCount = 0;
    public List<GifFrame> frames = new ArrayList();
    public int loopCount = 0;

    public int getHeight() {
        return this.height;
    }

    public int getNumFrames() {
        return this.frameCount;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.width;
    }
}
