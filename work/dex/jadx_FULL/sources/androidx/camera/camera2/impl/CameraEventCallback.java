package androidx.camera.camera2.impl;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public abstract class CameraEventCallback {
    public void onDeInitSession() {
    }

    @Nullable
    public CaptureConfig onDisableSession() {
        return null;
    }

    @Nullable
    public CaptureConfig onEnableSession() {
        return null;
    }

    @Nullable
    public CaptureConfig onInitSession() {
        return null;
    }

    @Nullable
    public CaptureConfig onRepeating() {
        return null;
    }
}
