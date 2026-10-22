package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class SizeUtil {
    public static final Size RESOLUTION_ZERO = new Size(0, 0);
    public static final Size RESOLUTION_QVGA = new Size(320, 240);
    public static final Size RESOLUTION_VGA = new Size(640, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
    public static final Size RESOLUTION_480P = new Size(720, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
    public static final Size RESOLUTION_720P = new Size(1280, 720);
    public static final Size RESOLUTION_1080P = new Size(1920, 1080);
    public static final Size RESOLUTION_1440P = new Size(1920, 1440);

    private SizeUtil() {
    }

    public static int getArea(@NonNull Size size) {
        return size.getWidth() * size.getHeight();
    }

    @Nullable
    public static Size getMaxSize(@NonNull List<Size> list) {
        if (list.isEmpty()) {
            return null;
        }
        return (Size) Collections.max(list, new CompareSizesByArea());
    }

    public static boolean isLongerInAnyEdge(@NonNull Size size, @NonNull Size size2) {
        return size.getWidth() > size2.getWidth() || size.getHeight() > size2.getHeight();
    }

    public static boolean isSmallerByArea(@NonNull Size size, @NonNull Size size2) {
        return getArea(size) < getArea(size2);
    }
}
