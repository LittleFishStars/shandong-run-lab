package androidx.camera.core.internal.utils;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface RingBuffer<T> {

    public interface OnRemoveCallback<T> {
        void onRemove(@NonNull T t);
    }

    @NonNull
    T dequeue();

    void enqueue(@NonNull T t);

    int getMaxCapacity();

    boolean isEmpty();
}
