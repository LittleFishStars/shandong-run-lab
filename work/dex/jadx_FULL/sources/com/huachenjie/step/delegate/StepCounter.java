package com.huachenjie.step.delegate;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\r"}, d2 = {"Lcom/huachenjie/step/delegate/StepCounter;", "", "", "isSupport", "Landroid/content/Context;", "context", "b", "Lkotlin/Function1;", "", "acpListener", "a", "", "c", "step_release"}, k = 1, mv = {1, 8, 0})
public interface StepCounter {
    void a(@NotNull Context context, @NotNull Function1<? super Boolean, Unit> acpListener);

    boolean b(@NotNull Context context);

    int c(@NotNull Context context);

    boolean isSupport();
}
