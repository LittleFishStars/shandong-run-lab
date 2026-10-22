package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
public abstract class AttachedSurfaceInfo {
    @NonNull
    public static AttachedSurfaceInfo create(@NonNull SurfaceConfig surfaceConfig, int i, @NonNull Size size, @NonNull DynamicRange dynamicRange, @NonNull List<UseCaseConfigFactory.CaptureType> list, @Nullable Config config, @Nullable Range<Integer> range) {
        return new AutoValue_AttachedSurfaceInfo(surfaceConfig, i, size, dynamicRange, list, config, range);
    }

    @NonNull
    public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

    @NonNull
    public abstract DynamicRange getDynamicRange();

    public abstract int getImageFormat();

    @Nullable
    public abstract Config getImplementationOptions();

    @NonNull
    public abstract Size getSize();

    @NonNull
    public abstract SurfaceConfig getSurfaceConfig();

    @Nullable
    public abstract Range<Integer> getTargetFrameRate();

    @NonNull
    public StreamSpec toStreamSpec(@NonNull Config config) {
        StreamSpec.Builder implementationOptions = StreamSpec.builder(getSize()).setDynamicRange(getDynamicRange()).setImplementationOptions(config);
        if (getTargetFrameRate() != null) {
            implementationOptions.setExpectedFrameRateRange(getTargetFrameRate());
        }
        return implementationOptions.build();
    }
}
