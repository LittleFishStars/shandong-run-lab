package com.zj.adlib;

import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J-\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ7\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0012\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013JA\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u0002J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u0004J3\u0010#\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/zj/adlib/ll7;", "", "", "disMeter", "", "appendUnit", "isEngUnit", "", "e", "(Ljava/lang/Integer;ZZ)Ljava/lang/String;", "keepOneDecimalSize", "f", "(Ljava/lang/Integer;ZZI)Ljava/lang/String;", "", y6b.g, "(Ljava/lang/Long;ZZ)Ljava/lang/String;", y6b.f, "(Ljava/lang/Long;)Ljava/lang/String;", "i", "(Ljava/lang/Long;ZZI)Ljava/lang/String;", "delZeroFix", "j", "(Ljava/lang/Long;ZZZI)Ljava/lang/String;", "d", "(Ljava/lang/Integer;)Ljava/lang/String;", "keepSmallSize", "a", "pace", "isKeepHourUnix", "p", "type", "", "completionRate", "doneDistance", "doneTargetTimes", "c", "(ILjava/lang/Float;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/lang/String;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class ll7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ll7 f43096a = new ll7();

    public static /* synthetic */ String b(ll7 ll7Var, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return ll7Var.a(j, i);
    }

    public static /* synthetic */ String k(ll7 ll7Var, Integer num, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            i = 1;
        }
        return ll7Var.f(num, z, z2, i);
    }

    public static /* synthetic */ String l(ll7 ll7Var, Integer num, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return ll7Var.e(num, z, z2);
    }

    public static /* synthetic */ String m(ll7 ll7Var, Long l, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            i = 1;
        }
        return ll7Var.i(l, z, z2, i);
    }

    public static /* synthetic */ String n(ll7 ll7Var, Long l, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return ll7Var.h(l, z, z2);
    }

    public static /* synthetic */ String q(ll7 ll7Var, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return ll7Var.p(j, z);
    }

    @Nullable
    public final String a(long disMeter, int keepSmallSize) {
        if (disMeter < 10000000) {
            return BigDecimal.valueOf(disMeter).divide(BigDecimal.valueOf(1000L), keepSmallSize, 1).toString();
        }
        return BigDecimal.valueOf((long) ((disMeter * 1.0f) / 10000)).divide(BigDecimal.valueOf(1000L), keepSmallSize, 1) + "W";
    }

    @NotNull
    public final String c(int type, @Nullable Float completionRate, @Nullable Long doneDistance, @Nullable Integer doneTargetTimes) {
        int iFloatValue = (int) ((completionRate != null ? completionRate.floatValue() : 0.0f) * 100);
        if (type == 2) {
            return iFloatValue + "%\n" + (doneTargetTimes != null ? doneTargetTimes.intValue() : 0) + "次";
        }
        return iFloatValue + "%\n" + h46.f42049a.j(Float.valueOf((float) (Math.floor((doneDistance != null ? doneDistance.longValue() : 0L) / ((long) 100)) / 10.0d)), 1) + "km";
    }

    @Nullable
    public final String d(@Nullable Integer disMeter) {
        return g(disMeter != null ? Long.valueOf(disMeter.intValue()) : null);
    }

    @Nullable
    public final String e(@Nullable Integer disMeter, boolean appendUnit, boolean isEngUnit) {
        return f(disMeter, appendUnit, isEngUnit, 1);
    }

    @Nullable
    public final String f(@Nullable Integer disMeter, boolean appendUnit, boolean isEngUnit, int keepOneDecimalSize) {
        return i(disMeter != null ? Long.valueOf(disMeter.intValue()) : null, appendUnit, isEngUnit, keepOneDecimalSize);
    }

    @Nullable
    public final String g(@Nullable Long disMeter) {
        return h(disMeter, false, false);
    }

    @Nullable
    public final String h(@Nullable Long disMeter, boolean appendUnit, boolean isEngUnit) {
        return i(disMeter, appendUnit, isEngUnit, 1);
    }

    @NotNull
    public final String i(@Nullable Long disMeter, boolean appendUnit, boolean isEngUnit, int keepOneDecimalSize) {
        String str;
        if (disMeter == null) {
            return "0.0";
        }
        if (appendUnit) {
            str = isEngUnit ? "km" : "公里";
        } else {
            str = "";
        }
        return h46.f42049a.j(Float.valueOf((disMeter.longValue() * 1.0f) / 1000), keepOneDecimalSize) + str;
    }

    @Nullable
    public final String j(@Nullable Long disMeter, boolean appendUnit, boolean isEngUnit, boolean delZeroFix, int keepOneDecimalSize) {
        String str;
        if (disMeter == null) {
            disMeter = 0L;
        }
        if (appendUnit) {
            str = isEngUnit ? "km" : "公里";
        } else {
            str = "";
        }
        return h46.f42049a.h(Double.valueOf((disMeter.longValue() * 1.0d) / 1000), keepOneDecimalSize) + str;
    }

    @NotNull
    public final String p(long pace, boolean isKeepHourUnix) {
        String strF = s72.f(pace, isKeepHourUnix);
        Intrinsics.checkNotNullExpressionValue(strF, "formatPaceTimeWithSecond(pace, isKeepHourUnix)");
        return strF;
    }
}
