package com.byazt.mg;

import android.annotation.TargetApi;
import android.os.Debug;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 13})
public class tt {
    public static final c c = new C0465tt();

    @com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        private c() {
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int tt(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int ve(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: com.byazt.mg.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 240})
    @TargetApi(19)
    public static class C0465tt extends c {
        private C0465tt() {
            super();
        }

        @Override // com.byazt.mg.tt.c
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.byazt.mg.tt.c
        public int tt(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.byazt.mg.tt.c
        public int ve(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return c.c(memoryInfo);
    }

    public static int tt(Debug.MemoryInfo memoryInfo) {
        return c.tt(memoryInfo);
    }

    public static int ve(Debug.MemoryInfo memoryInfo) {
        return c.ve(memoryInfo);
    }
}
