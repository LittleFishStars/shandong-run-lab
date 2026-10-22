package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.pose_estimation.CameraManager;
import com.huachenjie.pose_estimation.CameraPermissions;
import com.huachenjie.pose_estimation.DartMessenger;
import com.huachenjie.pose_estimation.data.Device;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e¢\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u00062\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010(¨\u0006,"}, d2 = {"Lcom/zj/adlib/lo5;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/plugin/common/MethodCall;", "call", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "", "onMethodCall", "e", "d", "Ljava/lang/Exception;", "Lkotlin/Exception;", c.f25231a, "c", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lio/flutter/plugin/common/BinaryMessenger;", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "Lcom/huachenjie/pose_estimation/CameraPermissions;", "Lcom/huachenjie/pose_estimation/CameraPermissions;", "cameraPermissions", "Lcom/huachenjie/pose_estimation/CameraPermissions$PermissionsRegistry;", "Lcom/huachenjie/pose_estimation/CameraPermissions$PermissionsRegistry;", "permissionsRegistry", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterAssets;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterAssets;", "flutterAssets", "Lio/flutter/view/TextureRegistry;", "Lio/flutter/view/TextureRegistry;", "textureRegistry", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/MethodChannel;", "methodChannel", "Lio/flutter/plugin/common/EventChannel;", "Lio/flutter/plugin/common/EventChannel;", "poseStreamChannel", "Lcom/huachenjie/pose_estimation/CameraManager;", "Lcom/huachenjie/pose_estimation/CameraManager;", "cameraManager", "<init>", "(Landroid/app/Activity;Lio/flutter/plugin/common/BinaryMessenger;Lcom/huachenjie/pose_estimation/CameraPermissions;Lcom/huachenjie/pose_estimation/CameraPermissions$PermissionsRegistry;Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterAssets;Lio/flutter/view/TextureRegistry;)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class lo5 implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Activity activity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CameraManager cameraManager;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final CameraPermissions.PermissionsRegistry permissionsRegistry;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final CameraPermissions cameraPermissions;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final FlutterPlugin.FlutterAssets flutterAssets;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final BinaryMessenger messenger;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final EventChannel poseStreamChannel;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MethodChannel methodChannel;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final TextureRegistry textureRegistry;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/zj/adlib/lo5$a", "Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;", "", "errorCode", "errorDescription", "", "a", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements CameraPermissions.ResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MethodCall f18015a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MethodChannel.Result f18016a;

        public a(MethodCall methodCall, MethodChannel.Result result) {
            this.f18015a = methodCall;
            this.f18016a = result;
        }

        @Override // com.huachenjie.pose_estimation.CameraPermissions.ResultCallback
        public void a(@Nullable String errorCode, @Nullable String errorDescription) {
            if (errorCode != null) {
                this.f18016a.error(errorCode, errorDescription, null);
                return;
            }
            try {
                lo5.this.d(this.f18015a, this.f18016a);
            } catch (Exception e) {
                lo5.this.c(e, this.f18016a);
            }
        }
    }

    public lo5(@NotNull Activity activity, @NotNull BinaryMessenger binaryMessenger, @NotNull CameraPermissions cameraPermissions, @NotNull CameraPermissions.PermissionsRegistry permissionsRegistry, @NotNull FlutterPlugin.FlutterAssets flutterAssets, @NotNull TextureRegistry textureRegistry) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(binaryMessenger, "messenger");
        Intrinsics.checkNotNullParameter(cameraPermissions, "cameraPermissions");
        Intrinsics.checkNotNullParameter(permissionsRegistry, "permissionsRegistry");
        Intrinsics.checkNotNullParameter(flutterAssets, "flutterAssets");
        Intrinsics.checkNotNullParameter(textureRegistry, "textureRegistry");
        this.activity = activity;
        this.messenger = binaryMessenger;
        this.cameraPermissions = cameraPermissions;
        this.permissionsRegistry = permissionsRegistry;
        this.flutterAssets = flutterAssets;
        this.textureRegistry = textureRegistry;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "pose_estimation");
        this.methodChannel = methodChannel;
        this.poseStreamChannel = new EventChannel(binaryMessenger, "pose_estimation/poseStream");
        methodChannel.setMethodCallHandler(this);
    }

    public final void c(Exception exception, MethodChannel.Result result) {
        if (exception instanceof CameraAccessException) {
            result.error("CameraAccess", exception.getMessage(), null);
        } else if (exception instanceof IllegalArgumentException) {
            result.error("IllegalArgument", exception.getMessage(), null);
        }
        Intrinsics.checkNotNull(exception, "null cannot be cast to non-null type java.lang.RuntimeException{ kotlin.TypeAliasesKt.RuntimeException }");
        throw ((RuntimeException) exception);
    }

    public final void d(MethodCall call, MethodChannel.Result result) throws CameraAccessException {
        Device device;
        String str = (String) call.argument("modelFilename");
        if (str == null) {
            throw new IllegalArgumentException("params \"modelFilename\" not found");
        }
        String assetFilePathByName = this.flutterAssets.getAssetFilePathByName(str);
        String str2 = (String) call.argument("cameraPosition");
        if (str2 == null) {
            throw new IllegalArgumentException("params \"cameraPosition\" not found");
        }
        boolean zAreEqual = Intrinsics.areEqual(str2, "back");
        Integer num = (Integer) call.argument("interpreterDevice");
        if (num == null) {
            num = 0;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            device = Device.CPU;
        } else if (iIntValue != 1) {
            device = iIntValue != 2 ? Device.CPU : Device.NNAPI;
        } else {
            device = Device.GPU;
        }
        wr5.a aVar = wr5.f20501a;
        Context applicationContext = this.activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
        Intrinsics.checkNotNullExpressionValue(assetFilePathByName, "modelFileKey");
        wr5 wr5VarA = aVar.a(applicationContext, device, assetFilePathByName);
        TextureRegistry.SurfaceTextureEntry surfaceTextureEntryCreateSurfaceTexture = this.textureRegistry.createSurfaceTexture();
        Intrinsics.checkNotNullExpressionValue(surfaceTextureEntryCreateSurfaceTexture, "textureRegistry.createSurfaceTexture()");
        CameraManager cameraManager = new CameraManager(this.activity, zAreEqual ? 1 : 0, surfaceTextureEntryCreateSurfaceTexture, new DartMessenger(this.messenger, surfaceTextureEntryCreateSurfaceTexture.id()));
        this.cameraManager = cameraManager;
        cameraManager.p(wr5VarA);
        CameraManager cameraManager2 = this.cameraManager;
        if (cameraManager2 != null) {
            cameraManager2.k(result);
        }
    }

    public final void e() {
        this.methodChannel.setMethodCallHandler(null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NotNull MethodCall call, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -780145655:
                    if (str.equals("startRecognizing")) {
                        try {
                            CameraManager cameraManager = this.cameraManager;
                            if (cameraManager != null) {
                                cameraManager.r(this.poseStreamChannel);
                            }
                            result.success(null);
                            return;
                        } catch (Exception e) {
                            c(e, result);
                            return;
                        }
                    }
                    break;
                case -62643095:
                    if (str.equals("stopRecognizing")) {
                        try {
                            CameraManager cameraManager2 = this.cameraManager;
                            if (cameraManager2 != null) {
                                cameraManager2.s();
                            }
                            result.success(null);
                            return;
                        } catch (Exception e2) {
                            c(e2, result);
                            return;
                        }
                    }
                    break;
                case 402763162:
                    if (str.equals("takeRecognizingPicture")) {
                        CameraManager cameraManager3 = this.cameraManager;
                        if (cameraManager3 != null) {
                            cameraManager3.t();
                        }
                        result.success(null);
                        return;
                    }
                    break;
                case 871091088:
                    if (str.equals("initialize")) {
                        CameraManager cameraManager4 = this.cameraManager;
                        if (cameraManager4 != null) {
                            cameraManager4.i();
                        }
                        this.cameraPermissions.requestPermissions(this.activity, this.permissionsRegistry, false, new a(call, result));
                        return;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        CameraManager cameraManager5 = this.cameraManager;
                        if (cameraManager5 != null) {
                            cameraManager5.j();
                        }
                        result.success(null);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
