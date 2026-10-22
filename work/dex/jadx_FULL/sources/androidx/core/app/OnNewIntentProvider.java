package androidx.core.app;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface OnNewIntentProvider {
    void addOnNewIntentListener(@NonNull Consumer<Intent> consumer);

    void removeOnNewIntentListener(@NonNull Consumer<Intent> consumer);
}
