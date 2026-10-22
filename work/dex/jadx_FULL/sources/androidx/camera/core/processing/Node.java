package androidx.camera.core.processing;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface Node<I, O> {
    void release();

    @NonNull
    @MainThread
    O transform(@NonNull I i);
}
