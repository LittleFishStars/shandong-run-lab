package com.huachenjie.step;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&¨\u0006\f"}, d2 = {"Lcom/huachenjie/step/PermissionDelegate;", "", "Landroid/content/Context;", "context", "", "requiredPermission", "hintMessage", "Lkotlin/Function1;", "", "", "acpListener", "a", "step_release"}, k = 1, mv = {1, 8, 0})
public interface PermissionDelegate {
    void a(@NotNull Context context, @NotNull String requiredPermission, @NotNull String hintMessage, @NotNull Function1<? super Boolean, Unit> acpListener);
}
