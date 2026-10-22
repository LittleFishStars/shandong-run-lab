package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.util.Base64;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.utils.AVTime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public final class TTCrashUtil {
    public static void addDebugTrackInfo(long j, String str, String str2, boolean z) throws Throwable {
        appendTrackInfo(getDebugTrackFilePath(j, str), z, str2);
    }

    public static void addTrackInfo(long j, String str, String str2) throws Throwable {
        appendTrackInfo(getTrackFilePath(j, str), true, str2);
    }

    private static void appendTrackInfo(String str, boolean z, String str2) throws Throwable {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(str, z);
            try {
                fileWriter2.write(str2);
                try {
                    fileWriter2.close();
                } catch (Exception e) {
                    m.c(e);
                }
            } catch (Exception unused) {
                fileWriter = fileWriter2;
                try {
                    fileWriter.close();
                } catch (Exception e2) {
                    m.c(e2);
                }
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    fileWriter.close();
                } catch (Exception e3) {
                    m.c(e3);
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void checkLogDir(String str) {
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists()) {
            if (file.mkdir()) {
                return;
            }
            file.getName();
        } else if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (!file2.delete()) {
                        file2.getName();
                    }
                }
            }
            if (file.delete()) {
                return;
            }
            file.getName();
        }
    }

    public static void checkTrackDir(String str) {
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[10240];
        while (true) {
            int i = inputStream.read(bArr, 0, 10240);
            if (i == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
            gZIPOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0082 A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #12 {IOException -> 0x007e, blocks: (B:43:0x007a, B:47:0x0082), top: B:79:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0095 A[Catch: IOException -> 0x0091, TRY_LEAVE, TryCatch #1 {IOException -> 0x0091, blocks: (B:53:0x008d, B:57:0x0095), top: B:73:0x008d }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00a8 A[Catch: IOException -> 0x00a4, TRY_LEAVE, TryCatch #11 {IOException -> 0x00a4, blocks: (B:63:0x00a0, B:67:0x00a8), top: B:77:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static final boolean copyFile(String str, String str2, boolean z, boolean z2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(str2);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(str);
        if (file2.exists()) {
            if (z) {
                new File(str).delete();
            }
        } else if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    if (z2) {
                        file.delete();
                    }
                    try {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    } catch (IOException e) {
                        m.c(e);
                        return true;
                    }
                } catch (FileNotFoundException unused) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e2) {
                            m.c(e2);
                            return false;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e3) {
                            m.c(e3);
                            return false;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (IOException e4) {
                            m.c(e4);
                            throw th;
                        }
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                th = th;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } else if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            fileInputStream = null;
        } catch (IOException unused6) {
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
        }
    }

    public static void deleteCrashFile(Context context, String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void deleteDebugTrackFile(long j, String str) {
        deleteTrackFile(getDebugTrackFilePath(j, str));
    }

    private static void deleteTrackFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean existLogsFile(long j, String str) {
        File[] fileArrListFiles;
        String strValueOf = String.valueOf(j);
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            m.c("ttmp", "<TTCrashUtils,existLogsFile,375>file:" + name + ",pname:" + strValueOf);
            if (name != null && !name.startsWith(strValueOf)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existsCrashFile(Context context, String str) {
        if (context == null && str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static final String existsCrashFilePath(Context context) {
        if (TTPlayerConfiger.getValue(18, 1) == 1) {
            String appCrashFilePath = TTPlayerConfiger.getAppCrashFilePath(context);
            if (appCrashFilePath == null || !new File(appCrashFilePath).exists()) {
                return null;
            }
            return appCrashFilePath;
        }
        String appCrashFilePath2 = TTPlayerConfiger.getAppCrashFilePath2(context);
        if (appCrashFilePath2 != null && new File(appCrashFilePath2).exists()) {
            return appCrashFilePath2;
        }
        String plugerCrashFilePath = TTPlayerConfiger.getPlugerCrashFilePath(context);
        if (plugerCrashFilePath != null && new File(plugerCrashFilePath).exists()) {
            return plugerCrashFilePath;
        }
        String externalStorageDirectoryCrashFilePath = TTPlayerConfiger.getExternalStorageDirectoryCrashFilePath();
        if (externalStorageDirectoryCrashFilePath == null || new File(externalStorageDirectoryCrashFilePath).exists()) {
            return externalStorageDirectoryCrashFilePath;
        }
        return null;
    }

    public static boolean existsTrackFile(long j, String str) {
        return new File(getTrackFilePath(j, str)).exists();
    }

    public static String getBase64SampleCrash(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String getCrashFileContext(Context context, String str, StringBuilder sb) {
        FileInputStream fileInputStream;
        if (context == null && str == null) {
            sb.append("context or path is null.\r\n");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            sb.append("file not exist.path:");
            sb.append(str);
            sb.append("\r\n");
            return null;
        }
        if (file.length() == 0) {
            sb.append("file size is zore.\r\n");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                compress(fileInputStream, byteArrayOutputStream);
                fileInputStream.close();
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                byteArrayOutputStream.close();
                return strEncodeToString;
            } catch (Exception e) {
                e = e;
                m.c(e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        m.c(e2);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                sb.append("gzip file is error.error:");
                sb.append(e.getMessage());
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        }
    }

    private static String getDebugTrackFilePath(long j, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d_d.log", str, Long.valueOf(j));
    }

    private static boolean getTrackFileInfos(File file, StringBuilder sb) {
        int i;
        FileReader fileReader = null;
        try {
            if (!file.exists()) {
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    i = fileReader2.read(cArr);
                    if (i <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                }
            } while (i >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (Exception unused) {
            }
        }
        sb.append("track message:");
        sb.append(th.getMessage());
        sb.append("\r\n");
        return true;
    }

    public static String getTrackFilePath(long j, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d.log", str, Long.valueOf(j));
    }

    public static final boolean moveFile(String str, String str2, boolean z) {
        return copyFile(str, str2, z, true);
    }

    public static boolean moveTrackFile(long j, long j2, String str) {
        return new File(getTrackFilePath(j, str)).renameTo(new File(getTrackFilePath(j2, str)));
    }

    public static boolean readDebugTrackInfos(long j, String str, StringBuilder sb) {
        return getTrackFileInfos(getDebugTrackFilePath(j, str), sb);
    }

    public static boolean readLogsInfo(long j, String str, StringBuilder sb) {
        File[] fileArrListFiles;
        String strValueOf = String.valueOf(j);
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            if (name != null && !name.startsWith(strValueOf) && getTrackFileInfos(file2, sb)) {
                boolean zDelete = file2.delete();
                if (!zDelete) {
                    file2.getName();
                }
                return zDelete;
            }
        }
        return false;
    }

    public static boolean readTrackInfos(long j, String str, StringBuilder sb) {
        return getTrackFileInfos(getTrackFilePath(j, str), sb);
    }

    public static final void saveException(Throwable th, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        PrintStream printStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                PrintStream printStream2 = new PrintStream(fileOutputStream);
                try {
                    printStream2.write("EXCE".getBytes());
                    th.printStackTrace(printStream2);
                    printStream2.close();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                        m.c(e);
                    }
                } catch (Exception unused) {
                    printStream = printStream2;
                    if (printStream != null) {
                        printStream.close();
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            m.c(e2);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = printStream2;
                    if (printStream != null) {
                        printStream.close();
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            m.c(e3);
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static void saveLowMemoryInfo(int i, String str) throws Throwable {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(file);
                try {
                    fileWriter2.write("LOWM\r\nrecv low memory warring info.level:" + i);
                    try {
                        fileWriter2.close();
                    } catch (IOException e) {
                        m.c(e);
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    m.c(e);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                            m.c(e3);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                            m.c(e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void saveStopInfo(String str, String str2) throws Throwable {
        Throwable th;
        FileWriter fileWriter;
        IOException e;
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        Writer writer = null;
        try {
            try {
                fileWriter = new FileWriter(file);
                try {
                    fileWriter.write("STOP recv stop info:" + str2 + ".time:" + AVTime.getFormatNow() + "\r\n");
                    try {
                        fileWriter.close();
                    } catch (IOException e2) {
                        m.c(e2);
                    }
                } catch (IOException e3) {
                    e = e3;
                    m.c(e);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                            m.c(e4);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        writer.close();
                    } catch (IOException e5) {
                        m.c(e5);
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            fileWriter = null;
            e = e6;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
                writer.close();
            }
            throw th;
        }
    }

    public static void addTrackInfo(long j, String str, String str2, boolean z) throws Throwable {
        appendTrackInfo(getTrackFilePath(j, str), z, str2);
    }

    public static void deleteTrackFile(long j, String str) {
        deleteTrackFile(getTrackFilePath(j, str));
    }

    private static boolean getTrackFileInfos(String str, StringBuilder sb) {
        int i;
        FileReader fileReader = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                sb.append("path");
                sb.append(str);
                sb.append(" not exists.\r\n");
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    i = fileReader2.read(cArr);
                    if (i <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    sb.append("track message:");
                    sb.append(th.getMessage());
                    sb.append("\r\n");
                    return true;
                }
            } while (i >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
