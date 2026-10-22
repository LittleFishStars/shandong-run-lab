package com.aliyun.svideosdk.editor;

import android.graphics.PointF;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption;
import com.aliyun.svideosdk.editor.impl.AliyunPasterControllerImage;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunPasterManager {
    AliyunPasterControllerCompoundCaption addCaptionWithStartTime(String str, Source source, Source source2, long j, long j2);

    AliyunPasterControllerCompoundCaption addCaptionWithStartTime(String str, Source source, Source source2, long j, long j2, TimeUnit timeUnit);

    @Deprecated
    AliyunPasterControllerCompoundCaption addCaptionWithStartTime(String str, String str2, String str3, long j, long j2);

    AliyunPasterControllerImage addImage(Source source);

    AliyunPasterController addPaster(Source source);

    @Deprecated
    AliyunPasterController addPaster(String str);

    AliyunPasterController addPasterWithStartTime(Source source, long j, long j2);

    AliyunPasterController addPasterWithStartTime(Source source, long j, long j2, TimeUnit timeUnit);

    @Deprecated
    AliyunPasterController addPasterWithStartTime(String str, long j, long j2);

    @Deprecated
    AliyunPasterController addSubtitle(String str, Source source);

    @Deprecated
    AliyunPasterController addSubtitle(String str, String str2);

    @Deprecated
    AliyunPasterController addSubtitleWithStartTime(String str, Source source, long j, long j2);

    @Deprecated
    AliyunPasterController addSubtitleWithStartTime(String str, String str2, long j, long j2);

    AliyunIPasterController findControllerAtPoint(PointF pointF, long j);

    AliyunIPasterController findControllerAtPoint(PointF pointF, long j, TimeUnit timeUnit);

    List<AliyunIPasterController> findControllersByType(int i);

    void remove(AliyunIPasterController aliyunIPasterController);

    void setDisplaySize(int i, int i2);

    void setOnPasterRestoreListener(OnPasterRestored onPasterRestored);
}
