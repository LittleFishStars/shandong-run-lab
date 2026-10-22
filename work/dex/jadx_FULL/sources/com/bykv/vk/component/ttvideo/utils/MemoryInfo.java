package com.bykv.vk.component.ttvideo.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.m;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class MemoryInfo {
    private static long[] mRomMemroy;
    private static long mTotalMemorySize;

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static long[] getRomMemroy() {
        if (mRomMemroy == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mRomMemroy = new long[]{getTotalInternalMemorySize(), ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())};
        }
        return mRomMemroy;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static long getTolalMemory() throws Throwable {
        BufferedReader bufferedReader;
        String str = null;
        str = null;
        str = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8);
                try {
                    try {
                        String line = bufferedReader.readLine();
                        str = line != null ? line : null;
                        bufferedReader.close();
                    } catch (Exception e) {
                        e = e;
                        m.c(e);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim());
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e2) {
                            m.c(e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                m.c(e3);
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        return Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim());
    }

    public static long getTotalInternalMemorySize() {
        if (mTotalMemorySize == 0) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mTotalMemorySize = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        }
        return mTotalMemorySize;
    }
}
