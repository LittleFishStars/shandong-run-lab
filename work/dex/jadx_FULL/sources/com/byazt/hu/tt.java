package com.byazt.hu;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 13})
public class tt {
    public static final c c = new C0429tt();

    @com.byazt.zqa.c(c = {0, 1, 1381, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        private c() {
        }

        public <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.hu.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1381, 240})
    @TargetApi(11)
    public static class C0429tt extends c {
        private C0429tt() {
            super();
        }

        @Override // com.byazt.hu.tt.c
        public <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void c(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        c.c(asyncTask, tArr);
    }
}
