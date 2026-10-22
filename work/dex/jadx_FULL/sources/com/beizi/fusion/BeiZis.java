package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZis {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BeiZiCustomController f26973a = null;
    private static boolean b = false;
    private static String c = "1.0.25";
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = false;

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str) {
        d = false;
        q1.h().a(context, str, null, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInitWithDomain(Context context, String str, String str2) {
        d = false;
        if (TextUtils.isEmpty(str2)) {
            q1.h().a(context, str, null, null);
        } else {
            q1.h().b(str2).a(context, str, null, null);
        }
    }

    public static void closeShakeAd() {
        f = true;
    }

    public static String getBidToken(String str) {
        return q1.h().a(str);
    }

    public static BeiZiCustomController getCustomController() {
        return f26973a;
    }

    public static String getOaidVersion() {
        return c;
    }

    public static String getSdkVersion() {
        return "5.5.0.2";
    }

    public static boolean getTransferProtocol() {
        return e;
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void init(Context context, String str) {
        q1.h().a(context, str, null, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void initWithDomain(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            q1.h().a(context, str, null, null);
        } else {
            q1.h().b(str2).a(context, str, null, null);
        }
    }

    public static boolean isCloseShakeAd() {
        return f;
    }

    public static boolean isIsSyncInit() {
        return d;
    }

    public static boolean isLimitPersonalAds() {
        return b;
    }

    public static void setAnyCustomExt(Map<String, Object> map) {
        q1.h().a(map);
    }

    public static void setLimitPersonalAds(boolean z) {
        b = z;
    }

    public static void setOaidVersion(String str) {
        c = str;
    }

    public static void setSupportPersonalized(boolean z) {
        al.a(z);
    }

    public static void setTransferProtocol(boolean z) {
        e = z;
    }

    public static void setUserAgent(String str) {
        rf.a().a(str);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f26973a = beiZiCustomController;
        q1.h().a(context, str, null, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str, BeiZiInitCallBack beiZiInitCallBack) {
        d = false;
        q1.h().b(beiZiInitCallBack);
        q1.h().a(context, str, null, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f26973a = beiZiCustomController;
        q1.h().a(context, str, str2, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInitWithDomain(Context context, String str, String str2, BeiZiInitCallBack beiZiInitCallBack) {
        d = false;
        q1.h().b(beiZiInitCallBack);
        if (!TextUtils.isEmpty(str2)) {
            q1.h().b(str2).a(context, str, null, null);
        } else {
            q1.h().a(context, str, null, null);
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f26973a = beiZiCustomController;
        d = false;
        q1.h().a(context, str, null, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f26973a = beiZiCustomController;
        q1.h().a(context, str, str2, str3);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, BeiZiInitCallBack beiZiInitCallBack) {
        f26973a = beiZiCustomController;
        d = false;
        q1.h().b(beiZiInitCallBack);
        q1.h().a(context, str, null, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f26973a = beiZiCustomController;
        d = false;
        q1.h().a(context, str, str2, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, BeiZiInitCallBack beiZiInitCallBack) {
        f26973a = beiZiCustomController;
        d = false;
        q1.h().b(beiZiInitCallBack);
        q1.h().a(context, str, str2, null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f26973a = beiZiCustomController;
        d = false;
        q1.h().a(context, str, str2, str3);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3, BeiZiInitCallBack beiZiInitCallBack) {
        f26973a = beiZiCustomController;
        d = false;
        q1.h().b(beiZiInitCallBack);
        q1.h().a(context, str, str2, str3);
    }
}
