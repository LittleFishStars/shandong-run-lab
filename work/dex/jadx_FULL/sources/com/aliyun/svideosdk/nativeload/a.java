package com.aliyun.svideosdk.nativeload;

import android.util.Log;
import com.aliyun.svideosdk.AlivcSdkCore;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a {
    public static final String SHARED_LIBRARY_FACE_AR_INTERFACE = "AliFaceAREngine";
    public static final String SHARED_LIBRARY_FFMPEG_NAME = "alivcffmpeg";
    public static final String SHARED_LIBRARY_SVIDEO_CORE = "ugsv";

    static {
        loadLibrary();
    }

    public static void loadLibrary() {
        loadLocalLibrary(SHARED_LIBRARY_FFMPEG_NAME);
        loadLocalLibrary("all_in_one");
    }

    public static void loadLocalLibrary(String str) {
        Log.d("AliYunLog", "loadLocalLibrary, AlivcSdkCore.APP_PRIVATE_DIR = " + AlivcSdkCore.APP_PRIVATE_DIR);
        Log.d("AliYunLog", "Load internal library:" + str);
        try {
            System.loadLibrary(str);
        } catch (Throwable th) {
            Log.e("AliYunLog", "Load .so failed!", th);
        }
    }
}
