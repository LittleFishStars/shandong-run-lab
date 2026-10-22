package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import io.flutter.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class StandardMethodCodec implements MethodCodec {
    public static final StandardMethodCodec INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);
    private final StandardMessageCodec messageCodec;

    public StandardMethodCodec(@NonNull StandardMessageCodec standardMessageCodec) {
        this.messageCodec = standardMessageCodec;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public Object decodeEnvelope(@NonNull ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byte b = byteBuffer.get();
        if (b != 0) {
            if (b == 1) {
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        Object value = this.messageCodec.readValue(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return value;
        }
        Object value2 = this.messageCodec.readValue(byteBuffer);
        Object value3 = this.messageCodec.readValue(byteBuffer);
        Object value4 = this.messageCodec.readValue(byteBuffer);
        if ((value2 instanceof String) && ((value3 == null || (value3 instanceof String)) && !byteBuffer.hasRemaining())) {
            throw new FlutterException((String) value2, (String) value3, value4);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public MethodCall decodeMethodCall(@NonNull ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object value = this.messageCodec.readValue(byteBuffer);
        Object value2 = this.messageCodec.readValue(byteBuffer);
        if (!(value instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new MethodCall((String) value, value2);
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeErrorEnvelope(@NonNull String str, @NonNull String str2, @NonNull Object obj) throws IOException {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(1);
        this.messageCodec.writeValue(exposedByteArrayOutputStream, str);
        this.messageCodec.writeValue(exposedByteArrayOutputStream, str2);
        if (obj instanceof Throwable) {
            this.messageCodec.writeValue(exposedByteArrayOutputStream, Log.getStackTraceString((Throwable) obj));
        } else {
            this.messageCodec.writeValue(exposedByteArrayOutputStream, obj);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        byteBufferAllocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return byteBufferAllocateDirect;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeErrorEnvelopeWithStacktrace(@NonNull String str, @NonNull String str2, @NonNull Object obj, @NonNull String str3) throws IOException {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(1);
        this.messageCodec.writeValue(exposedByteArrayOutputStream, str);
        this.messageCodec.writeValue(exposedByteArrayOutputStream, str2);
        if (obj instanceof Throwable) {
            this.messageCodec.writeValue(exposedByteArrayOutputStream, Log.getStackTraceString((Throwable) obj));
        } else {
            this.messageCodec.writeValue(exposedByteArrayOutputStream, obj);
        }
        this.messageCodec.writeValue(exposedByteArrayOutputStream, str3);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        byteBufferAllocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return byteBufferAllocateDirect;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeMethodCall(@NonNull MethodCall methodCall) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        this.messageCodec.writeValue(exposedByteArrayOutputStream, methodCall.method);
        this.messageCodec.writeValue(exposedByteArrayOutputStream, methodCall.arguments);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        byteBufferAllocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return byteBufferAllocateDirect;
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeSuccessEnvelope(@NonNull Object obj) throws IOException {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(0);
        this.messageCodec.writeValue(exposedByteArrayOutputStream, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        byteBufferAllocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return byteBufferAllocateDirect;
    }
}
