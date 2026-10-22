package com.beizi.fusion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class s8 implements ma {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static s8 f27744a = new s8();
    }

    private s8() {
        if (a.f27744a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                om.a(e);
            }
        }
    }

    public static byte[] c(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(gZIPOutputStream);
                    a(byteArrayOutputStream);
                    return byteArray;
                } catch (IOException e) {
                    e = e;
                    try {
                        om.a(e);
                        a(gZIPOutputStream);
                        a(byteArrayOutputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        gZIPOutputStream2 = gZIPOutputStream;
                        a(gZIPOutputStream2);
                        a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream2 = gZIPOutputStream;
                    a(gZIPOutputStream2);
                    a(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                gZIPOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                a(gZIPOutputStream2);
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
            byteArrayOutputStream = byteArrayOutputStream2;
            gZIPOutputStream2 = gZIPOutputStream;
            a(gZIPOutputStream2);
            a(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] d(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[2048];
                        while (true) {
                            int i = gZIPInputStream2.read(bArr2);
                            if (i < 0) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                a(gZIPInputStream2);
                                a(byteArrayInputStream);
                                a(byteArrayOutputStream);
                                return byteArray;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i);
                        }
                    } catch (IOException e) {
                        e = e;
                        try {
                            om.a(e);
                            a(gZIPInputStream2);
                            a(byteArrayInputStream);
                            a(byteArrayOutputStream);
                            return null;
                        } catch (Throwable th2) {
                            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                            gZIPInputStream = gZIPInputStream2;
                            th = th2;
                            closeable2 = byteArrayOutputStream2;
                            GZIPInputStream gZIPInputStream3 = gZIPInputStream;
                            th = th;
                            gZIPInputStream2 = gZIPInputStream3;
                            ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                            closeable = closeable2;
                            closeable2 = byteArrayInputStream2;
                            a(gZIPInputStream2);
                            a(closeable2);
                            a(closeable);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable2 = byteArrayInputStream;
                        closeable = byteArrayOutputStream;
                        a(gZIPInputStream2);
                        a(closeable2);
                        a(closeable);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    gZIPInputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    gZIPInputStream2 = null;
                }
            } catch (IOException e3) {
                e = e3;
                gZIPInputStream2 = null;
                byteArrayInputStream = null;
            } catch (Throwable th5) {
                closeable = byteArrayOutputStream;
                th = th5;
                gZIPInputStream2 = null;
            }
        } catch (IOException e4) {
            e = e4;
            gZIPInputStream2 = null;
            byteArrayOutputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            gZIPInputStream = null;
            byteArrayInputStream = null;
            GZIPInputStream gZIPInputStream4 = gZIPInputStream;
            th = th;
            gZIPInputStream2 = gZIPInputStream4;
            ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
            closeable = closeable2;
            closeable2 = byteArrayInputStream3;
            a(gZIPInputStream2);
            a(closeable2);
            a(closeable);
            throw th;
        }
    }

    @Override // com.beizi.fusion.ma
    public byte[] b(byte[] bArr) {
        try {
            return c(bArr);
        } catch (IOException e) {
            om.a(e);
            return null;
        }
    }

    public static s8 a() {
        return a.f27744a;
    }

    @Override // com.beizi.fusion.ma
    public byte[] a(byte[] bArr) {
        try {
            return d(bArr);
        } catch (IOException e) {
            om.a(e);
            return null;
        }
    }
}
