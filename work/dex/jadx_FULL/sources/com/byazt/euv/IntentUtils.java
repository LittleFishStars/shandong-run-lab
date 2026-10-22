package com.byazt.euv;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT, 1129})
public class IntentUtils {
    public static HashMap<Long, WeakReference<Bundle>> c = new HashMap<>();

    public static void c(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            c(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    @Keep
    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    private static void c(long j, Bundle bundle) {
        c.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void c(Intent intent) {
        Bundle bundleC;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (bundleC = c(longExtra)) == null) {
            return;
        }
        intent.putExtras(bundleC);
    }

    private static Bundle c(long j) {
        WeakReference<Bundle> weakReferenceRemove = c.remove(Long.valueOf(j));
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
