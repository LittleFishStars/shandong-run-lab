package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface MethodCodec {
    @NonNull
    Object decodeEnvelope(@NonNull ByteBuffer byteBuffer);

    @NonNull
    MethodCall decodeMethodCall(@NonNull ByteBuffer byteBuffer);

    @NonNull
    ByteBuffer encodeErrorEnvelope(@NonNull String str, @Nullable String str2, @Nullable Object obj);

    @NonNull
    ByteBuffer encodeErrorEnvelopeWithStacktrace(@NonNull String str, @Nullable String str2, @Nullable Object obj, @Nullable String str3);

    @NonNull
    ByteBuffer encodeMethodCall(@NonNull MethodCall methodCall);

    @NonNull
    ByteBuffer encodeSuccessEnvelope(@Nullable Object obj);
}
