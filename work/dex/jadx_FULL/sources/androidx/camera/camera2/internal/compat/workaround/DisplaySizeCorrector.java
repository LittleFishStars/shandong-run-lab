package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class DisplaySizeCorrector {

    @Nullable
    private final SmallDisplaySizeQuirk mSmallDisplaySizeQuirk = (SmallDisplaySizeQuirk) DeviceQuirks.get(SmallDisplaySizeQuirk.class);

    @Nullable
    public Size getDisplaySize() {
        SmallDisplaySizeQuirk smallDisplaySizeQuirk = this.mSmallDisplaySizeQuirk;
        if (smallDisplaySizeQuirk != null) {
            return smallDisplaySizeQuirk.getDisplaySize();
        }
        return null;
    }
}
