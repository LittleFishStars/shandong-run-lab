package com.kc.dw.player.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {
    public static Bitmap a(String str, boolean z) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Bitmap frameAtTime = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    if (str.trim().toLowerCase().contains("m3u8") || !str.trim().toLowerCase().startsWith("http")) {
                        mediaMetadataRetriever.setDataSource(str);
                    } else {
                        mediaMetadataRetriever.setDataSource(z ? new com.kc.dw.player.datasource.a(str) : new com.kc.dw.player.datasource.b(str, null));
                    }
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                } catch (Throwable th) {
                    th = th;
                    try {
                        LogUtil.e("getFramePictures ERROR:", th.toString());
                        return frameAtTime;
                    } finally {
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                mediaMetadataRetriever = null;
            }
        } catch (Throwable unused2) {
        }
        return frameAtTime;
    }
}
