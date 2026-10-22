package com.zj.adlib;

import com.alibaba.android.arouter.utils.Consts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/zj/adlib/i46;", "", "", "num", "", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class i46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i46 f42276a = new i46();

    @JvmStatic
    @NotNull
    public static final String a(float num) {
        String strValueOf = String.valueOf(num);
        Intrinsics.checkNotNullExpressionValue(strValueOf, "numStr");
        if (!StringsKt.contains$default(strValueOf, Consts.DOT, false, 2, (Object) null)) {
            return strValueOf;
        }
        while (true) {
            Intrinsics.checkNotNullExpressionValue(strValueOf, "originStr");
            if (!StringsKt.endsWith$default(strValueOf, "0", false, 2, (Object) null)) {
                break;
            }
            Intrinsics.checkNotNullExpressionValue(strValueOf, "originStr");
            strValueOf = strValueOf.substring(0, strValueOf.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strValueOf, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Intrinsics.checkNotNullExpressionValue(strValueOf, "originStr");
        if (StringsKt.endsWith$default(strValueOf, Consts.DOT, false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(strValueOf, "originStr");
            strValueOf = strValueOf.substring(0, strValueOf.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strValueOf, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Intrinsics.checkNotNullExpressionValue(strValueOf, "originStr");
        return strValueOf;
    }
}
