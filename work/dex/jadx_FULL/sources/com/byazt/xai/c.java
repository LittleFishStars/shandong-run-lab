package com.byazt.xai;

import android.text.TextUtils;
import com.byazt.uq.a;
import com.igexin.push.core.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1690, 20})
public class c {
    public static String[] c(File file) throws Throwable {
        String strC;
        String str;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().startsWith("META-INF/")) {
                        if (zipEntryNextElement.getName().endsWith("MANIFEST.MF")) {
                            z3 = true;
                        } else if (zipEntryNextElement.getName().endsWith(".SF")) {
                            z = true;
                        } else if (zipEntryNextElement.getName().endsWith(".RSA")) {
                            z2 = true;
                        }
                        arrayList.add(Long.valueOf(zipEntryNextElement.getCrc()));
                    }
                }
                Collections.sort(arrayList, Collections.reverseOrder());
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append((Long) it.next());
                }
                if (z3 && z && z2) {
                    strC = a.c(sb.toString());
                    str = "";
                } else {
                    str = "without v1 signature.";
                    strC = "";
                }
                ve.c(zipFile2);
            } catch (Exception unused) {
                zipFile = zipFile2;
                ve.c(zipFile);
                strC = "";
                str = strC;
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                ve.c(zipFile);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        String[] strArr = new String[3];
        strArr[0] = strC;
        strArr[1] = TextUtils.isEmpty(strC) ? "" : g.e;
        strArr[2] = str;
        return strArr;
    }
}
