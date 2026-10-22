package com.alibaba.triver.embed.video.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {
    public static long a(String str) {
        try {
            if (!new File(str).exists()) {
                return 0L;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            return e(strExtractMetadata);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String b(String str) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(24);
        RVLogger.d("getVideoInf", "rotation:" + strExtractMetadata);
        mediaMetadataRetriever.release();
        return strExtractMetadata;
    }

    public static boolean c(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static float d(String str) {
        try {
            return Float.valueOf(Float.parseFloat(str)).floatValue();
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static long e(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return -1L;
        }
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
