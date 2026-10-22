package com.zj.adlib;

import android.content.Context;
import com.huachenjie.run.bean.CheatResult;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¨\u0006\r"}, d2 = {"Lcom/zj/adlib/oj1;", "", "", "", "Lcom/huachenjie/run/bean/CheatResult;", "b", "Landroid/content/Context;", "context", "", "a", "c", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class oj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final oj1 f43759a = new oj1();

    @JvmStatic
    @NotNull
    public static final Map<Integer, CheatResult> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        v32 v32Var = v32.f45280a;
        if (v32Var.a()) {
            linkedHashMap.put(110, new CheatResult(110, v32Var.b(), 0L, 4, null));
        }
        return linkedHashMap;
    }

    @NotNull
    public final Map<Integer, CheatResult> a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return c();
    }

    public final Map<Integer, CheatResult> c() {
        return new LinkedHashMap();
    }
}
