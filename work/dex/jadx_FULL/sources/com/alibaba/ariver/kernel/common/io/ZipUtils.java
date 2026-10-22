package com.alibaba.ariver.kernel.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.zj.adlib.o61;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ZipUtils {
    public static final String TAG = "AriverRes:ZipUtils";

    public static boolean unZip(ZipFile zipFile, String str) {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        MappedByteBuffer map;
        byte[] buf = IOUtils.getBuf(8192);
        try {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                FileOutputStream fileOutputStream = null;
                InputStream inputStream = null;
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String name = zipEntryNextElement.getName();
                    if (name.contains("../") || name.contains(o61.h) || name.contains("%")) {
                        RVLogger.d(TAG, "entryName " + name + " not safe!");
                    } else {
                        File file = new File(str + name);
                        if (zipEntryNextElement.isDirectory()) {
                            file.mkdirs();
                        } else {
                            File parentFile = file.getParentFile();
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                            if (zipEntryNextElement.getSize() < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH || zipEntryNextElement.getSize() > 5242880) {
                                RVLogger.d(TAG, "file size: " + zipEntryNextElement.getSize());
                                try {
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        inputStream = zipFile.getInputStream(zipEntryNextElement);
                                        while (true) {
                                            int i = inputStream.read(buf);
                                            if (i <= 0) {
                                                break;
                                            }
                                            fileOutputStream2.write(buf, 0, i);
                                        }
                                        IOUtils.closeQuietly(fileOutputStream2);
                                        IOUtils.closeQuietly(inputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        IOUtils.closeQuietly(fileOutputStream);
                                        IOUtils.closeQuietly(inputStream);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } else {
                                RVLogger.d(TAG, "unzip " + file.getName());
                                try {
                                    randomAccessFile = new RandomAccessFile(file, "rw");
                                    try {
                                        channel = randomAccessFile.getChannel();
                                        try {
                                            map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, zipEntryNextElement.getSize());
                                            try {
                                                inputStream = zipFile.getInputStream(zipEntryNextElement);
                                                if (zipEntryNextElement.getSize() > 0 && map != null && inputStream != null) {
                                                    while (true) {
                                                        int i2 = inputStream.read(buf);
                                                        if (i2 <= 0) {
                                                            break;
                                                        }
                                                        map.put(buf, 0, i2);
                                                    }
                                                } else {
                                                    RVLogger.w(TAG, " invalid ZipEntry size or mapped buffer!");
                                                }
                                                IOUtils.freeMappedBuffer(map);
                                                IOUtils.closeQuietly(channel);
                                                IOUtils.closeQuietly(randomAccessFile);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                try {
                                                    RVLogger.e(TAG, th);
                                                    IOUtils.freeMappedBuffer(map);
                                                    IOUtils.closeQuietly(channel);
                                                    IOUtils.closeQuietly(randomAccessFile);
                                                } catch (Throwable th4) {
                                                    IOUtils.freeMappedBuffer(map);
                                                    IOUtils.closeQuietly(channel);
                                                    IOUtils.closeQuietly(randomAccessFile);
                                                    IOUtils.closeQuietly(inputStream);
                                                    throw th4;
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            map = null;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        channel = null;
                                        map = channel;
                                        RVLogger.e(TAG, th);
                                        IOUtils.freeMappedBuffer(map);
                                        IOUtils.closeQuietly(channel);
                                        IOUtils.closeQuietly(randomAccessFile);
                                        IOUtils.closeQuietly(inputStream);
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    randomAccessFile = null;
                                    channel = null;
                                }
                                IOUtils.closeQuietly(inputStream);
                            }
                        }
                    }
                }
                IOUtils.returnBuf(buf);
                try {
                    zipFile.close();
                } catch (IOException e) {
                    RVLogger.e(TAG, "unzip Exception!", e);
                }
                return true;
            } catch (Throwable th8) {
                IOUtils.returnBuf(buf);
                if (zipFile == null) {
                    throw th8;
                }
                try {
                    zipFile.close();
                    throw th8;
                } catch (IOException e2) {
                    RVLogger.e(TAG, "unzip Exception!", e2);
                    throw th8;
                }
            }
        } catch (Exception e3) {
            RVLogger.e(TAG, e3);
            IOUtils.returnBuf(buf);
            if (zipFile == null) {
                return false;
            }
            try {
                zipFile.close();
                return false;
            } catch (IOException e4) {
                RVLogger.e(TAG, "unzip Exception!", e4);
                return false;
            }
        }
    }

    public static boolean unZip(InputStream inputStream, String str) throws Throwable {
        byte[] buf = IOUtils.getBuf(2048);
        boolean z = false;
        Closeable closeable = null;
        try {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains(o61.h) && !name.contains("%")) {
                            File file = new File(str, name);
                            if (nextEntry.isDirectory()) {
                                file.mkdirs();
                            } else {
                                File parentFile = file.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    while (true) {
                                        try {
                                            int i = zipInputStream.read(buf);
                                            if (i <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(buf, 0, i);
                                        } catch (Throwable th) {
                                            th = th;
                                            closeable = fileOutputStream;
                                            IOUtils.closeQuietly(closeable);
                                            throw th;
                                        }
                                    }
                                    IOUtils.closeQuietly(fileOutputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        } else {
                            RVLogger.d(TAG, "entryName " + name + " not safe!");
                        }
                    } catch (Exception e) {
                        e = e;
                        closeable = zipInputStream;
                        RVLogger.e(TAG, "unZip exception", e);
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(closeable);
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = zipInputStream;
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(closeable);
                        throw th;
                    }
                }
                IOUtils.returnBuf(buf);
                IOUtils.closeQuietly(zipInputStream);
                z = true;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return z;
    }

    public static boolean unZip(String str, String str2) {
        try {
            return unZip(new FileInputStream(str), str2);
        } catch (FileNotFoundException e) {
            RVLogger.e(TAG, c.f25231a, e);
            return false;
        }
    }
}
