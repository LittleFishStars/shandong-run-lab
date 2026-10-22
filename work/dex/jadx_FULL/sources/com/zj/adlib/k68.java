package com.zj.adlib;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.Utils;
import com.byazt.hv.TTDownloadField;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class k68 {
    public k68() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Set<String> a() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.a().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
        HashSet hashSet = new HashSet();
        if (runningServices == null || runningServices.size() == 0) {
            return null;
        }
        Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().service.getClassName());
        }
        return hashSet;
    }

    public static boolean b(@NonNull Class<?> cls) {
        return c(cls.getName());
    }

    public static void bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, int i) {
        try {
            bindService(Class.forName(str), serviceConnection, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean c(@NonNull String str) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.a().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() != 0) {
                Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().service.getClassName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void startService(@NonNull String str) {
        try {
            startService(Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean stopService(@NonNull String str) {
        try {
            return stopService(Class.forName(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void unbindService(@NonNull ServiceConnection serviceConnection) {
        Utils.a().unbindService(serviceConnection);
    }

    public static void bindService(@NonNull Class<?> cls, @NonNull ServiceConnection serviceConnection, int i) {
        bindService(new Intent(Utils.a(), cls), serviceConnection, i);
    }

    public static void startService(@NonNull Class<?> cls) {
        startService(new Intent(Utils.a(), cls));
    }

    public static boolean stopService(@NonNull Class<?> cls) {
        return stopService(new Intent(Utils.a(), cls));
    }

    public static void bindService(@NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i) {
        try {
            Utils.a().bindService(intent, serviceConnection, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startService(Intent intent) {
        try {
            intent.setFlags(32);
            Utils.a().startForegroundService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean stopService(@NonNull Intent intent) {
        try {
            return Utils.a().stopService(intent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
