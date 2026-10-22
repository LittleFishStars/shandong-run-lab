package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h {
    public static final char bgq = File.separatorChar;
    public static final String bgr;

    static {
        PrintWriter printWriter;
        Throwable th;
        StringBuilderWriter stringBuilderWriter;
        Exception e;
        String string;
        try {
            try {
                stringBuilderWriter = new StringBuilderWriter(4);
                try {
                    printWriter = new PrintWriter(stringBuilderWriter);
                    try {
                        printWriter.println();
                        string = stringBuilderWriter.toString();
                        b.closeQuietly(printWriter);
                        b.closeQuietly(stringBuilderWriter);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        b.closeQuietly(printWriter);
                        b.closeQuietly(stringBuilderWriter);
                        string = "\n";
                    }
                } catch (Exception e3) {
                    printWriter = null;
                    e = e3;
                } catch (Throwable th2) {
                    printWriter = null;
                    th = th2;
                    b.closeQuietly(printWriter);
                    b.closeQuietly(stringBuilderWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            printWriter = null;
            e = e4;
            stringBuilderWriter = null;
        } catch (Throwable th4) {
            printWriter = null;
            th = th4;
            stringBuilderWriter = null;
        }
        bgr = string;
    }

    public static String J(File file) {
        return a(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), a.UTF_8));
    }

    public static long K(File file) {
        try {
            if (!file.exists()) {
                return 0L;
            }
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long L(File file) {
        try {
            if (!file.exists()) {
                return 0L;
            }
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String O(Context context, String str) {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            return a(inputStreamOpen, a.a(Charset.defaultCharset()));
        } finally {
            b.closeQuietly(inputStreamOpen);
        }
    }

    private static String a(Reader reader) throws Throwable {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int i = reader.read(cArr);
                    if (i == -1) {
                        String string = stringWriter.toString();
                        b.closeQuietly(reader);
                        b.closeQuietly(stringWriter);
                        return string;
                    }
                    stringWriter.write(cArr, 0, i);
                }
            } catch (Throwable th2) {
                th = th2;
                b.closeQuietly(reader);
                b.closeQuietly(stringWriter);
                throw th;
            }
        } catch (Throwable th3) {
            stringWriter = stringWriter2;
            th = th3;
        }
    }

    public static String b(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static String c(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
                try {
                    String strA = a(bufferedReader);
                    b.closeQuietly(bufferedReader);
                    b.closeQuietly(inputStreamReader);
                    return strA;
                } catch (Throwable th2) {
                    th = th2;
                    b.closeQuietly(bufferedReader);
                    b.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public static String d(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }

    public static int e(InputStream inputStream, OutputStream outputStream) {
        long jF = f(inputStream, outputStream);
        if (jF > 2147483647L) {
            return -1;
        }
        return (int) jF;
    }

    private static long f(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, new byte[4096]);
    }

    public static long getAvailableBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return K(new File(str));
    }

    public static long getTotalBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return L(new File(str));
    }

    public static String inputStream2String(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    String str = new String(byteArrayOutputStream.toByteArray());
                    b.closeQuietly(inputStream);
                    b.closeQuietly(byteArrayOutputStream);
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException unused) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static void k(String str, String str2, boolean z) {
        FileWriter fileWriter;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
            try {
                fileWriter.write(str2);
                fileWriter.flush();
                b.closeQuietly(fileWriter);
            } catch (Throwable unused) {
                b.closeQuietly(fileWriter);
            }
        } catch (Throwable unused2) {
            fileWriter = null;
        }
    }

    private static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static String a(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static void a(String str, OutputStream outputStream, Charset charset) throws IOException {
        if (str != null) {
            outputStream.write(str.getBytes(a.a(charset)));
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    private static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    private static int a(Reader reader, Writer writer) {
        long jB = b(reader, writer);
        if (jB > 2147483647L) {
            return -1;
        }
        return (int) jB;
    }

    private static long a(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int i = reader.read(cArr);
            if (-1 == i) {
                return j;
            }
            writer.write(cArr, 0, i);
            j += (long) i;
        }
    }
}
