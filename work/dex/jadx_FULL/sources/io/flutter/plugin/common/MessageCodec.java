package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface MessageCodec<T> {
    @Nullable
    T decodeMessage(@Nullable ByteBuffer byteBuffer);

    @Nullable
    ByteBuffer encodeMessage(@Nullable T t);
}
