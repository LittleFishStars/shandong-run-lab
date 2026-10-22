package com.byazt.nr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 499})
public abstract class yv {
    public final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Runnable>> c = new ConcurrentHashMap<>();

    public void c(int i, int i2, Runnable runnable) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap = this.c.get(Integer.valueOf(i));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.c.put(Integer.valueOf(i), concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(i2), runnable);
    }

    public abstract boolean c(int i);

    public void tt(int i) {
        this.c.remove(Integer.valueOf(i));
    }

    public void ve(int i) {
        Runnable value;
        ConcurrentHashMap<Integer, Runnable> concurrentHashMapRemove = this.c.remove(Integer.valueOf(i));
        if (concurrentHashMapRemove != null) {
            for (Map.Entry<Integer, Runnable> entry : concurrentHashMapRemove.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.run();
                }
            }
        }
    }

    public void c(int i, int i2) {
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap;
        if (i <= 0 || i2 <= 0 || (concurrentHashMap = this.c.get(Integer.valueOf(i))) == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(i2));
    }
}
