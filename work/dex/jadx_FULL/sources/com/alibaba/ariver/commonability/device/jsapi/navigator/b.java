package com.alibaba.ariver.commonability.device.jsapi.navigator;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class b {
    public abstract void a(Context context);

    public void a(Context context, String str) throws IllegalAccessException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            throw new IllegalAccessException();
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        RVLogger.e("PermissionPageManager", "resolve info list" + listQueryIntentActivities.size());
        for (int i = 0; i < listQueryIntentActivities.size(); i++) {
            RVLogger.e("PermissionPageManager", listQueryIntentActivities.get(i).activityInfo.packageName + listQueryIntentActivities.get(i).activityInfo.name);
        }
        ResolveInfo next = listQueryIntentActivities.iterator().next();
        if (next == null) {
            throw new IllegalAccessException();
        }
        ActivityInfo activityInfo = next.activityInfo;
        String str2 = activityInfo.packageName;
        String str3 = activityInfo.name;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(new ComponentName(str2, str3));
        context.startActivity(intent2);
    }

    public boolean b(Context context) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            RVLogger.e("openSystemSetting", e);
            return false;
        }
    }
}
