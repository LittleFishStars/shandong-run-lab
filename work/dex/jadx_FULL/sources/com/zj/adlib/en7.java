package com.zj.adlib;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hjq.permissions.Permission;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.run.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/zj/adlib/en7;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/common/util/permission/PermissionResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "e", "c", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class en7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final en7 f41475a = new en7();

    @JvmStatic
    public static final void c(@NotNull Context context, @NotNull final PermissionResultListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        vo6.k(context, CollectionsKt.mutableListOf(new String[]{"android.permission.ACCESS_FINE_LOCATION"}), CollectionsKt.mutableListOf(new String[]{context.getString(R.string.location_permission_message)}), new PermissionResultListener() { // from class: com.zj.adlib.cn7
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                en7.d(listener, z);
            }
        });
    }

    public static final void d(PermissionResultListener permissionResultListener, boolean z) {
        Intrinsics.checkNotNullParameter(permissionResultListener, "$listener");
        if (z) {
            permissionResultListener.onResult(true);
        } else {
            permissionResultListener.onResult(false);
        }
    }

    @JvmStatic
    public static final void e(@NotNull final Context context, @NotNull final PermissionResultListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        List listMutableListOf = CollectionsKt.mutableListOf(new String[]{"android.permission.ACCESS_FINE_LOCATION"});
        List listMutableListOf2 = CollectionsKt.mutableListOf(new String[]{context.getString(R.string.location_permission_message)});
        if (Build.VERSION.SDK_INT >= 29) {
            listMutableListOf.add(Permission.ACCESS_BACKGROUND_LOCATION);
            listMutableListOf2.add(context.getString(R.string.bg_location_permission_message));
        }
        vo6.k(context, listMutableListOf, listMutableListOf2, new PermissionResultListener() { // from class: com.zj.adlib.dn7
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z) {
                en7.f(context, listener, z);
            }
        });
    }

    public static final void f(Context context, PermissionResultListener permissionResultListener, boolean z) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(permissionResultListener, "$listener");
        if (!z) {
            permissionResultListener.onResult(false);
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                permissionResultListener.onResult(true);
                return;
            }
            String string = context.getString(R.string.recognition_permission_message);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ition_permission_message)");
            vo6.j(context, Permission.ACTIVITY_RECOGNITION, string, permissionResultListener);
        }
    }
}
