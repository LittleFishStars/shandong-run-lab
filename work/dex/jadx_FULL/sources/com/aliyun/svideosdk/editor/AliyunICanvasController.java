package com.aliyun.svideosdk.editor;

import android.graphics.Paint;
import android.view.View;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunICanvasController {
    int applyPaintCanvas();

    void cancel();

    void clear();

    void confirm();

    View getCanvas();

    boolean hasCanvasPath();

    void release();

    void removeCanvas();

    int resetPaintCanvas();

    void setCurrentColor(int i);

    void setCurrentSize(float f);

    void setPaint(Paint paint);

    void undo();
}
