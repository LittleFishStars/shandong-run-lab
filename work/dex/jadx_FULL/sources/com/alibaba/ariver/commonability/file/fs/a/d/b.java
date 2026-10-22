package com.alibaba.ariver.commonability.file.fs.a.d;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24022a = "ZipFileInfo";
    private String b;
    private boolean c;
    private long d;
    private long e;
    private boolean f;

    private b() {
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public long c() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    public boolean e() {
        return this.f;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(long j) {
        this.d = j;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public static b b(String str) throws Exception {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    b bVar = new b();
                    bVar.b = str;
                    bVar.c = true;
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        String name = zipEntryNextElement.getName();
                        if (!bVar.f && (name.startsWith("../") || name.endsWith("/..") || name.contains("/../"))) {
                            bVar.f = true;
                        }
                        bVar.d += zipEntryNextElement.getSize();
                        bVar.e += zipEntryNextElement.getCompressedSize();
                    }
                    a(zipFile2);
                    return bVar;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    a(zipFile);
                    throw th;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a(long j) {
        this.e = j;
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Exception e) {
                RVLogger.e(f24022a, e);
            }
        }
    }
}
