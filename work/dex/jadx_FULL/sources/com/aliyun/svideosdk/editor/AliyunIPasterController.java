package com.aliyun.svideosdk.editor;

import android.graphics.PointF;
import android.graphics.RectF;
import com.aliyun.Visible;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIPasterController {
    long getDuration();

    long getDuration(TimeUnit timeUnit);

    PointF getPosition();

    float getRotate();

    RectF getSize();

    long getStartTime();

    long getStartTime(TimeUnit timeUnit);

    int getType();

    void setDuration(long j);

    void setDuration(long j, TimeUnit timeUnit);

    void setPosition(PointF pointF);

    void setRotate(float f);

    void setStartTime(long j);

    void setStartTime(long j, TimeUnit timeUnit);
}
