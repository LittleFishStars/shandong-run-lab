package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/zj/adlib/h40;", "", "Landroid/content/Context;", "context", "", "a", "", "Ljava/lang/String;", "ALIPAY_NFC_MINI_APP_ID", "b", "AUTH_BIND_PAGE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class h40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h40 f42045a = new h40();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String ALIPAY_NFC_MINI_APP_ID = "2021006175622330";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String AUTH_BIND_PAGE = "pages/auth-bind/index";

    @JvmStatic
    public static final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String satoken = ai9.e().getSatoken();
        if (satoken == null || satoken.length() == 0) {
            fv5.b("登录状态异常，请重新登录");
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startapp?appId=2021006175622330&page=pages/auth-bind/index&query=" + Uri.encode("satoken=" + satoken))));
        } catch (Exception unused) {
            fv5.b("请先安装支付宝APP后绑定");
        }
    }
}
