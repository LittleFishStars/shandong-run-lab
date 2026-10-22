package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
public abstract class SurfaceSizeDefinition {
    @NonNull
    public static SurfaceSizeDefinition create(@NonNull Size size, @NonNull Map<Integer, Size> map, @NonNull Size size2, @NonNull Map<Integer, Size> map2, @NonNull Size size3, @NonNull Map<Integer, Size> map3, @NonNull Map<Integer, Size> map4) {
        return new AutoValue_SurfaceSizeDefinition(size, map, size2, map2, size3, map3, map4);
    }

    @NonNull
    public abstract Size getAnalysisSize();

    @NonNull
    public Size getMaximumSize(int i) {
        return getMaximumSizeMap().get(Integer.valueOf(i));
    }

    @NonNull
    public abstract Map<Integer, Size> getMaximumSizeMap();

    @NonNull
    public abstract Size getPreviewSize();

    @NonNull
    public abstract Size getRecordSize();

    @NonNull
    public Size getS1440pSize(int i) {
        return getS1440pSizeMap().get(Integer.valueOf(i));
    }

    @NonNull
    public abstract Map<Integer, Size> getS1440pSizeMap();

    @NonNull
    public Size getS720pSize(int i) {
        return getS720pSizeMap().get(Integer.valueOf(i));
    }

    @NonNull
    public abstract Map<Integer, Size> getS720pSizeMap();

    @Nullable
    public Size getUltraMaximumSize(int i) {
        return getUltraMaximumSizeMap().get(Integer.valueOf(i));
    }

    @NonNull
    public abstract Map<Integer, Size> getUltraMaximumSizeMap();
}
