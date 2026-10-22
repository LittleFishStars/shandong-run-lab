package com.kc.openset.d;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f39759a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    @Keep
    public class a extends ByteArrayOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39760a;

        static {
            OSETSDKProtected.interface11(4416);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i) {
            super(i);
            this.f39760a = bVar;
        }

        @Override // java.io.ByteArrayOutputStream
        public native String toString();
    }

    static {
        OSETSDKProtected.interface11(4417);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException(OSETSDKProtected.getString2(1682));
        }
        if (!charset.equals(c.f39761a)) {
            throw new IllegalArgumentException(OSETSDKProtected.getString2(1681));
        }
        this.f39759a = inputStream;
        this.b = charset;
        this.c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public static native /* synthetic */ Charset a(b bVar);

    private native void a();

    public native boolean b();

    public native String c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public native void close();
}
