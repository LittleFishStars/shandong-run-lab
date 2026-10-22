package com.byazt.nu;

import android.content.Context;
import com.byazt.bog.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 137, 13})
public class tt {
    public static int c(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception e) {
            a.c(e);
            return 0;
        }
    }

    public static int tt(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "style", "android");
        } catch (Exception e) {
            a.c(e);
            return 0;
        }
    }

    public static int ve(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Exception e) {
            a.c(e);
            return 0;
        }
    }

    public static int tt(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            a.c(e);
            return 0;
        }
    }

    public static int c(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            a.c(e);
            return 0;
        }
    }
}
