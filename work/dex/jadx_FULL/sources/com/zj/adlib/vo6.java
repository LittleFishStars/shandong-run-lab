package com.zj.adlib;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.triver.basic.api.RequestPermission;
import com.google.android.exoplayer2.source.rtsp.j;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.huachenjie.common.util.permission.PermissionDeniedDialogListener;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huawei.hms.push.AttributionReporter;
import com.igexin.assist.util.AssistUtils;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b)\u0010*J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J4\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001aH\u0007J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0002H\u0002R$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/zj/adlib/vo6;", "", "Landroid/content/Context;", "context", "", "requiredPermission", "hintMessage", "Lcom/huachenjie/common/util/permission/PermissionResultListener;", "acpListener", "", "j", "", "requiredPermissions", "hintMessages", "k", "Landroidx/fragment/app/Fragment;", "fragment", t.d, AttributionReporter.SYSTEM_PERMISSION, "", "c", "a", "f", y6b.f, "d", "Landroid/app/Activity;", "", RequestPermission.REQUEST_CODE, "i", "n", "m", y6b.g, "ctx", "e", "Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;", "Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;", "b", "()Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;", j.b, "(Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;)V", "deniedDialogListener", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class vo6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public static PermissionDeniedDialogListener deniedDialogListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final vo6 f20262a = new vo6();

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001e\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/vo6$a", "Lcom/hjq/permissions/OnPermissionCallback;", "", "", RequestPermission.PERMISSIONS, "", "allGranted", "", "onGranted", "doNotAskAgain", "onDenied", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements OnPermissionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionResultListener f45402a;

        public a(PermissionResultListener permissionResultListener) {
            this.f45402a = permissionResultListener;
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onDenied(@NotNull List<String> permissions, boolean doNotAskAgain) {
            Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
            this.f45402a.onResult(false);
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onGranted(@NotNull List<String> permissions, boolean allGranted) {
            Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
            if (allGranted) {
                this.f45402a.onResult(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001e\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/vo6$b", "Lcom/hjq/permissions/OnPermissionCallback;", "", "", RequestPermission.PERMISSIONS, "", "allGranted", "", "onGranted", "doNotAskAgain", "onDenied", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnPermissionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionResultListener f45403a;

        public b(PermissionResultListener permissionResultListener) {
            this.f45403a = permissionResultListener;
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onDenied(@NotNull List<String> permissions, boolean doNotAskAgain) {
            Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
            this.f45403a.onResult(false);
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onGranted(@NotNull List<String> permissions, boolean allGranted) {
            Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
            if (allGranted) {
                this.f45403a.onResult(true);
            }
        }
    }

    @JvmStatic
    public static final boolean a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT <= 28) {
            return f20262a.e(context);
        }
        try {
            Object systemService = context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
            LocationManager locationManager = (LocationManager) systemService;
            return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
        } catch (Exception e) {
            i4a.c(e.getMessage());
        }
    }

    @JvmStatic
    public static final boolean c(@NotNull Context context, @NotNull String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, AttributionReporter.SYSTEM_PERMISSION);
        return XXPermissions.isGranted(context, permission);
    }

    @JvmStatic
    @RequiresApi(api = 23)
    public static final boolean d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @JvmStatic
    public static final void f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setAction("android.settings.SETTINGS");
            try {
                context.startActivity(intent);
            } catch (Exception unused2) {
            }
        }
    }

    @JvmStatic
    public static final void g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            intent.putExtra("android.provider.extra.CHANNEL_ID", i);
            intent.putExtra("app_package", packageName);
            intent.putExtra("app_uid", i);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    @JvmStatic
    public static final void h(@NotNull Context context, @NotNull String hintMessage, @NotNull PermissionResultListener acpListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hintMessage, "hintMessage");
        Intrinsics.checkNotNullParameter(acpListener, "acpListener");
        j(context, Permission.CAMERA, hintMessage, acpListener);
    }

    @JvmStatic
    @RequiresApi(api = 23)
    public static final void i(@NotNull Activity context, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JvmStatic
    public static final void j(@NotNull Context context, @NotNull String requiredPermission, @NotNull String hintMessage, @NotNull PermissionResultListener acpListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requiredPermission, "requiredPermission");
        Intrinsics.checkNotNullParameter(hintMessage, "hintMessage");
        Intrinsics.checkNotNullParameter(acpListener, "acpListener");
        k(context, CollectionsKt.listOf(requiredPermission), CollectionsKt.listOf(hintMessage), acpListener);
    }

    @JvmStatic
    public static final void k(@NotNull Context context, @NotNull List<String> requiredPermissions, @NotNull List<String> hintMessages, @NotNull PermissionResultListener acpListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requiredPermissions, "requiredPermissions");
        Intrinsics.checkNotNullParameter(hintMessages, "hintMessages");
        Intrinsics.checkNotNullParameter(acpListener, "acpListener");
        XXPermissions xXPermissionsPermission = XXPermissions.with(context).permission(requiredPermissions);
        po6 po6Var = new po6(hintMessages);
        po6Var.p(deniedDialogListener);
        xXPermissionsPermission.interceptor(po6Var).request(new a(acpListener));
    }

    @JvmStatic
    public static final void l(@NotNull Fragment fragment, @NotNull String requiredPermission, @NotNull String hintMessage, @NotNull PermissionResultListener acpListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(requiredPermission, "requiredPermission");
        Intrinsics.checkNotNullParameter(hintMessage, "hintMessage");
        Intrinsics.checkNotNullParameter(acpListener, "acpListener");
        XXPermissions xXPermissionsPermission = XXPermissions.with(fragment).permission(requiredPermission);
        po6 po6Var = new po6(CollectionsKt.listOf(hintMessage));
        po6Var.p(deniedDialogListener);
        po6Var.q(fragment);
        xXPermissionsPermission.interceptor(po6Var).request(new b(acpListener));
    }

    @JvmStatic
    public static final void m(@NotNull Context context) {
        ComponentName componentNameUnflattenFromString;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        try {
            intent.addFlags(268435456);
            String str = Build.MANUFACTURER;
            if (StringsKt.equals("xiaomi", str, true)) {
                componentNameUnflattenFromString = ComponentName.unflattenFromString("com.miui.powerkeeper/.ui.HiddenAppsContainerManagementActivity");
            } else if (StringsKt.equals(AssistUtils.BRAND_HW, str, true)) {
                componentNameUnflattenFromString = ComponentName.unflattenFromString("com.android.settings/.Settings$HighPowerApplicationsActivity");
            } else if (StringsKt.equals("vivo", str, true)) {
                componentNameUnflattenFromString = ComponentName.unflattenFromString("com.iqoo.powersaving/.PowerSavingManagerActivity");
            } else if (StringsKt.equals("oppo", str, true)) {
                componentNameUnflattenFromString = ComponentName.unflattenFromString("com.coloros.safecenter/.appfrozen.activities_run.AppFrozenSettingsActivity");
            } else {
                componentNameUnflattenFromString = StringsKt.equals("oneplus", str, true) ? ComponentName.unflattenFromString("com.android.settings/.Settings$BgOptimizeAppListActivity") : null;
            }
            intent.setComponent(componentNameUnflattenFromString);
            context.startActivity(intent);
        } catch (Exception unused) {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    @JvmStatic
    public static final void n(@NotNull Context context) {
        ComponentName componentName;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        try {
            intent.addFlags(268435456);
            String str = Build.MANUFACTURER;
            if (StringsKt.equals("xiaomi", str, true)) {
                componentName = ComponentName.unflattenFromString("com.miui.securitycenter/com.miui.permcenter.autostart.AutoStartManagementActivity");
            } else if (StringsKt.equals(AssistUtils.BRAND_HW, str, true)) {
                componentName = ComponentName.unflattenFromString("com.huawei.systemmanager/.mainscreen.MainScreenActivity");
            } else if (StringsKt.equals("vivo", str, true)) {
                componentName = ComponentName.unflattenFromString("com.vivo.permissionmanager/.activities_run.BgStartUpManagerActivity");
            } else if (StringsKt.equals("oppo", str, true)) {
                componentName = ComponentName.unflattenFromString("com.coloros.safecenter/com.coloros.privacypermissionsentry.PermissionTopActivity");
            } else if (StringsKt.equals(AssistUtils.BRAND_MZ, str, true)) {
                componentName = ComponentName.unflattenFromString("com.meizu.safe/.permission.SmartBGActivity");
            } else {
                componentName = StringsKt.equals("samsung", str, true) ? new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.ram.AutoRunActivity") : null;
            }
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    @Nullable
    public final PermissionDeniedDialogListener b() {
        return deniedDialogListener;
    }

    public final boolean e(Context ctx) {
        try {
            return Settings.Secure.getInt(ctx.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            i4a.c(e.getMessage());
            return false;
        }
    }

    public final void o(@Nullable PermissionDeniedDialogListener permissionDeniedDialogListener) {
        deniedDialogListener = permissionDeniedDialogListener;
    }
}
