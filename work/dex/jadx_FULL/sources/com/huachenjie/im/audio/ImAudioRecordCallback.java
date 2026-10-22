package com.huachenjie.im.audio;

import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ImAudioRecordCallback {
    default void a() {
    }

    default void b(long j) {
    }

    default void c(int i) {
    }

    void d(@Nullable File file, long j);
}
