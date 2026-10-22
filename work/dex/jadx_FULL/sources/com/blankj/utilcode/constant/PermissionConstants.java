package com.blankj.utilcode.constant;

import android.annotation.SuppressLint;
import com.hjq.permissions.Permission;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"InlinedApi"})
public final class PermissionConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28115a = "CALENDAR";
    public static final String b = "CAMERA";
    public static final String c = "CONTACTS";
    public static final String d = "LOCATION";
    public static final String e = "MICROPHONE";
    public static final String f = "PHONE";
    public static final String g = "SENSORS";
    public static final String h = "SMS";
    public static final String i = "STORAGE";
    public static final String j = "ACTIVITY_RECOGNITION";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f1232a = {Permission.READ_CALENDAR, Permission.WRITE_CALENDAR};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String[] f1233b = {Permission.CAMERA};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String[] f1234c = {Permission.READ_CONTACTS, Permission.WRITE_CONTACTS, "android.permission.GET_ACCOUNTS"};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String[] f1235d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", Permission.ACCESS_BACKGROUND_LOCATION};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String[] f1236e = {Permission.RECORD_AUDIO};

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String[] f1237f = {"android.permission.READ_PHONE_STATE", Permission.READ_PHONE_NUMBERS, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS, Permission.ANSWER_PHONE_CALLS};

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String[] f1238g = {"android.permission.READ_PHONE_STATE", Permission.READ_PHONE_NUMBERS, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS};

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String[] f1239h = {Permission.BODY_SENSORS};

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String[] f1240i = {Permission.SEND_SMS, Permission.RECEIVE_SMS, Permission.READ_SMS, Permission.RECEIVE_WAP_PUSH, Permission.RECEIVE_MMS};

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String[] f1241j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String[] k = {Permission.ACTIVITY_RECOGNITION};

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    public static String[] a(String str) {
        if (str == null) {
            return new String[0];
        }
        switch (str) {
            case "LOCATION":
                return f1235d;
            case "SENSORS":
                return f1239h;
            case "STORAGE":
                return f1241j;
            case "SMS":
                return f1240i;
            case "PHONE":
                return f1237f;
            case "ACTIVITY_RECOGNITION":
                return k;
            case "CONTACTS":
                return f1234c;
            case "CALENDAR":
                return f1232a;
            case "MICROPHONE":
                return f1236e;
            case "CAMERA":
                return f1233b;
            default:
                return new String[]{str};
        }
    }
}
