package com.alipay.sdk.m.p;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static byte[] a(byte[] bArr) throws Throwable {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int i = byteArrayInputStream2.read(bArr2);
                            if (i == -1) {
                                break;
                            }
                            gZIPOutputStream.write(bArr2, 0, i);
                        }
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayInputStream2.close();
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArray;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream = byteArrayInputStream2;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        if (gZIPOutputStream == null) {
                            throw th;
                        }
                        try {
                            gZIPOutputStream.close();
                            throw th;
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    gZIPOutputStream = null;
                    byteArrayInputStream = byteArrayInputStream2;
                    th = th3;
                }
            } catch (Throwable th4) {
                gZIPOutputStream = null;
                byteArrayInputStream = byteArrayInputStream2;
                th = th4;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
    }

    public static byte[] b(byte[] bArr) throws Throwable {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = gZIPInputStream.read(bArr2, 0, 4096);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, i);
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                byteArrayInputStream.close();
                                throw th;
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused6) {
                    }
                    return byteArray;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = null;
            byteArrayInputStream = null;
        }
    }
}
