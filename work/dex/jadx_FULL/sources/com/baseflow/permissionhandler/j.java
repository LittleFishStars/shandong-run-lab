package com.baseflow.permissionhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class j implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f26851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AppSettingsManager f1228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PermissionManager f1229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ServiceManager f1230a;

    public j(Context context, AppSettingsManager appSettingsManager, PermissionManager permissionManager, ServiceManager serviceManager) {
        this.f26851a = context;
        this.f1228a = appSettingsManager;
        this.f1229a = permissionManager;
        this.f1230a = serviceManager;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull final MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        switch (str) {
            case "checkServiceStatus":
                int i = Integer.parseInt(methodCall.arguments.toString());
                ServiceManager serviceManager = this.f1230a;
                Context context = this.f26851a;
                Objects.requireNonNull(result);
                serviceManager.a(i, context, new ServiceManager.SuccessCallback() { // from class: com.baseflow.permissionhandler.a
                    @Override // com.baseflow.permissionhandler.ServiceManager.SuccessCallback
                    public final void onSuccess(int i2) {
                        result.success(Integer.valueOf(i2));
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.b
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            case "shouldShowRequestPermissionRationale":
                int i2 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager = this.f1229a;
                Objects.requireNonNull(result);
                permissionManager.h(i2, new PermissionManager.ShouldShowRequestPermissionRationaleSuccessCallback() { // from class: com.baseflow.permissionhandler.f
                    @Override // com.baseflow.permissionhandler.PermissionManager.ShouldShowRequestPermissionRationaleSuccessCallback
                    public final void onSuccess(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.g
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            case "checkPermissionStatus":
                int i3 = Integer.parseInt(methodCall.arguments.toString());
                PermissionManager permissionManager2 = this.f1229a;
                Objects.requireNonNull(result);
                permissionManager2.c(i3, new PermissionManager.CheckPermissionsSuccessCallback() { // from class: com.baseflow.permissionhandler.c
                    @Override // com.baseflow.permissionhandler.PermissionManager.CheckPermissionsSuccessCallback
                    public final void onSuccess(int i4) {
                        result.success(Integer.valueOf(i4));
                    }
                });
                break;
            case "openAppSettings":
                AppSettingsManager appSettingsManager = this.f1228a;
                Context context2 = this.f26851a;
                Objects.requireNonNull(result);
                appSettingsManager.a(context2, new AppSettingsManager.OpenAppSettingsSuccessCallback() { // from class: com.baseflow.permissionhandler.h
                    @Override // com.baseflow.permissionhandler.AppSettingsManager.OpenAppSettingsSuccessCallback
                    public final void onSuccess(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.i
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            case "requestPermissions":
                List<Integer> list = (List) methodCall.arguments();
                PermissionManager permissionManager3 = this.f1229a;
                Objects.requireNonNull(result);
                permissionManager3.requestPermissions(list, new PermissionManager.RequestPermissionsSuccessCallback() { // from class: com.baseflow.permissionhandler.d
                    @Override // com.baseflow.permissionhandler.PermissionManager.RequestPermissionsSuccessCallback
                    public final void onSuccess(Map map) {
                        result.success(map);
                    }
                }, new ErrorCallback() { // from class: com.baseflow.permissionhandler.e
                    @Override // com.baseflow.permissionhandler.ErrorCallback
                    public final void onError(String str2, String str3) {
                        result.error(str2, str3, null);
                    }
                });
                break;
            default:
                result.notImplemented();
                break;
        }
    }
}
