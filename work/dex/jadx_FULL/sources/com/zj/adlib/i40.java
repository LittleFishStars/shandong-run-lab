package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Lcom/zj/adlib/i40;", "", "", "result", "", "a", "Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "PREFIX", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAlipayMiniQRCodeUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlipayMiniQRCodeUtil.kt\ncom/huachenjie/common/util/AlipayMiniQRCodeUtil\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,37:1\n29#2:38\n*S KotlinDebug\n*F\n+ 1 AlipayMiniQRCodeUtil.kt\ncom/huachenjie/common/util/AlipayMiniQRCodeUtil\n*L\n27#1:38\n*E\n"})
public final class i40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i40 f42272a = new i40();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String PREFIX = "alipays://platformapi/startapp";

    public final boolean a(@Nullable String result) {
        return !(result == null || result.length() == 0) && StringsKt.startsWith$default(result, PREFIX, false, 2, (Object) null);
    }

    public final boolean b(@NotNull Context context, @Nullable String result) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!a(result)) {
            return false;
        }
        try {
            Intrinsics.checkNotNull(result);
            Uri uri = Uri.parse(result);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
