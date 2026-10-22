package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class ExtraSupportedOutputSizeQuirk implements Quirk {
    @NonNull
    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(1920, 1080), new Size(1440, 1080), new Size(1280, 720), new Size(960, 720), new Size(864, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH), new Size(720, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH)};
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    @NonNull
    public Size[] getExtraSupportedResolutions(int i) {
        return (i == 34 && isMotoE5Play()) ? getMotoE5PlayExtraSupportedResolutions() : new Size[0];
    }

    @NonNull
    public <T> Size[] getExtraSupportedResolutions(@NonNull Class<T> cls) {
        return (StreamConfigurationMap.isOutputSupportedFor(cls) && isMotoE5Play()) ? getMotoE5PlayExtraSupportedResolutions() : new Size[0];
    }
}
