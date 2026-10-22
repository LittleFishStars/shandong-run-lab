package com.byazt.nys;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 13})
public final class tt {
    private static File c(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File tt(Context context) {
        return c(new File(context.getCacheDir(), "pangle_com.byted.pangle"));
    }

    public static boolean uj(Context context) {
        File file = new File(context.getFilesDir(), "/pangle_p/com.byted.pangle");
        if (!file.exists()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.nys.tt.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                try {
                    Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                    String strGroup = matcher.find() ? matcher.group() : "";
                    return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > 7611;
                } catch (Exception e) {
                    com.byazt.bog.a.c(e);
                    return file2.getName().matches(sb.toString());
                }
            }
        });
        return (fileArrListFiles == null || fileArrListFiles.length == 0) ? false : true;
    }

    public static File ve(Context context) {
        return c(new File(context.getExternalCacheDir(), "pangle_com.byted.pangle"));
    }

    public static SharedPreferences tt(Context context, String str, int i) {
        return i == 0 ? com.byazt.ut.a.getKVStore(context, c(str), i) : com.byazt.ut.a.getKVStore(context, str, i);
    }

    public static File c(Context context) {
        return c(new File(context.getFilesDir(), "pangle_com.byted.pangle"));
    }

    public static File c(Context context, String str) {
        return c(new File(context.getExternalFilesDir(str), "pangle_com.byted.pangle"));
    }

    public static File c(Context context, String str, int i) {
        return i == 0 ? c(new File(context.getDir(str, i), "pangle_com.byted.pangle")) : context.getDir(str, i);
    }

    private static String c(String str) {
        return "pangle_com.byted.pangle_" + str;
    }
}
