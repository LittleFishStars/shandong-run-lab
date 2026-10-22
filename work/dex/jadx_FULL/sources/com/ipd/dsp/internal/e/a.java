package com.ipd.dsp.internal.e;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38284a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 0;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0876a {
        @NonNull
        Bitmap a(int i, int i2, @NonNull Bitmap.Config config);

        void a(@NonNull Bitmap bitmap);

        void a(@NonNull byte[] bArr);

        void a(@NonNull int[] iArr);

        @NonNull
        byte[] a(int i);

        @NonNull
        int[] b(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    int a();

    int a(int i);

    int a(@Nullable InputStream inputStream, int i);

    void a(@NonNull Bitmap.Config config);

    void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer);

    void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i);

    void a(@NonNull c cVar, @NonNull byte[] bArr);

    @Nullable
    Bitmap b();

    void c();

    void clear();

    int d();

    int e();

    int f();

    int g();

    int h();

    int i();

    int j();

    int k();

    @Deprecated
    int l();

    @NonNull
    ByteBuffer m();

    void n();

    int read(@Nullable byte[] bArr);
}
