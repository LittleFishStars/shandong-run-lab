package com.byazt.six;

import com.byazt.nr.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 502, 71})
public class x {
    public static com.byazt.ku.c c;

    public static void c() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(n.sp(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.byazt.ku.c cVarC = com.byazt.ku.c.c(new JSONObject(new String(bArr, "utf-8")));
                    if (cVarC != null) {
                        c = cVarC;
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        m.ve("Version", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static synchronized com.byazt.ku.c tt() {
        return c;
    }

    public static void uj() {
        ve.tt(n.sp(), tt(), "temp_pkg_info.json");
        c = null;
    }

    public static void ve() {
        ve.c(n.sp(), tt(), "temp_pkg_info.json");
    }

    public static boolean tt(com.byazt.ku.c cVar) {
        return ve.ve(tt(), cVar);
    }

    public static synchronized void c(com.byazt.ku.c cVar) {
        if (cVar != null) {
            if (cVar.a()) {
                c = cVar;
            }
        }
    }

    public static boolean c(String str) {
        return ve.c(tt(), str);
    }
}
