package com.ipd.dsp.internal.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a {

    /* JADX INFO: renamed from: com.ipd.dsp.internal.k.a$a, reason: collision with other inner class name */
    public interface InterfaceC0888a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f38369a = 262144000;
        public static final String b = "ipd_image_manager_disk_cache";

        @Nullable
        a build();
    }

    public interface b {
        boolean a(@NonNull File file);
    }

    void a(com.ipd.dsp.internal.f.f fVar);

    void a(com.ipd.dsp.internal.f.f fVar, b bVar);

    @Nullable
    File b(com.ipd.dsp.internal.f.f fVar);

    void clear();
}
