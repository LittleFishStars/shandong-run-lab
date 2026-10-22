package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface MutableConfig extends Config {
    <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority, @Nullable ValueT valuet);

    <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet);

    @Nullable
    <ValueT> ValueT removeOption(@NonNull Config.Option<ValueT> option);
}
