package com.kwad.library.solder.lib.d;

import android.text.TextUtils;
import com.kwad.sdk.utils.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    public static File a(File file, String str, File file2) throws IOException {
        String strEx = a.Ex();
        if (!TextUtils.isEmpty(strEx)) {
            StringBuilder sb = new StringBuilder("lib");
            String str2 = File.separator;
            sb.append(str2);
            sb.append(strEx);
            sb.append(str2);
            sb.append(str);
            File file3 = new File(file, sb.toString());
            if (file3.exists()) {
                File file4 = new File(file2, str);
                if (!file3.renameTo(file4)) {
                    throw new IOException("Rename soLib fail.");
                }
                file3.getAbsolutePath();
                file4.getAbsolutePath();
                return file4;
            }
        }
        return null;
    }

    public static Set<String> b(File file, File file2) throws Throwable {
        ZipFile zipFile;
        Closeable closeable;
        BufferedInputStream bufferedInputStream;
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        y.aa(file2);
        file2.getAbsolutePath();
        file.getName();
        BufferedInputStream bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                closeable = null;
                while (enumerationEntries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        String name = zipEntryNextElement.getName();
                        if (name != null && !name.contains("../")) {
                            if (!name.startsWith("lib" + File.separator)) {
                                continue;
                            } else if (zipEntryNextElement.isDirectory()) {
                                File file3 = new File(file2, name);
                                file3.getAbsolutePath();
                                y.aa(file3);
                            } else {
                                File file4 = new File(file2, name);
                                file4.getAbsolutePath();
                                y.ab(file4);
                                byte[] bArr = new byte[4096];
                                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                try {
                                    FileDescriptor fd = fileOutputStream.getFD();
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntryNextElement));
                                        while (true) {
                                            try {
                                                int i = bufferedInputStream.read(bArr);
                                                if (i == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, i);
                                            } catch (IOException e) {
                                                e = e;
                                                zipFile2 = zipFile;
                                                closeable = bufferedOutputStream;
                                                try {
                                                    com.kwad.library.solder.lib.a.e("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile2;
                                                    bufferedInputStream2 = bufferedInputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                bufferedInputStream2 = bufferedInputStream;
                                                closeable = bufferedOutputStream;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        fd.sync();
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                                        hashSet.add(file4.getName());
                                        bufferedInputStream2 = bufferedInputStream;
                                        closeable = bufferedOutputStream;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedInputStream = bufferedInputStream2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    closeable = fileOutputStream;
                                    bufferedInputStream = bufferedInputStream2;
                                    zipFile2 = zipFile;
                                    com.kwad.library.solder.lib.a.e("plugin.so", e);
                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable = fileOutputStream;
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                return hashSet;
            } catch (IOException e5) {
                e = e5;
                closeable = null;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                closeable = null;
            }
        } catch (IOException e6) {
            e = e6;
            closeable = null;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            closeable = null;
        }
    }
}
