package com.aliyun.svideosdk.common.impl;

import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.svideosdk.common.AliyunIClipConstructor;
import com.aliyun.svideosdk.common.struct.common.AliyunClip;
import com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode;
import com.aliyun.svideosdk.common.struct.common.AliyunImageClip;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoClip;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends c implements AliyunIClipConstructor {
    public b(List<VideoTrackClip> list) {
        super(list);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addImage(String str, long j, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth >= 2 && options.outHeight >= 2 && !TextUtils.isEmpty(options.outMimeType) && options.outMimeType.startsWith("image")) {
            return addMediaClip(new AliyunImageClip.Builder().source(str).duration(j).displayMode(aliyunDisplayMode).transition(transitionBase).build());
        }
        Log.e("AliYunLog", "Not supported image for path '" + str + "'");
        return -20004003;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addVideo(String str, long j, long j2, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode) {
        if (j2 >= j) {
            return addMediaClip(new AliyunVideoClip.Builder().source(str).startTime(j).endTime(j2).duration(j2 - j).displayMode(aliyunDisplayMode).transition(transitionBase).build());
        }
        throw new RuntimeException("video duration invalid");
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addVideo(String str, TransitionBase transitionBase, AliyunDisplayMode aliyunDisplayMode) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            return addVideo(str, 0L, Long.parseLong(mediaMetadataRetriever.extractMetadata(9)), transitionBase, aliyunDisplayMode);
        } catch (Exception unused) {
            Log.e("AliYunLog", "Imported video file is invalid!");
            try {
                return -20004001;
            } catch (Exception e) {
                return -20004001;
            }
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int deleteMediaClip() {
        return deleteLastMediaClip();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public AliyunClip getMediaPart(int i) {
        return getMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int getMediaPartCount() {
        return getMediaClipCount();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeMedia(int i) {
        deleteMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeVideo(String str) throws IllegalAccessException {
        throw new IllegalAccessException("This function is deprecated");
    }
}
