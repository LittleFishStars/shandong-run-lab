package com.zj.adlib;

import android.app.Activity;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.pose_estimation.CameraPermissions;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.TextureRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J0\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001f¨\u0006#"}, d2 = {"Lcom/zj/adlib/ev6;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "", "onAttachedToEngine", "onDetachedFromEngine", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToActivity", "onDetachedFromActivityForConfigChanges", "onReattachedToActivityForConfigChanges", "onDetachedFromActivity", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterAssets;", "flutterAssets", "Lcom/huachenjie/pose_estimation/CameraPermissions$PermissionsRegistry;", "permissionsRegistry", "Lio/flutter/view/TextureRegistry;", "textureRegistry", "a", "", "f", "Ljava/lang/String;", "TAG", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "flutterPluginBinding", "Lcom/zj/adlib/lo5;", "Lcom/zj/adlib/lo5;", "methodCallHandler", "<init>", "()V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class ev6 implements FlutterPlugin, ActivityAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public lo5 methodCallHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public FlutterPlugin.FlutterPluginBinding flutterPluginBinding;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final String TAG = "PoseEstimationPlugin";

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/zj/adlib/ev6$a", "Lcom/huachenjie/pose_estimation/CameraPermissions$PermissionsRegistry;", "Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;", "handler", "", "a", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements CameraPermissions.PermissionsRegistry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityPluginBinding f41533a;

        public a(ActivityPluginBinding activityPluginBinding) {
            this.f41533a = activityPluginBinding;
        }

        @Override // com.huachenjie.pose_estimation.CameraPermissions.PermissionsRegistry
        public void a(@Nullable PluginRegistry.RequestPermissionsResultListener handler) {
            ActivityPluginBinding activityPluginBinding = this.f41533a;
            Intrinsics.checkNotNull(handler);
            activityPluginBinding.addRequestPermissionsResultListener(handler);
        }
    }

    public final void a(Activity activity, BinaryMessenger messenger, FlutterPlugin.FlutterAssets flutterAssets, CameraPermissions.PermissionsRegistry permissionsRegistry, TextureRegistry textureRegistry) {
        this.methodCallHandler = new lo5(activity, messenger, new CameraPermissions(), permissionsRegistry, flutterAssets, textureRegistry);
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Log.d(this.TAG, "onAttachedToActivity");
        Activity activity = binding.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "binding.activity");
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.flutterPluginBinding;
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = null;
        if (flutterPluginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
            flutterPluginBinding = null;
        }
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "flutterPluginBinding.binaryMessenger");
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding3 = this.flutterPluginBinding;
        if (flutterPluginBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
            flutterPluginBinding3 = null;
        }
        FlutterPlugin.FlutterAssets flutterAssets = flutterPluginBinding3.getFlutterAssets();
        Intrinsics.checkNotNullExpressionValue(flutterAssets, "flutterPluginBinding.flutterAssets");
        a aVar = new a(binding);
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding4 = this.flutterPluginBinding;
        if (flutterPluginBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flutterPluginBinding");
        } else {
            flutterPluginBinding2 = flutterPluginBinding4;
        }
        TextureRegistry textureRegistry = flutterPluginBinding2.getTextureRegistry();
        Intrinsics.checkNotNullExpressionValue(textureRegistry, "flutterPluginBinding.textureRegistry");
        a(activity, binaryMessenger, flutterAssets, aVar, textureRegistry);
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Log.d(this.TAG, "onAttachedToEngine");
        this.flutterPluginBinding = binding;
    }

    public void onDetachedFromActivity() {
        Log.d(this.TAG, "onDetachedFromActivity");
        lo5 lo5Var = this.methodCallHandler;
        if (lo5Var == null) {
            return;
        }
        Intrinsics.checkNotNull(lo5Var);
        lo5Var.e();
        this.methodCallHandler = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Log.d(this.TAG, "onDetachedFromEngine");
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        onAttachedToActivity(binding);
    }
}
