package com.aliyun.svideosdk.common.struct.effect;

import android.graphics.Bitmap;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.CanvasInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectPaint {
    private Bitmap bitmap;
    private CanvasInfo canvasInfo;
    private String path;
    private int viewId;

    @Deprecated
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public CanvasInfo getCanvasInfo() {
        return this.canvasInfo;
    }

    public String getPath() {
        return this.path;
    }

    public int getViewId() {
        return this.viewId;
    }

    @Deprecated
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setCanvasInfo(CanvasInfo canvasInfo) {
        this.canvasInfo = canvasInfo;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setViewId(int i) {
        this.viewId = i;
    }
}
