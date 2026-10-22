package com.getui.gtc.base.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.byazt.hv.TTDownloadField;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommonUtil {
    private static File externalFilesDir;
    private static Boolean isAppDebug;

    public static class CommonUtilSubscriber implements Subscriber {
        private static final CommonUtilSubscriber INSTANCE = new CommonUtilSubscriber();
        private static String getInstanceMethodName;
        private ApplicationInfo applicationInfo;
        private PackageInfo packageInfo;

        private CommonUtilSubscriber() {
        }

        private Bundle createBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
            bundle.putString(ProcessSwitchContract.GET_INSTANCE, getInstanceMethodName);
            return bundle;
        }

        public static CommonUtilSubscriber getInstance() {
            getInstanceMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            return INSTANCE;
        }

        public ApplicationInfo getAppInfoForSelf(Context context) {
            try {
                if (!CommonUtil.isGtcProcess()) {
                    GtcProvider.setContext(context);
                    Bundle bundleCreateBundle = createBundle();
                    bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "base-1-3-1");
                    return (ApplicationInfo) Broker.getInstance().subscribe(bundleCreateBundle).getParcelable(ProcessSwitchContract.METHOD_RETURN);
                }
                if (this.applicationInfo == null) {
                    if (context == null) {
                        context = CommonUtil.findAppContext();
                    }
                    this.applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                }
                return this.applicationInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public PackageInfo getPackageInfoForSelf(Context context) {
            try {
                if (!CommonUtil.isGtcProcess()) {
                    GtcProvider.setContext(context);
                    Bundle bundleCreateBundle = createBundle();
                    bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "base-1-2-1");
                    return (PackageInfo) Broker.getInstance().subscribe(bundleCreateBundle).getParcelable(ProcessSwitchContract.METHOD_RETURN);
                }
                if (this.packageInfo == null) {
                    if (context == null) {
                        context = CommonUtil.findAppContext();
                    }
                    this.packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 79);
                }
                return this.packageInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public boolean isAppForeground() {
            try {
                if (CommonUtil.isGtcProcess()) {
                    return GtcProvider.isForeground();
                }
                Bundle bundleCreateBundle = createBundle();
                bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "base-1-1-1");
                return Broker.getInstance().subscribe(bundleCreateBundle).getBoolean(ProcessSwitchContract.METHOD_RETURN);
            } catch (Throwable unused) {
                return false;
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0052  */
        @Override // com.getui.gtc.base.publish.Subscriber
        public void receive(Bundle bundle, Bundle bundle2) {
            byte b;
            Parcelable packageInfoForSelf;
            ArrayList arrayList = new ArrayList();
            try {
                Throwable th = (Throwable) bundle2.getSerializable(ProcessSwitchContract.METHOD_EXCEPTION);
                if (th != null) {
                    arrayList.add(th);
                }
                String string = bundle.getString(ProcessSwitchContract.METHOD_NAME);
                if (TextUtils.isEmpty(string)) {
                    throw new RuntimeException("methodName missed");
                }
                int iHashCode = string.hashCode();
                if (iHashCode != -1969640451) {
                    if (iHashCode != -1969639490) {
                        if (iHashCode == -1969638529 && string.equals("base-1-3-1")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (string.equals("base-1-2-1")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (string.equals("base-1-1-1")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b != 0) {
                    if (b == 1) {
                        packageInfoForSelf = getPackageInfoForSelf(GtcProvider.context());
                    } else if (b == 2) {
                        packageInfoForSelf = getAppInfoForSelf(GtcProvider.context());
                    }
                    bundle2.putParcelable(ProcessSwitchContract.METHOD_RETURN, packageInfoForSelf);
                } else {
                    bundle2.putBoolean(ProcessSwitchContract.METHOD_RETURN, isAppForeground());
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Throwable) it.next()).printStackTrace();
                }
            } catch (Throwable th2) {
                try {
                    arrayList.add(th2);
                } finally {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((Throwable) it2.next()).printStackTrace();
                    }
                }
            }
        }
    }

    public static void checkRuntimePermission(Context context, String str, boolean z) throws Throwable {
        if (hasPermission(context, str, z)) {
            return;
        }
        throw new IllegalStateException("permission " + str + " not granted");
    }

    public static Context findAppContext() {
        try {
            Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD).getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Context) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static ApplicationInfo getAppInfoForSelf(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo appInfoForSelf = CommonUtilSubscriber.getInstance().getAppInfoForSelf(context);
        if (appInfoForSelf != null) {
            return appInfoForSelf;
        }
        throw new PackageManager.NameNotFoundException();
    }

    public static File getExternalFilesDir(Context context) {
        if (externalFilesDir == null) {
            if (context == null) {
                context = findAppContext();
            }
            externalFilesDir = context.getExternalFilesDir(null);
        }
        return externalFilesDir;
    }

    public static PackageInfo getPackageInfoForSelf(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfoForSelf = CommonUtilSubscriber.getInstance().getPackageInfoForSelf(context);
        if (packageInfoForSelf != null) {
            return packageInfoForSelf;
        }
        throw new PackageManager.NameNotFoundException();
    }

    public static String getProcessName() {
        String processName;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
            } else {
                Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD).getDeclaredMethod(TRiverConstants.KEY_CURRENT_PROCESS_NAME, new Class[0]);
                declaredMethod.setAccessible(true);
                processName = (String) declaredMethod.invoke(null, new Object[0]);
            }
            return processName;
        } catch (Throwable th) {
            th.printStackTrace();
            String processNameByPid = getProcessNameByPid(Process.myPid());
            return !TextUtils.isEmpty(processNameByPid) ? processNameByPid : "unknown.process";
        }
    }

    private static String getProcessNameByPid(int i) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line)) {
                    line = line.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return line;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static Activity getTopActivity() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static boolean hasPermission(Context context, String str, boolean z) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static boolean isAppDebugEnable() {
        if (GtcProvider.context() == null) {
            return false;
        }
        if (isAppDebug == null) {
            try {
                isAppDebug = Boolean.valueOf((GtcProvider.context().getApplicationInfo().flags & 2) != 0);
            } catch (Throwable unused) {
                return false;
            }
        }
        return isAppDebug.booleanValue();
    }

    public static boolean isAppForeground() {
        return CommonUtilSubscriber.getInstance().isAppForeground();
    }

    public static boolean isGtcProcess() {
        return Process.myPid() == GtcProvider.gtcPid();
    }

    public static boolean isMainProcess() {
        return isMainProcess(GtcProvider.context());
    }

    public static boolean isMainProcess(Context context) {
        if (context == null) {
            try {
                context = findAppContext();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (context != null) {
            String str = context.getApplicationInfo().processName;
            return str != null && str.equals(getProcessName());
        }
        return false;
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
