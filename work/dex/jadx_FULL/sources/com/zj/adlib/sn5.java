package com.zj.adlib;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.Utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class sn5 {
    public sn5() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String a(@NonNull Activity activity, @NonNull String str) {
        return b(activity.getClass(), str);
    }

    public static String b(@NonNull Class<? extends Activity> cls, @NonNull String str) {
        try {
            return String.valueOf(Utils.a().getPackageManager().getActivityInfo(new ComponentName(Utils.a(), cls), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String c(@NonNull String str) {
        try {
            return String.valueOf(Utils.a().getPackageManager().getApplicationInfo(Utils.a().getPackageName(), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d(@NonNull BroadcastReceiver broadcastReceiver, @NonNull String str) {
        return d(broadcastReceiver, str);
    }

    public static String e(@NonNull Class<? extends BroadcastReceiver> cls, @NonNull String str) {
        try {
            return String.valueOf(Utils.a().getPackageManager().getReceiverInfo(new ComponentName(Utils.a(), cls), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String f(@NonNull Service service, @NonNull String str) {
        return g(service.getClass(), str);
    }

    public static String g(@NonNull Class<? extends Service> cls, @NonNull String str) {
        try {
            return String.valueOf(Utils.a().getPackageManager().getServiceInfo(new ComponentName(Utils.a(), cls), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
