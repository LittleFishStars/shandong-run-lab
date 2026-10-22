package androidx.camera.core.impl;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class CaptureConfig {
    public static final int TEMPLATE_TYPE_NONE = -1;
    final List<CameraCaptureCallback> mCameraCaptureCallbacks;

    @Nullable
    private final CameraCaptureResult mCameraCaptureResult;
    final Range<Integer> mExpectedFrameRateRange;
    final Config mImplementationOptions;
    final List<DeferrableSurface> mSurfaces;

    @NonNull
    private final TagBundle mTagBundle;
    final int mTemplateType;
    private final boolean mUseRepeatingSurface;
    public static final Config.Option<Integer> OPTION_ROTATION = Config.Option.create("camerax.core.captureConfig.rotation", Integer.TYPE);
    public static final Config.Option<Integer> OPTION_JPEG_QUALITY = Config.Option.create("camerax.core.captureConfig.jpegQuality", Integer.class);
    private static final Config.Option<Range<Integer>> OPTION_RESOLVED_FRAME_RATE = Config.Option.create("camerax.core.captureConfig.resolvedFrameRate", Range.class);

    public interface OptionUnpacker {
        void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    public CaptureConfig(List<DeferrableSurface> list, Config config, int i, @NonNull Range<Integer> range, List<CameraCaptureCallback> list2, boolean z, @NonNull TagBundle tagBundle, @Nullable CameraCaptureResult cameraCaptureResult) {
        this.mSurfaces = list;
        this.mImplementationOptions = config;
        this.mTemplateType = i;
        this.mExpectedFrameRateRange = range;
        this.mCameraCaptureCallbacks = Collections.unmodifiableList(list2);
        this.mUseRepeatingSurface = z;
        this.mTagBundle = tagBundle;
        this.mCameraCaptureResult = cameraCaptureResult;
    }

    @NonNull
    public static CaptureConfig defaultEmptyCaptureConfig() {
        return new Builder().build();
    }

    @NonNull
    public List<CameraCaptureCallback> getCameraCaptureCallbacks() {
        return this.mCameraCaptureCallbacks;
    }

    @Nullable
    public CameraCaptureResult getCameraCaptureResult() {
        return this.mCameraCaptureResult;
    }

    @NonNull
    public Range<Integer> getExpectedFrameRateRange() {
        Range<Integer> range = (Range) this.mImplementationOptions.retrieveOption(OPTION_RESOLVED_FRAME_RATE, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
        Objects.requireNonNull(range);
        return range;
    }

    @NonNull
    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    @NonNull
    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    @NonNull
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }

    public static final class Builder {
        private List<CameraCaptureCallback> mCameraCaptureCallbacks;

        @Nullable
        private CameraCaptureResult mCameraCaptureResult;
        private Range<Integer> mExpectedFrameRateRange;
        private MutableConfig mImplementationOptions;
        private MutableTagBundle mMutableTagBundle;
        private final Set<DeferrableSurface> mSurfaces;
        private int mTemplateType;
        private boolean mUseRepeatingSurface;

        public Builder() {
            this.mSurfaces = new HashSet();
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mExpectedFrameRateRange = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
        }

        @NonNull
        public static Builder createFrom(@NonNull UseCaseConfig<?> useCaseConfig) {
            OptionUnpacker captureOptionUnpacker = useCaseConfig.getCaptureOptionUnpacker(null);
            if (captureOptionUnpacker != null) {
                Builder builder = new Builder();
                captureOptionUnpacker.unpack(useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
        }

        @NonNull
        public static Builder from(@NonNull CaptureConfig captureConfig) {
            return new Builder(captureConfig);
        }

        public void addAllCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            Iterator<CameraCaptureCallback> it = collection.iterator();
            while (it.hasNext()) {
                addCameraCaptureCallback(it.next());
            }
        }

        public void addAllTags(@NonNull TagBundle tagBundle) {
            this.mMutableTagBundle.addTagBundle(tagBundle);
        }

        public void addCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            if (this.mCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                return;
            }
            this.mCameraCaptureCallbacks.add(cameraCaptureCallback);
        }

        public <T> void addImplementationOption(@NonNull Config.Option<T> option, @NonNull T t) {
            this.mImplementationOptions.insertOption(option, t);
        }

        public void addImplementationOptions(@NonNull Config config) {
            for (Config.Option<?> option : config.listOptions()) {
                Object objRetrieveOption = this.mImplementationOptions.retrieveOption(option, null);
                Object objRetrieveOption2 = config.retrieveOption(option);
                if (objRetrieveOption instanceof MultiValueSet) {
                    ((MultiValueSet) objRetrieveOption).addAll(((MultiValueSet) objRetrieveOption2).getAllItems());
                } else {
                    if (objRetrieveOption2 instanceof MultiValueSet) {
                        objRetrieveOption2 = ((MultiValueSet) objRetrieveOption2).mo14clone();
                    }
                    this.mImplementationOptions.insertOption(option, config.getOptionPriority(option), objRetrieveOption2);
                }
            }
        }

        public void addSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.add(deferrableSurface);
        }

        public void addTag(@NonNull String str, @NonNull Object obj) {
            this.mMutableTagBundle.putTag(str, obj);
        }

        @NonNull
        public CaptureConfig build() {
            return new CaptureConfig(new ArrayList(this.mSurfaces), OptionsBundle.from(this.mImplementationOptions), this.mTemplateType, this.mExpectedFrameRateRange, new ArrayList(this.mCameraCaptureCallbacks), this.mUseRepeatingSurface, TagBundle.from(this.mMutableTagBundle), this.mCameraCaptureResult);
        }

        public void clearSurfaces() {
            this.mSurfaces.clear();
        }

        @Nullable
        public Range<Integer> getExpectedFrameRateRange() {
            return (Range) this.mImplementationOptions.retrieveOption(CaptureConfig.OPTION_RESOLVED_FRAME_RATE, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
        }

        @NonNull
        public Config getImplementationOptions() {
            return this.mImplementationOptions;
        }

        @NonNull
        public Set<DeferrableSurface> getSurfaces() {
            return this.mSurfaces;
        }

        @Nullable
        public Object getTag(@NonNull String str) {
            return this.mMutableTagBundle.getTag(str);
        }

        public int getTemplateType() {
            return this.mTemplateType;
        }

        public boolean isUseRepeatingSurface() {
            return this.mUseRepeatingSurface;
        }

        public boolean removeCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            return this.mCameraCaptureCallbacks.remove(cameraCaptureCallback);
        }

        public void removeSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.remove(deferrableSurface);
        }

        public void setCameraCaptureResult(@NonNull CameraCaptureResult cameraCaptureResult) {
            this.mCameraCaptureResult = cameraCaptureResult;
        }

        public void setExpectedFrameRateRange(@NonNull Range<Integer> range) {
            addImplementationOption(CaptureConfig.OPTION_RESOLVED_FRAME_RATE, range);
        }

        public void setImplementationOptions(@NonNull Config config) {
            this.mImplementationOptions = MutableOptionsBundle.from(config);
        }

        public void setTemplateType(int i) {
            this.mTemplateType = i;
        }

        public void setUseRepeatingSurface(boolean z) {
            this.mUseRepeatingSurface = z;
        }

        private Builder(CaptureConfig captureConfig) {
            HashSet hashSet = new HashSet();
            this.mSurfaces = hashSet;
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mExpectedFrameRateRange = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mMutableTagBundle = MutableTagBundle.create();
            hashSet.addAll(captureConfig.mSurfaces);
            this.mImplementationOptions = MutableOptionsBundle.from(captureConfig.mImplementationOptions);
            this.mTemplateType = captureConfig.mTemplateType;
            this.mExpectedFrameRateRange = captureConfig.mExpectedFrameRateRange;
            this.mCameraCaptureCallbacks.addAll(captureConfig.getCameraCaptureCallbacks());
            this.mUseRepeatingSurface = captureConfig.isUseRepeatingSurface();
            this.mMutableTagBundle = MutableTagBundle.from(captureConfig.getTagBundle());
        }
    }
}
