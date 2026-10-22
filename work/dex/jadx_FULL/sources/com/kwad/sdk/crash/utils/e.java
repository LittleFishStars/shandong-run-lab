package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    private static Context aWI;

    @WorkerThread
    public static long Nk() {
        long jBZ = bZ(aWI);
        b(aWI, 1 + jBZ);
        return jBZ;
    }

    @WorkerThread
    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        editorEdit.putLong("crashseq", j);
        return editorEdit.commit();
    }

    @WorkerThread
    private static long bZ(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    public static void init(Context context) {
        aWI = context;
    }
}
