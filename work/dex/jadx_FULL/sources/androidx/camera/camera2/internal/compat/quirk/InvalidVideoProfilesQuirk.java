package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class InvalidVideoProfilesQuirk implements Quirk {
    static final List<String> AFFECTED_PIXEL_MODELS = Arrays.asList("pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro");

    private static boolean isAffectedPixelBuild() {
        return isTp1aBuild() || isTd1aBuild();
    }

    private static boolean isAffectedPixelDevices() {
        return isAffectedPixelModel() && isAffectedPixelBuild();
    }

    private static boolean isAffectedPixelModel() {
        return AFFECTED_PIXEL_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedSamsungDevices() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && isTp1aBuild();
    }

    private static boolean isTd1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    private static boolean isTp1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    public static boolean load() {
        return isAffectedSamsungDevices() || isAffectedPixelDevices();
    }
}
