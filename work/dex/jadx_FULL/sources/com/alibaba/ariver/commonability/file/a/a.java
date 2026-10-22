package com.alibaba.ariver.commonability.file.a;

import com.alibaba.ariver.kernel.common.io.ByteArrayPool;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24011a = 65536;
    public static final int b = 5242880;
    private static final String c = "H5IOUtils";
    private static final ByteArrayPool d = new ByteArrayPool(20480);

    public static ByteArrayPool a() {
        return d;
    }

    public static boolean b() {
        return false;
    }

    public static byte[] a(int i) {
        return a().getBuf(i);
    }

    public static void a(byte[] bArr) {
        a().returnBuf(bArr);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                RVLogger.e(c, e);
            }
        }
    }

    public static byte[] a(InputStream inputStream) throws Throwable {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        byte[] bArrA;
        byte[] bArr = null;
        if (inputStream == null) {
            a((byte[]) null);
            a((Closeable) null);
            return null;
        }
        try {
            bArrA = a(2048);
            try {
                poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                while (true) {
                    try {
                        try {
                            int i = inputStream.read(bArrA);
                            if (i != -1) {
                                poolingByteArrayOutputStream.write(bArrA, 0, i);
                            } else {
                                byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                                a(bArrA);
                                a(poolingByteArrayOutputStream);
                                return byteArray;
                            }
                        } catch (Exception e) {
                            e = e;
                            RVLogger.e(c, e);
                            a(bArrA);
                            a(poolingByteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    th = th;
                    bArr = bArrA;
                    a(bArr);
                    a(poolingByteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                poolingByteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                poolingByteArrayOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            bArrA = null;
            poolingByteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            poolingByteArrayOutputStream = null;
        }
    }

    public static byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArrA = a((InputStream) fileInputStream);
                    a((Closeable) fileInputStream);
                    return bArrA;
                } catch (Exception e) {
                    e = e;
                    RVLogger.e(c, e);
                    a((Closeable) fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) fileInputStream2);
            throw th;
        }
    }

    public static void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        try {
            Method declaredMethod = Class.forName("java.nio.NioUtils").getDeclaredMethod("freeDirectBuffer", ByteBuffer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, mappedByteBuffer);
        } catch (Throwable th) {
            RVLogger.e(c, th);
        }
    }
}
