package com.hzchengdun.securityguard.open;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.ali.auth.third.core.model.SystemMessageConstants;
import com.byazt.hv.TTDownloadField;
import com.hzchengdun.securityguard.adapter.JNICLibrary;
import com.hzchengdun.securityguard.open.dynamicdataencrypt.DynamicDataEncryptComponent;
import com.hzchengdun.securityguard.open.dynamicdatastore.DynamicDataStoreComponent;
import com.hzchengdun.securityguard.open.safeToken.SafeTokenComponent;
import com.hzchengdun.securityguard.open.staticdataencrypt.StaticDataEncryptComponent;
import com.hzchengdun.securityguard.open.staticdatastore.StaticDataStoreComponent;
import com.hzchengdun.securityguard.open.unifiedsecurity.UnifiedSecurityComponent;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SecurityGuardManager {
    private static final int FLAG_CUSTOM_NATIVELIB_PATH = 4;
    private static SecurityGuardManager sInstance;
    private String mAuthCode = "";
    private Context mContext;
    private File mSGLibPath;
    private static final Map<Class<?>, Object> componentCacheMap = new ConcurrentHashMap();
    private static volatile boolean sInited = false;
    private static Object lock = new Object();
    private static final Object interfaceLock = new Object();
    private static volatile boolean isFirstCleanOldData = true;

    private SecurityGuardManager() {
    }

    private void cleanOutdatedFile(File file, String str) {
        File[] fileArrListFiles;
        if (file != null) {
            try {
                if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
                    return;
                }
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory() && file2.getName().startsWith("app_") && !file2.getName().equals(str)) {
                        deleteDir(file2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void deleteDir(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                deleteDir(new File(file, str));
            }
        }
        file.delete();
    }

    public static Context getContext() {
        return sInstance.mContext;
    }

    public static SecurityGuardManager getInstance(Context context, String str, File file) throws SecException {
        if (!sInited) {
            synchronized (lock) {
                if (!sInited) {
                    if (sInstance == null) {
                        sInstance = new SecurityGuardManager();
                    }
                    sInstance.init(context, str, file);
                }
            }
        }
        return sInstance;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0037  */
    private File getSGAppTimeDir(Context context) throws SecException {
        String str;
        if (context != null) {
            try {
                String str2 = context.getApplicationInfo().sourceDir;
                if (str2 != null) {
                    File file = new File(str2);
                    if (file.exists()) {
                        str = (file.lastModified() / 1000) + "";
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                }
            } catch (Throwable th) {
                throw new SecException(th, 115);
            }
        } else {
            str = null;
        }
        if (str == null) {
            throw new SecException(115);
        }
        File file2 = this.mSGLibPath;
        if (file2 == null || !file2.exists()) {
            throw new SecException(109);
        }
        File file3 = new File(this.mSGLibPath.getAbsolutePath(), "app_".concat(str));
        if (!file3.exists()) {
            file3.mkdirs();
        }
        if (isFirstCleanOldData && file3.exists()) {
            isFirstCleanOldData = false;
            cleanOutdatedFile(this.mSGLibPath, "app_".concat(str));
        }
        if (file3.exists()) {
            return file3;
        }
        throw new SecException(114);
    }

    private void init(Context context, String str, File file) throws SecException {
        int i;
        String str2;
        String strValueOf;
        String str3;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        long time = new Date().getTime();
        if (context == null) {
            throw new SecException(101);
        }
        this.mContext = context.getApplicationContext();
        if (str != null && !str.isEmpty()) {
            this.mAuthCode = str;
        }
        if (file == null || file.exists()) {
            this.mSGLibPath = context.getDir("SGLib", 0);
            i = 0;
        } else {
            this.mSGLibPath = file;
            i = 4;
        }
        this.mSGLibPath = getSGAppTimeDir(context);
        String packageName = context.getPackageName();
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            try {
                strValueOf = String.valueOf(Build.VERSION.RELEASE);
            } catch (Exception unused) {
                strValueOf = "";
            }
        } catch (Exception unused2) {
            str2 = "";
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            str3 = "";
        } else {
            str3 = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    str3 = runningAppProcessInfo.processName;
                }
            }
        }
        int iIntValue = ((Integer) JNICLibrary.doCommand(SystemMessageConstants.H5_LOGIN_FAILURE, context, Integer.valueOf(i), "", this.mSGLibPath.getAbsolutePath(), this.mAuthCode, packageName, str2, strValueOf, str3, 0)).intValue();
        long time2 = new Date().getTime() - time;
        System.out.println("init： " + time2 + "ms");
        if (iIntValue != 0) {
            throw new SecException(iIntValue);
        }
        sInited = true;
    }

    public <T> T getComponent(Class<T> cls) throws SecException {
        Map<Class<?>, Object> map = componentCacheMap;
        Object dynamicDataStoreComponent = map.get(cls);
        if (dynamicDataStoreComponent == null) {
            synchronized (interfaceLock) {
                try {
                    if (dynamicDataStoreComponent == null) {
                        if (cls == UnifiedSecurityComponent.class) {
                            dynamicDataStoreComponent = new UnifiedSecurityComponent();
                            map.put(cls, dynamicDataStoreComponent);
                        } else if (cls == StaticDataStoreComponent.class) {
                            dynamicDataStoreComponent = new StaticDataStoreComponent();
                            map.put(cls, dynamicDataStoreComponent);
                        } else if (cls == StaticDataEncryptComponent.class) {
                            dynamicDataStoreComponent = new StaticDataEncryptComponent();
                            map.put(cls, dynamicDataStoreComponent);
                        } else if (cls == DynamicDataEncryptComponent.class) {
                            dynamicDataStoreComponent = new DynamicDataEncryptComponent();
                            map.put(cls, dynamicDataStoreComponent);
                        } else if (cls == SafeTokenComponent.class) {
                            dynamicDataStoreComponent = new SafeTokenComponent();
                            map.put(cls, dynamicDataStoreComponent);
                        } else {
                            if (cls != DynamicDataStoreComponent.class) {
                                throw new SecException(141);
                            }
                            dynamicDataStoreComponent = new DynamicDataStoreComponent();
                            map.put(cls, dynamicDataStoreComponent);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return cls.cast(dynamicDataStoreComponent);
    }

    public static SecurityGuardManager getInstance(Context context, String str) throws SecException {
        return getInstance(context, str, null);
    }

    public static SecurityGuardManager getInstance(Context context) throws SecException {
        return getInstance(context, null);
    }
}
