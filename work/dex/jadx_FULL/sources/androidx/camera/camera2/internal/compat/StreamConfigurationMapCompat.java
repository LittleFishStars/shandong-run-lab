package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class StreamConfigurationMapCompat {
    private static final String TAG = "StreamConfigurationMapCompat";
    private final StreamConfigurationMapCompatImpl mImpl;
    private final OutputSizesCorrector mOutputSizesCorrector;
    private final Map<Integer, Size[]> mCachedFormatOutputSizes = new HashMap();
    private final Map<Integer, Size[]> mCachedFormatHighResolutionOutputSizes = new HashMap();
    private final Map<Class<?>, Size[]> mCachedClassOutputSizes = new HashMap();

    public interface StreamConfigurationMapCompatImpl {
        @Nullable
        Size[] getHighResolutionOutputSizes(int i);

        @Nullable
        Size[] getOutputSizes(int i);

        @Nullable
        <T> Size[] getOutputSizes(@NonNull Class<T> cls);

        @NonNull
        StreamConfigurationMap unwrap();
    }

    private StreamConfigurationMapCompat(@NonNull StreamConfigurationMap streamConfigurationMap, @NonNull OutputSizesCorrector outputSizesCorrector) {
        this.mImpl = new StreamConfigurationMapCompatApi23Impl(streamConfigurationMap);
        this.mOutputSizesCorrector = outputSizesCorrector;
    }

    @NonNull
    public static StreamConfigurationMapCompat toStreamConfigurationMapCompat(@NonNull StreamConfigurationMap streamConfigurationMap, @NonNull OutputSizesCorrector outputSizesCorrector) {
        return new StreamConfigurationMapCompat(streamConfigurationMap, outputSizesCorrector);
    }

    @Nullable
    public Size[] getHighResolutionOutputSizes(int i) {
        if (this.mCachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(i))) {
            if (this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i)).clone();
        }
        Size[] highResolutionOutputSizes = this.mImpl.getHighResolutionOutputSizes(i);
        if (highResolutionOutputSizes != null && highResolutionOutputSizes.length > 0) {
            highResolutionOutputSizes = this.mOutputSizesCorrector.applyQuirks(highResolutionOutputSizes, i);
        }
        this.mCachedFormatHighResolutionOutputSizes.put(Integer.valueOf(i), highResolutionOutputSizes);
        if (highResolutionOutputSizes != null) {
            return (Size[]) highResolutionOutputSizes.clone();
        }
        return null;
    }

    @Nullable
    public Size[] getOutputSizes(int i) {
        if (this.mCachedFormatOutputSizes.containsKey(Integer.valueOf(i))) {
            if (this.mCachedFormatOutputSizes.get(Integer.valueOf(i)) == null) {
                return null;
            }
            return (Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(i)).clone();
        }
        Size[] outputSizes = this.mImpl.getOutputSizes(i);
        if (outputSizes != null && outputSizes.length != 0) {
            Size[] sizeArrApplyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, i);
            this.mCachedFormatOutputSizes.put(Integer.valueOf(i), sizeArrApplyQuirks);
            return (Size[]) sizeArrApplyQuirks.clone();
        }
        Logger.w(TAG, "Retrieved output sizes array is null or empty for format " + i);
        return outputSizes;
    }

    @NonNull
    public StreamConfigurationMap toStreamConfigurationMap() {
        return this.mImpl.unwrap();
    }

    @Nullable
    public <T> Size[] getOutputSizes(@NonNull Class<T> cls) {
        if (this.mCachedClassOutputSizes.containsKey(cls)) {
            if (this.mCachedClassOutputSizes.get(cls) == null) {
                return null;
            }
            return (Size[]) this.mCachedClassOutputSizes.get(cls).clone();
        }
        Size[] outputSizes = this.mImpl.getOutputSizes(cls);
        if (outputSizes != null && outputSizes.length != 0) {
            Size[] sizeArrApplyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, cls);
            this.mCachedClassOutputSizes.put(cls, sizeArrApplyQuirks);
            return (Size[]) sizeArrApplyQuirks.clone();
        }
        Logger.w(TAG, "Retrieved output sizes array is null or empty for class " + cls);
        return outputSizes;
    }
}
