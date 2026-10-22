package com.zj.adlib;

import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.login.bean.GradeBean;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.bean.RegisterConfigBean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0013R$\u0010$\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0016\u0010+\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006."}, d2 = {"Lcom/zj/adlib/pg3;", "", "", "a", "Lcom/huachenjie/login/bean/LoginResultData;", "Lcom/huachenjie/login/bean/LoginResultData;", "e", "()Lcom/huachenjie/login/bean/LoginResultData;", "j", "(Lcom/huachenjie/login/bean/LoginResultData;)V", "resultData", "Lcom/huachenjie/login/bean/RegisterConfigBean;", "Lcom/huachenjie/login/bean/RegisterConfigBean;", "c", "()Lcom/huachenjie/login/bean/RegisterConfigBean;", y6b.g, "(Lcom/huachenjie/login/bean/RegisterConfigBean;)V", "configBean", "", "Ljava/lang/String;", UserConstants.USER_PARAMS.b, "", "I", "f", "()I", "k", "(I)V", "sex", "b", "()Ljava/lang/String;", y6b.f, "(Ljava/lang/String;)V", "birthdayData", "portraitUrl", "d", "i", "portraitCode", "Lcom/huachenjie/common/bean/SchoolInfo;", "Lcom/huachenjie/common/bean/SchoolInfo;", UserConstants.LOGIN_PARAMS.c, "Lcom/huachenjie/login/bean/GradeBean;", "Lcom/huachenjie/login/bean/GradeBean;", "gradeInfo", "alumnusId", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class pg3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static int sex;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @JvmField
    @Nullable
    public static SchoolInfo schoolInfo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @JvmField
    @Nullable
    public static GradeBean gradeInfo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static LoginResultData resultData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static RegisterConfigBean configBean;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public static String portraitCode;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final pg3 f18845a = new pg3();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String nickName = "";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static String birthdayData = "";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public static String portraitUrl = "";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public static String alumnusId = "";

    public final void a() {
        resultData = null;
        configBean = null;
        nickName = "";
        sex = 0;
        birthdayData = "";
        portraitUrl = "";
        schoolInfo = null;
        gradeInfo = null;
        alumnusId = "";
    }

    @NotNull
    public final String b() {
        return birthdayData;
    }

    @Nullable
    public final RegisterConfigBean c() {
        return configBean;
    }

    @Nullable
    public final String d() {
        return portraitCode;
    }

    @Nullable
    public final LoginResultData e() {
        return resultData;
    }

    public final int f() {
        return sex;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        birthdayData = str;
    }

    public final void h(@Nullable RegisterConfigBean registerConfigBean) {
        configBean = registerConfigBean;
    }

    public final void i(@Nullable String str) {
        portraitCode = str;
    }

    public final void j(@Nullable LoginResultData loginResultData) {
        resultData = loginResultData;
    }

    public final void k(int i) {
        sex = i;
    }
}
