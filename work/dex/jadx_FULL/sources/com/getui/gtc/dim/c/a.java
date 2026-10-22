package com.getui.gtc.dim.c;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.fl.saas.base.cache.DatabaseHelper;
import com.getui.gtc.base.annotation.MutableMethod;
import com.getui.gtc.base.util.CommonUtil;
import com.hjq.permissions.Permission;
import com.igexin.assist.util.AssistUtils;
import com.kuaishou.weapon.p0.g;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {
    private static final Map<String, String> c = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.a.1
        {
            put(AssistUtils.BRAND_HW, "ro.build.version.emui");
            put(AssistUtils.BRAND_HON, "ro.build.version.magic#ro.build.version.emui");
            put("xiaomi", com.blankj.utilcode.util.e.c);
            put("redmi", com.blankj.utilcode.util.e.c);
            put("blackshark", com.blankj.utilcode.util.e.c);
            put("samsang", com.blankj.utilcode.util.e.c);
            put("vivo", "ro.vivo.os.version");
            put("oppo", "ro.build.version.opporom#ro.build.version.oplusrom");
            put(AssistUtils.BRAND_MZ, "ro.build.display.id");
            put("lenovo", com.blankj.utilcode.util.e.c);
            put("smartisan", "ro.modversion");
            put("htc", "ro.build.sense.version");
            put("oneplus", com.blankj.utilcode.util.e.h);
            put("yunos", "ro.cta.yunos.version");
            put("360", com.blankj.utilcode.util.e.f);
            put("nubia", "ro.build.rom.internal.id");
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f30315a = new HashMap();
    private static final Map<String, String> d = new HashMap<String, String>() { // from class: com.getui.gtc.dim.c.a.2
        {
            put(AssistUtils.BRAND_HW, "com.android.permission.GET_INSTALLED_APP");
            put(AssistUtils.BRAND_HON, Permission.GET_INSTALLED_APPS);
        }
    };
    public static final Map<String, String> b = new HashMap();

    /* JADX INFO: renamed from: com.getui.gtc.dim.c.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC0651a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f30316a = false;
        final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.a(th);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class b implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f30317a;

        public b(IBinder iBinder) {
            this.f30317a = iBinder;
        }

        public final String a() throws RemoteException {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f30317a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Exception e) {
                    com.getui.gtc.dim.e.b.a(e);
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f30317a;
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, "network".equals(str) ? "android.permission.ACCESS_COARSE_LOCATION" : "android.permission.ACCESS_FINE_LOCATION", true);
            return ((LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION)).getLastKnownLocation(str);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String a() {
        Process processA;
        BufferedReader bufferedReader = null;
        try {
            StringBuilder sb = new StringBuilder();
            processA = com.getui.gtc.dim.e.c.a(new String(Base64.decode("aXAgYWRkcg==", 0)));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processA.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (Pattern.matches("^\\d+: ((wlan\\d+)|(eth\\d+)): .*", line)) {
                            String strSubstring = line.substring(line.indexOf(": ") + 2);
                            sb.append(sb.length() == 0 ? "" : ",");
                            sb.append(strSubstring.substring(0, strSubstring.indexOf(": ")));
                            sb.append("#");
                            String line2 = bufferedReader2.readLine();
                            if (line2 != null) {
                                sb.append(line2.substring(line2.indexOf("link/ether ") + 11, line2.indexOf(" brd")));
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            com.getui.gtc.dim.e.b.a(th);
                            return "";
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (processA != null) {
                                try {
                                    processA.destroy();
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                    }
                }
                String string = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (Throwable unused3) {
                }
                try {
                    processA.destroy();
                } catch (Throwable unused4) {
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            processA = null;
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String a(int i, Context context) {
        String deviceId;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get imei above 29");
            }
            "vivo".equalsIgnoreCase(b());
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            return (telephonyManager == null || i < 0 || (deviceId = telephonyManager.getDeviceId(i)) == null) ? "" : deviceId;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get imei above 29");
            }
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            String deviceId = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getDeviceId();
            return !TextUtils.isEmpty(deviceId) ? deviceId : "";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String a(Context context, boolean z) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("can not get oaid at main thread");
            }
            d.a();
            d.a aVar = d.f30319a;
            if (aVar != null && context != null) {
                d.b = context.getApplicationContext();
                if (d.b()) {
                    d.c = aVar.c(d.b);
                }
            }
            String strC = d.c ? d.c() : null;
            if (!"HONOR".equals(d.d)) {
                return strC;
            }
            String strB = b(context, z);
            if (strB == null) {
                strB = "";
            }
            return strB + '#' + strC;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String b() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String b(int i, Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get imsi above 29");
            }
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            Object objA = com.getui.gtc.dim.e.c.a(i, "getSubscriberId", context);
            return objA != null ? (String) objA : "";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get imsi above 29");
            }
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            String subscriberId = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSubscriberId();
            return !TextUtils.isEmpty(subscriberId) ? subscriberId : "";
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String b(Context context, String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, g.d, true);
            if (!com.getui.gtc.dim.e.c.c(context)) {
                return "2##";
            }
            int i = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway;
            String strB = com.getui.gtc.dim.e.c.b((i & 255) + Consts.DOT + ((i >> 8) & 255) + Consts.DOT + ((i >> 16) & 255) + Consts.DOT + ((i >> 24) & 255));
            return "1#" + str.replace("\"", "") + "#" + strB;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    private static String b(Context context, boolean z) {
        if (!z) {
            try {
                if (d.i.c()) {
                    com.getui.gtc.dim.e.b.a("support honor oaid");
                    return "";
                }
            } catch (Throwable th) {
                com.getui.gtc.dim.e.b.a(th);
            }
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("can not get oaid at main thread");
        }
        d.h hVar = new d.h();
        if (hVar.a(context)) {
            hVar.c(context);
            return hVar.b(context);
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0056  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static int c(int i, Context context) {
        int subscriptionId;
        Cursor cursorQuery = null;
        int i2 = -1;
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            try {
                subscriptionId = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(i).getSubscriptionId();
                if (subscriptionId == -1) {
                    try {
                        throw new RuntimeException("invalid subId");
                    } catch (Throwable unused) {
                        i2 = subscriptionId;
                        cursorQuery = context.getContentResolver().query(Uri.parse("content://telephony/siminfo"), new String[]{DatabaseHelper.COLUMN_ID, "sim_id"}, "sim_id = ?", new String[]{String.valueOf(i)}, null);
                        subscriptionId = (cursorQuery == null || !cursorQuery.moveToFirst()) ? i2 : cursorQuery.getInt(cursorQuery.getColumnIndex(DatabaseHelper.COLUMN_ID));
                        if (cursorQuery != null) {
                            return subscriptionId;
                        }
                        cursorQuery.close();
                        return subscriptionId;
                    }
                }
            } catch (Throwable unused2) {
            }
            if (cursorQuery != null) {
                return subscriptionId;
            }
            cursorQuery.close();
            return subscriptionId;
        } catch (Throwable th) {
            try {
                com.getui.gtc.dim.e.b.a(th);
                return i2;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    @MutableMethod
    public static String c() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String c(Context context) {
        Throwable th;
        String simSerialNumber;
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            simSerialNumber = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimSerialNumber();
            if (TextUtils.isEmpty(simSerialNumber)) {
                simSerialNumber = "";
            }
            try {
                if (!TextUtils.isEmpty(simSerialNumber) && simSerialNumber.length() < 20) {
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                com.getui.gtc.dim.e.b.a(th);
            }
        } catch (Throwable th3) {
            th = th3;
            simSerialNumber = "";
        }
        return simSerialNumber;
    }

    @MutableMethod
    public static String d() {
        try {
            String strB = b();
            if (!TextUtils.isEmpty(strB)) {
                String lowerCase = strB.toLowerCase();
                Map<String, String> map = f30315a;
                if (map.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(map.get(lowerCase), "");
                }
                Map<String, String> map2 = c;
                if (map2.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(map2.get(lowerCase), "");
                }
            }
            String strE = e();
            if (!TextUtils.isEmpty(strE)) {
                String lowerCase2 = strE.toLowerCase();
                Map<String, String> map3 = f30315a;
                if (map3.containsKey(lowerCase2)) {
                    return com.getui.gtc.dim.e.c.a(map3.get(lowerCase2), "");
                }
                Map<String, String> map4 = c;
                if (map4.containsKey(lowerCase2)) {
                    return com.getui.gtc.dim.e.c.a(map4.get(lowerCase2), "");
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        return "";
    }

    @MutableMethod
    public static String d(int i, Context context) {
        String str = "";
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            Object objA = com.getui.gtc.dim.e.c.a(i, "getSimSerialNumber", context);
            String str2 = objA != null ? (String) objA : "";
            try {
                return (TextUtils.isEmpty(str2) || str2.length() >= 20) ? str2 : "";
            } catch (Throwable th) {
                str = str2;
                th = th;
                com.getui.gtc.dim.e.b.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @MutableMethod
    public static String d(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String e() {
        try {
            return Build.MANUFACTURER;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String e(Context context) {
        try {
            if (CommonUtil.isMainThread()) {
                throw new RuntimeException("cannot get advertisingId from main thread");
            }
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            ServiceConnectionC0651a serviceConnectionC0651a = new ServiceConnectionC0651a();
            if (!context.bindService(intent, serviceConnectionC0651a, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                if (serviceConnectionC0651a.f30316a) {
                    throw new IllegalStateException();
                }
                serviceConnectionC0651a.f30316a = true;
                String strA = new b(serviceConnectionC0651a.b.poll(3000L, TimeUnit.MILLISECONDS)).a();
                context.unbindService(serviceConnectionC0651a);
                return strA;
            } catch (Throwable th) {
                context.unbindService(serviceConnectionC0651a);
                throw th;
            }
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.a(th2);
            return "";
        }
    }

    @MutableMethod
    public static String f() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String f(Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.READ_PHONE_STATE", true);
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get serialnumber above 29");
            }
            Class<?> cls = Class.forName("android.os.Build");
            return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String g(Context context) {
        byte[] hardwareAddress;
        String string = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(networkInterfaceNextElement.getName()) && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    string = sb.toString();
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x005e A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0063 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    @MutableMethod
    public static List<PackageInfo> g() {
        Process processA;
        BufferedReader bufferedReader;
        Throwable th;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                throw new RuntimeException("can not get al by pm above 33");
            }
            ArrayList arrayList = new ArrayList();
            processA = com.getui.gtc.dim.e.c.a(new String(Base64.decode("cG0gbGlzdCBwYWNrYWdlcw==", 0)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processA.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            arrayList.add(com.getui.gtc.dim.e.d.a(line.split(u15.f19942b)[1], 0));
                        } else {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.getui.gtc.dim.e.b.a(th);
                            return Collections.emptyList();
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (processA != null) {
                                try {
                                    processA.destroy();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                }
                bufferedReader.close();
                try {
                    processA.destroy();
                } catch (Throwable unused4) {
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                th = th;
                com.getui.gtc.dim.e.b.a(th);
                return Collections.emptyList();
            }
        } catch (Throwable th4) {
            th = th4;
            processA = null;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x008b  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String h(Context context) {
        byte b2;
        try {
            String simOperator = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return "";
            }
            int iHashCode = simOperator.hashCode();
            if (iHashCode != 49679479) {
                if (iHashCode != 49679502) {
                    switch (iHashCode) {
                        case 49679470:
                            if (!simOperator.equals("46000")) {
                                b2 = -1;
                            } else {
                                b2 = 0;
                            }
                            break;
                        case 49679471:
                            if (!simOperator.equals("46001")) {
                                b2 = -1;
                            } else {
                                b2 = 4;
                            }
                            break;
                        case 49679472:
                            if (!simOperator.equals("46002")) {
                                b2 = -1;
                            } else {
                                b2 = 1;
                            }
                            break;
                        case 49679473:
                            if (!simOperator.equals("46003")) {
                                b2 = -1;
                            } else {
                                b2 = 7;
                            }
                            break;
                        case 49679474:
                            if (!simOperator.equals("46004")) {
                                b2 = -1;
                            } else {
                                b2 = 2;
                            }
                            break;
                        case 49679475:
                            if (!simOperator.equals("46005")) {
                                b2 = -1;
                            } else {
                                b2 = 8;
                            }
                            break;
                        case 49679476:
                            if (!simOperator.equals("46006")) {
                                b2 = -1;
                            } else {
                                b2 = 5;
                            }
                            break;
                        case 49679477:
                            if (!simOperator.equals("46007")) {
                                b2 = -1;
                            } else {
                                b2 = 3;
                            }
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                } else if (simOperator.equals("46011")) {
                    b2 = 9;
                } else {
                    b2 = -1;
                }
            } else if (simOperator.equals("46009")) {
                b2 = 6;
            } else {
                b2 = -1;
            }
            switch (b2) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return "中国移动";
                case 4:
                case 5:
                case 6:
                    return "中国联通";
                case 7:
                case 8:
                case 9:
                    return "中国电信";
                default:
                    return simOperator;
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static List<PackageInfo> h() {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("can not get al by us at main thread");
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 10000; i <= 19999; i++) {
                PackageInfo packageInfoA = com.getui.gtc.dim.e.d.a(i);
                if (packageInfoA != null) {
                    arrayList.add(packageInfoA);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return Collections.emptyList();
        }
    }

    @Deprecated
    public static String i() {
        return "";
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String i(Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_NETWORK_STATE", true);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                throw new IllegalStateException("getSystemService: CONNECTIVITY_SERVICE failed");
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                throw new IllegalStateException("getActiveNetworkInfo failed");
            }
            if (!activeNetworkInfo.isAvailable()) {
                throw new IllegalStateException("no available activeNetwork");
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return NetworkUtil.NETWORK_TYPE_WIFI;
            }
            int subtype = activeNetworkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager != null) {
                subtype = telephonyManager.getNetworkType();
            }
            if (subtype == 20) {
                return "5G";
            }
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return NetworkUtil.NETWORK_TYPE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return NetworkUtil.NETWORK_TYPE_3G;
                case 13:
                    return NetworkUtil.NETWORK_TYPE_4G;
                default:
                    return "NULL";
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "NULL";
        }
    }

    @MutableMethod
    public static String j(Context context) {
        try {
            if (!com.getui.gtc.dim.e.c.a(context)) {
                throw new IllegalStateException("network not connected");
            }
            boolean zB = com.getui.gtc.dim.e.c.b(context);
            boolean zC = com.getui.gtc.dim.e.c.c(context);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ((zB && networkInterfaceNextElement.getName().toLowerCase().contains("rmnet")) || (zC && networkInterfaceNextElement.getName().toLowerCase().contains("wlan0"))) {
                    List<InterfaceAddress> interfaceAddresses = networkInterfaceNextElement.getInterfaceAddresses();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<InterfaceAddress> it = interfaceAddresses.iterator();
                    while (it.hasNext()) {
                        InetAddress address = it.next().getAddress();
                        if (!address.isLoopbackAddress()) {
                            arrayList3.add(address.getHostAddress());
                        }
                    }
                    if (zB) {
                        arrayList.addAll(arrayList3);
                    }
                    if (zC) {
                        arrayList2.addAll(arrayList3);
                    }
                }
            }
            if (zB) {
                StringBuilder sb = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(",");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            if (!zC) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                sb2.append((String) it3.next());
                sb2.append(",");
            }
            if (sb2.toString().endsWith(",")) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    public static String k(Context context) {
        try {
            if (!com.getui.gtc.dim.e.c.a(context)) {
                throw new IllegalStateException("network not connected");
            }
            boolean zB = com.getui.gtc.dim.e.c.b(context);
            boolean zC = com.getui.gtc.dim.e.c.c(context);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                String lowerCase = networkInterfaceNextElement.getName().toLowerCase();
                if ((zB && (lowerCase.contains("rmnet") || lowerCase.contains("ccmni"))) || (zC && lowerCase.contains("wlan0"))) {
                    List<InterfaceAddress> interfaceAddresses = networkInterfaceNextElement.getInterfaceAddresses();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<InterfaceAddress> it = interfaceAddresses.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        InetAddress address = it.next().getAddress();
                        if (!address.isLoopbackAddress()) {
                            if (address instanceof Inet6Address) {
                                arrayList3.add(address.getHostAddress());
                            } else if (address instanceof Inet4Address) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        if (zB) {
                            arrayList.addAll(arrayList3);
                        }
                        if (zC) {
                            arrayList2.addAll(arrayList3);
                        }
                    }
                }
            }
            if (zB) {
                StringBuilder sb = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(",");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            if (!zC) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                sb2.append((String) it3.next());
                sb2.append(",");
            }
            if (sb2.toString().endsWith(",")) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static WifiInfo l(Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, g.d, true);
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    Field declaredField = WifiInfo.class.getDeclaredField("mIpAddress");
                    declaredField.setAccessible(true);
                    declaredField.set(connectionInfo, null);
                } catch (Throwable th) {
                    com.getui.gtc.dim.e.b.a(th);
                }
            }
            return connectionInfo;
        } catch (Throwable th2) {
            com.getui.gtc.dim.e.b.a(th2);
            return null;
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static List<ScanResult> m(Context context) {
        try {
            if (CommonUtil.isMainThread()) {
                throw new IllegalStateException("cannot get wifi list from the main thread");
            }
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_FINE_LOCATION", true);
            List<ScanResult> scanResults = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getScanResults();
            if (scanResults == null || scanResults.size() <= 0) {
                return null;
            }
            return scanResults;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v7 */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String n(Context context) {
        int systemId;
        int i;
        int baseStationId;
        ?? r8;
        boolean z;
        ?? r9;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_FINE_LOCATION", true);
            } else if (!com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                throw new IllegalStateException("permission coarse/fine location not granted");
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            List list = null;
            if (telephonyManager.getSimState() == 5) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator == null || networkOperator.length() < 3) {
                    systemId = 0;
                    i = 0;
                } else {
                    i = Integer.parseInt(networkOperator.substring(0, 3));
                    systemId = Integer.parseInt(networkOperator.substring(3));
                }
                try {
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    z = cellLocation instanceof GsmCellLocation;
                    try {
                        if (z) {
                            int lac = ((GsmCellLocation) cellLocation).getLac();
                            baseStationId = ((GsmCellLocation) cellLocation).getCid();
                            r9 = lac;
                        } else if (cellLocation instanceof CdmaCellLocation) {
                            int networkId = ((CdmaCellLocation) cellLocation).getNetworkId();
                            if (systemId == 0) {
                                systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                            }
                            baseStationId = ((CdmaCellLocation) cellLocation).getBaseStationId();
                            r9 = networkId;
                        } else {
                            baseStationId = 0;
                            r9 = 0;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.getui.gtc.dim.e.b.a(th);
                        baseStationId = 0;
                        r9 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    r8 = r9;
                } else {
                    list = (List) telephonyManager.getClass().getMethod("getNeighboringCellInfo", new Class[0]).invoke(telephonyManager, new Object[0]);
                    r8 = r9;
                }
            } else {
                systemId = 0;
                i = 0;
                baseStationId = 0;
                r8 = 0;
            }
            ?? sb = new StringBuilder();
            sb.append(i);
            sb.append("|");
            sb.append(systemId);
            sb.append("|");
            sb.append(r8);
            sb.append("|");
            sb.append(baseStationId);
            sb.append("|");
            for (int i2 = 0; list != null && i2 < list.size(); i2++) {
                sb.append(((NeighboringCellInfo) list.get(i2)).getCid());
                if (i2 < list.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } catch (Throwable th3) {
            com.getui.gtc.dim.e.b.a(th3);
            return "0|0|0|0|";
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x018f A[Catch: all -> 0x01d0, TryCatch #1 {all -> 0x01d0, blocks: (B:3:0x0008, B:10:0x001f, B:13:0x0029, B:15:0x0037, B:18:0x003f, B:19:0x004e, B:21:0x0054, B:23:0x0060, B:25:0x0064, B:67:0x0189, B:69:0x018f, B:70:0x0194, B:27:0x0088, B:29:0x008c, B:31:0x00a6, B:33:0x00aa, B:34:0x00c3, B:36:0x00c7, B:37:0x00e0, B:65:0x017b, B:72:0x01bc, B:74:0x01c2, B:77:0x01c8, B:78:0x01cf), top: B:84:0x0008 }] */
    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static String o(Context context) {
        long j;
        int mnc;
        int tac;
        long ci;
        int i;
        String str = "android.telephony.CellInfoNr";
        try {
            int i2 = 1;
            if (!CommonUtil.hasPermission(context, Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", true)) {
                throw new RuntimeException("not has location permission");
            }
            List<CellInfo> allCellInfo = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getAllCellInfo();
            if (allCellInfo != null && !allCellInfo.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<CellInfo> it = allCellInfo.iterator();
                long jLongValue = 0;
                int mcc = 0;
                int i3 = 0;
                int iIntValue = 0;
                int i4 = 0;
                while (it.hasNext()) {
                    CellInfo next = it.next();
                    if (next.isRegistered()) {
                        if (next instanceof CellInfoGsm) {
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) next).getCellIdentity();
                            mcc = cellIdentity.getMcc();
                            mnc = cellIdentity.getMnc();
                            tac = cellIdentity.getLac();
                            ci = cellIdentity.getCid();
                            i4 = i2;
                        } else {
                            if (next instanceof CellInfoCdma) {
                                CellIdentityCdma cellIdentity2 = ((CellInfoCdma) next).getCellIdentity();
                                mnc = cellIdentity2.getSystemId();
                                tac = cellIdentity2.getNetworkId();
                                ci = cellIdentity2.getBasestationId();
                                i = 2;
                            } else if (next instanceof CellInfoWcdma) {
                                CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) next).getCellIdentity();
                                mcc = cellIdentity3.getMcc();
                                mnc = cellIdentity3.getMnc();
                                tac = cellIdentity3.getLac();
                                ci = cellIdentity3.getCid();
                                i = 4;
                            } else {
                                if (next instanceof CellInfoLte) {
                                    CellIdentityLte cellIdentity4 = ((CellInfoLte) next).getCellIdentity();
                                    mcc = cellIdentity4.getMcc();
                                    mnc = cellIdentity4.getMnc();
                                    tac = cellIdentity4.getTac();
                                    ci = cellIdentity4.getCi();
                                    i = 3;
                                } else if (str.equals(next.getClass().getName())) {
                                    try {
                                        Method method = Class.forName(str).getMethod("getCellIdentity", new Class[0]);
                                        Class<?> cls = Class.forName("android.telephony.CellIdentityNr");
                                        str = str;
                                        try {
                                            Method method2 = cls.getMethod("getMccString", new Class[0]);
                                            it = it;
                                            try {
                                                Method method3 = cls.getMethod("getMncString", new Class[0]);
                                                int i5 = mcc;
                                                try {
                                                    Method method4 = cls.getMethod("getTac", new Class[0]);
                                                    j = jLongValue;
                                                    try {
                                                        Method method5 = cls.getMethod("getNci", new Class[0]);
                                                        Object objInvoke = method.invoke(next, new Object[0]);
                                                        String str2 = (String) method2.invoke(objInvoke, new Object[0]);
                                                        String str3 = (String) method3.invoke(objInvoke, new Object[0]);
                                                        int i6 = Integer.parseInt(str2);
                                                        try {
                                                            i3 = Integer.parseInt(str3);
                                                            iIntValue = ((Integer) method4.invoke(objInvoke, new Object[0])).intValue();
                                                            i4 = 6;
                                                            jLongValue = ((Long) method5.invoke(objInvoke, new Object[0])).longValue();
                                                            mcc = i6;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            mcc = i6;
                                                            com.getui.gtc.dim.e.b.b(th);
                                                            jLongValue = j;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        mcc = i5;
                                                        com.getui.gtc.dim.e.b.b(th);
                                                        jLongValue = j;
                                                        if (sb.length() != 0) {
                                                            sb.append(",");
                                                        }
                                                        sb.append(mcc);
                                                        sb.append("|");
                                                        sb.append(i3);
                                                        sb.append("|");
                                                        sb.append(iIntValue);
                                                        sb.append("|");
                                                        sb.append(jLongValue);
                                                        sb.append("|");
                                                        sb.append(i4);
                                                        it = it;
                                                        str = str;
                                                        i2 = 1;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    j = jLongValue;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                j = jLongValue;
                                                com.getui.gtc.dim.e.b.b(th);
                                                jLongValue = j;
                                                if (sb.length() != 0) {
                                                    sb.append(",");
                                                }
                                                sb.append(mcc);
                                                sb.append("|");
                                                sb.append(i3);
                                                sb.append("|");
                                                sb.append(iIntValue);
                                                sb.append("|");
                                                sb.append(jLongValue);
                                                sb.append("|");
                                                sb.append(i4);
                                                it = it;
                                                str = str;
                                                i2 = 1;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            it = it;
                                            j = jLongValue;
                                            com.getui.gtc.dim.e.b.b(th);
                                            jLongValue = j;
                                            if (sb.length() != 0) {
                                                sb.append(",");
                                            }
                                            sb.append(mcc);
                                            sb.append("|");
                                            sb.append(i3);
                                            sb.append("|");
                                            sb.append(iIntValue);
                                            sb.append("|");
                                            sb.append(jLongValue);
                                            sb.append("|");
                                            sb.append(i4);
                                            it = it;
                                            str = str;
                                            i2 = 1;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str = str;
                                    }
                                } else {
                                    str = str;
                                    it = it;
                                }
                                if (sb.length() != 0) {
                                    sb.append(",");
                                }
                                sb.append(mcc);
                                sb.append("|");
                                sb.append(i3);
                                sb.append("|");
                                sb.append(iIntValue);
                                sb.append("|");
                                sb.append(jLongValue);
                                sb.append("|");
                                sb.append(i4);
                                it = it;
                                str = str;
                                i2 = 1;
                            }
                            i4 = i;
                        }
                        long j2 = ci;
                        i3 = mnc;
                        iIntValue = tac;
                        jLongValue = j2;
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(mcc);
                        sb.append("|");
                        sb.append(i3);
                        sb.append("|");
                        sb.append(iIntValue);
                        sb.append("|");
                        sb.append(jLongValue);
                        sb.append("|");
                        sb.append(i4);
                        it = it;
                        str = str;
                        i2 = 1;
                    }
                }
                if (sb.length() > 0) {
                    return sb.toString();
                }
                return "0|0|0|0|0";
            }
            return "0|0|0|0|0";
        } catch (Throwable th7) {
            com.getui.gtc.dim.e.b.a(th7);
        }
    }

    @MutableMethod
    public static List<PackageInfo> p(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities.size() > 0) {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.getui.gtc.dim.e.d.a(it.next().activityInfo.packageName, 0));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return Collections.emptyList();
        }
    }

    @MutableMethod
    public static List<PackageInfo> q(Context context) {
        String str;
        try {
            String lowerCase = b().toLowerCase();
            Map<String, String> map = b;
            if (map.containsKey(lowerCase)) {
                str = map.get(lowerCase);
            } else {
                Map<String, String> map2 = d;
                if (!map2.containsKey(lowerCase)) {
                    throw new RuntimeException("not support brand: ".concat(String.valueOf(lowerCase)));
                }
                str = map2.get(lowerCase);
            }
            com.getui.gtc.dim.e.c.a(context, str, false);
            PackageManager packageManager = context.getPackageManager();
            return (List) packageManager.getClass().getDeclaredMethod(new String(Base64.decode("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 0)), Integer.TYPE).invoke(packageManager, 5);
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return Collections.emptyList();
        }
    }

    @MutableMethod
    public static List<PackageInfo> r(Context context) {
        String[] list;
        File parentFile;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new RuntimeException("can not get localDirs above 29");
            }
            File externalCacheDir = context.getExternalCacheDir();
            File parentFile2 = (externalCacheDir == null || (parentFile = externalCacheDir.getParentFile()) == null) ? null : parentFile.getParentFile();
            if (parentFile2 != null && parentFile2.isDirectory() && (list = parentFile2.list(new FilenameFilter() { // from class: com.getui.gtc.dim.c.a.3
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    try {
                        return file.isDirectory() && str.contains(Consts.DOT);
                    } catch (Throwable unused) {
                    }
                }
            })) != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    try {
                        arrayList.add(com.getui.gtc.dim.e.d.a(str, 0));
                    } catch (Throwable unused) {
                    }
                }
                return arrayList;
            }
            return Collections.emptyList();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
    }
}
