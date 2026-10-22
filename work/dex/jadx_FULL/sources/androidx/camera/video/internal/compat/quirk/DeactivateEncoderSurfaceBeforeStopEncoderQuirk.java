package androidx.camera.video.internal.compat.quirk;

import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class DeactivateEncoderSurfaceBeforeStopEncoderQuirk implements Quirk {
    public static boolean load() {
        return false;
    }
}
