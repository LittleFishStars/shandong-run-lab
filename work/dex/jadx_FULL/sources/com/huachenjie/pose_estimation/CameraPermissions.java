package com.huachenjie.pose_estimation;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.hv.TTDownloadField;
import com.hjq.permissions.Permission;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0004\u000e\r\u0013\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/pose_estimation/CameraPermissions;", "", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/pose_estimation/CameraPermissions$PermissionsRegistry;", "permissionsRegistry", "", "enableAudio", "Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;", RenderCallContext.TYPE_CALLBACK, "", "requestPermissions", "c", "b", "a", "Z", "ongoing", "<init>", "()V", "PermissionsRegistry", "ResultCallback", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class CameraPermissions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35418a = 9796;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final b f11389a = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean ongoing;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/pose_estimation/CameraPermissions$PermissionsRegistry;", "", "Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;", "handler", "", "a", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public interface PermissionsRegistry {
        void a(@Nullable PluginRegistry.RequestPermissionsResultListener handler);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;", "", "", "errorCode", "errorDescription", "", "a", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public interface ResultCallback {
        void a(@Nullable String errorCode, @Nullable String errorDescription);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/pose_estimation/CameraPermissions$a;", "Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;", "", "id", "", "", RequestPermission.PERMISSIONS, "", RequestPermission.GRANT_RESULTS, "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)Z", "Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;", "a", "Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;", "()Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;", RenderCallContext.TYPE_CALLBACK, "<init>", "(Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements PluginRegistry.RequestPermissionsResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final ResultCallback callback;

        public a(@NotNull ResultCallback resultCallback) {
            Intrinsics.checkNotNullParameter(resultCallback, RenderCallContext.TYPE_CALLBACK);
            this.callback = resultCallback;
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: from getter */
        public final ResultCallback getCallback() {
            return this.callback;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
        public boolean onRequestPermissionsResult(int id, @NotNull String[] permissions, @NotNull int[] grantResults) {
            Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
            Intrinsics.checkNotNullParameter(grantResults, RequestPermission.GRANT_RESULTS);
            boolean z = false;
            if (id == 9796) {
                z = true;
                if (grantResults[0] != 0) {
                    this.callback.a("cameraPermission", "MediaRecorderCamera permission not granted");
                } else if (grantResults.length <= 1 || grantResults[1] == 0) {
                    this.callback.a(null, null);
                } else {
                    this.callback.a("cameraPermission", "MediaRecorderAudio permission not granted");
                }
            }
            return z;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/pose_estimation/CameraPermissions$b;", "", "", "CAMERA_REQUEST_ID", "I", "<init>", "()V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/pose_estimation/CameraPermissions$c", "Lcom/huachenjie/pose_estimation/CameraPermissions$ResultCallback;", "", "errorCode", "errorDescription", "", "a", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class c implements ResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResultCallback f35420a;

        public c(ResultCallback resultCallback) {
            this.f35420a = resultCallback;
        }

        @Override // com.huachenjie.pose_estimation.CameraPermissions.ResultCallback
        public void a(@Nullable String errorCode, @Nullable String errorDescription) {
            CameraPermissions.this.ongoing = false;
            this.f35420a.a(errorCode, errorDescription);
        }
    }

    public final boolean b(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, Permission.RECORD_AUDIO) == 0;
    }

    public final boolean c(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, Permission.CAMERA) == 0;
    }

    public final void requestPermissions(@NotNull Activity activity, @NotNull PermissionsRegistry permissionsRegistry, boolean enableAudio, @NotNull ResultCallback callback) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(permissionsRegistry, "permissionsRegistry");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        if (this.ongoing) {
            callback.a("cameraPermission", "Camera permission request ongoing");
        }
        if (c(activity) && (!enableAudio || b(activity))) {
            callback.a(null, null);
            return;
        }
        permissionsRegistry.a(new a(new c(callback)));
        this.ongoing = true;
        ActivityCompat.requestPermissions(activity, enableAudio ? new String[]{Permission.CAMERA, Permission.RECORD_AUDIO} : new String[]{Permission.CAMERA}, f35418a);
    }
}
