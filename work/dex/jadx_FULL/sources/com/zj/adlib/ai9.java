package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huachenjie.common.bean.BrandPromotionConfigBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.bean.SportStatics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ai9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CommonUserInfo f40539a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static SportStatics f15276a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f15277a = "UserConfigStorage";
    public static final String b = "keyCommonUserInfo";
    public static final String c = "keyFreeRunningStatics";
    public static final String d = "keyGoodReviews";
    public static final String e = "keyFeaturePushNew";
    public static final String f = "chooseRunningPlanCode";
    public static final String g = "chooseSemesterBean";
    public static final String h = "keyBrandPromotionConfig";

    public static void a() {
        zr8.c(f15277a).l(h);
    }

    public static void b() {
        f40539a = null;
        f15276a = null;
        zr8.c(f15277a).a();
    }

    @Nullable
    public static BrandPromotionConfigBean c() {
        String str = (String) zr8.c(f15277a).h(h, "");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (BrandPromotionConfigBean) new Gson().fromJson(str, BrandPromotionConfigBean.class);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static SemesterBean d() {
        String str = (String) zr8.c(f15277a).h(g, "");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (SemesterBean) new Gson().fromJson(str, SemesterBean.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static CommonUserInfo e() {
        if (f40539a == null) {
            CommonUserInfo commonUserInfo = (CommonUserInfo) new Gson().fromJson((String) zr8.c(f15277a).h(b, ""), CommonUserInfo.class);
            f40539a = commonUserInfo;
            if (commonUserInfo == null) {
                return new CommonUserInfo();
            }
        }
        return f40539a;
    }

    public static String f(String key) {
        return (String) zr8.c(f15277a).h(key, "");
    }

    public static SportStatics g() {
        if (f15276a == null) {
            SportStatics sportStatics = (SportStatics) new Gson().fromJson((String) zr8.c(f15277a).h(c, ""), SportStatics.class);
            f15276a = sportStatics;
            if (sportStatics == null) {
                return new SportStatics();
            }
        }
        return f15276a;
    }

    public static int h() {
        return ((Integer) zr8.c(f15277a).h(d, -1)).intValue();
    }

    public static String i() {
        return (String) zr8.c(f15277a).h(f, "");
    }

    public static void j(Context context) {
        zr8.f(f15277a, new p55(context, f15277a), new wp());
    }

    public static boolean k() {
        return ((Boolean) zr8.c(f15277a).h(e, Boolean.TRUE)).booleanValue();
    }

    public static boolean l() {
        return !TextUtils.isEmpty(e().getToken());
    }

    public static boolean m() {
        return e().getUserType() == 1;
    }

    public static boolean n() {
        return o(e().getUserType());
    }

    public static boolean o(int userType) {
        return userType == 0;
    }

    public static void p(@NotNull String key) {
        zr8.c(f15277a).l(key);
    }

    public static void q(@Nullable BrandPromotionConfigBean config) {
        try {
            if (config == null) {
                a();
            } else {
                zr8.c(f15277a).j(h, new Gson().toJson(config));
            }
        } catch (Exception unused) {
        }
    }

    public static void r(@Nullable SemesterBean semesterBean) {
        try {
            if (semesterBean == null) {
                zr8.c(f15277a).j(g, "");
            } else {
                zr8.c(f15277a).j(g, new Gson().toJson(semesterBean));
            }
        } catch (Exception unused) {
        }
    }

    public static void s(CommonUserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        f40539a = userInfo;
        zr8.c(f15277a).j(b, new Gson().toJson(userInfo));
    }

    public static void t(String key, String value) {
        zr8.c(f15277a).j(key, value);
    }

    public static void u(boolean on) {
        zr8.c(f15277a).j(e, Boolean.valueOf(on));
    }

    public static void v(SportStatics sportStatics) {
        f15276a = sportStatics;
        zr8.c(f15277a).j(c, f15276a != null ? new Gson().toJson(f15276a) : "");
    }

    public static void w(int showGoodReviews) {
        zr8.c(f15277a).j(d, Integer.valueOf(showGoodReviews));
    }

    public static void x(String runPlanCode) {
        zr8.c(f15277a).j(f, runPlanCode);
    }
}
