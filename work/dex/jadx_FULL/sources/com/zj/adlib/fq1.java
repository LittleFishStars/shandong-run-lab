package com.zj.adlib;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"", "t", "", "format", "a", "str", "", "c", "common_release"}, k = 2, mv = {1, 8, 0})
public final class fq1 {
    @NotNull
    public static final String a(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "format");
        if (j <= 0) {
            return "";
        }
        if (String.valueOf(j).length() <= 10) {
            j *= (long) 1000;
        }
        try {
            String str2 = new SimpleDateFormat(str, Locale.CHINESE).format(Long.valueOf(j));
            Intrinsics.checkNotNullExpressionValue(str2, "sdf.format(time)");
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static /* synthetic */ String b(long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "yyyy.MM.dd";
        }
        return a(j, str);
    }

    public static final boolean c(@Nullable String str) {
        return TextUtils.isEmpty(str);
    }
}
