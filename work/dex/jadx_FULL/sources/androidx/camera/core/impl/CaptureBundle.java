package androidx.camera.core.impl;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface CaptureBundle {
    @Nullable
    List<CaptureStage> getCaptureStages();
}
