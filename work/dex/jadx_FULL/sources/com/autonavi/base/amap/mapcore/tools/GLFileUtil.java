package com.autonavi.base.amap.mapcore.tools;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLFileUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void copy(Context context, String str, File file) throws Exception {
        file.delete();
        InputStream inputStreamOpen = context.getAssets().open(str);
        byte[] bArr = new byte[inputStreamOpen.available()];
        try {
            inputStreamOpen.read(bArr);
            closeQuietly(inputStreamOpen);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                closeQuietly(fileOutputStream);
            }
        } catch (Throwable th) {
            closeQuietly(inputStreamOpen);
            throw th;
        }
    }

    public static void deleteFile(File file) {
        if (file == null) {
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (file.isDirectory() && fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    public static File getCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getDir("cache", 0);
        }
        if (cacheDir == null) {
            cacheDir = new File("/data/data/" + context.getPackageName() + "/app_cache");
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static File getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = context.getDir("files", 0);
        }
        if (filesDir == null) {
            filesDir = new File("/data/data/" + context.getPackageName() + "/app_files");
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return filesDir;
    }

    public static byte[] readFileContents(String str) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                closeQuietly(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(fileInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        closeQuietly(fileInputStream);
        return null;
    }

    public static void writeDatasToFile(String str, byte[] bArr) throws Throwable {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        writeLock.unlock();
                        closeQuietly(fileOutputStream2);
                        return;
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            writeLock.unlock();
            closeQuietly(fileOutputStream);
            return;
        }
        writeLock.unlock();
        closeQuietly(null);
    }
}
