package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baseflow.permissionhandler.AppSettingsManager;
import com.baseflow.permissionhandler.PermissionManager;
import com.baseflow.permissionhandler.ServiceManager;
import com.baseflow.permissionhandler.j;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ho6 implements FlutterPlugin, ActivityAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PermissionManager f42171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public j f17044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ActivityPluginBinding f17045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MethodChannel f17046a;

    public final void a() {
        ActivityPluginBinding activityPluginBinding = this.f17045a;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.f42171a);
            this.f17045a.removeRequestPermissionsResultListener(this.f42171a);
        }
    }

    public final void b() {
        ActivityPluginBinding activityPluginBinding = this.f17045a;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.f42171a);
            this.f17045a.addRequestPermissionsResultListener(this.f42171a);
        }
    }

    public final void c(Context context, BinaryMessenger binaryMessenger) {
        this.f17046a = new MethodChannel(binaryMessenger, "flutter.baseflow.com/permissions/methods");
        j jVar = new j(context, new AppSettingsManager(), this.f42171a, new ServiceManager());
        this.f17044a = jVar;
        this.f17046a.setMethodCallHandler(jVar);
    }

    public final void d(Activity activity) {
        PermissionManager permissionManager = this.f42171a;
        if (permissionManager != null) {
            permissionManager.g(activity);
        }
    }

    public final void e() {
        this.f17046a.setMethodCallHandler(null);
        this.f17046a = null;
        this.f17044a = null;
    }

    public final void f() {
        PermissionManager permissionManager = this.f42171a;
        if (permissionManager != null) {
            permissionManager.g(null);
        }
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        d(activityPluginBinding.getActivity());
        this.f17045a = activityPluginBinding;
        b();
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f42171a = new PermissionManager(flutterPluginBinding.getApplicationContext());
        c(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromActivity() {
        f();
        a();
        this.f17045a = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        e();
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
