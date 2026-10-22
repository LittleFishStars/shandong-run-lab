package com.zj.adlib;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/zj/adlib/f58;", "", "", "a13", "b13", "", "b", "array", "a", "c", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class f58 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f58 f41602a = new f58();

    public final float a(@NotNull float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        float f = 0.0f;
        for (float f2 : array) {
            f += f2 * f2;
        }
        return (float) Math.sqrt(f);
    }

    public final float b(@NotNull float[] a13, @NotNull float[] b13) {
        Intrinsics.checkNotNullParameter(a13, "a13");
        Intrinsics.checkNotNullParameter(b13, "b13");
        return (a13[0] * b13[0]) + (a13[1] * b13[1]) + (a13[2] * b13[2]);
    }

    public final float c(@NotNull float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        float f = 0.0f;
        for (float f2 : array) {
            f += f2;
        }
        return f;
    }
}
