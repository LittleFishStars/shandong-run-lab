package androidx.core.content;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface OnConfigurationChangedProvider {
    void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer);

    void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer);
}
