package com.alibaba.analytics.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.analytics.a.p;
import com.alibaba.analytics.a.u;
import com.alibaba.analytics.a.w;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.ut.device.UTDevice;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    private static String Y = "/system/bin/setprop";
    private static String Z = "/system/bin/monkey";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f23769a;

    public static void a(Context context, String str, String str2) {
        e eVarB;
        String strB;
        if (context == null || u.isEmpty(str) || u.isEmpty(str2) || (eVarB = d.b(context)) == null) {
            return;
        }
        String strB2 = null;
        try {
            strB = com.alibaba.analytics.a.c.b(str.getBytes("UTF-8"));
            try {
                strB2 = com.alibaba.analytics.a.c.b(str2.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            strB = null;
        }
        if (u.isEmpty(strB) || u.isEmpty(strB2)) {
            return;
        }
        eVarB.putString("EI", strB);
        eVarB.putString("SI", strB2);
        eVarB.commit();
    }

    private static c b(Context context) {
        if (context == null) {
            return null;
        }
        c cVarA = a(context);
        cVarA.setUtdid(UTDevice.getUtdid(context));
        if (u.isEmpty(cVarA.getImei())) {
            cVarA.setImei(p.getImei(context));
        }
        if (u.isEmpty(cVarA.getImsi())) {
            cVarA.setImsi(p.getImsi(context));
        }
        return cVarA;
    }

    public static synchronized c c(Context context) {
        TimeZone timeZone;
        c cVar = f23769a;
        if (cVar != null) {
            return cVar;
        }
        if (context == null) {
            return null;
        }
        c cVarB = b(context);
        if (cVarB != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager == null) {
                    return null;
                }
                cVarB.x(Build.MODEL);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    String str = packageInfo.versionName;
                    cVarB.F("" + packageInfo.versionCode);
                    cVarB.setAppVersion(str);
                } catch (Exception unused) {
                    cVarB.F("Unknown");
                    cVarB.setAppVersion("Unknown");
                }
                cVarB.E(Build.BRAND);
                cVarB.G("Android");
                if (r()) {
                    cVarB.G("aliyunos");
                }
                cVarB.H(Build.VERSION.RELEASE);
                Configuration configuration = new Configuration();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                Locale locale = configuration.locale;
                if (locale != null) {
                    cVarB.y(locale.getCountry());
                    cVarB.z(configuration.locale.toString());
                    Calendar calendar = Calendar.getInstance(configuration.locale);
                    if (calendar == null || (timeZone = calendar.getTimeZone()) == null) {
                        cVarB.A(PrepareException.ERROR_AUTH_FAIL);
                    } else {
                        cVarB.A("" + (timeZone.getRawOffset() / 3600000));
                    }
                } else {
                    cVarB.y("Unknown");
                    cVarB.z("Unknown");
                    cVarB.A(PrepareException.ERROR_AUTH_FAIL);
                }
                try {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    int i = displayMetrics.widthPixels;
                    int i2 = displayMetrics.heightPixels;
                    cVarB.j(i);
                    cVarB.k(i2);
                    if (i > i2) {
                        int i3 = i ^ i2;
                        i2 ^= i3;
                        i = i3 ^ i2;
                    }
                    cVarB.B(i2 + "*" + i);
                } catch (Exception unused2) {
                    cVarB.B("Unknown");
                }
                cVarB.C(com.alibaba.analytics.core.e.b.getAccess(com.alibaba.analytics.core.d.a().getContext()));
                cVarB.D(com.alibaba.analytics.core.e.b.getAccess(com.alibaba.analytics.core.d.a().getContext()));
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (u.isEmpty(networkOperatorName)) {
                    networkOperatorName = "";
                }
                cVarB.w(networkOperatorName);
                cVarB.v(w.z());
            } catch (Exception unused3) {
                return null;
            }
        }
        f23769a = cVarB;
        return cVarB;
    }

    private static boolean r() {
        String property = System.getProperty("java.vm.name");
        return (property != null && property.toLowerCase().contains("lemur")) || System.getProperty("ro.yunos.version") != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m109a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Alvin3", 0);
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("UTCommon", 0);
        if (sharedPreferences2 == null || sharedPreferences == null) {
            return;
        }
        String string = sharedPreferences.getString("EI", null);
        String string2 = sharedPreferences.getString("SI", null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return;
        }
        String string3 = sharedPreferences2.getString("EI", null);
        String string4 = sharedPreferences2.getString("SI", null);
        if (!string.equals(string3)) {
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            editorEdit.putString("EI", string);
            editorEdit.commit();
        }
        if (string2.equals(string4)) {
            return;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
        editorEdit2.putString("SI", string2);
        editorEdit2.commit();
    }

    public static c a(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        if (context != null) {
            m109a(context);
            e eVarB = d.b(context);
            String str5 = null;
            if (eVarB != null) {
                String string = eVarB.getString("EI");
                String string2 = eVarB.getString("SI");
                if (!u.isEmpty(string) && !u.isEmpty(string2) && !u.isEmpty(string)) {
                    try {
                        str2 = new String(com.alibaba.analytics.a.c.decode(string.getBytes("UTF-8")), "UTF-8");
                        try {
                            str3 = new String(com.alibaba.analytics.a.c.decode(string2.getBytes("UTF-8")), "UTF-8");
                            try {
                                str4 = new String(com.alibaba.analytics.a.c.decode(string.getBytes("UTF-8")), "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e = e;
                                e.printStackTrace();
                                str4 = null;
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                str4 = null;
                            }
                        } catch (UnsupportedEncodingException e3) {
                            e = e3;
                            str3 = null;
                        } catch (IOException e4) {
                            e = e4;
                            str3 = null;
                        }
                    } catch (UnsupportedEncodingException e5) {
                        e = e5;
                        str2 = null;
                        str3 = null;
                    } catch (IOException e6) {
                        e = e6;
                        str2 = null;
                        str3 = null;
                    }
                    if (!u.isEmpty(str2) && !u.isEmpty(str3) && !u.isEmpty(str4)) {
                        c cVar = new c();
                        cVar.setDeviceId(str4);
                        cVar.setImei(str2);
                        cVar.setImsi(str3);
                        return cVar;
                    }
                }
            }
            e eVarA = d.a(context);
            if (eVarA != null) {
                String string3 = eVarA.getString("EI");
                String string4 = eVarA.getString("SI");
                String string5 = eVarA.getString("DID");
                if (!u.isEmpty(string3) && !u.isEmpty(string4)) {
                    try {
                        str = new String(com.alibaba.analytics.a.c.decode(string3.getBytes("UTF-8")), "UTF-8");
                        try {
                            str5 = new String(com.alibaba.analytics.a.c.decode(string4.getBytes("UTF-8")), "UTF-8");
                        } catch (UnsupportedEncodingException e7) {
                            e = e7;
                            e.printStackTrace();
                        } catch (IOException e8) {
                            e = e8;
                            e.printStackTrace();
                        }
                    } catch (UnsupportedEncodingException e9) {
                        e = e9;
                        str = null;
                    } catch (IOException e10) {
                        e = e10;
                        str = null;
                    }
                    c cVar2 = new c();
                    cVar2.setDeviceId(string5);
                    cVar2.setImei(string3);
                    cVar2.setImsi(string4);
                    a(context, str, str5);
                    return cVar2;
                }
            }
        }
        c cVar3 = new c();
        String imei = p.getImei(context);
        String imsi = p.getImsi(context);
        cVar3.setImei(imei);
        cVar3.setImsi(imsi);
        cVar3.setDeviceId(imei);
        a(context, imei, imsi);
        return cVar3;
    }
}
