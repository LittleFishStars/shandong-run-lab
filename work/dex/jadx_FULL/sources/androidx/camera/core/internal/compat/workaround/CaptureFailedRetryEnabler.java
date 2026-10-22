package androidx.camera.core.internal.compat.workaround;

import androidx.annotation.RequiresApi;
import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class CaptureFailedRetryEnabler {
    private final CaptureFailedRetryQuirk mCaptureFailedRetryQuirk = (CaptureFailedRetryQuirk) DeviceQuirks.get(CaptureFailedRetryQuirk.class);

    public int getRetryCount() {
        CaptureFailedRetryQuirk captureFailedRetryQuirk = this.mCaptureFailedRetryQuirk;
        if (captureFailedRetryQuirk == null) {
            return 0;
        }
        return captureFailedRetryQuirk.getRetryCount();
    }
}
