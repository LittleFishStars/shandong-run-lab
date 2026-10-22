package androidx.camera.core.impl.quirk;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface ProfileResolutionQuirk extends Quirk {
    @NonNull
    List<Size> getSupportedResolutions();
}
