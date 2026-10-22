package com.byazt.wr;

import com.byazt.nr.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1361, 46})
public class n implements com.byazt.yy.c, com.byazt.yy.tt {
    public static Method c = null;
    public static Method tt = null;
    public static boolean ve = false;
    public final boolean n;
    public final com.byazt.iy.ve uj;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            c = cls.getDeclaredMethod("readMapXml", InputStream.class);
            tt = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            c.setAccessible(true);
            tt.setAccessible(true);
            ve = true;
        } catch (Exception unused) {
            ve = false;
        }
    }

    public n(com.byazt.iy.ve veVar) {
        this.uj = veVar;
        this.n = false;
    }

    public static boolean c() {
        return ve;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.byazt.yy.c
    public Map<String, Object> c(File file) throws Throwable {
        Exception e;
        BufferedInputStream bufferedInputStream;
        if (ve && file.exists()) {
            BufferedInputStream bufferedInputStream2 = null;
            if (!file.canRead()) {
                m.tt("PropReaderWriter", "can't read file ".concat(String.valueOf(file)));
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 49152);
                try {
                    try {
                        Map<String, Object> mapC = new com.byazt.et.tt().c((Map) c.invoke(null, bufferedInputStream), this.uj, this.n);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused) {
                        }
                        return mapC;
                    } catch (Exception e2) {
                        e = e2;
                        m.tt("XmlReader", "read file exception: ".concat(String.valueOf(file)), e);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return Collections.emptyMap();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return Collections.emptyMap();
    }

    public n(com.byazt.iy.ve veVar, boolean z) {
        this.uj = veVar;
        this.n = z;
    }

    @Override // com.byazt.yy.tt
    public void c(Map<String, Object> map, File file) throws Throwable {
        if (!ve || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    tt.invoke(null, new com.byazt.et.tt().c(map, this.uj, this.n), fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    m.tt("XmlReader", "write: to file exception: ".concat(String.valueOf(file)), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
