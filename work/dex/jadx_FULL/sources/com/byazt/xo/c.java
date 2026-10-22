package com.byazt.xo;

import android.text.TextUtils;
import com.byazt.by.ve;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1047, 20})
public class c {
    public static AtomicBoolean c;

    public static boolean a() {
        return p.ve;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    public static boolean c() {
        boolean z;
        try {
            AtomicBoolean atomicBoolean = c;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            File file = new File(sp.c(gt.getContext(), false, null).getParent(), "/pangle_p/com.byted.pangle");
            file.getAbsolutePath();
            if (file.exists()) {
                final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
                file.listFiles();
                File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.xo.c.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (file2 == null) {
                            return false;
                        }
                        try {
                            int i = p.uj;
                            Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                            String strGroup = matcher.find() ? matcher.group() : "";
                            return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > i;
                        } catch (Exception e) {
                            m.c(e);
                            return file2.getName().matches(sb.toString());
                        }
                    }
                });
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            c(z);
            return z;
        } catch (Throwable th) {
            m.c(th);
            return false;
        }
    }

    public static int n() {
        return p.ve ? 1 : 0;
    }

    public static boolean sp() {
        return a() && x.m().d();
    }

    public static boolean tt() {
        return a() && uj() && c();
    }

    public static boolean uj() {
        return ve.c().i() == 0;
    }

    public static boolean ve() {
        boolean z = p.ve;
        return false;
    }

    public static boolean x() {
        return ve.c().da();
    }

    public static void c(boolean z) {
        if (c == null) {
            c = new AtomicBoolean();
        }
        c.set(z);
        x.m().z();
    }
}
