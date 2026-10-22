package com.alibaba.ariver.commonability.file.fs.a.d;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24021a = "TinyAppZipUtils";

    public static boolean a(InputStream inputStream, String str) throws Throwable {
        byte[] bArrA = com.alibaba.ariver.commonability.file.a.a.a(2048);
        Closeable closeable = null;
        try {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                            com.alibaba.ariver.commonability.file.a.a.a((Closeable) zipInputStream);
                            return true;
                        }
                        String name = nextEntry.getName();
                        if (TextUtils.isEmpty(name)) {
                            RVLogger.w(f24021a, "zipEntry is illegal");
                        } else if (name.startsWith("../") || name.endsWith("/..") || name.contains("/../")) {
                            RVLogger.w(f24021a, "zipEntry is illegal");
                        } else {
                            File file = new File(str + name);
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
                                            int i = zipInputStream.read(bArrA);
                                            if (i <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArrA, 0, i);
                                        } catch (Throwable th) {
                                            th = th;
                                            closeable = fileOutputStream;
                                            com.alibaba.ariver.commonability.file.a.a.a(closeable);
                                            throw th;
                                        }
                                    }
                                    com.alibaba.ariver.commonability.file.a.a.a(fileOutputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        closeable = zipInputStream;
                        RVLogger.e(f24021a, e);
                        com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                        com.alibaba.ariver.commonability.file.a.a.a(closeable);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = zipInputStream;
                        com.alibaba.ariver.commonability.file.a.a.a(bArrA);
                        com.alibaba.ariver.commonability.file.a.a.a(closeable);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean a(String str, String str2) {
        try {
            return a(new FileInputStream(str), str2);
        } catch (FileNotFoundException e) {
            RVLogger.e(f24021a, c.f25231a, e);
            return false;
        }
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("../") || str.endsWith("/..") || str.contains("/../");
    }
}
