package com.huachenjie.base.aliyun.detect_face.analyzer;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.aliyun.detect_face.analyzer.FaceDetectAnalyzer;
import com.huachenjie.base.bean.RunFaceDetectStatus;
import com.insightface.sdk.inspireface.base.FaceFeature;
import com.insightface.sdk.inspireface.base.FaceInteractionsActions;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.FaceResult;
import com.zj.adlib.TrackingInfo;
import com.zj.adlib.i4a;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B)\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0014\u0010)\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u0018\u0010*\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010,\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010+R@\u00102\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010-8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010/\u001a\u0004\b0\u00101R$\u00107\u001a\u0002032\u0006\u0010.\u001a\u0002038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00109¨\u0006="}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/analyzer/FaceDetectAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "Landroidx/camera/core/ImageProxy;", "imageProxy", "", "analyze", "m", "d", y6b.f, "i", "Lcom/zj/adlib/xa9;", "trackingInfo", t.d, "Lcom/zj/adlib/td3;", "result", "", "n", "j", "k", "", "a", "Ljava/lang/String;", "faceImg", "Z", "bodyEnable", "Lcom/huachenjie/base/bean/RunFaceDetectStatus;", "Lcom/huachenjie/base/bean/RunFaceDetectStatus;", "detectStatus", "Lcom/huachenjie/base/aliyun/detect_face/analyzer/AnalyzerCallback;", "Lcom/huachenjie/base/aliyun/detect_face/analyzer/AnalyzerCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/base/aliyun/detect_face/analyzer/FaceTool;", "Lcom/huachenjie/base/aliyun/detect_face/analyzer/FaceTool;", "faceTool", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "faceImageLoadThread", "Landroid/os/Handler;", "Landroid/os/Handler;", "faceImageLoadHandler", "b", "faceDetectionThread", "faceDetectionHandler", "Lcom/zj/adlib/td3;", "bgFaceFeature", "Lkotlin/Pair;", "<set-?>", "Lkotlin/Pair;", "e", "()Lkotlin/Pair;", "bestFaceData", "", "F", "f", "()F", "bestSimilarity", "", "I", "status", "<init>", "(Ljava/lang/String;ZLcom/huachenjie/base/bean/RunFaceDetectStatus;Lcom/huachenjie/base/aliyun/detect_face/analyzer/AnalyzerCallback;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class FaceDetectAnalyzer implements ImageAnalysis.Analyzer {
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    public static final String f6947b = "FaceDetectAnalyzer";
    public static final int c = 1000;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public float bestSimilarity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public int status;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Handler faceImageLoadHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final HandlerThread faceImageLoadThread;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AnalyzerCallback callback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public FaceTool faceTool;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RunFaceDetectStatus detectStatus;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public FaceResult bgFaceFeature;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final String faceImg;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Pair<FaceResult, TrackingInfo> bestFaceData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final boolean bodyEnable;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Handler faceDetectionHandler;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final HandlerThread faceDetectionThread;

    public FaceDetectAnalyzer(@Nullable String str, boolean z, @NotNull RunFaceDetectStatus runFaceDetectStatus, @NotNull AnalyzerCallback analyzerCallback) {
        Intrinsics.checkNotNullParameter(runFaceDetectStatus, "detectStatus");
        Intrinsics.checkNotNullParameter(analyzerCallback, RenderCallContext.TYPE_CALLBACK);
        this.faceImg = str;
        this.bodyEnable = z;
        this.detectStatus = runFaceDetectStatus;
        this.callback = analyzerCallback;
        this.faceTool = new FaceTool();
        HandlerThread handlerThread = new HandlerThread("FaceImageLoadThread");
        this.faceImageLoadThread = handlerThread;
        HandlerThread handlerThread2 = new HandlerThread("FaceDetectionThread");
        this.faceDetectionThread = handlerThread2;
        handlerThread.start();
        this.faceImageLoadHandler = new Handler(handlerThread.getLooper());
        g();
        handlerThread2.start();
        this.faceDetectionHandler = new Handler(handlerThread2.getLooper(), new Handler.Callback() { // from class: com.zj.adlib.qd3
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return FaceDetectAnalyzer.c(this.f44179a, message);
            }
        });
    }

    public static final boolean c(FaceDetectAnalyzer faceDetectAnalyzer, Message message) {
        Intrinsics.checkNotNullParameter(faceDetectAnalyzer, "this$0");
        Intrinsics.checkNotNullParameter(message, "msg");
        if (message.what != 1) {
            return false;
        }
        Object obj = message.obj;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.huachenjie.base.aliyun.detect_face.analyzer.TrackingInfo");
        faceDetectAnalyzer.l((TrackingInfo) obj);
        return true;
    }

    public static final void h(FaceDetectAnalyzer faceDetectAnalyzer) {
        Intrinsics.checkNotNullParameter(faceDetectAnalyzer, "this$0");
        faceDetectAnalyzer.detectStatus.setModelInit(!faceDetectAnalyzer.faceTool.k() ? 1 : 0);
        faceDetectAnalyzer.i();
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(@NotNull ImageProxy imageProxy) {
        Message messageObtainMessage;
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        if (imageProxy.getFormat() != 35) {
            imageProxy.close();
            return;
        }
        try {
            try {
                TrackingInfo trackingInfoF = this.faceTool.f(imageProxy);
                if (trackingInfoF.l() != 0 && trackingInfoF.j() != 0) {
                    Handler handler = this.faceDetectionHandler;
                    if (handler != null) {
                        handler.removeMessages(1);
                    }
                    Handler handler2 = this.faceDetectionHandler;
                    if (handler2 != null && (messageObtainMessage = handler2.obtainMessage(1, trackingInfoF)) != null) {
                        messageObtainMessage.sendToTarget();
                    }
                }
            } catch (Exception e2) {
                i4a.d(f6947b, "analyze image error: " + e2.getMessage());
            }
        } finally {
            imageProxy.close();
        }
    }

    public final void d() {
        Handler handler = this.faceImageLoadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.faceImageLoadHandler = null;
        this.faceImageLoadThread.quit();
        Handler handler2 = this.faceDetectionHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        this.faceDetectionHandler = null;
        this.faceDetectionThread.quit();
        this.faceTool.g();
    }

    @Nullable
    public final Pair<FaceResult, TrackingInfo> e() {
        return this.bestFaceData;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final float getBestSimilarity() {
        return this.bestSimilarity;
    }

    public final void g() {
        Handler handler = this.faceImageLoadHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.zj.adlib.rd3
                @Override // java.lang.Runnable
                public final void run() {
                    FaceDetectAnalyzer.h(this.f44424a);
                }
            });
        }
    }

    public final void i() {
        String str = this.faceImg;
        if (str == null || str.length() == 0) {
            i4a.d(f6947b, "face image is empty");
            return;
        }
        Bitmap bitmapH = this.faceTool.h(this.faceImg, 1000);
        this.detectStatus.setBaseImageDownload(bitmapH == null ? 2 : 1);
        if (bitmapH == null) {
            return;
        }
        FaceResult faceResultA = this.faceTool.a(bitmapH, false);
        this.bgFaceFeature = faceResultA;
        this.detectStatus.setBaseImageParse(faceResultA == null ? 2 : 1);
    }

    public final boolean j(FaceResult result, TrackingInfo trackingInfo) {
        float fL = trackingInfo.l() * 0.2f;
        float fL2 = trackingInfo.l() * 0.8f;
        float fJ = trackingInfo.j() * 0.2f;
        float fJ2 = trackingInfo.j() * 0.8f;
        float f2 = result.i().x + (result.i().width * 0.5f);
        float f3 = result.i().y + (result.i().height * 0.5f);
        return f2 > fL && f2 < fL2 && f3 > fJ && f3 < fJ2;
    }

    public final void k() {
        FaceTool faceTool = this.faceTool;
        Pair<FaceResult, TrackingInfo> pair = this.bestFaceData;
        Intrinsics.checkNotNull(pair);
        FaceFeature faceFeatureH = ((FaceResult) pair.getFirst()).h();
        FaceResult faceResult = this.bgFaceFeature;
        Intrinsics.checkNotNull(faceResult);
        float fC = faceTool.c(faceFeatureH, faceResult.h()) * 100;
        this.bestSimilarity = fC;
        AnalyzerCallback analyzerCallback = this.callback;
        Pair<FaceResult, TrackingInfo> pair2 = this.bestFaceData;
        Intrinsics.checkNotNull(pair2);
        if (analyzerCallback.a(fC, (TrackingInfo) pair2.getSecond())) {
            i4a.g(f6947b, "置信度通过...");
        } else {
            i4a.g(f6947b, "置信度未通过...");
            this.status = 0;
        }
    }

    public final void l(TrackingInfo trackingInfo) {
        int[] iArr;
        Integer orNull;
        if (this.bgFaceFeature == null || this.status == 4) {
            return;
        }
        FaceResult faceResultB = this.faceTool.b(trackingInfo, true);
        if (faceResultB == null) {
            return;
        }
        if (this.status == 0) {
            if (!n(faceResultB, trackingInfo)) {
                return;
            }
            this.callback.d("");
            i4a.g(f6947b, "获取到最佳人脸");
            this.bestFaceData = new Pair<>(faceResultB, trackingInfo);
            this.bestSimilarity = 0.0f;
            this.detectStatus.setBestImageCapture(1);
        }
        FaceInteractionsActions faceInteractionsActionsG = faceResultB.g();
        int iIntValue = (faceInteractionsActionsG == null || (iArr = faceInteractionsActionsG.shake) == null || (orNull = ArraysKt.getOrNull(iArr, 0)) == null) ? -1 : orNull.intValue();
        int i = this.status;
        if (i == 0) {
            int i2 = this.bodyEnable ? 1 : 4;
            this.status = i2;
            if (i2 == 4) {
                k();
                return;
            }
            return;
        }
        if (i == 1) {
            this.callback.b();
            if (iIntValue == 0) {
                this.status = 2;
                i4a.g(f6947b, "开始摇头检测...");
                return;
            }
            return;
        }
        if (i == 2) {
            if (iIntValue == 1) {
                this.status = 3;
                i4a.g(f6947b, "摇头中...");
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        this.callback.c();
        if (iIntValue == 0) {
            this.status = 4;
            this.detectStatus.setLivenessCheck(1);
            i4a.g(f6947b, "完成摇头动作识别");
            k();
        }
    }

    public final void m() {
        this.status = 0;
    }

    public final boolean n(FaceResult result, TrackingInfo trackingInfo) {
        float fL = (result.i().width * result.i().height) / (trackingInfo.l() * trackingInfo.j());
        if (fL < 0.1f) {
            this.callback.d("请靠近一点");
            return false;
        }
        if (fL > 0.6f) {
            this.callback.d("请远离一点");
            return false;
        }
        if (!j(result, trackingInfo)) {
            this.callback.d("请移动到中间");
            return false;
        }
        if (result.j() >= 0.5f) {
            return true;
        }
        this.callback.d("请保持不动");
        return false;
    }
}
