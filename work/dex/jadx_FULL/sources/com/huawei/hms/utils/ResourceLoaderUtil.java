package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class ResourceLoaderUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f37697a;
    private static String b;

    public static int getAnimId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", b);
    }

    public static int getColorId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "color", b);
    }

    public static int getDimenId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", b);
    }

    public static Drawable getDrawable(String str) {
        Context context = f37697a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", b);
    }

    public static int getIdId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", b);
    }

    public static int getLayoutId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", b);
    }

    public static String getString(String str) {
        Context context = f37697a;
        return context == null ? "" : context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, b);
    }

    public static int getStyleId(String str) {
        Context context = f37697a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "style", b);
    }

    public static Context getmContext() {
        return f37697a;
    }

    public static void setmContext(Context context) {
        f37697a = context;
        if (context != null) {
            b = context.getPackageName();
        } else {
            b = null;
            HMSLog.e("ResourceLoaderUtil", "context is null");
        }
    }

    public static String getString(String str, Object... objArr) {
        Context context = f37697a;
        return context == null ? "" : context.getResources().getString(getStringId(str), objArr);
    }
}
