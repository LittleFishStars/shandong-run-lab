package com.ali.auth.third.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceUtils {
    public static final String TAG = "ResourceUtils";

    public static float getDimen(Context context, String str) {
        Resources resources = KernelContext.resources;
        if (resources == null) {
            resources = context.getResources();
        }
        return resources.getDimension(getIdentifier(context, "dimen", str));
    }

    public static int getIdentifier(Context context, String str, String str2) {
        String packageName = !TextUtils.isEmpty(KernelContext.packageName) ? KernelContext.packageName : context.getPackageName();
        SDKLogger.i("resources", "resources = " + KernelContext.resources + " packageName = " + KernelContext.packageName);
        Resources resources = KernelContext.resources;
        return resources != null ? resources.getIdentifier(str2, str, packageName) : context.getResources().getIdentifier(str2, str, packageName);
    }

    public static int getIdentifier(String str, String str2) {
        return getIdentifier(KernelContext.getApplicationContext(), str, str2);
    }

    public static int getRDrawable(Context context, String str) {
        return getIdentifier(context, "drawable", str);
    }

    public static int getRId(Context context, String str) {
        return getIdentifier(context, "id", str);
    }

    public static int getRLayout(Context context, String str) {
        return getIdentifier(context, "layout", str);
    }

    public static int getRLayout(String str) {
        return getIdentifier(KernelContext.getApplicationContext(), "layout", str);
    }

    public static String getString(Context context, String str) {
        Resources resources = KernelContext.resources;
        if (resources == null) {
            resources = context.getResources();
        }
        return resources.getString(getIdentifier(context, TypedValues.Custom.S_STRING, str));
    }

    public static String getString(String str) {
        return getString(KernelContext.getApplicationContext(), str);
    }
}
