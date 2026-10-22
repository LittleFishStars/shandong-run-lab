package com.ali.auth.third.core.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.ReflectionUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeviceInfo {
    public static String deviceId;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f23417a;

        public a(Context context) {
            this.f23417a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DeviceInfo.deviceId = this.f23417a.getSharedPreferences("auth_sdk_device", 0).getString("deviceId", "");
                SDKLogger.e("DeviceInfo", "DeviceInfo.deviceId = " + DeviceInfo.deviceId);
            } catch (Throwable unused) {
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f23418a;

        public b(Context context) {
            this.f23418a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SharedPreferences.Editor editorEdit = this.f23418a.getSharedPreferences("auth_sdk_device", 0).edit();
                editorEdit.putString("deviceId", DeviceInfo.deviceId);
                editorEdit.apply();
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(Context context) {
        MemberExecutorService memberExecutorService;
        Runnable bVar;
        Class<?> clsLoadClassQuietly = ReflectionUtils.loadClassQuietly("com.ta.utdid2.device.UTDevice");
        String str = null;
        if (clsLoadClassQuietly != null) {
            try {
                Object objInvoke = clsLoadClassQuietly.getMethod("getUtdid", Context.class).invoke(null, context);
                if (objInvoke == null) {
                    SDKLogger.e("DeviceInfo", "get utdid null");
                } else {
                    str = (String) objInvoke;
                }
            } catch (Exception unused) {
                SDKLogger.e("DeviceInfo", "get utdid error");
            }
        }
        if (str == null) {
            memberExecutorService = KernelContext.executorService;
            bVar = new a(context);
        } else {
            deviceId = str;
            SDKLogger.e("DeviceInfo", "utdid = " + str);
            memberExecutorService = KernelContext.executorService;
            bVar = new b(context);
        }
        memberExecutorService.postTask(bVar);
    }

    public static void init(Context context) {
        if (TextUtils.isEmpty(deviceId)) {
            a(context);
        }
    }
}
