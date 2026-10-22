package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.LayoutModel;
import com.huachenjie.pose_estimation.data.BodyPart;
import com.huachenjie.pose_estimation.data.Device;
import com.huachenjie.pose_estimation.ml.PoseDetector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.gpu.CompatibilityList;
import org.tensorflow.lite.gpu.GpuDelegate;
import org.tensorflow.lite.support.image.f;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B/\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010\"\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0004\b9\u0010:J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J&\u0010\u0018\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J4\u0010\u001e\u001a\u00020\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010#R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010(R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00100R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010+R\u0014\u00105\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010+R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00107¨\u0006;"}, d2 = {"Lcom/zj/adlib/wr5;", "Lcom/huachenjie/pose_estimation/ml/PoseDetector;", "Landroidx/camera/core/ImageProxy;", "image", "", "imageFlipped", "", "sensorRotation", "Lcom/zj/adlib/fv6;", "n", "", "", "", "Y", "", "close", "imageWidth", "imageHeight", "Landroid/graphics/RectF;", "c", "", "Lcom/zj/adlib/es4;", "keyPoints", "e", "a", "targetKeyPoints", "", LayoutModel.MODEL_KEY_CENTER_X, LayoutModel.MODEL_KEY_CENTER_Y, "Lcom/zj/adlib/j99;", "b", "Lorg/tensorflow/lite/a;", "Lorg/tensorflow/lite/a;", "interpreter", "Lorg/tensorflow/lite/gpu/GpuDelegate;", "Lorg/tensorflow/lite/gpu/GpuDelegate;", "gpuDelegate", "Ljava/util/Map;", "initArguments", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "bitmapBuffer", "K", "I", "imageRotationDegrees", "Lcom/zj/adlib/a84;", "Lcom/zj/adlib/a84;", "imageProcessor", "Landroid/graphics/RectF;", "cropRegion", "L", "inputWidth", "M", "inputHeight", "", "[I", "outputShape", "<init>", "(Lorg/tensorflow/lite/a;Lorg/tensorflow/lite/gpu/GpuDelegate;Ljava/util/Map;)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class wr5 implements PoseDetector {
    public static final int N = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f45668a = 0.3f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f20501a = new a(null);
    public static final float b = 1.9f;
    public static final float c = 1.2f;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int imageRotationDegrees;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int inputWidth;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public final int inputHeight;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public Bitmap bitmapBuffer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public RectF cropRegion;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public a84 imageProcessor;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Map<String, ? extends Object> initArguments;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final org.tensorflow.lite.a interpreter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public GpuDelegate gpuDelegate;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public int[] outputShape;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/wr5$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/pose_estimation/data/Device;", "device", "", "modelFile", "Lcom/zj/adlib/wr5;", "a", "", "BODY_EXPANSION_RATIO", "F", "", "CPU_NUM_THREADS", "I", "MIN_CROP_KEYPOINT_SCORE", "TORSO_EXPANSION_RATIO", "<init>", "()V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        /* JADX INFO: renamed from: com.zj.adlib.wr5$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class C1335a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f45669a;

            static {
                int[] iArr = new int[Device.values().length];
                iArr[Device.CPU.ordinal()] = 1;
                iArr[Device.GPU.ordinal()] = 2;
                iArr[Device.NNAPI.ordinal()] = 3;
                f45669a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0045  */
        @NotNull
        public final wr5 a(@NotNull Context context, @NotNull Device device, @NotNull String modelFile) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(modelFile, "modelFile");
            org.tensorflow.lite.a.a aVar = new org.tensorflow.lite.a.a();
            aVar.v(4);
            int i = C1335a.f45669a[device.ordinal()];
            int i2 = 1;
            GpuDelegate gpuDelegate = null;
            if (i == 1) {
                i2 = 0;
            } else if (i != 2) {
                if (i != 3) {
                    i2 = 0;
                } else {
                    aVar.x(true);
                    i2 = 2;
                }
            } else if (new CompatibilityList().h()) {
                gpuDelegate = new GpuDelegate();
                aVar.q(gpuDelegate);
            } else {
                i2 = 0;
            }
            return new wr5(new org.tensorflow.lite.a(ig3.f(context, modelFile), aVar), gpuDelegate, MapsKt.mapOf(TuplesKt.to("interpreterDevice", Integer.valueOf(i2))));
        }
    }

    public wr5(@NotNull org.tensorflow.lite.a aVar, @Nullable GpuDelegate gpuDelegate, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(aVar, "interpreter");
        this.interpreter = aVar;
        this.gpuDelegate = gpuDelegate;
        this.initArguments = map;
        this.inputWidth = aVar.c0(0).i()[1];
        this.inputHeight = aVar.c0(0).i()[2];
        int[] iArrI = aVar.p0(0).i();
        Intrinsics.checkNotNullExpressionValue(iArrI, "interpreter.getOutputTensor(0).shape()");
        this.outputShape = iArrI;
    }

    @Override // com.huachenjie.pose_estimation.ml.PoseDetector
    @NotNull
    public Map<String, Object> Y() {
        Map<String, ? extends Object> map = this.initArguments;
        return map == null ? MapsKt.emptyMap() : map;
    }

    public final RectF a(List<KeyPoint> keyPoints, int imageWidth, int imageHeight) {
        ArrayList arrayList = new ArrayList();
        for (KeyPoint keyPoint : keyPoints) {
            arrayList.add(new KeyPoint(keyPoint.f(), new PointF(keyPoint.g().x, keyPoint.g().y), keyPoint.h()));
        }
        if (!e(keyPoints)) {
            return c(imageWidth, imageHeight);
        }
        BodyPart bodyPart = BodyPart.LEFT_HIP;
        float f = arrayList.get(bodyPart.getPosition()).g().x;
        BodyPart bodyPart2 = BodyPart.RIGHT_HIP;
        float f2 = (f + arrayList.get(bodyPart2.getPosition()).g().x) / 2.0f;
        float f3 = (arrayList.get(bodyPart.getPosition()).g().y + arrayList.get(bodyPart2.getPosition()).g().y) / 2.0f;
        TorsoAndBodyDistance torsoAndBodyDistanceB = b(keyPoints, arrayList, f2, f3);
        Float fMaxOrNull = CollectionsKt.maxOrNull(CollectionsKt.listOf(new Float[]{Float.valueOf(torsoAndBodyDistanceB.i() * 1.9f), Float.valueOf(torsoAndBodyDistanceB.j() * 1.9f), Float.valueOf(torsoAndBodyDistanceB.g() * 1.2f), Float.valueOf(torsoAndBodyDistanceB.h() * 1.2f)}));
        float fFloatValue = fMaxOrNull != null ? fMaxOrNull.floatValue() : 0.0f;
        float f4 = imageWidth;
        float f5 = imageHeight;
        Float fMaxOrNull2 = CollectionsKt.maxOrNull(CollectionsKt.listOf(new Float[]{Float.valueOf(f2), Float.valueOf(f4 - f2), Float.valueOf(f3), Float.valueOf(f5 - f3)}));
        float fMin = Math.min(fFloatValue, fMaxOrNull2 != null ? fMaxOrNull2.floatValue() : 0.0f);
        Pair pair = new Pair(Float.valueOf(f3 - fMin), Float.valueOf(f2 - fMin));
        double d = fMin;
        if (d > ((double) Math.max(imageWidth, imageHeight)) * 0.5d || d < ((double) Math.max(imageWidth, imageHeight)) * 0.02d) {
            return c(imageWidth, imageHeight);
        }
        float f6 = fMin * 2;
        return new RectF(((Number) pair.getSecond()).floatValue() / f4, ((Number) pair.getFirst()).floatValue() / f5, (((Number) pair.getSecond()).floatValue() + f6) / f4, (((Number) pair.getFirst()).floatValue() + f6) / f5);
    }

    public final TorsoAndBodyDistance b(List<KeyPoint> keyPoints, List<KeyPoint> targetKeyPoints, float centerX, float centerY) {
        Iterator it = CollectionsKt.listOf(new Integer[]{Integer.valueOf(BodyPart.LEFT_SHOULDER.getPosition()), Integer.valueOf(BodyPart.RIGHT_SHOULDER.getPosition()), Integer.valueOf(BodyPart.LEFT_HIP.getPosition()), Integer.valueOf(BodyPart.RIGHT_HIP.getPosition())}).iterator();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            float fAbs = Math.abs(centerY - targetKeyPoints.get(iIntValue).g().y);
            float fAbs2 = Math.abs(centerX - targetKeyPoints.get(iIntValue).g().x);
            if (fAbs > f2) {
                f2 = fAbs;
            }
            if (fAbs2 > f3) {
                f3 = fAbs2;
            }
        }
        int size = keyPoints.size();
        float f4 = 0.0f;
        for (int i = 0; i < size; i++) {
            if (keyPoints.get(i).h() >= 0.3f) {
                float fAbs3 = Math.abs(centerY - keyPoints.get(i).g().y);
                float fAbs4 = Math.abs(centerX - keyPoints.get(i).g().x);
                if (fAbs3 > f) {
                    f = fAbs3;
                }
                if (fAbs4 > f4) {
                    f4 = fAbs4;
                }
            }
        }
        return new TorsoAndBodyDistance(f2, f3, f, f4);
    }

    public final RectF c(int imageWidth, int imageHeight) {
        float f;
        float f2;
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (imageWidth > imageHeight) {
            float f5 = imageWidth;
            float f6 = imageHeight;
            f2 = f5 / f6;
            f = ((f6 / 2.0f) - (f5 / 2.0f)) / f6;
        } else {
            float f7 = imageWidth;
            f = 0.0f;
            f3 = ((f7 / 2.0f) - (imageHeight / 2)) / f7;
            f2 = 1.0f;
            f4 = imageHeight / f7;
        }
        return new RectF(f3, f, f4 + f3, f2 + f);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        GpuDelegate gpuDelegate = this.gpuDelegate;
        if (gpuDelegate != null) {
            gpuDelegate.close();
        }
        this.interpreter.close();
        this.cropRegion = null;
    }

    public final boolean e(List<KeyPoint> keyPoints) {
        return ((keyPoints.get(BodyPart.LEFT_SHOULDER.getPosition()).h() > 0.3f) | (keyPoints.get(BodyPart.RIGHT_SHOULDER.getPosition()).h() > 0.3f)) & ((keyPoints.get(BodyPart.LEFT_HIP.getPosition()).h() > 0.3f) | (keyPoints.get(BodyPart.RIGHT_HIP.getPosition()).h() > 0.3f));
    }

    @Override // com.huachenjie.pose_estimation.ml.PoseDetector
    @NotNull
    public PoseEstimationResult n(@NotNull ImageProxy image, boolean imageFlipped, int sensorRotation) {
        Bitmap bitmap;
        long jElapsedRealtime;
        Size size;
        float f;
        Intrinsics.checkNotNullParameter(image, "image");
        if (this.bitmapBuffer == null) {
            this.imageRotationDegrees = image.getImageInfo().getRotationDegrees();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(image.width… Bitmap.Config.ARGB_8888)");
            this.bitmapBuffer = bitmapCreateBitmap;
            a84 a84VarG = new a84.b().f(new ResizeOp(this.inputWidth, this.inputHeight, ResizeOp.ResizeMethod.BILINEAR)).g();
            Intrinsics.checkNotNullExpressionValue(a84VarG, "Builder()\n              …\n                .build()");
            this.imageProcessor = a84VarG;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        Bitmap bitmap2 = this.bitmapBuffer;
        a84 a84Var = null;
        if (bitmap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bitmapBuffer");
            bitmap2 = null;
        }
        bitmap2.copyPixelsFromBuffer(image.getPlanes()[0].getBuffer());
        Matrix matrix = new Matrix();
        matrix.postRotate(sensorRotation);
        if (imageFlipped) {
            matrix.postScale(-1.0f, 1.0f);
        }
        Bitmap bitmap3 = this.bitmapBuffer;
        if (bitmap3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bitmapBuffer");
            bitmap = null;
        } else {
            bitmap = bitmap3;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, image.getWidth(), image.getHeight(), matrix, false);
        if (this.cropRegion == null) {
            this.cropRegion = c(bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight());
        }
        int i = this.outputShape[2];
        ArrayList arrayList = new ArrayList();
        Size size2 = new Size(1, 1);
        RectF rectF = this.cropRegion;
        if (rectF != null) {
            RectF rectF2 = new RectF(rectF.left * bitmapCreateBitmap2.getWidth(), rectF.top * bitmapCreateBitmap2.getHeight(), rectF.right * bitmapCreateBitmap2.getWidth(), rectF.bottom * bitmapCreateBitmap2.getHeight());
            Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap((int) rectF2.width(), (int) rectF2.height(), Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap3).drawBitmap(bitmapCreateBitmap2, -rectF2.left, -rectF2.top, (Paint) null);
            f fVar = new f(DataType.UINT8);
            fVar.k(bitmapCreateBitmap3);
            a84 a84Var2 = this.imageProcessor;
            if (a84Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageProcessor");
            } else {
                a84Var = a84Var2;
            }
            f fVarD = a84Var.d(fVar);
            TensorBuffer tensorBufferD = TensorBuffer.d(this.outputShape, DataType.FLOAT32);
            Intrinsics.checkNotNullExpressionValue(tensorBufferD, "createFixedSize(outputShape, DataType.FLOAT32)");
            Size size3 = new Size(bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight());
            float width = bitmapCreateBitmap3.getWidth() / this.inputWidth;
            float height = bitmapCreateBitmap3.getHeight() / this.inputHeight;
            ArrayList arrayList2 = new ArrayList();
            jElapsedRealtime = SystemClock.elapsedRealtime();
            if (fVarD != null) {
                Intrinsics.checkNotNullExpressionValue(fVarD, "inputTensor");
                this.interpreter.G(fVarD.d(), tensorBufferD.f().rewind());
                float[] fArrI = tensorBufferD.i();
                int i2 = 0;
                f = 0.0f;
                while (i2 < i) {
                    int i3 = i2 * 3;
                    float f2 = fArrI[i3 + 1] * this.inputWidth * width;
                    Size size4 = size3;
                    float f3 = fArrI[i3 + 0] * this.inputHeight * height;
                    arrayList2.add(Float.valueOf(f2));
                    arrayList2.add(Float.valueOf(f3));
                    float f4 = fArrI[i3 + 2];
                    arrayList.add(new KeyPoint(BodyPart.INSTANCE.a(i2), new PointF(f2, f3), f4));
                    f += f4;
                    i2++;
                    height = height;
                    size3 = size4;
                    fArrI = fArrI;
                    width = width;
                }
                size = size3;
            } else {
                size = size3;
                f = 0.0f;
            }
            Matrix matrix2 = new Matrix();
            float[] floatArray = CollectionsKt.toFloatArray(arrayList2);
            matrix2.postTranslate(rectF2.left, rectF2.top);
            matrix2.mapPoints(floatArray);
            int i4 = 0;
            for (Object obj : arrayList) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int i6 = i4 * 2;
                ((KeyPoint) obj).i(new PointF(floatArray[i6], floatArray[i6 + 1]));
                i4 = i5;
            }
            this.cropRegion = a(arrayList, bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight());
        } else {
            jElapsedRealtime = 0;
            size = size2;
            f = 0.0f;
        }
        int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - jElapsedRealtime2);
        int i7 = (int) (jElapsedRealtime - jElapsedRealtime2);
        return new PoseEstimationResult(0, size, arrayList, f / i, iElapsedRealtime, i7, iElapsedRealtime - i7, bitmapCreateBitmap2, 1, null);
    }
}
