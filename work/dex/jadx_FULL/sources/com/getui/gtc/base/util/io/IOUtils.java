package com.getui.gtc.base.util.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class IOUtils {
    public static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    static final char pad = '=';

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void copy(byte[] bArr, OutputStream outputStream) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = byteArrayInputStream.read(bArr2);
                if (i == -1) {
                    return;
                } else {
                    outputStream.write(bArr2, 0, i);
                }
            }
        } catch (IOException e) {
            safeClose(byteArrayInputStream);
            throw e;
        }
    }

    public static void encode(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, i);
        copy(inputStream, base64OutputStream);
        base64OutputStream.commit();
    }

    public static byte[] encode(byte[] bArr, int i) throws RuntimeException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                encode(byteArrayInputStream, byteArrayOutputStream, i);
                safeClose(byteArrayInputStream);
                safeClose(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Unexpected I/O error", e);
            }
        } catch (Throwable th) {
            safeClose(byteArrayInputStream);
            safeClose(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] gzip(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    safeClose(gZIPOutputStream2);
                    safeClose(byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safeClose(gZIPOutputStream);
                    safeClose(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] readFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (byteArrayOutputStream == null) {
                        throw th;
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void saveToFile(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        safeClose(fileOutputStream2);
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void saveToFile(InputStream inputStream, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        safeClose(fileOutputStream2);
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void saveToFile(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i = byteArrayInputStream2.read(bArr2);
                        if (i == -1) {
                            safeClose(byteArrayInputStream2);
                            safeClose(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr2, 0, i);
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    safeClose(byteArrayInputStream);
                    safeClose(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable, java.io.InputStream, java.util.zip.GZIPInputStream] */
    public static byte[] unGzip(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ?? gZIPInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = gZIPInputStream.read();
                            if (i == -1) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                safeClose(gZIPInputStream);
                                safeClose(byteArrayOutputStream);
                                safeClose(byteArrayInputStream);
                                return byteArray;
                            }
                            byteArrayOutputStream.write(i);
                        } catch (Throwable th2) {
                            th = th2;
                            safeClose(gZIPInputStream);
                            safeClose(byteArrayOutputStream);
                            safeClose(byteArrayInputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                th = th;
                gZIPInputStream = byteArrayOutputStream;
                safeClose(gZIPInputStream);
                safeClose(byteArrayOutputStream);
                safeClose(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
    }
}
