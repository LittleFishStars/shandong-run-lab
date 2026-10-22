package com.igexin.push.core.i.a;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38060a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 0;

    public interface a {
        Bitmap a(int i, int i2, Bitmap.Config config, int i3);

        void a();

        void a(Bitmap bitmap);

        byte[] a(int i);

        void b();

        int[] b(int i);

        void c();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    int a();

    int a(int i);

    int a(InputStream inputStream, int i);

    int a(byte[] bArr);

    void a(Bitmap.Config config);

    void a(i iVar, ByteBuffer byteBuffer);

    void a(i iVar, ByteBuffer byteBuffer, int i);

    void a(i iVar, byte[] bArr);

    int b();

    ByteBuffer c();

    int d();

    void e();

    int f();

    int g();

    int h();

    void i();

    @Deprecated
    int j();

    int k();

    int l();

    int m();

    Bitmap n();

    void o();
}
