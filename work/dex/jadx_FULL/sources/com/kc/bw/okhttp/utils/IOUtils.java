package com.kc.bw.okhttp.utils;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class IOUtils {
    public static final String TAG = dexg.dexa("XN`JPVujmt");

    public static boolean canRead(String str) {
        return new File(str).canRead();
    }

    public static boolean canWrite(String str) {
        return new File(str).canWrite();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        int i;
        BufferedInputStream bufferedInputStream = toBufferedInputStream(inputStream);
        BufferedInputStream bufferedInputStream2 = toBufferedInputStream(inputStream2);
        do {
            i = bufferedInputStream.read();
            if (-1 == i) {
                return bufferedInputStream2.read() == -1;
            }
        } while (i == bufferedInputStream2.read());
        return false;
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        int i;
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        do {
            i = bufferedReader.read();
            if (-1 == i) {
                return bufferedReader2.read() == -1;
            }
        } while (i == bufferedReader2.read());
        return false;
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) throws IOException {
        String line;
        String line2;
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        do {
            line = bufferedReader.readLine();
            line2 = bufferedReader2.readLine();
            if (line == null || line2 == null) {
                break;
            }
        } while (line.equals(line2));
        return line != null && (line2 == null || line.equals(line2));
    }

    public static boolean createFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                return true;
            }
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFile(new File(str));
    }

    public static boolean createFolder(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            file.delete();
        }
        return file.mkdirs();
    }

    public static boolean createFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFolder(new File(str));
    }

    public static boolean createNewFile(File file) {
        if (file.exists()) {
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createNewFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createNewFile(new File(str));
    }

    public static boolean createNewFolder(File file) {
        return delFileOrFolder(file) && createFolder(file);
    }

    public static boolean createNewFolder(String str) {
        return delFileOrFolder(str) && createFolder(str);
    }

    public static boolean delFileOrFolder(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (!file.isFile()) {
            if (!file.isDirectory()) {
                return true;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    delFileOrFolder(file2);
                }
            }
        }
        setFileWrite(file);
        file.delete();
        return true;
    }

    public static boolean delFileOrFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return delFileOrFolder(new File(str));
    }

    public static void flushQuietly(Flushable flushable) {
        if (flushable == null) {
            return;
        }
        try {
            flushable.flush();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static long getDirSize(String str) {
        try {
            return getStatFsSize(new StatFs(str), dexg.dexa("hfuCmpdlTj{fMpoh"), dexg.dexa("hfuBwbjmbcmfCmpdltMpoh"));
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static long getStatFsSize(StatFs statFs, String str, String str2) {
        try {
            Method method = statFs.getClass().getMethod(str, new Class[0]);
            method.setAccessible(true);
            Method method2 = statFs.getClass().getMethod(str2, new Class[0]);
            method2.setAccessible(true);
            return ((Long) method.invoke(statFs, new Object[0])).longValue() * ((Long) method2.invoke(statFs, new Object[0])).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static List<String> readLines(InputStream inputStream) {
        return readLines(new InputStreamReader(inputStream));
    }

    public static List<String> readLines(InputStream inputStream, String str) {
        return readLines(new InputStreamReader(inputStream, str));
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return arrayList;
            }
            arrayList.add(line);
        }
    }

    public static void setFileReadOnly(File file) {
        String strDexa;
        String str = TAG;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(dexg.dexa("TEL`JOU!|sfe~!"));
            int i = Build.VERSION.SDK_INT;
            sb.append(i);
            Log.d(str, sb.toString());
            if (i < 34) {
                return;
            }
            if (file.setReadOnly()) {
                strDexa = dexg.dexa("tfuSfbePomz!usvf\"");
            } else {
                strDexa = dexg.dexa("tfuSfbePomz!gbmtf\"") + file.getName();
            }
            Log.d(str, strDexa);
        } catch (Throwable th) {
            Log.w(TAG, dexg.dexa("tfuSfbePomz!gbjm!????") + th);
        }
    }

    public static void setFileWrite(File file) {
        if (file != null) {
            String str = TAG;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(dexg.dexa("TEL`JOU!|xsjuf~!"));
                int i = Build.VERSION.SDK_INT;
                sb.append(i);
                Log.w(str, sb.toString());
                if (i < 34) {
                    return;
                }
                Log.w(str, dexg.dexa(file.setWritable(true) ? "tfuGjmfXsjuf!usvf\"" : "tfuGjmfXsjuf!gbmtf\""));
            } catch (Throwable th) {
                Log.w(TAG, dexg.dexa("tfuGjmfXsjuf!gbjm!????") + th);
            }
        }
    }

    public static BufferedInputStream toBufferedInputStream(InputStream inputStream) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    public static BufferedOutputStream toBufferedOutputStream(OutputStream outputStream) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static BufferedWriter toBufferedWriter(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(Reader reader) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(Reader reader, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream, str);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(CharSequence charSequence) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes();
    }

    public static byte[] toByteArray(CharSequence charSequence, String str) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes(str);
    }

    public static byte[] toByteArray(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    closeQuietly(objectOutputStream);
                    closeQuietly(byteArrayOutputStream);
                    return byteArray;
                } catch (IOException unused) {
                    closeQuietly(objectOutputStream);
                    closeQuietly(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    closeQuietly(objectOutputStream2);
                    closeQuietly(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused3) {
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static char[] toCharArray(InputStream inputStream) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(InputStream inputStream, String str) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter, str);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(Reader reader) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(reader, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(CharSequence charSequence) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(charSequence, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(CharSequence charSequence) {
        return new ByteArrayInputStream(charSequence.toString().getBytes());
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) {
        return new ByteArrayInputStream(charSequence.toString().getBytes(str));
    }

    public static Object toObject(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Object object = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    object = objectInputStream.readObject();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                    } finally {
                        closeQuietly(objectInputStream);
                        closeQuietly(byteArrayInputStream);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
        }
        return object;
    }

    public static String toString(InputStream inputStream) {
        return new String(toByteArray(inputStream));
    }

    public static String toString(InputStream inputStream, String str) {
        return new String(toByteArray(inputStream), str);
    }

    public static String toString(Reader reader) {
        return new String(toByteArray(reader));
    }

    public static String toString(Reader reader, String str) {
        return new String(toByteArray(reader), str);
    }

    public static String toString(byte[] bArr) {
        return new String(bArr);
    }

    public static String toString(byte[] bArr, String str) {
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static void write(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void write(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        write(new InputStreamReader(inputStream, str), outputStream);
    }

    public static void write(InputStream inputStream, Writer writer) throws IOException {
        write(new InputStreamReader(inputStream), writer);
    }

    public static void write(InputStream inputStream, Writer writer, String str) throws IOException {
        write(new InputStreamReader(inputStream, str), writer);
    }

    public static void write(Reader reader, OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        write(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void write(Reader reader, OutputStream outputStream, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, str);
        write(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void write(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        while (true) {
            int i = reader.read(cArr);
            if (-1 == i) {
                return;
            } else {
                writer.write(cArr, 0, i);
            }
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream) throws IOException {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes());
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, String str) throws IOException {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes(str));
        }
    }

    public static void write(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence != null) {
            writer.write(charSequence.toString());
        }
    }

    public static void write(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public static void write(byte[] bArr, Writer writer) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr));
        }
    }

    public static void write(byte[] bArr, Writer writer, String str) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr, str));
        }
    }

    public static void write(char[] cArr, OutputStream outputStream) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes());
        }
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(str));
        }
    }

    public static void write(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            writer.write(cArr);
        }
    }
}
