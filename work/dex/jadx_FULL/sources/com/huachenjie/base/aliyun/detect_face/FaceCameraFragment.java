package com.huachenjie.base.aliyun.detect_face;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Size;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.b;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.common.util.concurrent.ListenableFuture;
import com.hjq.permissions.Permission;
import com.huachenjie.base.aliyun.detect_face.FaceCameraFragment;
import com.huachenjie.base.aliyun.detect_face.analyzer.AnalyzerCallback;
import com.huachenjie.base.aliyun.detect_face.analyzer.FaceDetectAnalyzer;
import com.huachenjie.base.aliyun.detect_face.util.TakePhotoCallback;
import com.huachenjie.base.bean.RunFaceDetectStatus;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.zj.adlib.FaceResult;
import com.zj.adlib.TrackingInfo;
import com.zj.adlib.dd1;
import com.zj.adlib.en6;
import com.zj.adlib.fx7;
import com.zj.adlib.i4a;
import com.zj.adlib.vo6;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\bk\u0010lJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\b\u0010\u001c\u001a\u00020\nH&J\b\u0010\u001d\u001a\u00020\nH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\b\u0010!\u001a\u00020 H&J\b\u0010#\u001a\u00020\"H&J\u0010\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020 H&J\u0010\u0010&\u001a\u00020\n2\u0006\u0010$\u001a\u00020 H\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020\u000fH\u0016J\n\u0010+\u001a\u0004\u0018\u00010 H\u0016J\b\u0010-\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020 H\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\nH\u0016J\u0018\u00106\u001a\u00020\n2\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0016J\u0016\u00109\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000204\u0018\u000107H\u0004J\b\u0010:\u001a\u000202H\u0004J\u000e\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020;J\u0006\u0010>\u001a\u00020\nJ\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020 H\u0007J\b\u0010A\u001a\u00020\nH\u0004J\b\u0010B\u001a\u00020\nH\u0016R\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020,8\u0004X\u0084D¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010TR$\u0010W\u001a\u0004\u0018\u00010V8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001d\u0010`\u001a\u0004\u0018\u00010V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010ZR\u001b\u0010e\u001a\u00020a8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bb\u0010^\u001a\u0004\bc\u0010dR'\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010^\u001a\u0004\bh\u0010i¨\u0006m"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/FaceCameraFragment;", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Landroid/widget/FrameLayout;", "layout", "Landroid/widget/TextView;", "addSideTextView", "", "lockCommit", "startCamera", "Landroid/graphics/Bitmap;", "bitmap", "", "compressPicture", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "checkCameraPermission", "unlockCommit", "onPermissionDenied", "onClickBack", "Landroidx/camera/view/PreviewView;", "getPreviewView", "", "getLoadingTip", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "getUploadFileType", "message", "onCameraError", "onTakePictureError", "filePath", "onTakePicture", "isFaceAnalysis", "bodyEnable", "getFaceImg", "", "getSimilarityValue", "tip", "onFaceQualityTip", "onStartBodyDetection", "onEndBodyDetection", "", "sim", "Lcom/zj/adlib/xa9;", "trackingInfo", "onAnalyzerSuccess", "Lkotlin/Pair;", "Lcom/zj/adlib/td3;", "getBestFaceData", "getBestSimilarity", "Landroid/content/Context;", "context", com.alibaba.ariver.jsapi.multimedia.camera.a.f24158a, "resumeCamera", "textCode", "setSideText", "reAnalyzer", "onDestroyView", "Lcom/huachenjie/base/aliyun/detect_face/CameraXLifecycle;", "cameraLifecycle", "Lcom/huachenjie/base/aliyun/detect_face/CameraXLifecycle;", "Landroidx/camera/core/ImageCapture;", "imageCapture", "Landroidx/camera/core/ImageCapture;", "Lcom/huachenjie/base/aliyun/detect_face/analyzer/FaceDetectAnalyzer;", "faceDetectAnalyzer", "Lcom/huachenjie/base/aliyun/detect_face/analyzer/FaceDetectAnalyzer;", "faceTargetSize", "I", "getFaceTargetSize", "()I", "sideTextView", "Landroid/widget/TextView;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cameraInitSuccess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "canCommit", "Landroid/app/Dialog;", "loadingDialog", "Landroid/app/Dialog;", "getLoadingDialog", "()Landroid/app/Dialog;", "setLoadingDialog", "(Landroid/app/Dialog;)V", "mTakePictureLoading$delegate", "Lkotlin/Lazy;", "getMTakePictureLoading", "mTakePictureLoading", "Lcom/huachenjie/base/bean/RunFaceDetectStatus;", "detectStatus$delegate", "getDetectStatus", "()Lcom/huachenjie/base/bean/RunFaceDetectStatus;", "detectStatus", "com/huachenjie/base/aliyun/detect_face/FaceCameraFragment$analyzerCallback$2$a", "analyzerCallback$delegate", "getAnalyzerCallback", "()Lcom/huachenjie/base/aliyun/detect_face/FaceCameraFragment$analyzerCallback$2$a;", "analyzerCallback", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFaceCameraFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceCameraFragment.kt\ncom/huachenjie/base/aliyun/detect_face/FaceCameraFragment\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,426:1\n470#2:427\n*S KotlinDebug\n*F\n+ 1 FaceCameraFragment.kt\ncom/huachenjie/base/aliyun/detect_face/FaceCameraFragment\n*L\n135#1:427\n*E\n"})
public abstract class FaceCameraFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseMVVMFragment<V, VM> {

    @Nullable
    private FaceDetectAnalyzer faceDetectAnalyzer;

    @Nullable
    private ImageCapture imageCapture;

    @Nullable
    private Dialog loadingDialog;

    @Nullable
    private TextView sideTextView;

    @NotNull
    private final CameraXLifecycle cameraLifecycle = new CameraXLifecycle();
    private final int faceTargetSize = 1000;

    @NotNull
    private final AtomicBoolean cameraInitSuccess = new AtomicBoolean(false);

    @NotNull
    private final AtomicBoolean canCommit = new AtomicBoolean(true);

    /* JADX INFO: renamed from: mTakePictureLoading$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTakePictureLoading = LazyKt.lazy(new Function0<Dialog>(this) { // from class: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$mTakePictureLoading$2
        final /* synthetic */ FaceCameraFragment<V, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Dialog m207invoke() {
            return DialogUtil.p(this.this$0.requireActivity(), false);
        }
    });

    /* JADX INFO: renamed from: detectStatus$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy detectStatus = LazyKt.lazy(new Function0<RunFaceDetectStatus>(this) { // from class: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$detectStatus$2
        final /* synthetic */ FaceCameraFragment<V, VM> this$0;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/base/aliyun/detect_face/FaceCameraFragment$detectStatus$2$a", "Lcom/huachenjie/base/bean/RunFaceDetectStatus$OnStatusChangeListener;", "", "onStatusChange", "base_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements RunFaceDetectStatus.OnStatusChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FaceCameraFragment<V, VM> f32784a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ RunFaceDetectStatus f6946a;

            public a(FaceCameraFragment<V, VM> faceCameraFragment, RunFaceDetectStatus runFaceDetectStatus) {
                this.f32784a = faceCameraFragment;
                this.f6946a = runFaceDetectStatus;
            }

            public static final void b(FaceCameraFragment faceCameraFragment, RunFaceDetectStatus runFaceDetectStatus) {
                Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                Intrinsics.checkNotNullParameter(runFaceDetectStatus, "$this_apply");
                if (faceCameraFragment.isFaceAnalysis()) {
                    faceCameraFragment.setSideText(runFaceDetectStatus.statusString());
                }
            }

            @Override // com.huachenjie.base.bean.RunFaceDetectStatus.OnStatusChangeListener
            public void onStatusChange() {
                TextView textView = ((FaceCameraFragment) this.f32784a).sideTextView;
                if (textView != null) {
                    final FaceCameraFragment<V, VM> faceCameraFragment = this.f32784a;
                    final RunFaceDetectStatus runFaceDetectStatus = this.f6946a;
                    textView.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE 
                          (r0v1 'textView' android.widget.TextView)
                          (wrap java.lang.Runnable:0x000e: CONSTRUCTOR 
                          (r1v0 'faceCameraFragment' com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> A[DONT_INLINE])
                          (r2v0 'runFaceDetectStatus' com.huachenjie.base.bean.RunFaceDetectStatus A[DONT_INLINE])
                         A[MD:(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, com.huachenjie.base.bean.RunFaceDetectStatus):void (m), WRAPPED] call: com.zj.adlib.nd3.<init>(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, com.huachenjie.base.bean.RunFaceDetectStatus):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] in method: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$detectStatus$2.a.onStatusChange():void, file: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:286)
                        	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:557)
                        	at jadx.core.codegen.ClassGen.addField(ClassGen.java:463)
                        	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:430)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:283)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.zj.adlib.nd3, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 74 more
                        */
                    /*
                        this = this;
                        com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r0 = r4.f32784a
                        android.widget.TextView r0 = com.huachenjie.base.aliyun.detect_face.FaceCameraFragment.access$getSideTextView$p(r0)
                        if (r0 == 0) goto L14
                        com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r1 = r4.f32784a
                        com.huachenjie.base.bean.RunFaceDetectStatus r2 = r4.f6946a
                        com.zj.adlib.nd3 r3 = new com.zj.adlib.nd3
                        r3.<init>(r1, r2)
                        r0.post(r3)
                    L14:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$detectStatus$2.a.onStatusChange():void");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RunFaceDetectStatus m206invoke() {
                RunFaceDetectStatus runFaceDetectStatus = new RunFaceDetectStatus();
                runFaceDetectStatus.setStatusChangeListener(new a(this.this$0, runFaceDetectStatus));
                return runFaceDetectStatus;
            }
        });

        /* JADX INFO: renamed from: analyzerCallback$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy analyzerCallback = LazyKt.lazy(new Function0<FaceCameraFragment$analyzerCallback$2.a>(this) { // from class: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2
            final /* synthetic */ FaceCameraFragment<V, VM> this$0;

            @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/huachenjie/base/aliyun/detect_face/FaceCameraFragment$analyzerCallback$2$a", "Lcom/huachenjie/base/aliyun/detect_face/analyzer/AnalyzerCallback;", "", "tip", "", "d", "b", "c", "", "sim", "Lcom/zj/adlib/xa9;", "trackingInfo", "", "a", "base_release"}, k = 1, mv = {1, 8, 0})
            public static final class a implements AnalyzerCallback {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FaceCameraFragment<V, VM> f32783a;

                public a(FaceCameraFragment<V, VM> faceCameraFragment) {
                    this.f32783a = faceCameraFragment;
                }

                public static final void i(FaceCameraFragment faceCameraFragment, float f, TrackingInfo trackingInfo) {
                    Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                    Intrinsics.checkNotNullParameter(trackingInfo, "$trackingInfo");
                    faceCameraFragment.onAnalyzerSuccess(f, trackingInfo);
                }

                public static final void j(FaceCameraFragment faceCameraFragment) {
                    Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                    faceCameraFragment.onEndBodyDetection();
                }

                public static final void k(FaceCameraFragment faceCameraFragment, String str) {
                    Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                    Intrinsics.checkNotNullParameter(str, "$tip");
                    faceCameraFragment.onFaceQualityTip(str);
                }

                public static final void l(FaceCameraFragment faceCameraFragment) {
                    Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                    faceCameraFragment.onStartBodyDetection();
                }

                @Override // com.huachenjie.base.aliyun.detect_face.analyzer.AnalyzerCallback
                public boolean a(final float sim, @NotNull final TrackingInfo trackingInfo) {
                    Intrinsics.checkNotNullParameter(trackingInfo, "trackingInfo");
                    boolean z = sim > 0.0f && sim <= 100.0f && sim >= ((float) this.f32783a.getSimilarityValue());
                    if (z) {
                        this.f32783a.getDetectStatus().setSimilarityCheck(1);
                        FragmentActivity activity = this.f32783a.getActivity();
                        if (activity != null) {
                            final FaceCameraFragment<V, VM> faceCameraFragment = this.f32783a;
                            activity.runOnUiThread(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: INVOKE 
                                  (r1v2 'activity' androidx.fragment.app.FragmentActivity)
                                  (wrap java.lang.Runnable:0x0046: CONSTRUCTOR 
                                  (r2v2 'faceCameraFragment' com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> A[DONT_INLINE])
                                  (r5v0 'sim' float A[DONT_INLINE])
                                  (r6v0 'trackingInfo' com.zj.adlib.xa9 A[DONT_INLINE])
                                 A[MD:(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, float, com.zj.adlib.xa9):void (m), WRAPPED] call: com.zj.adlib.ld3.<init>(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, float, com.zj.adlib.xa9):void type: CONSTRUCTOR)
                                 VIRTUAL call: android.app.Activity.runOnUiThread(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.a(float, com.zj.adlib.xa9):boolean, file: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:286)
                                	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:557)
                                	at jadx.core.codegen.ClassGen.addField(ClassGen.java:463)
                                	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:430)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:283)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.zj.adlib.ld3, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 78 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "trackingInfo"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                                r0 = 0
                                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                                r1 = 1
                                if (r0 <= 0) goto L1e
                                r0 = 1120403456(0x42c80000, float:100.0)
                                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                                if (r0 > 0) goto L1e
                                com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r0 = r4.f32783a
                                int r0 = r0.getSimilarityValue()
                                float r0 = (float) r0
                                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                                if (r0 < 0) goto L1e
                                r0 = r1
                                goto L1f
                            L1e:
                                r0 = 0
                            L1f:
                                if (r0 != 0) goto L31
                                com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r5 = r4.f32783a
                                com.huachenjie.base.bean.RunFaceDetectStatus r5 = r5.getDetectStatus()
                                r6 = 2
                                r5.setSimilarityCheck(r6)
                                java.lang.String r5 = "校验失败，请重新尝试"
                                com.zj.adlib.fv5.b(r5)
                                goto L4c
                            L31:
                                com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r2 = r4.f32783a
                                com.huachenjie.base.bean.RunFaceDetectStatus r2 = r2.getDetectStatus()
                                r2.setSimilarityCheck(r1)
                                com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r1 = r4.f32783a
                                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                                if (r1 == 0) goto L4c
                                com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r2 = r4.f32783a
                                com.zj.adlib.ld3 r3 = new com.zj.adlib.ld3
                                r3.<init>(r2, r5, r6)
                                r1.runOnUiThread(r3)
                            L4c:
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.a(float, com.zj.adlib.xa9):boolean");
                        }

                        @Override // com.huachenjie.base.aliyun.detect_face.analyzer.AnalyzerCallback
                        public void b() {
                            FragmentActivity activity = this.f32783a.getActivity();
                            if (activity != null) {
                                final FaceCameraFragment<V, VM> faceCameraFragment = this.f32783a;
                                activity.runOnUiThread(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE 
                                      (r0v1 'activity' androidx.fragment.app.FragmentActivity)
                                      (wrap java.lang.Runnable:0x000c: CONSTRUCTOR (r1v0 'faceCameraFragment' com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> A[DONT_INLINE]) A[MD:(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment):void (m), WRAPPED] call: com.zj.adlib.md3.<init>(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment):void type: CONSTRUCTOR)
                                     VIRTUAL call: android.app.Activity.runOnUiThread(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.b():void, file: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:286)
                                    	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:557)
                                    	at jadx.core.codegen.ClassGen.addField(ClassGen.java:463)
                                    	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:430)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:283)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.zj.adlib.md3, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 74 more
                                    */
                                /*
                                    this = this;
                                    com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r0 = r3.f32783a
                                    androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                                    if (r0 == 0) goto L12
                                    com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r1 = r3.f32783a
                                    com.zj.adlib.md3 r2 = new com.zj.adlib.md3
                                    r2.<init>(r1)
                                    r0.runOnUiThread(r2)
                                L12:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.b():void");
                            }

                            @Override // com.huachenjie.base.aliyun.detect_face.analyzer.AnalyzerCallback
                            public void c() {
                                FragmentActivity activity = this.f32783a.getActivity();
                                if (activity != null) {
                                    final FaceCameraFragment<V, VM> faceCameraFragment = this.f32783a;
                                    activity.runOnUiThread(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE 
                                          (r0v1 'activity' androidx.fragment.app.FragmentActivity)
                                          (wrap java.lang.Runnable:0x000c: CONSTRUCTOR (r1v0 'faceCameraFragment' com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> A[DONT_INLINE]) A[MD:(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment):void (m), WRAPPED] call: com.zj.adlib.kd3.<init>(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment):void type: CONSTRUCTOR)
                                         VIRTUAL call: android.app.Activity.runOnUiThread(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.c():void, file: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:286)
                                        	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:557)
                                        	at jadx.core.codegen.ClassGen.addField(ClassGen.java:463)
                                        	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:430)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:283)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.zj.adlib.kd3, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 74 more
                                        */
                                    /*
                                        this = this;
                                        com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r0 = r3.f32783a
                                        androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                                        if (r0 == 0) goto L12
                                        com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r1 = r3.f32783a
                                        com.zj.adlib.kd3 r2 = new com.zj.adlib.kd3
                                        r2.<init>(r1)
                                        r0.runOnUiThread(r2)
                                    L12:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.c():void");
                                }

                                @Override // com.huachenjie.base.aliyun.detect_face.analyzer.AnalyzerCallback
                                public void d(@NotNull final String tip) {
                                    Intrinsics.checkNotNullParameter(tip, "tip");
                                    FragmentActivity activity = this.f32783a.getActivity();
                                    if (activity != null) {
                                        final FaceCameraFragment<V, VM> faceCameraFragment = this.f32783a;
                                        activity.runOnUiThread(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE 
                                              (r0v2 'activity' androidx.fragment.app.FragmentActivity)
                                              (wrap java.lang.Runnable:0x0011: CONSTRUCTOR 
                                              (r1v0 'faceCameraFragment' com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> A[DONT_INLINE])
                                              (r4v0 'tip' java.lang.String A[DONT_INLINE])
                                             A[MD:(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, java.lang.String):void (m), WRAPPED] call: com.zj.adlib.jd3.<init>(com.huachenjie.base.aliyun.detect_face.FaceCameraFragment, java.lang.String):void type: CONSTRUCTOR)
                                             VIRTUAL call: android.app.Activity.runOnUiThread(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.d(java.lang.String):void, file: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:286)
                                            	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:557)
                                            	at jadx.core.codegen.ClassGen.addField(ClassGen.java:463)
                                            	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:430)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:283)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.zj.adlib.jd3, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 74 more
                                            */
                                        /*
                                            this = this;
                                            java.lang.String r0 = "tip"
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                                            com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r0 = r3.f32783a
                                            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                                            if (r0 == 0) goto L17
                                            com.huachenjie.base.aliyun.detect_face.FaceCameraFragment<V, VM> r1 = r3.f32783a
                                            com.zj.adlib.jd3 r2 = new com.zj.adlib.jd3
                                            r2.<init>(r1, r4)
                                            r0.runOnUiThread(r2)
                                        L17:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.base.aliyun.detect_face.FaceCameraFragment$analyzerCallback$2.a.d(java.lang.String):void");
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.this$0 = this;
                                }

                                @NotNull
                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final a m205invoke() {
                                    return new a(this.this$0);
                                }
                            });

                            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/base/aliyun/detect_face/FaceCameraFragment$a", "Lcom/huachenjie/base/aliyun/detect_face/util/TakePhotoCallback;", "Landroid/graphics/Bitmap;", "bitmap", "", "a", "", SendToNativeCallback.KEY_MESSAGE, TriverEmbedVideoView.b, "base_release"}, k = 1, mv = {1, 8, 0})
                            public static final class a implements TakePhotoCallback {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                public final /* synthetic */ long f32782a;

                                /* JADX INFO: renamed from: a, reason: collision with other field name */
                                public final /* synthetic */ FaceCameraFragment<V, VM> f6945a;

                                public a(long j, FaceCameraFragment<V, VM> faceCameraFragment) {
                                    this.f32782a = j;
                                    this.f6945a = faceCameraFragment;
                                }

                                public static final void d(FaceCameraFragment faceCameraFragment, String str) {
                                    Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                                    Dialog mTakePictureLoading = faceCameraFragment.getMTakePictureLoading();
                                    if (mTakePictureLoading != null) {
                                        mTakePictureLoading.dismiss();
                                    }
                                    if (str == null) {
                                        str = "获取照片失败";
                                    }
                                    faceCameraFragment.onTakePictureError(str);
                                    faceCameraFragment.resumeCamera();
                                    faceCameraFragment.unlockCommit();
                                }

                                public static final void e(FaceCameraFragment faceCameraFragment, boolean z) {
                                    Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                                    Dialog mTakePictureLoading = faceCameraFragment.getMTakePictureLoading();
                                    if (mTakePictureLoading != null) {
                                        mTakePictureLoading.dismiss();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    faceCameraFragment.onTakePictureError("拍摄失败");
                                    faceCameraFragment.resumeCamera();
                                    faceCameraFragment.unlockCommit();
                                }

                                @Override // com.huachenjie.base.aliyun.detect_face.util.TakePhotoCallback
                                public void a(@NotNull Bitmap bitmap) {
                                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                                    i4a.a("拍照耗时：" + (System.currentTimeMillis() - this.f32782a) + "ms");
                                    final boolean zCompressPicture = this.f6945a.compressPicture(bitmap);
                                    FragmentActivity activity = this.f6945a.getActivity();
                                    if (activity != null) {
                                        final FaceCameraFragment<V, VM> faceCameraFragment = this.f6945a;
                                        activity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.pd3
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                FaceCameraFragment.a.e(faceCameraFragment, zCompressPicture);
                                            }
                                        });
                                    }
                                }

                                @Override // com.huachenjie.base.aliyun.detect_face.util.TakePhotoCallback
                                public void onError(@Nullable final String errorMessage) {
                                    FragmentActivity activity = this.f6945a.getActivity();
                                    if (activity != null) {
                                        final FaceCameraFragment<V, VM> faceCameraFragment = this.f6945a;
                                        activity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.od3
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                FaceCameraFragment.a.d(faceCameraFragment, errorMessage);
                                            }
                                        });
                                    }
                                }
                            }

                            private final TextView addSideTextView(FrameLayout layout) {
                                String strC = b.C();
                                Intrinsics.checkNotNullExpressionValue(strC, "getAppVersionName()");
                                int iMin = (int) Math.min(fx7.c(), fx7.e());
                                TextView textView = new TextView(getActivity());
                                textView.setTextSize(1, 10.0f);
                                textView.setTypeface(null, 1);
                                textView.setIncludeFontPadding(false);
                                textView.setGravity(81);
                                textView.setText(strC);
                                textView.setTextColor(Color.parseColor("#8997A4"));
                                textView.setRotation(90.0f);
                                textView.setIncludeFontPadding(false);
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin, iMin);
                                layoutParams.gravity = 17;
                                layout.addView(textView, layoutParams);
                                return textView;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void checkCameraPermission$lambda$0(FaceCameraFragment faceCameraFragment, boolean z) {
                                Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                                if (z) {
                                    faceCameraFragment.cameraInitSuccess.set(false);
                                    faceCameraFragment.startCamera();
                                } else {
                                    faceCameraFragment.cameraInitSuccess.set(false);
                                    faceCameraFragment.onPermissionDenied();
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public final boolean compressPicture(Bitmap bitmap) {
                                FragmentActivity activity;
                                final long jCurrentTimeMillis = System.currentTimeMillis();
                                final String str = en6.K() + File.separator + "face_" + System.currentTimeMillis() + FileTypes.F;
                                i4a.a("原图大小:(" + bitmap.getWidth() + ',' + bitmap.getHeight() + ')');
                                StringBuilder sb = new StringBuilder();
                                sb.append("图片是否需要压缩:");
                                sb.append(bitmap.getWidth() > this.faceTargetSize || bitmap.getHeight() > this.faceTargetSize);
                                i4a.a(sb.toString());
                                if (bitmap.getWidth() > this.faceTargetSize || bitmap.getHeight() > this.faceTargetSize) {
                                    int i = this.faceTargetSize;
                                    bitmap = ImageUtils.C(bitmap, i, i, true);
                                }
                                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                i4a.a("压缩耗时：" + jCurrentTimeMillis2 + "ms");
                                if (bitmap == null) {
                                    return false;
                                }
                                i4a.a("压缩原图大小:(" + bitmap.getWidth() + ',' + bitmap.getHeight() + ')');
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("压缩后图片新路径:");
                                sb2.append(str);
                                i4a.a(sb2.toString());
                                File file = new File(str);
                                if (file.exists()) {
                                    i4a.a("存在同名文件,已删除:" + file.delete());
                                }
                                boolean zB0 = ImageUtils.B0(bitmap, str, Bitmap.CompressFormat.JPEG, true);
                                i4a.a("save耗时：" + ((System.currentTimeMillis() - jCurrentTimeMillis) - jCurrentTimeMillis2) + "ms");
                                if (zB0 && (activity = getActivity()) != null) {
                                    activity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.hd3
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            FaceCameraFragment.compressPicture$lambda$5(jCurrentTimeMillis, this, str);
                                        }
                                    });
                                }
                                return zB0;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void compressPicture$lambda$5(long j, FaceCameraFragment faceCameraFragment, String str) {
                                Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                                Intrinsics.checkNotNullParameter(str, "$compressPath");
                                i4a.a("压缩耗时：" + (System.currentTimeMillis() - j) + "ms");
                                faceCameraFragment.lockCommit();
                                faceCameraFragment.onTakePicture(str);
                            }

                            private final FaceCameraFragment$analyzerCallback$2.a getAnalyzerCallback() {
                                return (FaceCameraFragment$analyzerCallback$2.a) this.analyzerCallback.getValue();
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public final Dialog getMTakePictureLoading() {
                                return (Dialog) this.mTakePictureLoading.getValue();
                            }

                            private final void lockCommit() {
                                this.canCommit.set(false);
                            }

                            private final void startCamera() {
                                final PreviewView previewView;
                                Context context = getContext();
                                if (context == null || (previewView = getPreviewView()) == null) {
                                    return;
                                }
                                previewView.setScaleType(PreviewView.ScaleType.FILL_CENTER);
                                final ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(context);
                                Intrinsics.checkNotNullExpressionValue(processCameraProvider, "getInstance(mContext)");
                                processCameraProvider.addListener(new Runnable() { // from class: com.zj.adlib.id3
                                    @Override // java.lang.Runnable
                                    public final void run() throws ExecutionException, InterruptedException {
                                        FaceCameraFragment.startCamera$lambda$4(processCameraProvider, previewView, this);
                                    }
                                }, ContextCompat.getMainExecutor(context));
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            /* JADX WARN: Multi-variable type inference failed */
                            public static final void startCamera$lambda$4(ListenableFuture listenableFuture, PreviewView previewView, FaceCameraFragment faceCameraFragment) throws ExecutionException, InterruptedException {
                                ImageAnalysis imageAnalysisBuild;
                                Intrinsics.checkNotNullParameter(listenableFuture, "$cameraProviderFuture");
                                Intrinsics.checkNotNullParameter(previewView, "$previewView");
                                Intrinsics.checkNotNullParameter(faceCameraFragment, "this$0");
                                V v = listenableFuture.get();
                                Intrinsics.checkNotNullExpressionValue(v, "cameraProviderFuture.get()");
                                ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) v;
                                Display display = previewView.getDisplay();
                                int rotation = display != null ? display.getRotation() : 0;
                                ResolutionSelector.Builder builder = new ResolutionSelector.Builder();
                                AspectRatioStrategy aspectRatioStrategy = AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY;
                                ResolutionSelector resolutionSelectorBuild = builder.setAspectRatioStrategy(aspectRatioStrategy).build();
                                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "Builder()\n              …\n                .build()");
                                Preview previewBuild = new Preview.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild).build();
                                previewBuild.setSurfaceProvider(previewView.getSurfaceProvider());
                                Intrinsics.checkNotNullExpressionValue(previewBuild, "Builder()\n              …ovider)\n                }");
                                ResolutionSelector.Builder aspectRatioStrategy2 = new ResolutionSelector.Builder().setAspectRatioStrategy(aspectRatioStrategy);
                                int i = faceCameraFragment.faceTargetSize;
                                ResolutionSelector resolutionSelectorBuild2 = aspectRatioStrategy2.setResolutionStrategy(new ResolutionStrategy(new Size(i, i), 1)).build();
                                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild2, "Builder()\n              …\n                .build()");
                                if (faceCameraFragment.isFaceAnalysis()) {
                                    imageAnalysisBuild = new ImageAnalysis.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild2).setBackpressureStrategy(0).build();
                                    faceCameraFragment.faceDetectAnalyzer = new FaceDetectAnalyzer(faceCameraFragment.getFaceImg(), faceCameraFragment.bodyEnable(), faceCameraFragment.getDetectStatus(), faceCameraFragment.getAnalyzerCallback());
                                    ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                                    FaceDetectAnalyzer faceDetectAnalyzer = faceCameraFragment.faceDetectAnalyzer;
                                    Intrinsics.checkNotNull(faceDetectAnalyzer);
                                    imageAnalysisBuild.setAnalyzer(executorServiceNewSingleThreadExecutor, faceDetectAnalyzer);
                                } else {
                                    faceCameraFragment.imageCapture = new ImageCapture.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild2).build();
                                    imageAnalysisBuild = null;
                                }
                                try {
                                    processCameraProvider.unbindAll();
                                    UseCaseGroup.Builder builderAddUseCase = new UseCaseGroup.Builder().addUseCase(previewBuild);
                                    ImageCapture imageCapture = faceCameraFragment.imageCapture;
                                    if (imageCapture != null) {
                                        Intrinsics.checkNotNull(imageCapture);
                                        builderAddUseCase.addUseCase(imageCapture);
                                    }
                                    if (imageAnalysisBuild != null) {
                                        builderAddUseCase.addUseCase(imageAnalysisBuild);
                                    }
                                    UseCaseGroup useCaseGroupBuild = builderAddUseCase.build();
                                    Intrinsics.checkNotNullExpressionValue(useCaseGroupBuild, "Builder()\n              …                 .build()");
                                    processCameraProvider.bindToLifecycle(faceCameraFragment.cameraLifecycle, CameraSelector.DEFAULT_FRONT_CAMERA, useCaseGroupBuild);
                                    faceCameraFragment.cameraInitSuccess.set(true);
                                    faceCameraFragment.getDetectStatus().setCameraStart(1);
                                } catch (Exception e) {
                                    i4a.a("Use case binding failed");
                                    faceCameraFragment.getDetectStatus().setCameraStart(2);
                                    String message = e.getMessage();
                                    if (message == null) {
                                        message = "相机绑定失败";
                                    }
                                    faceCameraFragment.onCameraError(message);
                                }
                            }

                            public boolean bodyEnable() {
                                return false;
                            }

                            public final void checkCameraPermission() {
                                vo6.l(this, Permission.CAMERA, "为了您能正常进行人脸认证，我们需要访问您终端设备的相机权限，拒绝会无法完成人脸认证，请允许开启。", new PermissionResultListener() { // from class: com.zj.adlib.gd3
                                    @Override // com.huachenjie.common.util.permission.PermissionResultListener
                                    public final void onResult(boolean z) {
                                        FaceCameraFragment.checkCameraPermission$lambda$0(this.f41877a, z);
                                    }
                                });
                            }

                            @Nullable
                            public final Pair<FaceResult, TrackingInfo> getBestFaceData() {
                                FaceDetectAnalyzer faceDetectAnalyzer = this.faceDetectAnalyzer;
                                if (faceDetectAnalyzer != null) {
                                    return faceDetectAnalyzer.e();
                                }
                                return null;
                            }

                            public final float getBestSimilarity() {
                                FaceDetectAnalyzer faceDetectAnalyzer = this.faceDetectAnalyzer;
                                if (faceDetectAnalyzer != null) {
                                    return faceDetectAnalyzer.getBestSimilarity();
                                }
                                return 0.0f;
                            }

                            @NotNull
                            public final RunFaceDetectStatus getDetectStatus() {
                                return (RunFaceDetectStatus) this.detectStatus.getValue();
                            }

                            @Nullable
                            public String getFaceImg() {
                                return null;
                            }

                            public final int getFaceTargetSize() {
                                return this.faceTargetSize;
                            }

                            @Nullable
                            public final Dialog getLoadingDialog() {
                                return this.loadingDialog;
                            }

                            @NotNull
                            public abstract String getLoadingTip();

                            @Nullable
                            public abstract PreviewView getPreviewView();

                            public int getSimilarityValue() {
                                return 45;
                            }

                            @NotNull
                            public abstract UploadFileType getUploadFileType();

                            public boolean isFaceAnalysis() {
                                return false;
                            }

                            public void onAnalyzerSuccess(float sim, @NotNull TrackingInfo trackingInfo) {
                                Intrinsics.checkNotNullParameter(trackingInfo, "trackingInfo");
                            }

                            public abstract void onCameraError(@NotNull String message);

                            public abstract void onClickBack();

                            @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
                            public void onCreate(@Nullable Bundle savedInstanceState) {
                                super.onCreate(savedInstanceState);
                                CameraXLifecycle cameraXLifecycle = this.cameraLifecycle;
                                Lifecycle lifecycle = getLifecycle();
                                Intrinsics.checkNotNullExpressionValue(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
                                cameraXLifecycle.a(lifecycle);
                                this.cameraInitSuccess.set(false);
                            }

                            @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
                            @Nullable
                            public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                                Intrinsics.checkNotNullParameter(inflater, "inflater");
                                View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
                                if (viewOnCreateView == null) {
                                    return null;
                                }
                                if (viewOnCreateView instanceof FrameLayout) {
                                    this.sideTextView = addSideTextView((FrameLayout) viewOnCreateView);
                                    return viewOnCreateView;
                                }
                                FrameLayout frameLayout = new FrameLayout(viewOnCreateView.getContext());
                                frameLayout.addView(viewOnCreateView);
                                this.sideTextView = addSideTextView(frameLayout);
                                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                return frameLayout;
                            }

                            @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
                            public void onDestroyView() {
                                FaceDetectAnalyzer faceDetectAnalyzer = this.faceDetectAnalyzer;
                                if (faceDetectAnalyzer != null) {
                                    faceDetectAnalyzer.d();
                                }
                                Dialog mTakePictureLoading = getMTakePictureLoading();
                                if (mTakePictureLoading != null) {
                                    mTakePictureLoading.dismiss();
                                }
                                Dialog dialog = this.loadingDialog;
                                if (dialog != null) {
                                    dialog.dismiss();
                                }
                                super.onDestroyView();
                            }

                            public void onEndBodyDetection() {
                            }

                            public void onFaceQualityTip(@NotNull String tip) {
                                Intrinsics.checkNotNullParameter(tip, "tip");
                            }

                            public abstract void onPermissionDenied();

                            public void onStartBodyDetection() {
                            }

                            public void onTakePicture(@NotNull String filePath) {
                                Intrinsics.checkNotNullParameter(filePath, "filePath");
                            }

                            public void onTakePictureError(@NotNull String message) {
                                Intrinsics.checkNotNullParameter(message, "message");
                            }

                            public final void reAnalyzer() {
                                FaceDetectAnalyzer faceDetectAnalyzer;
                                if (!isFaceAnalysis() || (faceDetectAnalyzer = this.faceDetectAnalyzer) == null) {
                                    return;
                                }
                                faceDetectAnalyzer.m();
                            }

                            public final void resumeCamera() {
                                this.cameraLifecycle.i();
                            }

                            public final void setLoadingDialog(@Nullable Dialog dialog) {
                                this.loadingDialog = dialog;
                            }

                            @SuppressLint({"SetTextI18n"})
                            public final void setSideText(@NotNull String textCode) {
                                Intrinsics.checkNotNullParameter(textCode, "textCode");
                                TextView textView = this.sideTextView;
                                if (textView != null) {
                                    textView.setText(b.C() + '-' + textCode);
                                }
                            }

                            public final void takePhoto(@NotNull Context context) {
                                ImageCapture imageCapture;
                                Intrinsics.checkNotNullParameter(context, "context");
                                if (this.cameraInitSuccess.get() && this.canCommit.get() && (imageCapture = this.imageCapture) != null) {
                                    lockCommit();
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    this.cameraLifecycle.k();
                                    Dialog mTakePictureLoading = getMTakePictureLoading();
                                    if (mTakePictureLoading != null) {
                                        mTakePictureLoading.show();
                                    }
                                    dd1.l(imageCapture, context, new a(jCurrentTimeMillis, this));
                                }
                            }

                            public final void unlockCommit() {
                                this.canCommit.set(true);
                                i4a.a("unlockCommit");
                            }
                        }
