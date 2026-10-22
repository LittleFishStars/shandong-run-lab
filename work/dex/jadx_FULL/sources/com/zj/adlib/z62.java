package com.zj.adlib;

import com.alibaba.android.arouter.utils.Consts;
import com.google.android.material.timepicker.TimeModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"Lcom/zj/adlib/z62;", "", "", "disMeter", "", "keepDecimalSize", "", "c", "(Ljava/lang/Long;Ljava/lang/Integer;)Ljava/lang/String;", "a", "(Ljava/lang/Long;)Ljava/lang/String;", "b", "(Ljava/lang/Long;I)Ljava/lang/String;", "originStr", "keepIndex", "d", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class z62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z62 f46193a = new z62();

    @NotNull
    public final String a(@Nullable Long disMeter) {
        try {
            return b(disMeter, 1);
        } catch (Exception unused) {
            return "0";
        }
    }

    @NotNull
    public final String b(@Nullable Long disMeter, int keepDecimalSize) {
        if (disMeter == null) {
            return "0";
        }
        String strValueOf = String.valueOf((disMeter.longValue() * 1.0f) / 1000);
        i4a.c(strValueOf);
        return d(strValueOf, keepDecimalSize);
    }

    @NotNull
    public final String c(@Nullable Long disMeter, @Nullable Integer keepDecimalSize) {
        String strSubstring;
        int iIntValue = (keepDecimalSize == null || keepDecimalSize.intValue() < 1) ? 1 : keepDecimalSize.intValue();
        if (disMeter != null) {
            try {
                if (disMeter.longValue() > 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{disMeter}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    int length = str.length();
                    if (length == 1) {
                        strSubstring = String.format("0.00%s", Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "format(format, *args)");
                    } else if (length == 2) {
                        strSubstring = String.format("0.0%s", Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "format(format, *args)");
                    } else if (length != 3) {
                        String strSubstring2 = str.substring(0, str.length() - 3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        String strSubstring3 = str.substring(str.length() - 3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String).substring(startIndex)");
                        strSubstring = String.format("%s.%s", Arrays.copyOf(new Object[]{strSubstring2, strSubstring3}, 2));
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "format(format, *args)");
                    } else {
                        strSubstring = String.format("0.%s", Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "format(format, *args)");
                    }
                    int iIndexOf$default = StringsKt.indexOf$default(strSubstring, Consts.DOT, 0, false, 6, (Object) null) + 1;
                    if (iIndexOf$default == -1) {
                        return "0";
                    }
                    int i = iIndexOf$default + iIntValue;
                    if (i < strSubstring.length()) {
                        strSubstring = strSubstring.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    while (StringsKt.endsWith$default(strSubstring, "0", false, 2, (Object) null)) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    if (!StringsKt.endsWith$default(strSubstring, Consts.DOT, false, 2, (Object) null)) {
                        return strSubstring;
                    }
                    String strSubstring4 = strSubstring.substring(0, strSubstring.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    return strSubstring4;
                }
            } catch (Exception unused) {
                return b(disMeter, iIntValue);
            }
        }
        return "0";
    }

    @NotNull
    public final String d(@NotNull String originStr, int keepIndex) {
        Intrinsics.checkNotNullParameter(originStr, "originStr");
        int iIndexOf$default = StringsKt.indexOf$default(originStr, Consts.DOT, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return originStr;
        }
        int i = iIndexOf$default + 1;
        if (originStr.length() - i > keepIndex) {
            originStr = originStr.substring(0, i + keepIndex);
            Intrinsics.checkNotNullExpressionValue(originStr, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        while (StringsKt.endsWith$default(originStr, "0", false, 2, (Object) null)) {
            originStr = originStr.substring(0, originStr.length() - 1);
            Intrinsics.checkNotNullExpressionValue(originStr, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (!StringsKt.endsWith$default(originStr, Consts.DOT, false, 2, (Object) null)) {
            return originStr;
        }
        String strSubstring = originStr.substring(0, originStr.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
