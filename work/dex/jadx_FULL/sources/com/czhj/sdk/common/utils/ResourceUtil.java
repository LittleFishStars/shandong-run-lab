package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.czhj.sdk.logger.SigmobLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ResourceUtil {
    public static Context applcationContext;

    public static int getAnimId(Context context, String str) {
        return getIdentifierByType(context, str, "anim");
    }

    public static int getArrayId(Context context, String str) {
        return getIdentifierByType(context, str, "array");
    }

    public static int getAttrId(Context context, String str) {
        return getIdentifierByType(context, str, "attr");
    }

    public static int getBoolId(Context context, String str) {
        return getIdentifierByType(context, str, "bool");
    }

    public static int getColorId(Context context, String str) {
        return getIdentifierByType(context, str, "color");
    }

    public static int getDimenId(Context context, String str) {
        return getIdentifierByType(context, str, "dimen");
    }

    public static int getDrawableId(Context context, String str) {
        return getIdentifierByType(context, str, "drawable");
    }

    public static int getId(Context context, String str) {
        return getIdentifierByType(context, str, "id");
    }

    public static int getIdentifierByType(Context context, String str, String str2) {
        if (context == null) {
            SigmobLog.w("getIdentifierByType: originContext is null.");
            return 0;
        }
        String packageName = context.getPackageName();
        int identifier = context.getResources().getIdentifier(str, str2, packageName);
        SigmobLog.d("getIdentifierByType: originPackageName = " + packageName + ", resourceName = " + str + ", defType = " + str2 + ", identifier = " + identifier);
        Context context2 = applcationContext;
        if (context2 == null) {
            SigmobLog.w("getIdentifierByType: pluginContext is null.");
            return identifier;
        }
        if (identifier != 0) {
            return identifier;
        }
        String packageName2 = context2.getPackageName();
        int identifier2 = applcationContext.getResources().getIdentifier(str, str2, packageName2);
        SigmobLog.d("getIdentifierByType: pluginPackageName = " + packageName2 + ", resourceName " + str + ", defType = " + str2 + ", cusIdentifier = " + identifier2);
        return identifier2;
    }

    public static int getIntegerId(Context context, String str) {
        return getIdentifierByType(context, str, TypedValues.Custom.S_INT);
    }

    public static int getLayoutId(Context context, String str) {
        return getIdentifierByType(context, str, "layout");
    }

    public static int getMipmapId(Context context, String str) {
        return getIdentifierByType(context, str, "mipmap");
    }

    public static String getString(Context context, String str, String str2, Object... objArr) {
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        int stringId = getStringId(context, str);
        if (stringId == 0) {
            return str2;
        }
        Context context2 = applcationContext;
        Resources resources = context2 == null ? context.getResources() : context2.getResources();
        String string = objArr == null ? resources.getString(stringId) : resources.getString(stringId, objArr);
        SigmobLog.d("getString: str = " + string);
        return string;
    }

    public static int getStringId(Context context, String str) {
        return getIdentifierByType(context, str, TypedValues.Custom.S_STRING);
    }

    public static int getStyleId(Context context, String str) {
        return getIdentifierByType(context, str, "style");
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        LayoutInflater layoutInflaterFrom;
        View viewInflate = null;
        if (i == 0) {
            return null;
        }
        Context context2 = applcationContext;
        if (context2 != null && (layoutInflaterFrom = LayoutInflater.from(context2)) != null) {
            viewInflate = layoutInflaterFrom.inflate(i, viewGroup);
        }
        return (viewInflate != null || context == null) ? viewInflate : View.inflate(context, i, viewGroup);
    }

    public static void setApplicationContext(Context context) {
        applcationContext = context;
    }
}
