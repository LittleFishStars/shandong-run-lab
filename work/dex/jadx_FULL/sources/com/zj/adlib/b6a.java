package com.zj.adlib;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.hjq.permissions.Permission;
import com.huachenjie.step.PermissionDelegate;
import com.huachenjie.step.delegate.StepCounter;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¨\u0006\u0016"}, d2 = {"Lcom/zj/adlib/b6a;", "Lcom/huachenjie/step/delegate/StepCounter;", "", "isSupport", "Landroid/content/Context;", "context", "b", "Lkotlin/Function1;", "", "acpListener", "a", "", "c", "", "name", "defaultValue", "d", "Lkotlin/Pair;", "", "e", "<init>", "()V", "step_release"}, k = 1, mv = {1, 8, 0})
public final class b6a implements StepCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b6a f40689a = new b6a();

    @Override // com.huachenjie.step.delegate.StepCounter
    public void a(@NotNull Context context, @NotNull Function1<? super Boolean, Unit> acpListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(acpListener, "acpListener");
        if (Build.VERSION.SDK_INT < 29) {
            acpListener.invoke(Boolean.TRUE);
            return;
        }
        PermissionDelegate permissionDelegateA = jr8.f17466a.a();
        if (permissionDelegateA != null) {
            permissionDelegateA.a(context, Permission.ACTIVITY_RECOGNITION, "请授予身体活动权限权限，以获取步数信息", acpListener);
        }
    }

    @Override // com.huachenjie.step.delegate.StepCounter
    public boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT < 29 || ContextCompat.checkSelfPermission(context, Permission.ACTIVITY_RECOGNITION) == 0;
    }

    @Override // com.huachenjie.step.delegate.StepCounter
    public int c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Pair<Long, Long> pairE = e();
        long jLongValue = ((Number) pairE.component1()).longValue();
        long jLongValue2 = ((Number) pairE.component2()).longValue();
        String strValueOf = String.valueOf(jLongValue);
        int i = 0;
        String[] strArr = {strValueOf, String.valueOf(jLongValue2), "0"};
        ContentResolver contentResolver = context.getContentResolver();
        gr8 gr8Var = gr8.f16854a;
        Cursor cursorQuery = contentResolver.query(gr8Var.a(), gr8Var.b(), "_begin_time >= ? AND _end_time < ? AND _mode != ?", strArr, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                cursor2.moveToFirst();
                i = cursor2.getInt(0);
                CloseableKt.closeFinally(cursor, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        return i;
    }

    public final boolean d(String name, boolean defaultValue) {
        try {
            Object objInvoke = Class.forName("miui.util.FeatureParser").getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, name, Boolean.valueOf(defaultValue));
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public final Pair<Long, Long> e() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(6, 1);
        return TuplesKt.to(Long.valueOf(timeInMillis), Long.valueOf(calendar.getTimeInMillis()));
    }

    @Override // com.huachenjie.step.delegate.StepCounter
    public boolean isSupport() {
        return d("support_steps_provider", false);
    }
}
