package androidx.camera.core.streamsharing;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
class ResolutionUtils {
    private ResolutionUtils() {
    }

    public static List<Size> getMergedResolutions(@NonNull List<Size> list, @NonNull Size size, @NonNull Set<UseCaseConfig<?>> set) {
        Iterator<UseCaseConfig<?>> it = set.iterator();
        while (it.hasNext()) {
            List<Size> list2 = (List) it.next().retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, null);
            if (list2 != null) {
                return list2;
            }
        }
        return list;
    }
}
