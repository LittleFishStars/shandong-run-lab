package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface TargetConfig<T> extends ReadableConfig {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Config.Option<String> OPTION_TARGET_NAME = Config.Option.create("camerax.core.target.name", String.class);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Config.Option<Class<?>> OPTION_TARGET_CLASS = Config.Option.create("camerax.core.target.class", Class.class);

    public interface Builder<T, B> {
        @NonNull
        B setTargetClass(@NonNull Class<T> cls);

        @NonNull
        B setTargetName(@NonNull String str);
    }

    @Nullable
    default Class<T> getTargetClass(@Nullable Class<T> cls) {
        return (Class) retrieveOption(OPTION_TARGET_CLASS, cls);
    }

    @Nullable
    default String getTargetName(@Nullable String str) {
        return (String) retrieveOption(OPTION_TARGET_NAME, str);
    }

    @NonNull
    default Class<T> getTargetClass() {
        return (Class) retrieveOption(OPTION_TARGET_CLASS);
    }

    @NonNull
    default String getTargetName() {
        return (String) retrieveOption(OPTION_TARGET_NAME);
    }
}
