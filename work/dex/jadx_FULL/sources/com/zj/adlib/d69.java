package com.zj.adlib;

import android.view.View;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\t\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0000¨\u0006\n"}, d2 = {"Landroid/view/View;", "", "interval", "Ljava/util/concurrent/TimeUnit;", "unit", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "common_release"}, k = 2, mv = {1, 8, 0})
public final class d69 {
    public static final void a(@NotNull View view, long j, @NotNull TimeUnit timeUnit, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(function1, "block");
        view.setOnClickListener(new e69(j, timeUnit, function1));
    }

    public static /* synthetic */ void b(View view, long j, TimeUnit timeUnit, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        a(view, j, timeUnit, function1);
    }
}
