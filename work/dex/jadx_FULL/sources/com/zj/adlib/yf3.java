package com.zj.adlib;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/zj/adlib/yf3;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class yf3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final yf3 f46022a = new yf3();

    @JvmStatic
    @NotNull
    public static final String a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageName() + ".takephoto.fileprovider";
    }
}
