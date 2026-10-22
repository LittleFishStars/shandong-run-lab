package com.aliyun.svideosdk.editor;

import android.graphics.RectF;
import com.aliyun.Visible;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIPipController extends AliyunISteamController {
    AliyunIPipTrack getOwnerTrack();

    RectF getPipRectFInCurrentScreen();

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    AliyunIPipController setBorderColor(int i);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    AliyunIPipController setBorderCornerRadius(float f);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    AliyunIPipController setBorderWidth(float f);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    AliyunIPipController setClipEndTime(long j, TimeUnit timeUnit);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    AliyunIPipController setClipStartTime(long j, TimeUnit timeUnit);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    AliyunIPipController setHorizontalFlip(boolean z);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    AliyunIPipController setTimelineStartTime(long j, TimeUnit timeUnit);
}
