package com.huachenjie.base.aliyun.detect_face.analyzer;

import android.graphics.Bitmap;
import androidx.camera.core.ImageProxy;
import com.blankj.utilcode.util.Utils;
import com.insightface.sdk.inspireface.InspireFace;
import com.insightface.sdk.inspireface.base.CustomParameter;
import com.insightface.sdk.inspireface.base.FaceFeature;
import com.insightface.sdk.inspireface.base.FaceInteractionsActions;
import com.insightface.sdk.inspireface.base.FaceQualityConfidence;
import com.insightface.sdk.inspireface.base.FaceRect;
import com.insightface.sdk.inspireface.base.ImageStream;
import com.insightface.sdk.inspireface.base.MultipleFaceData;
import com.insightface.sdk.inspireface.base.Session;
import com.insightface.sdk.inspireface.base.TypeDefine;
import com.zj.adlib.FaceResult;
import com.zj.adlib.TrackingInfo;
import com.zj.adlib.i4a;
import com.zj.adlib.m55;
import com.zj.adlib.mm9;
import com.zj.adlib.rw0;
import com.zj.adlib.y6b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\bC\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ$\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u001cJ8\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u000bH\u0002JH\u0010,\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0002J\u001a\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00107R\u0016\u0010:\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u00109R\u0016\u0010;\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00109R\u0016\u0010<\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00109R#\u0010B\u001a\n >*\u0004\u0018\u00010=0=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010?\u001a\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/analyzer/FaceTool;", "", "", "k", "Landroid/graphics/Bitmap;", "bitmap", "needPipeline", "Lcom/zj/adlib/td3;", "a", "", "url", "", "maxSize", y6b.g, "imageUrl1", "imageUrl2", "", "d", "Lcom/zj/adlib/xa9;", "trackingInfo", "b", "Landroidx/camera/core/ImageProxy;", "image", "f", "Lcom/insightface/sdk/inspireface/base/FaceFeature;", "feature1", "feature2", "c", "", y6b.f, "Landroidx/camera/core/ImageProxy$PlaneProxy;", "yPlane", "w", "degrees", "", "dst", "dstW", "n", "uPlane", "vPlane", "cw", "ch", "ySize", "dstCw", "m", "Lcom/insightface/sdk/inspireface/base/ImageStream;", "imageStream", "i", "Lcom/insightface/sdk/inspireface/base/Session;", "Lcom/insightface/sdk/inspireface/base/Session;", "session", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroyed", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "sessionLock", "[B", "yRowScratch", "uRowScratch", "vRowScratch", "Lcom/insightface/sdk/inspireface/base/CustomParameter;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "j", "()Lcom/insightface/sdk/inspireface/base/CustomParameter;", "parameter", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFaceTool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceTool.kt\ncom/huachenjie/base/aliyun/detect_face/analyzer/FaceTool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,439:1\n1#2:440\n*E\n"})
public final class FaceTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final String f6961a = "FaceTool";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Session session;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AtomicBoolean isDestroyed = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ReentrantLock sessionLock = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public byte[] yRowScratch = new byte[0];

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public byte[] uRowScratch = new byte[0];

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public byte[] vRowScratch = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy parameter = LazyKt.lazy(new Function0<CustomParameter>() { // from class: com.huachenjie.base.aliyun.detect_face.analyzer.FaceTool$parameter$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CustomParameter m208invoke() {
            return InspireFace.CreateCustomParameter().enableRecognition(true).enableFaceQuality(true).enableInteractionLiveness(true);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.analyzer.FaceTool$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/analyzer/FaceTool$a;", "", "", "imageUrl", "", "c", "Ljava/io/File;", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final File b(String imageUrl) {
            File file = new File(Utils.a().getExternalCacheDir(), "FaceRecognitionCache");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, m55.c(imageUrl));
            if (file2.exists()) {
                return file2;
            }
            try {
                Response responseExecute = new OkHttpClient().newCall(new Request.Builder().url(imageUrl).build()).execute();
                if (responseExecute.isSuccessful()) {
                    ResponseBody responseBodyBody = responseExecute.body();
                    byte[] bArrBytes = responseBodyBody != null ? responseBodyBody.bytes() : null;
                    if (bArrBytes != null) {
                        FilesKt.writeBytes(file2, bArrBytes);
                        return file2;
                    }
                }
            } catch (Exception e) {
                i4a.d(FaceTool.f6961a, "failed to download face image: " + e.getMessage());
            }
            return null;
        }

        @JvmStatic
        public final void c(@Nullable String imageUrl) {
            if (imageUrl == null || imageUrl.length() == 0) {
                i4a.d(FaceTool.f6961a, "face image url is empty");
            } else {
                b(imageUrl);
            }
        }
    }

    public static /* synthetic */ float e(FaceTool faceTool, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1000;
        }
        return faceTool.d(str, str2, i);
    }

    @JvmStatic
    public static final void l(@Nullable String str) {
        INSTANCE.c(str);
    }

    @Nullable
    public final FaceResult a(@NotNull Bitmap bitmap, boolean needPipeline) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (this.isDestroyed.get()) {
            i4a.p(f6961a, "FaceTool is destroyed, ignoring analyzeImage call");
            return null;
        }
        ImageStream imageStreamCreateImageStreamFromBitmap = InspireFace.CreateImageStreamFromBitmap(bitmap, 0);
        Intrinsics.checkNotNullExpressionValue(imageStreamCreateImageStreamFromBitmap, "imageStream");
        return i(imageStreamCreateImageStreamFromBitmap, needPipeline);
    }

    @Nullable
    public final FaceResult b(@NotNull TrackingInfo trackingInfo, boolean needPipeline) {
        Intrinsics.checkNotNullParameter(trackingInfo, "trackingInfo");
        if (this.isDestroyed.get()) {
            i4a.p(f6961a, "FaceTool is destroyed, ignoring analyzeImage call");
            return null;
        }
        ImageStream imageStreamCreateImageStreamFromByteBuffer = InspireFace.CreateImageStreamFromByteBuffer(trackingInfo.h(), trackingInfo.l(), trackingInfo.j(), trackingInfo.i(), trackingInfo.k());
        Intrinsics.checkNotNullExpressionValue(imageStreamCreateImageStreamFromByteBuffer, "imageStream");
        return i(imageStreamCreateImageStreamFromByteBuffer, needPipeline);
    }

    public final float c(@NotNull FaceFeature feature1, @NotNull FaceFeature feature2) {
        Intrinsics.checkNotNullParameter(feature1, "feature1");
        Intrinsics.checkNotNullParameter(feature2, "feature2");
        if (!this.isDestroyed.get()) {
            return InspireFace.FaceComparison(feature1, feature2);
        }
        i4a.p(f6961a, "FaceTool is destroyed, returning 0f for compareFeatures");
        return 0.0f;
    }

    public final float d(@Nullable String imageUrl1, @Nullable String imageUrl2, int maxSize) {
        boolean z = true;
        if (!(imageUrl1 == null || imageUrl1.length() == 0)) {
            if (imageUrl2 != null && imageUrl2.length() != 0) {
                z = false;
            }
            if (!z) {
                Bitmap bitmapH = h(imageUrl1, maxSize);
                Bitmap bitmapH2 = h(imageUrl2, maxSize);
                if (bitmapH == null || bitmapH2 == null) {
                    i4a.d(f6961a, "failed to decode bitmap from url");
                    return 0.0f;
                }
                FaceResult faceResultA = a(bitmapH, false);
                FaceFeature faceFeatureH = faceResultA != null ? faceResultA.h() : null;
                FaceResult faceResultA2 = a(bitmapH2, false);
                FaceFeature faceFeatureH2 = faceResultA2 != null ? faceResultA2.h() : null;
                if (faceFeatureH != null && faceFeatureH2 != null) {
                    return c(faceFeatureH, faceFeatureH2) * 100;
                }
                i4a.d(f6961a, "failed to extract face features from bitmaps");
                return 0.0f;
            }
        }
        i4a.d(f6961a, "image url is empty");
        return 0.0f;
    }

    @NotNull
    public final TrackingInfo f(@NotNull ImageProxy image) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(image, "image");
        int width = image.getWidth();
        int height = image.getHeight();
        int rotationDegrees = image.getImageInfo().getRotationDegrees();
        if (rotationDegrees == 90 || rotationDegrees == 270) {
            i = width;
            i2 = height;
        } else {
            i2 = width;
            i = height;
        }
        int i3 = i2 * i;
        byte[] bArr = new byte[i3 + (i3 / 2)];
        ImageProxy.PlaneProxy planeProxy = image.getPlanes()[0];
        Intrinsics.checkNotNullExpressionValue(planeProxy, "image.planes[0]");
        n(planeProxy, width, height, rotationDegrees, bArr, i2);
        ImageProxy.PlaneProxy planeProxy2 = image.getPlanes()[1];
        Intrinsics.checkNotNullExpressionValue(planeProxy2, "image.planes[1]");
        ImageProxy.PlaneProxy planeProxy3 = image.getPlanes()[2];
        Intrinsics.checkNotNullExpressionValue(planeProxy3, "image.planes[2]");
        m(planeProxy2, planeProxy3, width / 2, height / 2, rotationDegrees, bArr, i3, i2 / 2);
        return new TrackingInfo(bArr, i2, i, 5, 0);
    }

    public final void g() {
        ReentrantLock reentrantLock = this.sessionLock;
        reentrantLock.lock();
        try {
            if (this.isDestroyed.get()) {
                i4a.p(f6961a, "FaceTool already destroyed");
            } else {
                this.isDestroyed.set(true);
                Session session = this.session;
                if (session != null) {
                    InspireFace.ReleaseSession(session);
                }
                this.session = null;
                InspireFace.GlobalTerminate();
                i4a.b(f6961a, "FaceTool destroyed successfully");
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Nullable
    public final Bitmap h(@NotNull String url, int maxSize) {
        Intrinsics.checkNotNullParameter(url, "url");
        File fileB = INSTANCE.b(url);
        if (fileB == null) {
            return null;
        }
        rw0 rw0Var = rw0.f44555a;
        String absolutePath = fileB.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "cacheFile.absolutePath");
        return rw0Var.a(absolutePath, maxSize);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0095 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:3:0x0005, B:6:0x000c, B:12:0x0021, B:22:0x0070, B:29:0x0091, B:30:0x0094, B:31:0x0095, B:9:0x0016, B:15:0x0028, B:17:0x0039, B:19:0x0062, B:21:0x0068, B:27:0x0078), top: B:37:0x0005, inners: #1 }] */
    public final FaceResult i(ImageStream imageStream, boolean needPipeline) {
        FaceInteractionsActions faceInteractionsActionsGetFaceInteractionActionsResult;
        ReentrantLock reentrantLock = this.sessionLock;
        reentrantLock.lock();
        try {
            FaceResult faceResult = null;
            if (this.session != null) {
                try {
                    if (this.isDestroyed.get()) {
                        i4a.p(f6961a, "Session is null or FaceTool is destroyed");
                        InspireFace.ReleaseImageStream(imageStream);
                    } else {
                        try {
                            MultipleFaceData multipleFaceDataExecuteFaceTrack = InspireFace.ExecuteFaceTrack(this.session, imageStream);
                            if (multipleFaceDataExecuteFaceTrack.detectedNum < 1) {
                                InspireFace.ReleaseImageStream(imageStream);
                            } else {
                                if (needPipeline) {
                                    InspireFace.MultipleFacePipelineProcess(this.session, imageStream, multipleFaceDataExecuteFaceTrack, j());
                                    faceInteractionsActionsGetFaceInteractionActionsResult = InspireFace.GetFaceInteractionActionsResult(this.session);
                                } else {
                                    faceInteractionsActionsGetFaceInteractionActionsResult = null;
                                }
                                FaceFeature faceFeatureExtractFaceFeature = InspireFace.ExtractFaceFeature(this.session, imageStream, multipleFaceDataExecuteFaceTrack.tokens[0]);
                                FaceQualityConfidence faceQualityConfidenceGetFaceQualityConfidence = InspireFace.GetFaceQualityConfidence(this.session);
                                FaceRect faceRect = multipleFaceDataExecuteFaceTrack.rects[0];
                                Intrinsics.checkNotNullExpressionValue(faceRect, "multipleFaceData.rects[0]");
                                float[] fArr = faceQualityConfidenceGetFaceQualityConfidence.confidence;
                                Intrinsics.checkNotNullExpressionValue(fArr, "quality.confidence");
                                Float orNull = ArraysKt.getOrNull(fArr, 0);
                                float fFloatValue = orNull != null ? orNull.floatValue() : 0.0f;
                                Intrinsics.checkNotNullExpressionValue(faceFeatureExtractFaceFeature, mm9.f18258b);
                                FaceResult faceResult2 = new FaceResult(faceRect, fFloatValue, faceInteractionsActionsGetFaceInteractionActionsResult, faceFeatureExtractFaceFeature);
                                InspireFace.ReleaseImageStream(imageStream);
                                faceResult = faceResult2;
                            }
                        } catch (Exception e) {
                            i4a.d(f6961a, "Error in extractFaceResult: " + e.getMessage());
                        }
                    }
                } catch (Throwable th) {
                    InspireFace.ReleaseImageStream(imageStream);
                    throw th;
                }
            } else {
                i4a.p(f6961a, "Session is null or FaceTool is destroyed");
                InspireFace.ReleaseImageStream(imageStream);
            }
            reentrantLock.unlock();
            return faceResult;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final CustomParameter j() {
        return (CustomParameter) this.parameter.getValue();
    }

    public final boolean k() {
        Boolean boolGlobalLaunch = InspireFace.GlobalLaunch(Utils.a(), TypeDefine.PIKACHU);
        i4a.b(f6961a, "Launch status: " + boolGlobalLaunch);
        if (!boolGlobalLaunch.booleanValue()) {
            i4a.d(f6961a, "Failed to launch InspireFace");
            return false;
        }
        Session sessionCreateSession = InspireFace.CreateSession(j(), 1, 1, 320, -1);
        this.session = sessionCreateSession;
        InspireFace.SetTrackPreviewSize(sessionCreateSession, 320);
        InspireFace.SetFaceDetectThreshold(this.session, 0.5f);
        InspireFace.SetFilterMinimumFacePixelSize(this.session, 0);
        return true;
    }

    public final void m(ImageProxy.PlaneProxy uPlane, ImageProxy.PlaneProxy vPlane, int cw, int ch, int degrees, byte[] dst, int ySize, int dstCw) {
        ByteBuffer buffer = uPlane.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "uPlane.buffer");
        ByteBuffer buffer2 = vPlane.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer2, "vPlane.buffer");
        int rowStride = uPlane.getRowStride();
        int rowStride2 = vPlane.getRowStride();
        int pixelStride = uPlane.getPixelStride();
        int pixelStride2 = vPlane.getPixelStride();
        if (this.uRowScratch.length < rowStride) {
            this.uRowScratch = new byte[rowStride];
        }
        if (this.vRowScratch.length < rowStride2) {
            this.vRowScratch = new byte[rowStride2];
        }
        byte[] bArr = this.uRowScratch;
        byte[] bArr2 = this.vRowScratch;
        int i = dstCw * 2;
        int i2 = 0;
        int i3 = 0;
        while (i3 < ch) {
            buffer.position(i3 * rowStride);
            buffer2.position(i3 * rowStride2);
            buffer.get(bArr, i2, Math.min(rowStride, buffer.remaining()));
            buffer2.get(bArr2, i2, Math.min(rowStride2, buffer2.remaining()));
            if (degrees == 90) {
                int i4 = ySize + (i3 * 2);
                for (int i5 = 0; i5 < cw; i5++) {
                    dst[i4] = bArr2[i5 * pixelStride2];
                    dst[i4 + 1] = bArr[i5 * pixelStride];
                    i4 += i;
                }
            } else if (degrees == 180) {
                int i6 = ySize + (((ch - 1) - i3) * i);
                for (int i7 = 0; i7 < cw; i7++) {
                    dst[i6] = bArr2[i7 * pixelStride2];
                    dst[i6 + 1] = bArr[i7 * pixelStride];
                    i6 += 2;
                }
            } else if (degrees != 270) {
                int i8 = ySize + (((i3 * dstCw) + (cw - 1)) * 2);
                while (i2 < cw) {
                    dst[i8] = bArr2[i2 * pixelStride2];
                    dst[i8 + 1] = bArr[i2 * pixelStride];
                    i8 -= 2;
                    i2++;
                }
            } else {
                int i9 = ySize + ((((cw - 1) * dstCw) + ((ch - 1) - i3)) * 2);
                for (int i10 = 0; i10 < cw; i10++) {
                    dst[i9] = bArr2[i10 * pixelStride2];
                    dst[i9 + 1] = bArr[i10 * pixelStride];
                    i9 -= i;
                }
            }
            i3++;
            i2 = 0;
        }
    }

    public final void n(ImageProxy.PlaneProxy yPlane, int w, int h, int degrees, byte[] dst, int dstW) {
        ByteBuffer buffer = yPlane.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "yPlane.buffer");
        int rowStride = yPlane.getRowStride();
        int pixelStride = yPlane.getPixelStride();
        if (this.yRowScratch.length < rowStride) {
            this.yRowScratch = new byte[rowStride];
        }
        byte[] bArr = this.yRowScratch;
        for (int i = 0; i < h; i++) {
            buffer.position(i * rowStride);
            buffer.get(bArr, 0, Math.min(rowStride, buffer.remaining()));
            if (degrees == 90) {
                int i2 = i;
                for (int i3 = 0; i3 < w; i3++) {
                    dst[i2] = bArr[i3 * pixelStride];
                    i2 += dstW;
                }
            } else if (degrees == 180) {
                int i4 = ((h - 1) - i) * dstW;
                if (pixelStride == 1) {
                    System.arraycopy(bArr, 0, dst, i4, w);
                } else {
                    int i5 = 0;
                    while (i5 < w) {
                        dst[i4] = bArr[i5 * pixelStride];
                        i5++;
                        i4++;
                    }
                }
            } else if (degrees != 270) {
                int i6 = (i * dstW) + (w - 1);
                int i7 = 0;
                while (i7 < w) {
                    dst[i6] = bArr[i7 * pixelStride];
                    i7++;
                    i6--;
                }
            } else {
                int i8 = ((w - 1) * dstW) + ((h - 1) - i);
                for (int i9 = 0; i9 < w; i9++) {
                    dst[i8] = bArr[i9 * pixelStride];
                    i8 -= dstW;
                }
            }
        }
    }
}
