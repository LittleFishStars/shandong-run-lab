package com.zj.adlib;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/zj/adlib/o0a;", "", "", "time", "", "a", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class o0a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o0a f43642a = new o0a();

    @NotNull
    public final String a(long time) {
        String str;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(time);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return "今天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Long.valueOf(time));
        }
        calendar.add(6, -1);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            str = "昨天 " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Long.valueOf(time));
        } else {
            str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(time));
        }
        Intrinsics.checkNotNullExpressionValue(str, "{\n            now.add(Ca…)\n            }\n        }");
        return str;
    }
}
