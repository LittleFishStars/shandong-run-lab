package com.baidu.b.e;

import android.content.Context;
import com.baidu.b.c.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26295a;
    private C0258a b;

    /* JADX INFO: renamed from: com.baidu.b.e.a$a, reason: collision with other inner class name */
    public final class C0258a {
        private File b;
        private String c;
        private C0258a d;
        private boolean e = true;

        public C0258a(File file) {
            this.b = file;
            this.c = file.getName();
        }

        public C0258a(String str, C0258a c0258a) {
            this.c = str;
            this.d = c0258a;
        }

        public C0258a a(File file) {
            if (this.e) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0258a c0258aD = this;
            do {
                arrayList.add(c0258aD.c());
                c0258aD = c0258aD.d();
            } while (c0258aD != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return a.this.new C0258a(file);
        }

        public C0258a a(String str) {
            return a.this.new C0258a(str, this);
        }

        public String a(String str, boolean z) {
            return a.a(b(), str, "UTF-8", z);
        }

        public void a() {
            b().mkdirs();
        }

        public boolean a(String str, String str2, boolean z) {
            return a.a(b(), str, str2, "UTF-8", z);
        }

        public File b() {
            File file = this.b;
            if (file != null) {
                return file;
            }
            File file2 = this.d == null ? new File(a.this.a(), this.c) : new File(this.d.b(), this.c);
            this.b = file2;
            return file2;
        }

        public String c() {
            return this.c;
        }

        public C0258a d() {
            return this.d;
        }
    }

    public a(Context context) {
        this.f26295a = context;
        c().mkdirs();
    }

    public static String a(File file, String str, String str2, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        a(file);
        File file2 = new File(file, str);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (z) {
                        byteArray = new c().b(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    com.baidu.b.f.c.a(fileInputStream);
                    com.baidu.b.f.c.a(byteArrayOutputStream2);
                    return str3;
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.baidu.b.f.c.a(fileInputStream);
                    com.baidu.b.f.c.a(byteArrayOutputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.baidu.b.f.c.a(fileInputStream);
                    com.baidu.b.f.c.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                fileInputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                th = th2;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void a(File file) {
        file.mkdirs();
    }

    public static boolean a(File file, String str, String str2, String str3, boolean z) throws Throwable {
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream2.write(new c().a(str2.getBytes()));
                } else {
                    fileOutputStream2.write(str2.getBytes(str3));
                }
                com.baidu.b.f.c.a(fileOutputStream2);
                return true;
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                com.baidu.b.f.c.a(fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                com.baidu.b.f.c.a(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private File c() {
        return new File(a(), ".cesium");
    }

    public File a() {
        return new File(this.f26295a.getApplicationInfo().dataDir);
    }

    public synchronized C0258a b() {
        if (this.b == null) {
            this.b = new C0258a(".cesium", null);
        }
        return this.b;
    }
}
