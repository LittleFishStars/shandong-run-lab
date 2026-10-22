package com.hjq.permissions;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class PermissionHelper {
    private static final Map<String, Integer> PERMISSION_VERSION_MAP;
    private static final List<String> SPECIAL_PERMISSION_LIST;
    private static final List<String> VIRTUAL_PERMISSION_LIST;

    static {
        ArrayList arrayList = new ArrayList(12);
        SPECIAL_PERMISSION_LIST = arrayList;
        HashMap map = new HashMap(53);
        PERMISSION_VERSION_MAP = map;
        ArrayList arrayList2 = new ArrayList(4);
        VIRTUAL_PERMISSION_LIST = arrayList2;
        arrayList.add(Permission.SCHEDULE_EXACT_ALARM);
        arrayList.add(Permission.MANAGE_EXTERNAL_STORAGE);
        arrayList.add(Permission.REQUEST_INSTALL_PACKAGES);
        arrayList.add(Permission.PICTURE_IN_PICTURE);
        arrayList.add(Permission.SYSTEM_ALERT_WINDOW);
        arrayList.add(Permission.WRITE_SETTINGS);
        arrayList.add(Permission.ACCESS_NOTIFICATION_POLICY);
        arrayList.add(Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
        arrayList.add(Permission.PACKAGE_USAGE_STATS);
        arrayList.add(Permission.NOTIFICATION_SERVICE);
        arrayList.add(Permission.BIND_NOTIFICATION_LISTENER_SERVICE);
        arrayList.add(Permission.BIND_VPN_SERVICE);
        map.put(Permission.SCHEDULE_EXACT_ALARM, 31);
        map.put(Permission.MANAGE_EXTERNAL_STORAGE, 30);
        map.put(Permission.REQUEST_INSTALL_PACKAGES, 26);
        map.put(Permission.PICTURE_IN_PICTURE, 26);
        map.put(Permission.SYSTEM_ALERT_WINDOW, 23);
        map.put(Permission.WRITE_SETTINGS, 23);
        map.put(Permission.ACCESS_NOTIFICATION_POLICY, 23);
        map.put(Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, 23);
        map.put(Permission.PACKAGE_USAGE_STATS, 21);
        map.put(Permission.NOTIFICATION_SERVICE, 19);
        map.put(Permission.BIND_NOTIFICATION_LISTENER_SERVICE, 18);
        map.put(Permission.BIND_VPN_SERVICE, 14);
        map.put(Permission.READ_MEDIA_VISUAL_USER_SELECTED, 34);
        map.put(Permission.POST_NOTIFICATIONS, 33);
        map.put(Permission.NEARBY_WIFI_DEVICES, 33);
        map.put(Permission.BODY_SENSORS_BACKGROUND, 33);
        map.put(Permission.READ_MEDIA_IMAGES, 33);
        map.put(Permission.READ_MEDIA_VIDEO, 33);
        map.put(Permission.READ_MEDIA_AUDIO, 33);
        map.put(Permission.BLUETOOTH_SCAN, 31);
        map.put(Permission.BLUETOOTH_CONNECT, 31);
        map.put(Permission.BLUETOOTH_ADVERTISE, 31);
        map.put(Permission.ACCESS_BACKGROUND_LOCATION, 29);
        map.put(Permission.ACTIVITY_RECOGNITION, 29);
        map.put(Permission.ACCESS_MEDIA_LOCATION, 29);
        map.put(Permission.ACCEPT_HANDOVER, 28);
        map.put(Permission.ANSWER_PHONE_CALLS, 26);
        map.put(Permission.READ_PHONE_NUMBERS, 26);
        map.put(Permission.GET_INSTALLED_APPS, 23);
        map.put("android.permission.READ_EXTERNAL_STORAGE", 23);
        map.put("android.permission.WRITE_EXTERNAL_STORAGE", 23);
        map.put(Permission.CAMERA, 23);
        map.put(Permission.RECORD_AUDIO, 23);
        map.put("android.permission.ACCESS_FINE_LOCATION", 23);
        map.put("android.permission.ACCESS_COARSE_LOCATION", 23);
        map.put(Permission.READ_CONTACTS, 23);
        map.put(Permission.WRITE_CONTACTS, 23);
        map.put("android.permission.GET_ACCOUNTS", 23);
        map.put(Permission.READ_CALENDAR, 23);
        map.put(Permission.WRITE_CALENDAR, 23);
        map.put("android.permission.READ_PHONE_STATE", 23);
        map.put(Permission.CALL_PHONE, 23);
        map.put(Permission.READ_CALL_LOG, 23);
        map.put(Permission.WRITE_CALL_LOG, 23);
        map.put(Permission.ADD_VOICEMAIL, 23);
        map.put(Permission.USE_SIP, 23);
        map.put(Permission.PROCESS_OUTGOING_CALLS, 23);
        map.put(Permission.BODY_SENSORS, 23);
        map.put(Permission.SEND_SMS, 23);
        map.put(Permission.RECEIVE_SMS, 23);
        map.put(Permission.READ_SMS, 23);
        map.put(Permission.RECEIVE_WAP_PUSH, 23);
        map.put(Permission.RECEIVE_MMS, 23);
        arrayList2.add(Permission.NOTIFICATION_SERVICE);
        arrayList2.add(Permission.BIND_NOTIFICATION_LISTENER_SERVICE);
        arrayList2.add(Permission.BIND_VPN_SERVICE);
        arrayList2.add(Permission.PICTURE_IN_PICTURE);
    }

    public static int findAndroidVersionByPermission(@NonNull String str) {
        Integer num = PERMISSION_VERSION_MAP.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean isSpecialPermission(@NonNull String str) {
        return PermissionUtils.containsPermission(SPECIAL_PERMISSION_LIST, str);
    }

    public static boolean isVirtualPermission(@NonNull String str) {
        return PermissionUtils.containsPermission(VIRTUAL_PERMISSION_LIST, str);
    }
}
