package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class SessionConfig {
    private final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
    private final List<ErrorListener> mErrorListeners;

    @Nullable
    private InputConfiguration mInputConfiguration;
    private final List<OutputConfig> mOutputConfigs;
    private final CaptureConfig mRepeatingCaptureConfig;
    private final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
    private final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;

    public static class BaseBuilder {

        @Nullable
        InputConfiguration mInputConfiguration;
        final Set<OutputConfig> mOutputConfigs = new LinkedHashSet();
        final CaptureConfig.Builder mCaptureConfigBuilder = new CaptureConfig.Builder();
        final List<CameraDevice.StateCallback> mDeviceStateCallbacks = new ArrayList();
        final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks = new ArrayList();
        final List<ErrorListener> mErrorListeners = new ArrayList();
        final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks = new ArrayList();
    }

    public static class Builder extends BaseBuilder {
        @NonNull
        public static Builder createFrom(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Size size) {
            OptionUnpacker sessionOptionUnpacker = useCaseConfig.getSessionOptionUnpacker(null);
            if (sessionOptionUnpacker != null) {
                Builder builder = new Builder();
                sessionOptionUnpacker.unpack(size, useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
        }

        @NonNull
        public Builder addAllCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            for (CameraCaptureCallback cameraCaptureCallback : collection) {
                this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
                if (!this.mSingleCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                    this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
                }
            }
            return this;
        }

        @NonNull
        public Builder addAllDeviceStateCallbacks(@NonNull Collection<CameraDevice.StateCallback> collection) {
            Iterator<CameraDevice.StateCallback> it = collection.iterator();
            while (it.hasNext()) {
                addDeviceStateCallback(it.next());
            }
            return this;
        }

        @NonNull
        public Builder addAllRepeatingCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
            return this;
        }

        @NonNull
        public Builder addAllSessionStateCallbacks(@NonNull List<CameraCaptureSession.StateCallback> list) {
            Iterator<CameraCaptureSession.StateCallback> it = list.iterator();
            while (it.hasNext()) {
                addSessionStateCallback(it.next());
            }
            return this;
        }

        @NonNull
        public Builder addCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
            if (!this.mSingleCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
            }
            return this;
        }

        @NonNull
        public Builder addDeviceStateCallback(@NonNull CameraDevice.StateCallback stateCallback) {
            if (this.mDeviceStateCallbacks.contains(stateCallback)) {
                return this;
            }
            this.mDeviceStateCallbacks.add(stateCallback);
            return this;
        }

        @NonNull
        public Builder addErrorListener(@NonNull ErrorListener errorListener) {
            this.mErrorListeners.add(errorListener);
            return this;
        }

        @NonNull
        public Builder addImplementationOptions(@NonNull Config config) {
            this.mCaptureConfigBuilder.addImplementationOptions(config);
            return this;
        }

        @NonNull
        public Builder addNonRepeatingSurface(@NonNull DeferrableSurface deferrableSurface) {
            return addNonRepeatingSurface(deferrableSurface, DynamicRange.SDR);
        }

        @NonNull
        public Builder addOutputConfig(@NonNull OutputConfig outputConfig) {
            this.mOutputConfigs.add(outputConfig);
            this.mCaptureConfigBuilder.addSurface(outputConfig.getSurface());
            Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
            while (it.hasNext()) {
                this.mCaptureConfigBuilder.addSurface(it.next());
            }
            return this;
        }

        @NonNull
        public Builder addRepeatingCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
            return this;
        }

        @NonNull
        public Builder addSessionStateCallback(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            if (this.mSessionStateCallbacks.contains(stateCallback)) {
                return this;
            }
            this.mSessionStateCallbacks.add(stateCallback);
            return this;
        }

        @NonNull
        public Builder addSurface(@NonNull DeferrableSurface deferrableSurface) {
            return addSurface(deferrableSurface, DynamicRange.SDR);
        }

        @NonNull
        public Builder addTag(@NonNull String str, @NonNull Object obj) {
            this.mCaptureConfigBuilder.addTag(str, obj);
            return this;
        }

        @NonNull
        public SessionConfig build() {
            return new SessionConfig(new ArrayList(this.mOutputConfigs), new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), new ArrayList(this.mErrorListeners), this.mCaptureConfigBuilder.build(), this.mInputConfiguration);
        }

        @NonNull
        public Builder clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
            return this;
        }

        @NonNull
        public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
            return Collections.unmodifiableList(this.mSingleCameraCaptureCallbacks);
        }

        public boolean removeCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            return this.mCaptureConfigBuilder.removeCameraCaptureCallback(cameraCaptureCallback) || this.mSingleCameraCaptureCallbacks.remove(cameraCaptureCallback);
        }

        @NonNull
        public Builder removeSurface(@NonNull DeferrableSurface deferrableSurface) {
            OutputConfig next;
            Iterator<OutputConfig> it = this.mOutputConfigs.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.getSurface().equals(deferrableSurface));
            if (next != null) {
                this.mOutputConfigs.remove(next);
            }
            this.mCaptureConfigBuilder.removeSurface(deferrableSurface);
            return this;
        }

        @NonNull
        public Builder setExpectedFrameRateRange(@NonNull Range<Integer> range) {
            this.mCaptureConfigBuilder.setExpectedFrameRateRange(range);
            return this;
        }

        @NonNull
        public Builder setImplementationOptions(@NonNull Config config) {
            this.mCaptureConfigBuilder.setImplementationOptions(config);
            return this;
        }

        @NonNull
        public Builder setInputConfiguration(@Nullable InputConfiguration inputConfiguration) {
            this.mInputConfiguration = inputConfiguration;
            return this;
        }

        @NonNull
        public Builder setTemplateType(int i) {
            this.mCaptureConfigBuilder.setTemplateType(i);
            return this;
        }

        @NonNull
        public Builder addNonRepeatingSurface(@NonNull DeferrableSurface deferrableSurface, @NonNull DynamicRange dynamicRange) {
            this.mOutputConfigs.add(OutputConfig.builder(deferrableSurface).setDynamicRange(dynamicRange).build());
            return this;
        }

        @NonNull
        public Builder addSurface(@NonNull DeferrableSurface deferrableSurface, @NonNull DynamicRange dynamicRange) {
            this.mOutputConfigs.add(OutputConfig.builder(deferrableSurface).setDynamicRange(dynamicRange).build());
            this.mCaptureConfigBuilder.addSurface(deferrableSurface);
            return this;
        }
    }

    public interface ErrorListener {
        void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionError sessionError);
    }

    public interface OptionUnpacker {
        void unpack(@NonNull Size size, @NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    @AutoValue
    public static abstract class OutputConfig {
        public static final int SURFACE_GROUP_ID_NONE = -1;

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract OutputConfig build();

            @NonNull
            public abstract Builder setDynamicRange(@NonNull DynamicRange dynamicRange);

            @NonNull
            public abstract Builder setPhysicalCameraId(@Nullable String str);

            @NonNull
            public abstract Builder setSharedSurfaces(@NonNull List<DeferrableSurface> list);

            @NonNull
            public abstract Builder setSurface(@NonNull DeferrableSurface deferrableSurface);

            @NonNull
            public abstract Builder setSurfaceGroupId(int i);
        }

        @NonNull
        public static Builder builder(@NonNull DeferrableSurface deferrableSurface) {
            return new AutoValue_SessionConfig_OutputConfig.Builder().setSurface(deferrableSurface).setSharedSurfaces(Collections.emptyList()).setPhysicalCameraId(null).setSurfaceGroupId(-1).setDynamicRange(DynamicRange.SDR);
        }

        @NonNull
        public abstract DynamicRange getDynamicRange();

        @Nullable
        public abstract String getPhysicalCameraId();

        @NonNull
        public abstract List<DeferrableSurface> getSharedSurfaces();

        @NonNull
        public abstract DeferrableSurface getSurface();

        public abstract int getSurfaceGroupId();
    }

    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    public static final class ValidatingBuilder extends BaseBuilder {
        private static final List<Integer> SUPPORTED_TEMPLATE_PRIORITY = Arrays.asList(1, 5, 3);
        private static final String TAG = "ValidatingBuilder";
        private final SurfaceSorter mSurfaceSorter = new SurfaceSorter();
        private boolean mValid = true;
        private boolean mTemplateSet = false;

        private List<DeferrableSurface> getSurfaces() {
            ArrayList arrayList = new ArrayList();
            for (OutputConfig outputConfig : this.mOutputConfigs) {
                arrayList.add(outputConfig.getSurface());
                Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            return arrayList;
        }

        private int selectTemplateType(int i, int i2) {
            List<Integer> list = SUPPORTED_TEMPLATE_PRIORITY;
            return list.indexOf(Integer.valueOf(i)) >= list.indexOf(Integer.valueOf(i2)) ? i : i2;
        }

        private void setOrVerifyExpectFrameRateRange(@NonNull Range<Integer> range) {
            Range<Integer> range2 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            if (range.equals(range2)) {
                return;
            }
            if (this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(range2)) {
                this.mCaptureConfigBuilder.setExpectedFrameRateRange(range);
            } else {
                if (this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(range)) {
                    return;
                }
                this.mValid = false;
                Logger.d(TAG, "Different ExpectedFrameRateRange values");
            }
        }

        public void add(@NonNull SessionConfig sessionConfig) {
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            if (repeatingCaptureConfig.getTemplateType() != -1) {
                this.mTemplateSet = true;
                this.mCaptureConfigBuilder.setTemplateType(selectTemplateType(repeatingCaptureConfig.getTemplateType(), this.mCaptureConfigBuilder.getTemplateType()));
            }
            setOrVerifyExpectFrameRateRange(repeatingCaptureConfig.getExpectedFrameRateRange());
            this.mCaptureConfigBuilder.addAllTags(sessionConfig.getRepeatingCaptureConfig().getTagBundle());
            this.mDeviceStateCallbacks.addAll(sessionConfig.getDeviceStateCallbacks());
            this.mSessionStateCallbacks.addAll(sessionConfig.getSessionStateCallbacks());
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(sessionConfig.getRepeatingCameraCaptureCallbacks());
            this.mSingleCameraCaptureCallbacks.addAll(sessionConfig.getSingleCameraCaptureCallbacks());
            this.mErrorListeners.addAll(sessionConfig.getErrorListeners());
            if (sessionConfig.getInputConfiguration() != null) {
                this.mInputConfiguration = sessionConfig.getInputConfiguration();
            }
            this.mOutputConfigs.addAll(sessionConfig.getOutputConfigs());
            this.mCaptureConfigBuilder.getSurfaces().addAll(repeatingCaptureConfig.getSurfaces());
            if (!getSurfaces().containsAll(this.mCaptureConfigBuilder.getSurfaces())) {
                Logger.d(TAG, "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.mValid = false;
            }
            this.mCaptureConfigBuilder.addImplementationOptions(repeatingCaptureConfig.getImplementationOptions());
        }

        public <T> void addImplementationOption(@NonNull Config.Option<T> option, @NonNull T t) {
            this.mCaptureConfigBuilder.addImplementationOption(option, t);
        }

        @NonNull
        public SessionConfig build() {
            if (!this.mValid) {
                throw new IllegalArgumentException("Unsupported session configuration combination");
            }
            ArrayList arrayList = new ArrayList(this.mOutputConfigs);
            this.mSurfaceSorter.sort(arrayList);
            return new SessionConfig(arrayList, new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), new ArrayList(this.mErrorListeners), this.mCaptureConfigBuilder.build(), this.mInputConfiguration);
        }

        public void clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
        }

        public boolean isValid() {
            return this.mTemplateSet && this.mValid;
        }
    }

    public SessionConfig(List<OutputConfig> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<CameraCaptureCallback> list4, List<ErrorListener> list5, CaptureConfig captureConfig, @Nullable InputConfiguration inputConfiguration) {
        this.mOutputConfigs = list;
        this.mDeviceStateCallbacks = Collections.unmodifiableList(list2);
        this.mSessionStateCallbacks = Collections.unmodifiableList(list3);
        this.mSingleCameraCaptureCallbacks = Collections.unmodifiableList(list4);
        this.mErrorListeners = Collections.unmodifiableList(list5);
        this.mRepeatingCaptureConfig = captureConfig;
        this.mInputConfiguration = inputConfiguration;
    }

    @NonNull
    public static SessionConfig defaultEmptySessionConfig() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new ArrayList(0), new CaptureConfig.Builder().build(), null);
    }

    @NonNull
    public List<CameraDevice.StateCallback> getDeviceStateCallbacks() {
        return this.mDeviceStateCallbacks;
    }

    @NonNull
    public List<ErrorListener> getErrorListeners() {
        return this.mErrorListeners;
    }

    @NonNull
    public Range<Integer> getExpectedFrameRateRange() {
        return this.mRepeatingCaptureConfig.getExpectedFrameRateRange();
    }

    @NonNull
    public Config getImplementationOptions() {
        return this.mRepeatingCaptureConfig.getImplementationOptions();
    }

    @Nullable
    public InputConfiguration getInputConfiguration() {
        return this.mInputConfiguration;
    }

    @NonNull
    public List<OutputConfig> getOutputConfigs() {
        return this.mOutputConfigs;
    }

    @NonNull
    public List<CameraCaptureCallback> getRepeatingCameraCaptureCallbacks() {
        return this.mRepeatingCaptureConfig.getCameraCaptureCallbacks();
    }

    @NonNull
    public CaptureConfig getRepeatingCaptureConfig() {
        return this.mRepeatingCaptureConfig;
    }

    @NonNull
    public List<CameraCaptureSession.StateCallback> getSessionStateCallbacks() {
        return this.mSessionStateCallbacks;
    }

    @NonNull
    public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
        return this.mSingleCameraCaptureCallbacks;
    }

    @NonNull
    public List<DeferrableSurface> getSurfaces() {
        ArrayList arrayList = new ArrayList();
        for (OutputConfig outputConfig : this.mOutputConfigs) {
            arrayList.add(outputConfig.getSurface());
            Iterator<DeferrableSurface> it = outputConfig.getSharedSurfaces().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int getTemplateType() {
        return this.mRepeatingCaptureConfig.getTemplateType();
    }
}
