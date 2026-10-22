package com.zj.adlib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import com.google.common.base.a;
import com.hjq.permissions.Permission;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class wo6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45647a = "sp_permission_handler_permission_was_denied_before";

    public static String a(Context context, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 && e(context, null, str)) {
            return str;
        }
        if (i >= 29) {
            if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
                return "android.permission.ACCESS_FINE_LOCATION";
            }
            return null;
        }
        if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
            return "android.permission.ACCESS_FINE_LOCATION";
        }
        if (e(context, null, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "android.permission.ACCESS_COARSE_LOCATION";
        }
        return null;
    }

    public static int b(@Nullable Activity activity, String str) {
        if (activity == null) {
            return 0;
        }
        boolean zL = l(activity, str);
        boolean z = true;
        boolean z2 = !f(activity, str);
        if (!zL) {
            z = z2;
        } else if (z2) {
            z = false;
        }
        if (!zL && z) {
            h(activity, str);
        }
        return (zL && z) ? 4 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @TargetApi(22)
    public static List<String> c(Context context, int i) {
        String strA;
        String strA2;
        String strA3;
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
            case 37:
                if (e(context, arrayList, Permission.WRITE_CALENDAR)) {
                    arrayList.add(Permission.WRITE_CALENDAR);
                }
                if (e(context, arrayList, Permission.READ_CALENDAR)) {
                    arrayList.add(Permission.READ_CALENDAR);
                }
                return arrayList;
            case 1:
                if (e(context, arrayList, Permission.CAMERA)) {
                    arrayList.add(Permission.CAMERA);
                }
                return arrayList;
            case 2:
                if (e(context, arrayList, Permission.READ_CONTACTS)) {
                    arrayList.add(Permission.READ_CONTACTS);
                }
                if (e(context, arrayList, Permission.WRITE_CONTACTS)) {
                    arrayList.add(Permission.WRITE_CONTACTS);
                }
                if (e(context, arrayList, "android.permission.GET_ACCOUNTS")) {
                    arrayList.add("android.permission.GET_ACCOUNTS");
                }
                return arrayList;
            case 3:
            case 4:
            case 5:
                if (i != 4 || Build.VERSION.SDK_INT < 29) {
                    if (e(context, arrayList, "android.permission.ACCESS_COARSE_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (e(context, arrayList, "android.permission.ACCESS_FINE_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    }
                } else if (e(context, arrayList, Permission.ACCESS_BACKGROUND_LOCATION)) {
                    arrayList.add(Permission.ACCESS_BACKGROUND_LOCATION);
                }
                return arrayList;
            case 6:
            case 11:
            case 20:
                return null;
            case 7:
            case 14:
                if (e(context, arrayList, Permission.RECORD_AUDIO)) {
                    arrayList.add(Permission.RECORD_AUDIO);
                }
                return arrayList;
            case 8:
                if (e(context, arrayList, "android.permission.READ_PHONE_STATE")) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (Build.VERSION.SDK_INT > 29 && e(context, arrayList, Permission.READ_PHONE_NUMBERS)) {
                    arrayList.add(Permission.READ_PHONE_NUMBERS);
                }
                if (e(context, arrayList, Permission.CALL_PHONE)) {
                    arrayList.add(Permission.CALL_PHONE);
                }
                if (e(context, arrayList, Permission.READ_CALL_LOG)) {
                    arrayList.add(Permission.READ_CALL_LOG);
                }
                if (e(context, arrayList, Permission.WRITE_CALL_LOG)) {
                    arrayList.add(Permission.WRITE_CALL_LOG);
                }
                if (e(context, arrayList, Permission.ADD_VOICEMAIL)) {
                    arrayList.add(Permission.ADD_VOICEMAIL);
                }
                if (e(context, arrayList, Permission.USE_SIP)) {
                    arrayList.add(Permission.USE_SIP);
                }
                if (e(context, arrayList, Permission.ANSWER_PHONE_CALLS)) {
                    arrayList.add(Permission.ANSWER_PHONE_CALLS);
                }
                return arrayList;
            case 9:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, Permission.READ_MEDIA_IMAGES)) {
                    arrayList.add(Permission.READ_MEDIA_IMAGES);
                }
                return arrayList;
            case 10:
            case 25:
            case 26:
            default:
                return arrayList;
            case 12:
                if (e(context, arrayList, Permission.BODY_SENSORS)) {
                    arrayList.add(Permission.BODY_SENSORS);
                }
                return arrayList;
            case 13:
                if (e(context, arrayList, Permission.SEND_SMS)) {
                    arrayList.add(Permission.SEND_SMS);
                }
                if (e(context, arrayList, Permission.RECEIVE_SMS)) {
                    arrayList.add(Permission.RECEIVE_SMS);
                }
                if (e(context, arrayList, Permission.READ_SMS)) {
                    arrayList.add(Permission.READ_SMS);
                }
                if (e(context, arrayList, Permission.RECEIVE_WAP_PUSH)) {
                    arrayList.add(Permission.RECEIVE_WAP_PUSH);
                }
                if (e(context, arrayList, Permission.RECEIVE_MMS)) {
                    arrayList.add(Permission.RECEIVE_MMS);
                }
                return arrayList;
            case 15:
                if (e(context, arrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                }
                int i2 = Build.VERSION.SDK_INT;
                if ((i2 < 29 || (i2 == 29 && Environment.isExternalStorageLegacy())) && e(context, arrayList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                return arrayList;
            case 16:
                if (e(context, arrayList, Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) {
                    arrayList.add(Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                }
                return arrayList;
            case 17:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, Permission.POST_NOTIFICATIONS)) {
                    arrayList.add(Permission.POST_NOTIFICATIONS);
                }
                return arrayList;
            case 18:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (e(context, arrayList, Permission.ACCESS_MEDIA_LOCATION)) {
                    arrayList.add(Permission.ACCESS_MEDIA_LOCATION);
                }
                return arrayList;
            case 19:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (e(context, arrayList, Permission.ACTIVITY_RECOGNITION)) {
                    arrayList.add(Permission.ACTIVITY_RECOGNITION);
                }
                return arrayList;
            case 21:
                if (e(context, arrayList, "android.permission.BLUETOOTH")) {
                    arrayList.add("android.permission.BLUETOOTH");
                }
                return arrayList;
            case 22:
                if (Build.VERSION.SDK_INT >= 30 && e(context, arrayList, Permission.MANAGE_EXTERNAL_STORAGE)) {
                    arrayList.add(Permission.MANAGE_EXTERNAL_STORAGE);
                }
                return arrayList;
            case 23:
                if (e(context, arrayList, Permission.SYSTEM_ALERT_WINDOW)) {
                    arrayList.add(Permission.SYSTEM_ALERT_WINDOW);
                }
                return arrayList;
            case 24:
                if (e(context, arrayList, Permission.REQUEST_INSTALL_PACKAGES)) {
                    arrayList.add(Permission.REQUEST_INSTALL_PACKAGES);
                }
                return arrayList;
            case 27:
                if (e(context, arrayList, Permission.ACCESS_NOTIFICATION_POLICY)) {
                    arrayList.add(Permission.ACCESS_NOTIFICATION_POLICY);
                }
                return arrayList;
            case 28:
                if (Build.VERSION.SDK_INT >= 31 && (strA = a(context, Permission.BLUETOOTH_SCAN)) != null) {
                    arrayList.add(strA);
                }
                return arrayList;
            case 29:
                if (Build.VERSION.SDK_INT >= 31 && (strA2 = a(context, Permission.BLUETOOTH_ADVERTISE)) != null) {
                    arrayList.add(strA2);
                }
                return arrayList;
            case 30:
                if (Build.VERSION.SDK_INT >= 31 && (strA3 = a(context, Permission.BLUETOOTH_CONNECT)) != null) {
                    arrayList.add(strA3);
                }
                return arrayList;
            case 31:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, Permission.NEARBY_WIFI_DEVICES)) {
                    arrayList.add(Permission.NEARBY_WIFI_DEVICES);
                }
                return arrayList;
            case 32:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, Permission.READ_MEDIA_VIDEO)) {
                    arrayList.add(Permission.READ_MEDIA_VIDEO);
                }
                return arrayList;
            case 33:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, Permission.READ_MEDIA_AUDIO)) {
                    arrayList.add(Permission.READ_MEDIA_AUDIO);
                }
                return arrayList;
            case 34:
                if (e(context, arrayList, Permission.SCHEDULE_EXACT_ALARM)) {
                    arrayList.add(Permission.SCHEDULE_EXACT_ALARM);
                }
                return arrayList;
            case 35:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, Permission.BODY_SENSORS_BACKGROUND)) {
                    arrayList.add(Permission.BODY_SENSORS_BACKGROUND);
                }
                return arrayList;
            case 36:
                if (e(context, arrayList, Permission.WRITE_CALENDAR)) {
                    arrayList.add(Permission.WRITE_CALENDAR);
                }
                return arrayList;
        }
    }

    public static PackageInfo d(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)) : packageManager.getPackageInfo(context.getPackageName(), 4096);
    }

    public static boolean e(Context context, ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                Log.d(go6.f16832a, "Unable to check manifest for permission: ", e);
            }
        }
        if (context == null) {
            Log.d(go6.f16832a, "Unable to detect current Activity or App Context.");
            return false;
        }
        PackageInfo packageInfoD = d(context);
        if (packageInfoD == null) {
            Log.d(go6.f16832a, "Unable to get Package info, will not be able to determine permissions to request.");
            return false;
        }
        Iterator it2 = new ArrayList(Arrays.asList(packageInfoD.requestedPermissions)).iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(api = 23)
    public static boolean f(@NonNull Activity activity, String str) {
        return !ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int g(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2062386608:
                if (str.equals(Permission.READ_SMS)) {
                    b = 0;
                }
                break;
            case -1928411001:
                if (str.equals(Permission.READ_CALENDAR)) {
                    b = 1;
                }
                break;
            case -1925850455:
                if (str.equals(Permission.POST_NOTIFICATIONS)) {
                    b = 2;
                }
                break;
            case -1921431796:
                if (str.equals(Permission.READ_CALL_LOG)) {
                    b = 3;
                }
                break;
            case -1888586689:
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    b = 4;
                }
                break;
            case -1813079487:
                if (str.equals(Permission.MANAGE_EXTERNAL_STORAGE)) {
                    b = 5;
                }
                break;
            case -1783097621:
                if (str.equals(Permission.ACCESS_NOTIFICATION_POLICY)) {
                    b = 6;
                }
                break;
            case -1561629405:
                if (str.equals(Permission.SYSTEM_ALERT_WINDOW)) {
                    b = 7;
                }
                break;
            case -1479758289:
                if (str.equals(Permission.RECEIVE_WAP_PUSH)) {
                    b = 8;
                }
                break;
            case -1238066820:
                if (str.equals(Permission.BODY_SENSORS)) {
                    b = 9;
                }
                break;
            case -1164582768:
                if (str.equals(Permission.READ_PHONE_NUMBERS)) {
                    b = 10;
                }
                break;
            case -909527021:
                if (str.equals(Permission.NEARBY_WIFI_DEVICES)) {
                    b = 11;
                }
                break;
            case -895679497:
                if (str.equals(Permission.RECEIVE_MMS)) {
                    b = 12;
                }
                break;
            case -895673731:
                if (str.equals(Permission.RECEIVE_SMS)) {
                    b = 13;
                }
                break;
            case -798669607:
                if (str.equals(Permission.BLUETOOTH_CONNECT)) {
                    b = a.p;
                }
                break;
            case -406040016:
                if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    b = 15;
                }
                break;
            case -63024214:
                if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    b = a.r;
                }
                break;
            case -5573545:
                if (str.equals("android.permission.READ_PHONE_STATE")) {
                    b = 17;
                }
                break;
            case 52602690:
                if (str.equals(Permission.SEND_SMS)) {
                    b = 18;
                }
                break;
            case 112197485:
                if (str.equals(Permission.CALL_PHONE)) {
                    b = 19;
                }
                break;
            case 175802396:
                if (str.equals(Permission.READ_MEDIA_IMAGES)) {
                    b = 20;
                }
                break;
            case 214526995:
                if (str.equals(Permission.WRITE_CONTACTS)) {
                    b = a.y;
                }
                break;
            case 361658321:
                if (str.equals(Permission.BODY_SENSORS_BACKGROUND)) {
                    b = 22;
                }
                break;
            case 463403621:
                if (str.equals(Permission.CAMERA)) {
                    b = 23;
                }
                break;
            case 603653886:
                if (str.equals(Permission.WRITE_CALENDAR)) {
                    b = 24;
                }
                break;
            case 610633091:
                if (str.equals(Permission.WRITE_CALL_LOG)) {
                    b = a.C;
                }
                break;
            case 691260818:
                if (str.equals(Permission.READ_MEDIA_AUDIO)) {
                    b = a.D;
                }
                break;
            case 710297143:
                if (str.equals(Permission.READ_MEDIA_VIDEO)) {
                    b = 27;
                }
                break;
            case 784519842:
                if (str.equals(Permission.USE_SIP)) {
                    b = 28;
                }
                break;
            case 970694249:
                if (str.equals(Permission.SCHEDULE_EXACT_ALARM)) {
                    b = 29;
                }
                break;
            case 1166454870:
                if (str.equals(Permission.BLUETOOTH_ADVERTISE)) {
                    b = 30;
                }
                break;
            case 1271781903:
                if (str.equals("android.permission.GET_ACCOUNTS")) {
                    b = 31;
                }
                break;
            case 1365911975:
                if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    b = 32;
                }
                break;
            case 1777263169:
                if (str.equals(Permission.REQUEST_INSTALL_PACKAGES)) {
                    b = com.google.android.exoplayer2.text.cea.a.e;
                }
                break;
            case 1780337063:
                if (str.equals(Permission.ACTIVITY_RECOGNITION)) {
                    b = 34;
                }
                break;
            case 1831139720:
                if (str.equals(Permission.RECORD_AUDIO)) {
                    b = 35;
                }
                break;
            case 1977429404:
                if (str.equals(Permission.READ_CONTACTS)) {
                    b = 36;
                }
                break;
            case 2024715147:
                if (str.equals(Permission.ACCESS_BACKGROUND_LOCATION)) {
                    b = com.google.android.exoplayer2.text.cea.a.g;
                }
                break;
            case 2062356686:
                if (str.equals(Permission.BLUETOOTH_SCAN)) {
                    b = com.google.android.exoplayer2.text.cea.a.h;
                }
                break;
            case 2114579147:
                if (str.equals(Permission.ACCESS_MEDIA_LOCATION)) {
                    b = com.google.android.exoplayer2.text.cea.a.i;
                }
                break;
            case 2133799037:
                if (str.equals(Permission.ADD_VOICEMAIL)) {
                    b = MaterialProgressDrawable.c;
                }
                break;
        }
        switch (b) {
            case 0:
            case 8:
            case 12:
            case 13:
            case 18:
                return 13;
            case 1:
            case 24:
                return 0;
            case 2:
                return 17;
            case 3:
            case 10:
            case 17:
            case 19:
            case 25:
            case 28:
            case 40:
                return 8;
            case 4:
            case 16:
                return 3;
            case 5:
                return 22;
            case 6:
                return 27;
            case 7:
                return 23;
            case 9:
                return 12;
            case 11:
                return 31;
            case 14:
                return 30;
            case 15:
            case 32:
                return 15;
            case 20:
                return 9;
            case 21:
            case 31:
            case 36:
                return 2;
            case 22:
                return 35;
            case 23:
                return 1;
            case 26:
                return 33;
            case 27:
                return 32;
            case 29:
                return 34;
            case 30:
                return 29;
            case 33:
                return 24;
            case 34:
                return 19;
            case 35:
                return 7;
            case 37:
                return 4;
            case 38:
                return 28;
            case 39:
                return 18;
            default:
                return 20;
        }
    }

    public static void h(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().putBoolean(f45647a, true).apply();
    }

    @NonNull
    public static Integer i(@Nullable Integer num, @Nullable Integer num2) {
        HashSet hashSet = new HashSet();
        hashSet.add(num);
        hashSet.add(num2);
        return j(hashSet);
    }

    @NonNull
    public static Integer j(@NonNull Collection<Integer> collection) {
        if (collection.contains(4)) {
            return 4;
        }
        if (collection.contains(2)) {
            return 2;
        }
        if (collection.contains(0)) {
            return 0;
        }
        return collection.contains(3) ? 3 : 1;
    }

    public static int k(@Nullable Activity activity, String str, int i) {
        if (i == -1) {
            return b(activity, str);
        }
        return 1;
    }

    public static boolean l(Context context, String str) {
        return context.getSharedPreferences(str, 0).getBoolean(f45647a, false);
    }
}
