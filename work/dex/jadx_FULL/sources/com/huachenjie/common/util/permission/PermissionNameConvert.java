package com.huachenjie.common.util.permission;

import android.content.Context;
import android.os.Build;
import com.alibaba.triver.basic.api.RequestPermission;
import com.hjq.permissions.Permission;
import com.huachenjie.common.R;
import com.huawei.hms.push.AttributionReporter;
import com.igexin.push.g.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/util/permission/PermissionNameConvert;", "", "Landroid/content/Context;", "context", "", "", RequestPermission.PERMISSIONS, "d", "permissionHints", "c", AttributionReporter.SYSTEM_PERMISSION, "b", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPermissionNameConvert.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionNameConvert.kt\ncom/huachenjie/common/util/permission/PermissionNameConvert\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,206:1\n1864#2,3:207\n*S KotlinDebug\n*F\n+ 1 PermissionNameConvert.kt\ncom/huachenjie/common/util/permission/PermissionNameConvert\n*L\n194#1:207,3\n*E\n"})
public final class PermissionNameConvert {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PermissionNameConvert f33932a = new PermissionNameConvert();

    /* JADX WARN: Code duplicated, block: B:127:0x021e  */
    /* JADX WARN: Code duplicated, block: B:147:0x0266  */
    /* JADX WARN: Code duplicated, block: B:187:0x031f  */
    /* JADX WARN: Code duplicated, block: B:190:0x032c  */
    /* JADX WARN: Code duplicated, block: B:197:0x0346  */
    /* JADX WARN: Code duplicated, block: B:198:0x0349  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String b(Context context, String permission) {
        String string;
        int i;
        String string2;
        switch (permission.hashCode()) {
            case -2078357533:
                if (!permission.equals(Permission.WRITE_SETTINGS)) {
                    return "";
                }
                String string3 = context.getString(R.string.common_permission_modify_system_settings);
                Intrinsics.checkNotNullExpressionValue(string3, "{\n                contex…m_settings)\n            }");
                return string3;
            case -2062386608:
                if (!permission.equals(Permission.READ_SMS)) {
                    return "";
                }
                String string4 = context.getString(R.string.common_permission_sms);
                Intrinsics.checkNotNullExpressionValue(string4, "{\n                contex…ission_sms)\n            }");
                return string4;
            case -1928411001:
                if (!permission.equals(Permission.READ_CALENDAR)) {
                    return "";
                }
                String string5 = context.getString(R.string.common_permission_calendar);
                Intrinsics.checkNotNullExpressionValue(string5, "{\n                contex…n_calendar)\n            }");
                return string5;
            case -1925850455:
                if (!permission.equals(Permission.POST_NOTIFICATIONS)) {
                    return "";
                }
                string = Build.VERSION.SDK_INT >= 33 ? context.getString(R.string.common_permission_post_notifications) : "";
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case -1921431796:
                if (!permission.equals(Permission.READ_CALL_LOG)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    i = R.string.common_permission_call_logs;
                } else {
                    i = R.string.common_permission_phone;
                }
                String string6 = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string6, "{\n                contex…sion_phone)\n            }");
                return string6;
            case -1888586689:
                if (!permission.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 29 || !Intrinsics.areEqual(permission, Permission.ACCESS_BACKGROUND_LOCATION)) {
                    string2 = context.getString(R.string.common_permission_location);
                } else {
                    string2 = context.getString(R.string.common_permission_location_background);
                }
                String str = string2;
                Intrinsics.checkNotNullExpressionValue(str, "{\n                if (Bu…          }\n            }");
                return str;
            case -1813079487:
                if (!permission.equals(Permission.MANAGE_EXTERNAL_STORAGE)) {
                    return "";
                }
                string = Build.VERSION.SDK_INT >= 30 ? context.getString(R.string.common_permission_all_file_access) : "";
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case -1783097621:
                if (!permission.equals(Permission.ACCESS_NOTIFICATION_POLICY)) {
                    return "";
                }
                String string7 = context.getString(R.string.common_permission_do_not_disturb_access);
                Intrinsics.checkNotNullExpressionValue(string7, "{\n                contex…urb_access)\n            }");
                return string7;
            case -1674700861:
                if (!permission.equals(Permission.ANSWER_PHONE_CALLS)) {
                    return "";
                }
                String string8 = context.getString(R.string.common_permission_phone);
                Intrinsics.checkNotNullExpressionValue(string8, "{\n                contex…sion_phone)\n            }");
                return string8;
            case -1621761407:
                if (!permission.equals(Permission.NOTIFICATION_SERVICE)) {
                    return "";
                }
                String string9 = context.getString(R.string.common_permission_allow_notifications);
                Intrinsics.checkNotNullExpressionValue(string9, "{\n                contex…ifications)\n            }");
                return string9;
            case -1561629405:
                if (!permission.equals(Permission.SYSTEM_ALERT_WINDOW)) {
                    return "";
                }
                String string10 = context.getString(R.string.common_permission_display_over_other_apps);
                Intrinsics.checkNotNullExpressionValue(string10, "{\n                contex…other_apps)\n            }");
                return string10;
            case -1479758289:
                if (!permission.equals(Permission.RECEIVE_WAP_PUSH)) {
                    return "";
                }
                String string11 = context.getString(R.string.common_permission_sms);
                Intrinsics.checkNotNullExpressionValue(string11, "{\n                contex…ission_sms)\n            }");
                return string11;
            case -1446288141:
                if (!permission.equals(Permission.GET_INSTALLED_APPS)) {
                    return "";
                }
                String string12 = context.getString(R.string.common_permission_get_installed_apps);
                Intrinsics.checkNotNullExpressionValue(string12, "{\n                contex…alled_apps)\n            }");
                return string12;
            case -1164582768:
                if (!permission.equals(Permission.READ_PHONE_NUMBERS)) {
                    return "";
                }
                String string13 = context.getString(R.string.common_permission_phone);
                Intrinsics.checkNotNullExpressionValue(string13, "{\n                contex…sion_phone)\n            }");
                return string13;
            case -1142799244:
                if (!permission.equals(Permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
                    return "";
                }
                string = Build.VERSION.SDK_INT >= 33 ? context.getString(R.string.common_permission_image_and_video) : "";
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case -909527021:
                if (!permission.equals(Permission.NEARBY_WIFI_DEVICES)) {
                    return "";
                }
                string = Build.VERSION.SDK_INT >= 33 ? context.getString(R.string.common_permission_nearby_devices) : "";
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case -895679497:
                if (!permission.equals(Permission.RECEIVE_MMS)) {
                    return "";
                }
                String string14 = context.getString(R.string.common_permission_sms);
                Intrinsics.checkNotNullExpressionValue(string14, "{\n                contex…ission_sms)\n            }");
                return string14;
            case -895673731:
                if (!permission.equals(Permission.RECEIVE_SMS)) {
                    return "";
                }
                String string15 = context.getString(R.string.common_permission_sms);
                Intrinsics.checkNotNullExpressionValue(string15, "{\n                contex…ission_sms)\n            }");
                return string15;
            case -798669607:
                if (!permission.equals(Permission.BLUETOOTH_CONNECT)) {
                    return "";
                }
                string = Build.VERSION.SDK_INT >= 31 ? context.getString(R.string.common_permission_nearby_devices) : "";
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case -784330217:
                if (!permission.equals(Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) {
                    return "";
                }
                String string16 = context.getString(R.string.common_permission_ignore_battery_optimize);
                Intrinsics.checkNotNullExpressionValue(string16, "{\n                contex…y_optimize)\n            }");
                return string16;
            case -598942459:
                if (!permission.equals(Permission.PICTURE_IN_PICTURE)) {
                    return "";
                }
                String string17 = context.getString(R.string.common_permission_picture_in_picture);
                Intrinsics.checkNotNullExpressionValue(string17, "{\n                contex…in_picture)\n            }");
                return string17;
            case -406040016:
                if (!permission.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    return "";
                }
                String string18 = context.getString(R.string.common_permission_storage);
                Intrinsics.checkNotNullExpressionValue(string18, "{\n                contex…on_storage)\n            }");
                return string18;
            case -272536472:
                if (!permission.equals(Permission.BIND_VPN_SERVICE)) {
                    return "";
                }
                String string19 = context.getString(R.string.common_permission_vpn);
                Intrinsics.checkNotNullExpressionValue(string19, "{\n                contex…ission_vpn)\n            }");
                return string19;
            case -162862488:
                if (!permission.equals(Permission.PACKAGE_USAGE_STATS)) {
                    return "";
                }
                String string20 = context.getString(R.string.common_permission_apps_with_usage_access);
                Intrinsics.checkNotNullExpressionValue(string20, "{\n                contex…age_access)\n            }");
                return string20;
            case -121723492:
                if (!permission.equals(Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
                    return "";
                }
                String string21 = context.getString(R.string.common_permission_allow_notifications_access);
                Intrinsics.checkNotNullExpressionValue(string21, "{\n                contex…ons_access)\n            }");
                return string21;
            case -63024214:
                if (!permission.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    string2 = context.getString(R.string.common_permission_location);
                } else {
                    string2 = context.getString(R.string.common_permission_location);
                }
                String str2 = string2;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n                if (Bu…          }\n            }");
                return str2;
            case -5573545:
                if (!permission.equals("android.permission.READ_PHONE_STATE")) {
                    return "";
                }
                String string110 = context.getString(R.string.common_permission_phone);
                Intrinsics.checkNotNullExpressionValue(string110, "{\n                contex…sion_phone)\n            }");
                return string110;
            case 52602690:
                if (!permission.equals(Permission.SEND_SMS)) {
                    return "";
                }
                String string111 = context.getString(R.string.common_permission_sms);
                Intrinsics.checkNotNullExpressionValue(string111, "{\n                contex…ission_sms)\n            }");
                return string111;
            case 112197485:
                if (!permission.equals(Permission.CALL_PHONE)) {
                    return "";
                }
                String string112 = context.getString(R.string.common_permission_phone);
                Intrinsics.checkNotNullExpressionValue(string112, "{\n                contex…sion_phone)\n            }");
                return string112;
            case 175802396:
                if (!permission.equals(Permission.READ_MEDIA_IMAGES)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 33) {
                }
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case 214526995:
                if (!permission.equals(Permission.WRITE_CONTACTS)) {
                    return "";
                }
                String string22 = context.getString(R.string.common_permission_contacts);
                Intrinsics.checkNotNullExpressionValue(string22, "{\n                contex…n_contacts)\n            }");
                return string22;
            case 463403621:
                if (!permission.equals(Permission.CAMERA)) {
                    return "";
                }
                String string23 = context.getString(R.string.common_permission_camera);
                Intrinsics.checkNotNullExpressionValue(string23, "{\n                contex…ion_camera)\n            }");
                return string23;
            case 603653886:
                if (!permission.equals(Permission.WRITE_CALENDAR)) {
                    return "";
                }
                String string24 = context.getString(R.string.common_permission_calendar);
                Intrinsics.checkNotNullExpressionValue(string24, "{\n                contex…n_calendar)\n            }");
                return string24;
            case 610633091:
                if (!permission.equals(Permission.WRITE_CALL_LOG)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    i = R.string.common_permission_call_logs;
                } else {
                    i = R.string.common_permission_phone;
                }
                String string25 = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string25, "{\n                contex…sion_phone)\n            }");
                return string25;
            case 691260818:
                if (!permission.equals(Permission.READ_MEDIA_AUDIO)) {
                    return "";
                }
                string = Build.VERSION.SDK_INT >= 33 ? context.getString(R.string.common_permission_music_and_audio) : "";
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case 710297143:
                if (!permission.equals(Permission.READ_MEDIA_VIDEO)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 33) {
                }
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case 784519842:
                if (!permission.equals(Permission.USE_SIP)) {
                    return "";
                }
                String string113 = context.getString(R.string.common_permission_phone);
                Intrinsics.checkNotNullExpressionValue(string113, "{\n                contex…sion_phone)\n            }");
                return string113;
            case 952819282:
                if (!permission.equals(Permission.PROCESS_OUTGOING_CALLS)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    i = R.string.common_permission_call_logs;
                } else {
                    i = R.string.common_permission_phone;
                }
                String string26 = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string26, "{\n                contex…sion_phone)\n            }");
                return string26;
            case 970694249:
                if (!permission.equals(Permission.SCHEDULE_EXACT_ALARM)) {
                    return "";
                }
                String string27 = context.getString(R.string.common_permission_alarms_reminders);
                Intrinsics.checkNotNullExpressionValue(string27, "{\n                contex…_reminders)\n            }");
                return string27;
            case 1166454870:
                if (!permission.equals(Permission.BLUETOOTH_ADVERTISE)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 31) {
                }
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case 1271781903:
                if (!permission.equals("android.permission.GET_ACCOUNTS")) {
                    return "";
                }
                String string28 = context.getString(R.string.common_permission_contacts);
                Intrinsics.checkNotNullExpressionValue(string28, "{\n                contex…n_contacts)\n            }");
                return string28;
            case 1365911975:
                if (!permission.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    return "";
                }
                String string114 = context.getString(R.string.common_permission_storage);
                Intrinsics.checkNotNullExpressionValue(string114, "{\n                contex…on_storage)\n            }");
                return string114;
            case 1777263169:
                if (!permission.equals(Permission.REQUEST_INSTALL_PACKAGES)) {
                    return "";
                }
                String string29 = context.getString(R.string.common_permission_install_unknown_apps);
                Intrinsics.checkNotNullExpressionValue(string29, "{\n                contex…known_apps)\n            }");
                return string29;
            case 1780337063:
                if (!permission.equals(Permission.ACTIVITY_RECOGNITION)) {
                    return "";
                }
                String string30 = context.getString(Build.VERSION.SDK_INT >= 30 ? R.string.common_permission_activity_recognition_api30 : R.string.common_permission_activity_recognition_api29);
                Intrinsics.checkNotNullExpressionValue(string30, "{\n                contex…ion_api29)\n\n            }");
                return string30;
            case 1831139720:
                if (!permission.equals(Permission.RECORD_AUDIO)) {
                    return "";
                }
                String string31 = context.getString(R.string.common_permission_microphone);
                Intrinsics.checkNotNullExpressionValue(string31, "{\n                contex…microphone)\n            }");
                return string31;
            case 1977429404:
                if (!permission.equals(Permission.READ_CONTACTS)) {
                    return "";
                }
                String string210 = context.getString(R.string.common_permission_contacts);
                Intrinsics.checkNotNullExpressionValue(string210, "{\n                contex…n_contacts)\n            }");
                return string210;
            case 2024715147:
                if (!permission.equals(Permission.ACCESS_BACKGROUND_LOCATION)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    string2 = context.getString(R.string.common_permission_location);
                } else {
                    string2 = context.getString(R.string.common_permission_location);
                }
                String str3 = string2;
                Intrinsics.checkNotNullExpressionValue(str3, "{\n                if (Bu…          }\n            }");
                return str3;
            case 2062356686:
                if (!permission.equals(Permission.BLUETOOTH_SCAN)) {
                    return "";
                }
                if (Build.VERSION.SDK_INT >= 31) {
                }
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case 2114579147:
                if (!permission.equals(Permission.ACCESS_MEDIA_LOCATION)) {
                    return "";
                }
                string = Build.VERSION.SDK_INT >= 29 ? context.getString(R.string.common_permission_access_media_location) : "";
                Intrinsics.checkNotNullExpressionValue(string, "{\n                if (Bu…          }\n            }");
                return string;
            case 2133799037:
                if (!permission.equals(Permission.ADD_VOICEMAIL)) {
                    return "";
                }
                String string115 = context.getString(R.string.common_permission_phone);
                Intrinsics.checkNotNullExpressionValue(string115, "{\n                contex…sion_phone)\n            }");
                return string115;
            default:
                return "";
        }
    }

    @NotNull
    public final List<String> c(@NotNull Context context, @NotNull List<String> permissions, @NotNull List<String> permissionHints) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
        Intrinsics.checkNotNullParameter(permissionHints, "permissionHints");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : permissions) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String strB = f33932a.b(context, (String) obj);
            if (strB.length() > 0) {
                String str = strB + "：" + CollectionsKt.getOrNull(permissionHints, i);
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public final String d(@NotNull final Context context, @NotNull List<String> permissions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
        return CollectionsKt.joinToString$default(permissions, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<String, CharSequence>() { // from class: com.huachenjie.common.util.permission.PermissionNameConvert$permissionsToNames$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final CharSequence invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                return PermissionNameConvert.f33932a.b(context, str);
            }
        }, 30, (Object) null);
    }
}
