package com.kuaishou.weapon.p0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40111a = 2048;
    public static final String b = ".gz";

    public static byte[] a(byte[] bArr) {
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] byteArray = null;
        byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    a(byteArrayInputStream, byteArrayOutputStream2);
                    byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    byteArrayInputStream.close();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        byteArrayInputStream.close();
                        return byteArray;
                    } catch (Exception unused2) {
                        return byteArray;
                    }
                } catch (Throwable unused3) {
                    byte[] bArr3 = byteArray;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    bArr2 = bArr3;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return bArr2;
                }
            } catch (Throwable unused6) {
                bArr2 = null;
            }
        } catch (Throwable unused7) {
            bArr2 = null;
            byteArrayInputStream = null;
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    b(byteArrayInputStream, byteArrayOutputStream2);
                    bArr = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    byteArrayInputStream.close();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (Throwable unused2) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (byteArrayInputStream != null) {
                    }
                    return bArr;
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            byteArrayInputStream = null;
        }
        try {
            byteArrayInputStream.close();
        } catch (Exception unused6) {
        }
        return bArr;
    }

    public static void b(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int i = gZIPInputStream2.read(bArr, 0, 2048);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        gZIPInputStream2.close();
                        try {
                            gZIPInputStream2.close();
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            } catch (Exception unused2) {
                gZIPInputStream = gZIPInputStream2;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int i = inputStream.read(bArr, 0, 2048);
                    if (i != -1) {
                        gZIPOutputStream.write(bArr, 0, i);
                    } else {
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                        gZIPOutputStream.close();
                        return;
                    }
                }
            } catch (Throwable unused) {
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
            gZIPOutputStream = null;
        }
    }
}
