package com.byazt.mg;

import android.annotation.TargetApi;
import android.app.ActivityManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 91})
public class sp {
    public static final c c = new tt();

    @com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 180})
    public static class c {
        private c() {
        }

        public long c(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 904})
    @TargetApi(16)
    public static class tt extends c {
        private tt() {
            super();
        }

        @Override // com.byazt.mg.sp.c
        public long c(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long c(ActivityManager.MemoryInfo memoryInfo) {
        return c.c(memoryInfo);
    }
}
