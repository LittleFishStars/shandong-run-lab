package androidx.camera.core.resolutionselector;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface ResolutionFilter {
    @NonNull
    List<Size> filter(@NonNull List<Size> list, int i);
}
