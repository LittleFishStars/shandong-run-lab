package com.alibaba.sdk.android.vod.upload.common.utils;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.alibaba.sdk.android.vod.upload.model.UserData;
import com.aliyun.vod.common.utils.StringUtils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoInfoUtil {
    private static final String VOD_SOURCE_SHORT_VIDEO = "short_video";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static UserData getVideoBitrate(Context context, String str) throws Throwable {
        MediaMetadataRetriever mediaMetadataRetriever;
        UserData userData = new UserData();
        ?? r1 = 0;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        MediaMetadataRetriever mediaMetadataRetriever3 = null;
        try {
            try {
                MediaMetadataRetriever mediaMetadataRetriever4 = new MediaMetadataRetriever();
                try {
                    boolean zIsUriPath = StringUtils.isUriPath(str);
                    if (zIsUriPath) {
                        mediaMetadataRetriever4.setDataSource(context, Uri.parse(str));
                    } else {
                        mediaMetadataRetriever4.setDataSource(new File(str).getAbsolutePath());
                    }
                    userData.setBitrate(String.valueOf(Integer.parseInt(mediaMetadataRetriever4.extractMetadata(20)) / 1024));
                    userData.setDuration(String.valueOf(Integer.parseInt(mediaMetadataRetriever4.extractMetadata(9)) / 1000));
                    userData.setFps(mediaMetadataRetriever4.extractMetadata(25));
                    userData.setWidth(mediaMetadataRetriever4.extractMetadata(18));
                    userData.setHeight(mediaMetadataRetriever4.extractMetadata(19));
                    userData.setSource(VOD_SOURCE_SHORT_VIDEO);
                    mediaMetadataRetriever4.release();
                    r1 = zIsUriPath;
                } catch (Error e) {
                    e = e;
                    mediaMetadataRetriever2 = mediaMetadataRetriever4;
                    e.printStackTrace();
                    r1 = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever2 != null) {
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        mediaMetadataRetriever.release();
                        r1 = mediaMetadataRetriever;
                    }
                } catch (Exception e2) {
                    e = e2;
                    mediaMetadataRetriever3 = mediaMetadataRetriever4;
                    e.printStackTrace();
                    r1 = mediaMetadataRetriever3;
                    mediaMetadataRetriever = mediaMetadataRetriever3;
                    if (mediaMetadataRetriever3 != null) {
                        mediaMetadataRetriever.release();
                        r1 = mediaMetadataRetriever;
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = mediaMetadataRetriever4;
                    if (r1 != 0) {
                        r1.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Error e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
        return userData;
    }
}
