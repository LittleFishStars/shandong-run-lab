package androidx.camera.video.internal.encoder;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface TimeProvider {
    long realtimeUs();

    long uptimeUs();
}
