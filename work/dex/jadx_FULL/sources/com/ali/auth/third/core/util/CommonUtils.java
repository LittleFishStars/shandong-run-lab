package com.ali.auth.third.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.FailureCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.model.ResultCode;
import com.byazt.hv.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CommonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f23446a;
    public static String mAppLabel;
    public static String mAppVersion;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FailureCallback f23447a;
        final /* synthetic */ Message b;

        public a(FailureCallback failureCallback, Message message) {
            this.f23447a = failureCallback;
            this.b = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            FailureCallback failureCallback = this.f23447a;
            if (failureCallback != null) {
                Message message = this.b;
                failureCallback.onFailure(message.code, message.message);
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FailureCallback f23448a;
        final /* synthetic */ ResultCode b;

        public b(FailureCallback failureCallback, ResultCode resultCode) {
            this.f23448a = failureCallback;
            this.b = resultCode;
        }

        @Override // java.lang.Runnable
        public void run() {
            FailureCallback failureCallback = this.f23448a;
            if (failureCallback != null) {
                ResultCode resultCode = this.b;
                failureCallback.onFailure(resultCode.code, resultCode.message);
            }
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FailureCallback f23449a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        public c(FailureCallback failureCallback, int i, String str) {
            this.f23449a = failureCallback;
            this.b = i;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            FailureCallback failureCallback = this.f23449a;
            if (failureCallback != null) {
                failureCallback.onFailure(this.b, this.c);
            }
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f23450a;

        public d(String str) {
            this.f23450a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(KernelContext.getApplicationContext(), ResourceUtils.getString(this.f23450a), 0).show();
        }
    }

    public static String getAndroidAppVersion() {
        return "android_" + getAppVersion();
    }

    public static String getAndroidId() {
        return Settings.Secure.getString(KernelContext.getApplicationContext().getContentResolver(), "android_id");
    }

    public static String getAppLabel() {
        if (mAppLabel == null) {
            try {
                PackageManager packageManager = KernelContext.getApplicationContext().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    mAppVersion = packageInfo.versionName;
                    mAppLabel = "" + ((Object) packageManager.getApplicationLabel(packageInfo.applicationInfo));
                }
            } catch (Throwable unused) {
            }
        }
        return mAppLabel;
    }

    public static String getAppVersion() {
        if (mAppVersion == null) {
            try {
                PackageManager packageManager = KernelContext.getApplicationContext().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    mAppVersion = packageInfo.versionName;
                    mAppLabel = "" + ((Object) packageManager.getApplicationLabel(packageInfo.applicationInfo));
                }
            } catch (PackageManager.NameNotFoundException | Exception e) {
                e.printStackTrace();
            }
        }
        return mAppVersion;
    }

    public static String getCurrentProcessName() {
        if (KernelContext.context == null) {
            return null;
        }
        String str = f23446a;
        if (str != null) {
            return str;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) KernelContext.context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    String str2 = runningAppProcessInfo.processName;
                    f23446a = str2;
                    return str2;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String getHashString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString(b2 & com.google.common.base.a.q));
        }
        return sb.toString();
    }

    public static String getLocalIPAddress() {
        return "";
    }

    public static String getTotalMemory() {
        long jIntValue;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String line = bufferedReader.readLine();
            String[] strArrSplit = line.split("\\s+");
            for (String str : strArrSplit) {
                Log.i(line, str + "\t");
            }
            jIntValue = Integer.valueOf(strArrSplit[1]).intValue();
            try {
                bufferedReader.close();
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            jIntValue = 0;
        }
        return jIntValue + " KB";
    }

    public static boolean isNetworkAvailable() {
        if (KernelContext.context == null) {
            return true;
        }
        return isNetworkAvailable(KernelContext.context);
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING)) {
                return true;
            }
        }
        return false;
    }

    public static void onFailure(FailureCallback failureCallback, int i, String str) {
        KernelContext.executorService.postUITask(new c(failureCallback, i, str));
    }

    public static void onFailure(FailureCallback failureCallback, Message message) {
        KernelContext.executorService.postUITask(new a(failureCallback, message));
    }

    public static void onFailure(FailureCallback failureCallback, ResultCode resultCode) {
        KernelContext.executorService.postUITask(new b(failureCallback, resultCode));
    }

    public static void sendBroadcast(LoginAction loginAction) {
        Intent intent = new Intent();
        intent.setAction(loginAction.name());
        intent.setPackage(KernelContext.getApplicationContext().getPackageName());
        KernelContext.getApplicationContext().sendBroadcast(intent);
    }

    public static String toString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void toast(String str) {
        KernelContext.executorService.postUITask(new d(str));
    }

    public static void toastSystemException() {
        toast("com_taobao_tae_sdk_system_exception");
    }
}
