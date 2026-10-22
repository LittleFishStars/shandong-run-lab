package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class PreviewDelayWhenVideoCaptureIsBoundQuirk implements Quirk {
    private static final Set<String> HUAWEI_DEVICE_LIST = new HashSet(Arrays.asList("HWELE", "HW-02L", "HWVOG", "HWYAL", "HWLYA", "HWCOL", "HWPAR"));
    private static final Set<String> HUAWEI_MODEL_LIST = new HashSet(Arrays.asList("ELS-AN00", "ELS-TN00", "ELS-NX9", "ELS-N04"));

    public static boolean load() {
        if ("Huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
            Set<String> set = HUAWEI_DEVICE_LIST;
            String str = Build.DEVICE;
            Locale locale = Locale.US;
            if (set.contains(str.toUpperCase(locale)) || HUAWEI_MODEL_LIST.contains(Build.MODEL.toUpperCase(locale))) {
                return true;
            }
        }
        return false;
    }
}
