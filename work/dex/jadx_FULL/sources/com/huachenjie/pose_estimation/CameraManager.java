package com.huachenjie.pose_estimation;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CaptureRequest;
import android.util.Base64;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.interop.Camera2Interop;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.ResolutionInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.p002lifecycle.LifecycleOwner;
import com.alibaba.triver.embed.video.video.h;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.byazt.hv.TTDownloadField;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.common.util.concurrent.ListenableFuture;
import com.huachenjie.pose_estimation.CameraManager;
import com.huachenjie.pose_estimation.ml.PoseDetector;
import com.zj.adlib.KeyPoint;
import com.zj.adlib.PoseEstimationResult;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020%¢\u0006\u0004\bG\u0010HJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010!\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00101R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010<R\u0016\u0010?\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010\u001eR\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010AR\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010AR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010E¨\u0006I"}, d2 = {"Lcom/huachenjie/pose_estimation/CameraManager;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "", "t", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "k", "Lio/flutter/plugin/common/EventChannel;", "poseStreamChannel", "r", "s", "Landroidx/camera/core/ImageProxy;", "image", "analyze", "Lcom/huachenjie/pose_estimation/ml/PoseDetector;", "detector", "p", "i", "j", "q", "Lcom/zj/adlib/fv6;", j.b, "", "a", "Ljava/lang/String;", "TAG", "Landroid/app/Activity;", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "I", "cameraFacing", "b", "cameraSensorRotation", "Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;", "Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;", "flutterTexture", "Lcom/huachenjie/pose_estimation/DartMessenger;", "Lcom/huachenjie/pose_estimation/DartMessenger;", "dartMessenger", "Lio/flutter/plugin/common/EventChannel$EventSink;", "Lio/flutter/plugin/common/EventChannel$EventSink;", "poseResultEventSink", "Landroidx/camera/core/ImageAnalysis;", "Landroidx/camera/core/ImageAnalysis;", "imageAnalysis", "Landroid/util/Size;", "Landroid/util/Size;", "previewSize", "Lcom/huachenjie/pose_estimation/ml/PoseDetector;", "", "Ljava/lang/Object;", "lock", "Landroidx/camera/core/Camera;", "Landroidx/camera/core/Camera;", h.d, "", "F", AliyunLogKey.KEY_FPS, "", "J", "lastFpsTimestamp", "c", "frameCounter", "", "Z", "pauseAnalysis", "needTakePicture", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "imageProcessExecutor", "<init>", "(Landroid/app/Activity;ILio/flutter/view/TextureRegistry$SurfaceTextureEntry;Lcom/huachenjie/pose_estimation/DartMessenger;)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class CameraManager implements ImageAnalysis.Analyzer {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float fps;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final int cameraFacing;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long lastFpsTimestamp;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Activity activity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public Size previewSize;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Camera camera;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public ImageAnalysis imageAnalysis;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final DartMessenger dartMessenger;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public PoseDetector detector;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public EventChannel.EventSink poseResultEventSink;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final TextureRegistry.SurfaceTextureEntry flutterTexture;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Object lock;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final String TAG;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ThreadPoolExecutor imageProcessExecutor;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean pauseAnalysis;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int cameraSensorRotation;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean needTakePicture;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int frameCounter;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/pose_estimation/CameraManager$a", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "", j.b, "Lio/flutter/plugin/common/EventChannel$EventSink;", "eventSink", "", "onListen", "onCancel", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements EventChannel.StreamHandler {
        public a() {
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onCancel(@Nullable Object o) {
            CameraManager.this.s();
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onListen(@Nullable Object o, @NotNull EventChannel.EventSink eventSink) {
            Intrinsics.checkNotNullParameter(eventSink, "eventSink");
            CameraManager.this.pauseAnalysis = false;
            CameraManager.this.poseResultEventSink = eventSink;
            CameraManager.this.q();
        }
    }

    public CameraManager(@NotNull Activity activity, int i, @NotNull TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, @NotNull DartMessenger dartMessenger) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(surfaceTextureEntry, "flutterTexture");
        Intrinsics.checkNotNullParameter(dartMessenger, "dartMessenger");
        this.TAG = "PoseEstimationCamera";
        this.activity = activity;
        this.cameraFacing = i;
        this.flutterTexture = surfaceTextureEntry;
        this.dartMessenger = dartMessenger;
        this.lock = new Object();
        this.imageProcessExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static final void h(CameraManager cameraManager, Map map) {
        Intrinsics.checkNotNullParameter(cameraManager, "this$0");
        Intrinsics.checkNotNullParameter(map, "$result");
        EventChannel.EventSink eventSink = cameraManager.poseResultEventSink;
        if (eventSink != null) {
            eventSink.success(map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(ListenableFuture listenableFuture, final CameraManager cameraManager, MethodChannel.Result result, final Executor executor) {
        Map<String, Object> mapEmptyMap;
        Intrinsics.checkNotNullParameter(listenableFuture, "$cameraProviderFuture");
        Intrinsics.checkNotNullParameter(cameraManager, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) listenableFuture.get();
        Preview.SurfaceProvider surfaceProvider = new Preview.SurfaceProvider() { // from class: com.zj.adlib.fc1
            @Override // androidx.camera.core.Preview.SurfaceProvider
            public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                CameraManager.m(this.f41640a, executor, surfaceRequest);
            }
        };
        Preview previewBuild = new Preview.Builder().build();
        Intrinsics.checkNotNullExpressionValue(previewBuild, "cameraPreviewBuilder.build()");
        previewBuild.setSurfaceProvider(surfaceProvider);
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(cameraManager.cameraFacing).build();
        Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "Builder()\n              …\n                .build()");
        try {
            processCameraProvider.unbindAll();
            ComponentCallbacks2 componentCallbacks2 = cameraManager.activity;
            Intrinsics.checkNotNull(componentCallbacks2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            LifecycleOwner lifecycleOwner = (LifecycleOwner) componentCallbacks2;
            UseCase[] useCaseArr = new UseCase[2];
            useCaseArr[0] = previewBuild;
            ImageAnalysis imageAnalysis = cameraManager.imageAnalysis;
            Size size = null;
            if (imageAnalysis == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageAnalysis");
                imageAnalysis = null;
            }
            useCaseArr[1] = imageAnalysis;
            Camera cameraBindToLifecycle = processCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelectorBuild, useCaseArr);
            cameraManager.camera = cameraBindToLifecycle;
            Intrinsics.checkNotNull(cameraBindToLifecycle);
            cameraManager.cameraSensorRotation = cameraBindToLifecycle.getCameraInfo().getSensorRotationDegrees();
            ResolutionInfo resolutionInfo = previewBuild.getResolutionInfo();
            Intrinsics.checkNotNull(resolutionInfo);
            Size resolution = resolutionInfo.getResolution();
            Intrinsics.checkNotNullExpressionValue(resolution, "cameraPreview.resolutionInfo!!.resolution");
            boolean z = cameraManager.cameraSensorRotation % 180 == 0;
            int width = resolution.getWidth();
            int height = resolution.getHeight();
            cameraManager.previewSize = z ? new Size(width, height) : new Size(height, width);
            HashMap map = new HashMap();
            map.put("textureId", Long.valueOf(cameraManager.flutterTexture.id()));
            Size size2 = cameraManager.previewSize;
            if (size2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                size2 = null;
            }
            map.put("previewWidth", Integer.valueOf(size2.getWidth()));
            Size size3 = cameraManager.previewSize;
            if (size3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                size3 = null;
            }
            map.put("previewHeight", Integer.valueOf(size3.getHeight()));
            PoseDetector poseDetector = cameraManager.detector;
            if (poseDetector == null || (mapEmptyMap = poseDetector.Y()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            map.put("initArguments", mapEmptyMap);
            String str = cameraManager.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Camera initialized successfully with size ");
            Size size4 = cameraManager.previewSize;
            if (size4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                size4 = null;
            }
            sb.append(size4.getWidth());
            sb.append('x');
            Size size5 = cameraManager.previewSize;
            if (size5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewSize");
            } else {
                size = size5;
            }
            sb.append(size.getHeight());
            Log.i(str, sb.toString());
            result.success(map);
        } catch (Exception e) {
            Log.e(cameraManager.TAG, "Use case binding failed", e);
        }
    }

    public static final void m(CameraManager cameraManager, Executor executor, SurfaceRequest surfaceRequest) {
        Intrinsics.checkNotNullParameter(cameraManager, "this$0");
        Intrinsics.checkNotNullParameter(surfaceRequest, "request");
        Size resolution = surfaceRequest.getResolution();
        Intrinsics.checkNotNullExpressionValue(resolution, "request.resolution");
        SurfaceTexture surfaceTexture = cameraManager.flutterTexture.surfaceTexture();
        Intrinsics.checkNotNullExpressionValue(surfaceTexture, "flutterTexture.surfaceTexture()");
        surfaceTexture.setDefaultBufferSize(resolution.getWidth(), resolution.getHeight());
        surfaceRequest.provideSurface(new Surface(surfaceTexture), executor, new Consumer() { // from class: com.zj.adlib.hc1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CameraManager.n((SurfaceRequest.Result) obj);
            }
        });
    }

    public static final void n(SurfaceRequest.Result result) {
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(@NotNull ImageProxy image) {
        Intrinsics.checkNotNullParameter(image, "image");
        if (this.pauseAnalysis) {
            image.close();
            return;
        }
        try {
            PoseEstimationResult poseEstimationResultO = o(image);
            List<KeyPoint> listQ = poseEstimationResultO.q();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listQ, 10));
            for (KeyPoint keyPoint : listQ) {
                arrayList.add(CollectionsKt.listOf(new Float[]{Float.valueOf(keyPoint.g().x), Float.valueOf(keyPoint.g().y), Float.valueOf(keyPoint.h())}));
            }
            int i = this.frameCounter + 1;
            this.frameCounter = i;
            if (i % 10 == 0) {
                this.frameCounter = 0;
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.fps = (1000 * 10) / (jCurrentTimeMillis - this.lastFpsTimestamp);
                this.lastFpsTimestamp = jCurrentTimeMillis;
            }
            final HashMap map = new HashMap();
            map.put("keyPoints", arrayList);
            map.put(AliyunLogKey.KEY_FPS, Float.valueOf(this.fps));
            map.put("imageWidth", Integer.valueOf(poseEstimationResultO.o().getWidth()));
            map.put("imageHeight", Integer.valueOf(poseEstimationResultO.o().getHeight()));
            map.put("cost", Integer.valueOf(poseEstimationResultO.k()));
            map.put("imageProcessCost", Integer.valueOf(poseEstimationResultO.n()));
            map.put("inferenceCost", Integer.valueOf(poseEstimationResultO.p()));
            if (this.needTakePicture && poseEstimationResultO.m() != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                poseEstimationResultO.m().compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(outputStr…eArray(), Base64.NO_WRAP)");
                map.put("picture", strEncodeToString);
                this.needTakePicture = false;
            }
            this.activity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.gc1
                @Override // java.lang.Runnable
                public final void run() {
                    CameraManager.h(this.f41869a, map);
                }
            });
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(image, (Throwable) null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(image, th);
                throw th2;
            }
        }
    }

    public final void i() {
        synchronized (this.lock) {
            PoseDetector poseDetector = this.detector;
            if (poseDetector != null) {
                poseDetector.close();
            }
            this.detector = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void j() {
        i();
        this.flutterTexture.release();
    }

    @ExperimentalCamera2Interop
    public final void k(@NotNull final MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.imageAnalysis == null) {
            ImageAnalysis.Builder builder = new ImageAnalysis.Builder();
            builder.setTargetAspectRatio(0).setBackpressureStrategy(0).setOutputImageFormat(2);
            new Camera2Interop.Extender(builder).setCaptureRequestOption(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(30, 30));
            ImageAnalysis imageAnalysisBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "analysisBuilder.build()");
            this.imageAnalysis = imageAnalysisBuild;
        }
        final Executor mainExecutor = ContextCompat.getMainExecutor(this.activity);
        final ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(this.activity);
        Intrinsics.checkNotNullExpressionValue(processCameraProvider, "getInstance(activity)");
        processCameraProvider.addListener(new Runnable() { // from class: com.zj.adlib.ic1
            @Override // java.lang.Runnable
            public final void run() {
                CameraManager.l(processCameraProvider, this, result, mainExecutor);
            }
        }, mainExecutor);
    }

    public final PoseEstimationResult o(ImageProxy image) {
        synchronized (this.lock) {
            PoseDetector poseDetector = this.detector;
            if (poseDetector != null) {
                PoseEstimationResult poseEstimationResultN = poseDetector.n(image, this.cameraFacing == 0, this.cameraSensorRotation);
                if (poseEstimationResultN != null) {
                    return poseEstimationResultN;
                }
            }
            return new PoseEstimationResult(0, new Size(1, 1), CollectionsKt.emptyList(), 0.0f, 0, 0, 0, null, 129, null);
        }
    }

    public final void p(@NotNull PoseDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        synchronized (this.lock) {
            PoseDetector poseDetector = this.detector;
            if (poseDetector != null) {
                poseDetector.close();
            }
            this.detector = detector;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void q() {
        ImageAnalysis imageAnalysis = this.imageAnalysis;
        if (imageAnalysis == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageAnalysis");
            imageAnalysis = null;
        }
        imageAnalysis.setAnalyzer(this.imageProcessExecutor, this);
    }

    public final void r(@NotNull EventChannel poseStreamChannel) {
        Intrinsics.checkNotNullParameter(poseStreamChannel, "poseStreamChannel");
        poseStreamChannel.setStreamHandler(new a());
    }

    public final void s() {
        this.pauseAnalysis = true;
    }

    public final void t() {
        this.needTakePicture = true;
    }
}
