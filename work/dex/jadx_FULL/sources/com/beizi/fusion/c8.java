package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.c8;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class c8 {
    public static File[] a(File file, final long j) {
        if (file != null && file.exists() && file.isDirectory()) {
            return file.listFiles(new FileFilter() { // from class: com.zj.adlib.ura
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return c8.a(j, file2);
                }
            });
        }
        return null;
    }

    public static boolean b(File file, String str) {
        File[] fileArrA = a(file, str);
        return fileArrA != null && fileArrA.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(long j, File file) {
        return file.lastModified() < j;
    }

    public static String b(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file.exists() && file.canRead()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    String strA = zd.a((InputStream) fileInputStream);
                    zd.a((Closeable) fileInputStream);
                    return strA;
                } catch (IOException e) {
                    e = e;
                    try {
                        om.a(e);
                        zd.a((Closeable) fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        zd.a((Closeable) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zd.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                zd.a((Closeable) fileInputStream);
                throw th;
            }
        }
        return null;
    }

    public static File[] a(File file, final String str) {
        if (file == null || !file.exists() || !file.isDirectory() || TextUtils.isEmpty(str)) {
            return null;
        }
        return file.listFiles(new FilenameFilter() { // from class: com.zj.adlib.wra
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                return c8.a(str, file2, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(String str, File file, String str2) {
        return str2.equals(str);
    }

    public static long a(File file) {
        long jA;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    jA = file2.length();
                } else {
                    if (file2.isDirectory()) {
                        jA = a(file2);
                    }
                }
                j += jA;
            }
        }
        return j;
    }

    public static File a(Context context) {
        return context.getFilesDir();
    }

    public static File a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                om.a(e);
            }
        }
        return file;
    }

    public static boolean a(String str, long j, String str2) throws Throwable {
        Throwable th;
        Writer writer;
        BufferedWriter bufferedWriter;
        Writer fileWriter;
        Writer writer2 = null;
        try {
            fileWriter = new FileWriter(a(str), true);
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter.write(no.a(j));
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("------------------crash----------------------");
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write(str2);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("-------------------end-----------------------");
                    bufferedWriter.newLine();
                    zd.a(bufferedWriter);
                    zd.a(fileWriter);
                    return true;
                } catch (IOException e) {
                    e = e;
                    writer2 = fileWriter;
                    try {
                        om.a(e);
                        zd.a(bufferedWriter);
                        zd.a(writer2);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        Writer writer3 = writer2;
                        writer2 = bufferedWriter;
                        writer = writer3;
                        fileWriter = writer;
                        zd.a(writer2);
                        zd.a(fileWriter);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writer2 = bufferedWriter;
                    zd.a(writer2);
                    zd.a(fileWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedWriter = null;
        } catch (Throwable th5) {
            th = th5;
            writer = null;
            fileWriter = writer;
            zd.a(writer2);
            zd.a(fileWriter);
            throw th;
        }
    }

    public static void a(File file, Set set) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            if (set == null || !set.contains(name)) {
                try {
                    file2.delete();
                } catch (Throwable th) {
                    om.a(th);
                }
            }
        }
    }
}
