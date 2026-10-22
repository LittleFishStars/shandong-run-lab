package com.kc.openset.d;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Closeable;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f39753a;
    private static final OutputStream b;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private final int i;
    private Writer k;
    private int m;
    private long j = 0;
    private final LinkedHashMap<String, d> l = new LinkedHashMap<>(0, 0.75f, true);
    private long n = 0;
    final ThreadPoolExecutor o = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> p = new CallableC1110a(this);

    /* JADX INFO: renamed from: com.kc.openset.d.a$a, reason: collision with other inner class name */
    @Keep
    public class CallableC1110a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39754a;

        static {
            OSETSDKProtected.interface11(4409);
        }

        public CallableC1110a(a aVar) {
            this.f39754a = aVar;
        }

        public native Void a();

        @Override // java.util.concurrent.Callable
        public native /* bridge */ /* synthetic */ Void call();
    }

    @Keep
    public class b extends OutputStream {
        static {
            OSETSDKProtected.interface11(4410);
        }

        @Override // java.io.OutputStream
        public native void write(int i);
    }

    @Keep
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f39755a;
        private final boolean[] b;
        private boolean c;
        private boolean d;
        final a e;

        /* JADX INFO: renamed from: com.kc.openset.d.a$c$a, reason: collision with other inner class name */
        @Keep
        public class C1111a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final c f39756a;

            static {
                OSETSDKProtected.interface11(4411);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private C1111a(c cVar, OutputStream outputStream) {
                super(outputStream);
                this.f39756a = cVar;
            }

            public /* synthetic */ C1111a(c cVar, OutputStream outputStream, CallableC1110a callableC1110a) {
                this(cVar, outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public native void close();

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public native void flush();

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public native void write(int i);

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public native void write(byte[] bArr, int i, int i2);
        }

        static {
            OSETSDKProtected.interface11(4412);
        }

        private c(a aVar, d dVar) {
            this.e = aVar;
            this.f39755a = dVar;
            this.b = d.d(dVar) ? null : new boolean[a.c(aVar)];
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC1110a callableC1110a) {
            this(aVar, dVar);
        }

        public static native /* synthetic */ d a(c cVar);

        public static native /* synthetic */ boolean a(c cVar, boolean z);

        public static native /* synthetic */ boolean[] b(c cVar);

        public native OutputStream a(int i);

        public native void a();

        public native void b();
    }

    @Keep
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f39757a;
        private final long[] b;
        private boolean c;
        private c d;
        private long e;
        final a f;

        static {
            OSETSDKProtected.interface11(4413);
        }

        private d(a aVar, String str) {
            this.f = aVar;
            this.f39757a = str;
            this.b = new long[a.c(aVar)];
        }

        public /* synthetic */ d(a aVar, String str, CallableC1110a callableC1110a) {
            this(aVar, str);
        }

        public static native /* synthetic */ long a(d dVar, long j);

        public static native /* synthetic */ c a(d dVar, c cVar);

        private native IOException a(String[] strArr);

        public static native /* synthetic */ void a(d dVar, String[] strArr);

        public static native /* synthetic */ boolean a(d dVar, boolean z);

        public static native /* synthetic */ long[] a(d dVar);

        public static native /* synthetic */ String b(d dVar);

        private native void b(String[] strArr);

        public static native /* synthetic */ long c(d dVar);

        public static native /* synthetic */ boolean d(d dVar);

        public static native /* synthetic */ c e(d dVar);

        public native File a(int i);

        public native String a();

        public native File b(int i);
    }

    @Keep
    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f39758a;
        private final long b;
        private final InputStream[] c;
        private final long[] d;
        final a e;

        static {
            OSETSDKProtected.interface11(4414);
        }

        private e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.e = aVar;
            this.f39758a = str;
            this.b = j;
            this.c = inputStreamArr;
            this.d = jArr;
        }

        public /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC1110a callableC1110a) {
            this(aVar, str, j, inputStreamArr, jArr);
        }

        public native InputStream a(int i);

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public native void close();
    }

    static {
        OSETSDKProtected.interface11(4415);
        f39753a = Pattern.compile(OSETSDKProtected.getString2(1657));
        b = new b();
    }

    private a(File file, int i, int i2, long j) {
        this.c = file;
        this.g = i;
        this.d = new File(file, OSETSDKProtected.getString2(1658));
        this.e = new File(file, OSETSDKProtected.getString2(1659));
        this.f = new File(file, OSETSDKProtected.getString2(1660));
        this.i = i2;
        this.h = j;
    }

    public static native /* synthetic */ int a(a aVar, int i);

    private native c a(String str, long j);

    public static native a a(File file, int i, int i2, long j);

    public static native /* synthetic */ OutputStream a();

    public static native /* synthetic */ Writer a(a aVar);

    private native void a(c cVar, boolean z);

    public static native /* synthetic */ void a(a aVar, c cVar, boolean z);

    private static native void a(File file);

    private static native void a(File file, File file2, boolean z);

    private native void b();

    public static native /* synthetic */ void b(a aVar);

    public static native /* synthetic */ int c(a aVar);

    private native void c(String str);

    public static native /* synthetic */ File d(a aVar);

    private native boolean d();

    private native void e();

    private native void e(String str);

    public static native /* synthetic */ boolean e(a aVar);

    private native void f();

    public static native /* synthetic */ void f(a aVar);

    private native void g();

    private native void h();

    public native c a(String str);

    public native e b(String str);

    public native void c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public native void close();

    public native boolean d(String str);
}
