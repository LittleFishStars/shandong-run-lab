package com.czhj.devicehelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.czhj.sdk.logger.SigmobLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DeviceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29321a = "getSimState";
    private static final String b = "getImei";
    private static final String c = "getLine1Number";
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static String g = "";
    private static long h = 0;
    private static long i = 0;
    private static Handler j = null;
    private static Handler k = null;
    private static int l = 0;
    private static boolean m = false;
    private static String n;
    private static String o;
    private static String p;
    private static Thread q;
    private static Thread r;
    private static boolean s;
    private static int t;

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEI(Context context) {
        try {
            SigmobLog.d("private :getIMEI");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null) {
                return null;
            }
            String imei = telephonyManager.getImei();
            if (TextUtils.isEmpty(imei)) {
                try {
                    return telephonyManager.getDeviceId();
                } catch (Throwable unused) {
                    return telephonyManager.getMeid();
                }
            }
            if (imei != null) {
                return imei;
            }
            return null;
        } catch (Exception unused2) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getIMEI(Context context, int i2) {
        try {
            SigmobLog.d("private :getIMEI " + i2);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null) {
                return null;
            }
            String imei = telephonyManager.getImei(i2);
            if (TextUtils.isEmpty(imei)) {
                try {
                    return telephonyManager.getDeviceId(i2);
                } catch (Throwable unused) {
                    return telephonyManager.getMeid(i2);
                }
            }
            if (imei != null) {
                return imei;
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMSI(Context context) {
        return null;
    }

    public static String getMacAddress() {
        return "";
    }

    public static void getOAID(final Context context, final com.czhj.devicehelper.msaoaId.a.InterfaceC0616a interfaceC0616a) {
        if (!TextUtils.isEmpty(d)) {
            if (interfaceC0616a != null) {
                interfaceC0616a.a(e);
                return;
            }
            return;
        }
        if (t > 10) {
            if (interfaceC0616a != null) {
                interfaceC0616a.a("");
                return;
            }
            return;
        }
        h = System.currentTimeMillis();
        if (r == null) {
            Log.d("", "Thread create ,current thread num :" + Thread.activeCount());
            Thread thread = new Thread(new Runnable() { // from class: com.czhj.devicehelper.DeviceHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    SigmobLog.d("private  getOAID");
                    com.czhj.devicehelper.msaoaId.a.a(context, new com.czhj.devicehelper.msaoaId.a.InterfaceC0616a() { // from class: com.czhj.devicehelper.DeviceHelper.1.1
                        @Override // com.czhj.devicehelper.msaoaId.a.InterfaceC0616a
                        public void a(String str) {
                            String unused = DeviceHelper.d = str;
                            com.czhj.devicehelper.msaoaId.a.InterfaceC0616a interfaceC0616a2 = interfaceC0616a;
                            if (interfaceC0616a2 != null) {
                                interfaceC0616a2.a(str);
                            }
                            boolean unused2 = DeviceHelper.s = false;
                            if (DeviceHelper.j != null) {
                                DeviceHelper.j.removeCallbacksAndMessages(null);
                                Handler unused3 = DeviceHelper.j = null;
                            }
                        }
                    });
                }
            });
            r = thread;
            thread.start();
            t++;
            s = true;
            Handler handler = new Handler(Looper.getMainLooper());
            j = handler;
            handler.postDelayed(new Runnable() { // from class: com.czhj.devicehelper.DeviceHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DeviceHelper.r != null) {
                        boolean unused = DeviceHelper.s = false;
                        int unused2 = DeviceHelper.t = 11;
                        com.czhj.devicehelper.msaoaId.a.InterfaceC0616a interfaceC0616a2 = interfaceC0616a;
                        if (interfaceC0616a2 != null) {
                            interfaceC0616a2.a("");
                        }
                        if (DeviceHelper.j != null) {
                            DeviceHelper.j.removeCallbacksAndMessages(null);
                            Handler unused3 = DeviceHelper.j = null;
                        }
                    }
                }
            }, 10000L);
        }
    }

    public static String getVAID() {
        return f;
    }

    @SuppressLint({"MissingPermission"})
    public static String getWifiName(Context context) {
        return n;
    }

    @SuppressLint({"MissingPermission"})
    public static String getWifimac(Context context) {
        return "";
    }
}
