package com.zj.adlib;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kuaishou.weapon.p0.t;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006¨\u0006 "}, d2 = {"Lcom/zj/adlib/h46;", "", "", "fee", "", "size", "", "i", "(Ljava/lang/Double;I)Ljava/lang/String;", "", "j", "(Ljava/lang/Float;I)Ljava/lang/String;", y6b.f, "(Ljava/lang/Double;)Ljava/lang/String;", "keepPointCount", y6b.g, "num", "k", t.d, "per", "f", "e", "d", "b", "", "c", "a", "str", "", "m", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class h46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h46 f42049a = new h46();

    @NotNull
    public final String a(double num) {
        if (num <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return "0";
        }
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        Intrinsics.checkNotNullExpressionValue(numberInstance, "getNumberInstance()");
        String str = numberInstance.format(num);
        Intrinsics.checkNotNullExpressionValue(str, "numberFormat.format(num)");
        return str;
    }

    @NotNull
    public final String b(int num) {
        if (num <= 0) {
            return "0";
        }
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        Intrinsics.checkNotNullExpressionValue(numberInstance, "getNumberInstance()");
        String str = numberInstance.format(Integer.valueOf(num));
        Intrinsics.checkNotNullExpressionValue(str, "numberFormat.format(num)");
        return str;
    }

    @NotNull
    public final String c(long num) {
        if (num <= 0) {
            return "0";
        }
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        Intrinsics.checkNotNullExpressionValue(numberInstance, "getNumberInstance()");
        String str = numberInstance.format(num);
        Intrinsics.checkNotNullExpressionValue(str, "numberFormat.format(num)");
        return str;
    }

    @NotNull
    public final String d(int num) {
        return String.valueOf(i(Double.valueOf(((double) num) / 1000.0d), 3));
    }

    @NotNull
    public final String e(int num) {
        try {
            return new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"}[num];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @NotNull
    public final String f(float per) {
        if (per <= 0.0f) {
            return "0%";
        }
        if (per >= 1.0d) {
            return "100%";
        }
        return ((int) (per * 100)) + "%";
    }

    @NotNull
    public final String g(@Nullable Double fee) {
        return h(fee, 4);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a A[PHI: r1
      0x000a: PHI (r1v6 int) = (r1v1 int), (r1v2 int) binds: [B:3:0x0008, B:6:0x000d] A[DONT_GENERATE, DONT_INLINE]] */
    @NotNull
    public final String h(@Nullable Double fee, int keepPointCount) {
        double dDoubleValue;
        StringBuilder sb = new StringBuilder("##########.");
        int i = 1;
        if (keepPointCount <= 1) {
            keepPointCount = i;
        } else {
            i = 6;
            if (keepPointCount >= 6) {
                keepPointCount = i;
            }
        }
        for (int i2 = 0; i2 < keepPointCount; i2++) {
            sb.append("#");
        }
        DecimalFormat decimalFormat = new DecimalFormat(sb.toString());
        if (fee != null) {
            try {
                dDoubleValue = fee.doubleValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "0";
            }
        } else {
            dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        String str = decimalFormat.format(dDoubleValue);
        Intrinsics.checkNotNullExpressionValue(str, "{\n            df.format(fee ?: 0.0)\n        }");
        return str;
    }

    @Nullable
    public final String i(@Nullable Double fee, int size) {
        String str;
        double dDoubleValue;
        if (size == 0 || size == 1) {
            str = "#0.0";
        } else if (size == 2) {
            str = "#0.00";
        } else if (size == 3) {
            str = "#0.000";
        } else if (size != 4) {
            str = size != 5 ? "#0.000000" : "#0.00000";
        } else {
            str = "#0.0000";
        }
        DecimalFormat decimalFormat = new DecimalFormat(str);
        if (fee != null) {
            try {
                dDoubleValue = fee.doubleValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "0";
            }
        } else {
            dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return decimalFormat.format(dDoubleValue);
    }

    @NotNull
    public final String j(@Nullable Float fee, int size) {
        String str;
        if (size == 0) {
            str = "#0";
        } else if (size == 1) {
            str = "#0.0";
        } else if (size == 2) {
            str = "#0.00";
        } else if (size == 3) {
            str = "#0.000";
        } else if (size != 4) {
            str = size != 5 ? "#0.000000" : "#0.00000";
        } else {
            str = "#0.0000";
        }
        DecimalFormat decimalFormat = new DecimalFormat(str);
        Object objValueOf = fee;
        if (fee == null) {
            try {
                objValueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "0";
            }
        }
        String str2 = decimalFormat.format(objValueOf);
        Intrinsics.checkNotNullExpressionValue(str2, "{\n            df.format(fee ?: 0.0)\n        }");
        return str2;
    }

    public final int k(float num) {
        if (num >= 10.0f) {
            return 10;
        }
        if (num <= 0.0f) {
            return 0;
        }
        return (int) num;
    }

    public final int l(float num) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String str = decimalFormat.format(Float.valueOf(num));
        Intrinsics.checkNotNullExpressionValue(str, "format.format(num)");
        return ((int) (Float.parseFloat(str) * 10)) % 10;
    }

    public final boolean m(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(^[0-9]*$)").matcher(str).find();
    }
}
