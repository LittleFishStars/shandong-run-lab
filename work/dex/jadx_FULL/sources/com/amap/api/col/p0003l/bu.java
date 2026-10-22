package com.amap.api.col.p0003l;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.zj.adlib.o61;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f25893a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f25895a = false;
    }

    public interface c {
        void a();

        void a(long j);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bq f25896a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public b f749a = new b();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f750a;
        public String b;
        public String c;

        public d(br brVar, bq bqVar) {
            this.f25896a = null;
            this.f750a = brVar.x();
            this.b = brVar.y();
            this.f25896a = bqVar;
        }

        public final String a() {
            return this.f750a;
        }

        public final void b(String str) {
            if (str.length() > 1) {
                this.c = str;
            }
        }

        public final String c() {
            return this.b;
        }

        public final String d() {
            return this.c;
        }

        public final bq e() {
            return this.f25896a;
        }

        public final b f() {
            return this.f749a;
        }

        public final void g() {
            this.f749a.f25895a = true;
        }
    }

    public bu(br brVar, bq bqVar) {
        this.f25893a = new d(brVar, bqVar);
    }

    public static int a(File file, ZipInputStream zipInputStream, long j, long j2, c cVar, b bVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int i2 = zipInputStream.read(bArr, 0, 1024);
            if (i2 == -1) {
                bufferedOutputStream.close();
                return i;
            }
            if (bVar != null && bVar.f25895a) {
                bufferedOutputStream.close();
                return i;
            }
            bufferedOutputStream.write(bArr, 0, i2);
            i += i2;
            if (j2 > 0 && cVar != null) {
                long j3 = ((((long) i) + j) * 100) / j2;
                if (bVar == null || !bVar.f25895a) {
                    cVar.a(j3);
                }
            }
        }
    }

    public static void c(d dVar) {
        if (dVar == null) {
            return;
        }
        bq bqVarE = dVar.e();
        if (bqVarE != null) {
            bqVarE.p();
        }
        String strA = dVar.a();
        String strC = dVar.c();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strC)) {
            if (dVar.f().f25895a) {
                if (bqVarE != null) {
                    bqVarE.r();
                    return;
                }
                return;
            } else {
                if (bqVarE != null) {
                    bqVarE.q();
                    return;
                }
                return;
            }
        }
        File file = new File(strA);
        if (!file.exists()) {
            if (dVar.f().f25895a) {
                if (bqVarE != null) {
                    bqVarE.r();
                    return;
                }
                return;
            } else {
                if (bqVarE != null) {
                    bqVarE.q();
                    return;
                }
                return;
            }
        }
        File file2 = new File(strC);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        a aVar = new a(bqVarE);
        try {
            if (dVar.f().f25895a && bqVarE != null) {
                bqVarE.r();
            }
            e(file, file2, aVar, dVar);
            if (dVar.f().f25895a) {
                if (bqVarE != null) {
                    bqVarE.r();
                }
            } else if (bqVarE != null) {
                bqVarE.b(dVar.d());
            }
        } catch (Throwable unused) {
            if (dVar.f().f25895a) {
                if (bqVarE != null) {
                    bqVarE.r();
                }
            } else if (bqVarE != null) {
                bqVarE.q();
            }
        }
    }

    public static void d(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        d(parentFile);
        parentFile.mkdir();
    }

    public static void e(File file, File file2, c cVar, d dVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        b bVarF = dVar.f();
        long size = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (bVarF != null && bVarF.f25895a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!g(nextEntry.getName())) {
                            cVar.a();
                            break;
                        } else {
                            stringBuffer.append(nextEntry.getName());
                            stringBuffer.append(l.b);
                        }
                    }
                    size += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            dVar.b(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        f(file2, zipInputStream2, size, cVar, bVarF);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    public static void f(File file, ZipInputStream zipInputStream, long j, c cVar, b bVar) throws Exception {
        int iA = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (bVar != null && bVar.f25895a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!g(nextEntry.getName())) {
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            } else {
                File file2 = new File(str);
                d(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    iA += a(file2, zipInputStream, iA, j, cVar, bVar);
                }
                zipInputStream.closeEntry();
            }
        }
    }

    public static boolean g(String str) {
        return (str.contains("..") || str.contains(WVNativeCallbackUtil.SEPERATER) || str.contains(o61.h) || str.contains("%")) ? false : true;
    }

    public final void b() {
        d dVar = this.f25893a;
        if (dVar != null) {
            dVar.g();
        }
    }

    public final void h() {
        d dVar = this.f25893a;
        if (dVar != null) {
            c(dVar);
        }
    }

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bq f25894a;

        public a(bq bqVar) {
            this.f25894a = bqVar;
        }

        @Override // com.amap.api.col.3l.bu.c
        public final void a(long j) {
            try {
                bq bqVar = this.f25894a;
                if (bqVar != null) {
                    bqVar.a(j);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.amap.api.col.3l.bu.c
        public final void a() {
            bq bqVar = this.f25894a;
            if (bqVar != null) {
                bqVar.q();
            }
        }
    }
}
