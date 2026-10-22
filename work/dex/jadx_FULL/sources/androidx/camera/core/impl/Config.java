package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.ResolutionSelectorUtil;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import com.google.auto.value.AutoValue;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface Config {

    @AutoValue
    public static abstract class Option<T> {
        @NonNull
        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls) {
            return create(str, cls, null);
        }

        @NonNull
        public abstract String getId();

        @Nullable
        public abstract Object getToken();

        @NonNull
        public abstract Class<T> getValueClass();

        @NonNull
        public static <T> Option<T> create(@NonNull String str, @NonNull Class<?> cls, @Nullable Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }
    }

    public interface OptionMatcher {
        boolean onOptionMatched(@NonNull Option<?> option);
    }

    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    static boolean hasConflict(@NonNull OptionPriority optionPriority, @NonNull OptionPriority optionPriority2) {
        OptionPriority optionPriority3 = OptionPriority.ALWAYS_OVERRIDE;
        if (optionPriority == optionPriority3 && optionPriority2 == optionPriority3) {
            return true;
        }
        OptionPriority optionPriority4 = OptionPriority.REQUIRED;
        return optionPriority == optionPriority4 && optionPriority2 == optionPriority4;
    }

    @NonNull
    static Config mergeConfigs(@Nullable Config config, @Nullable Config config2) {
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        MutableOptionsBundle mutableOptionsBundleFrom = config2 != null ? MutableOptionsBundle.from(config2) : MutableOptionsBundle.create();
        if (config != null) {
            Iterator<Option<?>> it = config.listOptions().iterator();
            while (it.hasNext()) {
                mergeOptionValue(mutableOptionsBundleFrom, config2, config, it.next());
            }
        }
        return OptionsBundle.from(mutableOptionsBundleFrom);
    }

    static void mergeOptionValue(@NonNull MutableOptionsBundle mutableOptionsBundle, @NonNull Config config, @NonNull Config config2, @NonNull Option<?> option) {
        if (!Objects.equals(option, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), config2.retrieveOption(option));
            return;
        }
        ResolutionSelector resolutionSelector = (ResolutionSelector) config2.retrieveOption(option, null);
        mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), ResolutionSelectorUtil.overrideResolutionSelectors((ResolutionSelector) config.retrieveOption(option, null), resolutionSelector));
    }

    boolean containsOption(@NonNull Option<?> option);

    void findOptions(@NonNull String str, @NonNull OptionMatcher optionMatcher);

    @NonNull
    OptionPriority getOptionPriority(@NonNull Option<?> option);

    @NonNull
    Set<OptionPriority> getPriorities(@NonNull Option<?> option);

    @NonNull
    Set<Option<?>> listOptions();

    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option);

    @Nullable
    <ValueT> ValueT retrieveOption(@NonNull Option<ValueT> option, @Nullable ValueT valuet);

    @Nullable
    <ValueT> ValueT retrieveOptionWithPriority(@NonNull Option<ValueT> option, @NonNull OptionPriority optionPriority);
}
