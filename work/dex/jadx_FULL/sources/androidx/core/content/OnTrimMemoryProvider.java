package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(@NonNull Consumer<Integer> consumer);

    void removeOnTrimMemoryListener(@NonNull Consumer<Integer> consumer);
}
