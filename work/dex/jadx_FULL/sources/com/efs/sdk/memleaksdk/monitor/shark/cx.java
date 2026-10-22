package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.triver.triver_render.view.input.a;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/HHPC;", "", "()V", "MAX_HASH_ARRAY_LENGTH", "", "MIN_HASH_ARRAY_LENGTH", "PHI_C64", "", "expandAtCount", "arraySize", "loadFactor", "", "minBufferSize", "elements", "mixPhi", "k", "nextBufferSize", "nextHighestPowerOfTwo", a.f25238a, "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cx f29861a = new cx();

    private cx() {
    }

    public final int a(int i, double d) {
        long jCeil = (long) Math.ceil(((double) i) / d);
        if (jCeil == i) {
            jCeil++;
        }
        long jMax = Math.max(4, b(jCeil));
        if (jMax <= 1073741824) {
            return (int) jMax;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ROOT, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(new Object[]{Integer.valueOf(i), Double.valueOf(d)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        throw new RuntimeException(str);
    }

    public final int a(long j) {
        long j2 = j * (-7046029254386353131L);
        return (int) (j2 ^ (j2 >>> 32));
    }

    public final int b(int i, double d) {
        return Math.min(i - 1, (int) Math.ceil(((double) i) * d));
    }

    public final long b(long j) {
        long j2 = j - 1;
        long j3 = j2 | (j2 >> 1);
        long j4 = j3 | (j3 >> 2);
        long j5 = j4 | (j4 >> 4);
        long j6 = j5 | (j5 >> 8);
        long j7 = j6 | (j6 >> 16);
        return (j7 | (j7 >> 32)) + 1;
    }

    public final int a(int i, int i2, double d) {
        if (i != 1073741824) {
            return i << 1;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ROOT, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Double.valueOf(d)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        throw new RuntimeException(str);
    }
}
