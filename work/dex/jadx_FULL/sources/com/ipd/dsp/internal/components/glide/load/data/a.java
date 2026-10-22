package com.ipd.dsp.internal.components.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a<T> {

    /* JADX INFO: renamed from: com.ipd.dsp.internal.components.glide.load.data.a$a, reason: collision with other inner class name */
    public interface InterfaceC0870a<T> {
        @NonNull
        a<T> a(@NonNull T t);

        @NonNull
        Class<T> a();
    }

    void b();

    @NonNull
    T c() throws IOException;
}
