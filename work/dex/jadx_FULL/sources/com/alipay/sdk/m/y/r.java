package com.alipay.sdk.m.y;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r {
    public static void a(String str, String str2) throws IOException {
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Failed to create destination directory: " + str2);
        }
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        fileInputStream.close();
                        return;
                    }
                    File file2 = new File(file, nextEntry.getName());
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath() + File.separator)) {
                        throw new IOException("Zip entry is trying to escape the target directory: " + nextEntry.getName());
                    }
                    if (!nextEntry.isDirectory()) {
                        File parentFile = file2.getParentFile();
                        if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                            throw new IOException("Failed to create parent directory: " + parentFile.getAbsolutePath());
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                try {
                                    zipInputStream.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                                throw th;
                            }
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } else if (!file2.isDirectory() && !file2.mkdirs()) {
                        throw new IOException("Failed to create directory: " + file2.getAbsolutePath());
                    }
                    zipInputStream.closeEntry();
                } catch (Throwable th4) {
                    zipInputStream.close();
                    throw th4;
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th5) {
                    th.addSuppressed(th5);
                }
                throw th;
            }
        } catch (Throwable th6) {
            fileInputStream.close();
            throw th6;
        }
    }
}
