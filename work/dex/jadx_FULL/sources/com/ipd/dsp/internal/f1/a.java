package com.ipd.dsp.internal.f1;

import androidx.annotation.NonNull;
import com.ali.auth.third.core.model.KernelMessageConstants;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.igexin.sdk.PushConsts;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38306a;
    public String b;

    public a(int i, String str) {
        this.f38306a = i;
        this.b = str;
    }

    public static a a(String str) {
        return new a(10005, str);
    }

    public static a b(String str) {
        return new a(10002, str);
    }

    public static a c(String str) {
        return new a(10004, str);
    }

    public static a d() {
        return new a(10000, "初始化参数异常");
    }

    public static a e(String str) {
        return new a(10001, str);
    }

    public static a f() {
        return b("网络错误");
    }

    public static a g() {
        return new a(10009, "渲染失败");
    }

    public static a h() {
        return c("素材加载错误");
    }

    public static a i() {
        return d("没有广告");
    }

    public static a j() {
        return new a(10011, "配置错误，请升级SDK");
    }

    public static a k() {
        return e(AlibcProtocolConstant.UNKNOWN_ERROR);
    }

    public static a l() {
        return new a(PushConsts.GET_SDKSERVICEPID, "广告过期，请重新请求");
    }

    @NonNull
    public String toString() {
        return a(this.f38306a, this.b);
    }

    public static a a() {
        return new a(10012, "Activity为空或已destroyed");
    }

    public static a b() {
        return new a(10006, "容器为空");
    }

    public static a c() {
        return new a(PushConsts.GET_SDKONLINESTATE, "Context为空");
    }

    public static a d(String str) {
        return new a(10003, str);
    }

    public static a e() {
        return a("内部错误");
    }

    public static a a(Throwable th) {
        return new a(KernelMessageConstants.PARAM_ERROR, th != null ? th.getMessage() : "unknown error");
    }

    public static String a(int i, String str) {
        return String.format(Locale.getDefault(), "%d:%s", Integer.valueOf(i), str);
    }
}
