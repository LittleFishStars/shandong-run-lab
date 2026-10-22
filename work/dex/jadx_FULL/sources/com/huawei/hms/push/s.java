package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class s {
    public static int a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    HMSLog.i(com.ipd.dsp.internal.n.t.c, "Error-resourceType=" + str + "--resourceName=" + str2 + "--resourceId =" + identifier);
                }
            }
            return identifier;
        } catch (ClassNotFoundException e) {
            HMSLog.e(com.ipd.dsp.internal.n.t.c, "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e);
            return 0;
        } catch (IllegalAccessException e2) {
            HMSLog.e(com.ipd.dsp.internal.n.t.c, "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (NoSuchFieldException e3) {
            HMSLog.e(com.ipd.dsp.internal.n.t.c, "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e3);
            return 0;
        } catch (NumberFormatException e4) {
            HMSLog.e(com.ipd.dsp.internal.n.t.c, "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e4);
            return 0;
        } catch (IllegalArgumentException e5) {
            HMSLog.e(com.ipd.dsp.internal.n.t.c, "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e5);
            return 0;
        }
    }

    public static int a(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.w(com.ipd.dsp.internal.n.t.c, "load meta data resource failed.");
            return 0;
        }
    }
}
